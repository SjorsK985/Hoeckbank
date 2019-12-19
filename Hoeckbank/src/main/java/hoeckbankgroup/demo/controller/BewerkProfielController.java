package hoeckbankgroup.demo.controller;
import hoeckbankgroup.demo.model.Gebruiker;
import hoeckbankgroup.demo.model.MKB;
import hoeckbankgroup.demo.model.Particulier;
import hoeckbankgroup.demo.model.service.MKBService;
import hoeckbankgroup.demo.model.service.ParticulierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("gebruiker")
public class BewerkProfielController {

    @Autowired
    ParticulierService particulierService;

    @Autowired
    MKBService mkbService;

    @GetMapping("bewerkprofiel")
    private String editProfileHandler(Model model){
        Gebruiker gebruiker = (Gebruiker) model.getAttribute("gebruiker");
        if(gebruiker.getRol().equals("Particulier")) {
            Particulier particulier = particulierService.findParticulierById(gebruiker.getId());
            model.addAttribute("particulier", particulier);
            return "bewerkprofielparticulier";
        } else {
            MKB mkb = mkbService.findMKBById(gebruiker.getId());
            model.addAttribute("mkb", mkb);
            return "bewerkprofielmkb";
        }
    }

    @PostMapping("do_change_profile_particulier")
    private String doChangeProfileParticulierHandler(@ModelAttribute(name="particulier") Particulier particulier) {
        particulierService.save(particulier);
        return "redirect:/rekeningenoverzicht";
    }

    @PostMapping("do_change_profile_mkb")
    private String doChangeProfileMKBHandler(@ModelAttribute(name="mbk") MKB mkb) {
        mkbService.save(mkb);
        return "redirect:/rekeningenoverzicht";
    }
}