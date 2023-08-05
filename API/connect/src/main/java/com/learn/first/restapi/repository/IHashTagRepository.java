package com.learn.first.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.first.restapi.model.CHashTag;

public interface IHashTagRepository extends JpaRepository<CHashTag, Long> {

}
