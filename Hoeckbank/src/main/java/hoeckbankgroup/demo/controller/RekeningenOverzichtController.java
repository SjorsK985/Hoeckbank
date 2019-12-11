package hoeckbankgroup.demo.controller;

import hoeckbankgroup.demo.model.Klant;
import hoeckbankgroup.demo.model.Particulier;
import hoeckbankgroup.demo.model.Rekening;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;

@Controller
public class RekeningenOverzichtController {

    @GetMapping("rekeningenoverzicht")
    public String registerHandler(Model model){

        /**####################### Test Data  #######################**/
        Rekening rekening1 = new Rekening("118014305", 200.25, "R. Kulk");
        Rekening rekening2 = new Rekening("1180197534", 3501.89, "P. van der Beek");
        Rekening rekening3 = new Rekening("3180197992\n", 0.34, "L. Elshout");
        ArrayList<Rekening> rekeningen = new ArrayList<>();
        rekeningen.add(rekening1);
        rekeningen.add(rekening2);
        rekeningen.add(rekening3);
        Particulier klant1 = new Particulier("test@test.com", "test", "Appelmansstraat",
                "1", "1423AK", "uithoorn", "065745621", rekeningen,
                "Klant1", "", "Kulk", 456456546, "man", LocalDate.now() );
        Particulier klant2 = new Particulier("test@test.com", "test", "Appelmansstraat",
                "1", "1423AK", "uithoorn", "065745621", rekeningen,
                "Klant2", "de", "Boer", 456456546, "man", LocalDate.now() );
        Particulier klant3 = new Particulier("test@test.com", "test", "Appelmansstraat",
                "1", "1423AK", "uithoorn", "065745621", rekeningen,
                "Klant3", "van der", "Beek", 456456546, "man", LocalDate.now() );
        /**####################### Test Data  #######################**/

        model.addAttribute("gebruiker", klant1);
        model.addAttribute("rekeningen", rekeningen);

        return "rekeningenoverzicht";
    }

}
