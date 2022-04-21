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

    @RequestMapping(value = "/NumeroPrenotazioni",method = RequestMethod.GET)
    public String Selectpss(Model model,@RequestParam(value = "numero_selezionato") String numero_selezionato){
        model.addAttribute("stats",postoDatiMg1.getPostCap(Integer.parseInt(numero_selezionato)));
        return "ListaPostiSeleziona";
    }

    @RequestMapping(value = "/id_posto",method = RequestMethod.GET)
    public String StartForm(Model model,@RequestParam(value = "qr_id") String qr_id){
        model.addAttribute("id_forma",qr_id);
        return "PrenotaMenu";
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
