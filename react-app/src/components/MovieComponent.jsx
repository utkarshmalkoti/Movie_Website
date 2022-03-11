import React,{Component} from 'react'
import MovieService from '/Users/utkarshmalkali/Desktop/try_spring/react-app/src/services/MovieService.jsx'

class MovieComponent extends Component{
    constructor(props){
        super(props)
        this.state = {
            movies:[],
            x : 1
        }
    };
    componentDidMount(){
        MovieService.getMovies().then((response)=>{
            this.setState({ movies: response.data})
        })
    }
    render(){
        console.log(this.state.movies[0]);
        return (
            <React.Fragment>
                <h1>Hello Bitches!!!!!{["3",'4','5']}</h1>
                <table className='table'>
                    <thead>
                        <tr>
                            <td> Id </td>
                            <td> IMDB_Score </td>
                            <td> Name </td>
                            <td>isWatched</td>
                            <td>Watchlist </td>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.movies.map( 
                                movie=>
                                <tr key={movie.id}>
                                    <td>{movie.id}</td>
                                    <td>{movie.imdb_score}</td> 
                                    <td>{movie.name}</td>
                                    <td>{movie.watched.toString()}</td>
                                    <td>{movie.watchlist.toString()}</td>   
                                </tr>
                            )
                        }
                    </tbody>
                </table>
                <button onClick={()=>this.setState({x:this.state.x+1})}>daba naa {this.state.x}</button>
            </React.Fragment>
        );
    }
}
export default MovieComponent;