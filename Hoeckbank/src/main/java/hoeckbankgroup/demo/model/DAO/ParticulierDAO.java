package hoeckbankgroup.demo.model.DAO;

import hoeckbankgroup.demo.model.Particulier;
import hoeckbankgroup.demo.model.Rekening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticulierDAO extends JpaRepository<Particulier, Integer> {

}
