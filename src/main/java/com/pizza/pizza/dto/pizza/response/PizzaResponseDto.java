package com.pizza.pizza.dto.pizza.response;

import java.util.List;

public class PizzaResponseDto {
    private Long id;
    private String name;
    private List<PizzaGroceryResponseDto> groceries;

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

    public List<PizzaGroceryResponseDto> getGroceries() {
        return groceries;
    }

    public void setGroceries(List<PizzaGroceryResponseDto> groceries) {
        this.groceries = groceries;
    }
}
