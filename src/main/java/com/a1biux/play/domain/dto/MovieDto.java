package com.a1biux.play.domain.dto;

import com.a1biux.play.domain.Genre;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record MovieDto(
        Long id,
        @NotBlank(message = "Debes colocar un título")
        String title,
        @Positive(message = "El valor de la duración debe ser positivo")
        Integer duration,
        Genre genre,
        @PastOrPresent(message = "La fecha debe ser anterior a la actual")
        LocalDate release,
        @Min(value = 0, message = "El valor mínimo debe ser 0")
        @Max(value = 5, message = "El valor máximp debe ser 5")
        Double rating) {

}
