package hoeckbankgroup.demo.model.service;

import hoeckbankgroup.demo.model.DAO.KlantDAO;
import hoeckbankgroup.demo.model.Klant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private KlantDAO klantDAO;

    public boolean validatePassword(String email, String gebruikerWachtwoord){
        Klant klant = klantDAO.findKlantByEmail(email);
        if (klant == null){
        return false;
        } else return klant.getWachtwoord().equals(gebruikerWachtwoord);
    }

}
