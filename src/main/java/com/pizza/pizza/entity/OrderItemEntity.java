package com.pizza.pizza.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class OrderItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    @OneToMany(mappedBy = "orderItem")
    private List<OrderItemAdditionalGroceryEntity> orderItemAdditionalGroceries;

    public Long getId() {
        return id;
    }

    public List<OrderItemAdditionalGroceryEntity> getOrderItemAdditionalGroceries() {
        return orderItemAdditionalGroceries;
    }

    public void setOrderItemAdditionalGroceries(List<OrderItemAdditionalGroceryEntity> orderItemAdditionalGroceries) {
        this.orderItemAdditionalGroceries = orderItemAdditionalGroceries;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public PizzaEntity getPizza() {
        return pizza;
    }

    public void setPizza(PizzaEntity pizza) {
        this.pizza = pizza;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @ManyToOne
    @JoinColumn(name = "pizza_id")
    private PizzaEntity pizza;
    private Integer quantity;
}
