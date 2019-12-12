package hoeckbankgroup.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
public class IndexController {

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