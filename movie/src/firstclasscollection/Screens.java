package firstclasscollection;

import model.Screen;
import model.enums.ScreenNo;

import java.util.List;

import static java.util.stream.Collectors.toSet;

public record Screens (List <Screen> screens) {
    private static final Integer MAX_SCREEN_NUMBER = 4;
    public Screens {
        validateScreensRegister ( screens );
    }

    private void validateScreensRegister ( List <Screen> screens ) {
        if(screens.size () > MAX_SCREEN_NUMBER) {
            throw new IllegalArgumentException(String.format ( "상영관의 숫자는 %s개를 넘어갈 수 없습니다.", MAX_SCREEN_NUMBER ));
        }
        if( screens.stream ().map ( Screen::screenNo ).collect ( toSet () ) .size () != screens.size ( )){
            throw new IllegalArgumentException("동일한 상영관을 중복 등록할 수 없습니다.");
        }
    }

    public Screen getScreenByScreenNo (ScreenNo screenNo ) {
        return this.screens ()
                    .stream ()
                    .filter ( screen -> screenNo.equals ( screen.screenNo () ) )
                    .findFirst ()
                    .orElseThrow (() -> new IllegalArgumentException ("현재 사용할 수 없는 상영관입니다."));
    }
}
