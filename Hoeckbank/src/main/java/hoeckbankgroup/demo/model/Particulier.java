package hoeckbankgroup.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Particulier extends Klant {

    private String voornaam;
    private String tussenvoegsel;
    private String achternaam;
    private String BSN;
    private String geslacht;
    private String geboorteDatum;


    protected Particulier(){
        super();
    }

    public Particulier(String email, String wachtwoord, String straat, String huisnummer, String postcode,
                       String woonplaats, String telefoonNummer, List<Rekening> rekeningen, String voornaam,
                       String tussenvoegsel, String achternaam, String BSN, String geslacht, String geboorteDatum) {
        super(email, wachtwoord, straat, huisnummer, postcode, woonplaats, telefoonNummer, rekeningen);
        this.voornaam = voornaam;
        this.tussenvoegsel = tussenvoegsel;
        this.achternaam = achternaam;
        this.BSN = BSN;
        this.geslacht = geslacht;
        this.geboorteDatum = geboorteDatum;
    }

    public Particulier(String email, String wachtwoord, String straat, String huisnummer, String postcode,
                       String woonplaats, String telefoonNummer, String voornaam, String tussenvoegsel,
                       String achternaam, String BSN, String geslacht, String geboorteDatum) {
        super(email, wachtwoord, straat, huisnummer, postcode, woonplaats, telefoonNummer);
        this.voornaam = voornaam;
        this.tussenvoegsel = tussenvoegsel;
        this.achternaam = achternaam;
        this.BSN = BSN;
        this.geslacht = geslacht;
        this.geboorteDatum = geboorteDatum;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getTussenvoegsel() {
        return tussenvoegsel;
    }

    public void setTussenvoegsel(String tussenvoegsel) {
        this.tussenvoegsel = tussenvoegsel;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getBSN() {
        return BSN;
    }

    public void setBSN(String BSN) {
        this.BSN = BSN;
    }

    public String getGeslacht() {
        return geslacht;
    }

    public void setGeslacht(String geslacht) {
        this.geslacht = geslacht;
    }

    public String getGeboorteDatum() {
        return geboorteDatum;
    }

    public void setGeboorteDatum(String geboorteDatum) {
        this.geboorteDatum = geboorteDatum;
    }
}
