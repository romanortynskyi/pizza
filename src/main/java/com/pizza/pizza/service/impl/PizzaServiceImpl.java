package com.pizza.pizza.service.impl;

import com.pizza.pizza.dto.grocery.response.GroceryResponseDto;
import com.pizza.pizza.dto.pizza.request.SavePizzaRequestDto;
import com.pizza.pizza.dto.pizza.request.UpdatePizzaRequestDto;
import com.pizza.pizza.dto.pizza.response.PizzaGroceryResponseDto;
import com.pizza.pizza.dto.pizza.response.PizzaResponseDto;
import com.pizza.pizza.dto.user.response.UserResponseDto;
import com.pizza.pizza.entity.GroceryEntity;
import com.pizza.pizza.entity.PizzaEntity;
import com.pizza.pizza.entity.UserEntity;
import com.pizza.pizza.repository.GroceryRepository;
import com.pizza.pizza.repository.PizzaRepository;
import com.pizza.pizza.service.PizzaService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PizzaServiceImpl implements PizzaService {

    private PizzaRepository pizzaRepository;
    private GroceryRepository groceryRepository;

    public PizzaServiceImpl(PizzaRepository pizzaRepository, GroceryRepository groceryRepository) {
        this.pizzaRepository = pizzaRepository;
        this.groceryRepository = groceryRepository;
    }

    @Override
    public PizzaResponseDto save(SavePizzaRequestDto createPizzaRequestDto) {
        ModelMapper mapper = new ModelMapper();
        PizzaEntity pizza = mapper.map(createPizzaRequestDto, PizzaEntity.class);
        PizzaEntity createdPizza = pizzaRepository.save(pizza);
        return mapper.map(createdPizza, PizzaResponseDto.class);
    }

    // DOES NOT WORK!
    @Override
    public PizzaGroceryResponseDto addGrocery(Long id, Long groceryId) {
        ModelMapper mapper = new ModelMapper();

        PizzaEntity pizza = pizzaRepository.findById(id).get();
        List<GroceryEntity> groceries = pizza.getGroceries();

        GroceryEntity grocery = groceryRepository.findById(groceryId).get();
        groceries.add(grocery);

        pizza.setGroceries(groceries);
        pizzaRepository.save(pizza);

        PizzaGroceryResponseDto responseDto = new PizzaGroceryResponseDto();

        responseDto.setPizzaId(id);
        responseDto.setGrocery(mapper.map(grocery, GroceryResponseDto.class));

        return responseDto;
    }

    @Override
    public List<PizzaResponseDto> getAll() {
        ModelMapper mapper = new ModelMapper();
        List<PizzaEntity> pizzas = (List<PizzaEntity>) pizzaRepository.findAll();
        return pizzas.stream().map(p -> mapper.map(p, PizzaResponseDto.class)).collect(Collectors.toList());
    }

    @Override
    public PizzaResponseDto getById(Long id) {
        ModelMapper mapper = new ModelMapper();
        PizzaEntity pizza = pizzaRepository.findById(id).get();
        return mapper.map(pizza, PizzaResponseDto.class);
    }

    @Override
    public List<GroceryResponseDto> getGroceriesByPizza(Long id) {
        ModelMapper mapper = new ModelMapper();
        PizzaEntity pizza = pizzaRepository.findById(id).get();
        List<GroceryEntity> groceries = pizza.getGroceries();

        return groceries.stream().map(g -> mapper.map(g, GroceryResponseDto.class)).collect(Collectors.toList());
    }

    @Override
    public PizzaResponseDto update(Long id, UpdatePizzaRequestDto updatePizzaRequestDto) {
        ModelMapper mapper = new ModelMapper();
        PizzaEntity pizza = pizzaRepository.findById(id).get();

        pizza.setName(updatePizzaRequestDto.getName());

        pizzaRepository.save(pizza);

        return mapper.map(pizza, PizzaResponseDto.class);
    }

    @Override
    public void delete(Long id) {
        pizzaRepository.deleteById(id);
    }
}
