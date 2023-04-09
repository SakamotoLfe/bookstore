package com.example.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

/**
 * Class created to be {} for {}.
 *
 * @author Alfredo marin
 * @version 1
 * @since 2023-03-28
 */

@Entity
public class Book extends GenericEntity {

    @Column
    private String name;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<AuthorCut> authors;

    @ManyToMany
    private Set<Genre> genres;

    /* Constructors */

    public Book(UUID id, Date createdDate, Date lastUpdate, boolean enable, String name, Set<AuthorCut> authors, Set<Genre> genres) {
        super(id, createdDate, lastUpdate, enable);
        this.name = name;
        this.authors = authors;
        this.genres = genres;
    }

    public Book(String name, Set<AuthorCut> authors, Set<Genre> genres) {
        this.name = name;
        this.authors = authors;
        this.genres = genres;
    }

    public Book() {
    }

    /* Equals and HashCode */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(name, book.name) && Objects.equals(authors, book.authors) && Objects.equals(genres, book.genres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, authors, genres);
    }

    /* Getters and Setters */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<AuthorCut> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<AuthorCut> authors) {
        this.authors = authors;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    /* To String */

    /**
     * To String Method.
     * @return {@link String}. String with all objects' values.
     */
    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", authors=" + authors +
                ", genres=" + genres +
                '}';
    }
}
