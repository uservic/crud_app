package com.andersen.javatrainee.model.movietheatre;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "movies")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Movie extends AbstractEntity {

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
        super(movie.getId());
        this.title = movie.getTitle();
        this.description = movie.getDescription();
    }

    public Movie(Integer id, String title, String description) {
        super(id);
        this.title = title;
        this.description = description;
    }

}
