package hoeckbankgroup.demo.model.service;

import hoeckbankgroup.demo.model.*;
import hoeckbankgroup.demo.model.DAO.KlantDAO;
import hoeckbankgroup.demo.model.DAO.KoppelDAO;
import hoeckbankgroup.demo.model.DAO.RekeningDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

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

    public boolean checkOpGebruikersnaamEnRekeningnummer(String mederekeninghouder, String rekeningnummer){
        return !koppelDao.existsByMederekeninghouderAndRekeningnummer(mederekeninghouder, rekeningnummer);
    }

    public boolean checkOpEigenEmail(int Id, String mederekeninghouder){
        Klant klant = klantDAO.findKlantByPersonId(Id);
        System.out.println("ja");
        String email = klant.getEmail();
        if(email.equals(mederekeninghouder)){
            System.out.println("nee");
            return true;
        } else return false;
    }



//    public Koppel findKoppelByKoppelId(int koppelId){
//        return koppelDao.findKoppelByKoppelId(koppelId);
//    }
//
//    public boolean checkOpKoppelId(int koppelId){
//        return !koppelDao.existsByKoppelIdEquals(koppelId);
//    }

//    public boolean alGekoppeldMederekeninghouder (String mederekeninghouder, String rekeningnummer){
//        System.out.println(mederekeninghouder+" "+rekeningnummer);
//        Rekening rekening = rekeningDAO.findRekeningByRekeningnummer(rekeningnummer);
//        System.out.println(rekening);
//        List<Klant> rekeningenhouders = rekening.getRekeninghouder();
//        //for (int i = 0; i < rekening.getRekeninghouder().size(); i++) {
//        //    rekeningenhouders.add;
//
//        //}
//        //de lijst moet gevuld worden, hoe dan???????????????????
//        //lijst moet gevuld met een field van een lijst in het object
//        System.out.println(rekeningenhouders.size());
//        for(Klant klant : rekeningenhouders) {
//            System.out.println("bah");
//            if (klant.getEmail().equals(mederekeninghouder)) {
//                System.out.println(" ja ");
//                return true;
//            }
//        }
//        return false;
//}


    //methode maken waarbij er gecontroleerd wordt of de email al gekoppeld is aan de rekening
    //List Rekening = rekening.getrekeninghouders
    //for
    //if rekeng.rekeninghouder equals mederekeninghouder return false >niet koppelen
}
