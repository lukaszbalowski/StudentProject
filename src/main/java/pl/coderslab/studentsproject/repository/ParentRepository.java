package pl.coderslab.studentsproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.studentsproject.model.Parent;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Long> {

}
