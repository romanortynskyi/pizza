package com.pizza.pizza.dto.order.response;

import com.pizza.pizza.dto.grocery.response.GroceryResponseDto;
import com.pizza.pizza.dto.pizza.response.PizzaResponseDto;

import java.util.List;

public class OrderItemResponseDto {
    private PizzaResponseDto pizza;
    private Integer quantity;
    private List<AdditionalGroceryResponseDto> additionalGroceries;

    public PizzaResponseDto getPizza() {
        return pizza;
    }

    public void setPizza(PizzaResponseDto pizza) {
        this.pizza = pizza;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<AdditionalGroceryResponseDto> getAdditionalGroceries() {
        return additionalGroceries;
    }

    public void setAdditionalGroceries(List<AdditionalGroceryResponseDto> additionalGroceries) {
        this.additionalGroceries = additionalGroceries;
    }
}
