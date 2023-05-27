package pl.coderslab.studentsproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.coderslab.studentsproject.service.ClassService;
import pl.coderslab.studentsproject.model.Class;

@Controller
public class ClassController {

    @Autowired
    private ClassService classService;

    @GetMapping("/list/classes")
    public String getClassList (Model model) {
        model.addAttribute("classes", classService.getAllClasses());

        return "classlist";
    }

    @GetMapping ("/classdetails/{id}")
    public String getClassDetails (@PathVariable("id") long classId, Model model) {
        Class classDetails = classService.getClassById(classId);
        model.addAttribute("classDetails", classDetails);
        return "classdetails";
    }
    @GetMapping("classedit/{id}")
    public String editClass(@PathVariable("id") long classId, Model model) {
        Class classDetails = classService.getClassById(classId);
        model.addAttribute("classDetails", classDetails);
        return "classedit";
    }


}
