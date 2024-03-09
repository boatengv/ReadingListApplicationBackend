package com.example.ReadingListApp.Controller;
import com.example.ReadingListApp.DTO.BookDTO;
import com.example.ReadingListApp.Model.Book;
import org.springframework.web.bind.annotation.*;
import com.example.ReadingListApp.Model.Student;
import com.example.ReadingListApp.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

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
    public Student getStudentId(@PathVariable String email) {
        return studentService.getStudentId(email);
    }
    
    @GetMapping("/api/GetStudent/{studentId}")
    public Student getStudentById(@PathVariable UUID studentId) {
        return studentService.getStudentById(studentId);
    }

    @GetMapping("/api/GetLogin/{studentId}")
    public boolean getLogin(@PathVariable UUID studentId) {
        return studentService.getLogin(studentId);
    }

    @PutMapping("/api/Logout/{studentId}")
    public void Logout(@PathVariable UUID studentId) {
        studentService.Logout(studentId);
    }

    @GetMapping("/api/GetStudentBookList/{studentId}")
    public List<BookDTO> getStudentBookList(@PathVariable UUID studentId) {
        return studentService.getStudentBookList(studentId);
    }
    
    @PostMapping("/api/AddStudent")
    public boolean postMethodName(@RequestBody Student student) {
        return studentService.addStudent(student);
    }
    
    @DeleteMapping("/api/RemoveStudent/{studentId}")
    public void removeStudent(@PathVariable UUID studentId){
        studentService.removeStudent(studentId);
    }
}
