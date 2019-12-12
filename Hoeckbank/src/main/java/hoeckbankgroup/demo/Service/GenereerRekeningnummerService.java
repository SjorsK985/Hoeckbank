package hoeckbankgroup.demo.Service;

import hoeckbankgroup.demo.model.DAO.RekeningDAO;
import hoeckbankgroup.demo.model.Rekening;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class GenereerRekeningnummerService {

    @Autowired
    private RekeningDAO rekeningDAO;

    public GenereerRekeningnummerService(){
        super();
    }

    public String genereerRekeningnummer(){
        String rekeningNummer = "";
        String landCode = "NL";
        String bankCode = "HCKB";
        int controleGetal = (int) (Math.random() * 100);
        int rekeningIdentificatieEen = (int) (Math.random() * 100000);
        int rekeningIdentificatieTwee = (int) (Math.random() * 100000);
        rekeningNummer = landCode + String.valueOf(controleGetal) + bankCode + String.valueOf(rekeningIdentificatieEen) + String.valueOf(rekeningIdentificatieTwee);
        return rekeningNummer;
    }

    public boolean checkRekeningnummer(String rekeningNummer){
        return rekeningDAO.existsByRekeningnummerEquals(rekeningNummer);
    }
}
