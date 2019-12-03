package hoeckbankgroup.demo.model;

import java.util.ArrayList;

/**
 * Auteurs Anne van den Bosch en Ruben van den Akker
 * POJO Klant
 */
public class Klant  {


    private String adres; //straat + huisnummer
    private String gebruikersnaam;
    private String wachtwoord;
    private String woonplaats;
    public ArrayList<Rekening> rekeningen;

    public Klant(String adres, String gebruikersnaam, String wachtwoord, String woonplaats, ArrayList<Rekening> rekeningen) {
        this.adres = adres;
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
        this.woonplaats = woonplaats;
        this.rekeningen = rekeningen;
    }

    public Klant(String gebruikersnaam, String wachtwoord, String adres, String woonplaats) {
       this(gebruikersnaam, wachtwoord,adres,  woonplaats, new ArrayList<Rekening>());
    }

    public Klant(String gebruikersnaam, String wachtwoord) {
        this(gebruikersnaam, wachtwoord,"onbekend", "onbekend");
    }

    public String getAdres() {return adres;}

    public void setAdres(String adres) {this.adres = adres;}

    public String getGebruikersnaam() {return gebruikersnaam;}

    public void setGebruikersnaam(String gebruikersnaam) {this.gebruikersnaam = gebruikersnaam;}

    public String getWachtwoord() {return wachtwoord;}

    public void setWachtwoord(String wachtwoord) {this.wachtwoord = wachtwoord;}

    public String getWoonplaats() {return woonplaats;}

    public void setWoonplaats(String woonplaats) {this.woonplaats = woonplaats;}
}
