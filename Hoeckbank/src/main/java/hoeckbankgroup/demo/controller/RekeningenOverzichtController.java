package hoeckbankgroup.demo.controller;


import hoeckbankgroup.demo.model.Gebruiker;
import hoeckbankgroup.demo.model.Klant;
import hoeckbankgroup.demo.model.service.KlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class RekeningenOverzichtController {

    @Autowired
    private KlantService klantService;

    @GetMapping("rekeningenoverzicht")
    public String rekeningenOverzichtHandler(@SessionAttribute("gebruiker") Gebruiker gebruiker, Model model){
        int personId = gebruiker.getId();
        Klant klant = klantService.findKlantByPersonId(personId);
        model.addAttribute("rekeningen", klant.getRekeningen());
        return "rekeningenoverzicht";
    }

}
