"use strict";
document.addEventListener("DOMContentLoaded", onPageLoading);

// refresh - on page loading
function onPageLoading() {
  loadAllProvince();
  loadAllDistrict();
}

// Load district by province code
function loadDistrictByProvinceCode() {
  var selectedProvince = document.getElementById("province").value;
  var districtSelect = document.getElementById("district");
  districtSelect.innerHTML = '<option value="">Chọn Quận/huyện</option>';
  fetch("/district?provinceCode=" + selectedProvince)
    .then((response) => response.json())
    .then((data) => {
      data.forEach((district) => {
        var option = document.createElement("option");
        option.value = district.id;
        option.innerHTML = district.prefix + " " + district.name;
        districtSelect.appendChild(option);
      });
    });
}

// Load ward by district id
function loadWardByDistrictId() {
  var selectedDistrict = document.getElementById("district").value;
  var wardSelect = document.getElementById("ward");
  wardSelect.innerHTML = '<option value="">Chọn xã/phường</option>';
  fetch("/ward?districtId=" + selectedDistrict)
    .then((response) => response.json())
    .then((data) => {
      data.forEach((ward) => {
        var option = document.createElement("option");
        option.value = ward.id;
        option.innerHTML = ward.prefix + " " + ward.name;
        wardSelect.appendChild(option);
      });
    });
}

//load all province
function loadAllProvince() {
  var provinceSelect = document.getElementById("province");
  var provinceForDistrictSelect = document.getElementById(
    "create-province-for-district"
  );
  fetch("/province/all")
    .then((response) => response.json())
    .then((data) => {
      data.forEach((province) => {
        var option1 = document.createElement("option");
        option1.value = province.code;
        option1.innerHTML = province.name;
        provinceSelect.appendChild(option1);

        var option2 = document.createElement("option");
        option2.value = province.code;
        option2.innerHTML = province.name;
        provinceForDistrictSelect.appendChild(option2);
      });
    });
}

//load all district
function loadAllDistrict() {
  var districtSelect = document.getElementById("create-district-for-ward");
  fetch("/district/all")
    .then((response) => response.json())
    .then((data) => {
      data.forEach((province) => {
        var option1 = document.createElement("option");
        option1.value = province.code;
        option1.innerHTML = province.name;
        districtSelect.appendChild(option1);
      });
    });
}
