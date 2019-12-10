package hoeckbankgroup.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Medewerker extends Persoon{

    private String functie;

    public Medewerker(){
        super();
    }

    public Medewerker(String email, String wachtwoord, String functie) {
        super(email, wachtwoord);
        this.functie = functie;
    }

    public String getFunctie() {return functie;}

    public void setFunctie(String functie) {this.functie = functie;}

}
