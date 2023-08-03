import firstclasscollection.Movies;
import firstclasscollection.Screens;
import firstclasscollection.Snacks;
import model.Movie;
import model.Reservation;
import model.Screen;
import model.Snack;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static model.enums.DiscountType.*;
import static model.enums.MovieCode.*;
import static model.enums.RestrictedRate.*;
import static model.enums.ScreenNo.*;
import static model.enums.ScreenSize.*;
import static model.enums.SnackCode.*;
import static model.enums.SnackSize.*;

public class Main {
    private static Screens initScreen () {
        return new Screens ( Arrays.asList (
                new Screen( SCREEN_A, LARGE, 300),
                new Screen(SCREEN_B, SMALL, 100),
                new Screen(SCREEN_C, MIDDLE, 200),
                new Screen(SCREEN_D, MIDDLE, 200)
        ) );
    }
    private static Movies initMovie ( Screens screens ){
        return new Movies ( Arrays.asList(new Movie(
                MOVIE_A,
                "인어 공주",
                LocalDateTime.of(2023, 6, 1, 18, 10),
                10000.00,
                ALL,
                screens.getScreenByScreenNo ( SCREEN_A )
        ), new Movie(
                MOVIE_B,
                "가디언즈 오브 갤럭시",
                LocalDateTime.of(2023, 6, 1, 15, 20),
                10000.00,
                TWELVE,
                screens.getScreenByScreenNo ( SCREEN_B )
        ), new Movie(
                MOVIE_C,
                "범죄 도시3",
                LocalDateTime.of(2023, 6, 1, 19, 20),
                10000.00,
                FIFTEEN,
                screens.getScreenByScreenNo ( SCREEN_C )
        ) ) );
    }
    private static Snacks initSnack () {
        return new Snacks ( Arrays.asList (
                new Snack( SNACK_A, "팝콘", 5000.0),
                new Snack(SNACK_B,"콜라", 3000.0),
                new Snack(SNACK_C, "버터구이 오징어", 10000.0)
        ) );
    }

    public static void main(String[] args) {
        Movies movies = initMovie (initScreen ());
        Snacks snacks = initSnack();

        /*****************실제 예매 하는 부분 ******************/
        //예약자
        Reservation reservation = Reservation.of(
            "이재민",
            16,
            CARD,
            movies.getMovieByMovieCode ( MOVIE_C ),
            List.of (
                snacks.getSnackBySnackCode ( SNACK_C, BENTI ),
                snacks.getSnackBySnackCode ( SNACK_A, TALL )
            )
        );


        System.out.println("************* 영화 예매 확인 ************");
        System.out.println("    구매자: " + reservation.getName ());
        System.out.println("    영화 제목: " + reservation.getMovie ().title());
        System.out.println("    시간: " + reservation.getMovie ().startTime().format(DateTimeFormatter.ISO_DATE));
        System.out.println("    상영관: " + reservation.getMovie ().screen().screenNo());
        System.out.println("    간식: " + reservation.toStringSnackList ());
        System.out.println("    금액: " + (reservation.getAmount ()));

    }
}