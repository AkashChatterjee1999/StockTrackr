package com.stocktrackr.api.v100.provider;

import com.stocktrackr.api.v100.client.StockPriceFetcher;
import com.stocktrackr.api.v100.provider.realtimeServices.messaging.KafkaMessageProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableScheduling
public class StockTrackrBackendApplication {

	// the main method the application
	public static void main(String[] args) {
		SpringApplication.run(StockTrackrBackendApplication.class, args);

		List<String> stockSymbols = new ArrayList<>();
		stockSymbols.add("MSFT:NASDAQ");
		stockSymbols.add("AMZN:NASDAQ");
		stockSymbols.add("GOOGL:NASDAQ");

		int i = 0, blockSize = 3;
		while(i < stockSymbols.size()) {
			List<StockPriceFetcher> microFetchers = new ArrayList<>();
			for(int b = 0; b < blockSize; b++) {
				if(i + b >= stockSymbols.size()) break;
				microFetchers.add(new StockPriceFetcher(stockSymbols.get(i + b), KafkaMessageProducer.Topics.REGULAR_STOCK));
			}
			Thread.startVirtualThread(() -> {
				while(true) microFetchers.forEach(StockPriceFetcher::run);
			});
			i += blockSize;
		}

	}

}
