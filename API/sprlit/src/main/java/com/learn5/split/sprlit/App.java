package com.learn5.split.sprlit;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class App {

    @CrossOrigin
    @GetMapping("/country")
    public ArrayList<Country> regions() {
        String[] countryCode = { "VN", "US", "CA", "TL", "AU" };
        String[] countryName = { "Việt Nam", "America", "Campuchia", "Thái Lan", "Australia" };
        ArrayList<Country> countries = new ArrayList<>();

        for (int index = 0; index < countryCode.length; index++) {
            String name = countryName[index];
            String code = countryCode[index];
            Country country = new Country(code, name);
            countries.add(country);
        }

        String[] regionCode = { "GL", "HP", "LC" };
        String[] regionName = { "Gia Lai", "Hải Phòng", "Lào Cai" };

        ArrayList<Region> regions = new ArrayList<>();

        for (int index = 0; index < regionCode.length; index++) {
            String name = regionName[index];
            String code = regionCode[index];
            Region region = new Region(code, name);
            regions.add(region);
        }

        countries.get(0).setRegions(regions);
        countries.get(0).addCountry(new Region("Hồ Chí Minh", "HCM"));
        return countries;
    }

    @GetMapping("/customer-invoice")
    public ArrayList<Invoice> customerInvoice() {
        Customer customer1 = new Customer(1, "Tuấn", 12);
        Customer customer2 = new Customer(2, "Hải", 20);
        Customer customer3 = new Customer(3, "Tiển", 15);

        Invoice invoice1 = new Invoice(12, customer1, 120000);
        Invoice invoice2 = new Invoice(13, customer2, 150000);
        Invoice invoice3 = new Invoice(12, customer3, 170000);
        Invoice invoice4 = new Invoice(12, new Customer(1, "special", 12), 199000);

        ArrayList<Invoice> invoiceList = new ArrayList<>();
        invoiceList.add(invoice1);
        invoiceList.add(invoice2);
        invoiceList.add(invoice3);
        invoiceList.add(invoice4);

        return invoiceList;
    }

}
