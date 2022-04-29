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

    @RequestMapping(value = "/posti_disponibili",method = RequestMethod.GET)
    public String SelectPosto(Model model,@RequestParam(value = "numero_selezionato") String numero_selezionato){
        model.addAttribute("posti",postoDatiMg1.getPostCap(Integer.parseInt(numero_selezionato)));
        return "ListaPostiSeleziona";
    }

    @RequestMapping(value = "/id_posto",method = RequestMethod.GET)
    public String StartForm(Model model,@RequestParam(value = "qr_id") String qr_id){
        Posto std = postoDatiMg1.getPostobyID(qr_id);
        model.addAttribute("posto",std);
        model.addAttribute("getAttr", Attrezatura.values());
        return "PrenotaMenu";
    }


    @GetMapping("/vedi_lista")
    public String ListaPosti(Model model){
        model.addAttribute("posti",postoDatiMg1.getPosti());
        model.addAttribute("next_path","/");//btn_txt
        model.addAttribute("btn_txt","Indietro");
        return "DettagliPosto";
    }

    // POST METHOD
    @RequestMapping(value = "/show_new_list",method = RequestMethod.POST)
    public String Partecipa(Model model, @ModelAttribute("posto") Posto ps) {
        System.out.println(ps.toString());
        postoDatiMg1.update_posto(ps);

        model.addAttribute("posti",postoDatiMg1.getPosti());
        model.addAttribute("next_path","home");
        model.addAttribute("btn_txt","fine prenotazione");
        return "DettagliPosto";
    }

    @GetMapping("/home")
    public String goHome(){
        return "HomeMenu";
    }

    @GetMapping("/start")
    public String Start(){
        return "InizioMenu";
    }

    @GetMapping("/numero_partecipanti")
    public String selectNumbers(Model model){
        model.addAttribute("numero",3);
        return "NumeroPrenotazioni";
    }

    @GetMapping("/prenota")
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
