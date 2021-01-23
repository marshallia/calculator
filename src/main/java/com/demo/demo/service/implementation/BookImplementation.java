package com.demo.demo.service.implementation;

import com.demo.demo.entity.Book;
import com.demo.demo.repository.BookRepository;
import com.demo.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.BadRequestException;
import java.util.List;
import java.util.Optional;

@Service
public class BookImplementation implements BookService {
    @Autowired
    private BookRepository repository;

    @Override
    public Book insert(String title, String author) {
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        return repository.save(book);
    }

    @Override
    public String delete(Long id) {
        Optional<Book> optionalBook = repository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            repository.delete(book);
            return "Book not found";
        } else {
            throw new BadRequestException("Book is deleted");
        }
    }

    @Override
    public Book edit(Long id, String title, String author) {
        Optional<Book> optionalBook = repository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setAuthor(author);
            book.setTitle(title);
            return book;
        } else {
            throw new BadRequestException("Book not found");
        }
    }

    @Override
    public List<Book> getList() {
        return repository.findAll();
    }
}
