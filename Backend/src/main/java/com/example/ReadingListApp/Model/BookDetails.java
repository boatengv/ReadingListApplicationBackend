package com.example.ReadingListApp.Model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter@Setter@NoArgsConstructor
public class BookDetails {

    @Id
    @Column(name="book_id")
    private String bookId;
    private String title;    
    private String authors; 
    private String publisher; 
    private String publishedDate;
    private int pageCount; 
    private String category;  
    private String description;
    private String thumbnail;
    @Column(name="review")
    private double AVG_review;
    
    public BookDetails(String bookId, String title, String authors, String publisher, String publishedDate, int pageCount, String category, String description, String thumbnail){
        this.bookId = bookId;
        this.title = title;
        this.authors = authors; 
        this.publisher = publisher; 
        this.publishedDate = publishedDate; 
        this.pageCount = pageCount; 
        this.category = category; 
        this.description = description; 
        this.thumbnail = thumbnail; 
    }
}
