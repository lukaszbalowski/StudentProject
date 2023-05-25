package pl.coderslab.studentsproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.coderslab.studentsproject.model.Student;
import pl.coderslab.studentsproject.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImplement implements StudentService {


    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> searchStudentsByLastName(String lastName) {
        return studentRepository.findByLastName(lastName);
    }

    @Override
    public List<Student> filterStudentsByClassId(int classId) {
        return studentRepository.findByClassId(classId);
    }

//    @Override
//    public Student getStudentById(long studentId) {
//        return studentRepository.findById(studentId)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid student ID: " + studentId));
//    }

    @Override
    public Student getStudentById(long id) {
        Optional<Student> optional = studentRepository.findById(id);
        Student student = null;
        if (optional.isPresent()) {
            student = optional.get();
        } else {
            throw new RuntimeException(" Student not found for id :: " + id);
        }
        return student;
    }

    @Override
    public void deleteStudent(long id) {
        this.studentRepository.deleteById(id);
    }

//    @Override
//    public Page<Student> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
//        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
//                Sort.by(sortField).descending();
//        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
//        return this.studentRepository.findAll(pageable);
//
//    }

    @Override
    public Page<Student> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.studentRepository.findAll(pageable);
    }






    @Override
    public void saveStudent(Student student) {
        this.studentRepository.save(student);
    }

    }



