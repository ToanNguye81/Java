package com.learn.first.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.first.restapi.model.CProduct;

public interface IProductRepository extends JpaRepository<CProduct, Long> {

}
