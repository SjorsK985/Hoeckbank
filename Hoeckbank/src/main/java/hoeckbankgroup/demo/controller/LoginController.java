package hoeckbankgroup.demo.controller;


import hoeckbankgroup.demo.model.Klant;
import hoeckbankgroup.demo.model.Particulier;
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
            model.addAttribute("gebruiker", klant);
            return setup(klant);
        } else {
            model.addAttribute("Login_error", "Gebruiker / wachtwoord combi niet geldig");
            return "Login";
        }
    }

    public String setup(Klant klant){
        if (klant instanceof Particulier) {
            System.out.println("Particulier");
            return "Login";
        } else {
            System.out.println("MKB");
            return "Login";
        }
    }

}
