package hoeckbankgroup.demo.model.enums;

public enum Geslacht {
    MAN("Hr"),
    VROUW("Mw"),
    NEUTRAAL("Ntr");

    public final String aanhef;

    private Geslacht(String aanhef){
        this.aanhef = aanhef;
    }

    public String getStringValue() {
        return aanhef;
    }
}
