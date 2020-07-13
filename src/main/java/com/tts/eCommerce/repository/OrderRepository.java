package com.tts.eCommerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.eCommerce.model.OrderTable;

@Repository
public interface OrderRepository
    extends CrudRepository<OrderTable, Long> {
  
}