package hoeckbankgroup.demo.controller;

import hoeckbankgroup.demo.model.Rekening;
import hoeckbankgroup.demo.model.Transactie;
import hoeckbankgroup.demo.model.service.RekeningService;
import hoeckbankgroup.demo.model.service.TransactieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.time.*;

@Controller
public class BetalingMakenController {

    @Autowired
    private RekeningService rekeningService;

    @Autowired
    private TransactieService transactieService;

    @GetMapping("betalingmaken")
    public String betalingMakenHandler(@RequestParam int id,
                                       @RequestParam (value = "melding", required = false) String melding,
                                       Model model){
        Rekening rekening = rekeningService.findRekeningByRekeningID(id);
        model.addAttribute("rekening", rekening);
        model.addAttribute("error", melding);
        //RK: Voor testdoeleinden:
        //rekeningService.setTestSaldo(id, 2000.00);
        return "betalingmaken";
    }
    //Todo: Refactor
    //Todo: Los data probleem op met none unique rekening
    //Todo: Front-end validatie
    //Todo:

    @PostMapping("do_transactie")
    public String doTransactieHandler(@RequestParam (name="rekening_id") int rekeningId,
                                      @RequestParam double bedrag,
                                      @RequestParam (name="naam_ontvanger") String naamOntvanger,
                                      @RequestParam (name="rekeningnummer_ontvanger") String rekeningnummerOntvanger,
                                      @RequestParam String omschrijving,
                                      Model model){
        System.out.println("RekeningID = " + rekeningId);
        //TODO: Controleer of bedrag niet negatief, 0 of groter dan saldo is
        //TODO: Check of tegenrekening bestaan (en naam overeenkomt)
        Rekening rekening = rekeningService.findRekeningByRekeningID(rekeningId);
        Rekening tegenRekening =  rekeningService.findRekeningByRekeningnummer(rekeningnummerOntvanger);
        String validatieError = valideerTransactie(bedrag, rekening, tegenRekening);
        if(!validatieError.equals("")){
            model.addAttribute("error", validatieError);
            return "redirect:/betalingmaken?id=" + rekeningId + "&melding=" +validatieError;
        }
        //TODO: Maak object aan transactie aan
        Transactie transactie = new Transactie(rekeningnummerOntvanger, -bedrag, omschrijving, LocalDate.now());
        Transactie tegenTransactie = new Transactie(rekeningnummerOntvanger, bedrag, omschrijving, LocalDate.now());
        //TODO: Sla transactie object op in DB
        transactieService.save(transactie);
        transactieService.save(tegenTransactie);
        rekening.addTransactie(transactie);
        tegenRekening.addTransactie(tegenTransactie);

        //TODO: Pas saldo eigen rekening  & tegenrekening aan
        saldosAanpassen(rekening, tegenRekening, bedrag);
        return "redirect:/rekeningdetail?id=" + rekeningId;

    }

    public String valideerTransactie(double bedrag, Rekening rekening, Rekening tegenRekening){
        String error = "";
        if(tegenRekening == null){
            error = "Tegenrekening bestaat niet";
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

    public void saldosAanpassen(Rekening rekening, Rekening tegenRekening, double bedrag){
        setNieuwSaldo(-bedrag, rekening);
        setNieuwSaldo(bedrag, tegenRekening);
    }

    public void setNieuwSaldo(double bedrag, Rekening rekening){
        double nieuwSaldo = bedrag + rekening.getSaldo();
        rekening.setSaldo(nieuwSaldo);
        rekeningService.save(rekening);
    }

}
