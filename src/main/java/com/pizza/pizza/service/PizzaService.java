package com.pizza.pizza.service;

import com.pizza.pizza.dto.grocery.response.GroceryResponseDto;
import com.pizza.pizza.dto.pizza.request.SavePizzaRequestDto;
import com.pizza.pizza.dto.pizza.request.UpdatePizzaRequestDto;
import com.pizza.pizza.dto.pizza.response.PizzaGroceryResponseDto;
import com.pizza.pizza.dto.pizza.response.PizzaResponseDto;

import java.util.List;

public interface PizzaService {
    PizzaResponseDto save(SavePizzaRequestDto createPizzaRequestDto);
    PizzaGroceryResponseDto addGrocery(Long id, Long groceryId);
    List<PizzaResponseDto> getAll();
    PizzaResponseDto getById(Long id);
    PizzaResponseDto update(Long id, UpdatePizzaRequestDto updatePizzaRequestDto);
    void delete(Long id);
    void deleteGrocery(long id, long groceryId);
}
