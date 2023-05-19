package com.learn.first.restapi.drinks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.first.restapi.drinks.model.CDrink;

public interface IDrinkRepository extends JpaRepository<CDrink, Long> {

}
