package com.learn.first.restapi.vouchers.controller;

import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.first.restapi.vouchers.model.CVoucher;
import com.learn.first.restapi.vouchers.repository.IVoucherRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin
@RestController
@RequestMapping("/")
public class CVoucherController {
    @Autowired
    IVoucherRepository pIVoucherRepository;

    // @GetMapping("/vouchers")
    // public ResponseEntity<List<CVoucher>> getAllVouchers(
    // @RequestParam(value = "page", defaultValue = "0") int page,
    // @RequestParam(value = "size", defaultValue = "10") int size) {

    // try {
    // Pageable pageWithFiveElements = PageRequest.of(page, size);
    // List<CVoucher> pVouchers = new ArrayList<CVoucher>();
    // pIVoucherRepository.findAll(pageWithFiveElements).forEach(pVouchers::add);
    // return new ResponseEntity<>(pVouchers, HttpStatus.OK);
    // } catch (Exception e) {
    // // TODO: handle exception
    // return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    // }
    // }

    @GetMapping("/vouchers")
    public ResponseEntity<List<CVoucher>> getAllVouchers(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        try {
            // tạo ra một đối tượng Pageable để đại diện cho thông tin về phân trang.
            Pageable pageable = PageRequest.of(page, size);
            // truy vấn CSDL và trả về một trang của đối tượng CVoucher với thông tin trang
            Page<CVoucher> voucherPage = pIVoucherRepository.findAll(pageable);
            // để lấy danh sách các đối tượng
            List<CVoucher> vouchers = voucherPage.getContent();
            // Đếm tổng phần tử
            long totalElements = voucherPage.getTotalElements();
            // Trả về thành công
            return ResponseEntity.ok()
                    .header("totalCount", String.valueOf(totalElements))
                    .body(vouchers);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    // Get voucher by Id
    @GetMapping("/vouchers/{id}")
    public ResponseEntity<CVoucher> getCVoucherById(@PathVariable("id") long id) {
        Optional<CVoucher> voucherData = pIVoucherRepository.findById(id);
        if (voucherData.isPresent()) {
            return new ResponseEntity<>(voucherData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // // Create new Voucher
    // @PostMapping("/vouchers")
    // public ResponseEntity<CVoucher> createCVoucher(@RequestBody CVoucher
    // pVouchers) {
    // try {
    // CVoucher _vouchers = pIVoucherRepository.createVoucher(pVouchers);
    // // TODO: Hãy viết code tạo voucher đưa lên DB
    // return new ResponseEntity<>(_vouchers, HttpStatus.CREATED);
    // } catch (Exception e) {
    // System.out.println(e);
    // return new ResponseEntity<>(null,
    // HttpStatus.INTERNAL_SERVER_ERROR);
    // }
    // }

    // // Create new Voucher
    // @PostMapping("/vouchers")
    // public ResponseEntity<CVoucher> createCVoucher(@RequestBody CVoucher
    // pVoucher) {
    // try {
    // CVoucher createdVoucher = pIVoucherRepository.save(pVoucher);
    // // TODO: Viết code để tạo voucher và lưu vào cơ sở dữ liệu
    // return ResponseEntity.status(HttpStatus.CREATED).body(createdVoucher);
    // } catch (Exception e) {
    // System.out.println(e);
    // return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    // }
    // }

    // @PostMapping("/vouchers")
    // public ResponseEntity<CVoucher> createCVoucher(@RequestBody CVoucher
    // pVouchers) {
    // try {
    // // TODO: Hãy viết code tạo voucher đưa lên DB

    // return new ResponseEntity<>(_vouchers, HttpStatus.CREATED);
    // } catch (Exception e) {
    // System.out.println(e);
    // return new ResponseEntity<>(null,
    // HttpStatus.INTERNAL_SERVER_ERROR);
    // }
    // }

    @PostMapping("/vouchers")
    public ResponseEntity<CVoucher> createCVoucher(@RequestBody CVoucher pVoucher) {
        try {
            // TODO: Viết code để tạo voucher và lưu vào cơ sở dữ liệu
            CVoucher createdVoucher = pIVoucherRepository.save(pVoucher);

            return new ResponseEntity<>(createdVoucher, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @PutMapping("/vouchers/{id}")
    // public ResponseEntity<CVoucher> updateCVoucherById(@PathVariable("id")
    // long id, @RequestBody CVoucher pVouchers) {
    // //TODO: Hãy viết code lấy voucher từ DB để UPDATE
    // if (voucherData.isPresent()) {
    // return new
    // ResponseEntity<>(pVoucherRepository.save(pVouchers), HttpStatus.OK);
    // } else {
    // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    // }

    // Delete voucher by Id
    @DeleteMapping("/vouchers/{id}")
    public ResponseEntity<CVoucher> deleteCVoucherById(@PathVariable("id") long id) {
        try {
            // TODO: Delete voucher in DB
            pIVoucherRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null,
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
