package com.learn.first.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.first.restapi.model.CPost;

public interface IPostRepository extends JpaRepository<CPost, Long> {

}
