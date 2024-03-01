package com.example.ReadingListApp.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;import com.example.ReadingListApp.Model.Book;
import com.example.ReadingListApp.Model.BookDetails;
import com.example.ReadingListApp.Repository.BookDetailsRepository;
import java.util.List;

@Service
public class BookDetailsService {

    @Autowired
    private BookDetailsRepository bookDetailsRepository; 

    public BookDetailsService(BookDetailsRepository bookDetailsRepository){
        this.bookDetailsRepository = bookDetailsRepository;
    }

    public List<BookDetails> getBookList() {
        return bookDetailsRepository.findAll();
    }    
}
