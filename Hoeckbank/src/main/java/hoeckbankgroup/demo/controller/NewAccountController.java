package hoeckbankgroup.demo.controller;

import hoeckbankgroup.demo.model.Klant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NewAccountController {

    //@Autowired
    //private KlantDao klantdao;

    @PostMapping("newAccount")
    public String newAccountHandler(@RequestParam(name = "user-name") String username, @RequestParam(name = "password") String password,
                                    @RequestParam(name = "gender") String gender,@RequestParam(name = "first_name") String firstName,
                                    @RequestParam(name = "preposition") String tussenvoegsel, @RequestParam(name = "last_name") String lastName,
                                    @RequestParam(name = "street") String street, @RequestParam(name = "house_number") int houseNumber,
                                    @RequestParam(name = "postcode") String postcode, @RequestParam(name = "city") String woonplaats,
                                    @RequestParam(name = "email") String email, @RequestParam(name = "phone") String phone,
                                    @RequestParam(name = "dob") String dob, @RequestParam(name = "bsn") int bsn) {
        //valideren bsn? tegen database
        // particulier aanpassen naar hibernate en rekeningen eruit halen in een constructor
        //Klant klant = new Klant(username, password, firstName, tussenvoegsel, lastName, street, houseNumber, postcode, woonplaats, email, phone, dob,bsn);
        //if (bsn != klantDao.findById()){
        //     klantdao.save(klant); return "personal_account_template";
       // } else {
        // return naar Login? met boodschap: u bent reeds kant, log aub in
        return "personal_account_template";
    }
}
