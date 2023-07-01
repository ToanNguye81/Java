package com.learn.first.restapi.vouchers.controller;

import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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

    // GET METHOD====================
    // Get all vouchers
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
    public ResponseEntity<CVoucher> getVoucherById(@PathVariable("id") long id) {
        Optional<CVoucher> voucherData = pIVoucherRepository.findById(id);
        if (voucherData.isPresent()) {
            return new ResponseEntity<>(voucherData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // POST METHOD ====================
    // Create new Voucher
    @PostMapping("/vouchers")
    public ResponseEntity<Object> createVoucher(@Valid @RequestBody CVoucher pVouchers) {
        try {
            // Set the creation date and nullify the update date
            pVouchers.setDayCreated(new Date());
            pVouchers.setDayUpdated(null);
            System.out.println("+++++++++++++++++++++++++++++++");
            System.out.println(pVouchers);
            System.out.println("+++++++++++++++++++++++++++++++");
            // Save the voucher to the database
            CVoucher voucher = pIVoucherRepository.save(pVouchers);

            // Return the created voucher in the response with HTTP status 201 (Created)
            return new ResponseEntity<>(voucher, HttpStatus.CREATED);

        } catch (Exception e) {
            System.out.println("==================================");
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // PUT METHOD ==================
    @PutMapping("vouchers/{id}")
    public ResponseEntity<CVoucher> updateVoucherById(@PathVariable("id") long id, @RequestBody CVoucher pVoucher) {
        try {
            // Get the voucher from the database by its ID
            Optional<CVoucher> optionalVoucher = pIVoucherRepository.findById(id);
            if (optionalVoucher.isPresent()) {
                CVoucher voucher = optionalVoucher.get();

                // Update the voucher properties with the provided pVoucher data
                voucher.setMaVoucher(pVoucher.getMaVoucher());
                voucher.setPhanTramGiamGia(pVoucher.getPhanTramGiamGia());
                voucher.setGhiChu(pVoucher.getGhiChu());
                voucher.setDayUpdated(new Date());
                // Save the updated voucher back to the database
                pIVoucherRepository.save(voucher);

                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // DELETE METHOD ===============
    // Delete voucher by Id
    @DeleteMapping("/vouchers/{id}")
    public ResponseEntity<CVoucher> deleteCVoucherById(@PathVariable("id") long id) {
        try {
            // TODO: Delete voucher in DB by Id
            pIVoucherRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null,
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete all vouchers
    @DeleteMapping("/vouchers")
    public ResponseEntity<CVoucher> deleteAllVoucher() {
        try {
            // TODO: Delete all voucher in DB
            pIVoucherRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null,
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
