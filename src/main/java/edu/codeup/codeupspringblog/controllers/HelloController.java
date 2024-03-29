package edu.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/world")
    @ResponseBody
    public String helloWorld(){
        System.out.println("Inside HelloController helloWorld method");
        return "Hello World!";
    }

    @GetMapping("/{name}")
    @ResponseBody
    public String helloName(@PathVariable String name){
        return String.format ("Hello,  %s!", name);
        //same as above:
//        return "Hello, " + name + "!";
    }

}
