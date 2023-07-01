package com.learn.first.restapi.menus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "menus")
public class CMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // tự động sinh ra giá trị cho trường id
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "size")
    @NotNull(message = "Hãy nhập kích cỡ piza")
    private Long size;

    @Column(name = "diameter")
    @NotNull(message = "Hãy nhập đường kính pizza")
    @Positive(message = "Đường kính pizza lớn hơn 0")
    private Long diameter;

    @Column(name = "meat")
    @NotNull(message = "Hãy nhập số lượng thịt")
    @Range(min = 0, message = "Số lượng thịt lớn hơn hoặc bằng 0")
    private Long meat;

    @Column(name = "salad")
    @NotNull(message = "Hãy nhập gram salad")
    @Range(min = 0, message = "gram salad lớn hơn hoặc bằng 0")
    private Long salad;

    @Column(name = "drinkQuantity")
    @NotNull(message = "Hãy nhập số lượng nước")
    @Range(min = 0, message = "Số lượng nước lớn hơn hoặc bằng 0")
    private Long drinkQuantity;

    @Column(name = "price")
    @Positive(message = "Giá bán lớn hơn 0")
    @NotNull(message = "Hãy nhập price")
    private Long price;

    public CMenu() {
        super();
    }

    public Long getDiameter() {
        return diameter;
    }

    public Long getDrinkQuantity() {
        return drinkQuantity;
    }

    public Long getId() {
        return id;
    }

    public Long getMeat() {
        return meat;
    }

    public Long getPrice() {
        return price;
    }

    public Long getSalad() {
        return salad;
    }

    public Long getSize() {
        return size;
    }

    public void setDiameter(Long diameter) {
        this.diameter = diameter;
    }

    public void setDrinkQuantity(Long drinkQuantity) {
        this.drinkQuantity = drinkQuantity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMeat(Long meat) {
        this.meat = meat;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public void setSalad(Long salad) {
        this.salad = salad;
    }

    public void setSize(Long size) {
        this.size = size;
    }
}
