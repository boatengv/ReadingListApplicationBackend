package com.example.ReadingListApp.Service;
import com.example.ReadingListApp.DTO.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ReadingListApp.Model.Book;
import com.example.ReadingListApp.Model.Student;
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

    public boolean addStudent(Student student) {
        try {
            studentRepository.save(student);
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

    public List<BookDTO> getStudentBookList(UUID studentId) {

        List<Book> bookList = bookRepository.findByStudentId(studentId);
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

    public boolean getLogin(UUID studentId) {
        return studentRepository.findById(studentId).get().isLoggedin();
    }

    public void Logout(UUID studentId) {
        Student student = studentRepository.findById(studentId).get();
        student.setLoggedin(false);
        studentRepository.save(student);
    }
}
