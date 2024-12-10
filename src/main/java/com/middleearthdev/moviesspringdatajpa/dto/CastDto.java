package com.middleearthdev.moviesspringdatajpa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CastDto {
    private String actorName;
    private String roleName;
    private Date birthDate;
    private String gender;
}
