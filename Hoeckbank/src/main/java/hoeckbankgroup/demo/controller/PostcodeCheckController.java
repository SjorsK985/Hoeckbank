package hoeckbankgroup.demo.controller;

import hoeckbankgroup.demo.model.Postcode;
import hoeckbankgroup.demo.model.service.PostcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostcodeCheckController {

    @Autowired
    private PostcodeService postcodeService;

    @CrossOrigin
    @PostMapping("/postcodecheck")
    public @ResponseBody
    Postcode postCodecheckHandler(@RequestParam String postcode, @RequestParam int housenumber){
        Postcode newPostcode = postcodeService.getPostcodeByPostcode(postcode);
        if (newPostcode!=null){
            if(housenumber < newPostcode.getMinHuisnr() && housenumber > newPostcode.getMaxHuisnr()){
            newPostcode = null;
            }
        }
        return newPostcode;
    }
}
