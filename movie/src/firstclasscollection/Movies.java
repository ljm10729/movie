package firstclasscollection;

import model.Movie;
import model.enums.MovieCode;

import java.util.List;

import static java.util.stream.Collectors.toSet;

public record Movies(List<Movie> movies) {
    private static final Integer MAX_MOVIE_NUMBER = 5;
    public Movies {
        validateMoviesRegister ( movies );
    }

    private void validateMoviesRegister ( List <Movie> movies ) {
        if(movies.size () > MAX_MOVIE_NUMBER) {
            throw new IllegalArgumentException(String.format ( "등록가능한 영화의 숫자는 %s개를 넘어갈 수 없습니다.", MAX_MOVIE_NUMBER ));
        }
        if( movies.stream ( ).map ( Movie::code ).collect ( toSet ( ) ).size ( ) != movies.size ( )){
            throw new IllegalArgumentException("동일한 영화를 중복 등록할 수 없습니다." );
        }
    }

    public Movie getMovieByMovieCode ( MovieCode code ) {
        return this.movies ()
                    .stream ()
                    .filter ( m -> code.equals ( m.code () ) )
                    .findFirst ()
                    .orElseThrow (() -> new IllegalArgumentException ("그러한 영화는 등록되지 않았습니다."));
    }
}
