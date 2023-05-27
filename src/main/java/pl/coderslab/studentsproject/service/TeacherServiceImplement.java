package pl.coderslab.studentsproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.studentsproject.model.Teacher;
import pl.coderslab.studentsproject.repository.TeacherRepository;

import java.util.List;

@Service
public class TeacherServiceImplement implements TeacherService {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherServiceImplement(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }
}
