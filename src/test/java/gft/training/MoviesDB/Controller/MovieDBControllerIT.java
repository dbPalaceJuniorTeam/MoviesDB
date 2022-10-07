package gft.training.MoviesDB.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import gft.training.MoviesDB.Entity.UserMovie;
import gft.training.MoviesDB.Repository.UserMovieRepository;
import gft.training.MoviesDB.Service.MoviesDBService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.security.Principal;
import java.util.HashMap;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
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

    @MockBean
    UserMovieRepository repository;

    @Autowired
    ObjectMapper objectMapper;

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

    @Test
    public void findTopRatedMovies() throws Exception{
        //GIVEN
        HashMap<String, Object> result = new HashMap<>();
        result.put("genres", 0);

        given(moviesDBService.findTopRatedMovies()).willReturn(result);

        //WHEN
        ResultActions response = mockMvc.perform(get("/api/top"));

        //THEN
        response.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.genres", is(0)));
    }

    @Test
    @WithMockUser
    public void findMovieById() throws Exception{
        //GIVEN
        HashMap<String, Object> result = new HashMap<>();
        result.put("genres", 0);
        Integer id = 420;

        given(moviesDBService.findMovieById(id)).willReturn(result);

        //WHEN
        ResultActions response = mockMvc.perform(get("/api/movie/{id}", id));

        //THEN
        response.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.genres", is(0)));
    }

    @Test
    public void findCreditsByMovieId() throws Exception{
        //GIVEN
        HashMap<String, Object> result = new HashMap<>();
        result.put("genres", 0);
        Integer id = 420;

        given(moviesDBService.findCreditsById(id)).willReturn(result);

        //WHEN
        ResultActions response = mockMvc.perform(get("/api/movie/{id}/credits", id));

        //THEN
        response.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.genres", is(0)));
    }

    @Test
    public void findImagesByMovieId() throws Exception{
        //GIVEN
        HashMap<String, Object> result = new HashMap<>();
        result.put("genres", 0);
        Integer id = 420;

        given(moviesDBService.findImagesById(id)).willReturn(result);

        //WHEN
        ResultActions response = mockMvc.perform(get("/api/movie/{id}/images", id));

        //THEN
        response.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.genres", is(0)));
    }

    @Test
    public void findKeywordsByMovieId() throws Exception{
        //GIVEN
        HashMap<String, Object> result = new HashMap<>();
        result.put("genres", 0);
        Integer id = 420;

        given(moviesDBService.findKeywordsById(id)).willReturn(result);

        //WHEN
        ResultActions response = mockMvc.perform(get("/api/movie/{id}/keywords", id));

        //THEN
        response.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.genres", is(0)));
    }

    @Test
    public void findRecommendationsByMovieId() throws Exception{
        //GIVEN
        HashMap<String, Object> result = new HashMap<>();
        result.put("genres", 0);
        Integer id = 420;

        given(moviesDBService.findRecommendationsById(id)).willReturn(result);

        //WHEN
        ResultActions response = mockMvc.perform(get("/api/movie/{id}/recommendations", id));

        //THEN
        response.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.genres", is(0)));
    }

    @Test
    public void findSimilarMoviesByMovieId() throws Exception{
        //GIVEN
        HashMap<String, Object> result = new HashMap<>();
        result.put("genres", 0);
        Integer id = 420;

        given(moviesDBService.findSimilarMoviesById(id)).willReturn(result);

        //WHEN
        ResultActions response = mockMvc.perform(get("/api/movie/{id}/similar", id));

        //THEN
        response.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.genres", is(0)));
    }

    @Test
    @WithMockUser
    public void PatchMovieById() throws Exception{
        //GIVEN
        Integer id = 420;

        Principal user = () -> "admin";

        UserMovie userMovie = new UserMovie();


        given(repository.findByUsernameAndMovie(user.getName(),id.toString())).willReturn(Optional.of(userMovie));

        given(repository.save(userMovie)).willAnswer((invocation) -> invocation.getArgument(0));

        //WHEN
        ResultActions response = mockMvc.perform(patch("/api/movie/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userMovie)));

        //THEN
        response.andExpect(status().isOk()).andDo(print());
    }

    @Test
    @WithMockUser
    public void PatchMovieByIdWithNoContents() throws Exception{
        //GIVEN
        Integer id = 420;

        Principal user = () -> "admin";

        UserMovie userMovie = new UserMovie();

        given(repository.findByUsernameAndMovie(user.getName(),id.toString())).willReturn(Optional.of(userMovie));

        given(repository.save(userMovie)).willAnswer((invocation) -> invocation.getArgument(0));

        //WHEN
        ResultActions response = mockMvc.perform(patch("/api/movie/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                );

        //THEN
        response.andExpect(status().is4xxClientError()).andDo(print());
    }

    @Test
    @WithMockUser
    public void PatchMovieByIdWithNoContentType() throws Exception{
        //GIVEN
        Integer id = 420;

        Principal user = () -> "admin";

        UserMovie userMovie = new UserMovie();

        given(repository.findByUsernameAndMovie(user.getName(),id.toString())).willReturn(Optional.of(userMovie));

        given(repository.save(userMovie)).willAnswer((invocation) -> invocation.getArgument(0));

        //WHEN
        ResultActions response = mockMvc.perform(patch("/api/movie/{id}", id)
                .content(objectMapper.writeValueAsString(userMovie))
        );

        //THEN
        response.andExpect(status().is4xxClientError()).andDo(print());
    }
}
