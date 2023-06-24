package com.learn.first.restapi.hashTags.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.first.restapi.hashTags.model.CHashTag;

public interface IHashTagRepository extends JpaRepository<CHashTag, Long> {

}
