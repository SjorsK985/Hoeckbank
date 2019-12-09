package hoeckbankgroup.demo.model;

import javax.persistence.*;
import java.util.ArrayList;
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

   /* @OneToMany(fetch = FetchType.LAZY, mappedBy = "klant")*/
   @ManyToMany(cascade = { CascadeType.ALL})
/*    @JoinTable(
            name = "rekeningen_klant",
            joinColumns = { @JoinColumn(name = "klant_id") },
            inverseJoinColumns = { @JoinColumn(name = "rekening_id") }
    )*/
    private List<Rekening> rekeningen;

    public MKB(int personID, String gebruikersnaam, String wachtwoord, String straat,
               String huisnummer, String postcode, String woonplaats, String bedrijfsnaam,
               String sector, String accountmanager, List<Rekening> rekeningen) {
        super(personID, gebruikersnaam, wachtwoord, straat, huisnummer, postcode, woonplaats);
        this.bedrijfsnaam = bedrijfsnaam;
        this.sector = sector;
        this.accountmanager = accountmanager;
        this.rekeningen = rekeningen;
    }

    public MKB(int personID, String gebruikersnaam, String wachtwoord, String straat,
               String huisnummer, String postcode, String woonplaats, String bedrijfsnaam,
               String sector, String accountmanager) {
        super(personID, gebruikersnaam, wachtwoord, straat, huisnummer, postcode, woonplaats);
        this.bedrijfsnaam = bedrijfsnaam;
        this.sector = sector;
        this.accountmanager = accountmanager;
    }

    public MKB(int personID, String gebruikersnaam, String wachtwoord, String straat,
               String huisnummer, String postcode, String woonplaats, String bedrijfsnaam, String sector) {
        super(personID, gebruikersnaam, wachtwoord, straat, huisnummer, postcode, woonplaats);
        this.bedrijfsnaam = bedrijfsnaam;
        this.sector = sector;
    }

    public MKB (){}

    public String getBedrijfsnaam() {return bedrijfsnaam;}

    public void setBedrijfsnaam(String bedrijfsnaam) {this.bedrijfsnaam = bedrijfsnaam;}

    public String getSector() {return sector;}

    public void setSector(String sector) {this.sector = sector;}

    public String getAccountmanager() {return accountmanager;}

    public void setAccountmanager(String accountmanager) {this.accountmanager = accountmanager;}
}
