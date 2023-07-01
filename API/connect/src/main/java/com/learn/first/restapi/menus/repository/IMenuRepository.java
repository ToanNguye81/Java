package com.learn.first.restapi.menus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.first.restapi.menus.model.CMenu;

public interface IMenuRepository extends JpaRepository<CMenu, Long> {
}