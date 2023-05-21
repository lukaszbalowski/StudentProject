package pl.coderslab.studentsproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.studentsproject.model.Parent;
import pl.coderslab.studentsproject.model.Student;
import pl.coderslab.studentsproject.model.Class;
import pl.coderslab.studentsproject.service.ClassService;
import pl.coderslab.studentsproject.service.ParentService;
import pl.coderslab.studentsproject.service.StudentService;


import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ParentService parentService;

    @Autowired
    private ClassService classService;


    @GetMapping ("/list/students")
    public String getStudentsList(Model model) {
     model.addAttribute("students", studentService.getAllStudents());
        return "studentslist";
    }


    @PostMapping("/list/students/search")
    public String searchStudents(@RequestParam("lastName") String lastName, Model model) {
        List<Student> foundStudents = studentService.searchStudentsByLastName(lastName);
        model.addAttribute("students", foundStudents);
        return "studentslist";
    }



    @PostMapping("/list/students/filter")
    public String filterStudents(@RequestParam("classId") int classId, Model model) {
        if (classId == 0) {
            return getStudentsList(model);
        }

        List<Student> filteredStudents = studentService.filterStudentsByClassId(classId);
        model.addAttribute("students", filteredStudents);
        return "studentslist";
    }

    @GetMapping("/student/details/{studentId}")
    public String showStudentDetails(@PathVariable("studentId") String studentId, Model model) {
        Student student = studentService.getStudentById(Long.parseLong(studentId));
        Parent parent = parentService.getParentById(student.getParentId());
//        Class studentClass = studentService.getStudentById(Long.parseLong(studentId)).getStudentClass();
        Class studentClass = classService.getClassById(student.getClassId());

        model.addAttribute("student", student);
        model.addAttribute("parent", parent);
        model.addAttribute("studentClass", studentClass);
        return "studentdetails";

    }

}
