package edu.codeup.codeupspringblog.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {
    @GetMapping("/add/{firstNumber}/{secondNumber}")
    public int add(@PathVariable("firstNumber") int firstNumber, @PathVariable("secondNumber") int secondNumber) {
        return firstNumber + secondNumber;
    }
    @GetMapping("/subtract/{firstNumber}/{secondNumber}")
    public int subtract(@PathVariable("firstNumber") int firstNumber, @PathVariable("secondNumber") int secondNumber) {
        return firstNumber - secondNumber;
    }

    @GetMapping("/multiply/{firstNumber}/{secondNumber}")
    public int multiply(@PathVariable("firstNumber") int firstNumber, @PathVariable("secondNumber") int secondNumber) {
        return firstNumber * secondNumber;
    }

    @GetMapping("/divide/{firstNumber}/{secondNumber}")
    public int divide(@PathVariable("firstNumber") int firstNumber, @PathVariable("secondNumber") int secondNumber) {
        return firstNumber / secondNumber;
    }
}
