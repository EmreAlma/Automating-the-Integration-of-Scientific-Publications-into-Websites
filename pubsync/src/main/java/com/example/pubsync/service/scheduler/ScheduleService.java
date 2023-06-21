package com.example.pubsync.service.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleService {

    @Scheduled(initialDelay = 2000, fixedRate = 3000)
    public void doTask() {
        System.out.println("It works");
    }
}
