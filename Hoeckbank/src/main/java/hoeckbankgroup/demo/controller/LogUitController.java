package hoeckbankgroup.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import javax.servlet.http.HttpSession;

@Controller

public class LogUitController {

    @GetMapping("loguit")
    public String logUitHandler(HttpSession session){
        session.invalidate();
        return "index";
    }

}
