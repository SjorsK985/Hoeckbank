package hoeckbankgroup.demo.controller;

import hoeckbankgroup.demo.model.Rekening;
import hoeckbankgroup.demo.model.Sessie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes({"gebruiker", "sessie"})
public class RekeningenOverzichtController {

    @GetMapping("rekeningenoverzicht")
    public String rekeningenOverzichtHandler(Model model){

        Sessie sessie = (Sessie)model.getAttribute("sessie");
        List<Rekening> rekeningen = sessie.getRekeningen();
        System.out.println(rekeningen);
        //System.out.println(rekeningen.get(0).getRekeningnummer() + "  " +rekeningen.get(0).getTenaamstelling()  );
        //model.addAttribute("rekeningen", sessie.getRekeningen());

        // --> DEZE GAAT FOUT
        //model.addAttribute("rekeningen", rekeningen);
        /*try{

        }catch(NullPointerException error){
            System.out.println(error.getMessage());
        }*/
        //model.addAttribute("rekeningen", sessie.getRekeningen());

        return "rekeningenoverzicht";
    }

}
