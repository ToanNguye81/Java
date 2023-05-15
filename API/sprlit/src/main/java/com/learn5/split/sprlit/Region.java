package com.learn5.split.sprlit;

public class Region {
    String regionCode;
    String regionName;

    public Region(String regionName, String regionCode) {
        this.regionName = regionName;
        this.regionCode = regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public String getRegionName() {
        return regionName;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Region[regionCode=" + regionCode + ",regionName=" + regionName + "]";
    }
}
