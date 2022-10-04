package gft.training.MoviesDB.Controller;

import java.util.HashMap;

import org.springframework.data.relational.core.sql.IsNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gft.training.MoviesDB.Entity.UserMovie;
import gft.training.MoviesDB.Repository.UserMovieRepository;
import gft.training.MoviesDB.Service.MoviesDBService;

@RestController
@RequestMapping("/api")
public class MoviesDBController {

	private final MoviesDBService moviesDBService;
	private final UserMovieRepository userMovieReporitory;
	
	public MoviesDBController(MoviesDBService moviesDBService, UserMovieRepository userMovieReporitory) {
		super();
		this.moviesDBService = moviesDBService;
		this.userMovieReporitory = userMovieReporitory;
	}
	
	@GetMapping("/configuration")
	public HashMap<String, Object> getConfiguration() {
		
		return moviesDBService.getConfig();
		
	}
	
	@GetMapping("/genres")
	public HashMap<String, Object> findAllGenres() {
		
		return moviesDBService.findAllGenres();
		
	}
	
	@GetMapping("/popular")
	public HashMap<String, Object> findAllPopularMovies() {
		
		return moviesDBService.findAllPopularMovies();
		
	}
	
	@GetMapping("/top")
	public HashMap<String, Object> findTopRatedMovies() {
		
		return moviesDBService.findTopRatedMovies();
		
	}
	
	@GetMapping("/movie/{id}")
	public HashMap<String, Object> findMovieById(@PathVariable Integer id, @AuthenticationPrincipal UserDetails user) {
		
		return moviesDBService.findMovieById(id);
		
	}
	
	@GetMapping("/movie/{id}/credits")
	public HashMap<String, Object> findCreditsById(@PathVariable Integer id) {
		
		return moviesDBService.findCreditsById(id);
		
	}
	
	@GetMapping("/movie/{id}/images")
	public HashMap<String, Object> findImagesById(@PathVariable Integer id) {
		
		return moviesDBService.findImagesById(id);
		
	}
	
	@GetMapping("/movie/{id}/keywords")
	public HashMap<String, Object> findKeywordsById(@PathVariable Integer id) {
		
		return moviesDBService.findKeywordsById(id);
		
	}
	
	@GetMapping("/movie/{id}/recommendations")
	public HashMap<String, Object> findRecommendationsById(@PathVariable Integer id) {
		
		return moviesDBService.findRecommendationsById(id);
		
	}
	
	@GetMapping("/movie/{id}/similar")
	public HashMap<String, Object> findSimilarMoviesById(@PathVariable Integer id) {
		
		return moviesDBService.findSimilarMoviesById(id);
		
	}
	
	@PatchMapping("/movie/{id}")
	public ResponseEntity<UserMovie> patchUserMovie(@PathVariable Integer id, @RequestBody UserMovie usermovie, @AuthenticationPrincipal UserDetails user) {
		
		UserMovie newMovie = userMovieReporitory.findByUsernameAndMovie(user.getUsername(), id.toString()).orElse(null);
		
		if (newMovie == null) {
			
			newMovie = new UserMovie();
		}
		
		newMovie.setUsername(user.getUsername());
		newMovie.setMovie(id.toString());
		newMovie.setFavorite(usermovie.getFavorite());
		newMovie.setPersonal_rating(usermovie.getPersonal_rating());
		newMovie.setNotes((usermovie.getNotes()));
		
		userMovieReporitory.save(newMovie);
		
		return new ResponseEntity<UserMovie>(newMovie, HttpStatus.OK);
	}
	
	
}
