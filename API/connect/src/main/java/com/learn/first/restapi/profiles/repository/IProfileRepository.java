package com.learn.first.restapi.profiles.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.first.restapi.profiles.model.CProfile;

public interface IProfileRepository extends JpaRepository<CProfile, Long> {

}
