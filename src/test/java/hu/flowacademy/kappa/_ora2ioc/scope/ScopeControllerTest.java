package hu.flowacademy.kappa._ora2ioc.scope;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ScopeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void haveFun() throws Exception {
        // println() kerül meghívásra!
        mockMvc.perform(get("/api/v2"));
        mockMvc.perform(get("/api/v2"));
        mockMvc.perform(get("/api/v2"));

        /* Példa futtatás:

        [1] Property Scope:  29dec7b2-8701-4986-b0c7-400f0b0078b5 <---- itt is más a property
        [1] Request Scope:   041ce52d-535f-41bd-8eed-44dd3a439f8d <-\
        [1] Singleton Scope: e2294496-db92-441f-9bc3-f685e86ffaa0 <-|--- Singleton mindenhol ugyanaz!
                                                                    | Csak itt azonosak a request-esek
        [2] Property Scope:  341a667c-3b0d-48e5-8fe2-679a347afa7f <-|-- itt is más a property
        [2] Request Scope:   041ce52d-535f-41bd-8eed-44dd3a439f8d <-/
        [2] Singleton Scope: e2294496-db92-441f-9bc3-f685e86ffaa0 <----- Singleton mindenhol ugyanaz!
        ----------------------------------
        [1] Property Scope:  3b6faff9-5957-41d0-843f-7ea67f3a49ca
        [1] Request Scope:   53304e0e-1da9-414d-aa11-643a02276e39
        [1] Singleton Scope: e2294496-db92-441f-9bc3-f685e86ffaa0

        [2] Property Scope:  6a8775ae-10af-40fe-bb59-c66d68777a86
        [2] Request Scope:   53304e0e-1da9-414d-aa11-643a02276e39
        [2] Singleton Scope: e2294496-db92-441f-9bc3-f685e86ffaa0
        ----------------------------------
        [1] Property Scope:  3f3dab6e-5cba-47ac-8939-b347a7ef951b
        [1] Request Scope:   22426864-f0ba-44b4-9137-f246bc9d2175
        [1] Singleton Scope: e2294496-db92-441f-9bc3-f685e86ffaa0

        [2] Property Scope:  ee2f3a01-09fb-47c9-9a76-a3cf7bd8f2d2
        [2] Request Scope:   22426864-f0ba-44b4-9137-f246bc9d2175
        [2] Singleton Scope: e2294496-db92-441f-9bc3-f685e86ffaa0
        ----------------------------------
         */
    }
}