package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ThreadLocalRandom;

@Controller
 class DiceRollController {
    @GetMapping("/roll-dice/{n}")
    public String rollDiceUser(@PathVariable int n, Model model) {
        int randomNum = ThreadLocalRandom.current().nextInt(1,6+1);
        model.addAttribute("randomNumber", randomNum);
        model.addAttribute("userGuess", n);
        model.addAttribute("isUserGuessCorrect", n == randomNum);
        return "roll-dice";
    }

    @GetMapping("/roll-dice")
    public String rollDice() {
        return "roll-dice";
    }
}
