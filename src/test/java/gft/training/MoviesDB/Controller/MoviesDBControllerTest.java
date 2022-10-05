package gft.training.MoviesDB.Controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.test.context.support.WithMockUser;

import java.util.*;

import gft.training.MoviesDB.Entity.UserMovie;
import gft.training.MoviesDB.Repository.UserMovieRepository;
import gft.training.MoviesDB.Service.MoviesDBService;

public class MoviesDBControllerTest {

	MoviesDBController moviesDBController;

	MoviesDBService moviesDBService;

	UserMovieRepository userMovieRepository;

	@BeforeEach
	void setUp() {
		moviesDBService = mock(MoviesDBService.class);
		userMovieRepository = mock(UserMovieRepository.class);
		moviesDBController = new MoviesDBController(moviesDBService, userMovieRepository);
	}

	@Test
	public void getConfigurations() {

		// GIVEN
		HashMap<String, Object> resultFromGetConfig = new HashMap<>();
		resultFromGetConfig.put("images", 0);
		resultFromGetConfig.put("change_keys", 0);

		// WHEN
		given(moviesDBService.getConfig()).willReturn(resultFromGetConfig);

		// THEN
		assertEquals(resultFromGetConfig, moviesDBController.getConfiguration());
	}

	@Test
	public void findAllGenres() {

		// GIVEN
		HashMap<String, Object> resultFromGetAllGenres = new HashMap<>();
		resultFromGetAllGenres.put("images", 0);
		resultFromGetAllGenres.put("change_keys", 0);

		// WHEN
		given(moviesDBService.findAllGenres()).willReturn(resultFromGetAllGenres);

		// THEN
		assertEquals(resultFromGetAllGenres, moviesDBController.findAllGenres());
	}

	@Test
	public void findAllPopularMovies() {

		// GIVEN
		HashMap<String, Object> resultFromfindAllPopularMovies = new HashMap<>();
		resultFromfindAllPopularMovies.put("images", 0);
		resultFromfindAllPopularMovies.put("change_keys", 0);

		// WHEN
		given(moviesDBService.findAllPopularMovies()).willReturn(resultFromfindAllPopularMovies);

		// THEN
		assertEquals(resultFromfindAllPopularMovies, moviesDBController.findAllPopularMovies());
	}

	@Test
	public void findTopRatedMovies() {

		// GIVEN
		HashMap<String, Object> resultFromfindTopRatedMovies = new HashMap<>();
		resultFromfindTopRatedMovies.put("images", 0);
		resultFromfindTopRatedMovies.put("change_keys", 0);

		// WHEN
		given(moviesDBService.findTopRatedMovies()).willReturn(resultFromfindTopRatedMovies);

		// THEN
		assertEquals(resultFromfindTopRatedMovies, moviesDBController.findTopRatedMovies());
	}
	
