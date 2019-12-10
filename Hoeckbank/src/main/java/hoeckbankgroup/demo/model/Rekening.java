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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rekeningID;
    private String rekeningnummer;
    private double saldo;

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "klant_id")*/
    @ManyToMany(mappedBy = "rekeningen")
    private List<Klant> klanten;

    public Rekening(String rekeningnummer, double saldo) {
        this.rekeningnummer = rekeningnummer;
        this.saldo = saldo;
    }

    public Rekening(){
        this("onbekend", 0.00);
    }

    public String getRekeningnummer() {return rekeningnummer;}

    public void setRekeningnummer(String rekeningnummer) {this.rekeningnummer = rekeningnummer;}

    public double getSaldo() {return saldo;}

    public void setSaldo(double saldo) {this.saldo = saldo;}
}
