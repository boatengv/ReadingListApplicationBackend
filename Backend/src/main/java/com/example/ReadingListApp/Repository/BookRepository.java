package com.example.ReadingListApp.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.ReadingListApp.Model.Book;
import com.example.ReadingListApp.Model.BookId;
import java.util.List;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, BookId>{
    List<Book> findByStudentId(UUID studentId);
    Book findByBookIdAndStudentId(String bookId, UUID StudentId);
    void deleteByBookIdAndStudentId(String bookId, UUID studentId);
}
