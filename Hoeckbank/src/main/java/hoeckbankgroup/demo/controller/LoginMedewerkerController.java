package hoeckbankgroup.demo.controller;

import hoeckbankgroup.demo.model.Klant;
import hoeckbankgroup.demo.model.Medewerker;
import hoeckbankgroup.demo.model.Rekening;
import hoeckbankgroup.demo.model.service.LoginMedewerkerService;
import hoeckbankgroup.demo.model.service.MedewerkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("medewerker")
public class LoginMedewerkerController {

    @Autowired
    private LoginMedewerkerService loginMedewerkerService;

    @Autowired
    private MedewerkerService medewerkerService;

    @PostMapping("do_loginmedewerker")
    public String doLoginHandler(@RequestParam(name = "gebruiker_naam") String email,
                                 @RequestParam(name = "gebruiker_paswoord") String gebruikerWachtwoord,
                                 Model model) {
        if (loginMedewerkerService.validatePassword(email, gebruikerWachtwoord)) {
            Medewerker medewerker = medewerkerService.findMedewerkerByEmail(email);
            return setup(medewerker, model);
        } else {
            model.addAttribute("header_text", "Probeer nog eens in te loggen als medewerker");
            model.addAttribute("login_error", "Gebruiker / wachtwoord combi niet geldig");
            return "login_medewerker";
        }
    }
    public String setup(Medewerker medewerker, Model model){
        if (medewerker.getFunctie().equals("HoofdParticulier")) {
            List<Rekening> rekeningList = medewerkerService.rekeningenHoogsteSaldo();
            model.addAttribute("rekeningen",rekeningList);
            model.addAttribute("medewerker", medewerker);

            return "hoofdparticulier";

        } else {
            model.addAttribute("medewerker", medewerker);
            return "redirect:/rekeningenoverzicht";
        }
    }
}