package pl.coderslab.studentsproject.service;


import org.springframework.stereotype.Service;
import pl.coderslab.studentsproject.model.Class;
import pl.coderslab.studentsproject.model.Student;
import pl.coderslab.studentsproject.repository.ClassRepository;
import pl.coderslab.studentsproject.repository.StudentRepository;

import java.util.List;

@Service
public class ClassServiceImplement implements ClassService {

    final
    ClassRepository classRepository;

    final
    StudentRepository studentRepository;

    public ClassServiceImplement(ClassRepository classRepository, StudentRepository studentRepository) {
        this.classRepository = classRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Class> getAllClasses() {
        return classRepository.findAll();
    }

    @Override
    public Class getClassById(long classId) {

        Class classDetails = classRepository.findById(classId)
                .orElseThrow(() -> new IllegalArgumentException("Niepoprawny ID Klasy: " + classId));
        List<Student> students = studentRepository.findByClassId((int) classId);

        return classDetails;

    }

    @Override
    public Class getClassByName(String className) {
        return classRepository.findByClassName(className)
                .orElseThrow(() -> new IllegalArgumentException("Niepoprawna nazwa klasy: " + className));
    }

    @Override
    public void saveClass(Class classDetails) {
        classRepository.save(classDetails);
    }


}
