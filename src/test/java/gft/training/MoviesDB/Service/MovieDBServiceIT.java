package gft.training.MoviesDB.Service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
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
}
