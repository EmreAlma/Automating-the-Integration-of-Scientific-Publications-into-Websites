package com.example.pubsync.controller;

import com.example.pubsync.entity.Publication;
import com.example.pubsync.repository.PublicationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@SessionAttributes("publication")
public class PublicationViewController {

    private final PublicationRepository publicationRepository;

    public PublicationViewController(PublicationRepository publicationRepository) {
        this.publicationRepository = publicationRepository;
    }

    @GetMapping("/all")
    public String getAllPublications(Model model) {
       List<Publication> publication = publicationRepository.findAll();
        List<Integer> publicationYears = publicationRepository.findDistinctPublicationYears();
        model.addAttribute("publicationYears", publicationYears);
        model.addAttribute("publication", publication);
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
    public String updatePublication(@ModelAttribute("publication") Publication publication, BindingResult result) {
        if (result.hasErrors()) {
            return "update-publication";
        }
        publicationRepository.save(publication);
        return "redirect:/all";
    }

}