package com.learn.first.restapi.regions.controller;

import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.first.restapi.countries.model.CCountry;
import com.learn.first.restapi.countries.repository.ICountryRepository;
import com.learn.first.restapi.regions.model.CDistrict;
import com.learn.first.restapi.regions.model.CProvince;
import com.learn.first.restapi.regions.model.CRegion;
import com.learn.first.restapi.regions.model.CWard;
import com.learn.first.restapi.regions.repository.IDistrictRepository;
import com.learn.first.restapi.regions.repository.IProvinceRepository;
import com.learn.first.restapi.regions.repository.IRegionRepository;
import com.learn.first.restapi.regions.repository.IWardRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin
@RestController
@RequestMapping("/")
public class CRegionController {

    @Autowired
    IRegionRepository pIRegionRepository;
    @Autowired
    ICountryRepository pICountryRepository;
    @Autowired
    IProvinceRepository pIProvinceRepository;
    @Autowired
    IDistrictRepository pDistrictRepository;
    @Autowired
    IWardRepository pWardRepository;

    /*
     * ResponseEntity: Là một lớp trong Spring Framework được sử dụng để đóng gói
     * kết quả trả về từ một API endpoint. Cho phép thiết lập các thông tin
     * phản hồi như body, headers và mã trạng thái HTTP
     * Set được sử dụng thay vì List hoặc ArrayList vì yêu cầu
     * đặc biệt của một tập hợp các đối tượng duy nhất (không có phần tử trùng lặp).
     * Body được đóng gói là một tập hợp (Set) các đối tượng kiểu CRegion. Set đảm
     * bảo rằng không có phần tử trùng lặp trong tập hợp.
     */

    @GetMapping(value = "/regions")
    public ResponseEntity<Set<CRegion>> getRegionByCountryCode(
            @RequestParam(value = "countryCode", required = false) String countryCode) {
        try {
            if (countryCode != null) {
                // find Country base on countryCode
                CCountry vCountry = pICountryRepository.findByCountryCode(countryCode);
                // Return regions list
                return new ResponseEntity<>(vCountry.getRegions(), HttpStatus.OK);
            } else {
                {
                    // find all regions
                    Set<CRegion> allRegions = new HashSet<>();
                    List<CCountry> countries = pICountryRepository.findAll();

                    // create list
                    for (CCountry country : countries) {
                        allRegions.addAll(country.getRegions());
                    }
                    // Return regions list
                    return new ResponseEntity<>(allRegions, HttpStatus.OK);
                }
            }

        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/provinces")
    public ResponseEntity<List<CProvince>> getAllProvinces() {

        try {
            List<CProvince> pProvinces = new ArrayList<CProvince>();

            pIProvinceRepository.findAll().forEach(pProvinces::add);

            return new ResponseEntity<>(pProvinces, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/districts")
    public ResponseEntity<Set<CDistrict>> getDistrictByCode(
            @RequestParam(value = "provinceCode", required = false) String provinceCode) {
        try {
            if (provinceCode != null) {
                // find Province base on provinceCode
                CProvince vProvince = pIProvinceRepository.findByCode(provinceCode);
                // Return province list
                return new ResponseEntity<>(vProvince.getDistricts(), HttpStatus.OK);
            } else {
                {
                    // find all province
                    Set<CDistrict> allDistricts = new HashSet<>();
                    List<CProvince> provinces = pIProvinceRepository.findAll();

                    // create list
                    for (CProvince province : provinces) {
                        allDistricts.addAll(province.getDistricts());
                    }
                    // Return province list
                    return new ResponseEntity<>(allDistricts, HttpStatus.OK);
                }
            }

        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/wards")
    public ResponseEntity<Set<CWard>> getWardByName(
            @RequestParam(value = "districtName", required = false) String districtName) {
        try {
            if (districtName != null) {
                // find District base on districtName
                CDistrict vDistrict = pDistrictRepository.findByName(districtName);
                System.out.println("=======================================");
                System.out.println("vDistrict : " + vDistrict);
                // Return wards list
                return new ResponseEntity<>(vDistrict.getWards(), HttpStatus.OK);
            } else {
                {
                    // find all wards
                    Set<CWard> allWards = new HashSet<>();
                    List<CDistrict> districts = pDistrictRepository.findAll();

                    // create list
                    for (CDistrict district : districts) {
                        allWards.addAll(district.getWards());
                    }
                    // Return wards list
                    return new ResponseEntity<>(allWards, HttpStatus.OK);
                }
            }

        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
