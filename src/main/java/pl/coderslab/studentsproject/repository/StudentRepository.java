package pl.coderslab.studentsproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.studentsproject.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


}
