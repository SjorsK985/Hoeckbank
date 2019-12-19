package hoeckbankgroup.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Koppel extends Persoon{

//    @OneToMany(cascade = CascadeType.ALL)
//    private List<Klant> rekeninghouder;

    private String mederekeninghouder;

    private String rekeningnummer;
    private int beveiliginscode;

    protected Koppel(){
        super();
    }

    public Koppel(String rekeningnummer, String rekeninghouder, int beveiliginscode) {
        this.rekeningnummer = rekeningnummer;
        this.mederekeninghouder = rekeninghouder;
        this.beveiliginscode = beveiliginscode;
    }

    public String getRekeningnummer() {
        return rekeningnummer;
    }

    public void setRekeningnummer(String rekeningnummer) {
        this.rekeningnummer = rekeningnummer;
    }

    public String getRekeninghouder() {
        return mederekeninghouder;
    }

    public void setRekeninghouder(String rekeninghouder) {
        this.mederekeninghouder = rekeninghouder;
    }

    //    public List<Klant> getRekeninghouder() {
//        return rekeninghouder;
//    }
//
//    public void setRekeninghouder(List<Klant> rekeninghouder) {
//        this.rekeninghouder = rekeninghouder;
//    }

    public int getBeveiliginscode() {
        return beveiliginscode;
    }

    public void setBeveiliginscode(int beveiliginscode) {
        this.beveiliginscode = beveiliginscode;
    }
}
