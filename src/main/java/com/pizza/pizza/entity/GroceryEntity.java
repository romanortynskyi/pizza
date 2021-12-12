package com.pizza.pizza.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class GroceryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double mass;
    private Double price;

    @ManyToMany(mappedBy = "groceries")
    private List<PizzaEntity> pizzas;

    @OneToMany(mappedBy = "grocery")
    private List<OrderItemAdditionalGroceryEntity> orderItemAdditionalGroceries;

    public GroceryEntity() {}

    public GroceryEntity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMass() {
        return mass;
    }

    public void setMass(Double mass) {
        this.mass = mass;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
