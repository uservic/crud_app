package com.andersen.javatrainee.model.movietheatre;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="price_categories")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PriceCategory extends AbstractEntity {

    private String categoryType;

    private Integer price;


}
