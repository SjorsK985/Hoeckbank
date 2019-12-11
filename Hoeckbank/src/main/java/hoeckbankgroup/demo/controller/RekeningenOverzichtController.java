package hoeckbankgroup.demo.controller;

import hoeckbankgroup.demo.model.Klant;
import hoeckbankgroup.demo.model.Particulier;
import hoeckbankgroup.demo.model.Rekening;
import hoeckbankgroup.demo.model.Sessie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RekeningenOverzichtController {

    @GetMapping("rekeningenoverzicht")
    public String registerHandler(Model model){

        /**####################### Test Data  #######################**/
        /*Rekening rekening1 = new Rekening("118014305", 200.25, "R. Kulk");
        Rekening rekening2 = new Rekening("1180197534", 3501.89, "P. van der Beek");
        Rekening rekening3 = new Rekening("3180197992\n", 0.34, "L. Elshout");
        ArrayList<Rekening> rekeningen = new ArrayList<>();
        rekeningen.add(rekening1);
        rekeningen.add(rekening2);
        rekeningen.add(rekening3);
        Particulier klant1 = new Particulier("test@test.com", "test", "Appelmansstraat",
                "1", "1423AK", "uithoorn", "065745621", rekeningen,
                "Klant1", "", "Kulk", 456456546, "man", "01-01-2000" );
        Particulier klant2 = new Particulier("test@test.com", "test", "Appelmansstraat",
                "1", "1423AK", "uithoorn", "065745621", rekeningen,
                "Klant2", "de", "Boer", 456456546, "man", "01-01-2000" );
        Particulier klant3 = new Particulier("test@test.com", "test", "Appelmansstraat",
                "1", "1423AK", "uithoorn", "065745621", rekeningen,
                "Klant3", "van der", "Beek", 456456546, "man", "01-01-2000" );*/
        /**####################### Test Data  #######################**/
        Sessie sessie = (Sessie)model.getAttribute("sessie");
        List<Rekening> rekeningen = sessie.getRekeningen();
        System.out.println(rekeningen.get(0).getRekeningnummer());

        model.addAttribute("rekeningen", sessie.getRekeningen());

        return "rekeningenoverzicht";
    }

}
