package gft.training.MoviesDB.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
import gft.training.MoviesDB.Entity.UserMovie;

public interface UserMovieRepository extends JpaRepository<UserMovie, Integer>{
	
	Optional<UserMovie>findByUsernameAndMovie(String username, String movieid);



}
