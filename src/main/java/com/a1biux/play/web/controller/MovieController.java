package com.a1biux.play.web.controller;

import com.a1biux.play.domain.dto.MovieDto;
import com.a1biux.play.domain.dto.SuggestRequestDto;
import com.a1biux.play.domain.dto.UpdateMovieDto;
import com.a1biux.play.domain.service.MovPlayAiService;
import com.a1biux.play.domain.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;
    private final MovPlayAiService movPlayAiService;

    public MovieController(MovieService movieService, MovPlayAiService movPlayAiService) {
        this.movieService = movieService;
        this.movPlayAiService = movPlayAiService;
    }

    @GetMapping
    public ResponseEntity<List<MovieDto>> getAll() {
        return ResponseEntity.ok(this.movieService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getById(@PathVariable long id) {
        MovieDto movieDto = this.movieService.getById(id);
        if(movieDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(movieDto);
    }

    @PostMapping("/suggest")
    public ResponseEntity<String> generateMovieSuggestion(@RequestBody SuggestRequestDto suggestRequestDto) {
        return ResponseEntity.ok(this.movPlayAiService.generateMoviesSuggestion(suggestRequestDto.userPreferences()));
    }

    @PostMapping
    public ResponseEntity<MovieDto> add(@RequestBody MovieDto movieDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.movieService.add(movieDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDto> update(@PathVariable long id, @RequestBody UpdateMovieDto updateMovieDto){
        return ResponseEntity.ok(this.movieService.update(id, updateMovieDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        this.movieService.delete(id);
        return ResponseEntity.ok().build();
    }
}
