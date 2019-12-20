package hoeckbankgroup.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Gebruiker {
    private int id;
    private List<Rekening> rekeningen;
    private String rol;
    private String huidigRekeningnummer;

    public Gebruiker(int id, List<Rekening> rekeningen, String rol) {
        this.id = id;
        this.rekeningen = rekeningen;
        this.rol = rol;
    }

    public Gebruiker(int id, String rol){
        this.id = id;
        this.rol = rol;
        this.rekeningen = new ArrayList<>();
    }

    public Gebruiker(int id, List<Rekening> rekeningen, String rol, String huidigRekeningnummer) {
        this.id = id;
        this.rekeningen = rekeningen;
        this.rol = rol;
        this.huidigRekeningnummer = huidigRekeningnummer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Rekening> getRekeningen() {
        return rekeningen;
    }

    public void setRekeningen(List<Rekening> rekeningen) {
        this.rekeningen = rekeningen;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getHuidigRekeningnummer() {
        return huidigRekeningnummer;
    }

    public void setHuidigRekeningnummer(String huidigRekeningnummer) {
        this.huidigRekeningnummer = huidigRekeningnummer;
    }
}
