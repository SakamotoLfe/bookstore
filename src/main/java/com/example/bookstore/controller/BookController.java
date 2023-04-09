package com.example.bookstore.controller;

import com.example.bookstore.dto.BookDTO;
import com.example.bookstore.factory.BookFactory;
import com.example.bookstore.model.Book;
import com.example.bookstore.service.BookService;
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
@RequestMapping("/books")
public class BookController extends GenericController<Book> {

    private BookService bookService;

    private BookFactory bookFactory;

    @Autowired
    public BookController(BookService bookService, BookFactory bookFactory) {
        this.bookService = bookService;
        this.bookFactory = bookFactory;
    }

    @Override
    protected GenericService<Book> getGenericService() {
        return bookService;
    }

    @PostMapping("/save")
    @ResponseBody
    public Book saveBook(@RequestBody BookDTO bookDTO) {
        Book book = bookFactory.bookDTOToBook(bookDTO);
        book = bookService.save(book);
        bookFactory.saveAuthorsCuts(book, bookDTO.getAuthors());
        return book;
    }
}
