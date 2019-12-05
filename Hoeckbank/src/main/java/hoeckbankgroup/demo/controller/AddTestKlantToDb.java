package hoeckbankgroup.demo.controller;

import hoeckbankgroup.demo.model.Klant;
import hoeckbankgroup.demo.model.KlantDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddTestKlantToDb {

    @Autowired
    private KlantDAO klantDAO;

    @GetMapping("fdb")
    public String fillDatabase(){

        return "login";
    }


}
