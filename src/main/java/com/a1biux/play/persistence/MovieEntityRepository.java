package com.a1biux.play.persistence;

import com.a1biux.play.domain.dto.MovieDto;
import com.a1biux.play.domain.dto.UpdateMovieDto;
import com.a1biux.play.domain.repository.MovieRepository;
import com.a1biux.play.persistence.crud.CrudMovieEntity;
import com.a1biux.play.persistence.entity.MovieEntity;
import com.a1biux.play.persistence.mapper.MovieMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class MovieEntityRepository implements MovieRepository {

    private final CrudMovieEntity crudMovieEntity;
    private final MovieMapper movieMapper;

    public MovieEntityRepository(CrudMovieEntity crudMovieEntity, MovieMapper movieMapper) {
        this.crudMovieEntity = crudMovieEntity;
        this.movieMapper = movieMapper;
    }

    @Override
    public List<MovieDto> getAll() {
        return this.movieMapper.toDto(this.crudMovieEntity.findAll());
    }

    @Override
    public MovieDto getById(long id) {
        MovieEntity movieEntity = this.crudMovieEntity.findById(id).orElse(null);
        return movieMapper.toDto(movieEntity);
    }

    @Override
    public MovieDto save(MovieDto movieDto) {
        MovieEntity movieEntity = this.movieMapper.toEntity(movieDto);
        movieEntity.setStatus("D");
        return this.movieMapper.toDto(this.crudMovieEntity.save(movieEntity));
    }

    @Override
    public MovieDto update(long id, UpdateMovieDto updateMovieDto) {
        MovieEntity movieEntity = this.crudMovieEntity.findById(id).orElse(null);

        if (movieEntity == null) return null;

        this.movieMapper.updateEntityFromDto(updateMovieDto, movieEntity);

        return this.movieMapper.toDto(this.crudMovieEntity.save(movieEntity));
    }

    @Override
    public void delete(long id) {
        this.crudMovieEntity.deleteById(id);
    }


}
