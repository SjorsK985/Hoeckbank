package hoeckbankgroup.demo.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
public class Medewerker extends Persoon{

    private String functie;

    protected Medewerker(){
        super();
    }

    public Medewerker(String email, String wachtwoord, String functie) {
        super(email, wachtwoord);
        this.functie = functie;
    }

    public String getFunctie() {return functie;}

    public void setFunctie(String functie) {this.functie = functie;}

}
