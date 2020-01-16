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
        List<String> mederekeninghouders = new ArrayList<>();
        for(Klant klant:alleMederekeninghouders){
            if(klant instanceof Particulier){
                mederekeninghouders.add(((Particulier) klant).getVoornaam() + ((Particulier) klant).getTussenvoegsel() + ((Particulier) klant).getAchternaam());
            } else{
                mederekeninghouders.add(((MKB) klant).getBedrijfsnaam());
            }
        }
        return mederekeninghouders;
    }

//    public String getNaam(Rekening rekening) {
//        List<Klant> getNaam = getMederekeninghouders(rekening);
//
//        for (Klant klant : getNaam) {
//            // System.out.println(klant);
//            List<Rekening> rekeningenvandeklant = klant.getRekeningen();
//            for (Rekening rekening1 : rekeningenvandeklant) {
//                if (rekening1.getRekeningnummer().equals(rekening.getRekeningnummer())) {
//                    if (klant instanceof Particulier) {
//                        System.out.println("gelukt");
//                        return  ((Particulier) klant).getVoornaam() + ((Particulier) klant).getTussenvoegsel() + ((Particulier) klant).getAchternaam();
//                    } else {
//                        System.out.println("gelukt mkb");
//                        return  ((MKB) klant).getBedrijfsnaam();
//                    }
//                }
//            }
//        }
//        return "geen klant gevonden ";
//    }

}

