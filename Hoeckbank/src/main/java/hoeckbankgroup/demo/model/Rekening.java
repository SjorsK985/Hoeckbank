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
    private String tenaamstelling;

    @OneToMany (cascade = CascadeType.ALL)
    private List<Klant> rekeninghouder;

    @OneToMany (cascade = CascadeType.ALL)
    private List<Transactie>transactiehistorie;

    public Rekening(String rekeningnummer, double saldo, String tenaamstelling) {
        this.rekeningnummer = rekeningnummer;
        this.saldo = saldo;
        this.tenaamstelling = tenaamstelling;
    }

    public Rekening(){
        super();
    }

    public String getRekeningnummer() {return rekeningnummer;}

    public void setRekeningnummer(String rekeningnummer) {this.rekeningnummer = rekeningnummer;}

    public double getSaldo() {return saldo;}

    public void setSaldo(double saldo) {this.saldo = saldo;}

    public String getTenaamstelling() {
        return tenaamstelling;
    }
    public void setTenaamstelling(String tenaamstelling) {
        this.tenaamstelling = tenaamstelling;
    }
    public List<Klant> getRekeninghouder() {
        return rekeninghouder;
    }

    public void setRekeninghouder(List<Klant> rekeninghouder) {
        this.rekeninghouder = rekeninghouder;
    }

    public List<Transactie> getTransactiehistorie() {
        return transactiehistorie;
    }

    public void setTransactiehistorie(List<Transactie> transactiehistorie) {
        this.transactiehistorie = transactiehistorie;
    }

    public int getRekeningID() {
        return rekeningID;
    }
}
