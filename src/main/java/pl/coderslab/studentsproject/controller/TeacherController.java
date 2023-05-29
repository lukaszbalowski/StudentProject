package pl.coderslab.studentsproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.coderslab.studentsproject.model.Teacher;
import pl.coderslab.studentsproject.model.Subject;
import pl.coderslab.studentsproject.service.TeacherService;

import java.util.List;

@Controller
public class TeacherController {

    @Autowired
    private TeacherService teacherService;


    @GetMapping("/list/teachers")
    public String getTeacherList(Model model) {
        model.addAttribute("teachers", teacherService.getAllTeachers());
        return "teacherslist";
    }

    @GetMapping ("/teacher/details/{id}")
    public String showTeacherDetails(@PathVariable("id") long id, Model model) {
        Teacher teacher = teacherService.getTeacherById(id);
        List<Subject> subjects = teacher.getSubjects();
        model.addAttribute("teacher", teacher);
        model.addAttribute("subjects", subjects);
        return "teacherdetails";

    }


}
