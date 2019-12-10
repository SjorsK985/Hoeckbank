package hoeckbankgroup.demo.model;

import javax.persistence.*;
import java.util.List;

/**
 * Auteurs Anne van den Bosch en Ruben van den Akker
 * POJO Klant
 */

@Entity
public class Klant extends Persoon{

    private String straat;
    private String huisnummer;  //gekozen voor string want sommige nummers hebben nog a of b
    private String postcode;
    private String woonplaats;
    private String telefoonNummer;
    @OneToMany
    private List<Rekening> rekeningen;

    public Klant(){
        super();
    }


    public Klant(String email, String wachtwoord, String straat, String huisnummer, String postcode, String woonplaats, String telefoonNummer, List<Rekening> rekeningen) {
        super(email, wachtwoord);
        this.straat = straat;
        this.huisnummer = huisnummer;
        this.postcode = postcode;
        this.woonplaats = woonplaats;
        this.telefoonNummer = telefoonNummer;
        this.rekeningen = rekeningen;
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
