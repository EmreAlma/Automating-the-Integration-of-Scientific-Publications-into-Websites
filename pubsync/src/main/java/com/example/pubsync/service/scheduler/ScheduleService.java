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

    @Scheduled(cron = "@weekly")
    public void doTask() {

        try {
            authorPublicationService.fetchAndSavePublicationsForAuthors();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
