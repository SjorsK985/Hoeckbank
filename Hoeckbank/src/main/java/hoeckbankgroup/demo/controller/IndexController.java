package hoeckbankgroup.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("login")
    public String loginHandler(Model model) {
        model.addAttribute("header_text", "Hier kan je inloggen");
        model.addAttribute("log", "loguit");
        return "login";
    }

    @GetMapping("index")
    public String indexHandler(Model model){
        model.addAttribute("log", "login");
        return "index";
    }

    @GetMapping("/")
    public String indexHandler1(Model model){
        model.addAttribute("log", "login");
        return "index";
    }

}