"use strict";
document.addEventListener("DOMContentLoaded", onPageLoading);

function loadDistricts() {
  var selectedProvince = document.getElementById("province").value;

  var districtSelect = document.getElementById("district");
  districtSelect.innerHTML = '<option value="">Chọn Quận/huyện</option>';
  fetch("http://127.0.0.1:8080/districts?provinceCode=" + selectedProvince)
    .then((response) => response.json())
    .then((data) => {
      data.forEach((district) => {
        var option = document.createElement("option");
        option.value = district.id;
        option.innerHTML = district.name;
        districtSelect.appendChild(option);
      });
    });
}

function loadWards() {
  var selectedDistrict = document.getElementById("district").value;
  var wardSelect = document.getElementById("ward");
  wardSelect.innerHTML = '<option value="">Chọn xã/phường</option>';
  fetch("http://127.0.0.1:8080/wards?districtId=" + selectedDistrict)
    .then((response) => response.json())
    .then((data) => {
      data.forEach((ward) => {
        var option = document.createElement("option");
        option.value = ward.id;
        option.innerHTML = ward.name;
        wardSelect.appendChild(option);
      });
    });
}

function onPageLoading() {
  var provinceSelect = document.getElementById("province");
  fetch("http://127.0.0.1:8080/provinces")
    .then((response) => response.json())
    .then((data) => {
      data.forEach((province) => {
        var option = document.createElement("option");
        option.value = province.code;
        option.innerHTML = province.name;
        provinceSelect.appendChild(option);
      });
    });
}
