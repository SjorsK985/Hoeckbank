package hoeckbankgroup.demo.model.DAO;

import hoeckbankgroup.demo.model.MKB;
import hoeckbankgroup.demo.model.Particulier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MKBDAO extends JpaRepository<MKB, Integer> {

}
