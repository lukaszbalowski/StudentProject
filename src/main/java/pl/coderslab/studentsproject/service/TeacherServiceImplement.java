package pl.coderslab.studentsproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.studentsproject.model.Subject;
import pl.coderslab.studentsproject.model.Teacher;
import pl.coderslab.studentsproject.model.Class;
import pl.coderslab.studentsproject.repository.ClassRepository;
import pl.coderslab.studentsproject.repository.TeacherRepository;

import java.util.List;

@Service
public class TeacherServiceImplement implements TeacherService {

    private final TeacherRepository teacherRepository;

    private final SubjectService subjectService;

    private final ClassService classService;

    private final ClassRepository classRepository;

    public TeacherServiceImplement(TeacherRepository teacherRepository, SubjectService subjectService, ClassService classService, ClassRepository classRepository) {
        this.teacherRepository = teacherRepository;
        this.subjectService = subjectService;
        this.classService = classService;
        this.classRepository = classRepository;
    }


    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher getTeacherById(long id) {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid teacher ID: " + id));
    }

    @Override
    public Teacher saveTeacher(Teacher teacher) {

        return teacherRepository.save(teacher);
    }

    @Override
    public List<Subject> getAllSubjects() {

        return subjectService.getAllSubjects();
    }

    @Override
    public List<Class> getCLassesByTeacherId(long teacherId) {
        Teacher teacher = getTeacherById(teacherId);
        return teacher.getClasses();
    }



    @Override
    public void deleteTeacher(long id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid teacher ID: " + id));

        teacherRepository.delete(teacher);

    }

    @Override
    public void removeClassFromTeacher(long teacherId, long classId) {
        Teacher teacherToRemove = getTeacherById(teacherId);
        Class classObj = classService.getClassById(classId);
        classObj.removeTeacher(teacherToRemove);
        classRepository.save(classObj);
    }

}
