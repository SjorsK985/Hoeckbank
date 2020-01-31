package hoeckbankgroup.demo.model.DAO;

import hoeckbankgroup.demo.model.Pinautomaat;
import hoeckbankgroup.demo.model.Rekening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface PinautomaatDao extends JpaRepository<Pinautomaat, Integer> {
   Pinautomaat findPinautomaatByRekening(Rekening rekening);
@Transactional
   Pinautomaat deletePinautomaatByRekening(Rekening rekening);

}
