package hoeckbankgroup.demo.model;

import java.util.ArrayList;

public class Particulier extends Klant {

    private String voornaam;
    private String tussenvoegsel;
    private String achternaam;
    private int BSN;

    public Particulier(String adres, String gebruikersnaam, String wachtwoord, String woonplaats,
                       ArrayList<Rekening> rekeningen, String voornaam, String tussenvoegsel, String achternaam, int BSN) {
        super(adres, gebruikersnaam, wachtwoord, woonplaats, rekeningen);
        this.voornaam = voornaam;
        this.tussenvoegsel = tussenvoegsel;
        this.achternaam = achternaam;
        this.BSN = BSN;
    }

    public Particulier(String gebruikersnaam, String wachtwoord, String voornaam, String tussenvoegsel, String achternaam, int BSN) {
        super(gebruikersnaam, wachtwoord);
        this.voornaam = voornaam;
        this.tussenvoegsel = tussenvoegsel;
        this.achternaam = achternaam;
        this.BSN = BSN;
    }

    public Particulier(String adres, String gebruikersnaam, String wachtwoord, String woonplaats,
                       ArrayList<Rekening> rekeningen, String voornaam, String achternaam, int BSN) {
        super(adres, gebruikersnaam, wachtwoord, woonplaats, rekeningen);
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.BSN = BSN;
    }

    public Particulier(String gebruikersnaam, String wachtwoord, String voornaam, String achternaam, int BSN) {
        super(gebruikersnaam, wachtwoord);
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.BSN = BSN;
    }

    public String getVoornaam() {return voornaam;}

    public void setVoornaam(String voornaam) {this.voornaam = voornaam;}

    public String getTussenvoegsel() {return tussenvoegsel;}

    public void setTussenvoegsel(String tussenvoegsel) {this.tussenvoegsel = tussenvoegsel;}

    public String getAchternaam() {return achternaam; }

    public void setAchternaam(String achternaam) {this.achternaam = achternaam;}

    public int getBSN() {return BSN;}

    public void setBSN(int BSN) {this.BSN = BSN;}
}
