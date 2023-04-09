package com.example.bookstore.service;

import com.example.bookstore.model.Author;
import com.example.bookstore.repository.AuthorRepository;
import com.example.bookstore.repository.GenericRepository;
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
public class AuthorService extends GenericService<Author> {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    protected GenericRepository getGenericRepository() {
        return authorRepository;
    }
}
