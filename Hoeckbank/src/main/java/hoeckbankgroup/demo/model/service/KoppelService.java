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

    public boolean checkOpKoppelen(String rekeningnummer, String beveiligingscode, String gebruikersnaam){
        return koppelDao.existsByRekeningnummerAndBeveiligingscodeAndMederekeninghouder(rekeningnummer,
                beveiligingscode, gebruikersnaam);
    }

    public boolean checkOpEigenEmail(int id, String mederekeninghouder){
        Klant klant = klantDAO.findKlantByPersonId(id);
        String email = klant.getEmail();
        if (email.equals(mederekeninghouder)){
            return false;
        } else {
            return true;
        }
    }

    public Koppel findKoppel(String rekeningnummer, String gebruikersnaam){
        return koppelDao.findKoppelByRekeningnummerAndMederekeninghouder(rekeningnummer, gebruikersnaam);
    }

    public void delete(Koppel koppel){
        koppelDao.delete(koppel);
    }
}
