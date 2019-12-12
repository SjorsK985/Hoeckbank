package hoeckbankgroup.demo.controller;

import hoeckbankgroup.demo.Service.GenereerRekeningnummerService;
import hoeckbankgroup.demo.model.*;
import hoeckbankgroup.demo.model.service.KlantService;
import hoeckbankgroup.demo.model.service.MKBService;
import hoeckbankgroup.demo.model.service.ParticulierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

@Controller
@SessionAttributes("gebruiker")
public class RegisterController {

    @Autowired
    private ParticulierService particulierService;

    @Autowired
    private MKBService mkbService;

    @Autowired
    private KlantService klantService;


    @GetMapping("register")
    public String registerHandler(){
        return "register";
    }

    @PostMapping("do_register")
    public String doRegisterHandler(@RequestParam(name = "accounttype_radio") String rekeningSoort,
                                    @RequestParam(name = "user_email") String emailadres, @RequestParam(name = "password") String wachtwoord,
                                    @RequestParam(name = "street") String straat, @RequestParam(name = "house_number") String huisnummer,
                                    @RequestParam(name = "postcode") String postcode, @RequestParam(name = "city") String woonplaats,
                                    @RequestParam(name = "telephone") String telefoon, @RequestParam(name = "agree") boolean akkoord,
                                    @RequestParam(required = false, name = "gender") String geslacht, @RequestParam(required = false, name = "first_name") String voornaam,
                                    @RequestParam(required = false, name = "prepositions") String tussenvoegsel, @RequestParam(required = false, name ="last_name") String achternaam,
                                    @RequestParam(required = false, name = "dob") String geboortedatumString, @RequestParam(required = false, name = "bsn") int bsn,
                                    @RequestParam(required = false, name = "company_name") String bedrijfsnaam, @RequestParam(required = false, name = "segment") String segment,
                                    @RequestParam(required = false, name = "kvk") String kvk, Model model){
        if (rekeningSoort.equals("bedrijf")){
            MKB mkb = new MKB(emailadres, wachtwoord, straat, huisnummer, postcode, woonplaats, telefoon, bedrijfsnaam, segment, null);
            mkbService.save(mkb);
            Klant klant = klantService.findKlantByEmail(mkb.getEmail());
            Gebruiker gebruiker = new Gebruiker(klant.getPersonId(),"MKB");
            model.addAttribute("gebruiker", gebruiker);
            return "redirect:/newbankaccount";
        }else{
            if (particulierService.controleerGeboortedatum(geboortedatumString) && particulierService.controleerBestaandeKlant(bsn, emailadres)){
                Particulier particulier = new Particulier(emailadres, wachtwoord, straat, huisnummer,
                        postcode, woonplaats, telefoon, voornaam, tussenvoegsel, achternaam, bsn, geslacht, geboortedatumString);
                particulierService.save(particulier);
                Klant klant = klantService.findKlantByEmail(particulier.getEmail());
                Gebruiker gebruiker = new Gebruiker(klant.getPersonId(),"Particulier");
                model.addAttribute("gebruiker", gebruiker);
                return "redirect:/newbankaccount";
            } else {
                return "redirect:/register";
            }
        }
    }
}