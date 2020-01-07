package hoeckbankgroup.demo.controller;


import hoeckbankgroup.demo.model.Klant;
import hoeckbankgroup.demo.model.Particulier;
import hoeckbankgroup.demo.model.Gebruiker;
import hoeckbankgroup.demo.model.service.KlantService;
import hoeckbankgroup.demo.model.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("gebruiker")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private KlantService klantService;

    @PostMapping("do_login")
    public String doLoginHandler(@RequestParam(name = "gebruiker_naam") String email,
                                 @RequestParam(name = "gebruiker_paswoord") String gebruikerWachtwoord,
                                 Model model) {
        if (loginService.validatePassword(email, gebruikerWachtwoord)) {
            Klant klant = klantService.findKlantByEmail(email);
            return setup(klant, model);
        } else {
            model.addAttribute("login_error", "Gebruiker / wachtwoord combi niet geldig");
            return "Login";
        }
    }

    public String setup(Klant klant, Model model){
        if (klant instanceof Particulier) {
            Gebruiker gebruiker = new Gebruiker(klant.getPersonId(), klant.getRekeningen(), "Particulier");
            model.addAttribute("gebruiker", gebruiker);
            return "redirect:/rekeningenoverzicht";

        } else {
            Gebruiker gebruiker = new Gebruiker(klant.getPersonId(), klant.getRekeningen(), "MKB");
            model.addAttribute("gebruiker", gebruiker);
            return "redirect:/rekeningenoverzicht";
        }
    }
}
