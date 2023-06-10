"use strict";
document.addEventListener("DOMContentLoaded", onPageLoading);

// Sự kiện click nút "All province"
$("#btn-all-province").click(function () {
  loadProvinceToTable();
});
$("#btn-all-district").click(function () {
  loadDistrictToTable();
});
$("#btn-all-ward").click(function () {
  loadWardToTable();
});
$("#btn-add-province").click(function () {
  createNewProvince();
});
$("#btn-add-district").click(function () {
  createNewDistrict();
});
$("#btn-add-ward").click(function () {
  createNewWard();
});
$("tbody").on("click", ".far.fa-edit.mr-2.province", function () {
  $("#modal-update-province").modal("show"); // Hiển thị modal
  // updateProvince(this);
});
$("tbody").on("click", ".far.fa-edit.mr-2.district", function () {
  $("#modal-update-district").modal("show"); // Hiển thị modal
  // updateDistrict(this);
});
$("tbody").on("click", ".far.fa-edit.mr-2.ward", function () {
  $("#modal-update-ward").modal("show"); // Hiển thị modal
  // updateWard(this);
});
$("tbody").on("click", ".far.fa-trash-alt.ml-2.province", function () {
  // deleteProvince(this);
  $("#modal-delete-province").modal("show"); // Hiển thị modal
});
$("tbody").on("click", ".far.fa-trash-alt.ml-2.district", function () {
  // deleteDistrict(this);
  $("#modal-delete-district").modal("show"); // Hiển thị modal
});
$("tbody").on("click", ".far.fa-trash-alt.ml-2.ward", function () {
  // deleteWard(this);
  $("#modal-delete-ward").modal("show"); // Hiển thị modal
});

