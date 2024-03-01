package com.example.ReadingListApp.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.ReadingListApp.Model.Category;
import com.example.ReadingListApp.Service.CategoryService;
import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping("/api/categories")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }
    
    
}
