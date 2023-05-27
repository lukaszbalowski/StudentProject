package pl.coderslab.studentsproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.studentsproject.model.Class;
import pl.coderslab.studentsproject.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {




}
