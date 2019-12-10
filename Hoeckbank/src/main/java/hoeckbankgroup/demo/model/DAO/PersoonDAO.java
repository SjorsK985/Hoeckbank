package hoeckbankgroup.demo.model.DAO;

import hoeckbankgroup.demo.model.Persoon;
import hoeckbankgroup.demo.model.TestKlant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersoonDAO extends JpaRepository<Persoon, Integer> {
    Persoon findPersoonByGebruikersnaam(String gebruikersnaam);
}
