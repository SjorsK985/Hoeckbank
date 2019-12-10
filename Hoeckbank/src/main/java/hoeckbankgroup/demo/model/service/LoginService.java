package hoeckbankgroup.demo.model.service;

import hoeckbankgroup.demo.model.DAO.KlantDAO;
import hoeckbankgroup.demo.model.Klant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private KlantDAO klantDAO;

    public boolean validatePassword(String gebruikerNaam, String gebruikerWachtwoord){
        Klant klant = klantDAO.findKlantByGebruikersnaam(gebruikerNaam);
        if (klant == null){
        return false;
        } else return klant.getWachtwoord().equals(gebruikerWachtwoord);
    }
}
