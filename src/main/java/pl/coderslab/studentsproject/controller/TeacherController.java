package pl.coderslab.studentsproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.studentsproject.model.Teacher;
import pl.coderslab.studentsproject.model.Subject;
import pl.coderslab.studentsproject.service.SubjectService;
import pl.coderslab.studentsproject.service.TeacherService;

import java.util.List;

@Controller  // todo poprawić wszystkie ścieżki. pomyśl o @RequestMapping ("teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private SubjectService subjectService;


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

    @GetMapping ("/teacher/edit/{id}")
    public String showTeacherEditForm(@PathVariable("id") long id, Model model) {
        Teacher teacher = teacherService.getTeacherById(id);
        List<Subject> subjects = subjectService.getAllSubjects();
        model.addAttribute("teacher", teacher);
//        model.addAttribute("subjects", subjects);
        return "teacheredit";
    }

    @PostMapping ("/teacher/edit/{id}")
    public String saveTeacherEditForm(@PathVariable("id") long id, @ModelAttribute ("teacher") Teacher teacher) {
        Teacher existingTeacher = teacherService.getTeacherById(id);
        existingTeacher.setFirstName(teacher.getFirstName());
        existingTeacher.setLastName(teacher.getLastName());
        existingTeacher.setEmail(teacher.getEmail());
        existingTeacher.setPhone(teacher.getPhone());
        teacherService.saveTeacher(existingTeacher);

        return "redirect:/teacher/details/{id}";
    }

    @GetMapping("/teacher/delete/{id}")
    public String deleteTeacher(@PathVariable("id") long id) {
        teacherService.deleteTeacher(id);
        return "redirect:/list/teachers";
    }

    @GetMapping ("/teacher/add")
    public String showAddTeacherForm(Model model) {
        model.addAttribute("teacher", new Teacher());
        return "addteacher";

    }

    @PostMapping ("/teacher/save")
        public String saveTeacher(Teacher teacher) {
        teacherService.saveTeacher(teacher);
        return "redirect:/list/teachers";
        }




}
