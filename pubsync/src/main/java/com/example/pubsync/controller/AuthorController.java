package com.example.pubsync.controller;

import com.example.pubsync.entity.Author;
import com.example.pubsync.repository.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@Controller
@RequestMapping("/ui")
public class AuthorController {
    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping("/authors")
    public String getAuthor(Model model) {
        List<Author> authors = authorRepository.findAll();
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
                               @RequestParam(value = "surname", required = false) String surname,
                               @RequestParam(value = "startDate", required = false) String start_date,
                               @RequestParam(value = "quitDate", required = false) String quit_date) {
        Author author =new Author();
        author.setName(name);
        author.setLastName(surname);
        author.setActive(true);
        author.setStartDate(start_date);
        author.setQuitDate(quit_date);


        authorRepository.save(author);
        return  "redirect:/ui/authors";
    }
}
