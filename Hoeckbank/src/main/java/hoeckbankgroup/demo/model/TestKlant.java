package hoeckbankgroup.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TestKlant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int klantId;
    private String gebruikersnaam;
    private String wachtwoord;

    public TestKlant() {
        super();
    }

    public TestKlant(String gebruikersnaam, String wachtwoord) {
        super();
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
    }


    public String getGebruikersnaam() {
        return gebruikersnaam;
    }

    public void setGebruikersnaam(String gebruikersnaam) {
        this.gebruikersnaam = gebruikersnaam;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }
}
