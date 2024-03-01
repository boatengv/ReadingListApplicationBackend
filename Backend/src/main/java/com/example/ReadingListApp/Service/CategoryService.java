package com.example.ReadingListApp.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ReadingListApp.Model.Category;
import com.example.ReadingListApp.Repository.CategoryRepository;
import java.util.List;

@Service
public class CategoryService{
    
    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
