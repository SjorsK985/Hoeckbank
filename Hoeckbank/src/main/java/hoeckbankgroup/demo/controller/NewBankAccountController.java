package hoeckbankgroup.demo.controller;
import hoeckbankgroup.demo.Service.GenereerRekeningnummerService;
import hoeckbankgroup.demo.Service.NewBankAccountService;
import hoeckbankgroup.demo.model.*;
import hoeckbankgroup.demo.model.service.KlantService;
import hoeckbankgroup.demo.model.service.RekeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

/*
Author: Sjors Koevoets
Controller die ervoor zorgt dat een nieuw banknummer wordt gegenereerd en aan een user wordt gekoppeld en opgeslagen
 */
@Controller
public class NewBankAccountController {

    String nieuwRekeningNummer;
    String tenaamstelling;
    Klant klant;
    Rekening rekening;

    @Autowired
    private RekeningService rekeningService;

    @Autowired
    private GenereerRekeningnummerService genereerRekeningnummerService;

    @Autowired
    private KlantService klantService;

    @GetMapping("newbankaccount")
    private String newBankAccountHandler(@SessionAttribute("gebruiker") Gebruiker gebruiker, Model model){
        //Genereer een rekeningnummer
        nieuwRekeningNummer = genereerRekeningnummerService.genereerRekeningnummer();
        model.addAttribute("nieuwrekeningnummer", nieuwRekeningNummer);
        klant = klantService.findKlantByPersonId(gebruiker.getId());
        if(klant instanceof MKB){
            tenaamstelling = ((MKB) klant).getBedrijfsnaam();
            model.addAttribute("tenaamstelling", tenaamstelling);
        } else if(klant instanceof Particulier) {
            String tussenvoegsel = " ";
            if(!((Particulier) klant).getTussenvoegsel().equals("")){
                tussenvoegsel = " " + ((Particulier) klant).getTussenvoegsel() + " ";
            }
            String geslacht = ((Particulier) klant).getGeslacht();
            tenaamstelling = ((Particulier) klant).getGeslacht() + " " + ((Particulier) klant).getVoornaam() + " " + ((Particulier) klant).getTussenvoegsel() + " " + ((Particulier) klant).getAchternaam();
            if(geslacht.equals("Neutraal")){
                tenaamstelling = ((Particulier) klant).getVoornaam() + tussenvoegsel + ((Particulier) klant).getAchternaam();
            }
            model.addAttribute("tenaamstelling", tenaamstelling);
        }
        return "newbankaccount";
    }

    @PostMapping("confirm-newbank")
    private String confirmNewBankAccountHandler(){
        rekening = new Rekening(nieuwRekeningNummer, 100, tenaamstelling);
        klant.addRekening(rekening);
        klantService.save(klant);
        return "redirect:/rekeningenoverzicht";
    }

    @GetMapping("cancel_bankaccount")
    private String cancelBankAccountHandler(){
        return "redirect:/rekeningenoverzicht";
    }
}