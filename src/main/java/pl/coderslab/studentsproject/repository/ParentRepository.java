package pl.coderslab.studentsproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.studentsproject.model.Parent;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Long> {

//    @Query(value = "SELECT p from Parent p Join p.students s where s.id = :studentId")
//    Parent findByStudentsId(@Param("studentId") long studentId);

}
