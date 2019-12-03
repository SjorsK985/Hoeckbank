package hoeckbankgroup.demo.model;

import java.util.ArrayList;

/**
 * Auteur Anne van den Bosch
 * POJO voor MKB klant
 */
public class MKB extends Klant{


    private String bedrijfsnaam;
    private String sector;
    private String accountmanager;

    public MKB(String adres, String gebruikersnaam, String wachtwoord, String woonplaats, ArrayList<Rekening> rekeningen,
               String bedrijfsnaam, String sector, String accountmanager) {
        super(adres, gebruikersnaam, wachtwoord, woonplaats, rekeningen);
        this.bedrijfsnaam = bedrijfsnaam;
        this.sector = sector;
        this.accountmanager = accountmanager;
    }

    public MKB(String gebruikersnaam, String wachtwoord,
               String bedrijfsnaam, String sector, String accountmanager) {
        super(gebruikersnaam, wachtwoord);
        this.bedrijfsnaam = bedrijfsnaam;
        this.sector = sector;
        this.accountmanager = accountmanager;
    }

    public MKB (){
        this("onbekend", "onbekend", "onbekend", "onbekend", "onbekend");
    }

    public String getBedrijfsnaam() {return bedrijfsnaam;}

    public void setBedrijfsnaam(String bedrijfsnaam) {this.bedrijfsnaam = bedrijfsnaam;}

    public String getSector() {return sector;}

    public void setSector(String sector) {this.sector = sector;}

    public String getAccountmanager() {return accountmanager;}

    public void setAccountmanager(String accountmanager) {this.accountmanager = accountmanager;}
}
