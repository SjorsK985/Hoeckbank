package hoeckbankgroup.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Adres {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int adresID;
    private String straat;
    private String huisnummer;
    private String postcode;
    private String plaats;

    //public final String POSTCODEREGEX = "^[1-9][0-9]{3}? [A-Za-z]{2}";

    public Adres(){
        this("onbekend", "0", "onbekend", "onbekend");
    }

    public Adres(String straat, String huisnummer, String postcode, String plaats) {
        this.straat = straat;
        this.huisnummer = huisnummer;
        this.postcode = postcode;
        this.plaats = plaats;
    }

    public int getAdresID() {
        return adresID;
    }

    public void setAdresID(int adresID) {
        this.adresID = adresID;
    }

    public String getStraat() {
        return straat;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public String getHuisnummer() {
        return huisnummer;
    }

    public void setHuisnummer(String huisnummer) {
        this.huisnummer = huisnummer;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPlaats() {
        return plaats;
    }

    public void setPlaats(String plaats) {
        this.plaats = plaats;
    }
}
