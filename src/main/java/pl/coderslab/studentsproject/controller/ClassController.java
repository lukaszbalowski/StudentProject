package pl.coderslab.studentsproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.studentsproject.service.ClassService;

@Controller
public class ClassController {

    @Autowired
    private ClassService classService;

    @GetMapping("/list/classes")
    public String getClassList (Model model) {
        model.addAttribute("classes", classService.getAllClasses());

        return "classlist";
    }

}
