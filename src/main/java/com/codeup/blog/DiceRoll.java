package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
 class DiceRoll {
    @GetMapping("/roll-dice")
    @ResponseBody
    public int userInput(int n){
       return 0;
    }

}
