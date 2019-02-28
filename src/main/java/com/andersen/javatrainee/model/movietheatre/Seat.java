package com.andersen.javatrainee.model.movietheatre;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "seats")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Seat extends AbstractEntity {

    @Column(name = "row")
    private Integer row;

    @Column(name = "number")
    private Integer seat_number;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "hall_id")
    private Hall hall;

    public Seat(Integer row, Integer seat_number, Hall hall) {
        this(null, row, seat_number, hall);
    }

    public Seat(Integer id, Integer row, Integer seat_number, Hall hall) {
        super(id);
        this.row = row;
        this.seat_number = seat_number;
        this.hall = hall;
    }

}