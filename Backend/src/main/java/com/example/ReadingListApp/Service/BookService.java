package com.example.ReadingListApp.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ReadingListApp.Model.Book;
import com.example.ReadingListApp.Model.Student;
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


    public BookService( BookRepository bookRepository, StudentRepository studentRepository){
        this.bookRepository = bookRepository;
        this.studentRepository = studentRepository;
    }

    public boolean addBook(UUID studentId, String title, String thumbnail, String authors, String categories, int page_count, String publisher, String publishedDate, String state, String description, long timestamp) {
            Book book = new Book(title, thumbnail, authors, categories, page_count, publisher, publishedDate, state, description, timestamp);
            Student student = studentRepository.findById(studentId).get();
            book.setStudent(student);
            bookRepository.save(book);
            return true;
    }

    public List<Book> getBookList() {
        return bookRepository.findAll();
    }

    @Transactional
    public void removeBook(UUID studentId, UUID bookId) {
        bookRepository.deleteByBookIdAndStudent_StudentId(bookId,studentId);
    }

    public void updateBookState(UUID studentId, UUID bookId, String newState) {
        Book book = bookRepository.findByBookIdAndStudent_StudentId(bookId,studentId);
        book.setState(newState);
        bookRepository.save(book);
    }

 
}
