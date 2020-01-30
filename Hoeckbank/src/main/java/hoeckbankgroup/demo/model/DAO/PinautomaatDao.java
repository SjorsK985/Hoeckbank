package hoeckbankgroup.demo.model.DAO;

import hoeckbankgroup.demo.model.Particulier;
import hoeckbankgroup.demo.model.Pinautomaat;
import hoeckbankgroup.demo.model.Rekening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PinautomaatDao extends JpaRepository<Pinautomaat, Integer> {
   Pinautomaat findPinautomaatByRekening(Rekening rekening);

}
