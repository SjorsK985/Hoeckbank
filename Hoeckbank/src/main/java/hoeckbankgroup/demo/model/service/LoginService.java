package hoeckbankgroup.demo.model.service;

import hoeckbankgroup.demo.model.DAO.PersoonDAO;
import hoeckbankgroup.demo.model.TestKlant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private PersoonDAO persoonDAO;

    public boolean validatePassword(String gebruikerNaam, String gebruikerWachtwoord){
        TestKlant k = persoonDAO.findKlantByGebruikersnaam(gebruikerNaam);
        if (k == null){
        return false;
        } else return k.getWachtwoord().equals(gebruikerWachtwoord);
    }
}
