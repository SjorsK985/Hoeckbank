package hoeckbankgroup.demo.controller;

import hoeckbankgroup.demo.model.Gebruiker;
import hoeckbankgroup.demo.model.Rekening;
import hoeckbankgroup.demo.model.Transactie;
import hoeckbankgroup.demo.model.service.RekeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class RekeningDetailController {

    @Autowired
    private RekeningService rekeningService;

    @GetMapping("rekeningdetail")
    public String rekeningDetailHandler(@RequestParam int id, @SessionAttribute("gebruiker") Gebruiker gebruiker, Model model){
        Rekening rekening = rekeningService.findRekeningByRekeningID(id);
        List<Transactie> alleTransacties = rekening.getTransactiehistorie();
        Collections.sort(alleTransacties);

        // Zet transacties in nieuwe lijst om er max 10 te weergeven:
        ArrayList<Transactie> transacties = new ArrayList<>();
        for (int i = 0; i < 10 && i < alleTransacties.size(); i++) {
            transacties.add(alleTransacties.get(i));
        }
        
        model.addAttribute("rekening", rekening);
        model.addAttribute("transacties", transacties);
        return "rekeningdetail";
    }

}
