package hoeckbankgroup.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class betalingMakenController {

    @GetMapping("betalingmaken")
    public String betalingMakenHandler(){
        return "betalingmaken";
    }
}
