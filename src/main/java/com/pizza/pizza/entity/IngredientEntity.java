package com.pizza.pizza.entity;

import javax.persistence.*;

@Entity
public class IngredientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    private Integer count;
}
