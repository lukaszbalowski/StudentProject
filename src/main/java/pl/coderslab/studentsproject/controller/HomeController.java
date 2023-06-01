package pl.coderslab.studentsproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {


    @GetMapping("/")
    public String showHome() {
        return "index";
    }

    @RequestMapping("/notyet")
    public String showNotYet() {
        return "notyet";
    }

}





