package com.pizza.pizza.service;

import com.pizza.pizza.dto.grocery.request.SaveGroceryRequestDto;
import com.pizza.pizza.dto.grocery.request.UpdateGroceryRequestDto;
import com.pizza.pizza.dto.grocery.response.GroceryResponseDto;

import java.util.List;

public interface GroceryService {
    GroceryResponseDto save(SaveGroceryRequestDto saveGroceryRequestDto);
    List<GroceryResponseDto> getAll();
    GroceryResponseDto getById(Long id);
    GroceryResponseDto update(Long id, UpdateGroceryRequestDto updateGroceryRequestDto);
    void delete(Long id);
}
