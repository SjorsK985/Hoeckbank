package hoeckbankgroup.demo.model.service;

import hoeckbankgroup.demo.model.DAO.PostcodeDAO;
import hoeckbankgroup.demo.model.Postcode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostcodeService {

    @Autowired
    PostcodeDAO postcodeDAO;

    public Postcode getPostcodeByPostcode(String postcode){
        return postcodeDAO.getPostcodeByPostcode(postcode);
    }
}
