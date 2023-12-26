package com.example.ReadingListApp.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.ReadingListApp.Model.Book;
import com.example.ReadingListApp.Model.BookRecord;
import com.example.ReadingListApp.Service.BookRetrievalService;
import com.example.ReadingListApp.Service.BookService;
import com.example.ReadingListApp.Service.StudentService;
import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@CrossOrigin("http://localhost:3000")
@RestController
public class BookController {
    
    @Autowired
    private BookService bookService;
    private BookRetrievalService bookRetrievalService;

    public BookController(BookService bookService, BookRetrievalService bookRetrievalService){
        this.bookService = bookService;
        this.bookRetrievalService = bookRetrievalService;
    }

    @GetMapping("/api/GetBookList")
    public List<Book> getBookList(){     
        return bookService.getBookList();
    }    

    @PutMapping("/api/AddBook")
    public void addBook(
        @RequestParam UUID studentId,
        @RequestParam String isbn,
        @RequestParam String state 
    ) throws JsonProcessingException {
        bookService.addBook(studentId, isbn, state);
    }

    @DeleteMapping("/api/RemoveBook/{bookId}")
    public void removeBook(@PathVariable UUID bookId){
        bookService.removeBook(bookId);
    }

    @PutMapping("/api/UpdateBookState")
    public void updateBookState(
        @RequestParam UUID studentId,
        @RequestParam UUID bookId,
        @RequestParam String newState
    ){
        bookService.updateBookState(studentId, bookId, newState);
    }

    @GetMapping("/api/RetrieveBook/{isbn}")
    public BookRecord retrievBookDetails(@PathVariable String isbn) throws JsonProcessingException {
        return bookRetrievalService.retrieveBookData(isbn);
    }
    
}
