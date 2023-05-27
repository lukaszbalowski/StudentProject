package pl.coderslab.studentsproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.studentsproject.service.SubjectService;

@Controller
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping("/list/subjects")
    public String getSubjectList(Model model) {
        model.addAttribute("subjectlist", subjectService.getAllSubjects());
        return "subjectlist";
    }

}
