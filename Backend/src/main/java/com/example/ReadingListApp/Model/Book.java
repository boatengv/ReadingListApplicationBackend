package com.example.ReadingListApp.Model;
import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter@Setter@NoArgsConstructor
public class Book {
  
    @Id@GeneratedValue
    private UUID bookId;
    private String isbn;
    private String title; 
    private String subtitle;
    private String authors; 
    private String state;
    private String imageUrlSmall;
    private String imageUrlMedium;
    private String imageUrlLarge;
    private String publishedDate;

    @ManyToOne@JsonIgnore
    @JoinColumn(name = "student_id") 
    private Student student; 

    public Book(String isbn, String title, String subtitle, String authors, String state, String imageUrlSmall, String imageUrlMedium, String imageUrlLarge, String publishedDate){
        this.isbn = isbn;
        this.title = title; 
        this.subtitle = subtitle;
        this.authors = authors;
        this.state = state;
        this.imageUrlSmall = imageUrlSmall; 
        this.imageUrlMedium = imageUrlMedium;
        this.imageUrlLarge = imageUrlLarge;
        this.publishedDate = publishedDate;
    }
}
