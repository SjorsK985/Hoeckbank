package hoeckbankgroup.demo.model.service;

import hoeckbankgroup.demo.model.DAO.KlantDAO;
import hoeckbankgroup.demo.model.DAO.MedewerkerDAO;
import hoeckbankgroup.demo.model.Klant;
import hoeckbankgroup.demo.model.Medewerker;
import hoeckbankgroup.demo.model.Rekening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class MedewerkerService {

    @Autowired
    private MedewerkerDAO medewerkerDAO;

    @Autowired
    private KlantDAO klantDAO;

    public Medewerker findMedewerkerByEmail(String email){
        return medewerkerDAO.findMedewerkerByEmail(email);
    }



    public List<Rekening> rekeningenHoogsteSaldo(){
        List<Rekening> alleParticuliereRekeningen = new ArrayList<>();
        List<Klant> alleKlanten = klantDAO.findAll();
        for(Klant klant:alleKlanten){
            List<Rekening> rekeningenPerKlant =  klant.getRekeningen();
            for(Rekening rekening :rekeningenPerKlant){
                alleParticuliereRekeningen.add(rekening);
            }
        }
        Collections.sort(alleParticuliereRekeningen);
        List<Rekening> selectie = new ArrayList<>();
        for (int i = 0; i <10 || i==alleParticuliereRekeningen.size() ; i++) {
            selectie.add(alleParticuliereRekeningen.get(i));
        }
        return selectie;
    }


}
