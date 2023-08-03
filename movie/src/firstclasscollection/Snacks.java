package firstclasscollection;

import model.Snack;
import model.enums.SnackCode;
import model.enums.SnackSize;

import java.util.List;

import static java.util.stream.Collectors.toSet;

public record Snacks(List <Snack> snacks) {
    private static final Integer MAX_SNACK_NUMBER = 5;
    public Snacks {
        validateSnacksRegister ( snacks );
    }

    private void validateSnacksRegister ( List <Snack> snacks ) {
        if(snacks.size () > MAX_SNACK_NUMBER) {
            throw new IllegalArgumentException(String.format ( "등록가능한 간식의 숫자는 %s개를 넘어갈 수 없습니다.", MAX_SNACK_NUMBER ));
        }
        if( snacks.stream ().map ( Snack::getSnackCode ).collect ( toSet ( ) ).size ( ) != snacks.size ( )){
            throw new IllegalArgumentException("동일한 간식을 중복 등록할 수 없습니다." );
        }
    }

    public Snack getSnackBySnackCode ( SnackCode code, SnackSize size ) {
        Snack snack = this.snacks ( )
                            .stream ( )
                            .filter ( m -> code.equals ( m.getSnackCode ( ) ) )
                            .findFirst ( )
                            .orElseThrow ( ( ) -> new IllegalArgumentException ( "그러한 간식은 등록되지 않았습니다." ) );
        return new Snack ( snack.getSnackCode (), snack.getName (), snack.getBasePrice (), size );
    }
}
