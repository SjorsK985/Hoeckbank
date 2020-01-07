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
        String error = "";
        if(tegenRekening == null){
            return "Rekeningnummer ontvanger bestaat niet";
        }
        if(bedrag > rekening.getSaldo()){
            error = "Saldo is ontoereikend";
        }
        if(bedrag <= 0){
            error = "Het bedrag mag niet 0 of lager zijn";
        }
        if(rekening.getRekeningnummer().equals(tegenRekening.getRekeningnummer())){
            error = "De tegenrekening mag niet hetzelfde zijn";
        }
        return error;
    }

    public void doValidTransactie(String rekeningnummer, String rekeningnummerOntvanger, double bedrag, String omschrijving){
        //Maak transactie objecten aan en sla deze op
        Transactie transactie = new Transactie(rekeningnummerOntvanger, -bedrag, omschrijving, LocalDateTime.now());
        Transactie tegenTransactie = new Transactie(rekeningnummerOntvanger, bedrag, omschrijving, LocalDateTime.now());
        save(transactie);
        save(tegenTransactie);
        Rekening rekening = rekeningService.findRekeningByRekeningnummer(rekeningnummer);
        Rekening tegenRekening = rekeningService.findRekeningByRekeningnummer(rekeningnummerOntvanger);
        rekening.addTransactie(transactie);
        tegenRekening.addTransactie(tegenTransactie);
        //Pas saldo's aan op rekening  & tegenrekening
        rekeningService.saldosAanpassen(rekening, tegenRekening, bedrag);
    }
}
