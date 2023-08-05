package com.learn.first.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.first.restapi.model.CCustomer;

public interface ICustomerRepository extends JpaRepository<CCustomer, Long> {

}
