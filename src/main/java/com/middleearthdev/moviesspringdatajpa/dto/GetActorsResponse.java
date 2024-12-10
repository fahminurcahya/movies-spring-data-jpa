package com.middleearthdev.moviesspringdatajpa.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class GetActorsResponse {
    private String actorName;
    private Date birthDate;
    private String gender;
    private List<MovieDto> movies;
}
