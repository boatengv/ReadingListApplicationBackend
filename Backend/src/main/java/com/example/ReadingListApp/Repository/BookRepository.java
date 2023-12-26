package com.example.ReadingListApp.Repository;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.ReadingListApp.Model.Book;


@Repository
public interface BookRepository extends JpaRepository<Book, UUID>{
    Book findByBookIdAndStudent_StudentId(UUID bookId, UUID StudentId);
}
