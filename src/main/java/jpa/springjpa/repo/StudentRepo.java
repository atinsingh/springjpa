package jpa.springjpa.repo;

import jpa.springjpa.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    Optional<Student> findByName(String name);
    Optional<Student> findByNameAndProgramName(String name , String program);
    @Query(value = "select count(0) from student_info", nativeQuery = true)
    Integer countAll();
}
