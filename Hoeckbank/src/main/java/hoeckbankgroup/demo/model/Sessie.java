package hoeckbankgroup.demo.model;

import java.util.List;

public class Sessie {
    private int id;
    private List<Rekening> rekeningen;
    private String rol;

    public Sessie(int id, List<Rekening> rekeningen, String rol) {
        this.id = id;
        this.rekeningen = rekeningen;
        this.rol = rol;
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
}
