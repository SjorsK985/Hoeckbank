package hoeckbankgroup.demo.controller;

import hoeckbankgroup.demo.model.KlantDAO;
import hoeckbankgroup.demo.model.TestKlant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private KlantDAO klantDAO;

    @PostMapping("do_login")
    public String doLoginHandler(@RequestParam(name = "gebruiker_naam") String gebruikerNaam,
                                 @RequestParam(name = "gebruiker_paswoord") String gebruikerWachtwoord,
                                 Model model ){
        String dbWachtwoord;
        // Probeer wachtwoord van gebruiker op te halen
        try{
            TestKlant klant = klantDAO.findKlantByGebruikersnaam(gebruikerNaam);
            dbWachtwoord = klant.getWachtwoord();
        } catch (NullPointerException noUser){
            model.addAttribute("login_error", "Gebruiker / wachtwoord combi niet geldig");
            return "login";
        }
        // Stuur gebruiker door als password klopt
        if(dbWachtwoord.equals(gebruikerWachtwoord)){
            return "testaccount";
        } else {
            model.addAttribute("login_error", "Gebruiker / wachtwoord combi niet geldig");
            return "login";
        }
    }
}
