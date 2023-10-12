package com.example.pubsync.controller;

import com.example.pubsync.model.PublicationView;
import com.example.pubsync.repository.PublicationRepository;
import com.example.pubsync.service.ConverterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Controller
public class PublicationViewController {

    private final ConverterService converterService;

    private final PublicationRepository publicationRepository;

    public PublicationViewController(ConverterService converterService, PublicationRepository publicationRepository) {
        this.converterService = converterService;
        this.publicationRepository = publicationRepository;
    }

    @GetMapping("/all")
    public String getAllPublications(Model model) {
       List<PublicationView> publicationViewList = converterService.convertPublicationViewList(publicationRepository.findAll());

       model.addAttribute("publicationView", publicationViewList);
        return "publications";
    }
}
