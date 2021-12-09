package com.pizza.pizza.dto.pizza.response;

import com.pizza.pizza.dto.grocery.response.GroceryResponseDto;

public class PizzaGroceryResponseDto {
    private Long pizzaId;
    private GroceryResponseDto grocery;

    public Long getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(Long pizzaId) {
        this.pizzaId = pizzaId;
    }

    public GroceryResponseDto getGrocery() {
        return grocery;
    }

    public void setGrocery(GroceryResponseDto grocery) {
        this.grocery = grocery;
    }
}
