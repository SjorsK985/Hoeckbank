package hoeckbankgroup.demo.model.service;

import hoeckbankgroup.demo.model.DAO.KlantDAO;
import hoeckbankgroup.demo.model.DAO.KoppelDAO;
import hoeckbankgroup.demo.model.Klant;
import hoeckbankgroup.demo.model.Koppel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

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

    public boolean checkOpGebnaamEnReknummer(String mederekeninghouder, String rekeningnummer){
        return !koppelDao.existsByMederekeninghouderAndRekeningnummer(mederekeninghouder, rekeningnummer);
    }

    public boolean checkBeveiligingscode (String beveiligingscode){
        return Pattern.matches("[0-9]{5}", beveiligingscode);
    }
    /*public boolean alGekoppeldMederekeninghouder(String mederekeninghouder){
        Koppel koppel = koppelDao.findKoppelByMederekeninghouder(mederekeninghouder);
        if (koppel == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkOpRekeningnummer(String rekeningnummer){
        Koppel koppel = koppelDao.findKoppelByRekeningnummer(rekeningnummer);
        if (koppel == null){
            return true;
        } else if (!koppel.getRekeningnummer().equals(rekeningnummer)){
            return false;
        } else {
            return true;
        }
    }
*/
    //methode maken waarbij er gecontroleerd wordt of de email al gekoppeld is aan de rekening
}
