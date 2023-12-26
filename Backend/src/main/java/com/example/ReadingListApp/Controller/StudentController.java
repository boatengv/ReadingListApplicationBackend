package com.example.ReadingListApp.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.example.ReadingListApp.Model.Book;
import com.example.ReadingListApp.Model.Student;
import com.example.ReadingListApp.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.UUID;


@CrossOrigin("http://localhost:3000")
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    
    @GetMapping("/api/GetStudentList")
    public List<Student> getUserList() {
        return studentService.getStudentList();
    }

    @GetMapping("/api/GetStudentId/{email}")
    public UUID getStudentId(@PathVariable String email) {
        return studentService.getStudentId(email);
    }
    

    @GetMapping("/api/GetStudent/{studentId}")
    public Student getStudentById(@PathVariable UUID studentId) {
        return studentService.getStudentById(studentId);
    }

    @GetMapping("/api/GetStudentBookList/{studentId}")
    public List<Book> getStudentBookList(@PathVariable UUID studentId) {
        return studentService.getStudentBookList(studentId);
    }
    
    @PostMapping("/api/AddStudent")
    public void postMethodName(
        @RequestParam String name,
        @RequestParam String username,
        @RequestParam String email,
        @RequestParam String password 
    ) {
        studentService.addStudent(name, username, email, password);
    }
    
    @DeleteMapping("/api/RemoveStudent/{studentId}")
    public void removeStudent(@PathVariable UUID studentId){
        studentService.removeStudent(studentId);
    }
}
