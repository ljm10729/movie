package model;

import model.enums.DiscountType;
import model.enums.RestrictedRate;
import model.enums.SnackSize;

import java.util.List;
import java.util.stream.Collectors;

public class Reservation {
    private final String name;
    private final Integer age;
    private final Double amount;
    private final Movie movie;
    private final List <Snack> snackList;
    private final DiscountType type;

    private Reservation ( String name, Integer age, Double amount, Movie movie, List <Snack> snackList, DiscountType type ) {
        this.name = name;
        this.age = age;
        this.amount = amount;
        this.movie = movie;
        this.snackList = snackList;
        this.type = type;
    }

    public static Reservation of(String name, Integer age, DiscountType type, Movie movie, List <Snack> snackList){
        validateCustomerAge ( age, movie );
        Double totalAmount = getMovieAmount ( type, movie ) + getSnacksAmount ( snackList );
        return new Reservation ( name, age, totalAmount, movie, snackList, type );
    }

    private static void validateCustomerAge ( Integer age, Movie movie ) {
        RestrictedRate rate = movie.rate ( );
        Integer restrictedAge = rate.getRestrictedAge ( );
        if(restrictedAge > age ) {
            throw new IllegalArgumentException ("해당 영화를 관람할 수 없는 연령입니다.");
        }
    }
    private static double getSnacksAmount ( List <Snack> snackList ) {
        return snackList.stream ( )
                        .map ( snack -> {
                            Double snackBasePrice = snack.getBasePrice ( );
                            SnackSize size = snack.getSnackSize ( );
                            return snackBasePrice * size.getMultipleRate ( );
                        } )
                        .toList ( )
                        .stream ()
                        .reduce ( Double::sum )
                        .orElse ( 0.0 );
    }

    private static double getMovieAmount ( DiscountType type, Movie movie ) {
        Double moviePrice = movie.price ( );
        Double rate = type.getRate ( );
        return moviePrice * (1 - rate);
    }
    public String getName ( ) {
        return name;
    }

    public Integer getAge ( ) {
        return age;
    }

    public Double getAmount ( ) {
        return amount;
    }

    public Movie getMovie ( ) {
        return movie;
    }

    public List<Snack> getSnackList ( ) {
        return snackList;
    }

    public DiscountType getType ( ) {
        return type;
    }

    public String toStringSnackList () {
        return snackList.stream ()
                        .map(snack -> snack.getName () + " " + snack.getSnackSize ())
                        .collect ( Collectors.joining ( " / " ) );
    }
}
