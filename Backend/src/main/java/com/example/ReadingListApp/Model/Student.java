package com.example.ReadingListApp.Model;
import java.util.List;
import java.util.UUID;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
    private boolean loggedin;
    private String salt;

    @OneToMany(mappedBy = "student", cascade=CascadeType.ALL)
    private List<Book> bookList;     

    public Student(String name, String email, String password, String salt){
        this.name=name;
        this.email=email; 
        this.password=password;
        this.salt = salt;
    }
    
}
