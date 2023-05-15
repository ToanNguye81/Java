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
}
