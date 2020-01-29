package hoeckbankgroup.demo.model;

import javax.persistence.*;

@Entity
public class Pinautomaat {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int pinautomaatID;
    private String code;
    @ManyToOne
    private Rekening rekening;

    public Pinautomaat() {
        super();
    }

    public int getPinautomaatID() {
        return pinautomaatID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Rekening getRekening() {
        return rekening;
    }

    public void setRekening(Rekening rekening) {
        this.rekening = rekening;
    }
}