	@Test
	@WithMockUser
	public void findMovieById() {
		
		// GIVEN
		Integer id = 420;
		UserDetails user = new UserDetails() {
			
			@Override
			public boolean isEnabled() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isCredentialsNonExpired() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isAccountNonLocked() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isAccountNonExpired() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public String getUsername() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getPassword() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Collection<? extends GrantedAuthority> getAuthorities() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		HashMap<String, Object> resultFromfindMovieById = new HashMap<>();
		resultFromfindMovieById.put("images", 0);
		resultFromfindMovieById.put("change_keys", 0);
		
		// WHEN
		given(moviesDBService.findMovieById(id)).willReturn(resultFromfindMovieById);
		
		// THEN
		assertEquals(resultFromfindMovieById, moviesDBController.findMovieById(id, user));
	}

	@Test
	@WithMockUser
	public void findMovieByIdButUserExists() {

		// GIVEN
		Integer id = 420;
		UserDetails user = new UserDetails() {

			@Override
			public boolean isEnabled() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean isCredentialsNonExpired() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean isAccountNonLocked() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean isAccountNonExpired() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public String getUsername() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getPassword() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Collection<? extends GrantedAuthority> getAuthorities() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		UserMovie usermovie = new UserMovie();
		HashMap<String, Object> resultFromfindMovieById = new HashMap<>();
		resultFromfindMovieById.put("images", 0);
		resultFromfindMovieById.put("change_keys", 0);

		// WHEN
		given(moviesDBService.findMovieById(id)).willReturn(resultFromfindMovieById);
		given(userMovieRepository.findByUsernameAndMovie(user.getUsername(), id.toString())).willReturn(Optional.of(usermovie));

		// THEN
		assertEquals(resultFromfindMovieById, moviesDBController.findMovieById(id, user));
	}

	@Test
	@WithMockUser
	public void findCreditsById() {

		// GIVEN
		Integer id = 420;
		HashMap<String, Object> resultFromfindCreditsById = new HashMap<>();
		resultFromfindCreditsById.put("images", 0);
		resultFromfindCreditsById.put("change_keys", 0);

		// WHEN
		given(moviesDBService.findCreditsById(id)).willReturn(resultFromfindCreditsById);

		// THEN
		assertEquals(resultFromfindCreditsById, moviesDBController.findCreditsById(id));
	}

	@Test
	@WithMockUser
	public void findImagesById() {

		// GIVEN
		Integer id = 420;
		HashMap<String, Object> resultFromfindImagesById = new HashMap<>();
		resultFromfindImagesById.put("images", 0);
		resultFromfindImagesById.put("change_keys", 0);

		// WHEN
		given(moviesDBService.findImagesById(id)).willReturn(resultFromfindImagesById);

		// THEN
		assertEquals(resultFromfindImagesById, moviesDBController.findImagesById(id));
	}
	
	@Test
	@WithMockUser
	public void findKeywordsById() {
		
		// GIVEN
		Integer id = 420;
		HashMap<String, Object> resultFromfindKeywordsById = new HashMap<>();
		resultFromfindKeywordsById.put("images", 0);
		resultFromfindKeywordsById.put("change_keys", 0);
		
		// WHEN
		given(moviesDBService.findKeywordsById(id)).willReturn(resultFromfindKeywordsById);
		
		// THEN
		assertEquals(resultFromfindKeywordsById, moviesDBController.findKeywordsById(id));
	}
	
	@Test
	@WithMockUser
	public void findRecommendationsById() {
		
		// GIVEN
		Integer id = 420;
		HashMap<String, Object> resultFromfindRecommendationsById = new HashMap<>();
		resultFromfindRecommendationsById.put("images", 0);
		resultFromfindRecommendationsById.put("change_keys", 0);
		
		// WHEN
		given(moviesDBService.findRecommendationsById(id)).willReturn(resultFromfindRecommendationsById);
		
		// THEN
		assertEquals(resultFromfindRecommendationsById, moviesDBController.findRecommendationsById(id));
	}
	
	@Test
	@WithMockUser
	public void findSimilarMoviesById() {
		
		// GIVEN
		Integer id = 420;
		HashMap<String, Object> resultFromfindSimilarMoviesById = new HashMap<>();
		resultFromfindSimilarMoviesById.put("images", 0);
		resultFromfindSimilarMoviesById.put("change_keys", 0);
		
		// WHEN
		given(moviesDBService.findSimilarMoviesById(id)).willReturn(resultFromfindSimilarMoviesById);
		
		// THEN
		assertEquals(resultFromfindSimilarMoviesById, moviesDBController.findSimilarMoviesById(id));
	}
	
	@Test
	@WithMockUser
	public void setNewInfoIntoExistingMovieByUser() {
		
		// GIVEN
		Integer id = 420;
		UserMovie usermovie = new UserMovie();
		usermovie.setMovie(id.toString());
		UserDetails user = new UserDetails() {
			
			@Override
			public boolean isEnabled() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isCredentialsNonExpired() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isAccountNonLocked() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isAccountNonExpired() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public String getUsername() {
				// TODO Auto-generated method stub
				return "admin";
			}
			
			@Override
			public String getPassword() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Collection<? extends GrantedAuthority> getAuthorities() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		
		ResponseEntity<UserMovie> response = new ResponseEntity<UserMovie>(usermovie, HttpStatus.OK);
		
		// WHEN
		given(userMovieRepository.findByUsernameAndMovie(user.getUsername(), id.toString())).willReturn(Optional.of(usermovie));
		given(userMovieRepository.save(usermovie)).willAnswer((invocation) -> invocation.getArgument(0));
		
		// THEN
		assertEquals(response, moviesDBController.patchUserMovie(id, usermovie, user));
	}
	

	@Test
	@WithMockUser
	public void setNewInfoIntoExistingMovieByUserButUserMovieDoesntExists() {
		
		// GIVEN
		Integer id = 420;
		UserMovie bodyRequest = new UserMovie();
		bodyRequest.setMovie(id.toString());
		UserDetails user = new UserDetails() {
			
			@Override
			public boolean isEnabled() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isCredentialsNonExpired() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isAccountNonLocked() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isAccountNonExpired() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public String getUsername() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getPassword() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Collection<? extends GrantedAuthority> getAuthorities() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		
		ResponseEntity<UserMovie> response = new ResponseEntity<UserMovie>(bodyRequest, HttpStatus.OK);


		// WHEN
		given(userMovieRepository.findByUsernameAndMovie(user.getUsername(), id.toString())).willReturn(Optional.empty());
		given(userMovieRepository.save(bodyRequest)).willAnswer((invocation) -> invocation.getArgument(0));
		
		// THEN
		assertEquals(response.toString(), moviesDBController.patchUserMovie(id, bodyRequest, user).toString());
	}

}
