package hoeckbankgroup.demo.model;


import javax.persistence.*;
import java.util.List;

/**
 * Auteur Anne van den Bosch
 * POJO voor MKB klant
 */
@Entity
public class MKB extends Klant{

    private String bedrijfsnaam;
    private String sector;
    private String accountmanager;

    public MKB(){
        super();
    }

    public MKB(String email, String wachtwoord, String straat, String huisnummer, String postcode, String woonplaats, String telefoonNummer, List<Rekening> rekeningen, String bedrijfsnaam, String sector, String accountmanager) {
        super(email, wachtwoord, straat, huisnummer, postcode, woonplaats, telefoonNummer, rekeningen);
        this.bedrijfsnaam = bedrijfsnaam;
        this.sector = sector;
        this.accountmanager = accountmanager;
    }

    public MKB(String email, String wachtwoord, String straat, String huisnummer, String postcode, String woonplaats, String telefoonNummer, String bedrijfsnaam, String sector, String accountmanager) {
        super(email, wachtwoord, straat, huisnummer, postcode, woonplaats, telefoonNummer);
        this.bedrijfsnaam = bedrijfsnaam;
        this.sector = sector;
        this.accountmanager = accountmanager;
    }

    public String getBedrijfsnaam() {return bedrijfsnaam;}

    public void setBedrijfsnaam(String bedrijfsnaam) {this.bedrijfsnaam = bedrijfsnaam;}

    public String getSector() {return sector;}

    public void setSector(String sector) {this.sector = sector;}

    public String getAccountmanager() {return accountmanager;}

    public void setAccountmanager(String accountmanager) {this.accountmanager = accountmanager;}



}
