package hoeckbankgroup.demo.model.service;

import hoeckbankgroup.demo.model.DAO.KlantDAO;
import hoeckbankgroup.demo.model.DAO.MedewerkerDAO;
import hoeckbankgroup.demo.model.Klant;
import hoeckbankgroup.demo.model.Medewerker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginMedewerkerService {

    @Autowired
    private MedewerkerDAO medewerkerDAO;

    public boolean validatePassword(String email, String gebruikerWachtwoord){
        Medewerker medewerker = medewerkerDAO.findMedewerkerByEmail(email);
        if (medewerker == null){
            return false;
        } else return medewerker.getWachtwoord().equals(gebruikerWachtwoord);
    }

}
