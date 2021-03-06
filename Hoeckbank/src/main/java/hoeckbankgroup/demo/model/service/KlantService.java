package hoeckbankgroup.demo.model.service;

import hoeckbankgroup.demo.model.*;
import hoeckbankgroup.demo.model.DAO.KlantDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

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

    public List<String> getMederekeninghouders(Rekening rekening){
        List<Klant> alleMederekeninghouders = rekening.getRekeninghouder();
        System.out.println(alleMederekeninghouders);
        ArrayList<String> mederekeninghouders = new ArrayList<>();
        String tussenvoegsel;
        for(Klant klant : alleMederekeninghouders){
            if(klant instanceof Particulier){
                if(!((Particulier) klant).getTussenvoegsel().equals("")){
                    tussenvoegsel = " " + ((Particulier) klant).getTussenvoegsel() + " ";
                } else {
                    tussenvoegsel = "";
                }
                mederekeninghouders.add(((Particulier) klant).getVoornaam() + tussenvoegsel + ((Particulier) klant).getAchternaam());
            } else{
                mederekeninghouders.add(((MKB) klant).getBedrijfsnaam());
            }
        }
        if(mederekeninghouders.size() == 0){
            String geenMederekeningHouder = ("Geen mederekeninghouder(s)");
            mederekeninghouders.add(geenMederekeningHouder);
        }
        System.out.println(mederekeninghouders);
        return mederekeninghouders;
    }

    public boolean klantExistsByEmail(String email){
        return klantDAO.existsKlantByEmail(email);
    }
}

