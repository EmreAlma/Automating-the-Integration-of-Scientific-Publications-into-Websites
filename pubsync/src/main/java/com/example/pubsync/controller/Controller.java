package com.example.pubsync.controller;

import com.example.pubsync.service.FirstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    FirstService firstService;

    @GetMapping("/testData")
    public String getTestData(@RequestParam(value = "format", required = false) String param){
        return firstService.getTestData(param);
    }
    @GetMapping("/author")
    public String getAuthor(@RequestParam(value = "author", required = false) String param){
        return firstService.getAuthor(param);
    }
}