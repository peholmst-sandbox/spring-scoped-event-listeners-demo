package com.example.demo.handler;

import com.example.demo.event.MyExampleEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class SingletonScopeEventHandler {

    private static final Logger log = LoggerFactory.getLogger(SingletonScopeEventHandler.class);

    @EventListener
    public void onMyExampleEvent(MyExampleEvent event) {
        log.info("{} Received event {}", this, event);
    }
}
