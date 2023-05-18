package pl.coderslab.studentsproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.studentsproject.model.Student;
import pl.coderslab.studentsproject.repository.StudentRepository;

import java.util.List;

@Service
public class StudentServiceImplement implements StudentService {


    @Autowired
    private StudentRepository StudentRepository;

    @Override
    public List<Student> getAllStudents() {
        return StudentRepository.findAll();
    }

    @Override
    public List<Student> searchStudentsByLastName(String lastName) {
        return StudentRepository.findByLastName(lastName);
    }
}
