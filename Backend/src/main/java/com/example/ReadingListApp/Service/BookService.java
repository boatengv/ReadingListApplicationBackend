package com.example.ReadingListApp.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ReadingListApp.Model.Book;
import com.example.ReadingListApp.Model.BookRecord;
import com.example.ReadingListApp.Model.Student;
import com.example.ReadingListApp.Repository.BookRepository;
import com.example.ReadingListApp.Repository.StudentRepository;
import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class BookService{
    
    @Autowired
    private BookRepository bookRepository; 
    private StudentRepository studentRepository;
    private BookRetrievalService bookRetrievalService;


    public BookService( BookRepository bookRepository, StudentRepository studentRepository, BookRetrievalService bookRetrievalService){
        this.bookRepository = bookRepository;
        this.studentRepository = studentRepository;
        this.bookRetrievalService = bookRetrievalService;
    }

    public void addBook(UUID studentId, String isbn, String state) throws JsonProcessingException {
        
        log.info("In addBook function in BookService studentId is {}, isbn is {} and state is {}",studentId, isbn, state);

        BookRecord bookRecord = bookRetrievalService.retrieveBookData(isbn);
        
        String title = bookRecord.getData().getTitle(); 
        String subtitle = bookRecord.getData().getSubtitle();
        String authors = ""; 
        String imageUrlSmall = bookRecord.getData().getCover().getSmall();
        String imageUrlMedium = bookRecord.getData().getCover().getMedium();
        String imageUrlLarge = bookRecord.getData().getCover().getLarge(); 
        String publishedDate = bookRecord.getData().getPublish_date();

        for (int i = 0; i < bookRecord.getData().getAuthors().size(); i++){
            authors += bookRecord.getData().getAuthors().get(i).getName() + ",";
        }

        Book book = new Book(isbn, title, subtitle, authors, state, imageUrlSmall, imageUrlMedium, imageUrlLarge, publishedDate);
        Student student = studentRepository.findById(studentId).get();
        book.setStudent(student);
        bookRepository.save(book);
    }

    public List<Book> getBookList() {
        return bookRepository.findAll();
    }

    public void removeBook(UUID bookId) {
        bookRepository.deleteById(bookId);
    }

    public void updateBookState(UUID studentId, UUID bookId, String newState) {
        Book book = bookRepository.findByBookIdAndStudent_StudentId(bookId,studentId);
        book.setState(newState);
        bookRepository.save(book);
    }

 
}
