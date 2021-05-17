package hu.flowacademy.kappa.megertescellal.jarmuvek;

import hu.flowacademy.kappa.models.Shop;
import hu.flowacademy.kappa.services.LoggerToConsoleService;
import hu.flowacademy.kappa.services.ShopService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.mockito.BDDMockito.given;

@SpringBootTest
@AutoConfigureMockMvc
class JarmuMvcMockTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getShop() {
        mockMvc.perform(MockMvcRequestBuilders)
    }
}