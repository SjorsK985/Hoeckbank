package hoeckbankgroup.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class rekeningDetailController {

    @GetMapping("rekeningdetail")
    public String rekeningDetailHandler(@RequestParam int id){
        System.out.println(id);
        return "rekeningdetail";
    }
}
