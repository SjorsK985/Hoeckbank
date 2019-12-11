package hoeckbankgroup.demo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Auteurs Anne van den Bosch en Ruben van den Akker
 * POJO rekening
 */

@Entity
public class Rekening {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int rekeningID;

    private String rekeningnummer;
    private double saldo;

    @OneToMany (cascade = CascadeType.ALL)
    private List<Klant> rekeninghouder;

    public Rekening(String rekeningnummer, double saldo) {
        this.rekeningnummer = rekeningnummer;
        this.saldo = saldo;
    }

    public Rekening(){
        super();
    }

    public String getRekeningnummer() {return rekeningnummer;}

    public void setRekeningnummer(String rekeningnummer) {this.rekeningnummer = rekeningnummer;}

    public double getSaldo() {return saldo;}

    public void setSaldo(double saldo) {this.saldo = saldo;}

    public int getRekeningID() {
        return rekeningID;
    }

    public List<Klant> getRekeninghouder() {
        return rekeninghouder;
    }

    public void setRekeninghouder(List<Klant> rekeninghouder) {
        this.rekeninghouder = rekeninghouder;
    }
}
