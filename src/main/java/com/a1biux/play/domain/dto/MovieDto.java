package com.a1biux.play.domain.dto;

import com.a1biux.play.domain.Genre;

import java.time.LocalDate;

public record MovieDto(
        Long id,
        String title,
        Integer duration,
        Genre genre,
        LocalDate release,
        Double rating) {

}
