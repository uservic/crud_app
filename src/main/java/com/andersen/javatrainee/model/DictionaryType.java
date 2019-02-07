package com.andersen.javatrainee.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "dt_seq_gen")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DictionaryType {

    @Id
    private String name;

    @Column(name = "counter")
    @NotNull
    private Integer counter;

}
