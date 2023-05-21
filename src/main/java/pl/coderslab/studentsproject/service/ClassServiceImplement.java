package pl.coderslab.studentsproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.studentsproject.model.Class;
import pl.coderslab.studentsproject.repository.ClassRepository;

import java.util.List;

@Service
public class ClassServiceImplement implements ClassService {

    @Autowired
    ClassRepository classRepository;

    @Override
    public List<Class> getAllClasses() {
        return classRepository.findAll();
    }

}
