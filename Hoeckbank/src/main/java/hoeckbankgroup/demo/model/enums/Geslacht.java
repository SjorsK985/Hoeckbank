package hoeckbankgroup.demo.model.enums;

public enum Geslacht {
    MAN("De heer"),
    VROUW("Mevrouw"),
    NEUTRAAL("Neutraal");

    public final String aanhef;

    private Geslacht(String aanhef){
        this.aanhef = aanhef;
    }

    public String getStringValue() {
        return aanhef;
    }
}
