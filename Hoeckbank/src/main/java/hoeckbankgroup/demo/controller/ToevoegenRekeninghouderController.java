package hoeckbankgroup.demo.controller;

import hoeckbankgroup.demo.model.Gebruiker;
import hoeckbankgroup.demo.model.Koppel;
import hoeckbankgroup.demo.model.Rekening;
import hoeckbankgroup.demo.model.service.KoppelService;
import hoeckbankgroup.demo.model.service.RekeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class ToevoegenRekeninghouderController {

    //@Responsebody bij les van Remi, postcode

    @Autowired
    private RekeningService rekeningService;

    @Autowired
    private KoppelService koppelService;

    @GetMapping("toevoegenrekeninghouder")
    private String toevoegenRekeninghouderHandler(@SessionAttribute("gebruiker") Gebruiker gebruiker,
                                                  @RequestParam (value = "melding", required = false) String melding, Model model) {
        model.addAttribute("koppel_error", melding);
        return "toevoegenrekeninghouder";
    }

    @PostMapping("do_toevoegen_rekeninghouder") //th:action in template
    public String doToevoegenHandler(@RequestParam(name = "rekening_id") int rekeningId,
                                     @RequestParam(name = "gebruiker_naam_mede_rekeninghouder") String email,
                                     @RequestParam(name = "beveiligingscode") int beveiligingscode,
                                     @SessionAttribute("gebruiker") Gebruiker gebruiker, Model model) {

        Rekening rekening = rekeningService.findRekeningByRekeningID(rekeningId);
        String error = "De ingevoerde rekeninghouder kan niet worden gekoppeld";

        if (koppelService.validateEmail(email) && !koppelService.checkOpEigenEmail(gebruiker.getId(), email)) {
            if (koppelService.checkOpGebruikersnaamEnRekeningnummer(email, rekening.getRekeningnummer())) {
                Koppel koppel = new Koppel(rekening.getRekeningnummer(), email, beveiligingscode);
                koppelService.save(koppel);
                return "redirect:/rekeningdetail?id=" + rekeningId;
            } else {
                model.addAttribute("koppel_error1", "De ingevoerde rekeninghouder is al gekoppeld");
                return "redirect:/toevoegenrekeninghouder?id=" + rekeningId + "&melding=" + error;
            }
        } else {
            model.addAttribute("koppel_error2", "De ingevoerde rekeninghouder kan niet worden gekoppeld");
                    //"De ingevoerde rekeninghouder bestaat niet");
            return "redirect:/toevoegenrekeninghouder?id=" + rekeningId + "&melding=" + error;
        }
        // valideren , als een rekening is gekoppeld, dan kan die niet nog een keer gekoppeld worden
        // header text maken bij rekeningdetail dat de rekening aanvraag voor koppelen mede rekeninghouder is aangevraagd
    }
}

