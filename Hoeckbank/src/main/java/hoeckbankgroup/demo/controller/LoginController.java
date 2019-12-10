package hoeckbankgroup.demo.controller;

import hoeckbankgroup.demo.model.DAO.KlantDAO;
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
        boolean loginTrue = loginTrueFalse(gebruikerNaam, gebruikerWachtwoord);
        if(loginTrue){
            return "testaccount";
        } else {
            model.addAttribute("login_error", "Gebruiker / wachtwoord combi niet geldig");
            return "login";
        }
    }

    private boolean loginTrueFalse(String gebruikerNaam, String gebruikerWachtwoord) {
        // Hulpmethode: Checkt of klant bestaat en wachtwoord overeenkomt
        TestKlant klant = klantDAO.findKlantByGebruikersnaam(gebruikerNaam);
        if (klant != null) {
            if (klant.getWachtwoord().equals(gebruikerWachtwoord)) {
                return true;
            }
        }
        return false;
    }

}
