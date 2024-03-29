package com.learn.first.restapi.controller;

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

import com.learn.first.restapi.model.CProvince;
import com.learn.first.restapi.repository.IProvinceRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin
@RestController
@RequestMapping("/")
public class CProvinceController {

    @Autowired
    IProvinceRepository pIProvinceRepository;

    // get all province
    @GetMapping(value = "/province/all")
    public ResponseEntity<List<CProvince>> getAllProvince(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        // tạo ra một đối tượng Pageable để đại diện cho thông tin về phân trang.
        Pageable pageable = PageRequest.of(page, size);
        // truy vấn CSDL và trả về một trang của đối tượng CProvince với thông tin trang
        Page<CProvince> provincePage = pIProvinceRepository.findAll(pageable);
        // để lấy danh sách các đối tượng
        List<CProvince> provinceList = provincePage.getContent();
        // Đếm tổng phần tử
        Long totalElement = provincePage.getTotalElements();
        // Trả về thành công
        return ResponseEntity.ok()
                .header("totalCount", String.valueOf(totalElement))
                .body(provinceList);
    }

    // get province by id
    @GetMapping(value = "/province/details/{id}")
    public CProvince getProvinceById(@PathVariable Integer id) {
        if (pIProvinceRepository.findById(id).isPresent()) {
            return pIProvinceRepository.findById(id).get();
        } else {
            return null;
        }
    }

    // create new province
    @PostMapping(value = "/province/create")
    public ResponseEntity<Object> createProvince(@RequestBody CProvince pProvince) {
        try {
            // create new province
            CProvince newProvince = new CProvince();
            newProvince.setName(pProvince.getName());
            newProvince.setCode(pProvince.getCode());
            CProvince savedProvince = pIProvinceRepository.save(newProvince);
            System.out.println(savedProvince);
            return new ResponseEntity<>(savedProvince, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    // Update province by id
    @PutMapping(value = "/province/update/{id}")
    public ResponseEntity<Object> updateProvince(@PathVariable Integer id, @RequestBody CProvince pProvince) {
        // find province by id
        Optional<CProvince> provinceData = pIProvinceRepository.findById(id);
        if (provinceData.isPresent()) {
            // get province
            CProvince newProvince = provinceData.get();
            // update province
            newProvince.setName(pProvince.getName());
            newProvince.setCode(pProvince.getCode());
            CProvince savedProvince = pIProvinceRepository.save(newProvince);
            return new ResponseEntity<>(savedProvince, HttpStatus.OK);
        } else {
            // TODO: handle exception
            System.out.println("not find province by id");
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Delete province by Id
    @DeleteMapping("/province/delete/{id}")
    public ResponseEntity<Object> deleteProvinceById(@PathVariable Integer id) {
        try {
            pIProvinceRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null,
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}