//Load all province to Table
function loadProvinceToTable() {
  console.log("click all province");
  $.ajax({
    url: "/province/all",
    method: "GET",
    success: function (response) {
      displayDataToTable(response, ["id", "name", "code"], "province");
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
      displayDataToTable(response, ["id", "name", "prefix"], "district");
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
      displayDataToTable(response, ["id", "name", "prefix"], "ward");
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
    "sel-province-for-district"
  );
  fetch("/province/all")
    .then((response) => response.json())
    .then((data) => {
      data.forEach((province) => {
        var option1 = document.createElement("option");
        option1.value = province.code;
        option1.dataset.provinceId = province.id;
        option1.innerHTML = province.name;
        provinceSelect.appendChild(option1);

        var option2 = document.createElement("option");
        option2.value = province.code;
        option2.dataset.provinceId = province.id;
        option2.innerHTML = province.name;
        provinceForDistrictSelect.appendChild(option2);
      });
    });
}

//load all district
function loadAllDistrict() {
  var districtSelect = document.getElementById("sel-district-for-ward");
  fetch("/district/all")
    .then((response) => response.json())
    .then((data) => {
      data.forEach((province) => {
        var option1 = document.createElement("option");
        option1.value = province.code;
        option1.dataset.districtId = province.id;
        option1.innerHTML = province.name;
        districtSelect.appendChild(option1);
      });
    });
}

// Hàm hiển thị dữ liệu lên bảng
function displayDataToTable(data, columns, field) {
  var $tableBody = $("#data-table tbody");
  $tableBody.empty();
  var $tableHead = $("#data-table thead");
  $tableHead.empty();

  var $headerRow = $("<tr>");

  $.each(columns, function (index, column) {
    $("<td>").text(column).appendTo($headerRow);
  });
  $("<td>").text("Action").appendTo($headerRow);

  $headerRow.appendTo($tableHead);

  $.each(data, function (index, item) {
    var $row = $("<tr>");

    $.each(columns, function (_, column) {
      $("<td>").text(item[column]).appendTo($row);
    });

    var $actionCell = $("<td>");
    $("<i>", {
      class: `far fa-edit mr-2 ${field}`,
      style: "color: #04b418",
      "data-toggle": "#modal",
      "data-target": `#modal-update-${field}`,
      "data-id": item.id,
    }).appendTo($actionCell);
    $("<i>", {
      class: `far fa-trash-alt ml-2 ${field}`,
      style: "color: #a40404",
      "data-toggle": "#modal",
      "data-target": `#modal-delete-${field}`,
      "data-id": item.id,
    }).appendTo($actionCell);

    $actionCell.appendTo($row);
    $row.appendTo($tableBody);
  });
}

//sent data to create new province
function createNewProvince() {
  let province = getProvince();
  console.log(province);
  // validate province
  $.ajax({
    url: "/province/create",
    data: JSON.stringify(province),
    method: "POST",
    contentType: "application/json",
    success: function (response) {
      console.log(response);
    },
    error: function (error) {
      console.log(error);
    },
  });
}

//sent data to create new district
function createNewDistrict() {
  let district = getDistrict();
  // valid district
  $.ajax({
    contentType: "application/json",
    url: `/district/create/${district.provinceId}`,
    data: JSON.stringify(district),
    method: "POST",
    success: function (response) {
      console.log(response);
    },
    error: function (error) {
      console.log(error);
    },
  });
}

//sent data to create new ward
function createNewWard() {
  let ward = getWard();
  //valid ward
  $.ajax({
    contentType: "application/json",
    url: `/ward/create/${ward.districtId}`,
    method: "POST",
    data: JSON.stringify(ward),
    success: function (response) {
      console.log(response);
    },
    error: function (error) {
      console.log(error);
    },
  });
}

//Get data to create province
function getProvince() {
  return {
    name: $("#inp-province-name").val(),
    code: $("#inp-province-code").val(),
  };
}

//Get data to create district
function getDistrict() {
  return {
    name: $("#inp-district-name").val(),
    prefix: $("#inp-district-prefix").val(),
    provinceId: $("#sel-province-for-district option:selected").data(
      "provinceId"
    ),
  };
}

//Get data to create ward
function getWard() {
  return {
    name: $("#inp-ward-name").val(),
    prefix: $("#inp-ward-prefix").val(),
    districtId: $("#sel-district-for-ward option:selected").data("districtId"),
  };
}

//delete province to database
function deleteProvince(element) {
  var id = $(element).data("id");
  $.ajax({
    url: `/province/delete/${id}`,
    method: "DELETE",
    success: function (response) {
      console.log(response);
    },
    error: function (error) {
      console.log(error);
    },
  });
}

//delete district to database
function deleteDistrict(element) {
  var id = $(element).data("id");
  $.ajax({
    url: `/district/delete/${id}`,
    method: "DELETE",
    success: function (response) {
      console.log(response);
    },
    error: function (error) {
      console.log(error);
    },
  });
}

//delete ward to database
function deleteWard(element) {
  var id = $(element).data("id");
  $.ajax({
    url: `/ward/delete/${id}`,
    method: "DELETE",
    success: function (response) {
      console.log(response);
    },
    error: function (error) {
      console.log(error);
    },
  });
}

//update province to database
function updateProvince(element) {
  var id = $(element).data("id");
  $.ajax({
    contentType: "application/json",
    url: `/district/create/${district.provinceId}`,
    data: JSON.stringify(district),
    method: "POST",
    success: function (response) {
      console.log(response);
    },
    error: function (error) {
      console.log(error);
    },
  });
}

//update district to database
function updateDistrict(element) {
  var id = $(element).data("id");
  $.ajax({
    contentType: "application/json",
    url: `/district/create/${district.provinceId}`,
    data: JSON.stringify(district),
    method: "POST",
    success: function (response) {
      console.log(response);
    },
    error: function (error) {
      console.log(error);
    },
  });
}

//update ward to database
function updateWard(element) {
  var id = $(element).data("id");
  $.ajax({
    contentType: "application/json",
    url: `/district/create/${district.provinceId}`,
    data: JSON.stringify(district),
    method: "POST",
    success: function (response) {
      console.log(response);
    },
    error: function (error) {
      console.log(error);
    },
  });
}
