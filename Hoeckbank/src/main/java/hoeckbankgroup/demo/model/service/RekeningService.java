package hoeckbankgroup.demo.model.service;

import hoeckbankgroup.demo.model.DAO.RekeningDAO;
import hoeckbankgroup.demo.model.Rekening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RekeningService {

    @Autowired
    private RekeningDAO rekeningDAO;

    public Rekening findRekeningByRekeningID(int rekeningID){
        return rekeningDAO.findRekeningByRekeningID(rekeningID);
    }
    
}
