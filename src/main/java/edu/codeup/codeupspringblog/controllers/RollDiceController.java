package edu.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String rollDice(Model model) {
        model.addAttribute("guesses", Arrays.asList(1, 2, 3, 4, 5, 6));
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{guess}")
    public String rollDice(@PathVariable int guess, Model model) {
        int randomNumber = (int) Math.random() * 6 + 1;
        model.addAttribute("guess", guess);
        model.addAttribute("randomNumber", randomNumber);
        model.addAttribute("correct", guess == randomNumber);
        return "roll-dice";
    }
}

