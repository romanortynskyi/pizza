package com.pizza.pizza.dto.order.request;

import java.util.List;

public class SaveOrderItemRequestDto {
    private Long pizzaId;
    private Integer quantity;
    private List<Long> additionalGroceriesIds;

    public Long getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(Long pizzaId) {
        this.pizzaId = pizzaId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<Long> getAdditionalGroceriesIds() {
        return additionalGroceriesIds;
    }

    public void setAdditionalGroceriesIds(List<Long> additionalGroceriesIds) {
        this.additionalGroceriesIds = additionalGroceriesIds;
    }
}
