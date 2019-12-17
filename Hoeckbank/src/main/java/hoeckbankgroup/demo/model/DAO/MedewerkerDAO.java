package hoeckbankgroup.demo.model.DAO;

import hoeckbankgroup.demo.model.Medewerker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedewerkerDAO extends JpaRepository<Medewerker, Integer> {
Medewerker findMedewerkerByEmail(String email);
}
