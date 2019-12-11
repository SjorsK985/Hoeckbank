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
    @OneToOne
    private Medewerker accountmanager;

    protected MKB(){
        super();
    }

    public MKB(String email, String wachtwoord, String straat, String huisnummer, String postcode, String woonplaats,
                    String telefoonNummer, List<Rekening> rekeningen, String bedrijfsnaam, String sector, Medewerker accountmanager) {
        super(email, wachtwoord, straat, huisnummer, postcode, woonplaats, telefoonNummer, rekeningen);
        this.bedrijfsnaam = bedrijfsnaam;
        this.sector = sector;
        this.accountmanager = accountmanager;
    }

    public MKB(String email, String wachtwoord, String straat, String huisnummer, String postcode, String woonplaats, String telefoonNummer, String bedrijfsnaam, String sector, Medewerker accountmanager) {
        super(email, wachtwoord, straat, huisnummer, postcode, woonplaats, telefoonNummer);
        this.bedrijfsnaam = bedrijfsnaam;
        this.sector = sector;
        this.accountmanager = accountmanager;
    }

    public MKB(String email, String wachtwoord, String straat, String huisnummer, String postcode, String woonplaats,
               String telefoonNummer, List<Rekening> rekeningen, String bedrijfsnaam, String sector) {
        super(email, wachtwoord, straat, huisnummer, postcode, woonplaats, telefoonNummer, rekeningen);
        this.bedrijfsnaam = bedrijfsnaam;
        this.sector = sector;
        this.accountmanager=null;

    }

    public String getBedrijfsnaam() {return bedrijfsnaam;}

    public void setBedrijfsnaam(String bedrijfsnaam) {this.bedrijfsnaam = bedrijfsnaam;}

    public String getSector() {return sector;}

    public void setSector(String sector) {this.sector = sector;}

    public Medewerker getAccountmanager() {return accountmanager;}

    public void setAccountmanager(Medewerker accountmanager) {this.accountmanager = accountmanager;}



}
