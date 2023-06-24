package com.learn.first.restapi.payments.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.first.restapi.payments.model.CPayment;

public interface IPaymentRepository extends JpaRepository<CPayment, Long> {

}
