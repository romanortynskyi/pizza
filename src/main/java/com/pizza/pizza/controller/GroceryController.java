package com.pizza.pizza.controller;

import com.pizza.pizza.dto.grocery.request.SaveGroceryRequestDto;
import com.pizza.pizza.dto.grocery.request.UpdateGroceryRequestDto;
import com.pizza.pizza.dto.grocery.response.GroceryResponseDto;
import com.pizza.pizza.service.GroceryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/groceries")
public class GroceryController {

    @Autowired
    private GroceryService groceryService;

    @PostMapping
    public GroceryResponseDto save(@RequestBody @Validated final SaveGroceryRequestDto saveGroceryRequestDto) {
        GroceryResponseDto user = groceryService.save(saveGroceryRequestDto);
        return user;
    }

    @GetMapping
    public List<GroceryResponseDto> getAll() {
        List<GroceryResponseDto> users = groceryService.getAll();
        return users;
    }

    @GetMapping("/{id}")
    public GroceryResponseDto getById(@PathVariable final long id) {
        GroceryResponseDto user = groceryService.getById(id);
        return user;
    }

    @PutMapping("/{id}")
    public GroceryResponseDto update(@PathVariable final long id, @RequestBody final UpdateGroceryRequestDto updateGroceryRequestDto) {
        GroceryResponseDto user = groceryService.update(id, updateGroceryRequestDto);
        return user;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable final long id) {
        groceryService.delete(id);
    }
}
