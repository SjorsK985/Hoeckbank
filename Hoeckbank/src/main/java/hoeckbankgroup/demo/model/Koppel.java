package hoeckbankgroup.demo.model;

import javax.persistence.*;

@Entity
public class Koppel extends Persoon{
    private String mederekeninghouder;
    private String rekeningnummer;
    private String beveiligingscode;

    protected Koppel(){
        super();
    }

    public Koppel(String rekeningnummer, String rekeninghouder, String beveiligingscode) {
        this.rekeningnummer = rekeningnummer;
        this.mederekeninghouder = rekeninghouder;
        this.beveiligingscode = beveiligingscode;
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

    public String getBeveiligingscode() {
        return beveiligingscode;
    }

    public void setBeveiligingscode(String beveiligingscode) {
        this.beveiligingscode = beveiligingscode;
    }
}
