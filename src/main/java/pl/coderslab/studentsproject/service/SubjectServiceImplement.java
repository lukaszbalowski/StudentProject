package pl.coderslab.studentsproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.studentsproject.model.Subject;
import pl.coderslab.studentsproject.repository.SubjectRepository;

import java.util.List;

@Service
public class SubjectServiceImplement implements SubjectService  {

    final
    SubjectRepository subjectRepository;

    public SubjectServiceImplement(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }


    @Override
    public List<Subject> getAllSubjects() {

        return subjectRepository.findAll();


    }

    @Override
    public List<Subject> getSubjectsByIds(List<Long> subjectIds) {
        return subjectRepository.findAllById(subjectIds);
    }

    @Override
    public Subject getSubjectById(long id) {
        return subjectRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid subject Id:" + id));

    }
}
