package hoeckbankgroup.demo.model.Dao;

import hoeckbankgroup.demo.model.Particulier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticulierDao extends CrudRepository<Particulier, Integer> {

    Particulier findParticulierByBSN(int bsn);
}
