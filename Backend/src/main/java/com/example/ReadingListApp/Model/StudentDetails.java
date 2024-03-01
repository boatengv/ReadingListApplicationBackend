package com.example.ReadingListApp.Model;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@NoArgsConstructor
public class StudentDetails {

    private Student student;
    private List<BookDetailsList> book; 

}
