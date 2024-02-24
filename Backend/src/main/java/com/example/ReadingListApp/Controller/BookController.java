package com.example.ReadingListApp.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.ReadingListApp.Model.Book;
import com.example.ReadingListApp.Service.BookService;
import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@CrossOrigin("http://localhost:3000")
@RestController
public class BookController {
    
    @Autowired
    private BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/api/GetBookList")
    public List<Book> getBookList(){     
        return bookService.getBookList();
    }    

    @PostMapping("/api/AddBook")
    public boolean addBook(
        @RequestParam UUID studentId,
        @RequestParam String title,
        @RequestParam String thumbnail,
        @RequestParam String authors,
        @RequestParam String categories, 
        @RequestParam int page_count,
        @RequestParam String publisher, 
        @RequestParam String publishedDate,
        @RequestParam String state,
        @RequestParam String description, 
        @RequestParam long timestamp
    ) {
        return bookService.addBook(studentId, title, thumbnail, authors, categories, page_count, publisher, publishedDate, state, description, timestamp);
    } 

    @DeleteMapping("/api/RemoveBook")
    public void removeBook(
        @RequestParam UUID studentId,
        @RequestParam UUID bookId
    ){
        bookService.removeBook(studentId, bookId);
    }

    @PutMapping("/api/UpdateBookState")
    public void updateBookState(
        @RequestParam UUID studentId,
        @RequestParam UUID bookId,
        @RequestParam String newState
    ){
        bookService.updateBookState(studentId, bookId, newState);
    } 
}
