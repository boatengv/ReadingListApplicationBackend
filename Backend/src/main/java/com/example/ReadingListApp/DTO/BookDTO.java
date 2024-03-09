package com.example.ReadingListApp.DTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@NoArgsConstructor
public class BookDTO {
    
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
    private double AVG_review;


    public BookDTO(String bookId, String title, String authors, String publisher, String publishedDate, int pageCount,
        String category, String description, String thumbnail, String state, long timestamp, double AVG_review){
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
        this.AVG_review = AVG_review;
    }
}
