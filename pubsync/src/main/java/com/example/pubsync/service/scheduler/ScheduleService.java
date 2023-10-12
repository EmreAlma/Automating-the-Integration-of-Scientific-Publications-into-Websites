package com.example.pubsync.service.scheduler;

import com.example.pubsync.service.AuthorPublicationService;
import com.example.pubsync.service.FileService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;

@Component
public class ScheduleService {

    private final AuthorPublicationService authorPublicationService;
    private final FileService fileService;

    public ScheduleService(AuthorPublicationService authorPublicationService, FileService fileService) {
        this.authorPublicationService = authorPublicationService;
        this.fileService = fileService;
    }

    @Scheduled(initialDelay = 1000, fixedRate = 7 * 24 * 60 * 60 * 1000)
    public void doTask() throws FileNotFoundException {
        fileService.createMarkdownFile();
        try {
            System.out.println("doTask is starting");
            authorPublicationService.fetchAndSavePublicationsForAuthors();
            System.out.println("doTask works..");
        } catch (Exception e) {
            System.out.println("doTask failed");
        }
    }
}
