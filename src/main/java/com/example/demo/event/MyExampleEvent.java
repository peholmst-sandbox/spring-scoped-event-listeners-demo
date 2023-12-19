package com.example.demo.event;

import java.time.Instant;

public record MyExampleEvent(String payload, Instant timestamp) {
}
