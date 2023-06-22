package com.learn.first.restapi.posts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.first.restapi.posts.model.CPost;

public interface IPostRepository extends JpaRepository<CPost, Long> {

}
