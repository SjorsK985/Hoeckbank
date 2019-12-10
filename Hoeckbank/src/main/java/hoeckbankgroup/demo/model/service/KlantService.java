package hoeckbankgroup.demo.model.service;

import hoeckbankgroup.demo.model.DAO.KlantDAO;
import hoeckbankgroup.demo.model.Klant;
import hoeckbankgroup.demo.model.Persoon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KlantService {

    @Autowired
    private KlantDAO klantDAO;

    public Klant findKlantByName(String gebruikersnaam){
        return klantDAO.findKlantByGebruikersnaam(gebruikersnaam);
    }

    public void save (Klant klant) {
        klantDAO.save(klant);}
}
