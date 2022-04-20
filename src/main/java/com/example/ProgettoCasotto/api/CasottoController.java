package com.example.ProgettoCasotto.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CasottoController {

    @GetMapping("HomeMenu.html")
    public String goHome(){
        return "HomeMenu";
    };

}
