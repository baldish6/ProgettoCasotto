package com.example.ProgettoCasotto.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AddettoPrenotazione {

    @Autowired
    PostoDatiMg postoDatiMg1;

    @GetMapping("/")
    public String home(){
        return "InizioMenu";
    }

    @GetMapping("/ListaPostiSeleziona.html")
    public String SelectPosti(Model model){
        model.addAttribute("stats",postoDatiMg1.getPostCap(1));
        return "ListaPostiSeleziona";
    }

    @GetMapping("DettagliPosto.html")
    public String ListaPosti(Model model){
        model.addAttribute("stats",postoDatiMg1.getPosti());
        return "DettagliPosto";
    }

    @GetMapping("InizioMenu.html")
    public String goHome(){
        return "InizioMenu";
    }

    //NumeroPrenotazioni.html
    @GetMapping("NumeroPrenotazioni.html")
    public String selectNumbers(Model model){
        model.addAttribute("numero",3);
        return "NumeroPrenotazioni";
    }

    //PrenotaMenu.html
    @GetMapping("PrenotaMenu.html")
    public String inputPosto(){
        return "PrenotaMenu";
    }


                /*
    @GetMapping("/")
    public ModelAndView getStatoSpiaggia(){
        return null;
    };
    @GetMapping("/")
    public String getPosto(){
        return null;
    };

    @RequestMapping("/delete/{id}")
    public String prenotaPosto(){return null;};*/
}
