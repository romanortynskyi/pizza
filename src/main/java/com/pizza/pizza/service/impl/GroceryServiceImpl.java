package com.pizza.pizza.service.impl;

import com.pizza.pizza.dto.grocery.request.SaveGroceryRequestDto;
import com.pizza.pizza.dto.grocery.request.UpdateGroceryRequestDto;
import com.pizza.pizza.dto.grocery.response.GroceryResponseDto;
import com.pizza.pizza.entity.GroceryEntity;
import com.pizza.pizza.repository.GroceryRepository;
import com.pizza.pizza.service.GroceryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroceryServiceImpl implements GroceryService {
    private GroceryRepository groceryRepository;

    public GroceryServiceImpl(GroceryRepository groceryRepository) {
        this.groceryRepository = groceryRepository;
    }

    @Override
    public GroceryResponseDto save(SaveGroceryRequestDto saveGroceryRequestDto) {
        ModelMapper mapper = new ModelMapper();
        GroceryEntity grocery = mapper.map(saveGroceryRequestDto, GroceryEntity.class);
        GroceryEntity createdGrocery = groceryRepository.save(grocery);
        return mapper.map(createdGrocery, GroceryResponseDto.class);
    }

    @Override
    public List<GroceryResponseDto> getAll() {
        ModelMapper mapper = new ModelMapper();
        List<GroceryEntity> groceries = (List<GroceryEntity>) groceryRepository.findAll();
        return groceries.stream().map(u -> mapper.map(u, GroceryResponseDto.class)).collect(Collectors.toList());
    }

    @Override
    public GroceryResponseDto getById(Long id) {
        ModelMapper mapper = new ModelMapper();
        GroceryEntity grocery = groceryRepository.findById(id).get();
        return mapper.map(grocery, GroceryResponseDto.class);
    }

    @Override
    public GroceryResponseDto update(Long id, UpdateGroceryRequestDto updateGroceryRequestDto) {
        ModelMapper mapper = new ModelMapper();
        GroceryEntity grocery = groceryRepository.findById(id).get();

        grocery.setName(updateGroceryRequestDto.getName());
        grocery.setMass(updateGroceryRequestDto.getMass());
        grocery.setPrice(updateGroceryRequestDto.getPrice());

        groceryRepository.save(grocery);

        return mapper.map(grocery, GroceryResponseDto.class);
    }

    @Override
    public void delete(Long id) {
        GroceryEntity grocery = groceryRepository.findById(id).get();
        groceryRepository.delete(grocery);
    }
}
