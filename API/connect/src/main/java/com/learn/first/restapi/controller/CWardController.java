package com.learn.first.restapi.controller;

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

import com.learn.first.restapi.model.CDistrict;
import com.learn.first.restapi.model.CWard;
import com.learn.first.restapi.repository.IDistrictRepository;
import com.learn.first.restapi.repository.IWardRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@CrossOrigin
@RestController
@RequestMapping("/")
public class CWardController {

    @Autowired
    IDistrictRepository pIDistrictRepository;
    @Autowired
    IWardRepository pIWardRepository;

    // get all ward
    @GetMapping(value = "/ward/all")
    public ResponseEntity<List<CWard>> getAllWard(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        // tạo ra một đối tượng Pageable để đại diện cho thông tin về phân trang.
        Pageable pageable = PageRequest.of(page, size);
        // truy vấn CSDL và trả về một trang của đối tượng CWard với thông tin trang
        Page<CWard> wardPage = pIWardRepository.findAll(pageable);
        // để lấy danh sách các đối tượng
        List<CWard> wardList = wardPage.getContent();
        // Đếm tổng phần tử
        Long totalElement = wardPage.getTotalElements();
        // Trả về thành công
        return ResponseEntity.ok()
                .header("totalCount", String.valueOf(totalElement))
                .body(wardList);
    }

    // get ward by id
    @GetMapping(value = "/ward/details/{id}")
    public CWard getWardById(@PathVariable Integer id) {
        if (pIWardRepository.findById(id).isPresent()) {
            return pIWardRepository.findById(id).get();
        } else {
            return null;
        }
    }

    // get ward by district id
    @GetMapping(value = "/ward")
    public Set<CWard> getDistrictByDistrictId(
            @RequestParam(value = "districtId", required = false) Integer districtId) {
        Optional<CDistrict> districtData = pIDistrictRepository.findById(districtId);
        if (districtData.isPresent()) {
            CDistrict district = districtData.get();
            return district.getWards();
        } else {
            return null;
        }
    }

    // Create new ward
    @PostMapping(value = "/ward/create/{districtId}")
    public ResponseEntity<Object> createWard(@PathVariable("districtId") Integer districtId,
            @RequestBody CWard pWard) {
        try {
            // Find district by id
            Optional<CDistrict> districtData = pIDistrictRepository.findById(districtId);
            // create new ward if found out district
            if (districtData.isPresent()) {
                // get district data
                CDistrict district = districtData.get();
                // create new ward
                CWard newDistrict = new CWard();
                newDistrict.setDistrict(district);
                newDistrict.setName(pWard.getName());
                newDistrict.setPrefix(pWard.getPrefix());
                CWard savedRole = pIWardRepository.save(newDistrict);
                // return FE
                return new ResponseEntity<>(savedRole, HttpStatus.CREATED);
            }
        } catch (Exception e) {
            // error
            return ResponseEntity.unprocessableEntity()
                    .body("Failed to Create specified Ward: " + e.getCause().getCause().getMessage());
        }
        // if not find district id
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    // Update ward by id
    @PutMapping(value = "/ward/update/{id}")
    public ResponseEntity<Object> updateWardById(@PathVariable Integer id,
            @RequestBody CWard pWard) {
        // find ward by id
        Optional<CWard> wardData = pIWardRepository.findById(id);
        if (wardData.isPresent()) {
            // update ward
            CWard newWard = wardData.get();
            newWard.setName(pWard.getName());
            newWard.setPrefix(pWard.getPrefix());
            newWard.setPrefix(pWard.getPrefix());
            CWard savedWard = pIWardRepository.save(newWard);
            // return
            return new ResponseEntity<>(savedWard, HttpStatus.OK);
        } else {
            // if not found ward by id
            return new ResponseEntity<Object>(null, HttpStatus.NOT_FOUND);
        }
    }

    // delete ward by id
    @DeleteMapping(value = "/ward/delete/{id}")
    public ResponseEntity<Object> deleteWardById(@PathVariable Integer id) {
        try {
            pIWardRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
