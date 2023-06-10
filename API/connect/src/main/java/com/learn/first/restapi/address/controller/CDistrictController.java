package com.learn.first.restapi.address.controller;

import org.springframework.http.HttpStatus;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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

import com.learn.first.restapi.address.model.CDistrict;
import com.learn.first.restapi.address.model.CProvince;
import com.learn.first.restapi.address.repository.IDistrictRepository;
import com.learn.first.restapi.address.repository.IProvinceRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@CrossOrigin
@RestController
@RequestMapping("/")
public class CDistrictController {

    @Autowired
    IDistrictRepository pIDistrictRepository;
    @Autowired
    IProvinceRepository pIProvinceRepository;

    // get all district
    @GetMapping(value = "/district/all")
    public ResponseEntity<List<CDistrict>> getAllDistrict(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        // tạo ra một đối tượng Pageable để đại diện cho thông tin về phân trang.
        Pageable pageable = PageRequest.of(page, size);
        // truy vấn CSDL và trả về một trang của đối tượng CDistrict với thông tin trang
        Page<CDistrict> districtPage = pIDistrictRepository.findAll(pageable);
        // để lấy danh sách các đối tượng
        List<CDistrict> districtList = districtPage.getContent();
        // Đếm tổng phần tử
        Long totalElement = districtPage.getTotalElements();
        // Trả về thành công
        return ResponseEntity.ok()
                .header("totalCount", String.valueOf(totalElement))
                .body(districtList);
    }

    // get district by id
    @GetMapping(value = "/district/details/{id}")
    public CDistrict getDistrictById(@PathVariable Integer id) {
        if (pIDistrictRepository.findById(id).isPresent()) {
            return pIDistrictRepository.findById(id).get();
        } else {
            return null;
        }
    }

    // get district by province code
    @GetMapping(value = "/district")
    public Set<CDistrict> getDistrictByProvinceCode(
            @RequestParam(value = "provinceCode", required = false) String provinceCode) {
        Optional<CProvince> provinceData = pIProvinceRepository.findByCode(provinceCode);
        if (provinceData.isPresent()) {
            CProvince province = provinceData.get();
            return province.getDistricts();
        } else {
            return null;
        }
    }

    // create new district
    @PostMapping(value = "/district/create/{provinceId}")
    public ResponseEntity<Object> createDistrict(@PathVariable Integer provinceId,
            @RequestBody CDistrict pDistrict) {
        try {
            // find province by id
            Optional<CProvince> provinceData = pIProvinceRepository.findById(provinceId);
            // if existed province
            if (provinceData.isPresent()) {
                CProvince province = provinceData.get();
                CDistrict newDistrict = new CDistrict();
                newDistrict.setProvince(province);
                newDistrict.setName(pDistrict.getName());
                newDistrict.setPrefix(pDistrict.getPrefix());
                CDistrict savedDistrict = pIDistrictRepository.save(newDistrict);
                return new ResponseEntity<>(savedDistrict, HttpStatus.CREATED);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.unprocessableEntity()
                    .body("Failed to Create specified Ward: " + e.getCause().getCause().getMessage());
        }
        // not found province
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // update district
    @PutMapping(value = "/district/update/{id}")
    public ResponseEntity<Object> updateDistrictById(@PathVariable Integer id, @RequestBody CDistrict pDistrict) {
        // find district by id
        Optional<CDistrict> districtData = pIDistrictRepository.findById(id);
        if (districtData.isPresent()) {
            // if existed district
            CDistrict newDistrict = districtData.get();
            newDistrict.setName(pDistrict.getName());
            newDistrict.setPrefix(pDistrict.getPrefix());
            newDistrict.setProvince(pDistrict.getProvince());
            CDistrict savedDistrict = pIDistrictRepository.save(newDistrict);
            return new ResponseEntity<>(savedDistrict, HttpStatus.OK);
        } else {
            // if not found district by id
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // delete District by id
    @DeleteMapping("/district/delete/{id}")
    public ResponseEntity<Object> deleteDistrictById(@PathVariable Integer id) {
        try {
            pIDistrictRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null,
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
