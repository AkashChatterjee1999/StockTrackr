package com.stocktrackr.api.v100.provider.realtimeServices.messaging;

import com.stocktrackr.api.v100.client.StockPriceResponse;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaMessageProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    public enum Topics { REGULAR_STOCK, CRYPTO, FOREX };
    public static final Map<Topics, String> topicNameMappings;

    static {
        topicNameMappings = Map.of(
                Topics.REGULAR_STOCK, "REGULAR",
                Topics.CRYPTO, "CRYPTO",
                Topics.FOREX, "FOREX"
        );
    }

    private KafkaMessageProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Topics topic, String key, StockPriceResponse message) {
        this.kafkaTemplate.send(topicNameMappings.get(topic), key, message.toString());
    }

    public static KafkaMessageProducer getInstance() {

        Map<String, Object> producerProps = new HashMap<>();
        producerProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        producerProps.put(ProducerConfig.LINGER_MS_CONFIG, 10);
        producerProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        producerProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        KafkaTemplate<String, String> template = new KafkaTemplate<>(new DefaultKafkaProducerFactory<>(producerProps));
        return new KafkaMessageProducer(template);
    }

}