package com.learn5.split.sprlit;

import java.util.ArrayList;

public class Country {
    private String countryCode;
    private String countryName;
    private ArrayList<Region> regions;

    public Country(String countryCode, String countryName) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.regions = new ArrayList<>();
    }

    public void setRegions(ArrayList<Region> regions) {
        this.regions = regions;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public ArrayList<Region> getRegions() {
        return regions;
    }

    public void addCountry(Region region) {
        regions.add(region);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Country[countryCode=" + countryCode + ",countryName=" + countryName + "]";
    }
}
