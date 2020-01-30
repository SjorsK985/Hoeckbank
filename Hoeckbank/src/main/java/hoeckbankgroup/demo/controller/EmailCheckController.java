package hoeckbankgroup.demo.controller;
import hoeckbankgroup.demo.model.service.KlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

/*
Author: Sjors Koevoets
Controller die ervoor zorgt dat gecheckt wordt of een emailadres al bestaat en dmv Ajax wordt doorgegeven aan pagina
 */
@Controller
public class EmailCheckController {
    @Autowired
    KlantService klantService;

    @CrossOrigin
    @PostMapping("/emailcheck")
    public @ResponseBody
    String checkEmail(@RequestParam String email){
        boolean response;
        try {
            response = klantService.klantExistsByEmail(email);
            if(response == true){
                return "true";
            } else {
                return "false";
            }
        } catch (EmptyResultDataAccessException ex) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Adres niet gevonden", ex);
        } catch (Exception ex) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Things went wrong on our side", ex);
        }
    }
}
