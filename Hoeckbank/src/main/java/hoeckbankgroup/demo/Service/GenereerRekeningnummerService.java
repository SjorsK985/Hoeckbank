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
    private static String controleGetal = "45";

    @Autowired
    private RekeningDAO rekeningDAO;

    public GenereerRekeningnummerService(){
        super();
    }

    public String genereerRekeningnummer(){
        StringBuilder rekeningCijfers = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int random = (int)(Math.random() * 9) + 1;
            String randomString = Integer.toString(random);
            rekeningCijfers.append(randomString);
        }
        return "NL45HCKB" + rekeningCijfers;
    }

    public boolean checkRekeningnummer(String rekeningNummer){
        return rekeningDAO.existsByRekeningnummerEquals(rekeningNummer);
    }
}
