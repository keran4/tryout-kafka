package com.test.messages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class Producer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.topic.name}")
    private String topicName;

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);

    public void sendMessage(String message) {

        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topicName, message);

        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

            @Override
            public void onSuccess(SendResult<String, String> result) {
                logger.info("======> Sent message=[{}] with offset=[{}]", message, result.getRecordMetadata().offset());
            }
            @Override
            public void onFailure(Throwable ex) {
                logger.error("======> Unable to send message=[{}] due to : ", message, ex.getMessage());
            }
        });
    }

}
