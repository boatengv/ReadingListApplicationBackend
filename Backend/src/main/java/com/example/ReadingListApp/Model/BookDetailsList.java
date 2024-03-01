package com.example.ReadingListApp.Model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@NoArgsConstructor
public class BookDetailsList {
    
    private String bookId;
    private String title;    
    private String authors; 
    private String publisher; 
    private String publishedDate;
    private int pageCount; 
    private String category;  
    private String description;
    private String thumbnail;
    private String state;
    private long timestamp;
    private double review; 
    private double AVG_review;


    public BookDetailsList(
        String bookId, 
        String title, 
        String authors, 
        String publisher, 
        String publishedDate, 
        int pageCount, 
        String category, 
        String description, 
        String thumbnail, 
        String state, 
        long timestamp, 
        double review,
        double AVG_review
    ){
        this.bookId = bookId;
        this.title = title;
        this.authors = authors; 
        this.publisher = publisher; 
        this.publishedDate = publishedDate; 
        this.pageCount = pageCount; 
        this.category = category; 
        this.description = description; 
        this.thumbnail = thumbnail; 
        this.state = state;
        this.timestamp = timestamp;
        this.review = review;
        this.AVG_review = AVG_review;
    }
}
