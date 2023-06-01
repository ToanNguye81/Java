package com.learn.first.restapi.vouchers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.first.restapi.vouchers.model.CVoucher;

public interface IVoucherRepository extends JpaRepository<CVoucher, Long> {

    // Các phương thức tùy chỉnh

}
