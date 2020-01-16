package hoeckbankgroup.demo.controller;

import hoeckbankgroup.demo.model.*;
import hoeckbankgroup.demo.model.service.KlantService;
import hoeckbankgroup.demo.model.service.KoppelService;
import hoeckbankgroup.demo.model.service.RekeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
public class KoppelenRekeningController {

    @Autowired
    private KoppelService koppelService;

    @Autowired
    private KlantService klantService;

    @Autowired
    private RekeningService rekeningService;

    @GetMapping("koppelenrekening")
    private String koppelenRekeningHandler(@RequestParam (value = "melding", required = false) String melding,
                                           @SessionAttribute("gebruiker") Gebruiker gebruiker, Model model){
        model.addAttribute("koppel_error", melding);
        return "koppelenrekening";
    }

    @PostMapping("do_koppelen")
    private String doKoppelenHandler(@RequestParam(name = "rekeningnummer") String rekeningnummer,
                                     @RequestParam(name = "beveiligingscode") String beveiligingscode,
                                     @SessionAttribute("gebruiker") Gebruiker gebruiker, Model model){
        Klant klant = klantService.findKlantByPersonId(gebruiker.getId());
        Rekening rekening = rekeningService.findRekeningByRekeningnummer(rekeningnummer);
        List<Rekening> rekeningList = klant.getRekeningen();
        Koppel koppel = koppelService.findKoppel(rekeningnummer, klant.getEmail());
        String error = "Koppelen kan niet worden voltooid, probeer opnieuw";
        if(koppelService.checkOpKoppelen(rekeningnummer, beveiligingscode, klant.getEmail())){
            rekening.addRekeninghouder(klant);
            rekeningService.save(rekening);

            rekeningList.add(rekening);
            klantService.save(klant);

            koppelService.delete(koppel);
            return "redirect:/rekeningenoverzicht";
        } else {
            model.addAttribute("koppel_error", error);
            return "redirect:/koppelenrekening?melding=" + error;
        }
    }
}
