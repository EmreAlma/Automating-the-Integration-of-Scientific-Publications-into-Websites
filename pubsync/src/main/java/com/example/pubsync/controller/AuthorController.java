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

    @GetMapping("/authors")
    public String getAuthor(Model model) {
        List<Author> authors = authorRepository.findAll();
        model.addAttribute("authors", authors);
        return "index";
    }

    @GetMapping("/deleteAuthor/{id}")
    public String deleteAuthor(@PathVariable UUID id) {
        authorRepository.deleteById(id);
        return "redirect:/ui/authors";
    }


    @PostMapping("/addAuthor")
    public String addAuthor(@ModelAttribute Author author) {
       author.setActive(true);
        authorRepository.save(author);
        return  "redirect:/ui/authors";
    }

    @GetMapping("/fetchAndSave")
    public String fetchAndSave() {
        authorPublicationService.fetchAndSavePublicationsForAuthors();
        return "redirect:/ui/authors";
    }

    @PostMapping("/generateMarkdown")
    public String generateMarkdown(@RequestParam("filePath") String filePath) {
        try {
            fileService.createMarkdownFile(filePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/ui/authors";
    }
}
