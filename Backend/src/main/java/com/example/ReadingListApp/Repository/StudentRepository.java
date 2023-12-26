package com.example.ReadingListApp.Repository;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.ReadingListApp.Model.Student;
import java.util.Optional;


@Repository
public interface StudentRepository extends JpaRepository<Student, UUID>{
    public Optional<Student> findByEmail(String email);
}
