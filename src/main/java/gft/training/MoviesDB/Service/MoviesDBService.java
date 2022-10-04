package gft.training.MoviesDB.Service;

import java.util.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.stereotype.Service;

@Service
public class MoviesDBService {
	
	WebClient webClient = WebClient.create("https://api.themoviedb.org/3/");

	@Value("${themoviedatabase.api_key}")
    private String api_key;

	public HashMap<String, Object> getConfig() {
		
		return new HashMap();
		
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
