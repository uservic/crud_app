package com.andersen.javatrainee.model.movietheatre;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "hall")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Hall extends AbstractEntity {

    @Column(name = "hall_name")
    private String name;

    @Column(name = "rows_quant")
    private Integer rowsQuantity;

    @Column(name = "seats_in_row")
    private Integer seatsInRow;

    public Hall(String name, Integer rows, Integer seats) {
        this(null, name, rows, seats);
    }

    public Hall(Integer id, String name, Integer rows, Integer seats) {
        super(id);
        this.name = name;
        this.rowsQuantity = rows;
        this.seatsInRow = seats;
    }

}
