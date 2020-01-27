package hoeckbankgroup.demo.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import hoeckbankgroup.demo.Service.GenereerRekeningnummerService;
import hoeckbankgroup.demo.Service.NewBankAccountService;
import hoeckbankgroup.demo.model.Gebruiker;
import hoeckbankgroup.demo.model.Klant;
import hoeckbankgroup.demo.model.Rekening;
import hoeckbankgroup.demo.model.service.KlantService;
import hoeckbankgroup.demo.model.service.RekeningService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class NewBankAccountControllerTest {

    @Autowired
    private NewBankAccountService newBankAccountService;

    @Autowired
    private KlantService klantService;

    @Autowired
    private GenereerRekeningnummerService genereerRekeningnummerService;

    @Autowired
    private RekeningService rekeningService;

    @Autowired
    private MockMvc mockMvc;

    MockHttpSession session = new MockHttpSession();

    @Before
    public void setup() {
        Klant klant = klantService.findKlantByEmail("sjors@gmail.com");
        Gebruiker gebruiker = new Gebruiker(klant.getPersonId(), klant.getRekeningen(), "Particulier");
        session.setAttribute("gebruiker", gebruiker);
    }

    @Test
    public void newBankAccountHandler() throws Exception {
        this.mockMvc.perform(
                get("/newbankaccount")
                        .session(session))
                .andDo(print())
                .andExpect(status()
                        .isOk())
                .andExpect(content().string(containsString("Meneer Sjors Koevoets")));
    }
}
