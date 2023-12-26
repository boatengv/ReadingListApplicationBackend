package com.example.ReadingListApp.Model;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class BookDetails {
    private String title;
    private String subtitle;
    private List<Author> authors;
    private String publish_date;
    private Cover cover;
}
