package hoeckbankgroup.demo.model.DAO;

import hoeckbankgroup.demo.model.Postcode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostcodeDAO extends JpaRepository<Postcode, Integer> {
    Postcode getPostcodeByPostcode(String postcode);
}
