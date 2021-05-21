package hu.flowacademy.kappa.vasarlas_gyak3;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.Random;
import java.util.Set;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class VasarlasControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ShopRepository repository;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void client() throws Exception {
        var item1 = new Item(1, "TV-1", 100000);
        var item2 = new Item(2, "TV-2", 200000);
        var item3 = new Item(3, "TV-3", 300000);
        Set<Item> set = Set.of(item1, item2, item3);

        given(repository.findAll()).willReturn(set);
        given(repository.findById(anyInt())).willAnswer(answer -> {
            var i = (Integer) answer.getArgument(0);
            switch (i) {
                case 1:
                    return Optional.of(item1);
                case 2:
                    return Optional.of(item2);
                case 3:
                    return Optional.of(item3);
                default:
                    return Optional.empty();
            }
        });

        mockMvc.perform(get("/api/vasarlas/termekek"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(result -> System.out.println(result.getResponse().getContentAsString()));
    }

    @Test
    public void client2() throws Exception {
        var item1 = new Item(1, "TV-1", 100000);
        var item2 = new Item(2, "TV-2", 200000);
        var item3 = new Item(3, "TV-3", 300000);
        Set<Item> set = Set.of(item1, item2, item3);

        given(repository.findAll()).willReturn(set);
        given(repository.findById(anyInt())).willAnswer(answer -> {
            var i = (Integer) answer.getArgument(0);
            switch (i) {
                case 1:
                    return Optional.of(item1);
                case 2:
                    return Optional.of(item2);
                case 3:
                    return Optional.of(item3);
                default:
                    return Optional.empty();
            }
        });

        var response = mockMvc.perform(get("/api/vasarlas/termekek"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(result -> System.out.println(result.getResponse().getContentAsString()))
                .andReturn().getResponse().getContentAsString();

        Item[] items = mapper.readValue(response, Item[].class);

        Item selectedItem = items[new Random().nextInt() % items.length];

        mockMvc.perform(get("/api/vasarlas/kivalaszt/" + selectedItem.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isMap())
                .andExpect(jsonPath("$.id").value(selectedItem.getId()));

        mockMvc.perform(get("/api/vasarlas/kivalaszt/" + 10))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(0));
    }
}
