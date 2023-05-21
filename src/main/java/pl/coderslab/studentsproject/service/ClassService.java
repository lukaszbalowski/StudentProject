package pl.coderslab.studentsproject.service;

import pl.coderslab.studentsproject.model.Class;

import java.util.List;

public interface ClassService {

    List<Class> getAllClasses();
    Class getClassById(long classId);


}
