package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
 class DiceRoll {
    @GetMapping("/roll-dice")
    @ResponseBody
    public String userInput(int x){
       return "Rolled number is: 5";
    }
    @GetMapping("/roll-dice/{n}")
   @ResponseBody
   public String diceOne(@RequestParam(name = "aNumber") int n) {
      return "You're guessed number is: " + n;
    }

}
