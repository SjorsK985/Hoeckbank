package hoeckbankgroup.demo.model.service;

import hoeckbankgroup.demo.model.DAO.KlantDAO;
import hoeckbankgroup.demo.model.DAO.RekeningDAO;
import hoeckbankgroup.demo.model.Klant;
import hoeckbankgroup.demo.model.Rekening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RekeningService {

    @Autowired
    private KlantDAO klantDAO;

    @Autowired
    private RekeningDAO rekeningDAO;

    public void addRekeningToKlant(Rekening rekening, Klant klant){
        klant.addRekening(rekening);
        klantDAO.save(klant);
    }

    public void save (Rekening rekening){
        rekeningDAO.save(rekening);
    }

    public Rekening findRekeningByRekeningID(int rekeningID){
        return rekeningDAO.findRekeningByRekeningID(rekeningID);
    }

    public Rekening findRekeningByRekeningnummer(String rekeningNummer){
        return rekeningDAO.findRekeningByRekeningnummer(rekeningNummer);
    }

//    public List<Rekening> findAllByRekeningnummer(Rekening rekening){
//        Iterable<Rekening> rekeningIterable = rekeningDAO.findAll().equals(rekening.getRekeningnummer());
//        List<Rekening> rekeningList = new ArrayList<>();
//        for (Rekening r: rekeningIterable){
//            rekeningList.add(r);
//        }
//        return rekeningList;
//    }

}
