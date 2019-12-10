package hoeckbankgroup.demo.controller;

import hoeckbankgroup.demo.model.DAO.PersoonDAO;
import hoeckbankgroup.demo.model.TestKlant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddTestKlantToDb {

    @Autowired
    private PersoonDAO persoonDAO;

    @GetMapping("fdb")
    public String fillDatabase(){
        TestKlant testKlant = new TestKlant("user", "test");
        persoonDAO.save(testKlant);

        return "login";
    }


}
