package com.example.bookstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

/**
 * Class created to be {} for {}.
 *
 * @author Alfredo marin
 * @version 1
 * @since 2023-03-28
 */

@Entity
public class Genre extends GenericEntity {

    @Column
    private String name;

    /* Constructors */

    public Genre(UUID id, Date createdDate, Date lastUpdate, boolean enable, String name) {
        super(id, createdDate, lastUpdate, enable);
        this.name = name;
    }

    public Genre(String name) {
        this.name = name;
    }

    public Genre() {
    }

    /* Equals and HashCode */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genre genre = (Genre) o;
        return Objects.equals(name, genre.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    /* Getters and Setters */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /* To String */

    /**
     * To String Method.
     * @return {@link String}. String with all objects' values.
     */
    @Override
    public String toString() {
        return "Genre{" +
                "name='" + name + '\'' +
                '}';
    }
}
