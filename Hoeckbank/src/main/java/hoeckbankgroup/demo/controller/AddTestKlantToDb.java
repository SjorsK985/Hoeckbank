package hoeckbankgroup.demo.controller;

import hoeckbankgroup.demo.model.DAO.KlantDAO;
import hoeckbankgroup.demo.model.TestKlant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddTestKlantToDb {

    @Autowired
    private KlantDAO klantDAO;

    @GetMapping("fdb")
    public String fillDatabase(){
        TestKlant testKlant = new TestKlant("user", "test");
        klantDAO.save(testKlant);

        return "login";
    }


}
