package com.example.ProgettoCasotto.api;

import com.example.ProgettoCasotto.models.Posto;
import com.example.ProgettoCasotto.services.Attrezatura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
        Posto std = postoDatiMg1.getPostobyID(qr_id);
        model.addAttribute("postxx",std);
        model.addAttribute("getAttr", Attrezatura.values());
        return "PrenotaMenu";
    }
/*
    @RequestMapping(value = "/id_posto",method = RequestMethod.GET)
    public ModelAndView  GoFormStart(@RequestParam(value = "qr_id") String qr_id){
        ModelAndView mav = new ModelAndView("id_postox");
        Posto std = postoDatiMg1.getPostobyID(qr_id);
        mav.addObject("postxx", std);
        return mav;
    }*/



    @GetMapping("DettagliPosto.html")
    public String ListaPosti(Model model){
        model.addAttribute("stats",postoDatiMg1.getPosti());
        return "DettagliPosto";
    }

    @GetMapping("going_home")
    public String VaiLitaPosti(Model model){
        model.addAttribute("stats",postoDatiMg1.getPosti());
        return "DettagliPosto";
    }

    // POST METHOD
    @RequestMapping(value = "/going_home_tt",method = RequestMethod.POST)
    public String saveStudentlll( @ModelAttribute("postxx") Posto ps) {
        System.out.println(ps.toString());
        //postoDatiMg1.postoOccupa(ps);
        return "DettagliPosto";
    }

    //    @RequestMapping(value = "/save", method = RequestMethod.POST)
    //    public String saveStudent(@ModelAttribute("student") Student std) {
    //        service.save(std);
    //        return "redirect:/";
    //    }

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
