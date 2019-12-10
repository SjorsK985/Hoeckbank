package hoeckbankgroup.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;


public class Medewerker extends Particulier{

    private int medewerkerID;

    private String functie;

    public Medewerker(){
        super();

    }

    public Medewerker(String gebruikersnaam, String wachtwoord, String voornaam, String achternaam,
                      int BSN, String functie) {
        super(gebruikersnaam, wachtwoord, voornaam, achternaam, BSN);
        this.functie = functie;
    }

    public String getFunctie() {return functie;}

    public void setFunctie(String functie) {this.functie = functie;}

    public int getMedewerkerID() {
        return medewerkerID;
    }
}
