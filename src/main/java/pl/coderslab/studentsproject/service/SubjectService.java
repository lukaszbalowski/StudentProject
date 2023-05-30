package pl.coderslab.studentsproject.service;

import pl.coderslab.studentsproject.model.Subject;

import java.util.List;

public interface SubjectService {

    List<Subject> getAllSubjects();


    List<Subject> getSubjectsByIds(List<Long> subjectIds);


    Subject getSubjectById(long id);
}
