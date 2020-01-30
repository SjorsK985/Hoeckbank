package hoeckbankgroup.demo.model.service;

import hoeckbankgroup.demo.model.DAO.PinautomaatDao;
import hoeckbankgroup.demo.model.Klant;
import hoeckbankgroup.demo.model.PaymentMachineConnectionResult;
import hoeckbankgroup.demo.model.Pinautomaat;
import hoeckbankgroup.demo.model.Rekening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PinautomaatService {

    @Autowired
    private PinautomaatDao pinautomaatDao;

    public void save(Pinautomaat pinautomaat){
        pinautomaatDao.save(pinautomaat);
    }

    public PaymentMachineConnectionResult validateAccount(Rekening rekening, int check){

        Pinautomaat pinautomaat = pinautomaatDao.findPinautomaatByRekening(rekening);
        int controle = Integer.parseInt(pinautomaat.getCode());
        if(pinautomaat!=null && controle==check){
            int returncode = Integer.parseInt(genereerreturnCode());
            PaymentMachineConnectionResult paymentMachineConnectionResult = new PaymentMachineConnectionResult(true,returncode);
            System.out.println(" true "+ controle + "  " + check);
            return paymentMachineConnectionResult;
        }
        System.out.println(" false "+ controle + "  " + check);
        return new PaymentMachineConnectionResult(false,0);

    }

    public String genereerCode(){
        String code = "";
        for (int i = 0; i < 5; i++) {
            int getal = (int) (10 * Math.random() + 1);
            code += getal;

        }
        System.out.println(code);
        return code;
    }

    public String genereerreturnCode(){
        String code = "";
        for (int i = 0; i < 8; i++) {
            int getal = (int) (10 * Math.random() + 1);
            code += getal;

        }
        System.out.println(code);
        return code;
    }
}
