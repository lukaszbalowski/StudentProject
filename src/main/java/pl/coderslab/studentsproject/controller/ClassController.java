package pl.coderslab.studentsproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.studentsproject.service.ClassService;
import pl.coderslab.studentsproject.model.Class;

@Controller
public class ClassController {

    private final ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @GetMapping("/list/classes")
    public String getClassList (Model model) {
        model.addAttribute("classes", classService.getAllClasses());

        return "classes/classlist";
    }

    @GetMapping ("/classdetails/{id}")
    public String getClassDetails (@PathVariable("id") long classId, Model model) {
        Class classDetails = classService.getClassById(classId);
        model.addAttribute("classDetails", classDetails);
        return "classes/classdetails";
    }
    @GetMapping("classedit/{id}")
    public String getCLassEtidForm(@PathVariable("id") long classId, Model model) {
        Class classDetails = classService.getClassById(classId);
        model.addAttribute("classDetails", classDetails);
        return "classes/classedit";
    }

    @PostMapping("/classedit/{id}")
    public String updateClass(@PathVariable("id") long classId, @RequestParam("className") String className, @RequestParam("classDescription") String classDescription) {
        Class classDetails = classService.getClassById(classId);
        classDetails.setClassName(className);
        classDetails.setDescription(classDescription);
        classService.saveClass(classDetails);
        return "redirect:/list/classes";
    }


}
