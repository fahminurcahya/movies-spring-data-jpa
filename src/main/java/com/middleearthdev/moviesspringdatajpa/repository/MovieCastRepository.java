package com.middleearthdev.moviesspringdatajpa.repository;

import com.middleearthdev.moviesspringdatajpa.entity.MovieCast;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieCastRepository extends JpaRepository<MovieCast, Integer> {
}
