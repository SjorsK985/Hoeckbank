package hoeckbankgroup.demo.controller;

import hoeckbankgroup.demo.model.Gebruiker;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogUitController {

    @GetMapping("loguit")
    public String logUitHandler(Model model){

        return "index";
    }

}
