package hoeckbankgroup.demo.model.service;

import hoeckbankgroup.demo.model.DAO.KlantDAO;
import hoeckbankgroup.demo.model.Klant;
import hoeckbankgroup.demo.model.TestKlant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private KlantDAO klantDAO;

    public boolean validatePassword(String gebruikerNaam, String gebruikerWachtwoord){
        TestKlant k = klantDAO.findKlantByGebruikersnaam(gebruikerNaam);
        if (k == null){
        return false;
        } else return k.getWachtwoord().equals(gebruikerWachtwoord);
    }
}
