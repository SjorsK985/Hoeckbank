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
        boolean continueLoop = true;
        while(continueLoop){
            rekeningNummer = maakRekeningnummer();
            if(elfProef(rekeningNummer)){
                if(!rekeningnummerBestaatAl(rekeningNummer)){
                    continueLoop = false;
                }
            }
        }
        return  rekeningNummer;
    }

    public String maakRekeningnummer(){
        StringBuilder rekeningCijfers = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int random = (int) (Math.random() * 9);
            String randomString = Integer.toString(random);
            rekeningCijfers.append(randomString);
        }
        return "NL45HCKB" + rekeningCijfers;
    }

    private static boolean elfProef(String rekeningNr){
        String rekeningCijfers = rekeningNr.substring(8,18);
        int totaal = 0;
        int teller = rekeningCijfers.length();
        for (int i = 0; i < rekeningCijfers.length(); i++) {
            String subStringCijfer = rekeningCijfers.substring(i, i+1);
            int cijfer = Integer.parseInt(subStringCijfer);
            totaal = totaal + (cijfer * teller);
            teller--;
        }
        return (totaal % 11) == 0;
    }

    public boolean rekeningnummerBestaatAl(String rekeningNummer){
        return rekeningDAO.existsByRekeningnummerEquals(rekeningNummer);
    }
}
