package com.example.bookstore.factory;

import com.example.bookstore.dto.BookDTO;
import com.example.bookstore.model.Author;
import com.example.bookstore.model.AuthorCut;
import com.example.bookstore.model.AuthorCutId;
import com.example.bookstore.model.Book;
import com.example.bookstore.model.Genre;
import com.example.bookstore.repository.AuthorCutRepository;
import com.example.bookstore.service.AuthorService;
import com.example.bookstore.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Class created to be {} for {}.
 *
 * @author Alfredo marin
 * @version 1
 * @since 2023-03-28
 */

@Component
public class BookFactory {

    private AuthorService authorService;

    private AuthorCutRepository authorCutRepository;

    private GenreService genreService;

    @Autowired
    public BookFactory(AuthorService authorService, AuthorCutRepository authorCutRepository, GenreService genreService) {
        this.authorService = authorService;
        this.authorCutRepository = authorCutRepository;
        this.genreService = genreService;
    }

    public Book bookDTOToBook(BookDTO bookDTO) {
        Set<Genre> genres = new HashSet<>();
        bookDTO.getGenres().forEach(genre -> genres.add(genreService.findById(genre).get()));

        Book book = new Book();
        book.setName(bookDTO.getName());
        book.setGenres(genres);
        book.setEnable(true);

        return book;
    }

    public Set<AuthorCut> saveAuthorsCuts(Book book, Set<UUID> authorsIds) {
        Set<Author> authors = new HashSet<>();
        Set<AuthorCut> authorsCut = new HashSet<>();
        authorsIds.forEach(author -> authors.add(authorService.findById(author).get()));

        for (Author author : authors) {
            AuthorCutId authorCutId = new AuthorCutId(author.getId(), book.getId());

            AuthorCut authorCut = new AuthorCut(authorCutId, 10F);
            authorCut.setAuthor(author);
            authorCut.setBook(book);

            authorsCut.add(authorCutRepository.save(authorCut));
        }
        return authorsCut;
    }
}
