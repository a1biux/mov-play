package com.a1biux.play.persistence.crud;

import com.a1biux.play.persistence.entity.MovieEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudMovieEntity extends CrudRepository<MovieEntity, Long> {

}
