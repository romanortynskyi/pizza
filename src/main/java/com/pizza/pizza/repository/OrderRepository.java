package com.pizza.pizza.repository;

import com.pizza.pizza.entity.OrderEntity;
import com.pizza.pizza.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<OrderEntity, Long> {
}
