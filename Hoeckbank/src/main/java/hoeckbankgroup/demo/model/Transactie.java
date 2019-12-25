package hoeckbankgroup.demo.model;

import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Auteur Anne van den Bosch
 * POJO Transactie
 */
@Entity
public class Transactie implements Comparable<Transactie> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int transactieId;

    private String tegenRekening;
    private double bedrag;
    private String omschrijving;
    private LocalDate datum;

    protected Transactie(){
        super();
    }

    public Transactie(String tegenRekening, double bedrag, String omschrijving, LocalDate datum) {
        this.tegenRekening = tegenRekening;
        this.bedrag = bedrag;
        this.omschrijving = omschrijving;
        this.datum = datum;
    }

    public String getTegenRekening() {
        return tegenRekening;
    }

    public void setTegenRekening(String tegenRekening) {
        this.tegenRekening = tegenRekening;
    }

    public double getBedrag() {
        return bedrag;
    }

    public void setBedrag(double bedrag) {
        this.bedrag = bedrag;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public int getTransactieId() {
        return transactieId;
    }

    @Override
    public int compareTo(Transactie transactie) {
        return transactie.getDatum().compareTo(this.getDatum());
    }

}
