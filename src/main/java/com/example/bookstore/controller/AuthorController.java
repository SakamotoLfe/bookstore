package com.example.bookstore.controller;

import com.example.bookstore.model.Author;
import com.example.bookstore.service.AuthorService;
import com.example.bookstore.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class created to be {} for {}.
 *
 * @author Alfredo marin
 * @version 1
 * @since 2023-03-28
 */

@RestController
@RequestMapping("/authors")
public class AuthorController extends GenericController<Author> {

    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @Override
    protected GenericService<Author> getGenericService() {
        return authorService;
    }

    @PostMapping("/save")
    @ResponseBody
    public Author saveAuthor(@RequestBody Author author) {
        return authorService.save(author);
    }
}
