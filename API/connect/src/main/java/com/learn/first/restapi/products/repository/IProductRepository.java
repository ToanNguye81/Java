package com.learn.first.restapi.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.first.restapi.products.model.CProduct;

public interface IProductRepository extends JpaRepository<CProduct, Long> {

}
