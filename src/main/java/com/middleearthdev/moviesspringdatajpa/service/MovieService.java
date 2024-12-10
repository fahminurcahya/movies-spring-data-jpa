package com.middleearthdev.moviesspringdatajpa.service;

import com.middleearthdev.moviesspringdatajpa.dto.*;
import com.middleearthdev.moviesspringdatajpa.dto.GetActorsResponse;
import com.middleearthdev.moviesspringdatajpa.dto.GetMoviesResponse;
import com.middleearthdev.moviesspringdatajpa.entity.Actor;
import com.middleearthdev.moviesspringdatajpa.entity.Movie;
import com.middleearthdev.moviesspringdatajpa.repository.ActorRepository;
import com.middleearthdev.moviesspringdatajpa.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ActorRepository actorRepository;



    public ResponseEntity<?> getAllMovies() {
        List<Movie> allMovies = movieRepository.findAll();
        List<GetMoviesResponse> response = new ArrayList<>();
        for (Movie movie : allMovies) {
            GetMoviesResponse moviesResp = new GetMoviesResponse();
            moviesResp.setId(movie.getId());
            moviesResp.setDescription(movie.getDescription());
            moviesResp.setRating(movie.getRating());
            List<CastDto> castDtos = movie.getCast()
                    .stream()
                    .map(movieCast -> {
                        CastDto castDto = new CastDto(
                                movieCast.getActor().getName(),
                                movieCast.getRoleName(),
                                movieCast.getActor().getBirthDate(),
                                movieCast.getActor().getGender().toString()
                        );
                        return castDto;
                    }).toList();
            moviesResp.setCast(castDtos);
            response.add(moviesResp);
        }
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<?> getAllActor() {
        List<Actor> actorList = actorRepository.findAll();
        List<GetActorsResponse> resps = new ArrayList<>();
        for (Actor actor : actorList) {
            GetActorsResponse actorDto = new GetActorsResponse();
            actorDto.setActorName(actor.getName());
            actorDto.setBirthDate(actor.getBirthDate());
            actorDto.setGender(actor.getGender().toString());
            List<MovieDto> listMovieDto = actor.getMovies().stream()
                    .map(movie -> {
                        MovieDto movieDto = new MovieDto();
                        movieDto.setId(movie.getMovie().getId());
                        movieDto.setTitle(movie.getMovie().getTitle());
                        movieDto.setDescription(movie.getMovie().getDescription());
                        movieDto.setRoleName(movie.getRoleName());
                        movieDto.setDurationMinutes(movie.getMovie().getDurationMinutes());
                        movieDto.setRating(movie.getMovie().getRating());
                        return movieDto;
                    }).toList();
            actorDto.setMovies(listMovieDto);
            resps.add(actorDto);
        }
        return ResponseEntity.ok(resps);
    }


}
