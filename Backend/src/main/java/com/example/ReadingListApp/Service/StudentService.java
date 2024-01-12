package com.example.ReadingListApp.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ReadingListApp.Model.Book;
import com.example.ReadingListApp.Model.Student;
import com.example.ReadingListApp.Repository.StudentRepository;
import java.util.List;
import java.util.UUID;

@Service
public class StudentService {
    
    @Autowired
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudentList() {
        return studentRepository.findAll();
    }

    public boolean addStudent(String name, String email, String password) {
        try {
            studentRepository.save(new Student(name, email, password));
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

    public UUID getStudentId(String email) {
        Student student = studentRepository.findByEmail(email).get();
        student.setLoggedin(true);
        studentRepository.save(student);
        return student.getStudentId();
    }

    public List<Book> getStudentBookList(UUID studentId) {
        List<Book> bookList = studentRepository.findById(studentId).get().getBookList();
        return bookList;
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
