package com.stocktrackr.api.v100.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class StockTrackrBackendApplication {

	// the main method the application
	public static void main(String[] args) {
		SpringApplication.run(StockTrackrBackendApplication.class, args);
	}

}
