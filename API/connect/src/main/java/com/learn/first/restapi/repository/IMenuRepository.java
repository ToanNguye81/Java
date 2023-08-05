package com.learn.first.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.first.restapi.model.CMenu;

public interface IMenuRepository extends JpaRepository<CMenu, Long> {
}