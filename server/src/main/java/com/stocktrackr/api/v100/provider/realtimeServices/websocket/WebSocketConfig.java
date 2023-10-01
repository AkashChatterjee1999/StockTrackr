package com.stocktrackr.api.v100.provider.realtimeServices.websocket;


import com.stocktrackr.api.v100.provider.realtimeServices.websocket.controllers.InsightControllers;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import com.stocktrackr.api.v100.provider.realtimeServices.websocket.*;

import java.lang.reflect.Method;
import java.util.*;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        try {
            List<Class<?>> socketHandlerClasses = new ArrayList<>();
            socketHandlerClasses.add(InsightControllers.class);

            for(Class<?> classType : socketHandlerClasses) {
                for(Method method: classType.getDeclaredMethods()) {
                    if(method.isAnnotationPresent(SocketMapping.class)) {
                        SocketMapping socketMap = method.getAnnotation(SocketMapping.class);
                        registry.addHandler(new StockTrackrSocketHandler(socketHandlerClasses), socketMap.path())
                                .setAllowedOriginPatterns("*");
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Some issue has occurred while attaching socket mapping");
            e.printStackTrace();
        }

    }

//    @Bean // This method not used
//    public Map<String, WebSocketHandler> getWebSocketHandlers() throws InvalidSocketConfigException, InvocationTargetException, IllegalAccessException {
//        Map <String, WebSocketHandler> mp = new HashMap<>();
//        for(Method method: InsightControllers.class.getDeclaredMethods()) {
//            if(method.isAnnotationPresent(SocketMapping.class)) {
//                List<Class<?>> implementedInterfaces = Arrays.asList(method.getReturnType().getInterfaces());
//                SocketMapping socketMap = method.getAnnotation(SocketMapping.class);
//                if(socketMap.path().equals("") || !implementedInterfaces.contains(WebSocketHandler.class))
//                    throw new InvalidSocketConfigException();
//                mp.put(socketMap.path(), (WebSocketHandler) method.invoke(null));
//            }
//        }
//        return mp;
//    }
}
