package com.example.bookstore.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 * Class created to be {} for {}.
 *
 * @author Alfredo marin
 * @version 1
 * @since 2023-03-28
 */

@Embeddable
public class AuthorCutId implements Serializable {

    private UUID authorId;

    private UUID bookId;

    /* Constructors */

    public AuthorCutId(UUID authorId, UUID bookId) {
        this.authorId = authorId;
        this.bookId = bookId;
    }

    public AuthorCutId() {
    }

    /* Equals and HashCode */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorCutId that = (AuthorCutId) o;
        return Objects.equals(authorId, that.authorId) && Objects.equals(bookId, that.bookId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorId, bookId);
    }

    /* Getters and Setters */

    public UUID getAuthorId() {
        return authorId;
    }

    public void setAuthorId(UUID authorId) {
        this.authorId = authorId;
    }

    public UUID getBookId() {
        return bookId;
    }

    public void setBookId(UUID bookId) {
        this.bookId = bookId;
    }

    /* To String */

    /**
     * To String Method.
     * @return {@link String}. String with all objects' values.
     */
    @Override
    public String toString() {
        return "AuthorCutId{" +
                "authorId=" + authorId +
                ", bookId=" + bookId +
                '}';
    }
}
