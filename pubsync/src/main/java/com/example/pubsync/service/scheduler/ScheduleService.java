package com.example.pubsync.service.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleService {

    @Scheduled(initialDelay = 200000, fixedRate = 30000)
    public void doTask() {
        System.out.println("It works");
    }
}
