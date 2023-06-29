package com.learn.first.restapi.orders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.http.HttpStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import com.learn.first.restapi.customers.model.CCustomer;
import com.learn.first.restapi.customers.repository.ICustomerRepository;
import com.learn.first.restapi.orders.model.COrder;
import com.learn.first.restapi.orders.repository.IOrderRepository;

@CrossOrigin
@RestController
@RequestMapping("/")
public class COrderController {

    @Autowired
    IOrderRepository pIOrderRepository;
    @Autowired
    ICustomerRepository pICustomerRepository;

    // Get region by id
    @GetMapping("/regions/{regionId}")
    public COrder getOrderById(@PathVariable Long regionId) {
        // find region by regionId
        if (pIOrderRepository.findById(regionId).isPresent())
            return pIOrderRepository.findById(regionId).get();
        else
            return null;
    }

    // Get all Orders
    @GetMapping(value = "/regions")
    public ResponseEntity<List<COrder>> getAllOrder(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        // tạo ra một đối tượng Pageable để đại diện cho thông tin về phân trang.
        Pageable pageable = PageRequest.of(page, size);
        // truy vấn CSDL và trả về một trang của đối tượng COrder với thông tin trang
        Page<COrder> regionPage = pIOrderRepository.findAll(pageable);
        // để lấy danh sách các đối tượng
        List<COrder> regionList = regionPage.getContent();
        // Đếm tổng phần tử
        Long totalElement = regionPage.getTotalElements();
        // Trả về thành công
        return ResponseEntity.ok()
                .header("totalCount", String.valueOf(totalElement))
                .body(regionList);
    }

    // Create new region
    @PostMapping(value = "countries/{countryId}/regions")
    public ResponseEntity<Object> createOrder(@PathVariable("countryId") Long countryId,
            @RequestBody COrder pOrder) {
        try {
            // Find country by id
            Optional<CCustomer> countryData = pICustomerRepository.findById(countryId);
            // create new region
            if (countryData.isPresent()) {
                CCustomer country = countryData.get();
                COrder newOrder = new COrder();
                // get region info
                newOrder.setCustomer(country);
                newOrder.setOrderName(pOrder.getOrderName());
                newOrder.setOrderCode(pOrder.getOrderCode());
                COrder savedRole = pIOrderRepository.save(newOrder);
                // return success
                return new ResponseEntity<>(savedRole, HttpStatus.CREATED);
            }
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity()
                    .body("Failed to Create specified Voucher: " + e.getCause().getCause().getMessage());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    // Update region by id
    @PutMapping(value = "/regions/{regionId}")
    public ResponseEntity<Object> updateOrder(@PathVariable Long regionId, @RequestBody COrder pOrder) {
        // find region by regionId
        Optional<COrder> regionData = pIOrderRepository.findById(regionId);
        // update new region
        if (regionData.isPresent()) {
            COrder newOrder = regionData.get();
            newOrder.setOrderName(pOrder.getOrderName());
            newOrder.setOrderCode(pOrder.getOrderCode());
            COrder savedOrder = pIOrderRepository.save(newOrder);
            return new ResponseEntity<>(savedOrder, HttpStatus.OK);
        } else {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Delete region by Id
    @DeleteMapping("/regions/{regionId}")
    public ResponseEntity<Object> deleteOrderById(@PathVariable Long regionId) {
        try {
            pIOrderRepository.deleteById(regionId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete all region
    @DeleteMapping("/regions")
    public ResponseEntity<Object> deleteAllOrder() {
        try {
            pIOrderRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // get the count of record
    @GetMapping("/regions-count")
    public Long countOrder() {
        return pIOrderRepository.count();
    }

    // Check region in database
    @GetMapping("/regions/check/{regionId}")
    public boolean checkOrderById(@PathVariable Long regionId) {
        return pIOrderRepository.existsById(regionId);
    }

    // Return the region containing the specified code
    @GetMapping("/regions/containing-code/{code}")
    public ResponseEntity<List<COrder>> getOrderByContainingCode(@PathVariable String code) {
        List<COrder> regionList = new ArrayList<>();
        COrder region = pIOrderRepository.findByOrderCodeContaining(code);
        if (region != null) {
            regionList.add(region);
        }
        return new ResponseEntity<>(regionList, HttpStatus.OK);

    }
}