package hoeckbankgroup.demo.controller;

import hoeckbankgroup.demo.model.Rekening;
import hoeckbankgroup.demo.model.service.RekeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BetalingMakenController {

    @Autowired
    private RekeningService rekeningService;

    @GetMapping("betalingmaken")
    public String betalingMakenHandler(@RequestParam int id, Model model){
        Rekening rekening = rekeningService.findRekeningByRekeningID(id);
        System.out.println(rekening.getRekeningnummer());
        System.out.println(rekening.getTenaamstelling());
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
        System.out.println("");
        System.out.println("bedrag :" + bedrag);
        System.out.println("naam_ontvanger :" + naamOntvanger);
        System.out.println("rekeningnummerOntvanger :" + rekeningnummerOntvanger);
        System.out.println("omschrijving :" + omschrijving);
        //TODO: Selenium scriptje voor bedrag overmaken

        //TODO: Controleer of bedrag niet negatief, 0 of groter dan saldo is

        //TODO: Check of tegenrekening bestaan (en naam overeenkomt)

        //TODO: Maak object aan transactie aan

        //TODO: Sla transactie object op in DB

        //TODO: Pas saldo eigen rekening aan

        //TODO: Pas saldo tegenrekening aan

        //TODO: Backend form validation

        //TODO: Front-end form validation

        return "redirect:/rekeningdetail?id=" + rekeningId;
    }


}
