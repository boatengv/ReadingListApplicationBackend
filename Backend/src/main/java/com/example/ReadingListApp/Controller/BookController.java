package com.example.ReadingListApp.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.ReadingListApp.Service.BookService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.ReadingListApp.Model.Book;

import java.util.List;
import java.util.UUID;

@CrossOrigin("http://localhost:3000")
@RestController
public class BookController {
    
    @Autowired
    private BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @PostMapping("/api/AddBook")
    public boolean addBook(
        @RequestParam String bookId,
        @RequestParam UUID studentId,
        @RequestParam String title,
        @RequestParam String authors,
        @RequestParam String publisher, 
        @RequestParam String publishedDate,
        @RequestParam int pageCount,
        @RequestParam String category, 
        @RequestParam String description, 
        @RequestParam String thumbnail,
        @RequestParam long timestamp
    ) {
        return bookService.addBook(bookId, studentId, title, authors, publisher, publishedDate, pageCount, category, description, thumbnail, timestamp);
    } 

    @DeleteMapping("/api/RemoveBook")
    public void removeBook(
        @RequestParam String bookId,
        @RequestParam UUID studentId
    ){
        bookService.removeBook(bookId, studentId);
    }

    @PutMapping("/api/ChangeBookState")
    public void changeBookState(
        @RequestParam String bookId,
        @RequestParam UUID studentId,
        @RequestParam String state
    ){
        bookService.changeBookState(bookId, studentId, state); 
    } 

    @PutMapping("/api/RateBook")
    public void rateBook(
        @RequestParam String bookId,
        @RequestParam UUID studentId,
        @RequestParam double review
    ){
        bookService.rateBook(bookId, studentId, review); 
    }

    @GetMapping("/api/GetBooks")
    public List<Book> getBookList(){
        return bookService.getBookList(); 
    }

}
