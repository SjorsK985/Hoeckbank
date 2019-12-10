package hoeckbankgroup.demo.controller;

import hoeckbankgroup.demo.model.Particulier;
import hoeckbankgroup.demo.model.Rekening;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.awt.*;
import java.util.ArrayList;

@Controller
public class RekeningenOverzichtController {

    @GetMapping("rekeningenoverzicht")
    public String registerHandler(Model model){

        /** Test Data  **/
        Rekening rekening1 = new Rekening("118014305", 200.25);
        Rekening rekening2 = new Rekening("1180197534", 3501.89);
        Rekening rekening3 = new Rekening("3180197992\n", 0.34);
        ArrayList<Rekening> rekeningen = new ArrayList<>();
        /** Test Data  **/

        Particulier particulier = new Particulier("test@test.com", "test", "Appelmansstraat", "1", "1423AK", "uithoorn", "065745621", rekeningen );
        model.addAttribute("gebruiker", particulier);
        model.addAttribute("rekeningen", rekeningen);
        return "rekeningenoverzicht";
    }

}
