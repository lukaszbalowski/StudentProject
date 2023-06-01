package pl.coderslab.studentsproject.service;

import pl.coderslab.studentsproject.model.Subject;
import pl.coderslab.studentsproject.model.Teacher;
import pl.coderslab.studentsproject.model.Class;

import java.util.List;

public interface TeacherService {

    List<Teacher> getAllTeachers();

    Teacher getTeacherById(long id);

    Teacher saveTeacher(Teacher teacher);

    List<Subject> getAllSubjects();

    List<Class> getCLassesByTeacherId(long teacherId);

//    List<Class> getClassesByTeacherId(long teacherId);

    void deleteTeacher(long id);

    void removeClassFromTeacher(long teacherId, long classId);
}
