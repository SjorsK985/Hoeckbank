package hoeckbankgroup.demo.model.DAO;

import hoeckbankgroup.demo.model.Klant;
import hoeckbankgroup.demo.model.Rekening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KlantDAO extends JpaRepository<Klant, Integer> {

    Klant findKlantByEmail(String email);

    Klant findKlantByPersonId(int id);
}