package com.example.demo.handler;


import com.example.demo.event.MyExampleEvent;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.spring.annotation.VaadinSessionScope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@VaadinSessionScope
public class VaadinSessionScopeEventHandler {

    private static final Logger log = LoggerFactory.getLogger(VaadinSessionScopeEventHandler.class);

    @EventListener
    public void onMyExampleEvent(MyExampleEvent event) {
        var sessionId = VaadinSession.getCurrent().getSession().getId();
        log.info("{} Received event {} (session ID: {})", this, event, sessionId);
    }
}
