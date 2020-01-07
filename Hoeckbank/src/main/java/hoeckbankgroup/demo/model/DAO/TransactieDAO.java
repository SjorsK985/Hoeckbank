package hoeckbankgroup.demo.model.DAO;

import hoeckbankgroup.demo.model.Rekening;
import hoeckbankgroup.demo.model.Transactie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactieDAO extends JpaRepository<Transactie, Integer> {
}
