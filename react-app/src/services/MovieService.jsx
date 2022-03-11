import axios from "axios"
const MOVIE_LIST_REST_API_URL = "http://localhost:8080/movies";

class MovieService{
    getMovies(){
        return axios.get(MOVIE_LIST_REST_API_URL);
    }
}
export default new MovieService();