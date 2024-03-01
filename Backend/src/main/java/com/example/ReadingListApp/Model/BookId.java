package com.example.ReadingListApp.Model;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Getter@Setter@NoArgsConstructor
public class BookId implements Serializable {

    @Column(name = "book_id")
    private String bookId;

    @Column(name = "student_id")
    private UUID studentId;

    public BookId(String bookId,UUID studentId) {
        this.bookId = bookId;
        this.studentId = studentId;
    }
}