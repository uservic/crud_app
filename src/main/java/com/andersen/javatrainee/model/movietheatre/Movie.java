package com.andersen.javatrainee.model.movietheatre;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "movies")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    @NotBlank(message = "Movie title must not be blank")
    @Size(min = 1, max = 50, message = "Title must be from 1 to 50 characters")
    private String title;

    @Column(name = "description")
    @NotBlank(message = "Movie description must not be blank")
    @Size(min = 1, max = 50, message = "Description must be from 1 to 50 characters")
    private String description;

    public Movie(String title, String description) {
        this(null, title, description);
    }

    //Copy-constructor
    public Movie(Movie movie) {
        this(movie.getId(), movie.getTitle(), movie.getDescription());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(Hibernate.getClass(o))) return false;
        Movie movie = (Movie) o;
        return id != null && id.equals(movie.id);
    }

    @Override
    public int hashCode() {
        return id == null ? 0 : id;
    }

}
