package hu.flowacademy.kappa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class ShopServiceTest {

    @MockBean
    private ShopRepository repository;

    @Autowired
    private ShopService service;

    @Test
    void findById() {
    }
}