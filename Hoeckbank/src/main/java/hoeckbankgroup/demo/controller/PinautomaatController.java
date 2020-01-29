package hoeckbankgroup.demo.controller;


import com.google.gson.Gson;
import hoeckbankgroup.demo.model.PaymentMachineConnectionData;
import hoeckbankgroup.demo.model.Pinautomaat;
import hoeckbankgroup.demo.model.Rekening;
import hoeckbankgroup.demo.model.service.PinautomaatService;
import hoeckbankgroup.demo.model.service.RekeningService;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;


@Controller
public class PinautomaatController {

    @Autowired
    private PinautomaatService pinautomaatService;
    @Autowired
    private RekeningService rekeningService;

    @GetMapping("pinautomaat")
    public String pinautomaatHandler(Model model) {
        System.out.println("pinautomaat");
        model.addAttribute("code", "");
        return "pinautomaat";
    }

    @PostMapping("pinautomaatopslaan")
    private String pinautomaatOpslaanHandler(@RequestParam(name = "rekeningnummer") String rekeningnummer, Model model) {
        String codePinautomaat = pinautomaatService.genereerCode();
        model.addAttribute("rekening", rekeningnummer);
        model.addAttribute("code", codePinautomaat);
        Pinautomaat pinautomaat = new Pinautomaat();
        pinautomaat.setCode(codePinautomaat);
        Rekening rekening = rekeningService.findRekeningByRekeningnummer(rekeningnummer);
        pinautomaat.setRekening(rekening);
        pinautomaatService.save(pinautomaat);
        System.out.println("koppelen maar " + rekeningnummer);
        return "pinautomaat";
    }

    @PostMapping("/paymentmachine/connect")
    public String paymentConnectHandler(@RequestBody PaymentMachineConnectionData paymentMachineConnectionData) {
        if (rekeningService.findRekeningByRekeningnummer(paymentMachineConnectionData.getAccount()) != null) {
            Rekening rekening = rekeningService.findRekeningByRekeningnummer(paymentMachineConnectionData.getAccount());
            int controle = paymentMachineConnectionData.getCheck();
            if (pinautomaatService.validateAccount(rekening, controle).isSucceeded()) {
                System.out.println("gelukt");
                Gson gson = new Gson();
                String json = gson.toJson(pinautomaatService.validateAccount(rekening, controle));
                sendPost(json);
            }
            System.out.println(rekening.getTenaamstelling());
        }
        return "login";
    }

    private void sendPost(String jsonString) {
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            //HttpPost httpPost = new HttpPost("https://webhook.site/f9733aa4-63b4-45c9-9bdf-f9da92b3f285");
            HttpPost httpPost = new HttpPost("http://localhost:8081/connect");
            StringEntity entity = new StringEntity(jsonString);
            httpPost.setEntity(entity);
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
            CloseableHttpResponse response = client.execute(httpPost);
            System.out.println("Server response: " + response);
            client.close();
        } catch (IOException error) {
            System.out.println(error.getMessage());
        }
    }
}
