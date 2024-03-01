package com.example.ReadingListApp.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.ReadingListApp.Model.BookDetails;
import com.example.ReadingListApp.Service.BookDetailsService;
import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
public class BookDetailsController {
    
    @Autowired
    private BookDetailsService bookDetailsService;
    
    public BookDetailsController(BookDetailsService bookDetailsService){
        this.bookDetailsService = bookDetailsService;
    }

    @GetMapping("/api/GetBookListDetails")
    public List<BookDetails> getBookListDetails(){     
        return bookDetailsService.getBookList();
    }    
}
