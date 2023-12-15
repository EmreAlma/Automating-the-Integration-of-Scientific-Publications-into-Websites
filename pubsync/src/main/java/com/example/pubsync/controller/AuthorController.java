package com.example.pubsync.controller;

import com.example.pubsync.entity.Author;
import com.example.pubsync.repository.AuthorRepository;
import com.example.pubsync.service.AuthorPublicationService;
import com.example.pubsync.service.FileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.UUID;

/**
 * Controller for handling web requests related to author management.
 * Maps to the '/ui' path and provides functionalities such as viewing, adding,
 * deleting, and updating authors, as well as fetching and saving publication data.
 */
@Controller
@RequestMapping("/ui")
public class AuthorController {
    private final AuthorRepository authorRepository;
    private final AuthorPublicationService authorPublicationService;
    private final FileService fileService;

    public AuthorController(AuthorRepository authorRepository, AuthorPublicationService authorPublicationService, FileService fileService) {
        this.authorRepository = authorRepository;
        this.authorPublicationService = authorPublicationService;
        this.fileService = fileService;
    }

    /**
     * Displays the list of authors.
     * @param model The model object to pass data to the view.
     * @return The view name to render.
     */
    @GetMapping("/authors")
    public String getAuthor(Model model) {
        List<Author> authors = authorRepository.findAll();
        model.addAttribute("authors", authors);
        return "index";
    }

    /**
     * Deletes an author based on their ID.
     * @param id The UUID of the author to be deleted.
     * @return Redirects to the authors list view.
     */
    @GetMapping("/deleteAuthor/{id}")
    public String deleteAuthor(@PathVariable UUID id) {
        authorRepository.deleteById(id);
        return "redirect:/ui/authors";
    }

    /**
     * Adds a new author.
     * @param author The author object to be added.
     * @return Redirects to the authors list view.
     */
    @PostMapping("/addAuthor")
    public String addAuthor(@ModelAttribute Author author) {
        author.setActive(true);
        authorRepository.save(author);
        return  "redirect:/ui/authors";
    }

    /**
     * Fetches and saves publication data for all authors.
     * @return Redirects to the authors list view.
     */
    @GetMapping("/fetchAndSave")
    public String fetchAndSave() {
        authorPublicationService.fetchAndSavePublicationsForAuthors();
        return "redirect:/ui/authors";
    }

    /**
     * Generates a Markdown file containing the list of authors and their publications.
     * @param filePath The path of the file to be generated.
     * @return Redirects to the authors list view.
     */
    @PostMapping("/generateMarkdown")
    public String generateMarkdown(@RequestParam(value = "filePath", required = false) String filePath) {

        if (filePath == null || filePath.isEmpty()) {
            filePath = "pubsync/src/main/resources/_index.md";
        }
        try {
            fileService.createMarkdownFile(filePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/ui/authors";
    }

    /**
     * Displays the form for updating an author.
     * @param id The UUID of the author to be updated.
     * @param model The model object to pass data to the view.
     * @return The view name to render.
     */
    @GetMapping("/updateAuthor/{id}")
    public String showUpdateAuthorForm(@PathVariable UUID id, Model model) {
        Author author = authorRepository.findById(id).orElseThrow();
        model.addAttribute("author", author);
        return "update-author";
    }

    /**
     * Updates an author.
     * @param author The author object to be updated.
     * @return Redirects to the authors list view.
     */
    @PostMapping("/updateAuthor")
    public String updateAuthor(@ModelAttribute Author author) {
        authorRepository.save(author);
        return "redirect:/ui/authors";
    }
}
