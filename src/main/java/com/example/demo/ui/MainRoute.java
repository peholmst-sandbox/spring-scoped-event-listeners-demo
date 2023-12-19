package com.example.demo.ui;

import com.example.demo.event.MyExampleEvent;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;

import java.time.Instant;

@Route("")
public class MainRoute extends VerticalLayout {

    public MainRoute(ApplicationEventPublisher eventPublisher) {
        add(new Button("Fire Event", event -> {
            eventPublisher.publishEvent(new MyExampleEvent("Example event fired from request thread", Instant.now()));
        }));
        add(new Button("Fire Event from Background Thread", event -> {
            // Don't start threads like this in production code
            var ui = UI.getCurrent();
            new Thread(() -> {
                try {
                    Thread.sleep(1000);
                    ui.access(() -> {
                        eventPublisher.publishEvent(new MyExampleEvent("Example event fired from a background thread", Instant.now()));
                    });
                } catch (InterruptedException ex) {
                    LoggerFactory.getLogger(MainRoute.class).error("Thread interrupted", ex);
                }
            }).start();
        }));
    }
}
