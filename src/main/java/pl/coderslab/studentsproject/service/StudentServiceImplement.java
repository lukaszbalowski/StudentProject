package pl.coderslab.studentsproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.studentsproject.model.Student;
import pl.coderslab.studentsproject.repository.StudentRepository;

import java.util.List;

@Service
public class StudentServiceImplement implements StudentService {


    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> searchStudentsByLastName(String lastName) {
        return studentRepository.findByLastName(lastName);
    }

    @Override
    public List<Student> filterStudentsByClassId(int classId) {
        return studentRepository.findByClassId(classId);
    }
}
