package com.learn.first.restapi.orders.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.first.restapi.orders.model.COrder;

public interface IOrderRepository extends JpaRepository<COrder, Long> {
    COrder findByOrderCode(String orderCode);

    COrder findByOrderCodeContaining(String code);

    List<Object> getAllOrderByCustomerId(Long customerId);
}