package hoeckbankgroup.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("login")
    public String loginHandler(Model model) {
        model.addAttribute("header_text", "Hier kan je inloggen");
        return "login";
    }

    @GetMapping("")
    public String indexHandler(){
        return "index";
    }

}