package hoeckbankgroup.demo.controller;

import hoeckbankgroup.demo.model.DAO.KoppelDAO;
import hoeckbankgroup.demo.model.Gebruiker;
import hoeckbankgroup.demo.model.Koppel;
import hoeckbankgroup.demo.model.Rekening;
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

@Controller
public class ToevoegenRekeninghouderController {

    @Autowired
    private RekeningService rekeningService;

    @Autowired
    private KoppelService koppelService;

    @Autowired
    private KoppelDAO koppelDAO;

    @GetMapping("toevoegenrekeninghouder")
    private String toevoegenRekeninghouderHandler(@SessionAttribute("gebruiker") Gebruiker gebruiker, Model model) {
        return "toevoegenrekeninghouder";
    }

    @PostMapping("do_toevoegen_rekeninghouder") //th:action in template
    public String doToevoegenHandler(@RequestParam(name = "rekening_id") int rekeningId,
                                     @RequestParam(name = "gebruiker_naam_mede_rekeninghouder") String email, //in template aanwezig
                                     @RequestParam(name = "beveiligingscode") int beveiligingscode,
                                     @SessionAttribute("gebruiker") Gebruiker gebruiker, Model model) {

        Rekening rekening = rekeningService.findRekeningByRekeningID(rekeningId);
        if (koppelService.validateEmail(email)) {
            if (koppelService.checkOpGebruikersnaamEnRekeningnummer(email, rekening.getRekeningnummer())) {
                Koppel koppel = new Koppel(rekening.getRekeningnummer(), email, beveiligingscode);
                koppelService.save(koppel);
                return "redirect:/rekeningdetail?id=" + rekeningId;
            } else {
                model.addAttribute("koppel1_error", "De ingevoerde rekeninghouder is al gekoppeld");
                return "redirect:/toevoegenrekeninghouder?id=" + rekeningId;
            }
        } else {
            model.addAttribute("koppel2_error", "De ingevoerde rekeninghouder bestaat niet");
            return "redirect:/toevoegenrekeninghouder?id=" + rekeningId;
        }
        // valideren , als een rekening is gekoppeld, dan kan die niet nog een keer gekoppeld worden
        // header text maken bij rekeningdetail dat de rekening aanvraag voor koppelen mede rekeninghouder is aangevraagd
    }
}

