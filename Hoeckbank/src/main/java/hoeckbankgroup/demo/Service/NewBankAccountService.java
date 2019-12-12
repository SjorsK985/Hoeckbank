package hoeckbankgroup.demo.Service;

import hoeckbankgroup.demo.model.DAO.RekeningDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewBankAccountService {

    @Autowired
    private RekeningDAO rekeningDAO;

    public NewBankAccountService(){
        super();
    }
}
