package hoeckbankgroup.demo.model.service;

import hoeckbankgroup.demo.model.DAO.KlantDAO;
import hoeckbankgroup.demo.model.DAO.KoppelDAO;
import hoeckbankgroup.demo.model.Klant;
import hoeckbankgroup.demo.model.Koppel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KoppelService {

    @Autowired
    private KoppelDAO koppelDao;

    @Autowired
    private KlantDAO klantDAO;

    public void save(Koppel koppel){
        koppelDao.save(koppel);
    }

    public boolean validateEmail(String email){
        Klant klant = klantDAO.findKlantByEmail(email);
        if(klant == null){
            return false;
        } else return klant.getEmail().equals(email);
    }
}
