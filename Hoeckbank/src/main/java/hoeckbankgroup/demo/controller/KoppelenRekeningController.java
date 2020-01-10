package hoeckbankgroup.demo.controller;

import hoeckbankgroup.demo.model.DAO.RekeningDAO;
import hoeckbankgroup.demo.model.Gebruiker;
import hoeckbankgroup.demo.model.service.RekeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class KoppelenRekeningController {

  //  @Autowired
    @GetMapping("koppelenrekening")
    private String koppelenRekeningHandler(@SessionAttribute("gebruiker")Gebruiker gebruiker,
                                           @RequestParam (value= "melding", required = false) String melding, Model model){
        model.addAttribute("koppel_error", melding); // template html
        return "toevoegenrekeninghouder";
    }

}
