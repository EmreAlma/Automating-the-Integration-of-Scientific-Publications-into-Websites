package com.example.pubsync.controller;

import com.example.pubsync.model.Response;
import com.example.pubsync.service.AuthorApiService;
import com.example.pubsync.service.AuthorPublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    AuthorPublicationService authorPublicationService;
    AuthorApiService authorApiService;

    @GetMapping("/page")
    public Response getAuthorsPage(@RequestParam(value = "name", required = false) String param){
        return authorApiService.getAuthorsPage(param);
    }
    @GetMapping("/publications")
    public void fetchPublicationsForAuthors() {
        authorPublicationService.fetchAndSavePublicationsForAuthors();
    }

}