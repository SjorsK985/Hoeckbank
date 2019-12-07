package hoeckbankgroup.demo.model;

import javax.persistence.Entity;
import java.util.ArrayList;


@Entity
public class Medewerker extends Persoon{

    private String functie;

    public Medewerker(int personID, String gebruikersnaam, String wachtwoord, String functie) {
        super(personID, gebruikersnaam, wachtwoord);
        this.functie = functie;
    }

    public Medewerker(){
        this(0,"onbekend", "onbekend","onbekend");
    }

    public String getFunctie() {return functie;}

    public void setFunctie(String functie) {this.functie = functie;}
}
