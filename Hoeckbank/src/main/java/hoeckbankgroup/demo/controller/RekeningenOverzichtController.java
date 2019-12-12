package hoeckbankgroup.demo.controller;

import hoeckbankgroup.demo.model.Klant;
import hoeckbankgroup.demo.model.Rekening;
import hoeckbankgroup.demo.model.Sessie;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes({"gebruiker", "sessie"})
public class RekeningenOverzichtController {

    @GetMapping("rekeningenoverzicht")
    ///public String someMethod(@ModelAttribute("sessie") Sessie sessie){
    public String rekeningenOverzichtHandler(Model model){
        Sessie sessie = (Sessie)model.getAttribute("sessie");

        model.addAttribute("rekeningen", sessie.getRekeningen());
        ///Klant klant = (Klant)model.getAttribute("gebruiker");
        /*List<Rekening> rekeningen = sessie.getRekeningen();
        System.out.println(sessie);
        //System.out.println(rekeningen.get(0).getRekeningnummer() + "  " +rekeningen.get(0).getTenaamstelling()  );*/

        //model.addAttribute("rekeningen", sessie.getRekeningen());

        return "rekeningenoverzicht";
    }

}
