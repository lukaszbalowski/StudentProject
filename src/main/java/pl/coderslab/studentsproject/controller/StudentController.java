package pl.coderslab.studentsproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private StudentService studentService;

    @Autowired
    private ParentService parentService;

    @Autowired
    private ClassService classService;


    @GetMapping ("/list/students")
    public String getStudentsList(Model model) {
     model.addAttribute("students", studentService.getAllStudents());
        return "studentslist";
    }


    @PostMapping("/list/students/search")
    public String searchStudents(@RequestParam("lastName") String lastName, Model model) {
        List<Student> foundStudents = studentService.searchStudentsByLastName(lastName);
        model.addAttribute("students", foundStudents);
        return "studentslist";
    }



    @PostMapping("/list/students/filter")
    public String filterStudents(@RequestParam("classId") int classId, Model model) {
        if (classId == 0) {
            return getStudentsList(model);
        }

        List<Student> filteredStudents = studentService.filterStudentsByClassId(classId);
        model.addAttribute("students", filteredStudents);
        return "studentslist";
    }

    @GetMapping("/student/details/{studentId}")
    public String showStudentDetails(@PathVariable("studentId") String studentId, Model model) {
        Student student = studentService.getStudentById(Long.parseLong(studentId));
        Parent parent = parentService.getParentById(student.getParentId());
        Class studentClass = classService.getClassById(student.getClassId());

        model.addAttribute("student", student);
        model.addAttribute("parent", parent);
        model.addAttribute("studentClass", studentClass);
        return "studentdetails";

    }

    @GetMapping("/student/add")
    public String addStudentForm(Model model) {
        Student student  = new Student();
        model.addAttribute("student", student);
        return "addstudent";


    }


//    @PostMapping("/saveStudent")
//    public String saveStudent(@ModelAttribute("student") Student student) {
//        studentService.addStudent(student);
//        return "redirect:/list/students";
//    }


    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student) {
        // save employee to database
        studentService.saveStudent(student);
        return "redirect:/";
    }

    @GetMapping ("/student/edit/{id}")
    public String editStudentForm(@PathVariable (value = "id") long id, Model model) {
        // get student from the service
        Student student = studentService.getStudentById(id);

        // set student as a model attribute to pre-populate the form
        model.addAttribute("student", student);
        return "editstudent";
    }



}
