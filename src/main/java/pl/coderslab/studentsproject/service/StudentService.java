package pl.coderslab.studentsproject.service;
import pl.coderslab.studentsproject.model.Student;
import java.util.List;



public interface StudentService {

    List<Student> getAllStudents();
    List<Student> searchStudentsByLastName(String lastName);

}
