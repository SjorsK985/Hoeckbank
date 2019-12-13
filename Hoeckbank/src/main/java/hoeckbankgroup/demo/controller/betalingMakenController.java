package hoeckbankgroup.demo.controller;

import hoeckbankgroup.demo.model.Rekening;
import hoeckbankgroup.demo.model.service.RekeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class betalingMakenController {

    @Autowired
    private RekeningService rekeningService;

    @GetMapping("betalingmaken")
    public String betalingMakenHandler(@RequestParam int id, Model model){
        Rekening rekening = rekeningService.findRekeningByRekeningID(id);
        System.out.println(rekening.getRekeningnummer());
        System.out.println(rekening.getTenaamstelling());
        model.addAttribute("rekening", rekening);
        return "betalingmaken";
    }

    @PostMapping("do_transactie")
    public String doTransactieHandler(){
        return "rekeningdetail";
    }
}
