package pl.coderslab.studentsproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.studentsproject.service.TeacherService;

@Controller
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/list/teachers")
    public String getTeacherList(Model model) {
        model.addAttribute("teachers", teacherService.getAllTeachers());
        return "teacherslist";
    }


}
