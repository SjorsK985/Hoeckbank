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
        boolean uniek = false;
        String rekeningNummer = "";
        while(!uniek) {
            String landCode = "NL";
            String bankCode = "HCKB";
            int controleGetal = (int) Math.random() * 100 - 1;
            int rekeningIdentificatie = (int) Math.random() * 1000000000 - 1;
            rekeningNummer = landCode + Integer.toString(controleGetal) + bankCode + Integer.toString(rekeningIdentificatie);
            uniek = checkRekeningnummer(rekeningNummer);
        }
        return rekeningNummer;
    }

    public boolean checkRekeningnummer(String rekeningNummer){
        return rekeningDAO.existsByRekeningnummerEquals(rekeningNummer);
    }
}
