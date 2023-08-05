package com.learn.first.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.first.restapi.model.CVoucher;

public interface IVoucherRepository extends JpaRepository<CVoucher, Long> {

    // Các phương thức tùy chỉnh

}
