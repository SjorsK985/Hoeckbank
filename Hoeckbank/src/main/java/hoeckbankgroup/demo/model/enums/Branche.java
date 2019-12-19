package hoeckbankgroup.demo.model.enums;

public enum Branche {
    LANDBOUW("Landbouw, Bosbouw & Visserij"),
    INDUSTRIE("Lichte & Zware industrie"),
    BOUW("Bouw & Grondverzet"),
    NUTS("Energie- & Watervoorziening"),
    GROOTHANDEL("Groothandel & Import"),
    DETAILHANDEL("Detailhandel & Winkelwezen"),
    LOGISTIEK("Transport & Logistiek"),
    OVERHEDEN("Landelijke & regionale overheden"),
    ZORG("Klinieken en Verzorgingshuizen"),
    ONDERWIJS("Jeugd- & volwassenenonderwijs"),
    SCHEPPENDEKUNSTEN("Scheppende kunsten");

    public final String naam;

    private Branche(String naam){
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }
}