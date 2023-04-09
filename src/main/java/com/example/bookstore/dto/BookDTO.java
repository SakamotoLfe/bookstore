package com.example.bookstore.dto;

import java.util.Set;
import java.util.UUID;

/**
 * Class created to be {} for {}.
 *
 * @author Alfredo marin
 * @version 1
 * @since 2023-03-28
 */

public class BookDTO {

    private String name;

    private Set<UUID> authors;

    private Set<UUID> genres;

    public BookDTO(String name, Set<UUID> authors, Set<UUID> genres) {
        this.name = name;
        this.authors = authors;
        this.genres = genres;
    }

    public BookDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<UUID> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<UUID> authors) {
        this.authors = authors;
    }

    public Set<UUID> getGenres() {
        return genres;
    }

    public void setGenres(Set<UUID> genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "name='" + name + '\'' +
                ", authors=" + authors +
                ", genres=" + genres +
                '}';
    }
}
