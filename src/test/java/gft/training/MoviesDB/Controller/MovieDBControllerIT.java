package gft.training.MoviesDB.Controller;

import gft.training.MoviesDB.Service.MoviesDBService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc(addFilters = false)
public class MovieDBControllerIT {

    @Autowired
    private WebApplicationContext webApplicationContext;


    @MockBean
    MoviesDBService moviesDBService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAllGenres() throws Exception {

        //GIVEN
        HashMap<String, Object> result = new HashMap<>();
        result.put("genres", 0);

        given(moviesDBService.findAllGenres()).willReturn(result);
        //WHEN

        ResultActions response = mockMvc.perform(get("/api/genre/list"));
        //THEN

        response.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.genres", is(0)));

    }
}
