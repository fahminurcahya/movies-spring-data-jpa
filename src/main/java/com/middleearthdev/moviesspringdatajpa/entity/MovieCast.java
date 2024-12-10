package com.middleearthdev.moviesspringdatajpa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "movie_cast")
@Data
public class MovieCast {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    @JsonBackReference // This prevents serialization of the back reference
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "actor_id", nullable = false)
    @JsonBackReference
    private Actor actor;

    @Column(name = "role_name")
    private String roleName;
}
