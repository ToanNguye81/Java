package com.learn.first.restapi.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.first.restapi.users.model.CUser;

public interface IUserRepository extends JpaRepository<CUser, Long> {

}
