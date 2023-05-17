package pl.coderslab.studentsproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.studentsproject.service.StudentService;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping ("/")
    public String getHomeView (Model model) {
     model.addAttribute("students", studentService.getAllStudents());
        return "index";
    }

}
