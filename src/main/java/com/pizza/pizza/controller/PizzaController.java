package com.pizza.pizza.controller;

import com.pizza.pizza.dto.grocery.response.GroceryResponseDto;
import com.pizza.pizza.dto.pizza.request.AddPizzaGroceryRequestDto;
import com.pizza.pizza.dto.pizza.request.SavePizzaRequestDto;
import com.pizza.pizza.dto.pizza.request.UpdatePizzaRequestDto;
import com.pizza.pizza.dto.pizza.response.PizzaGroceryResponseDto;
import com.pizza.pizza.dto.pizza.response.PizzaResponseDto;
import com.pizza.pizza.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/pizzas")
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;

    @PostMapping
    public PizzaResponseDto save(@RequestBody @Validated final SavePizzaRequestDto savePizzaRequestDto) {
        PizzaResponseDto user = pizzaService.save(savePizzaRequestDto);
        return user;
    }

    @PostMapping("/{id}/groceries")
    public PizzaGroceryResponseDto addGrocery(@PathVariable final long id, @RequestBody AddPizzaGroceryRequestDto addPizzaGroceryRequestDto) {
        PizzaGroceryResponseDto grocery = pizzaService.addGrocery(id, addPizzaGroceryRequestDto.getGroceryId());
        return grocery;
    }

    @GetMapping
    public List<PizzaResponseDto> getAll() {
        List<PizzaResponseDto> users = pizzaService.getAll();
        return users;
    }

    @GetMapping("/{id}")
    public PizzaResponseDto getById(@PathVariable final long id) {
        PizzaResponseDto user = pizzaService.getById(id);
        return user;
    }

    @GetMapping("/{id}/groceries")
    public List<GroceryResponseDto> getGroceriesByPizza(@PathVariable final long id) {
        List<GroceryResponseDto> groceries = pizzaService.getGroceriesByPizza(id);
        return groceries;
    }

    @PutMapping("/{id}")
    public PizzaResponseDto update(@PathVariable final long id, @RequestBody final UpdatePizzaRequestDto updatePizzaRequestDto) {
        PizzaResponseDto user = pizzaService.update(id, updatePizzaRequestDto);
        return user;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable final long id) {
        pizzaService.delete(id);
    }
}
