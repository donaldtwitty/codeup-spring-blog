package edu.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import edu.codeup.codeupspringblog.models.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Controller
public class RollDiceController {

//    @GetMapping("/roll-dice")
//    public String rollDice(Model model) {
//        model.addAttribute("guesses", Arrays.asList(1, 2, 3, 4, 5, 6));
//        return "roll-dice";
//    }

    @GetMapping("/roll-dice")
    public String rollDice(Model model) {
        List<Integer> rolls = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            rolls.add((int) Math.random() * 6 + 1);
        }
        model.addAttribute("rolls", rolls);
        return "roll-dice";
    }


    @GetMapping("/roll-dice/{guess}")
    public String rollDice(@PathVariable int guess, Model model) {
        boolean correct;
        int randomNumber = (int) (Math.random() * 6) + 1;
        model.addAttribute("guess", Collections.singletonList(guess));
        model.addAttribute("randomNumber", Collections.singletonList(randomNumber));
        correct = guess == randomNumber;
        model.addAttribute("correct", Collections.singletonList(Integer.valueOf(String.valueOf(correct))));
        return "roll-dice";
    }
}
