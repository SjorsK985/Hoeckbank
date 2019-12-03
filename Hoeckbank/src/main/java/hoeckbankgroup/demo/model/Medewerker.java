package hoeckbankgroup.demo.model;

import java.util.ArrayList;

public class Medewerker extends Particulier{

    private String functie;

    public Medewerker(String gebruikersnaam, String wachtwoord, String voornaam, String achternaam,
                      int BSN, String functie) {
        super(gebruikersnaam, wachtwoord, voornaam, achternaam, BSN);
        this.functie = functie;
    }

    public String getFunctie() {return functie;}

    public void setFunctie(String functie) {this.functie = functie;}
}
