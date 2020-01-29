package hoeckbankgroup.demo.controller;

import hoeckbankgroup.demo.model.Gebruiker;
import hoeckbankgroup.demo.model.Klant;
import hoeckbankgroup.demo.model.service.KlantService;
import hoeckbankgroup.demo.model.service.MKBService;
import hoeckbankgroup.demo.model.service.ParticulierService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RegisterControllerTest {

    @Autowired
    private MKBService mkbService;

    @Autowired
    private ParticulierService particulierService;

    @Autowired
    private KlantService klantService;

    @Autowired
    private MockMvc mockMvc;
    MockHttpSession session = new MockHttpSession();

    @Test
    public void doRegisterHandler() throws Exception {
        this.mockMvc.perform(
                get("/register")
                        .session(session))
                .andDo(print())
                .andExpect(status()
                        .isOk())
                .andExpect(content().string(containsString("<!DOCTYPE html>")));
    }

}
