package com.example.ReadingListApp.Service;
import com.example.ReadingListApp.DTO.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ReadingListApp.Model.Book;
import com.example.ReadingListApp.Model.BookDetails;
import com.example.ReadingListApp.Model.Student;
import com.example.ReadingListApp.Repository.BookDetailsRepository;
import com.example.ReadingListApp.Repository.BookRepository;
import com.example.ReadingListApp.Repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class BookService{
    
    @Autowired
    private final BookRepository bookRepository;
    private final BookDetailsRepository bookDetailsRepository;


    public BookService( BookRepository bookRepository, BookDetailsRepository bookDetailsRepository){
        this.bookRepository = bookRepository;
        this.bookDetailsRepository = bookDetailsRepository;
    }

    public boolean addBook(String bookId, UUID studentId, String title, String authors, String publisher, String publishedDate, int pageCount, String category, String description, String thumbnail, long timestamp){
        bookRepository.save(new Book(bookId, studentId, "START", timestamp));
        bookDetailsRepository.save(new BookDetails(bookId, title, authors, publisher, publishedDate, pageCount, category, description, thumbnail));
        return true;
    }

    public List<BookDTO> getBookList() {

        List<Book> bookList = bookRepository.findAll();
        List<BookDTO> bookDTOList = new ArrayList<>();

        for(int i = 0; i < bookList.size(); i++){
            bookDTOList.add(new BookDTO(
                    bookList.get(i).getBookId(),
                    bookList.get(i).getBookDetails().getTitle(),
                    bookList.get(i).getBookDetails().getAuthors(),
                    bookList.get(i).getBookDetails().getPublisher(),
                    bookList.get(i).getBookDetails().getPublishedDate(),
                    bookList.get(i).getBookDetails().getPageCount(),
                    bookList.get(i).getBookDetails().getCategory(),
                    bookList.get(i).getBookDetails().getDescription(),
                    bookList.get(i).getBookDetails().getThumbnail(),
                    bookList.get(i).getState(),
                    bookList.get(i).getTimestamp(),
                    bookList.get(i).getBookDetails().getAVG_review()
                )
            );
        }

        return bookDTOList;
    }

    @Transactional
    public void removeBook(String bookId, UUID studentId) {
        bookRepository.deleteByBookIdAndStudentId(bookId, studentId);
    }

    public void changeBookState(String bookId, UUID studentId, String state) {
        Book book = bookRepository.findByBookIdAndStudentId(bookId, studentId);
        book.setState(state);
        bookRepository.save(book);
    }

    public void rateBook(String bookId, UUID studentId, double review) {
        Book book = bookRepository.findByBookIdAndStudentId(bookId, studentId);
        book.setReview(review);
        bookRepository.save(book);
    }
}
