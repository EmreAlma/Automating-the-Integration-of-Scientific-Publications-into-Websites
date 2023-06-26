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

        return "config";
    }

    @GetMapping("/addAuthor")
    public String addAuthor() {

        return "addAuthor";
    }

    @PostMapping("/createAuthor")
    public String createAuthor(@RequestParam(value = "username", required = false) String username,
                               @RequestParam(value = "lastname", required = false) String lastname) {
        Authors  authors=new Authors();
        authors.setName(username);
        authors.setLastName(lastname);
        authors.setActive(true);

        authorRepository.save(authors);
        return  "redirect:/ui/authors";
    }
}
