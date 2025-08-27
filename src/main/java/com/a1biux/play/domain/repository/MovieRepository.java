package com.a1biux.play.domain.repository;

import com.a1biux.play.domain.dto.MovieDto;
import com.a1biux.play.domain.dto.UpdateMovieDto;

import java.util.List;

public interface MovieRepository {
    List<MovieDto> getAll();
    MovieDto getById(long id);
    MovieDto save(MovieDto movieDto);
    MovieDto update(long id, UpdateMovieDto updateMovieDto);
    void delete(long id);
}
