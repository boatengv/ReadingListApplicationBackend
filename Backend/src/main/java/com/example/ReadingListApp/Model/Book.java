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
    private String title;
    private String thumbnail;
    private String authors; 
    private String categories; 
    private int page_count; 
    private String publisher; 
    private String publishedDate;
    private String state;  
    private String description;
    private long timestamp;

    @ManyToOne@JsonIgnore
    @JoinColumn(name = "student_id") 
    private Student student; 

    public Book(String title, String thumbnail, String authors, String categories, int page_count, String publisher, String publishedDate, String state, String description, long timestamp){
        this.title = title; 
        this.thumbnail = thumbnail;
        this.authors = authors;
        this.categories = categories;
        this.page_count = page_count;
        this.publisher = publisher;
        this.publishedDate = publishedDate;
        this.state = state;
        this.description = description;
        this.timestamp = timestamp;
    }
}
