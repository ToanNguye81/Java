package com.learn.first.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.first.restapi.model.CDrink;

public interface IDrinkRepository extends JpaRepository<CDrink, Long> {

}
