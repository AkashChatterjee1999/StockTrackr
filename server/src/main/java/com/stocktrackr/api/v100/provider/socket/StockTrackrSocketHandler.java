package com.stocktrackr.api.v100.provider.socket;

import com.stocktrackr.api.v100.provider.utils.Pair;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import java.lang.reflect.Method;
import java.util.*;

public class StockTrackrSocketHandler implements WebSocketHandler {

    private final List<Class<?>> classesUsingSockets;
    public static int connectedClients = 0;
    public static Map<String, List<WebSocketSession>> socketMappings = new HashMap<>();

    public StockTrackrSocketHandler(List<Class<?>> classesUsingSockets) {
        this.classesUsingSockets = classesUsingSockets;
    }

    private Pair<Method, Class<?>> findHandlerToInvoke(WebSocketSession session) {
        String requestPath = Objects.requireNonNull(session.getUri()).getPath();
        for(Class<?> classType : this.classesUsingSockets) {
            for(Method method: classType.getDeclaredMethods()) {
                if(method.isAnnotationPresent(SocketMapping.class)) {
                    SocketMapping socketMap = method.getAnnotation(SocketMapping.class);
                    if(socketMap.path().equals(requestPath)) return new Pair<>(method, classType);
                }
            }
        }
        return null;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        connectedClients ++;
        String requestPath = Objects.requireNonNull(session.getUri()).getPath();
        if(!socketMappings.containsKey(requestPath)) socketMappings.put(requestPath, new ArrayList<>());
        socketMappings.get(requestPath).add(session);
        System.out.println("++ Clients connected: " + connectedClients);
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        String requestPath = Objects.requireNonNull(session.getUri()).getPath();
        Pair<Method, Class<?>> methodClassPair = this.findHandlerToInvoke(session);
        if(methodClassPair != null) {
            try {
                methodClassPair.getFirstValue().invoke(
                    methodClassPair.getSecondValue().getDeclaredConstructor().newInstance(),
                    requestPath != null? requestPath : "", message
                );
            } catch (Exception e) {
                System.out.println("Error occurred in executing method: " + methodClassPair.getFirstValue().getName());
                e.printStackTrace();
            }
        } else System.out.println("Cannot find a method to execute for: " + requestPath);
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception { exception.printStackTrace(); }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        connectedClients --;
        String requestPath = Objects.requireNonNull(session.getUri()).getPath();
        if(socketMappings.containsKey(requestPath))
            socketMappings.get(requestPath).remove(session);
        System.out.println("-- Clients connected: " + connectedClients);
    }

    @Override
    public boolean supportsPartialMessages() { return false; }
}
