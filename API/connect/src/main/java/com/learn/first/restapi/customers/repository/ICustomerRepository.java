package com.learn.first.restapi.customers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.first.restapi.customers.model.CCustomer;

public interface ICustomerRepository extends JpaRepository<CCustomer, Long> {

}
