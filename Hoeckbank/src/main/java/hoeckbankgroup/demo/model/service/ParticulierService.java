package hoeckbankgroup.demo.model.service;

import hoeckbankgroup.demo.model.Dao.ParticulierDao;
import hoeckbankgroup.demo.model.Particulier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticulierService {

    @Autowired
    private ParticulierDao particulierDao;

    public Particulier findParticulierbyBSN(int bsn){
        return particulierDao.findParticulierByBSN(bsn);
    }

}
