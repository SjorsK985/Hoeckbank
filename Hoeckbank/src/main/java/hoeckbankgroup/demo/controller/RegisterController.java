package hoeckbankgroup.demo.controller;

import hoeckbankgroup.demo.model.Klant;
import hoeckbankgroup.demo.model.MKB;
import hoeckbankgroup.demo.model.Particulier;
import hoeckbankgroup.demo.model.service.MKBService;
import hoeckbankgroup.demo.model.service.ParticulierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Controller
public class RegisterController {

    @Autowired
    private ParticulierService particulierService;

    @Autowired
    private MKBService mkbService;

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
                                    @RequestParam(required = false, name = "dob") String geboortedatumString, @RequestParam(required = false, name = "bsn") String bsnstring,
                                    @RequestParam(required = false, name = "company_name") String bedrijfsnaam, @RequestParam(required = false, name = "segment") String segment,
                                    @RequestParam(required = false, name = "kvk") String kvk){
        System.out.println(geboortedatumString);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate geboortedatum = LocalDate.parse(geboortedatumString, dateTimeFormatter);
        int bsn = Integer.parseInt(bsnstring);
        if (rekeningSoort.equals("bedrijf")){
            MKB mkb = new MKB(emailadres, wachtwoord, straat, huisnummer, postcode, woonplaats, telefoon, bedrijfsnaam, segment, null);
            mkbService.save(mkb);
            return "login";
        }else{
            Particulier particulier = new Particulier(emailadres, wachtwoord, straat, huisnummer,
                    postcode, woonplaats, telefoon, voornaam, tussenvoegsel, achternaam, bsn, geslacht, geboortedatumString);
            particulierService.save(particulier);
            return "index";
        }
    }

   public boolean controleerGeboortedatum (LocalDate geboortedatum){
       LocalDate vandaag = LocalDate.now(ZoneId.of("Europe/Paris"));
       int leeftijd = (int)ChronoUnit.YEARS.between(geboortedatum, vandaag);
       if (leeftijd >= 18){
           return true;
       }else{
           return false;
       }
   }

   public boolean controleerBSN (int bsn){
       if (particulierService.findParticulierbyBSN(bsn)==null){
           return true;
       }else{
           return false;
       }
   }

   public boolean controleerTelefoon (String telefoon){
       return false;
   }

   public boolean controleerWachtwoord(String wachtwoord){
       return false;
   }
}
