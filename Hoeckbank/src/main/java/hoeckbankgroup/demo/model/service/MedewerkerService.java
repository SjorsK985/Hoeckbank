package hoeckbankgroup.demo.model.service;

import hoeckbankgroup.demo.model.*;
import hoeckbankgroup.demo.model.DAO.KlantDAO;
import hoeckbankgroup.demo.model.DAO.MKBDAO;
import hoeckbankgroup.demo.model.DAO.MedewerkerDAO;
import hoeckbankgroup.demo.model.DAO.ParticulierDAO;
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
    private MKBDAO mkbDAO;

    @Autowired
    private ParticulierDAO particulierDAO;

    public Medewerker findMedewerkerByEmail(String email){
        return medewerkerDAO.findMedewerkerByEmail(email);
    }

    public List<Rekening> rekeningenHoogsteSaldoParticulier(){
        List<Rekening> alleParticuliereRekeningen = new ArrayList<>();
        List<Particulier> alleKlanten = particulierDAO.findAll();
        for(Particulier particulier:alleKlanten){
            List<Rekening> rekeningenPerKlant =  particulier.getRekeningen();
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

    public List<Rekening> rekeningenHoogsteSaldoMKB(){
        List<Rekening> alleMKBRekeningen = new ArrayList<>();
        List<MKB> alleKlanten = mkbDAO.findAll();
        for(MKB mkb:alleKlanten){
            List<Rekening> rekeningenPerKlant =  mkb.getRekeningen();
            for(Rekening rekening :rekeningenPerKlant){
                alleMKBRekeningen.add(rekening);
            }
        }
        Collections.sort(alleMKBRekeningen);
        List<Rekening> selectie = new ArrayList<>();
        for (int i = 0; i <10 || i==alleMKBRekeningen.size() ; i++) {
            selectie.add(alleMKBRekeningen.get(i));
        }
        return selectie;
    }


}
