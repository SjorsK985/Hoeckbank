package hoeckbankgroup.demo.model.DAO;

import hoeckbankgroup.demo.model.Klant;
import hoeckbankgroup.demo.model.Koppel;
import hoeckbankgroup.demo.model.Rekening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KoppelDAO extends JpaRepository<Koppel, Integer> {

    boolean existsByMederekeninghouderAndRekeningnummer(String mederekeninghouder, String rekeningnummer);
    boolean existsByRekeningnummerAndBeveiligingscodeAndMederekeninghouder(String rekeningnummer, String Beveiligingscode, String gebruikersnaam);
    Koppel findKoppelByRekeningnummerAndMederekeninghouder(String rekeningnummer, String gebruikersnaam);
}
