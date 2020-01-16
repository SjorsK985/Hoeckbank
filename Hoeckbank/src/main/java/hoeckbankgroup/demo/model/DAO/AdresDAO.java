package hoeckbankgroup.demo.model.DAO;
import hoeckbankgroup.demo.model.Adres;
import hoeckbankgroup.demo.model.Klant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdresDAO extends JpaRepository<Adres, Integer> {

}
