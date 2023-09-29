package com.example.pubsync.service.scheduler;

import com.example.pubsync.service.AuthorPublicationService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleService {

    private final AuthorPublicationService authorPublicationService;

    public ScheduleService(AuthorPublicationService authorPublicationService) {
        this.authorPublicationService = authorPublicationService;
    }

    @Scheduled(initialDelay = 2000, fixedRate = 3000000)
    public void doTask() {

        try {
            System.out.println("doTask is starting");
            authorPublicationService.fetchAndSavePublicationsForAuthors();
            System.out.println("doTask works..");
        } catch (Exception e) {
            System.out.println("doTask failed");
        }
    }
}
