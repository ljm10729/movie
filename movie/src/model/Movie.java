package model;

import model.enums.MovieCode;
import model.enums.RestrictedRate;

import java.time.LocalDateTime;

public record Movie(MovieCode code, String title, LocalDateTime startTime, Double price, RestrictedRate rate, Screen screen) {

}
