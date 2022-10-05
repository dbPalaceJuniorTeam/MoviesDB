package gft.training.MoviesDB.Service;

import java.util.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.stereotype.Service;

@Service
public class MoviesDBService {
	
	WebClient webClient;// = WebClient.create("https://api.themoviedb.org/3/");

	String baseUrl;
	public MoviesDBService(String baseUrl) {
		this.baseUrl = baseUrl;
		webClient = WebClient.create(baseUrl);
	}

	private String api_key="2b868b906423d3e47dcc13efbc5a14e1";


	public HashMap<String, Object> getConfig() {
		System.out.println(api_key);
		return webClient.get()
				.uri(uriBuilder -> uriBuilder.path("configuration").queryParam("api_key", api_key).build()).retrieve()
				.bodyToMono(HashMap.class).block();
	}
	
	public HashMap<String, Object> findAllGenres() {
		
		return new HashMap();
		
	}
	
	public HashMap<String, Object> findAllPopularMovies() {
		
		return new HashMap();
		
	}
	
	public HashMap<String, Object> findTopRatedMovies() {
		
		return new HashMap();
		
	}
	
	public HashMap<String, Object> findMovieById(Integer id) {
		
		return new HashMap();
		
	}
	
	public HashMap<String, Object> findCreditsById(Integer id) {
		
		return new HashMap();
		
	}
	
	public HashMap<String, Object> findImagesById(Integer id) {
		
		return new HashMap();
		
	}
	
	public HashMap<String, Object> findKeywordsById(Integer id) {
		
		return new HashMap();
		
	}
	
	public HashMap<String, Object> findRecommendationsById(Integer id) {
		
		return new HashMap();
		
	}
	
	public HashMap<String, Object> findSimilarMoviesById(Integer id) {
		
		return new HashMap();
		
	}
	
	
}
