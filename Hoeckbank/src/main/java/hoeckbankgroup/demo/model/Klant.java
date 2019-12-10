package hoeckbankgroup.demo.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.util.ArrayList;

/**
 * Auteurs Anne van den Bosch en Ruben van den Akker
 * POJO Klant
 */

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Klant extends Persoon{

    private String straat;
    private String huisnummer;  //gekozen voor string want sommige nummers hebben nog a of b
    private String postcode;
    private String woonplaats;

    public Klant(int personID, String gebruikersnaam, String wachtwoord, String straat,
                 String huisnummer, String postcode, String woonplaats) {
        super(personID, gebruikersnaam, wachtwoord);
        this.straat = straat;
        this.huisnummer = huisnummer;
        this.postcode = postcode;
        this.woonplaats = woonplaats;
    }

    public Klant() {
        this(0,"onbekend","onbekend",
                "onbekend","onbekend","onbekend","onbekend");
    }

    public String getStraat() {return straat;}

    public void setStraat(String straat) {this.straat = straat;}

    public String getHuisnummer() {return huisnummer;}

    public void setHuisnummer(String huisnummer) {this.huisnummer = huisnummer;}

    public String getPostcode() {return postcode;}

    public void setPostcode(String postcode) {this.postcode = postcode;}

    public String getWoonplaats() {return woonplaats;}

    public void setWoonplaats(String woonplaats) {this.woonplaats = woonplaats;}
}
