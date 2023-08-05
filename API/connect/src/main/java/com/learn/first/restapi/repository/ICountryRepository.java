package com.learn.first.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.first.restapi.model.CCountry;

public interface ICountryRepository extends JpaRepository<CCountry, Long> {
    CCountry findByCountryCode(String country);

    CCountry findByCountryCodeContaining(String code);
}
/*
 * Spring Data JPA là một phần của Spring Framework và cung cấp các tính năng và
 * tiện ích để làm việc với dữ liệu trong các ứng dụng Java/JVM. JPA (Java
 * Persistence API) là một chuẩn Java để tương tác với cơ sở dữ liệu quan hệ.
 */

/*
 * 1. Tự động triển khai các phương thức truy vấn dữ liệu dựa trên quy tắc đặt
 * tên và kiểu dữ liệu.
 * 2. Hỗ trợ các truy vấn linh hoạt và phức tạp thông qua việc sử dụng các
 * Annotation như @Query.
 * 3. Quản lý đối tượng và quan hệ giữa chúng thông qua cơ chế ORM
 * (Object-Relational Mapping).
 * 4. Hỗ trợ các tính năng như phân trang, sắp xếp, và gộp dữ liệu một cách dễ
 * dàng.
 * 5. Tích hợp tốt với các công nghệ khác trong Spring Framework như Spring MVC,
 * Spring Boot, và Spring Security.
 */