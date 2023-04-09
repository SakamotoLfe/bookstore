package com.example.bookstore.controller;

import com.example.bookstore.model.Genre;
import com.example.bookstore.service.GenericService;
import com.example.bookstore.service.GenreService;
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
@RequestMapping("/genres")
public class GenreController extends GenericController<Genre> {

    private GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @Override
    protected GenericService<Genre> getGenericService() {
        return genreService;
    }

    @PostMapping("/save")
    @ResponseBody
    public Genre saveGenre(@RequestBody Genre genre) {
        return genreService.save(genre);
    }
}
