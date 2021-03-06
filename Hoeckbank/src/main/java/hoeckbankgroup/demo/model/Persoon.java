package hoeckbankgroup.demo.model;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Persoon {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int personId;

    //@Column(unique = true)
    private String email;
    private String wachtwoord;

    protected Persoon(){
        super();
    }

    public Persoon(String email, String wachtwoord){
        super();
        this.email = email;
        this.wachtwoord = wachtwoord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getPersonId() {
        return personId;
    }
}
