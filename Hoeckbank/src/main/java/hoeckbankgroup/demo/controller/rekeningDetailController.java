package hoeckbankgroup.demo.controller;

import hoeckbankgroup.demo.model.Rekening;
import hoeckbankgroup.demo.model.service.RekeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class rekeningDetailController {

    @Autowired
    private RekeningService rekeningService;

    @GetMapping("rekeningdetail")
    public String rekeningDetailHandler(@RequestParam int id, Model model){
        Rekening rekening = rekeningService.findRekeningByRekeningID(id);
        model.addAttribute("rekening", rekening);
        return "rekeningdetail";
    }
}
