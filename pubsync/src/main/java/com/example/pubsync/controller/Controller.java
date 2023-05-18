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

    @GetMapping("/author")
    public String getAuthor(@RequestParam(value = "param", required = false) String param){
        return firstService.getAuthor(param);
    }
}
