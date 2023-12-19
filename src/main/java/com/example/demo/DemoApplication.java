package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.support.ScopeNotActiveException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.scheduling.support.TaskUtils;

@SpringBootApplication
public class DemoApplication {

	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	@Bean
	public ApplicationEventMulticaster applicationEventMulticaster() {
		var multicaster = new SimpleApplicationEventMulticaster();
		multicaster.setErrorHandler(error -> {
			if (error instanceof ScopeNotActiveException) {
				log.debug("Event handler was not active, ignoring");
			} else {
				log.error("Unexpected error from event handler", error);
			}
		});
		return multicaster;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
