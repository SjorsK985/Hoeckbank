package hoeckbankgroup.demo.model.service;

import hoeckbankgroup.demo.model.DAO.TransactieDAO;
import hoeckbankgroup.demo.model.Rekening;
import hoeckbankgroup.demo.model.Transactie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class TransactieService {

    @Autowired
    private TransactieDAO transactieDAO;

    @Autowired
    private RekeningService rekeningService;

    public void save(Transactie transactie){
        transactieDAO.save(transactie);
    }

    public String valideerTransactie(double bedrag, Rekening rekening, Rekening tegenRekening){
        if(tegenRekening == null){
            return "Rekeningnummer ontvanger bestaat niet";
        }
        if(bedrag > rekening.getSaldo()){
            return "Saldo is ontoereikend";
        }
        if(bedrag <= 0){
            return "Het bedrag mag niet 0 of lager zijn";
        }
        if(rekening.getRekeningnummer().equals(tegenRekening.getRekeningnummer())){
            return "De tegenrekening mag niet hetzelfde zijn";
        }
        return "";
    }

    public void executeTransactie(Rekening rekening, Rekening tegenRekening, double bedrag, String omschrijving){
        Transactie transactie = new Transactie(tegenRekening.getRekeningnummer(), bedrag, omschrijving, LocalDateTime.now());
        save(transactie);
        rekening.addTransactie(transactie);
        //Pas saldo aan
        rekening.setSaldo(bedrag + rekening.getSaldo());
        rekeningService.save(rekening);
    }
}
