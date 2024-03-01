package com.example.ReadingListApp.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ReadingListApp.Model.Book;
import com.example.ReadingListApp.Model.BookDetails;
import com.example.ReadingListApp.Model.BookDetailsList;
import com.example.ReadingListApp.Model.Student;
import com.example.ReadingListApp.Model.StudentDetails;
import com.example.ReadingListApp.Repository.BookDetailsRepository;
import com.example.ReadingListApp.Repository.BookRepository;
import com.example.ReadingListApp.Repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class StudentService {
    
    @Autowired
    private StudentRepository studentRepository;
    private BookDetailsRepository bookDetailsRepository;
    private BookRepository bookRepository;

    public StudentService(StudentRepository studentRepository, BookDetailsRepository bookDetailsRepository, BookRepository bookRepository){
        this.studentRepository = studentRepository;
        this.bookDetailsRepository = bookDetailsRepository;
        this.bookRepository = bookRepository;
    }

    public List<Student> getStudentList() {
        return studentRepository.findAll();
    }

    public boolean addStudent(String name, String email, String password, String salt) {
        try {
            studentRepository.save(new Student(name, email, password, salt));
            return true;
        } catch(org.springframework.dao.DataIntegrityViolationException e){
            return false;
        }        
    }

    public Student getStudentById(UUID studentId) {
        return studentRepository.findById(studentId).get();
    }

    public void removeStudent(UUID studentId) {
        studentRepository.deleteById(studentId);
    }

    public Student getStudentId(String email) {
        Student student = studentRepository.findByEmail(email).get();
        student.setLoggedin(true);
        studentRepository.save(student); 
        return student;
    }

    public List<BookDetailsList> getStudentBookList(UUID studentId) {
        Student student = studentRepository.findById(studentId).get();
        List<Book> bookList = bookRepository.findByStudentId(studentId);
        List<BookDetailsList> bookDetailsList = new ArrayList<BookDetailsList>();

        //log.info("book list is of length {}",bookList.size());

        StudentDetails studentDetails = new StudentDetails();
        studentDetails.setStudent(student);

        for(int i=0; i < bookList.size(); i++){
            bookDetailsList.add(
                new BookDetailsList(
                    bookList.get(i).getBookId(), 
                    bookDetailsRepository.findById(bookList.get(i).getBookId()).get().getTitle(),
                    bookDetailsRepository.findById(bookList.get(i).getBookId()).get().getAuthors(), 
                    bookDetailsRepository.findById(bookList.get(i).getBookId()).get().getPublisher(), 
                    bookDetailsRepository.findById(bookList.get(i).getBookId()).get().getPublishedDate(), 
                    bookDetailsRepository.findById(bookList.get(i).getBookId()).get().getPageCount(),  
                    bookDetailsRepository.findById(bookList.get(i).getBookId()).get().getCategory(),  
                    bookDetailsRepository.findById(bookList.get(i).getBookId()).get().getDescription(),  
                    bookDetailsRepository.findById(bookList.get(i).getBookId()).get().getThumbnail(),  
                    bookList.get(i).getState(),
                    bookList.get(i).getTimestamp(),
                    bookList.get(i).getReview(), 
                    bookDetailsRepository.findById(bookList.get(i).getBookId()).get().getAVG_review()
                )
            );
        }

        return bookDetailsList;
    }

    public boolean getLogin(UUID studentId) {
        return studentRepository.findById(studentId).get().isLoggedin();
    }

    public void Logout(UUID studentId) {
        Student student = studentRepository.findById(studentId).get();
        student.setLoggedin(false);
        studentRepository.save(student);
    }
}
