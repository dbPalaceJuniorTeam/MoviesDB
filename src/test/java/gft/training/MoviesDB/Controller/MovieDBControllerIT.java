package gft.training.MoviesDB.Controller;

import gft.training.MoviesDB.Service.MoviesDBService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
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
        ResultActions response = mockMvc.perform(get("/api/genres"));

        //THEN
        response.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.genres", is(0)));
    }

    @Test
    public void getConfiguration() throws Exception{
        //GIVEN
        HashMap<String, Object> result = new HashMap<>();
        result.put("genres", 0);

        given(moviesDBService.getConfig()).willReturn(result);

        //WHEN
        ResultActions response = mockMvc.perform(get("/api/configuration"));

        //THEN
        response.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.genres", is(0)));
    }

    @Test
    public void findAllPopularMovies() throws Exception{
        //GIVEN
        HashMap<String, Object> result = new HashMap<>();
        result.put("genres", 0);

        given(moviesDBService.findAllPopularMovies()).willReturn(result);

        //WHEN
        ResultActions response = mockMvc.perform(get("/api/popular"));

        //THEN
        response.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.genres", is(0)));
    }
}
