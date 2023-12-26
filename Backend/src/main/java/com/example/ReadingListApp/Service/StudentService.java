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

    public void addStudent(String name, String username, String email, String password) {
        studentRepository.save(new Student(name, username, email, password));
    }

    public Student getStudentById(UUID studentId) {
        return studentRepository.findById(studentId).get();
    }

    public void removeStudent(UUID studentId) {
        studentRepository.deleteById(studentId);
    }

    public UUID getStudentId(String email) {
        return studentRepository.findByEmail(email).get().getStudentId();
    }

    public List<Book> getStudentBookList(UUID studentId) {
        List<Book> bookList = studentRepository.findById(studentId).get().getBookList();
        return bookList;
    }

}
