package pl.coderslab.studentsproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.studentsproject.model.Parent;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Long> {

    Optional<Parent> findById(long parentId);

    List<Parent> findAll();




}
