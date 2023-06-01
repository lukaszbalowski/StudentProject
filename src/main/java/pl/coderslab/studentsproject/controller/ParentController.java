package pl.coderslab.studentsproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

//        model.addAttribute("parents", parentService.getAllParents());
//                return "parentslist";
        return findPaginated(1, "firstName", "asc", model);
    }

    @PostMapping("/addparent")
    public String addParent(@RequestParam("firstName") String firstName,
                            @RequestParam("lastName") String lastName,
                            @RequestParam("email") String email,
                            @RequestParam("phone") String phone) {

        Parent parent = new Parent(firstName, lastName, email, phone);

        parentRepository.save(parent);

//        Long parentId = parent.getId();

        return "redirect:/addstudent";
    }

    @GetMapping("/addparentform")
    public String addParentForm() {

        return "parents/addparentform";
    }

    @GetMapping ("/parent/details/{id}")
    public String showParentDetails(@PathVariable("id") long id, Model model) {
        Parent parent = parentService.getParentById(id);
        List<Student> studentsByParentId = studentService.getStudentsByParentId(id);
        model.addAttribute("parent", parent);
        model.addAttribute("studentsByParentId", studentsByParentId);
        return "parents/parentdetails";
    }

    @GetMapping("/parent/edit/{parentId}")
    public String showEditParentForm(@PathVariable long parentId, Model model) {
        Parent parent = parentService.getParentById(parentId);
        model.addAttribute("parent", parent);
        return "parents/editparent";
    }


    @PostMapping ("/parent/edit/{parentId}")
    public String processEditParentForm(@PathVariable long parentId, @ModelAttribute("parent") Parent parent) {
        parent.setId(parentId);
        parentService.updateParent(parent);
        return "redirect:/parent/details/{parentId}";

    }

    @GetMapping ("/list/parents/page/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 10;


        Page<Parent> page = parentService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Parent> parents = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        model.addAttribute("parentsList", parents);

        return "parents/parentslist";
    }



}
