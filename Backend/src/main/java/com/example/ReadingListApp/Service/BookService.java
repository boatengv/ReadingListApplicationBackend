package com.example.ReadingListApp.Service;
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
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class BookService{
    
    @Autowired
    private BookRepository bookRepository; 
    private StudentRepository studentRepository;
    private BookDetailsRepository bookDetailsRepository;



    public BookService( BookRepository bookRepository, BookDetailsRepository bookDetailsRepository, StudentRepository studentRepository){
        this.bookRepository = bookRepository;
        this.studentRepository = studentRepository;
        this.bookDetailsRepository = bookDetailsRepository;
    }

    public boolean addBook(String bookId, UUID studentId, String title, String authors, String publisher, String publishedDate, int pageCount, String category, String description, String thumbnail, long timestamp){
        Book book = new Book(bookId, studentId, "START", timestamp);
        BookDetails bookDetails = new BookDetails(bookId, title, authors, publisher, publishedDate, pageCount, category, description, thumbnail);
        Student student = studentRepository.findById(studentId).get();        
        log.info("in the book service bookId = {}, studentID = {}, title  = {}, authors = {}, publisher={}, publishedDate = {}, pageCount = {}, category = {}, description  = {}", bookId,  studentId,  title,  authors,  publisher,  publishedDate,  pageCount, category, description);
        bookRepository.save(book);
        bookDetailsRepository.save(bookDetails);
        return true;
    }

    public List<Book> getBookList() {
        return bookRepository.findAll();
    }

    @Transactional
    public void removeBook(String bookId, UUID studentId) {
        log.info("in the delete: book is {} & studentId is {}",bookId,studentId);
        bookRepository.deleteByBookIdAndStudentId(bookId, studentId);
    }

    public void changeBookState(String bookId, UUID studentId, String state) {
        Book book = bookRepository.findByBookIdAndStudentId(bookId, studentId);
        log.info("book is {}",book);
        book.setState(state);
        bookRepository.save(book);
    }

    public void rateBook(String bookId, UUID studentId, double review) {
        Book book = bookRepository.findByBookIdAndStudentId(bookId, studentId);
        log.info("book is {}",book);
        book.setReview(review);
        bookRepository.save(book);
    }
}
