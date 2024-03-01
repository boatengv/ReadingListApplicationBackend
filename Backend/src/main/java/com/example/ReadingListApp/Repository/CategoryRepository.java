package com.example.ReadingListApp.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.ReadingListApp.Model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String>{
    
}
