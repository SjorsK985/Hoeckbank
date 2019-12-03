package hoeckbankgroup.demo.model;

import java.time.LocalDate;

/**
 * Auteur Anne van den Bosch
 * POJO Transactie
 */
public class Transactie {

    private Rekening creditRekening;
    private Rekening debitRekening;
    private double bedrag;
    private String omschrijving;
    private LocalDate datum;

    public Transactie(Rekening creditRekening, Rekening debitRekening, double bedrag, String omschrijving, LocalDate datum) {
        this.creditRekening = creditRekening;
        this.debitRekening = debitRekening;
        this.bedrag = bedrag;
        this.omschrijving = omschrijving;
        this.datum = datum;
    }

    public Rekening getCreditRekening() {return creditRekening;}

    public void setCreditRekening(Rekening creditRekening) {this.creditRekening = creditRekening;}

    public Rekening getDebitRekening() {return debitRekening;}

    public void setDebitRekening(Rekening debitRekening) {this.debitRekening = debitRekening;}

    public double getBedrag() {return bedrag;}

    public void setBedrag(double bedrag) {this.bedrag = bedrag;}

    public String getOmschrijving() {return omschrijving;}

    public void setOmschrijving(String omschrijving) {this.omschrijving = omschrijving;}

    public LocalDate getDatum() {return datum;}

    public void setDatum(LocalDate datum) {this.datum = datum;}
}