package com.example.pubsync.controller;

import com.example.pubsync.entity.Publication;
import com.example.pubsync.model.PublicationView;
import com.example.pubsync.repository.PublicationRepository;
import com.example.pubsync.service.ConverterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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
        List<Integer> publicationYears = publicationRepository.findDistinctPublicationYears();
        model.addAttribute("publicationYears", publicationYears);
        model.addAttribute("publicationView", publicationViewList);
        return "publications";
    }
    @PostMapping("/export/{id}")
    public String export(@PathVariable("id") UUID id, @RequestParam(value = "isExportable", defaultValue = "false") Boolean isExportable) {
        Publication publication = publicationRepository.findById(id).orElseThrow();
        publication.setExportable(isExportable);
        publicationRepository.save(publication);
        return "redirect:/all";
    }
    @GetMapping("/updatePublication/{id}")
    public String showUpdatePublicationForm(@PathVariable("id") UUID id, Model model) {
        Publication publication = publicationRepository.findById(id).orElseThrow();
        model.addAttribute("publication", publication);
        return "update-publication";
    }
    @PostMapping("/updatePublication")
    public String updatePublication(@ModelAttribute Publication publication) {
        publication.setAccess(publicationRepository.findById(publication.getId()).orElseThrow().getAccess());
        publication.setAddDate(publicationRepository.findById(publication.getId()).orElseThrow().getAddDate());
        publication.setDoiNumber(publicationRepository.findById(publication.getId()).orElseThrow().getDoiNumber());
        publication.setKey(publicationRepository.findById(publication.getId()).orElseThrow().getKey());
        publication.setPageURL(publicationRepository.findById(publication.getId()).orElseThrow().getPageURL());
        publication.setPages(publicationRepository.findById(publication.getId()).orElseThrow().getPages());
        publication.setPublishLink(publicationRepository.findById(publication.getId()).orElseThrow().getPublishLink());
        publication.setType(publicationRepository.findById(publication.getId()).orElseThrow().getType());
        publicationRepository.save(publication);
        return "redirect:/all";
    }
}