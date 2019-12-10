package hoeckbankgroup.demo.model.service;

import hoeckbankgroup.demo.model.DAO.MKBDAO;
import hoeckbankgroup.demo.model.MKB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MKBService {

    @Autowired
    private MKBDAO mkbdao;

    public void save(MKB mkb){mkbdao.save(mkb);}
}
