package model;

import model.enums.ScreenNo;
import model.enums.ScreenSize;

public record Screen(ScreenNo screenNo, ScreenSize size, Integer capacity) {
    public Screen ( ScreenNo screenNo, ScreenSize size, Integer capacity ) {
        this.screenNo = screenNo;
        this.size = size;
        validateCapacity(capacity);
        this.capacity = capacity;
    }

    private void validateCapacity ( Integer capacity ) {
        if(this.size.getMaxCapacity() < capacity){
            throw new IllegalArgumentException ("해당 상영관의 허용 입장인원을 초과했습니다.");
        }
    }
}
