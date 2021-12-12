package com.pizza.pizza.entity;

import javax.persistence.*;

@Entity
public class OrderItemAdditionalGroceryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_item_id")
    private OrderItemEntity orderItem;

    @ManyToOne
    @JoinColumn(name = "grocery_id")
    private GroceryEntity grocery;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderItemEntity getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItemEntity orderItem) {
        this.orderItem = orderItem;
    }

    public GroceryEntity getGrocery() {
        return grocery;
    }

    public void setGrocery(GroceryEntity grocery) {
        this.grocery = grocery;
    }
}
