package com.pizza.pizza.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class PizzaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(
            name = "pizza_grocery",
            joinColumns = @JoinColumn(name = "pizza_id"),
            inverseJoinColumns = @JoinColumn(name = "grocery_id")
    )
    private List<GroceryEntity> groceries;

    @OneToMany(mappedBy = "pizza")
    private List<OrderItemEntity> orderItems;

    public List<OrderItemEntity> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemEntity> orderItems) {
        this.orderItems = orderItems;
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

    public List<GroceryEntity> getGroceries() {
        return groceries;
    }

    public void setGroceries(List<GroceryEntity> groceries) {
        this.groceries = groceries;
    }
}
