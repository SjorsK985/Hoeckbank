package hoeckbankgroup.demo.controller;

import hoeckbankgroup.demo.model.DAO.KlantDAO;
import hoeckbankgroup.demo.model.DAO.MedewerkerDAO;
import hoeckbankgroup.demo.model.DAO.ParticulierDAO;
import hoeckbankgroup.demo.model.DAO.RekeningDAO;
import hoeckbankgroup.demo.model.Klant;
import hoeckbankgroup.demo.model.Medewerker;
import hoeckbankgroup.demo.model.Rekening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

@Controller
public class AddAllKlantToDb {

    @Autowired
    private KlantDAO klantDAO;





    @GetMapping("fdbwk")
    private void inlezen(){
       // ArrayList<String> regelsUitBestand= new ArrayList<>();;
        try {
            Scanner invoer = new Scanner(new File("d:/test.csv"));
            while (invoer.hasNextLine()) {
                String regelUitBestand = invoer.nextLine();
              //  regelsUitBestand.add(invoer.nextLine());


                String[] regelArray;
                regelArray = regelUitBestand.split(";");
                Klant klant=new Klant(regelArray[0],regelArray[1],regelArray[2],regelArray[3]);
                System.out.println(regelArray[0]+" "+regelArray[1]+" "+regelArray[2]+" "+regelArray[3]+" "+regelArray[4]);

                klantDAO.save(klant);


            }

        } catch (FileNotFoundException nietGevonden) {
            System.out.println("Het bestand is niet gevonden.");
        }
    }
}