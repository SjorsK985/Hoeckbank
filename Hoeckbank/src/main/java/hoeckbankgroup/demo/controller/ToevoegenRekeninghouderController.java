package hoeckbankgroup.demo.controller;

import hoeckbankgroup.demo.model.Gebruiker;
import hoeckbankgroup.demo.model.Koppel;
import hoeckbankgroup.demo.model.service.KlantService;
import hoeckbankgroup.demo.model.service.KoppelService;
import hoeckbankgroup.demo.model.service.RekeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class ToevoegenRekeninghouderController {

    @Autowired
    private RekeningService rekeningService;

    @Autowired
    private KlantService klantService;

    @Autowired
    private KoppelService koppelService;

    @GetMapping("toevoegenrekeninghouder")
    private String toevoegenRekeninghouderHandler(@SessionAttribute("gebruiker") Gebruiker gebruiker, Model model){
        return "toevoegenrekeninghouder";
    }
//    @PostMapping("do_toevoegen_rekeninghouder") //th:action in template
//    public String doToevoegenHandler(@RequestParam(name = "gebruiker_naam_nieuwe_rekeninghouder") String email, //in template aanwezig
//                                     @RequestParam(name = "beveiligingcode") int beveiligingscode,
//                                     Gebruiker gebruiker, Model model) {
//        if (koppelService.validateEmail(email)) {
//            Koppel koppel = new Koppel(gebruiker.getHuidigeRekeningnummer(), email, beveiligingscode);
//            koppelService.save(koppel);
//            //return statement moet er nog in.
//        } else {
//            model.addAttribute("koppel_error", "Gebruiker / wachtwoord combi niet geldig");
//            return "toeveogenrekeninghouder";
//        }
    }
