package hoeckbankgroup.demo.model.DAO;

import hoeckbankgroup.demo.model.Rekening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RekeningDAO extends JpaRepository<Rekening, Integer> {
    Rekening findRekeningByRekeningID(int rekeningID);

}
