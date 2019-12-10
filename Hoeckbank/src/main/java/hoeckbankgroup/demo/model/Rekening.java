package hoeckbankgroup.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

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
