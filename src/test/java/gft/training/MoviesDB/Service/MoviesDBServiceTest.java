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
    HashMap<String, Object> expectedResponse;



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

        expectedResponse = new HashMap<>();
        expectedResponse.put("images", 0);
        expectedResponse.put("change_keys", 0);

    }

    @Test
    void getConfig() throws IOException, InterruptedException {
        //Given

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
    void findAllGenres() throws JsonProcessingException {
        //Given
        mockBackEnd.enqueue(new MockResponse()
                .addHeader("Content-Type", "application/json")
                .setBody(objectMapper.writeValueAsString(expectedResponse))
        );

        //When
        HashMap<String, Object> actual = moviesDBService.findAllGenres();

        //Then
        assertEquals(expectedResponse.toString(),actual.toString());
    }

    @Test
    void findAllPopularMovies() throws JsonProcessingException {
        //Given
        mockBackEnd.enqueue(new MockResponse()
                .addHeader("Content-Type", "application/json")
                .setBody(objectMapper.writeValueAsString(expectedResponse))
        );

        //When
        HashMap<String, Object> actual = moviesDBService.findAllPopularMovies();

        //Then
        assertEquals(expectedResponse.toString(),actual.toString());
    }

    @Test
    void findTopRatedMovies() throws JsonProcessingException {
        //Given
        mockBackEnd.enqueue(new MockResponse()
                .addHeader("Content-Type", "application/json")
                .setBody(objectMapper.writeValueAsString(expectedResponse))
        );

        //When
        HashMap<String, Object> actual = moviesDBService.findTopRatedMovies();

        //Then
        assertEquals(expectedResponse.toString(),actual.toString());
    }

    @Test
    void findMovieById() throws JsonProcessingException {
        //Given
        Integer id = 420;
        mockBackEnd.enqueue(new MockResponse()
                .addHeader("Content-Type", "application/json")
                .setBody(objectMapper.writeValueAsString(expectedResponse))
        );

        //When
        HashMap<String, Object> actual = moviesDBService.findMovieById(id);

        //Then
        assertEquals(expectedResponse.toString(),actual.toString());
    }

    @Test
    void findCreditsById() throws JsonProcessingException {
        //Given
        Integer id = 420;
        mockBackEnd.enqueue(new MockResponse()
                .addHeader("Content-Type", "application/json")
                .setBody(objectMapper.writeValueAsString(expectedResponse))
        );

        //When
        HashMap<String, Object> actual = moviesDBService.findCreditsById(id);

        //Then
        assertEquals(expectedResponse.toString(),actual.toString());
    }

    @Test
    void findImagesById() throws JsonProcessingException {
        //Given
        Integer id = 420;
        mockBackEnd.enqueue(new MockResponse()
                .addHeader("Content-Type", "application/json")
                .setBody(objectMapper.writeValueAsString(expectedResponse))
        );

        //When
        HashMap<String, Object> actual = moviesDBService.findCreditsById(id);

        //Then
        assertEquals(expectedResponse.toString(),actual.toString());
    }

    @Test
    void findKeywordsById() throws JsonProcessingException {
        //Given
        Integer id = 420;
        mockBackEnd.enqueue(new MockResponse()
                .addHeader("Content-Type", "application/json")
                .setBody(objectMapper.writeValueAsString(expectedResponse))
        );

        //When
        HashMap<String, Object> actual = moviesDBService.findKeywordsById(id);

        //Then
        assertEquals(expectedResponse.toString(),actual.toString());
    }

    @Test
    void findRecommendationsById() throws JsonProcessingException {
        //Given
        Integer id = 420;
        mockBackEnd.enqueue(new MockResponse()
                .addHeader("Content-Type", "application/json")
                .setBody(objectMapper.writeValueAsString(expectedResponse))
        );

        //When
        HashMap<String, Object> actual = moviesDBService.findRecommendationsById(id);

        //Then
        assertEquals(expectedResponse.toString(),actual.toString());
    }

    @Test
    void findSimilarMoviesById() throws JsonProcessingException {
        //Given
        Integer id = 420;
        mockBackEnd.enqueue(new MockResponse()
                .addHeader("Content-Type", "application/json")
                .setBody(objectMapper.writeValueAsString(expectedResponse))
        );

        //When
        HashMap<String, Object> actual = moviesDBService.findSimilarMoviesById(id);

        //Then
        assertEquals(expectedResponse.toString(),actual.toString());
    }
}