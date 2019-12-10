package hoeckbankgroup.demo.model.service;

import hoeckbankgroup.demo.model.DAO.KlantDAO;
import hoeckbankgroup.demo.model.Klant;
import hoeckbankgroup.demo.model.TestKlant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KlantService {

    @Autowired
    private KlantDAO klantDAO;

    public Klant findKlantByEmail(String email){
        return klantDAO.findKlantByEmail(email);
    }

   // public void save (TestKlant klant) {klantDAO.save(klant);}
}

