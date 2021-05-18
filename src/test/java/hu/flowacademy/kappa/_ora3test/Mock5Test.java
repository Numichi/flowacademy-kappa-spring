package hu.flowacademy.kappa._ora3test;

import hu.flowacademy.kappa._ora1controller.FirstControllerHelper;
import hu.flowacademy.kappa._ora1controller.RequestModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class Mock5Test {

    @Mock
    FirstControllerHelper helper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test1() throws Exception {
        var model = new RequestModel();
        model.setName("mock-bean");

        given(helper.model(any())).willReturn(model);

        mockMvc.perform(get("/api/v3"))
                .andExpect(status().isOk())
                .andDo(result -> System.out.println(result.getResponse().getContentAsString()))
                .andExpect(result -> assertEquals("", result.getResponse().getContentAsString()));
    }
}
