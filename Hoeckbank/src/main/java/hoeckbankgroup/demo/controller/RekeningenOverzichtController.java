package hoeckbankgroup.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RekeningenOverzichtController {

    @GetMapping("rekeningenoverzicht")
    public String registerHandler(){
        return "rekeningenoverzicht";
    }

}
