package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
 class DiceRoll {
    @GetMapping("/roll-dice")
    @ResponseBody
    public String userInput(int x){
       return "Rolled number is: 5";
    }
    @PostMapping("/roll-dice/{n}")
   @ResponseBody
   public String joinDice(@RequestParam(name = "aNumber") int n, Model model) {
        model.addAttribute("aNumber", "You guessed " + n);
        if (n != 5){
            return ("You guessed incorrect!");
        }else{
            return ("You guessed correct");
        }
    }

}
