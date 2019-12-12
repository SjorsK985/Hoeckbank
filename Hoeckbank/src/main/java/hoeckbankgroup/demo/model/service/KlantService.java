package hoeckbankgroup.demo.model.service;

import hoeckbankgroup.demo.model.DAO.KlantDAO;
import hoeckbankgroup.demo.model.Klant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KlantService {

    @Autowired
    private KlantDAO klantDAO;

    public Klant findKlantByEmail(String email){
        return klantDAO.findKlantByEmail(email);
    }

    public Klant findKlantByPersonId(int personId){
        return klantDAO.findKlantByPersonId(personId);

    }
    public void save (Klant klant) {
        klantDAO.save(klant);}

}

