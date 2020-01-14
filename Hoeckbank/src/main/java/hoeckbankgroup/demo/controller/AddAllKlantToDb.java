package hoeckbankgroup.demo.controller;
import hoeckbankgroup.demo.model.*;
import hoeckbankgroup.demo.model.DAO.*;
import hoeckbankgroup.demo.model.enums.Branche;
import hoeckbankgroup.demo.model.enums.Geslacht;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

@Controller
public class AddAllKlantToDb {
    @Autowired
    private ParticulierDAO particulierDao;
    @Autowired
    private MKBDAO mkbDao;
    @Autowired
    private MedewerkerDAO medewerkerDao;
    @Autowired
    private RekeningDAO rekeningDAO;
    @Autowired
    private PostcodeDAO postcodeDAO;

    Geslacht geslacht;

    Branche sector;

    @GetMapping("inleesmedewerker")
    private String inlezenmedewerker() {
        try {
            Scanner invoer = new Scanner(new File("../Hoeckbank/src/main/resources/static/inleesdocumenten/inleesmedewerker.csv"));
            while (invoer.hasNextLine()) {
                String regelUitBestand = invoer.nextLine();

                String[] regelArray;
                regelArray = regelUitBestand.split(";");
                Medewerker medewerker = new Medewerker(regelArray[0], regelArray[1], regelArray[2]);

                System.out.println("Medewerker :" + regelArray[0]);
                medewerkerDao.save(medewerker);
            }

        } catch (FileNotFoundException nietGevonden) {
            System.out.println("Het bestand is niet gevonden.");
        }
        return "login";
    }

    @GetMapping("inleesmkb")
    private String inlezenMKB() {
        try {
            Scanner invoer = new Scanner(new File("../Hoeckbank/src/main/resources/static/inleesdocumenten/inleesmkb.csv"));
            while (invoer.hasNextLine()) {
                String regelUitBestand = invoer.nextLine();

                String[] regelArray;
                regelArray = regelUitBestand.split(";");
                List<Rekening> rekeningen = new ArrayList<>();
                String tenaamstelling = String.format("%s", regelArray[8]);
                int geld = geefRandomGetal(4000, -1000);
                double geldbedrag = Math.round(geldbedrag = geld / 1.123) / 100.0;
                Rekening rekening = new Rekening(regelArray[7], geldbedrag, tenaamstelling);
                rekeningen.add(rekening);
                sector = Branche.LANDBOUW;
                MKB mkb = new MKB(regelArray[0], regelArray[1], new Adres(regelArray[2], regelArray[3], regelArray[4],
                        regelArray[5]), regelArray[6], rekeningen, regelArray[8], sector);

                System.out.println("MKB: " + regelArray[0] + " saldo : " + geldbedrag);
                mkbDao.save(mkb);
            }

        } catch (FileNotFoundException nietGevonden) {
            System.out.println("Het bestand is niet gevonden.");
        }
        return "login";
    }


    @GetMapping("inleesparticulier")
    private String inlezenparticulier() {
        try {
            Scanner invoer = new Scanner(new File("../Hoeckbank/src/main/resources/static/inleesdocumenten/inleesparticulier.csv"));
            while (invoer.hasNextLine()) {
                String regelUitBestand = invoer.nextLine();

                String[] regelArray;
                regelArray = regelUitBestand.split(";");
                List<Rekening> rekeningen = new ArrayList<>();
                String tenaamstelling = String.format("%s %s %s", regelArray[9], regelArray[10], regelArray[11]);
                int geld = geefRandomGetal(4000, -1000);
                double geldbedrag = Math.round(geldbedrag = geld / 1.2536) / 100.0;
                Rekening rekening1 = new Rekening(regelArray[7], geldbedrag, tenaamstelling);
                int geld1 = geefRandomGetal(10000, -1000);
                double geldbedrag1 = Math.round(geldbedrag = geld1 / 0.6954) / 100.0;
                Rekening rekening2 = new Rekening(regelArray[8], geldbedrag1, tenaamstelling);
                rekeningen.add(rekening1);
                rekeningen.add(rekening2);
                if(regelArray[13].equals("M")){
                    geslacht = Geslacht.MAN;
                } else if(regelArray[13].equals("V")){
                    geslacht = Geslacht.VROUW;
                } else{
                    geslacht = Geslacht.NEUTRAAL;
                }

                int bsn = Integer.parseInt(regelArray[12]);
                Particulier particulier=new Particulier(regelArray[0],regelArray[1], new Adres(regelArray[2],regelArray[3],regelArray[4],
                        regelArray[5]),regelArray[6],rekeningen,regelArray[9],regelArray[10],regelArray[11],regelArray[12], geslacht,regelArray[14]);
                System.out.println("Particulier: " + regelArray[0]);
                particulierDao.save(particulier);

            }

        } catch (FileNotFoundException nietGevonden) {
            System.out.println("Het bestand is niet gevonden.");
        }
        return "login";
    }

