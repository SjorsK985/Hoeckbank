package hoeckbankgroup.demo.controller;

import hoeckbankgroup.demo.model.Gebruiker;
import hoeckbankgroup.demo.model.Rekening;
import hoeckbankgroup.demo.model.Transactie;
import hoeckbankgroup.demo.model.service.RekeningService;
import hoeckbankgroup.demo.model.service.TransactieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import java.util.ArrayList;


@Controller
public class RekeningDetailController {

    @Autowired
    private RekeningService rekeningService;

    @Autowired
    private TransactieService transactieService;

    @GetMapping("rekeningdetail")
    public String rekeningDetailHandler(@RequestParam int id, @SessionAttribute("gebruiker") Gebruiker gebruiker, Model model){
        Rekening rekening = rekeningService.findRekeningByRekeningID(id);
        ArrayList<Transactie> transacties = transactieService.getLastTransactions(rekening);
        model.addAttribute("rekening", rekening);
        model.addAttribute("transacties", transacties);
        return "rekeningdetail";
    }

}
