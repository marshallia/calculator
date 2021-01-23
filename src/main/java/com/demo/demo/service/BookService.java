package com.demo.demo.service;

import com.demo.demo.entity.Book;

import java.util.List;

public interface BookService {

    Book insert(String title, String author);

    String delete(Long id);

    Book edit(Long id, String title, String author);

    List<Book> getList();
}
