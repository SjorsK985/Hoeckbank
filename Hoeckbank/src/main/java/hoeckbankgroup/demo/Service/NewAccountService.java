package hoeckbankgroup.demo.Service;

import hoeckbankgroup.demo.model.Dao.ParticulierDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewAccountService {

    @Autowired
    private ParticulierDao particulierDao;
}