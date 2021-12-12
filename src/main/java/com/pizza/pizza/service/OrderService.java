package com.pizza.pizza.service;

import com.pizza.pizza.dto.order.request.SaveOrderRequestDto;
import com.pizza.pizza.dto.order.response.OrderResponseDto;

import java.util.List;

public interface OrderService {
    OrderResponseDto save(SaveOrderRequestDto saveOrderRequestDto);
    List<OrderResponseDto> getAll();
    OrderResponseDto getById(Long id);
    void delete(Long id);
}
