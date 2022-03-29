package com.example.curs13springboot;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Component
public class TimeZoneService {

    public LocalDateTime getTimeByZone(String timeZone) {
        return LocalDateTime.now(ZoneId.of(timeZone));
    }

}
