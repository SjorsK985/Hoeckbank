package hoeckbankgroup.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @PostMapping("do_login")
    public String doLoginHandler(@RequestParam(name = "gebruiker_naam") String gebruikerNaam,
                                 @RequestParam(name = "gebruiker_paswoord") String gebruikerWachtwoord,
                                 Model model ){
        if(gebruikerNaam.equals("ling") && gebruikerWachtwoord.equals("geheim")){
            return "persoonlijke_pagina_template";
        } else{
            model.addAttribute("header_text", "Naam/password combi niet bekend.");
            return "login_template";
        }
    }
}
