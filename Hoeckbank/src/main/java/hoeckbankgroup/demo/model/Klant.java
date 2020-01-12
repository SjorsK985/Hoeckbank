package hoeckbankgroup.demo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Auteurs Anne van den Bosch en Ruben van den Akker
 * POJO Klant
 */

@Entity
public class Klant extends Persoon{

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Adres adres;
    private String telefoonNummer;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Rekening> rekeningen;

    protected Klant(){
        super();
    }

    public Klant(String email, String wachtwoord) {
        super(email, wachtwoord);
        this.adres = new Adres();
        this.telefoonNummer = "onbekend";
        this.rekeningen = new ArrayList<>();
    }

    public Klant(String email, String wachtwoord, Adres adres, String telefoonNummer, List<Rekening> rekeningen) {
        super(email, wachtwoord);
        this.adres = adres;
        this.telefoonNummer = telefoonNummer;
        this.rekeningen = rekeningen;
    }


    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public String getTelefoonNummer() {
        return telefoonNummer;
    }

    public void setTelefoonNummer(String telefoonNummer) {
        this.telefoonNummer = telefoonNummer;
    }

    public List<Rekening> getRekeningen() {
        return rekeningen;
    }

    public void setRekeningen(List<Rekening> rekeningen) {
        this.rekeningen = rekeningen;
    }

    public void addRekening(Rekening rekening){
        rekeningen.add(rekening);
    }
}
