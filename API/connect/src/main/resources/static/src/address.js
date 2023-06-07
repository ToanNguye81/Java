"use strict";
document.addEventListener("DOMContentLoaded", onPageLoading);

// Sự kiện click nút "All province"
$("#btn-all-province").click(function () {
  console.log("click all province");
  loadProvinceToTable();
});
$("#btn-all-district").click(function () {
  console.log("click all district");
  loadDistrictToTable();
});
$("#btn-all-ward").click(function () {
  loadWardToTable();
});

//Load all province to Table
function loadProvinceToTable() {
  console.log("click all province");
  $.ajax({
    url: "/province/all",
    method: "GET",
    success: function (response) {
      displayDataToTable(response, ["id", "name", "code"]);
    },
    error: function (error) {
      console.log(error);
    },
  });
}

//Load all district to Table
function loadDistrictToTable() {
  $.ajax({
    url: "/district/all",
    method: "GET",
    success: function (response) {
      displayDataToTable(response, ["id", "name", "prefix"]);
    },
    error: function (error) {
      console.log(error);
    },
  });
}

//Load all ward to Table
function loadWardToTable() {
  $.ajax({
    url: "/ward/all",
    method: "GET",
    success: function (response) {
      displayDataToTable(response, ["id", "name", "prefix"]);
    },
    error: function (error) {
      console.log(error);
    },
  });
}

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

// Hàm hiển thị dữ liệu lên bảng
function displayDataToTable(data, columns) {
  var tableBody = $("#data-table tbody");
  tableBody.empty();
  var tableBody = $("#data-table thead");
  tableBody.empty();

  var headerRow = $("<tr>");

  $.each(columns, function (_, column) {
    $("<td>").text(column).appendTo(headerRow);
  });
  $("<td>").text("Action").appendTo(headerRow);

  headerRow.appendTo(tableBody);

  $.each(data, function (index, item) {
    var row = $("<tr>");

    $.each(columns, function (_, column) {
      $("<td>").text(item[column]).appendTo(row);
    });

    var actionCell = $("<td>");
    $("<button>")
      .addClass("delete-button")
      .attr("data-id", item.id)
      .text("Delete")
      .appendTo(actionCell);

    $("<button>")
      .addClass("update-button")
      .attr("data-id", item.id)
      .text("Update")
      .appendTo(actionCell);

    actionCell.appendTo(row);
    row.appendTo(tableBody);
  });
}
