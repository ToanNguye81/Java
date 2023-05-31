package com.learn.first.restapi.vouchers.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.first.restapi.vouchers.model.CVoucher;

public interface IVoucherRepository extends JpaRepository<CVoucher, Long> {

    // Các phương thức tùy chỉnh
    Optional<CVoucher> findById(long id);

    CVoucher deleteById(long id);

    CVoucher save(CVoucher voucher);

}
