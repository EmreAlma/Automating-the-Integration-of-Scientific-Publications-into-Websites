package com.example.pubsync.controller;

import com.example.pubsync.entity.Publication;
import com.example.pubsync.repository.PublicationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

/**
 * Controller for handling web requests related to publication management.
 * Provides functionality for viewing, updating, and exporting publication data.
 */
@Controller
@SessionAttributes("publication")
public class PublicationViewController {

    private final PublicationRepository publicationRepository;

    public PublicationViewController(PublicationRepository publicationRepository) {
        this.publicationRepository = publicationRepository;
    }

    /**
     * Retrieves and displays all publications, marking those added within the last 30 minutes as new.
     * @param model The model object to pass data to the view.
     * @return The name of the view to render.
     */
    @GetMapping("/all")
    public String getAllPublications(Model model) {
       List<Publication> publication = publicationRepository.findAll();
        List<Integer> publicationYears = publicationRepository.findDistinctPublicationYears();
        Instant thirtyMinutesAgo = Instant.now().minus(30, ChronoUnit.MINUTES);
        model.addAttribute("thirtyMinutesAgo", thirtyMinutesAgo);
        model.addAttribute("publicationYears", publicationYears);
        model.addAttribute("publication", publication);
        return "publications";
    }

    /**
     * Updates the exportable status of a publication.
     * @param id The UUID of the publication to be updated.
     * @param isExportable The new exportable status of the publication.
     * @return Redirects to the publication list view.
     */
    @PostMapping("/export/{id}")
    public String export(@PathVariable("id") UUID id, @RequestParam(value = "isExportable", defaultValue = "false") Boolean isExportable) {
        Publication publication = publicationRepository.findById(id).orElseThrow();
        publication.setExportable(isExportable);
        publicationRepository.save(publication);
        return "redirect:/all";
    }

    /**
     * Displays the form for updating a publication.
     * @param id The UUID of the publication to be updated.
     * @param model The model object to pass data to the view.
     * @return The name of the update view to render.
     */
    @GetMapping("/updatePublication/{id}")
    public String showUpdatePublicationForm(@PathVariable("id") UUID id, Model model) {
        Publication publication = publicationRepository.findById(id).orElseThrow();
        model.addAttribute("publication", publication);
        return "update-publication";
    }

    /**
     * Processes the submitted form for updating a publication.
     * @param publication The publication object with updated data.
     * @param result Contains any binding errors.
     * @return Redirects to the publication list view or returns to the update form if errors are present.
     */
    @PostMapping("/updatePublication")
    public String updatePublication(@ModelAttribute("publication") Publication publication, BindingResult result) {
        if (result.hasErrors()) {
            return "update-publication";
        }
        publicationRepository.save(publication);
        return "redirect:/all";
    }

}