    @GetMapping("inleespostcodes")
    private String inlezenPostcodes() {
        try {
            Scanner invoer = new Scanner(new File("../Hoeckbank/src/main/resources/static/inleesdocumenten/postcodes.csv"));
            while (invoer.hasNextLine()) {
                String regelUitBestand = invoer.nextLine();
                String[] regelArray;
                regelArray = regelUitBestand.split(",");
                Postcode postcode = new Postcode(regelArray[0], Integer.parseInt(regelArray[1]), Integer.parseInt(regelArray[2]), regelArray[3], regelArray[4]);
                postcodeDAO.save(postcode);
            }

        } catch (FileNotFoundException nietGevonden) {
            System.out.println("Het bestand is niet gevonden.");
        }
        return "index";
    }

    @GetMapping("inleesvbpostcode")
    private String inleesVBPostcode(){
        Postcode postcode = new Postcode("1000AA",1,10,"Lutjebroekstraat","Lutjebroek");
        return "index";
    }

    @GetMapping("inleesall")
    private String inlezenall() {
        inlezenmedewerker();
        inlezenMKB();
        inlezenparticulier();
        rekeninginlezen();
        inleesVBPostcode();
        return "login";
    }

    private List<Transactie> gettransacties(){
        try {
            Scanner invoer = new Scanner(new File("../Hoeckbank/src/main/resources/static/inleesdocumenten/inleestransacties.csv"));
            List<Transactie> transacties = new ArrayList<>();
            while (invoer.hasNextLine()) {
                String regelUitBestand = invoer.nextLine();
                String[] regelArray;
                regelArray = regelUitBestand.split(";");
                double bedrag = Double.parseDouble(regelArray[1]);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                formatter = formatter.withLocale(Locale.getDefault());  // Locale specifies human language for translating, and cultural norms for lowercase/uppercase and abbreviations and such. Example: Locale.US or Locale.CANADA_FRENCH
                LocalDateTime date = LocalDateTime.parse(regelArray[3], formatter);
                Transactie transactie = new Transactie(regelArray[0], bedrag, regelArray[2], date);
                transacties.add(transactie);
                System.out.println(bedrag);
            }
            return transacties;
        } catch (FileNotFoundException nietGevonden) {
            System.out.println("Het bestand is niet gevonden.");
        }
        return null;
    }

    @GetMapping("rekeninginlezen")
    private String rekeninginlezen() {
        List<Rekening> rekeningen = rekeningDAO.findAll();
        int i = 0;
        for (Rekening rekening : rekeningen) {
            i++;
            if (i < 50) {
                rekening.setTransactiehistorie(gettransacties());
                rekeningDAO.save(rekening);
            }
        }
        return "login";
    }

    public static int geefRandomGetal(int aantal, int vanaf) { //van doet mee tot doet mee
        return (int) ((aantal + 1) * Math.random() + vanaf); //hoogste getal=antal+vanaf -- laagste=vanaf
    }
}
