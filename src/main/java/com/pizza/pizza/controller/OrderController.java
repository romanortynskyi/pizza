package com.pizza.pizza.controller;

import com.pizza.pizza.dto.order.request.SaveOrderRequestDto;
import com.pizza.pizza.dto.order.response.OrderResponseDto;
import com.pizza.pizza.dto.pizza.request.AddPizzaGroceryRequestDto;
import com.pizza.pizza.dto.pizza.request.SavePizzaRequestDto;
import com.pizza.pizza.dto.pizza.request.UpdatePizzaRequestDto;
import com.pizza.pizza.dto.pizza.response.PizzaGroceryResponseDto;
import com.pizza.pizza.dto.pizza.response.PizzaResponseDto;
import com.pizza.pizza.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public OrderResponseDto save(@RequestBody @Validated final SaveOrderRequestDto saveOrderRequestDto) {
        OrderResponseDto order = orderService.save(saveOrderRequestDto);
        return order;
    }

    @GetMapping
    public List<OrderResponseDto> getAll() {
        List<OrderResponseDto> orders = orderService.getAll();
        return orders;
    }

    @GetMapping("/{id}")
    public OrderResponseDto getById(@PathVariable final long id) {
        OrderResponseDto order = orderService.getById(id);
        return order;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable final long id) {
        orderService.delete(id);
    }
}
