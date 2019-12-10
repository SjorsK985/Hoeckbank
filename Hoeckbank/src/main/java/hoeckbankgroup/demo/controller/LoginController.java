package hoeckbankgroup.demo.controller;

import hoeckbankgroup.demo.model.MKB;
import hoeckbankgroup.demo.model.Particulier;
import hoeckbankgroup.demo.model.Persoon;
import hoeckbankgroup.demo.model.service.PersoonService;
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
    private PersoonService persoonService;

    @PostMapping("do_login")
    public String doLoginHandler(@RequestParam(name = "gebruiker_naam") String gebruikerNaam,
                                 @RequestParam(name = "gebruiker_paswoord") String gebruikerWachtwoord,
                                 Model model) {
        if (loginService.validatePassword(gebruikerNaam, gebruikerWachtwoord)) {
            Persoon persoon = persoonService.findPersoonByName(gebruikerNaam);
            model.addAttribute("gebruiker", persoon);
            return setup(persoon);
        } else {
            model.addAttribute("Login_error", "Gebruiker / wachtwoord combi niet geldig");
            return "Login";
        }
    }

    public String setup(Persoon persoon){
        if (persoon instanceof Particulier) {
            System.out.println("Particulier");
            return "Login";
        } else {
            System.out.println("MKB");
            return "Login";
        }
    }

}
