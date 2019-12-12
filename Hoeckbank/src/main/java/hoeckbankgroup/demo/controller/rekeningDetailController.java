package hoeckbankgroup.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class rekeningDetailController {

    @GetMapping("rekeningdetail")
    public String rekeningDetailHandler(){
        return "rekeningdetail";
    }
}
