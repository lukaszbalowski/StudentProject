package pl.coderslab.studentsproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.coderslab.studentsproject.model.Subject;
import pl.coderslab.studentsproject.service.SubjectService;

import java.util.List;

@Controller
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping("/list/subjects")
    public String getSubjectList(Model model) {
        List<Subject> subjectList = subjectService.getAllSubjects();
        model.addAttribute("subjectlist", subjectList);
        return "subjectlist";
    }

    @GetMapping("/subject/details/{id}")
    public String showSubjectDetails(@PathVariable("id") long id, Model model) {
        Subject subject = subjectService.getSubjectById(id);
        model.addAttribute("subject", subject);
        return "subjectdetails";
    }

}
