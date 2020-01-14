package hoeckbankgroup.demo.controller;

import hoeckbankgroup.demo.model.Adres;
import hoeckbankgroup.demo.model.DAO.KlantDAO;
import hoeckbankgroup.demo.model.Klant;
import hoeckbankgroup.demo.model.Rekening;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class KlantDAOTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private KlantDAO employeeRepository;

    @Test
    public void findKlantTest() {
        List<Rekening> rekeningList = new ArrayList<>();
        Rekening rekening = new Rekening("ABNA123456789", 50.0, "van mij");
        rekeningList.add(rekening);
        Klant testKlant = new Klant("martijn@hva.nl", "123", new Adres("straat", "1", "1234AA", "Amsterdam"), "1234567890", rekeningList);

        entityManager.persist(testKlant);
        entityManager.flush();

        Klant klantOpgehaald = employeeRepository.findKlantByEmail(testKlant.getEmail());

        assertThat(klantOpgehaald.getTelefoonNummer()).isEqualTo(testKlant.getTelefoonNummer());
    }

}


