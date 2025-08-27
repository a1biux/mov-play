package com.a1biux.play.domain.dto;

import java.time.LocalDate;

public record UpdateMovieDto(
        String title,
        LocalDate release,
        Double rating) {

}
