package com.a1biux.play.persistence.mapper;

import com.a1biux.play.domain.dto.MovieDto;
import com.a1biux.play.domain.dto.UpdateMovieDto;
import com.a1biux.play.persistence.entity.MovieEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = {GenreMapper.class})
public interface MovieMapper {
    @Mapping(source = "title", target = "title")
    @Mapping(source = "runtime", target = "duration")
    @Mapping(source = "genre", target = "genre", qualifiedByName = "stringToGenre")
    @Mapping(source = "releaseDate", target = "release")
    @Mapping(source = "rating", target = "rating")
    MovieDto toDto(MovieEntity entity);
    List<MovieDto> toDto(Iterable<MovieEntity> entities);

    @InheritInverseConfiguration
    @Mapping(source = "genre", target = "genre", qualifiedByName = "genreToString")
    MovieEntity toEntity(MovieDto movieDto);

    @Mapping(target = "title", source = "title")
    @Mapping(target = "releaseDate", source = "release")
    @Mapping(target = "rating", source = "rating")
    void updateEntityFromDto(UpdateMovieDto updateMovieDto, @MappingTarget MovieEntity movieEntity);
}
