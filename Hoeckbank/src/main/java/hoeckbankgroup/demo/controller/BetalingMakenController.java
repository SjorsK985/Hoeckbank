package hoeckbankgroup.demo.controller;

import hoeckbankgroup.demo.model.Rekening;
import hoeckbankgroup.demo.model.Transactie;
import hoeckbankgroup.demo.model.service.RekeningService;
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
    public String betalingMakenHandler(@RequestParam int id, Model model){
        Rekening rekening = rekeningService.findRekeningByRekeningID(id);
        model.addAttribute("rekening", rekening);
        //RK: Voor testdoeleinden:
        //rekeningService.setTestSaldo(id, 2000.00);
        return "betalingmaken";
    }

    @PostMapping("do_transactie")
    public String doTransactieHandler(@RequestParam (name="rekening_id") int rekeningId,
                                      @RequestParam double bedrag,
                                      @RequestParam (name="naam_ontvanger") String naamOntvanger,
                                      @RequestParam (name="rekeningnummer_ontvanger") String rekeningnummerOntvanger,
                                      @RequestParam String omschrijving,
                                      Model model){

        System.out.println("\nbedrag: " + bedrag);
        System.out.println("naam_ontvanger: " + naamOntvanger);
        System.out.println("rekeningnummerOntvanger: " + rekeningnummerOntvanger);
        System.out.println("omschrijving: " + omschrijving);

        //TODO: Controleer of bedrag niet negatief, 0 of groter dan saldo is
        //TODO: Check of tegenrekening bestaan (en naam overeenkomt)
        Rekening rekening = rekeningService.findRekeningByRekeningID(rekeningId);
        Rekening rekeningOntvanger =  rekeningService.findRekeningByRekeningnummer(rekeningnummerOntvanger);
        String validatieError = valideerTransactie(bedrag, rekening, rekeningOntvanger);
        if(!validatieError.equals("")){
            model.addAttribute("error", validatieError);
            return "redirect:/betalingmaken?id=" + rekeningId;
        }
        //TODO: Maak object aan transactie aan
        Transactie transactie = new Transactie(rekeningnummerOntvanger, bedrag, omschrijving, LocalDate.now());
        //String tegenRekening, double bedrag, String omschrijving, LocalDate datum
        //TODO: Sla transactie object op in DB

        //TODO: Pas saldo eigen rekening aan

        //TODO: Pas saldo tegenrekening aan

        //TODO: Backend form validation

        //TODO: Front-end form validation

        return "redirect:/rekeningdetail?id=" + rekeningId;
    }

    public String valideerTransactie(double bedrag, Rekening rekening, Rekening rekeningnummerOntvanger){
        String error = "";
        if(rekeningnummerOntvanger == null){
            error = "Tegenrekening bestaat niet";
        }
        if(bedrag > rekening.getSaldo()){
            error = "Saldo is ontoereikend";
        }
        if(bedrag <= 0){
            error = "Het bedrag mag niet 0 of lager zijn";
        }
        return error;
    }


}
