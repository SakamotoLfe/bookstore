package com.example.bookstore.service;

import com.example.bookstore.model.Genre;
import com.example.bookstore.repository.GenericRepository;
import com.example.bookstore.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Class created to be {} for {}.
 *
 * @author Alfredo marin
 * @version 1
 * @since 2023-03-28
 */

@Service
public class GenreService extends GenericService<Genre> {

    private GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    protected GenericRepository getGenericRepository() {
        return genreRepository;
    }
}
