package hoeckbankgroup.demo.model.enums;

public enum Branche {
    LANDBOUW("Landbouw, Bosbouw & Visserij"),
    INDUSTRIE("Lichte & Zware Industrie"),
    BOUW("Bouw & Grondverzet"),
    NUTS("Energie- & Watervoorziening"),
    LOGISTIEK("Transport & Logistiek"),
    GROOTHANDEL("Groothandel & Import/Export"),
    DETAILHANDEL("Detailhandel"),
    VASTGOED("Vastgoedbeheer & Woningcorporaties"),
    OVERHEDEN("Overheden"),
    ZORG("Gezondheidszorg"),
    ONDERWIJS("Onderwijs"),
    HORECA("Horeca"),
    CREATIEVESECTOR("Creatieve sector wo Kunsten, Muziek & Vormgeving");

    public final String naam;

    private Branche(String naam){
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }
}