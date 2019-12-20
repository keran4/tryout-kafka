package com.test.main;

import com.test.messages.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Main implements CommandLineRunner {

    @Autowired
    private Producer publisher;

    @Override
    public void run(String... args) throws Exception {
        publisher.sendMessage("This is a test message!");
    }
}
