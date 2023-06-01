package pl.coderslab.studentsproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.studentsproject.model.Class;
import pl.coderslab.studentsproject.model.Teacher;
import pl.coderslab.studentsproject.model.Subject;
import pl.coderslab.studentsproject.service.ClassService;
import pl.coderslab.studentsproject.service.SubjectService;
import pl.coderslab.studentsproject.service.TeacherService;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Controller  // todo poprawić wszystkie ścieżki. pomyśl o @RequestMapping ("teacher")
public class TeacherController {

    private final TeacherService teacherService;

    private final SubjectService subjectService;

    public TeacherController(TeacherService teacherService, SubjectService subjectService) {
        this.teacherService = teacherService;
        this.subjectService = subjectService;
    }

    @Autowired
    ClassService classService;


    @GetMapping("/list/teachers")
    public String getTeacherList(Model model) {
        model.addAttribute("teachers", teacherService.getAllTeachers());
        return "teachers/teacherslist";
    }

    @GetMapping("/teacher/details/{id}")
    public String showTeacherDetails(@PathVariable("id") long id, Model model) {
        Teacher teacher = teacherService.getTeacherById(id);
        List<Subject> subjects = teacher.getSubjects();
        model.addAttribute("teacher", teacher);
        model.addAttribute("subjects", subjects);
        List<Class> classes = teacherService.getCLassesByTeacherId(id);
        model.addAttribute("classes", classes);
        return "teachers/teacherdetails";

    }

    @GetMapping("/teacher/edit/{id}")
    public String showTeacherEditForm(@PathVariable("id") long id, Model model) {
        Teacher teacher = teacherService.getTeacherById(id);
        List<Subject> allSubjects = subjectService.getAllSubjects();
        List<Class> allClasses = classService.getAllClasses();
        model.addAttribute("teacher", teacher);
        model.addAttribute("allSubjects", allSubjects);
        model.addAttribute("allClasses", allClasses);
        return "teachers/teacheredit";
    }

    @PostMapping("/teacher/edit/{id}")
    public String saveTeacherEditForm(@PathVariable("id") long id, @ModelAttribute("teacher") Teacher teacher,
                                      @RequestParam("subjectIds") List<Long> subjectIds) {
        Teacher existingTeacher = teacherService.getTeacherById(id);
        existingTeacher.setFirstName(teacher.getFirstName());
        existingTeacher.setLastName(teacher.getLastName());
        existingTeacher.setEmail(teacher.getEmail());
        existingTeacher.setPhone(teacher.getPhone());
        List<Subject> selectedSubjects = subjectService.getSubjectsByIds(subjectIds);
        existingTeacher.setSubjects(selectedSubjects);
        teacherService.saveTeacher(existingTeacher);

        return "redirect:/teacher/details/{id}";
    }

    @GetMapping("/teacher/delete/{id}")
    public String deleteTeacher(@PathVariable("id") long id) {
        teacherService.deleteTeacher(id);
        return "redirect:/list/teachers";
    }

    @GetMapping("/teacher/add")
    public String showAddTeacherForm(Model model) {
        model.addAttribute("teacher", new Teacher());
        return "teachers/addteacher";

    }

    @PostMapping("/teacher/save")
    public String saveTeacher(Teacher teacher) {
        teacherService.saveTeacher(teacher);
        return "redirect:/list/teachers";
    }


    @GetMapping("/teacher/delete-confirmation/{id}")
    public String showDeleteConfirmation(@PathVariable(value = "id") long id, Model model) {
        Teacher teacher = teacherService.getTeacherById(id);
        model.addAttribute("teacher", teacher);
        return "teachers/TeacherDeleteConfirmation";

    }

    @PostMapping ("/teacher/add-class/{id}")
    public String addClassToTeacher(@PathVariable("id") Long teacherId, @RequestParam("classId") Long classId) throws SQLIntegrityConstraintViolationException {
        Teacher teacher = teacherService.getTeacherById(teacherId);
        Class cls = classService.getClassById(classId);
//        teacher.addClass(cls);
        cls.addTeacher(teacher);
        teacherService.saveTeacher(teacher);

        return "redirect:/teacher/edit/{id}";

    }

    @PostMapping("/removeclass")
    public String removeClassFromTeacher(@RequestParam("teacherId") long teacherId,
                                         @RequestParam("classId") long classId) {
        teacherService.removeClassFromTeacher(teacherId, classId);
        return "redirect:/teacher/edit/" + teacherId;
    }

}
