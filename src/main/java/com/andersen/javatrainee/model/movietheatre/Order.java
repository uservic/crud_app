package com.andersen.javatrainee.model.movietheatre;

import com.andersen.javatrainee.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Order extends AbstractEntity {

    @JoinColumn(name = "price_cat_id")
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private PriceCategory priceCategory;

    @JoinColumn(name = "user_id")
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private User user;

    @JoinColumn(name = "session_id")
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private MovieSession movieSession;

    @JoinColumn(name = "seat_id")
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Seat seat;

    public Order(PriceCategory priceCategory, User user, MovieSession movieSession, Seat seat) {
        this(null, priceCategory, user, movieSession, seat);
    }

    public Order(Integer id, PriceCategory priceCategory, User user, MovieSession movieSession, Seat seat) {
        super(id);
        this.priceCategory = priceCategory;
        this.user = user;
        this.movieSession = movieSession;
        this.seat = seat;
    }

}