package com.example.ReadingListApp.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.ReadingListApp.Model.BookDetails;

@Repository
public interface BookDetailsRepository extends JpaRepository<BookDetails, String>{
    
}
