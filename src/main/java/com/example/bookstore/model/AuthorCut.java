package com.example.bookstore.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import java.util.Objects;

/**
 * Class created to be {} for {}.
 *
 * @author Alfredo marin
 * @version 1
 * @since 2023-03-28
 */

@Entity
public class AuthorCut {

    @EmbeddedId
    private AuthorCutId authorCutId;

    @ManyToOne
    @MapsId("authorId")
    private Author author;

    @ManyToOne
    @MapsId("bookId")
    private Book book;

    @Column
    private Float percentage;

    /* Constructors */

    public AuthorCut(AuthorCutId authorCutId, Author author, Book book, Float percentage) {
        this.authorCutId = authorCutId;
        this.author = author;
        this.book = book;
        this.percentage = percentage;
    }

    public AuthorCut(AuthorCutId authorCutId, Float percentage) {
        this.authorCutId = authorCutId;
        this.percentage = percentage;
    }

    public AuthorCut(Float percentage) {
        this.percentage = percentage;
    }

    public AuthorCut() {
    }

    /* Equals and HashCode */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorCut authorCut = (AuthorCut) o;
        return Objects.equals(authorCutId, authorCut.authorCutId) && Objects.equals(author, authorCut.author)
                && Objects.equals(book, authorCut.book) && Objects.equals(percentage, authorCut.percentage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorCutId, author, book, percentage);
    }

    /* Getters and Setters */

    public AuthorCutId getAuthorCutId() {
        return authorCutId;
    }

    public void setAuthorCutId(AuthorCutId authorCutId) {
        this.authorCutId = authorCutId;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Float getPercentage() {
        return percentage;
    }

    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }

    /* To String */

    /**
     * To String Method.
     *
     * @return {@link String}. String with all objects' values.
     */
    @Override
    public String toString() {
        return "AuthorCut{" +
                "authorCutId=" + authorCutId +
                ", author=" + author +
                ", book=" + book +
                ", percentage=" + percentage +
                '}';
    }
}
