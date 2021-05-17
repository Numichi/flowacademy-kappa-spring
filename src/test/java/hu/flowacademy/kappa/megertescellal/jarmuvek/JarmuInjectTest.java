package hu.flowacademy.kappa.megertescellal.jarmuvek;

import hu.flowacademy.kappa.models.Shop;
import hu.flowacademy.kappa.services.LoggerService;
import hu.flowacademy.kappa.services.LoggerToConsoleService;
import hu.flowacademy.kappa.services.ShopService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.BDDMockito.given;

@SpringBootTest
class JarmuInjectTest {

    @InjectMocks
    ShopService service;

    @MockBean
    LoggerToConsoleService logger;

    @Test
    public void printLog() {
        given(logger.log()).willReturn(false);

        service.setShops(new Shop());
    }
}