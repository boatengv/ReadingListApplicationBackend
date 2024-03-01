package com.example.ReadingListApp.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter@Setter@NoArgsConstructor
public class Category {
    
    @Id
    private String category;

    public Category(String category){
        this.category = category;
    }
}
