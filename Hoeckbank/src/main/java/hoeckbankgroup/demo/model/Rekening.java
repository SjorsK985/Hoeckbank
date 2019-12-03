package hoeckbankgroup.demo.model;

import java.util.ArrayList;

/**
 * Auteurs Anne van den Bosch en Ruben van den Akker
 * POJO rekening
 */
public class Rekening {


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
