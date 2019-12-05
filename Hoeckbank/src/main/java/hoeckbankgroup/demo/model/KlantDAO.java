package hoeckbankgroup.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KlantDAO extends JpaRepository<Klant, Integer> {
    public Klant findKlantByGebruikersnaam(String gebruikersnaam);
}
