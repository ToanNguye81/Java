package com.learn.first.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.first.restapi.model.CPayment;

public interface IPaymentRepository extends JpaRepository<CPayment, Long> {

}
