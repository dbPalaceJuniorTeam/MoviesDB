package gft.training.MoviesDB.Service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.springframework.test.web.reactive.server.WebTestClient.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class MovieDBServiceIT {

    @Autowired
    private WebTestClient webTestClient;

    private Integer idTest=550;

    @Test
    void getConfigBody(){
        //GIVEN

        //WHEN
        ResponseSpec response = webTestClient.get()
                .uri("/api/configuration")
                .accept(MediaType.APPLICATION_JSON)
                .exchange();

        //THEN
        response.expectStatus().isOk()
                .expectHeader().valueEquals("Content-Type","application/json")
                .expectBody()
                .jsonPath("$.images").exists()
                .jsonPath("$.change_keys").exists();
    }

    @Test
    void findAllGenres(){
        //GIVEN

        //WHEN
        ResponseSpec response = webTestClient.get()
                .uri("/api/genres")
                .accept(MediaType.APPLICATION_JSON)
                .exchange();

        //THEN
        response.expectStatus().isOk()
                .expectHeader().valueEquals("Content-Type","application/json")
                .expectBody();
    }

    @Test
    void findAllPopularMovies(){
        //GIVEN

        //WHEN
        ResponseSpec response = webTestClient.get()
                .uri("/api/popular")
                .accept(MediaType.APPLICATION_JSON)
                .exchange();

        //THEN
        response.expectStatus().isOk()
                .expectHeader().valueEquals("Content-Type","application/json")
                .expectBody();
    }

    @Test
    void findTopRatedMovies(){
        //GIVEN

        //WHEN
        ResponseSpec response = webTestClient.get()
                .uri("/api/top")
                .accept(MediaType.APPLICATION_JSON)
                .exchange();

        //THEN
        response.expectStatus().isOk()
                .expectHeader().valueEquals("Content-Type","application/json")
                .expectBody();
    }

    @Test
    void findMovieById(){
        //GIVEN

        //WHEN
        ResponseSpec response = webTestClient.get()
                .uri("/api/movie/"+idTest.toString())
                .headers(httpHeaders -> httpHeaders.setBasicAuth("user","password"))
                .accept(MediaType.APPLICATION_JSON)
                .exchange();

        //THEN
        response.expectStatus().isOk()
                .expectHeader().valueEquals("Content-Type","application/json")
                .expectBody();
    }

    @Test
    void findCreditsById(){
        //GIVEN

        //WHEN
        ResponseSpec response = webTestClient.get()
                .uri("api/movie/"+idTest+"/credits")
                .accept(MediaType.APPLICATION_JSON)
                .exchange();

        //THEN
        response.expectStatus().isOk()
                .expectHeader().valueEquals("Content-Type","application/json")
                .expectBody();
    }

    @Test
    void findImagesById(){
        //GIVEN

        //WHEN
        ResponseSpec response = webTestClient.get()
                .uri("api/movie/"+idTest+"/images")
                .accept(MediaType.APPLICATION_JSON)
                .exchange();

        //THEN
        response.expectStatus().isOk()
                .expectHeader().valueEquals("Content-Type","application/json")
                .expectBody();
    }

    @Test
    void findKeywordsById(){
        //GIVEN

        //WHEN
        ResponseSpec response = webTestClient.get()
                .uri("api/movie/"+idTest+"/keywords")
                .accept(MediaType.APPLICATION_JSON)
                .exchange();

        //THEN
        response.expectStatus().isOk()
                .expectHeader().valueEquals("Content-Type","application/json")
                .expectBody();
    }

    @Test
    void findRecommendationsById(){
        //GIVEN

        //WHEN
        ResponseSpec response = webTestClient.get()
                .uri("api/movie/"+idTest+"/recommendations")
                .accept(MediaType.APPLICATION_JSON)
                .exchange();

        //THEN
        response.expectStatus().isOk()
                .expectHeader().valueEquals("Content-Type","application/json")
                .expectBody();
    }

    @Test
    void findSimilarMoviesById(){
        //GIVEN

        //WHEN
        ResponseSpec response = webTestClient.get()
                .uri("api/movie/"+idTest+"/similar")
                .accept(MediaType.APPLICATION_JSON)
                .exchange();

        //THEN
        response.expectStatus().isOk()
                .expectHeader().valueEquals("Content-Type","application/json")
                .expectBody();
    }

}
