package hoeckbankgroup.demo.controller;


import hoeckbankgroup.demo.model.Gebruiker;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class RekeningenOverzichtController {

    @GetMapping("rekeningenoverzicht")
    public String rekeningenOverzichtHandler(@SessionAttribute("gebruiker") Gebruiker gebruiker, Model model){
        model.addAttribute("rekeningen", gebruiker.getRekeningen());
        return "rekeningenoverzicht";
    }

}
