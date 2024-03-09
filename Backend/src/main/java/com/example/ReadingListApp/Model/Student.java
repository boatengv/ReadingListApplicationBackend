package com.example.ReadingListApp.Model;
import java.util.List;
import java.util.UUID;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter@Setter@NoArgsConstructor
public class Student {

    @Id@GeneratedValue
    private UUID studentId; 
    private String name; 
    private String email; 
    private String password;  
    private String salt;
    @Column(name = "logged_in")
    private boolean loggedin;

    @OneToMany
    @JoinColumn(name = "student_id")
    private List<Book> book;

    public Student(String name, String email, String password, String salt){
        this.name=name;
        this.email=email; 
        this.password=password;
        this.salt = salt;
    }
}
