package hoeckbankgroup.demo.model.service;


import hoeckbankgroup.demo.model.DAO.MKBDAO;
import hoeckbankgroup.demo.model.Particulier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hoeckbankgroup.demo.model.DAO.ParticulierDAO;
import javax.servlet.http.Part;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@Service
public class ParticulierService {

    @Autowired
    private ParticulierDAO particulierDAO;

    public Particulier findParticulierbyBSN(String bsn){
        return particulierDAO.findParticulierByBSN(bsn);
    }

    public Particulier findParticulierById(int id){
        return particulierDAO.findParticulierByPersonId(id);
    }

    public void save(Particulier particulier){
        particulierDAO.save(particulier);
    }

    public boolean controleerGeboortedatum (String geboortedatumString){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate geboortedatum = LocalDate.parse(geboortedatumString, dateTimeFormatter);
        LocalDate vandaag = LocalDate.now(ZoneId.of("Europe/Paris"));
        int leeftijd = (int) ChronoUnit.YEARS.between(geboortedatum, vandaag);
        if (leeftijd >= 18){
            return true;
        }else{
            return false;
        }
    }

    public boolean controleerBestaandeParticulier (String bsn, String email){
        if (particulierDAO.findParticulierByBSN(bsn)==null && particulierDAO.findParticulierByEmail(email) == null){
            return true;
        }else{
            return false;
        }
    }

    public boolean controleerTelefoon (String telefoon){
        return false;
    }

    public boolean controleerWachtwoord(String wachtwoord) {return false;}
}
