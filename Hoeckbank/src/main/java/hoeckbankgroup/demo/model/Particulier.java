package hoeckbankgroup.demo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Particulier extends Klant {

    private String voornaam;
    private String tussenvoegsel;
    private String achternaam;
    private int BSN;

    private String email;
    private String phone;
    private String gender;
    private String DoB;

 /*   @OneToMany(fetch = FetchType.LAZY, mappedBy = "klant")*/
    @ManyToMany(cascade = { CascadeType.ALL})
/*    @JoinTable(
            name = "rekeningen_klant",
            joinColumns = { @JoinColumn(name = "klant_id") },
            inverseJoinColumns = { @JoinColumn(name = "rekening_id") }
    )*/
    private List<Rekening> rekeningen;

    public Particulier(int personID, String gebruikersnaam, String wachtwoord, String straat,
                       String huisnummer, String postcode, String woonplaats, String voornaam,
                       String tussenvoegsel, String achternaam, int BSN, String email, String phone,
                       String gender, String doB, List<Rekening> rekeningen) {
        super(personID, gebruikersnaam, wachtwoord, straat, huisnummer, postcode, woonplaats);
        this.voornaam = voornaam;
        this.tussenvoegsel = tussenvoegsel;
        this.achternaam = achternaam;
        this.BSN = BSN;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.DoB = doB;
        this.rekeningen = rekeningen;
    }

    public Particulier(int personID, String gebruikersnaam, String wachtwoord, String straat,
                       String huisnummer, String postcode, String woonplaats, String voornaam,
                       String tussenvoegsel, String achternaam, int BSN) {
        super(personID, gebruikersnaam, wachtwoord, straat, huisnummer, postcode, woonplaats);
        this.voornaam = voornaam;
        this.tussenvoegsel = tussenvoegsel;
        this.achternaam = achternaam;
        this.BSN = BSN;
        this.email = "onbekend";
        this.phone = "onbekend";
        this.gender = "onbekend";
        this.DoB = "onbekend";
        this.rekeningen = new
    }

    public Particulier(){}

    public String getVoornaam() {return voornaam;}

    public void setVoornaam(String voornaam) {this.voornaam = voornaam;}

    public String getTussenvoegsel() {return tussenvoegsel;}

    public void setTussenvoegsel(String tussenvoegsel) {this.tussenvoegsel = tussenvoegsel;}

    public String getAchternaam() {return achternaam; }

    public void setAchternaam(String achternaam) {this.achternaam = achternaam;}

    public int getBSN() {return BSN;}

    public void setBSN(int BSN) {this.BSN = BSN;}
}
