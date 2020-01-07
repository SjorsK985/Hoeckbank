package hoeckbankgroup.demo.controller;

import hoeckbankgroup.demo.model.Gebruiker;
import hoeckbankgroup.demo.model.Rekening;
import hoeckbankgroup.demo.model.service.RekeningService;
import hoeckbankgroup.demo.model.service.TransactieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class BetalingMakenController {
    private Model model;
    private int rekeningId;

    @Autowired
    private RekeningService rekeningService;

    @Autowired
    private TransactieService transactieService;

    @GetMapping("betalingmaken")
    public String betalingMakenHandler(@SessionAttribute("gebruiker") Gebruiker gebruiker,
                                       @RequestParam int id,
                                       @RequestParam (value = "melding", required = false) String melding,
                                       Model model){
        this.model = model;
        this.rekeningId = id;
        Rekening rekening = rekeningService.findRekeningByRekeningID(rekeningId);
        model.addAttribute("rekening", rekening);
        model.addAttribute("error", melding);
        return "betalingmaken";
    }

    @PostMapping("do_transactie")
    public String doTransactieHandler(@RequestParam double bedrag,
                                      @RequestParam (name="rekeningnummer_ontvanger") String rekeningnummerOntvanger,
                                      @RequestParam String omschrijving){
        Rekening rekening = rekeningService.findRekeningByRekeningID(rekeningId);
        Rekening tegenRekening =  rekeningService.findRekeningByRekeningnummer(rekeningnummerOntvanger);
        // Valideer transactie:
        String validatieError = transactieService.valideerTransactie(bedrag, rekening, tegenRekening);
        if(!validatieError.equals("")){
            model.addAttribute("error", validatieError);
            return "redirect:/betalingmaken?id=" + rekeningId + "&melding=" +validatieError;
        } else {
            String rekeningnummer = rekening.getRekeningnummer(); // Todo: REMOVE
            transactieService.doValidTransactie(rekeningnummer, rekeningnummerOntvanger, bedrag, omschrijving);
            return "redirect:/rekeningdetail?id=" + rekeningId;
        }
    }

}
