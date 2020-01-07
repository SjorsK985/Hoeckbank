package hoeckbankgroup.demo.model;

import hoeckbankgroup.demo.model.enums.Geslacht;

import javax.persistence.*;
import java.util.List;

@Entity
public class Particulier extends Klant {

    private String voornaam;
    private String tussenvoegsel;
    private String achternaam;
    private String BSN;
    @Enumerated(EnumType.STRING)
    private Geslacht geslacht;
    private String geboorteDatum;


    protected Particulier(){
        super();
    }

    public Particulier(String email, String wachtwoord, String straat, String huisnummer, String postcode,
                       String woonplaats, String telefoonNummer, List<Rekening> rekeningen, String voornaam,
                       String tussenvoegsel, String achternaam, String BSN, Geslacht geslacht, String geboorteDatum) {
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
                       String achternaam, String BSN, Geslacht geslacht, String geboorteDatum) {
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
        return geslacht.getStringValue();
    }

    public void setGeslacht(Geslacht geslacht) {
        this.geslacht = geslacht;
    }

    public String getGeboorteDatum() {
        return geboorteDatum;
    }

    public void setGeboorteDatum(String geboorteDatum) {
        this.geboorteDatum = geboorteDatum;
    }
}
