package hoeckbankgroup.demo.model.service;

import hoeckbankgroup.demo.model.DAO.PersoonDAO;
import hoeckbankgroup.demo.model.Persoon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersoonService {

    @Autowired
    private PersoonDAO persoonDAO;

    public Persoon findPersoonByName(String gebruikersnaam){
        return persoonDAO.findPersoonByGebruikersnaam(gebruikersnaam);
    }

    public void save (Persoon persoon) {
        persoonDAO.save(persoon);}
}
