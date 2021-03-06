package hoeckbankgroup.demo.model;


import hoeckbankgroup.demo.model.enums.Branche;

import javax.persistence.*;
import java.util.List;

/**
 * Auteur Anne van den Bosch
 * POJO voor MKB klant
 */
@Entity
public class MKB extends Klant{

    private String bedrijfsnaam;
    @Enumerated(EnumType.STRING)
    private Branche sector;
    @OneToOne
    private Medewerker accountmanager;

    protected MKB(){
        super();
    }

    public MKB(String email, String wachtwoord, Adres adres, String telefoonNummer, List<Rekening> rekeningen, String bedrijfsnaam, Branche sector, Medewerker accountmanager) {
        super(email, wachtwoord, adres, telefoonNummer, rekeningen);
        this.bedrijfsnaam = bedrijfsnaam;
        this.sector = sector;
        this.accountmanager = accountmanager;
    }

    public MKB(String email, String wachtwoord, Adres adres, String telefoonNummer, List<Rekening> rekeningen, String bedrijfsnaam, Branche sector) {
        super(email, wachtwoord, adres, telefoonNummer, rekeningen);
        this.bedrijfsnaam = bedrijfsnaam;
        this.sector = sector;
        this.accountmanager=null;
    }

    public String getBedrijfsnaam() {return bedrijfsnaam;}

    public void setBedrijfsnaam(String bedrijfsnaam) {this.bedrijfsnaam = bedrijfsnaam;}

    public Branche getSector() {
        return sector;
    }

    public void setSector(Branche sector) {
        this.sector = sector;
    }

    public Medewerker getAccountmanager() {return accountmanager;}

    public void setAccountmanager(Medewerker accountmanager) {this.accountmanager = accountmanager;}
}
