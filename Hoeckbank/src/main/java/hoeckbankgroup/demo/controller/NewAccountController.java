package hoeckbankgroup.demo.controller;

import hoeckbankgroup.demo.model.Klant;
import hoeckbankgroup.demo.model.service.ParticulierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Controller
public class NewAccountController {

    @Autowired
    private ParticulierService particulierService;


   /* @PostMapping("newAccount")
    public String newAccountHandler(@RequestParam(name = "user_name") String username, @RequestParam(name = "password") String password,
                                    @RequestParam(name = "gender") String gender,@RequestParam(name = "first_name") String firstName,
                                    @RequestParam(name = "prepositions") (required = false) String tussenvoegsel, @RequestParam(name = "last_name") String lastName,
                                    @RequestParam(name = "street") String street, @RequestParam(name = "house_number") String houseNumber,
                                    @RequestParam(name = "postcode") String postcode, @RequestParam(name = "city") String woonplaats,
                                    @RequestParam(name = "email") String email, @RequestParam(name = "phone") String phone,
                                    @RequestParam(name = "dob") String dob, @RequestParam(name = "bsn") int bsn) {
        //valideren bsn? tegen database
        // particulier aanpassen naar hibernate en rekeningen eruit halen in een constructor
        //Klant klant = new Klant(username, password, firstName, tussenvoegsel, lastName, street, houseNumber, postcode, woonplaats, email, phone, dob,bsn);
        //email controleert zichtzelf, de rest nog niet
        //if (bsn != klantDao.findById()){
        //     klantdao.save(klant); return "personal_account_template";
       // } else {
        // return naar Login? met boodschap: u bent reeds klant, log aub in
        return "personal_account_template";
    }*/

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
