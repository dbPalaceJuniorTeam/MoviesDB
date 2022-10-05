package gft.training.MoviesDB.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import gft.training.MoviesDB.Utils.JSONResponses;
import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import reactor.test.StepVerifier;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MoviesDBServiceTest {

    MoviesDBService moviesDBService;


    ObjectMapper objectMapper;

    public MockWebServer mockBackEnd;

    JSONResponses jsonResponses;



    @AfterEach
    void tearDown() throws IOException {
        mockBackEnd.shutdown();
    }

    @BeforeEach
    void initialize() throws IOException {

        mockBackEnd = new MockWebServer();

        objectMapper = new ObjectMapper();
        jsonResponses = new JSONResponses();

        moviesDBService = new MoviesDBService(mockBackEnd.url("/").url().toString());

    }

    @Test
    void getConfig() throws IOException, InterruptedException {
        //Given
        HashMap<String, Object> expectedResponse = new HashMap<>();
        expectedResponse.put("images", 0);
        expectedResponse.put("change_keys", 0);
        mockBackEnd.enqueue(new MockResponse()
                .addHeader("Content-Type", "application/json")
                .setBody(objectMapper.writeValueAsString(expectedResponse))
        );

        //When
        HashMap<String, Object> actual = moviesDBService.getConfig();

        //Then
        assertEquals(expectedResponse.toString(),actual.toString());
    }

    @Test
    void findAllGenres() {
    }

    @Test
    void findAllPopularMovies() {
    }

    @Test
    void findTopRatedMovies() {
    }

    @Test
    void findMovieById() {
    }

    @Test
    void findCreditsById() {
    }

    @Test
    void findImagesById() {
    }

    @Test
    void findKeywordsById() {
    }

    @Test
    void findRecommendationsById() {
    }

    @Test
    void findSimilarMoviesById() {
    }
}