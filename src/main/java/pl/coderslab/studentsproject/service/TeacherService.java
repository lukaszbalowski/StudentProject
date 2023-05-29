package pl.coderslab.studentsproject.service;

import pl.coderslab.studentsproject.model.Subject;
import pl.coderslab.studentsproject.model.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> getAllTeachers();

    Teacher getTeacherById(long id);

    Teacher saveTeacher(Teacher teacher);

    List<Subject> getAllSubjects();
}
