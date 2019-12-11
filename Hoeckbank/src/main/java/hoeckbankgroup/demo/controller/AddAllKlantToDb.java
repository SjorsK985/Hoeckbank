package hoeckbankgroup.demo.controller;

import hoeckbankgroup.demo.model.DAO.KlantDAO;
import hoeckbankgroup.demo.model.DAO.MedewerkerDAO;
import hoeckbankgroup.demo.model.DAO.ParticulierDAO;

import hoeckbankgroup.demo.model.Klant;
import hoeckbankgroup.demo.model.Medewerker;
import hoeckbankgroup.demo.model.Particulier;
import hoeckbankgroup.demo.model.Rekening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Controller
public class AddAllKlantToDb {

    @Autowired
   private ParticulierDAO particulierDao;

    @Autowired
    private MedewerkerDAO medewerkerDao;

    @GetMapping("inleesmedewerker")
    private String inleesmedewerker(){
        try {
            Scanner invoer = new Scanner(new File("/Users/Ling/Desktop/inleesmedewerker.csv"));
            while (invoer.hasNextLine()) {
                String regelUitBestand = invoer.nextLine();

                String[] regelArray;
                regelArray = regelUitBestand.split(";");
                Medewerker medewerker =new Medewerker(regelArray[0],regelArray[1],regelArray[2]);

                System.out.println(regelArray[0]);
                medewerkerDao.save(medewerker);
            }

        } catch (FileNotFoundException nietGevonden) {
            System.out.println("Het bestand is niet gevonden.");
        }
        return "login";
    }

    @GetMapping("inleesparticulier")
    private String inleesparticulier(){
       // ArrayList<String> regelsUitBestand= new ArrayList<>();;
        try {
            Scanner invoer = new Scanner(new File("/Users/Ling/Desktop/inleesparticulier.csv"));
            while (invoer.hasNextLine()) {
                String regelUitBestand = invoer.nextLine();
                //regelsUitBestand.add(invoer.nextLine());

               String[] regelArray;
                regelArray = regelUitBestand.split(";");
                List<Rekening> rekeningen = new ArrayList<>();
                Rekening rekening = new Rekening(regelArray[7],0.0);
                rekeningen.add(rekening);
                //LocalDate datum = LocalDate.parse(regelArray[13]);
                int bsn = Integer.parseInt(regelArray[11]);
                Particulier particulier=new Particulier(regelArray[0],regelArray[1],regelArray[2],regelArray[3],regelArray[4],
                        regelArray[5],regelArray[6],rekeningen,regelArray[8],regelArray[9],regelArray[10],bsn,regelArray[12],regelArray[13]);

                System.out.println(regelArray[0]);
                particulierDao.save(particulier);
               // klantDAO.save(particulier);
            }

        } catch (FileNotFoundException nietGevonden) {
            System.out.println("Het bestand is niet gevonden.");
        }
        return "login";
    }
}