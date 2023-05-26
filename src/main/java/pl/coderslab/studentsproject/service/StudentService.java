package pl.coderslab.studentsproject.service;
import org.springframework.data.domain.Page;
import pl.coderslab.studentsproject.model.Parent;
import pl.coderslab.studentsproject.model.Student;
import java.util.List;



public interface StudentService {

    List<Student> getAllStudents();
    List<Student> searchStudentsByLastName(String lastName);
    List<Student> filterStudentsByClassId(int classId);
    void saveStudent(Student student);
    Student getStudentById(long id);
    void deleteStudent(long id);

//    Page<Student> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
    Page<Student> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

    List<Parent> getAllParents();

    List<Student> getStudentsByParentId(long parentId);








}

