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
        boolean loginTrue = loginTrueFalse(gebruikerNaam, gebruikerWachtwoord);
        if(loginTrue){
            return "testaccount";
        } else {
            model.addAttribute("login_error", "Gebruiker / wachtwoord combi niet geldig");
            return "login";
        }
    }

    private boolean loginTrueFalse(String gebruikerNaam, String gebruikerWachtwoord){
        boolean login = false;
        try{
            TestKlant klant = klantDAO.findKlantByGebruikersnaam(gebruikerNaam);
            String dbWachtwoord = klant.getWachtwoord();
            if(dbWachtwoord.equals(gebruikerWachtwoord)){
                login = true;
            }
        } catch (NullPointerException noUser){}
        return login;
    }

}
