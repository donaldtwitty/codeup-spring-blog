package edu.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
//    @GetMapping("/{page}")
//    @ResponseBody
//    public String landingPage(@PathVariable String page) {
//        return String.format("Hello this is the landing,  %s!", page);

    @GetMapping("/home")
    public String welcome() {
        return "home";
    }
}
