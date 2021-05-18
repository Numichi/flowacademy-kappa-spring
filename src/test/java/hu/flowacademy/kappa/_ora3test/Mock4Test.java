package hu.flowacademy.kappa._ora3test;

import hu.flowacademy.kappa._ora1controller.FirstControllerHelper;
import hu.flowacademy.kappa._ora1controller.RequestModel;
import hu.flowacademy.kappa._ora2ioc.qualifier.option2.Simple2Interface;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyObject;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class Mock4Test {

    @MockBean
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
                .andExpect(jsonPath("$.name").value("mock-bean"));

    }
}
