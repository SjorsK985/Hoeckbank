package hoeckbankgroup.demo.controller;

import hoeckbankgroup.demo.model.Gebruiker;
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
import org.springframework.web.bind.annotation.SessionAttribute;

import java.time.*;

@Controller
public class BetalingMakenController {

    @Autowired
    private RekeningService rekeningService;

    @Autowired
    private TransactieService transactieService;

    @GetMapping("betalingmaken")
    public String betalingMakenHandler(@SessionAttribute("gebruiker") Gebruiker gebruiker,
                                       @RequestParam int id,
                                       @RequestParam (value = "melding", required = false) String melding,
                                       Model model){
        Rekening rekening = rekeningService.findRekeningByRekeningID(id);
        model.addAttribute("rekening", rekening);
        model.addAttribute("error", melding);
        return "betalingmaken";
    }

    @PostMapping("do_transactie")
    public String doTransactieHandler(@RequestParam (name="rekening_id") int rekeningId,
                                      @RequestParam double bedrag,
                                      @RequestParam (name="naam_ontvanger") String naamOntvanger,
                                      @RequestParam (name="rekeningnummer_ontvanger") String rekeningnummerOntvanger,
                                      @RequestParam String omschrijving,
                                      Model model){
        Rekening rekening = rekeningService.findRekeningByRekeningID(rekeningId);
        Rekening tegenRekening =  rekeningService.findRekeningByRekeningnummer(rekeningnummerOntvanger);
        // Valideer transactie:
        String validatieError = valideerTransactie(bedrag, rekening, tegenRekening);
        if(!validatieError.equals("")){
            model.addAttribute("error", validatieError);
            return "redirect:/betalingmaken?id=" + rekeningId + "&melding=" +validatieError;
        }
        //Maak transactie objecten aan en sla deze op
        Transactie transactie = new Transactie(rekeningnummerOntvanger, -bedrag, omschrijving, LocalDateTime.now());
        Transactie tegenTransactie = new Transactie(rekeningnummerOntvanger, bedrag, omschrijving, LocalDateTime.now());
        transactieService.save(transactie);
        transactieService.save(tegenTransactie);
        rekening.addTransactie(transactie);
        tegenRekening.addTransactie(tegenTransactie);
        //Pas saldo's aan op rekening  & tegenrekening
        saldosAanpassen(rekening, tegenRekening, bedrag);
        return "redirect:/rekeningdetail?id=" + rekeningId;
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
