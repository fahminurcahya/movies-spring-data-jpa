package com.middleearthdev.moviesspringdatajpa.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class GetMoviesResponse {
    private int id;
    private String title;
    private int durationMinutes;
    private float rating;
    private String description;
    private List<CastDto> cast;
}
