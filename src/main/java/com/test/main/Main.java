package com.test.main;

import com.test.messages.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Main implements CommandLineRunner {

    @Autowired
    private Producer publisher;

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    @Override
    public void run(String... args) throws Exception {

        int counter = 0;
        while (true) {
            counter ++;
            logger.info("");
            publisher.sendMessage("This is a test message, count: " + counter);

            Thread.sleep(1000);
        }
    }
}
