package hoeckbankgroup.demo.controller;

import hoeckbankgroup.demo.model.Medewerker;
import hoeckbankgroup.demo.model.service.LoginMedewerkerService;
import hoeckbankgroup.demo.model.service.MedewerkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("medewerker")
public class LoginControllerMedewerker {

    @Autowired
    private LoginMedewerkerService loginMedewerkerService;

    @Autowired
    private MedewerkerService medewerkerService;

    @PostMapping("do_loginmedwerker")
    public String doLoginHandler(@RequestParam(name = "gebruiker_naam") String email,
                                 @RequestParam(name = "gebruiker_paswoord") String gebruikerWachtwoord,
                                 Model model) {
        if (loginMedewerkerService.validatePassword(email, gebruikerWachtwoord)) {
            Medewerker medewerker = medewerkerService.findMedewerkerByEmail(email);
            return setup(medewerker, model);
        } else {
            model.addAttribute("login_error", "Gebruiker / wachtwoord combi niet geldig");
            return "login_medewerker";
        }
    }
    public String setup(Medewerker medewerker, Model model){
        if (medewerker.getFunctie()=="HoofdParticulier") {
            model.addAttribute("medewerker", medewerker);
            return "redirect:/rekeningenoverzicht";

        } else {
            model.addAttribute("medewerker", medewerker);
            return "redirect:/rekeningenoverzicht";
        }
    }
}