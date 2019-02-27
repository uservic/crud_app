package com.andersen.javatrainee.model.movietheatre;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "price_categories")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PriceCategory extends AbstractEntity {

    @Column(name = "cat_type")
    @NotBlank(message = "Price Category must not be blank")
    @Size(min = 3, max = 15, message = "Category must be from 3 to 15 characters")
    private String name;

    @Column(name = "price")
    @Min(value = 1, message = "Price should not be less than 1")
    private Integer price;

    public PriceCategory(String name, Integer price) {
        this(null, name, price);
    }

    public PriceCategory(Integer id, String name, Integer price) {
        super(id);
        this.name = name;
        this.price = price;
    }

}
