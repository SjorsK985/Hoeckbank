package hoeckbankgroup.demo.model;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Persoon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int personID;
    private String gebruikersnaam;
    private String wachtwoord;

    public Persoon(int personID, String gebruikersnaam, String wachtwoord){
        super();
        this.personID = personID;
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
    }

    public Persoon() {
        this(0, "onbekend", "onbekend");
    }

    public int getPersonID() {return personID;}

    public void setPersonID(int personID) {this.personID = personID;}

    public String getGebruikersnaam() {return gebruikersnaam;}

    public void setGebruikersnaam(String gebruikersnaam) {this.gebruikersnaam = gebruikersnaam;}

    public String getWachtwoord() {return wachtwoord;}

    public void setWachtwoord(String wachtwoord) {this.wachtwoord = wachtwoord;}
}
