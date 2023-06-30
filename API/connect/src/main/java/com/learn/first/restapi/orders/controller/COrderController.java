package com.learn.first.restapi.orders.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    // Get order by id
    @GetMapping("/orders/{orderId}")
    public COrder getOrderById(@PathVariable Long orderId) {
        // find order by orderId
        if (pIOrderRepository.findById(orderId).isPresent())
            return pIOrderRepository.findById(orderId).get();
        else
            return null;
    }

    // Get all Orders
    @GetMapping(value = "/orders")
    public ResponseEntity<List<COrder>> getAllOrder(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        // tạo ra một đối tượng Pageable để đại diện cho thông tin về phân trang.
        Pageable pageable = PageRequest.of(page, size);
        // truy vấn CSDL và trả về một trang của đối tượng COrder với thông tin trang
        Page<COrder> orderPage = pIOrderRepository.findAll(pageable);
        // để lấy danh sách các đối tượng
        List<COrder> orderList = orderPage.getContent();
        // Đếm tổng phần tử
        Long totalElement = orderPage.getTotalElements();
        // Trả về thành công
        return ResponseEntity.ok()
                .header("totalCount", String.valueOf(totalElement))
                .body(orderList);
    }

    // get all order of customer
    @GetMapping("customers/{customerId}/orders")
    public List<Object> getOrderByCustomerId(@PathVariable Long customerId) {
        return pIOrderRepository.getAllOrderByCustomerId(customerId);
    }

    // Create new order of customer
    @PostMapping(value = "customers/{customerId}/orders")
    public ResponseEntity<Object> createOrder(@PathVariable("customerId") Long customerId,
            @RequestBody COrder pOrder) {
        try {
            // Find customer by id
            Optional<CCustomer> customerData = pICustomerRepository.findById(customerId);
            // create new order
            if (customerData.isPresent()) {
                CCustomer customer = customerData.get();
                COrder newOrder = new COrder();
                // get order info
                newOrder.setCustomer(customer);
                newOrder.setOrderCode(pOrder.getOrderCode());
                newOrder.setPaid(pOrder.getPaid());
                newOrder.setPizzaSize(pOrder.getPizzaSize());
                newOrder.setPizzaType(pOrder.getPizzaType());
                newOrder.setPayment(pOrder.getPayment());
                newOrder.setPrice(pOrder.getPrice());
                newOrder.setProducts(pOrder.getProducts());
                newOrder.setVoucherCode(pOrder.getVoucherCode());
                COrder savedRole = pIOrderRepository.save(newOrder);
                // return success
                return new ResponseEntity<>(savedRole, HttpStatus.CREATED);
            }
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity()
                    .body("Failed to Create specified order: " + e.getCause().getCause().getMessage());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    // Update order by id
    @PutMapping(value = "/orders/{orderId}")
    public ResponseEntity<Object> updateOrder(@PathVariable Long orderId, @RequestBody COrder pOrder) {
        // find order by orderId
        Optional<COrder> orderData = pIOrderRepository.findById(orderId);
        // update new order
        if (orderData.isPresent()) {
            COrder newOrder = orderData.get();
            newOrder.setOrderCode(pOrder.getOrderCode());
            newOrder.setPaid(pOrder.getPaid());
            newOrder.setPizzaSize(pOrder.getPizzaSize());
            newOrder.setPizzaType(pOrder.getPizzaType());
            newOrder.setPayment(pOrder.getPayment());
            newOrder.setPrice(pOrder.getPrice());
            newOrder.setProducts(pOrder.getProducts());
            COrder savedOrder = pIOrderRepository.save(newOrder);
            return new ResponseEntity<>(savedOrder, HttpStatus.OK);
        } else {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Delete order by Id
    @DeleteMapping("/orders/{orderId}")
    public ResponseEntity<Object> deleteOrderById(@PathVariable Long orderId) {
        try {
            pIOrderRepository.deleteById(orderId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete all order
    @DeleteMapping("/orders")
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
    @GetMapping("/orders-count")
    public Long countOrder() {
        return pIOrderRepository.count();
    }

    // Check order in database
    @GetMapping("/orders/check/{orderId}")
    public boolean checkOrderById(@PathVariable Long orderId) {
        return pIOrderRepository.existsById(orderId);
    }

    // Return the order containing the specified code
    @GetMapping("/orders/containing-code/{code}")
    public ResponseEntity<List<COrder>> getOrderByContainingCode(@PathVariable String code) {
        List<COrder> orderList = new ArrayList<>();
        COrder order = pIOrderRepository.findByOrderCodeContaining(code);
        if (order != null) {
            orderList.add(order);
        }
        return new ResponseEntity<>(orderList, HttpStatus.OK);

    }
}