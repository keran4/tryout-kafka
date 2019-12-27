package com.test.messages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    private static final Logger logger = LoggerFactory.getLogger("Consumer");

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "${kafka.group.id.1}")
    public void listen(String message) {
        logger.info("^^^^^^^ Received Message from Listener: {}", message);
    }

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "${kafka.group.id.2}")
    public void listenWithHeaders1(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        logger.info("******* Received Message from Listener(1): {} from partition: {}", message, partition);
    }

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "${kafka.group.id.2}")
    public void listenWithHeaders2(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        logger.info("******* Received Message from Listener(2): {} from partition: {}", message, partition);
    }

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "${kafka.group.id.2}")
    public void listenWithHeaders3(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        logger.info("******* Received Message from Listener(3): {} from partition: {}", message, partition);
    }

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "${kafka.group.id.2}")
    public void listenWithHeaders4(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        logger.info("******* Received Message from Listener(4): {} from partition: {}", message, partition);
    }
}
