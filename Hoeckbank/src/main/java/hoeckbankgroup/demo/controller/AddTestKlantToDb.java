package hoeckbankgroup.demo.controller;

import hoeckbankgroup.demo.model.DAO.KlantDAO;
import hoeckbankgroup.demo.model.Klant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddTestKlantToDb {

    @Autowired
    private KlantDAO klantDAO;

    @GetMapping("fdb")
    public String fillDatabase(){
/*       Klant klant = new Klant();
        klantDAO.save(klant);*/

        return "login";
    }


}
