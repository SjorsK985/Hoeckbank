package hoeckbankgroup.demo.controller;
import hoeckbankgroup.demo.model.*;
import hoeckbankgroup.demo.model.enums.Branche;
import hoeckbankgroup.demo.model.enums.Geslacht;
import hoeckbankgroup.demo.model.service.KlantService;
import hoeckbankgroup.demo.model.service.MKBService;
import hoeckbankgroup.demo.model.service.ParticulierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Logger;

@Controller
@SessionAttributes("gebruiker")
public class RegisterController {

    @Autowired
    private ParticulierService particulierService;

    @Autowired
    private MKBService mkbService;

    @Autowired
    private KlantService klantService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private AddressPart addressPart;

    @GetMapping("register")
    public String registerHandler(){
        return "register";
    }

    @PostMapping("do_register")
    public String doRegisterHandler(@RequestParam(name = "accounttype_radio") String rekeningSoort,
                                    @RequestParam(name = "user_email") String emailadres, @RequestParam(name = "password") String wachtwoord,
                                    @RequestParam(name = "house_number") String huisnummer, @RequestParam(name = "postcode") String postcode,
                                    @RequestParam(name = "telephone") String telefoon, @RequestParam(name = "agree") boolean akkoord,
                                    @RequestParam(required = false, name = "gender") Geslacht geslacht, @RequestParam(required = false, name = "first_name") String voornaam,
                                    @RequestParam(required = false, name = "prepositions") String tussenvoegsel, @RequestParam(required = false, name ="last_name") String achternaam,
                                    @RequestParam(required = false, name = "dob") String geboortedatumString, @RequestParam(required = false, name = "bsn") String bsn,
                                    @RequestParam(required = false, name = "company_name") String bedrijfsnaam, @RequestParam(required = false, name = "segment") Branche segment,
                                    Model model){
        if (rekeningSoort.equals("bedrijf")){
            MKB mkb = new MKB(emailadres, wachtwoord, new Adres(addressPart.getStreet(), huisnummer, postcode, addressPart.getCity()), telefoon, new ArrayList<>(), bedrijfsnaam, segment);
            mkbService.save(mkb);
            Klant klant = klantService.findKlantByEmail(mkb.getEmail());
            Gebruiker gebruiker = new Gebruiker(klant.getPersonId(),"MKB");
            model.addAttribute("gebruiker", gebruiker);
            return "redirect:/newbankaccount";
        }else{
            if (particulierService.controleerGeboortedatum(geboortedatumString) && particulierService.controleerBestaandeParticulier(bsn, emailadres)){
                Particulier particulier = new Particulier(emailadres, wachtwoord, new Adres(addressPart.getStreet(), huisnummer, postcode, addressPart.getCity()), telefoon, new ArrayList<>(),
                        voornaam, tussenvoegsel, achternaam, bsn, geslacht, geboortedatumString);
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

    @CrossOrigin // laat deze annotatie als experiment weg en kijk wat er gebeurt
    @PostMapping("/postcode")
    public @ResponseBody
    AddressPart getWoonplaatsAndStraat(@RequestParam String postcode, @RequestParam String nr){

        System.out.println("request data in: " + postcode + " " + nr);

        return getAddressPart(postcode, nr);
    }

    private AddressPart getAddressPart(@RequestParam String postcode, @RequestParam String nr) {


        try {
            addressPart = jdbcTemplate.queryForObject("SELECT straat, stad FROM postcode where postcode=? AND min_huisnr <= ? AND max_huisnr >=?",
                    new AdresMapper(), postcode, nr, nr);
            System.out.println(addressPart);

        } catch (EmptyResultDataAccessException ex) {
            System.out.println("query lukt niet, empty");
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Adres niet gevonden", ex);
        } catch (Exception ex) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Things went wrong on our side", ex);
        }
        return addressPart;
    }
}

class AdresMapper implements RowMapper<AddressPart> {

    @Override
    public AddressPart mapRow(ResultSet resultSet, int i) throws SQLException {
        return new AddressPart(resultSet.getString("straat"), resultSet.getString("stad"));
    }
}