package hoeckbankgroup.demo.controller;

import hoeckbankgroup.demo.Service.GenereerRekeningnummerService;
import hoeckbankgroup.demo.model.Adres;
import hoeckbankgroup.demo.model.DAO.RekeningDAO;
import hoeckbankgroup.demo.model.Klant;
import hoeckbankgroup.demo.model.Rekening;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RekeningDAOTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private GenereerRekeningnummerService genereerRekeningnummerService;

    @Autowired
    private RekeningDAO rekeningDAO;

    @Test
    public void findRekeningByRekeningIDTest(){
        Rekening testRekening = new Rekening(genereerRekeningnummerService.genereerRekeningnummer(), 100, "Meneer Henk Spaan");

        entityManager.persist(testRekening);
        entityManager.flush();

        Rekening rekeningOpgehaald = rekeningDAO.findRekeningByRekeningID(testRekening.getRekeningID());
        assertThat(rekeningOpgehaald.getRekeningnummer()).isEqualTo(testRekening.getRekeningnummer());
    }
}
