package hoeckbankgroup.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class templateController {

    @GetMapping("template")
    public String templateHandler(){ return "template";}
    //RK: Deze controller is ter demonstratie van de Thymeleaf fragments
    // Kan later verwijderd worden.

}
