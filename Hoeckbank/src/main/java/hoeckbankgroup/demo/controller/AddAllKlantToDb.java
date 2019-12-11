package hoeckbankgroup.demo.controller;

import hoeckbankgroup.demo.model.DAO.KlantDAO;
import hoeckbankgroup.demo.model.DAO.ParticulierDAO;

import hoeckbankgroup.demo.model.Particulier;
import hoeckbankgroup.demo.model.Rekening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Controller
public class AddAllKlantToDb {

    @Autowired
    private KlantDAO klantDAO;
   private ParticulierDAO particulierDao;





    @GetMapping("fdbwk")
    private void inlezen(){
       // ArrayList<String> regelsUitBestand= new ArrayList<>();;
        try {
            Scanner invoer = new Scanner(new File("d:/inleesparticulier.csv"));
            while (invoer.hasNextLine()) {
                String regelUitBestand = invoer.nextLine();
                //regelsUitBestand.add(invoer.nextLine());


               /*String[] regelArray;
                regelArray = regelUitBestand.split(";");
                List<Rekening> rekeningen = new ArrayList<>();
                Rekening rekening = new Rekening(regelArray[7],0.0);
                rekeningen.add(rekening);
                Particulier particulier=new Particulier(regelArray[0],regelArray[1],regelArray[2],regelArray[3],regelArray[4],regelArray[5],regelArray[6],rekeningen);
                System.out.println(regelArray[0]);

                klantDAO.save(particulier);*/


            }

        } catch (FileNotFoundException nietGevonden) {
            System.out.println("Het bestand is niet gevonden.");
        }
    }
}