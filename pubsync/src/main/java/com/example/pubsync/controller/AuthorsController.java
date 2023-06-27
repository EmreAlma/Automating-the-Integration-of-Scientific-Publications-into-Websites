package com.example.pubsync.controller;

import com.example.pubsync.model.Authors;
import com.example.pubsync.repository.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@Controller
@RequestMapping("/ui")
public class AuthorsController {
    private final AuthorRepository authorRepository;

    public AuthorsController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping("/authors")
    public String getAuthor(Model model) {
        List<Authors> authors = authorRepository.findAll();
        model.addAttribute("authors", authors);
        return "index";
    }

    @GetMapping("/deleteAuthor/{id}")
    public String deleteAuthor(@PathVariable String id) {
        authorRepository.deleteById(UUID.fromString(id));
        return "redirect:/ui/authors";
    }

    @GetMapping("/")
    public String uiFirstPage() {

        return "index";
    }

    @GetMapping("/addAuthor")
    public String addAuthor() {

        return "index";
    }

    @PostMapping("/createAuthor")
    public String createAuthor(@RequestParam(value = "name", required = false) String name,
                               @RequestParam(value = "surname", required = false) String surname) {
        Authors  authors=new Authors();
        authors.setName(name);
        authors.setLastName(surname);
        authors.setActive(true);

        authorRepository.save(authors);
        return  "redirect:/ui/authors";
    }
}
