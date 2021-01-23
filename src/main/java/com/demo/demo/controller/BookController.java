package com.demo.demo.controller;

import com.demo.demo.entity.Book;
import com.demo.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.BadRequestException;
import java.util.List;

@RestController
@RequestMapping("/rest/")
public class BookController {
    @Autowired
    private BookService service;

    @GetMapping("bookList")
    public ResponseEntity getList() {
        return ResponseEntity.ok().body(service.getList());
    }

    @GetMapping("insertBook")
    public ResponseEntity insert(
            @RequestParam("Title") String title,
            @RequestParam("Author") String author
    ) {
        return ResponseEntity.ok().body(service.insert(title, author));
    }

    @GetMapping("delete")
    public ResponseEntity delete(@RequestParam("ID") Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok().body("Success!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("edit")
    public ResponseEntity edit(@RequestParam("ID") Long id,
                     @RequestParam("Title") String title,
                     @RequestParam("Author") String author) {
        try {
            service.edit(id, title, author);
            return ResponseEntity.ok().body(service.edit(id, title, author));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }
}
