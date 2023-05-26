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
import pl.coderslab.studentsproject.repository.ParentRepository;
import pl.coderslab.studentsproject.service.ParentService;
import pl.coderslab.studentsproject.service.StudentService;

import java.util.List;

@Controller
public class ParentController {

    @Autowired
    private ParentService parentService;

    @Autowired
    private ParentRepository parentRepository;

    @Autowired
    private StudentService studentService;

    @Autowired
    public ParentController (ParentService parentService) {
        this.parentService = parentService;
    }

    @GetMapping("/list/parents")
    public String getParentsList(Model model) {
        model.addAttribute("parents", parentService.getAllParents());
        return "parentslist";
    }

    @PostMapping("/addparent")
    public String addParent(@RequestParam("firstName") String firstName,
                            @RequestParam("lastName") String lastName,
                            @RequestParam("email") String email,
                            @RequestParam("phone") String phone) {
        // Tworzenie nowego rodzica
        Parent parent = new Parent(firstName, lastName, email, phone);

        // Zapis rodzica w bazie danych
        parentRepository.save(parent);

        // Pobranie numeru Id nowo dodanego rodzica
        Long parentId = parent.getId();

        // Przekierowanie do widoku "addstudent.html" z przekazaniem numeru Id rodzica
        return "redirect:/addstudent";
    }

    @GetMapping("/addparentform")
    public String addParentForm() {
        return "addparentform";
    }

    @GetMapping ("/parent/details/{id}")
    public String showParentDetails(@PathVariable("id") long id, Model model) {
        Parent parent = parentService.getParentById(id);
        List<Student> studentsByParentId = studentService.getStudentsByParentId(id);
        model.addAttribute("parent", parent);
        model.addAttribute("studentsByParentId", studentsByParentId);
        return "parentdetails";
    }

}
