package hoeckbankgroup.demo.controller;

import hoeckbankgroup.demo.model.Gebruiker;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller

public class LogUitController {

    @GetMapping("loguit")
    public String logUitHandler(){
        return "index";
    }

}
