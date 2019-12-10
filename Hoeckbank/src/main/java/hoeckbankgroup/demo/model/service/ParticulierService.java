package hoeckbankgroup.demo.model.service;


import hoeckbankgroup.demo.model.Particulier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hoeckbankgroup.demo.model.DAO.ParticulierDAO;

@Service
public class ParticulierService {

    @Autowired
    private ParticulierDAO particulierDAO;

    public Particulier findParticulierbyBSN(int bsn){
        return particulierDAO.findParticulierByBSN(bsn);
    }

    public void save(Particulier particulier){ particulierDAO.save(particulier);}

}
