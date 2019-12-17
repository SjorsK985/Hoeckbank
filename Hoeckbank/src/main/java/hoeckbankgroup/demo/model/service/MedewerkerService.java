package hoeckbankgroup.demo.model.service;

import hoeckbankgroup.demo.model.DAO.KlantDAO;
import hoeckbankgroup.demo.model.DAO.MedewerkerDAO;
import hoeckbankgroup.demo.model.Klant;
import hoeckbankgroup.demo.model.Medewerker;
import hoeckbankgroup.demo.model.Rekening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedewerkerService {

    @Autowired
    private MedewerkerDAO medewerkerDAO;

    public Medewerker findMedewerkerByEmail(String email){
        return medewerkerDAO.findMedewerkerByEmail(email);
    }


}
