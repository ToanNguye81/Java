package com.learn.first.restapi.menus.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.first.restapi.menus.model.CMenu;
import com.learn.first.restapi.menus.repository.IMenuRepository;

@CrossOrigin
@RestController
@RequestMapping("/")
public class CMenuController {

    @Autowired
    IMenuRepository pIMenuRepository;

    // Get menu by id
    @GetMapping("/menus/{menuId}")
    public CMenu getMenuById(@PathVariable Long menuId) {
        // find menu by menuId
        if (pIMenuRepository.findById(menuId).isPresent())
            return pIMenuRepository.findById(menuId).get();
        else
            return null;
    }

    // Get all Menus
    @GetMapping("/menus")
    public ResponseEntity<List<CMenu>> getAllMenu(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        // tạo ra một đối tượng Pageable để đại diện cho thông tin về phân trang.
        Pageable pageable = PageRequest.of(page, size);
        // truy vấn CSDL và trả về một trang của đối tượng CMenu với thông tin trang
        Page<CMenu> menuPage = pIMenuRepository.findAll(pageable);
        // để lấy danh sách các đối tượng
        List<CMenu> menuList = menuPage.getContent();
        // Đếm tổng phần tử
        Long totalElement = menuPage.getTotalElements();
        // Trả về thành công
        return ResponseEntity.ok()
                .header("totalCount", String.valueOf(totalElement))
                .body(menuList);
    }

    // Create new menu
    @PostMapping("/menus")
    public ResponseEntity<Object> createNewMenu(@RequestBody CMenu pMenu) {
        try {
            CMenu newMenu = new CMenu();
            // get menu info
            newMenu.setDiameter(pMenu.getDiameter());
            newMenu.setDrinkQuantity(pMenu.getDrinkQuantity());
            newMenu.setMeat(pMenu.getMeat());
            newMenu.setPrice(pMenu.getPrice());
            newMenu.setSalad(pMenu.getSalad());
            newMenu.setSize(pMenu.getSize());
            CMenu savedMenu = pIMenuRepository.save(newMenu);
            // return success
            return new ResponseEntity<>(savedMenu, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getCause().getCause().getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete all menu
    @DeleteMapping("/menus")
    public ResponseEntity<Object> deleteAllMenu() {
        try {
            pIMenuRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete all menu by id
    @DeleteMapping("/menus/{menuId}")
    public ResponseEntity<Object> deleteMenuById(@PathVariable Long menuId) {
        try {
            pIMenuRepository.deleteById(menuId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            System.out.println(e.getCause().getCause().getMessage());
            return new ResponseEntity<>(e.getCause().getCause().getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // get the count of record
    @GetMapping("/menus-count")
    public Long countMenu() {
        return pIMenuRepository.count();
    }

    // Check menu in database
    @GetMapping("/menus/check/{menuId}")
    public boolean checkMenuById(@PathVariable Long menuId) {
        return pIMenuRepository.existsById(menuId);
    }
}