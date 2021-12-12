package com.pizza.pizza.repository;

import com.pizza.pizza.entity.OrderItemAdditionalGroceryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemAdditionalGroceryRepository extends CrudRepository<OrderItemAdditionalGroceryEntity, Long> {
}
