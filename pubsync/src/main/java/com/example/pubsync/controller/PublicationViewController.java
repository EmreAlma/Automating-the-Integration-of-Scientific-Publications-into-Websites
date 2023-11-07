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

       model.addAttribute("publicationView", publicationViewList);
        return "publications";
    }
    @PostMapping("/addPdfLink/{id}")
    public String addPdfLink(@PathVariable("id") UUID id,
                             @RequestParam("pdfLink") String pdfLink) {
        Publication publication = publicationRepository.findById(id).orElseThrow();
        publication.setPdfLink(pdfLink);
        publicationRepository.save(publication);
        return "redirect:/all";
    }
    @PostMapping("/export/{id}")
    public String export(@PathVariable("id") UUID id, @RequestParam(value = "isExportable", defaultValue = "false") Boolean isExportable) {
        Publication publication = publicationRepository.findById(id).orElseThrow();
        publication.setIsExportable(isExportable);
        publicationRepository.save(publication);
        return "redirect:/all";
    }
}
