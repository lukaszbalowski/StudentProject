package pl.coderslab.studentsproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.studentsproject.model.Parent;
import pl.coderslab.studentsproject.model.Student;
import pl.coderslab.studentsproject.service.ParentService;
import pl.coderslab.studentsproject.service.StudentService;


import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

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


}
