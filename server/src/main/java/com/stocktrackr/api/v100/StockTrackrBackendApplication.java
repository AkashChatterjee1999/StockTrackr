package com.stocktrackr.api.v100;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@SpringBootApplication
@EnableScheduling
public class StockTrackrBackendApplication {

	// the main method the application
	public static void main(String[] args) {
		SpringApplication.run(StockTrackrBackendApplication.class, args);
	}

}
