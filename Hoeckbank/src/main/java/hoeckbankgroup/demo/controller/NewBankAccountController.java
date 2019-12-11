package hoeckbankgroup.demo.controller;

import hoeckbankgroup.demo.Service.NewBankAccountService;
import hoeckbankgroup.demo.model.Klant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NewBankAccountController {

    @Autowired
    private NewBankAccountService newBankAccountService;

    @PostMapping("confirm_newbankaccount")
    private String confirmNewBankAccount(@ModelAttribute(name="gebruiker") Klant klant){

        return "accountsummary";
    }

}
