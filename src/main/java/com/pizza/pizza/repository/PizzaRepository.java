package com.pizza.pizza.repository;

import com.pizza.pizza.entity.PizzaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository extends CrudRepository<PizzaEntity, Long> {
}
