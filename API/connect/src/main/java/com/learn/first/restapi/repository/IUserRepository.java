package com.learn.first.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.first.restapi.model.CUser;

public interface IUserRepository extends JpaRepository<CUser, Long> {

}
