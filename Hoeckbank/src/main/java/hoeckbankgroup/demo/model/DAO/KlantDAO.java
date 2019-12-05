package hoeckbankgroup.demo.model.DAO;

import hoeckbankgroup.demo.model.TestKlant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KlantDAO extends JpaRepository<TestKlant, Integer> {
    public TestKlant findKlantByGebruikersnaam(String gebruikersnaam);
}
