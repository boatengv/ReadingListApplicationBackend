package com.example.ReadingListApp.Model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@Entity
@Getter@Setter@NoArgsConstructor
@IdClass(BookId.class)
public class Book {
  
    @Id
    @Column(name = "book_id")
    private String bookId;
    @Id
    @Column(name = "student_id")
    private UUID studentId;
    private String state;
    private long timestamp;
    private double review; 

    public Book(String bookId, UUID studentId, String state, long timestamp){
        this.bookId = bookId;
        this.studentId = studentId;
        this.state = state;
        this.timestamp = timestamp;
    }


}
