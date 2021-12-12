package com.pizza.pizza.service.impl;

import com.pizza.pizza.dto.grocery.response.GroceryResponseDto;
import com.pizza.pizza.dto.order.request.SaveOrderRequestDto;
import com.pizza.pizza.dto.order.response.AdditionalGroceryResponseDto;
import com.pizza.pizza.dto.order.response.OrderItemResponseDto;
import com.pizza.pizza.dto.order.response.OrderResponseDto;
import com.pizza.pizza.dto.pizza.response.PizzaResponseDto;
import com.pizza.pizza.entity.*;
import com.pizza.pizza.repository.*;
import com.pizza.pizza.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private OrderItemRepository orderItemRepository;
    private PizzaRepository pizzaRepository;
    private OrderItemAdditionalGroceryRepository orderItemAdditionalGroceryRepository;
    private GroceryRepository groceryRepository;

    public OrderServiceImpl(
            OrderRepository orderRepository,
            OrderItemRepository orderItemRepository,
            PizzaRepository pizzaRepository,
            OrderItemAdditionalGroceryRepository orderItemAdditionalGroceryRepository,
            GroceryRepository groceryRepository
    ) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.pizzaRepository = pizzaRepository;
        this.orderItemAdditionalGroceryRepository = orderItemAdditionalGroceryRepository;
        this.groceryRepository = groceryRepository;
    }

    @Transactional
    @Override
    public OrderResponseDto save(SaveOrderRequestDto saveOrderRequestDto) {
        ModelMapper mapper = new ModelMapper();
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setFirstName(saveOrderRequestDto.getFirstName());
        orderEntity.setLastName(saveOrderRequestDto.getLastName());
        orderEntity.setPhoneNumber(saveOrderRequestDto.getPhoneNumber());
        orderEntity.setEmail(saveOrderRequestDto.getEmail());
        orderEntity.setRegion(saveOrderRequestDto.getRegion());
        orderEntity.setDistrict(saveOrderRequestDto.getDistrict());
        orderEntity.setCity(saveOrderRequestDto.getCity());
        orderEntity.setStreet(saveOrderRequestDto.getStreet());
        orderEntity.setBuilding(saveOrderRequestDto.getBuilding());
        orderEntity.setApartment(saveOrderRequestDto.getApartment());
        orderEntity.setUserComment(saveOrderRequestDto.getUserComment());

        orderRepository.save(orderEntity);

        List<OrderItemEntity> orderItems = new ArrayList<>();

        saveOrderRequestDto.getItems().stream().forEach(i -> {
            OrderItemEntity orderItemEntity = new OrderItemEntity();

            PizzaEntity pizzaEntity = new PizzaEntity();
            pizzaEntity.setId(i.getPizzaId());

            orderItemEntity.setOrder(orderEntity);
            orderItemEntity.setPizza(pizzaEntity);
            orderItemEntity.setQuantity(i.getQuantity());

            orderItemRepository.save(orderItemEntity);
            orderItems.add(orderItemEntity);

            List<OrderItemAdditionalGroceryEntity> additionalGroceryEntities = new ArrayList<>();

            i.getAdditionalGroceriesIds().stream()
                    .forEach(id -> {
                        OrderItemAdditionalGroceryEntity additionalGroceryEntity = new OrderItemAdditionalGroceryEntity();
                        additionalGroceryEntity.setGrocery(new GroceryEntity(id));
                        additionalGroceryEntity.setOrderItem(orderItemEntity);

                        additionalGroceryEntities.add(additionalGroceryEntity);

                        orderItemAdditionalGroceryRepository.save(additionalGroceryEntity);
                    });

            orderItemEntity.setOrderItemAdditionalGroceries(additionalGroceryEntities);
        });

        orderEntity.setOrderItems(orderItems);

        OrderResponseDto responseDto = new OrderResponseDto();
        responseDto.setId(orderEntity.getId());
        responseDto.setFirstName(orderEntity.getFirstName());
        responseDto.setLastName(orderEntity.getLastName());
        responseDto.setPhoneNumber(orderEntity.getPhoneNumber());
        responseDto.setEmail(orderEntity.getEmail());
        responseDto.setRegion(orderEntity.getRegion());
        responseDto.setDistrict(orderEntity.getDistrict());
        responseDto.setCity(orderEntity.getCity());
        responseDto.setStreet(orderEntity.getStreet());
        responseDto.setBuilding(orderEntity.getBuilding());
        responseDto.setApartment(orderEntity.getApartment());
        responseDto.setUserComment(orderEntity.getUserComment());

        List<OrderItemResponseDto> orderItemResponseDtos = orderItems.stream().map(item -> {
            PizzaEntity pizza = pizzaRepository.findById(item.getPizza().getId()).get();
            PizzaResponseDto pizzaResponseDto = mapper.map(pizza, PizzaResponseDto.class);
            Integer quantity = item.getQuantity();

            OrderItemResponseDto dto = new OrderItemResponseDto();
            dto.setPizza(pizzaResponseDto);
            dto.setQuantity(quantity);

            List<AdditionalGroceryResponseDto> additionalGroceryResponseDtos = item.getOrderItemAdditionalGroceries().stream().map(g -> {
                OrderItemAdditionalGroceryEntity additionalGroceryEntity = orderItemAdditionalGroceryRepository.findById(item.getId()).get();
                GroceryEntity groceryEntity = groceryRepository.findById(additionalGroceryEntity.getGrocery().getId()).get();
                AdditionalGroceryResponseDto additionalGroceryResponseDto = new AdditionalGroceryResponseDto();
                additionalGroceryResponseDto.setGrocery(mapper.map(groceryEntity, GroceryResponseDto.class));

                return additionalGroceryResponseDto;
            }).collect(Collectors.toList());

            dto.setAdditionalGroceries(additionalGroceryResponseDtos);

            return dto;
        }).collect(Collectors.toList());

        responseDto.setItems(orderItemResponseDtos);

        return responseDto;
    }

    @Override
    public List<OrderResponseDto> getAll() {
        ModelMapper mapper = new ModelMapper();
        List<OrderEntity> orderEntity = (List<OrderEntity>) orderRepository.findAll();

        return orderEntity.stream().map(o -> mapper.map(o, OrderResponseDto.class)).collect(Collectors.toList());
    }

    @Override
    public OrderResponseDto getById(Long id) {
        ModelMapper mapper = new ModelMapper();
        OrderEntity orderEntity = orderRepository.findById(id).get();

        return mapper.map(orderEntity, OrderResponseDto.class);
    }

    @Override
    public void delete(Long id) {
        OrderEntity orderEntity = orderRepository.findById(id).get();
        orderRepository.delete(orderEntity);
    }
}
