package pl.coderslab.studentsproject.controller;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.studentsproject.model.Parent;
import pl.coderslab.studentsproject.model.Student;
import pl.coderslab.studentsproject.model.Class;
import pl.coderslab.studentsproject.service.ClassService;
import pl.coderslab.studentsproject.service.ParentService;
import pl.coderslab.studentsproject.service.StudentService;


import java.util.List;

@Controller
public class StudentController {

    private final StudentService studentService;

    private final ParentService parentService;

    private final ClassService classService;

    public StudentController(StudentService studentService, ParentService parentService, ClassService classService) {
        this.studentService = studentService;
        this.parentService = parentService;
        this.classService = classService;
    }


    @GetMapping ("/list/students")
    public String getStudentsList(Model model) {
        return findPaginated(1, "lastName", "asc", model);
//     model.addAttribute("students", studentService.getAllStudents());
//        return "studentslist";
    }


    @PostMapping("/list/students/search")
    public String searchStudents(@RequestParam("lastName") String lastName, Model model) {
        List<Student> foundStudents = studentService.searchStudentsByLastName(lastName);
        model.addAttribute("studentList", foundStudents); // tutaj zmieniłem z "students" na "studentList"
        return "students/studentslist";
    }



    @PostMapping("/list/students/filter")
    public String filterStudents(@RequestParam("classId") int classId, Model model) {
        if (classId == 0) {
            return getStudentsList(model);
        }

        List<Student> filteredStudents = studentService.filterStudentsByClassId(classId);
        model.addAttribute("studentList", filteredStudents);   // tutaj zmieniłem z "students" na "studentList"
        return "students/studentslist";
    }

    @GetMapping("/student/details/{studentId}")
    public String showStudentDetails(@PathVariable("studentId") String studentId, Model model) {
        Student student = studentService.getStudentById(Long.parseLong(studentId));
        Parent parent = parentService.getParentById(student.getParentId());
        Class studentClass = classService.getClassById(student.getClassId());

        model.addAttribute("student", student);
        model.addAttribute("parent", parent);
        model.addAttribute("studentClass", studentClass);
        return "students/studentdetails";

    }

//    @GetMapping("/student/add")
//    public String addStudentForm(Model model) {
//        Student student  = new Student();
//        model.addAttribute("student", student);
//        return "addstudent";
//
//    }


//    @PostMapping("/saveStudent")
//    public String saveStudent(@ModelAttribute("student") Student student) {
//        studentService.addStudent(student);
//        return "redirect:/list/students";
//    }

//
    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student) {

        studentService.saveStudent(student);
        return "redirect:/";
    }

    @GetMapping ("/student/edit/{id}")
    public String editStudentForm(@PathVariable (value = "id") long id, Model model) {

        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        List<Parent> parents = parentService.getAllParentsSortedByIdDesc();
        model.addAttribute("parents", parents);
        return "students/editstudent";
    }

    @GetMapping ("/student/delete/{id}")
    public String deleteStudent(@PathVariable (value = "id") long id) {

        this.studentService.deleteStudent(id);
        return "redirect:/list/students";
    }

    @GetMapping("list/students/page/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 10;

        Page <Student> page = studentService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List <Student> studentList = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("studentList", studentList);
        return "/students/studentslist";
    }

    @GetMapping ("/addstudent")
    public String showAddStudentForm(Model model) {
        model.addAttribute("student", new Student());
        List<Parent> parents = parentService.getAllParentsSortedByIdDesc();
        model.addAttribute("parents", parents);
        return "students/addstudent";
    }

    @GetMapping ("/delete-confirmation/{id}")
    public String showDeleteConfirmation(@PathVariable (value = "id") long id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "students/studentdeleteconfirmation";
    }

}
