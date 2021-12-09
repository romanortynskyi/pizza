package com.pizza.pizza.dto.pizza.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddPizzaGroceryRequestDto {
    private Long groceryId;

    public Long getGroceryId() {
        return groceryId;
    }
}
