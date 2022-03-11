// package com.try_spring.try_spring;

// import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.jupiter.api.Test;
// // import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.beans.factory.annotation.Autowired;

// // @SpringBootTest
// class TrySpringApplicationTests {
// 	@Autowired
// 	private tryspring_controller controller = new tryspring_controller();
// // 	@Test
// // 	void contextLoads() {	
// // 	}
//     // @Autowired
//     // public Movie_Repo mRepository;

// 	@Test
// 	void testUpdateMovie(){
//         Movie movie = new Movie();
//         movie.setImdb_score((double) 5);
//         movie.setName("newmovie");
//         movie.setWatched(true);
//         movie.setWatchlist(true);
//         Movie actual_result =  controller.save_movie(movie);
//         System.out.println(actual_result);
// 		assertEquals(movie, actual_result);
// 	}
// }
