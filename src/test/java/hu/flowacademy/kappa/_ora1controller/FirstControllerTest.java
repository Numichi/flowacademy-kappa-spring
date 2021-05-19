package hu.flowacademy.kappa._ora1controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class FirstControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FirstControllerHelper helper;

    // Jackson JSON Converter
    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    void getExample() throws Exception {
        mockMvc.perform(get("/api/v1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("Első GET method."));
    }

    @Test
    void getMethodWithPathVariable() throws Exception {
        mockMvc.perform(get("/api/v1/10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("A '10' értéket kaptam az URL-ből."));

        mockMvc.perform(get("/api/v1/22"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("A '22' értéket kaptam az URL-ből."));

        mockMvc.perform(get("/api/v1/string"))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof MethodArgumentTypeMismatchException));
    }

    @Test
    void postExample() throws Exception {
        var body = new RequestModel();
        body.setName("name");
        body.setCategory("category");
        body.setSettlement("settlement");
        body.setZip("zip");
        body.setAddress("address");

        // Object => JSON String
        String jsonString = mapper.writeValueAsString(body);

        // Egy argumentum (metódus paraméter) elkapást szeretnék, aminek a típusa "RequestModel"
        ArgumentCaptor<RequestModel> captor = ArgumentCaptor.forClass(RequestModel.class);

        // willReturn(body) kötelező, de nem foglalkozunk vele jelenleg. A lényeg a: captor.capture()
        // Nem előre definiált adatot kap a model metódus paraméterként (mint órán láttuk), hanem "késöbb kiderül" állapotban van.
        given(helper.model(captor.capture())).willReturn(body);

        /* Futtatjuk a MVC kérését.
         *
         *   HTTP Method = POST
         *   Request URI = /api/v1/string
         *    Parameters = {}
         *       Headers = [Content-Type:"application/json;charset=UTF-8", Content-Length:"95"]
         *          Body = {"name":"name1","category":"category","settlement":"settlement","zip":"zip","address":"address"}
         * Session Attrs = {}
         */
        mockMvc.perform(post("/api/v1").contentType(MediaType.APPLICATION_JSON).content(jsonString))
                .andExpect(status().isCreated());

        // captor elkapott egy értéket a futás folyamán, aminek egyeznie kell az átadott JSON-el.
        assertEquals(captor.getValue(), body);
    }

    @Test
    void getRequestParam() throws Exception {
        // REQUIRED => @RequestParam String testKey
        mockMvc.perform(get("/api/v1/request-param-1?testKey=almafa"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("almafa"));

        mockMvc.perform(get("/api/v1/request-param-1"))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertEquals(
                        "Required request parameter 'testKey' for method parameter type String is not present",
                        Objects.requireNonNull(result.getResolvedException()).getMessage()
                ));
    }

    @Test
    void headerExample1() throws Exception {
        mockMvc.perform(get("/api/v1/header-1").header("xTestHeader", "FlowAcademy"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("FlowAcademy"));

        // Nem oldja fel a "camelCase"-t "kebab-case"-re! Van ahol igen, így érdemes figyelni. :)
        mockMvc.perform(get("/api/v1/header-1").header("x-test-header", "FlowAcademy"))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof MissingRequestHeaderException));
    }

    @Test
    void headerExample2() throws Exception {
        // HTTP kommunikációban a header-eket "kebab-case"-el szokás jelölni. Kompatibilisebb más eszközökkel is.
        mockMvc.perform(get("/api/v1/header-2").header("x-test-header", "FlowAcademy"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("FlowAcademy"));
    }

    @Test
    void responseEntity() throws Exception {
        mockMvc.perform(get("/api/v1/response-entity"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("Programozottan konfigurálom a választ"));
    }

    @Test
    void putExample() throws Exception {
        var body = new RequestModel();
        body.setName("name");
        body.setCategory("category");
        body.setSettlement("settlement");
        body.setZip("zip");
        body.setAddress("address");

        // Object => JSON String
        String jsonString = mapper.writeValueAsString(body);

        mockMvc.perform(put("/api/v1").contentType(MediaType.APPLICATION_JSON).content(jsonString))
                .andExpect(status().isOk())
                .andExpect(result -> {
                    var responseString = result.getResponse().getContentAsString();
                    assertEquals(responseString, jsonString);
                })
                .andExpect(result -> {
                    var responseString = result.getResponse().getContentAsString();

                    // JSON String => Object
                    var model = mapper.readValue(responseString, RequestModel.class);

                    assertEquals(body, model);
                });
    }

    @Test
    public void testDataPass() throws Exception {
        var body = new RequestModel();
        body.setName("name");
        body.setCategory("category");
        body.setSettlement("settlement");
        body.setZip("zip");
        body.setAddress("address");

        String jsonString = mapper.writeValueAsString(body);

        String json = mockMvc.perform(put("/api/v1").contentType(MediaType.APPLICATION_JSON).content(jsonString))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        RequestModel model = mapper.readValue(json, RequestModel.class);
        assertEquals(body, model);

        String json2 = mapper.writeValueAsString(model.getName());

        mockMvc.perform(get("/api/v1/header-1").header("xTestHeader", json2))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("name"));
    }
}