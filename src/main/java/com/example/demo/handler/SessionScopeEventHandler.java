package com.example.demo.handler;

import com.example.demo.event.MyExampleEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.context.request.RequestContextHolder;

@Service
@SessionScope
public class SessionScopeEventHandler {

    private static final Logger log = LoggerFactory.getLogger(SessionScopeEventHandler.class);

    @EventListener
    public void onMyExampleEvent(MyExampleEvent event) {
        var sessionId = RequestContextHolder.currentRequestAttributes().getSessionId();
        log.info("{} Received event {} (session ID: {})", this, event, sessionId);
    }
}
