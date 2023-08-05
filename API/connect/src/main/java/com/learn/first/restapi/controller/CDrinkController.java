package com.learn.first.restapi.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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

import com.learn.first.restapi.model.CDrink;
import com.learn.first.restapi.repository.IDrinkRepository;

@CrossOrigin
@RestController
@RequestMapping("/")
public class CDrinkController {
    @Autowired
    IDrinkRepository pIDrinkRepository;

    // GET METHOD====================
    // Get all drinks
    @GetMapping("/drinks")
    public ResponseEntity<List<CDrink>> getAllDrinkCDrinks(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        try {
            // tạo ra một đối tượng Pageable để đại diện cho thông tin về phân trang.
            Pageable pageable = PageRequest.of(page, size);
            // truy vấn CSDL và trả về một trang của đối tượng CDrink với thông tin trang
            Page<CDrink> drinkPage = pIDrinkRepository.findAll(pageable);
            // để lấy danh sách các đối tượng
            List<CDrink> drinks = drinkPage.getContent();
            // Đếm tổng phần tử
            long totalElements = drinkPage.getTotalElements();
            // Trả về thành công
            return ResponseEntity.ok()
                    .header("totalCount", String.valueOf(totalElements))
                    .body(drinks);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    // Get drink by Id
    @GetMapping("/drinks/{id}")
    public ResponseEntity<CDrink> getDrinkCDrinkById(@PathVariable("id") long id) {
        Optional<CDrink> drinkData = pIDrinkRepository.findById(id);
        if (drinkData.isPresent()) {
            return new ResponseEntity<>(drinkData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // POST METHOD ====================
    // Create new Drink
    @PostMapping("/drinks")
    public ResponseEntity<Object> createDrink(@Valid @RequestBody CDrink pDrink) {
        try {
            CDrink newDrink = new CDrink();
            // Set the creation date and nullify the update date
            newDrink.setNote(pDrink.getNote());
            newDrink.setDrinkCode(pDrink.getDrinkCode());
            newDrink.setDayCreated(new Date());
            newDrink.setPrice(pDrink.getPrice());
            newDrink.setDrinkName(pDrink.getDrinkName());
            // Save the drink to the database
            CDrink drink = pIDrinkRepository.save(newDrink);
            // Return the created drink in the response with HTTP status 201 (Created)
            return new ResponseEntity<>(drink, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getCause().getCause().getMessage());
            return new ResponseEntity<>(e.getCause().getCause().getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // PUT METHOD ==================
    @PutMapping("drinks/{id}")
    public ResponseEntity<Object> updateDrinkById(@PathVariable("id") long id, @RequestBody CDrink pDrink) {
        try {
            // Get the drink from the database by its ID
            Optional<CDrink> optionalDrink = pIDrinkRepository.findById(id);
            if (optionalDrink.isPresent()) {
                CDrink drink = optionalDrink.get();

                // Update the drink properties with the provided pDrink data
                drink.setNote(pDrink.getNote());
                drink.setDrinkCode(pDrink.getDrinkCode());
                drink.setPrice(pDrink.getPrice());
                drink.setDrinkName(pDrink.getDrinkName());
                drink.setDayUpdated(new Date());
                // Save the updated drink back to the database
                pIDrinkRepository.save(drink);

                return new ResponseEntity<>(drink, HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(e.getCause().getCause().getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // DELETE METHOD ===============
    // Delete drink by Id
    @DeleteMapping("/drinks/{id}")
    public ResponseEntity<CDrink> deleteCDrinkById(@PathVariable("id") long id) {
        try {
            // TODO: Delete drink in DB by Id
            pIDrinkRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null,
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete all drinks
    @DeleteMapping("/drinks")
    public ResponseEntity<CDrink> deleteAllDrink() {
        try {
            // TODO: Delete all drink in DB
            pIDrinkRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null,
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
