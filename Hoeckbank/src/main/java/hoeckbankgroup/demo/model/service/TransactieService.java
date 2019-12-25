package hoeckbankgroup.demo.model.service;

import hoeckbankgroup.demo.model.DAO.TransactieDAO;
import hoeckbankgroup.demo.model.Transactie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactieService {

    @Autowired
    private TransactieDAO transactieDAO;

    public void save(Transactie transactie){
        transactieDAO.save(transactie);
    }
}
