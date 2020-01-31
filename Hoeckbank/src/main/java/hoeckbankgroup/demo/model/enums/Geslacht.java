package hoeckbankgroup.demo.model.enums;

/*
Author: Sjors Koevoets
Enum met geslacht-opties
 */
public enum Geslacht {
    MAN("Meneer"),
    VROUW("Mevrouw"),
    NEUTRAAL("Neutraal");

    //veld voor String
    public final String aanhef;

    private Geslacht(String aanhef){
        this.aanhef = aanhef;
    }

    public String getStringValue() {
        return aanhef;
    }
}
