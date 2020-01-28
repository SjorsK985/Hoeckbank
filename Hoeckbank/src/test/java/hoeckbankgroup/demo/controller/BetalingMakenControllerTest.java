package hoeckbankgroup.demo.controller;

import hoeckbankgroup.demo.Service.GenereerRekeningnummerService;
import hoeckbankgroup.demo.model.DAO.KlantDAO;
import hoeckbankgroup.demo.model.Gebruiker;
import hoeckbankgroup.demo.model.Klant;
import hoeckbankgroup.demo.model.service.KlantService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BetalingMakenControllerTest {

    @Autowired
    private KlantService klantService;

    @Autowired
    private GenereerRekeningnummerService genereerRekeningnummerService;

    @Autowired
    private MockMvc mockMvc;
    MockHttpSession session = new MockHttpSession();

    @Before
    public void setup() {
        Klant klant = klantService.findKlantByEmail("roeland@gmail.com");
        Gebruiker gebruiker = new Gebruiker(klant.getPersonId(), klant.getRekeningen(), "Particulier");
        session.setAttribute("gebruiker", gebruiker);
    }

    @Test
    public void betalingMakenHandler() throws Exception {
        this.mockMvc.perform(
                get("/betalingmaken?id=3052")
                .session(session))
                .andDo(print())
                .andExpect(status()
                .isOk())
                .andExpect(content().string(containsString("betalingmaken")));
    }
}
