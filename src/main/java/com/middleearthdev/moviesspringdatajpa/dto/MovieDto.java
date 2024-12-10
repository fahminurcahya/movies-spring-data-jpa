package com.middleearthdev.moviesspringdatajpa.dto;

import lombok.Data;

@Data
public class MovieDto {
    private int id;
    private String title;
    private String roleName;
    private int durationMinutes;
    private float rating;
    private String description;
}
