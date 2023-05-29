'use strict';
$.get(`http://127.0.0.1:8080/api/countries`, getCountry);
$.get(`http://127.0.0.1:8080/api/countries/regions`, loadRegionToTable);
let vCountrySelectElement = $('#select-country');
function getCountry(paramCountry) {
  paramCountry.forEach((country) => {
    $('<option>', {
      text: country.countryName,
      value: country.countryId,
    }).appendTo(vCountrySelectElement);
  });
}

let regionTable = $('#region-table').DataTable({
  columns: [
    { data: 'regionId' },
    { data: 'regionCode' },
    { data: 'regionName' },
    { data: 'action' },
  ],
  columnDefs: [
    {
      targets: -1,
      defaultContent: `<i class="fas fa-edit text-primary"></i>
      | <i class="fas fa-trash text-danger"></i>`,
    },
  ],
});

function loadRegionToTable(paramRegion) {
  regionTable.clear();
  regionTable.rows.add(paramRegion);
  regionTable.draw();
}

vCountrySelectElement.change(onGetRegionChange);

function onGetRegionChange(event) {
  gCountryId = event.target.value;
  if (gCountryId == 0) {
    $.get(`http://127.0.0.1:8080/api/countries/regions`, loadRegionToTable);
  } else {
    $.get(
      `http://127.0.0.1:8080/api/countries/${gCountryId}/regions`,
      loadRegionToTable,
    );
  }
}

// region
let gCountryId = 0;
let gRegionId = 0;

let region = {
  newRegion: {
    regionCode: '',
    regionName: '',
  },
  onCreateRegionClick() {
    this.newRegion = {
      regionCode: $('#input-region-Code').val().trim(),
      regionName: $('#input-region-name').val().trim(),
    };
    gRegionId = 0;
    if (validateRegion(this.newRegion)) {
      $.ajax({
        url: `http://127.0.0.1:8080/api/countries/${gCountryId}/regions`,
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(this.newRegion),
        success: (region) => {
          alert(
            `Đã tạo thành công region có  code là: ${region.regionCode} và tên là: ${region.regionName}`,
          );
          $.get(
            `http://127.0.0.1:8080/api/countries/${gCountryId}/regions`,
            loadRegionToTable,
          );
          resetRegionInput();
        },
        error: (err) => alert(err.responseText),
      });
    }
  },
  onEditRegionClick() {
    let vSelectedRow = $(this).parents('tr');
    let vSelectedData = regionTable.row(vSelectedRow).data();
    gRegionId = vSelectedData.regionId;
    $.get(
      `http://127.0.0.1:8080/api/countries/regions/${gRegionId}`,
      loadRegionToInput,
    );
  },
  onUpdateRegionClick() {
    this.newRegion = {
      regionCode: $('#input-region-Code').val().trim(),
      regionName: $('#input-region-name').val().trim(),
    };
    if (validateRegion(this.newRegion)) {
      $.ajax({
        url: `http://127.0.0.1:8080/api/countries/regions/${gRegionId}`,
        method: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(this.newRegion),
        success: (region) => {
          alert(
            `Đã update thành công region có  code là: ${region.regionCode} và tên là: ${region.regionName}`,
          );
          $.get(
            `http://127.0.0.1:8080/api/countries/${gCountryId}/regions`,
            loadRegionToTable,
          );
          resetRegionInput();
        },
        error: (err) => alert(err.responseText),
      });
    }
  },
  onDeleRegionByIdClick() {
    $('#modal-delete-region').modal('show');
    let vSelectedRow = $(this).parents('tr');
    let vSelectedData = regionTable.row(vSelectedRow).data();
    gRegionId = vSelectedData.regionId;
  },
  onDeleteAllRegionClick() {
    $('#modal-delete-region').modal('show');
    gRegionId = 0;
  },
  onConfirmDeleteRegionClick() {
    if (gRegionId == 0) {
      $.ajax({
        url: `http://127.0.0.1:8080/api/countries/regions`,
        method: 'DELETE',
        success: () => {
          alert(`All Region were successfully Delete`);
          $('#modal-delete-region').modal('hide');
          $.get(
            `http://127.0.0.1:8080/api/countries/regions`,
            loadRegionToTable,
          );
        },
        error: (err) => alert(err.responseText),
      });
    } else {
      $.ajax({
        url: `http://127.0.0.1:8080/api/countries/regions/${gRegionId}`,
        method: 'DELETE',
        success: () => {
          alert(`Region with id: ${gRegionId} were successfully Delete`);
          $('#modal-delete-region').modal('hide');
          $.get(
            `http://127.0.0.1:8080/api/countries/regions`,
            loadRegionToTable,
          );
        },
        error: (err) => alert(err.responseText),
      });
    }
  },
};

$('#create-region').click(region.onCreateRegionClick);
$('#update-region').click(region.onUpdateRegionClick);
$('#delete-all-region').click(region.onDeleteAllRegionClick);
$('#delete-region').click(region.onConfirmDeleteRegionClick);
$('#region-table').on('click', '.fa-edit', region.onEditRegionClick);
$('#region-table').on('click', '.fa-trash', region.onDeleRegionByIdClick);

function loadRegionToInput(paramRegion) {
  $('#input-region-Code').val(paramRegion.regionCode);
  $('#input-region-name').val(paramRegion.regionName);
}

function validateRegion(paramRegion) {
  let vResult = true;
  try {
    if (gCountryId == 0) {
      vResult = false;
      throw 'xin hãy chọn 1 đất nước';
    }
    if (paramRegion.regionCode == '') {
      vResult = false;
      throw 'Xin hãy cho biết Mã Vùng Miền';
    }
    if (paramRegion.regionName == '') {
      vResult = false;
      throw 'Xin hãy cho biết tên Vùng Miền';
    }
  } catch (e) {
    alert(e);
  }
  return vResult;
}

function resetRegionInput() {
  $('#input-region-Code').val('');
  $('#input-region-name').val('');
}
// country
let country = {
  newCountry: {
    countryCode: '',
    countryName: '',
  },
  onNewCountryClick() {
    $('#modal-create-country').modal('show');
    gCountryId = 0;
  },
  onUpdateCountryClick() {
    if (gCountryId != 0) {
      $('#modal-create-country').modal('show');
      $.get(
        `http://127.0.0.1:8080/api/countries/${gCountryId}`,
        loadCountryToInput,
      );
    } else {
      alert('Please select country to update');
    }
  },
  onSaveCountryClick() {
    this.newCountry = {
      countryCode: $('#input-country-code').val(),
      countryName: $('#input-country-name').val(),
    };
    if (gCountryId == 0) {
      if (validateCountry(this.newCountry)) {
        $.ajax({
          url: 'http://127.0.0.1:8080/api/countries',
          method: 'POST',
          data: JSON.stringify(this.newCountry),
          contentType: 'application/json',
          success: (country) => {
            alert(`Đã tạo thành công country`);
            $('#modal-create-country').modal('hide');
            resetCountryInput();
            location.reload();
          },
          error: (err) => alert(err.responseText),
        });
      }
    } else {
      if (validateCountry(this.newCountry)) {
        $.ajax({
          url: `http://127.0.0.1:8080/api/countries/${gCountryId}`,
          method: 'PUT',
          data: JSON.stringify(this.newCountry),
          contentType: 'application/json',
          success: (country) => {
            alert(`Đã cập nhât thành công country với id: ${gCountryId}`);
            $('#modal-create-country').modal('hide');
            resetCountryInput();
            location.reload();
          },
          error: (err) => alert(err.responseText),
        });
      }
    }
  },
  onDeleteCountryClick() {
    if (gCountryId != 0) {
      $('#modal-delete-country').modal('show');
    } else {
      alert('Please select country to delete');
    }
  },
  onDeleteAllCountryClick() {
    $('#modal-delete-country').modal('show');
    gCountryId == 0;
  },
  onConfirmDeleteCountryClick() {
    if (gCountryId == 0) {
      $.ajax({
        url: `http://127.0.0.1:8080/api/countries/`,
        method: 'DELETE',
        success: () => {
          alert(`Successfully Delete All Country`);
          location.reload();
        },
        error: () => alert(`Need delete All region then delete country`),
      });
    } else {
      $.ajax({
        url: `http://127.0.0.1:8080/api/countries/${gCountryId}`,
        method: 'DELETE',
        success: () => {
          alert(`Successfully Delete Country with id: ${gCountryId}`);
          location.reload();
        },
        error: () => alert(`Need delete All region then delete country`),
      });
    }
  },
};

$('#create-country').click(country.onNewCountryClick);
$('#update-country').click(country.onUpdateCountryClick);
$('#btn-save-country').click(country.onSaveCountryClick);
$('#delete-country').click(country.onDeleteCountryClick);
$('#delete-all-country').click(country.onDeleteAllCountryClick);
$('#btn-delete-country').click(country.onConfirmDeleteCountryClick);

function validateCountry(paramCountry) {
  let vResult = true;
  try {
    if (paramCountry.countryCode == '') {
      vResult = false;
      throw 'Không được để trống country code';
    }

    if (paramCountry.countryName == '') {
      vResult = false;
      throw 'Không được để trống country name';
    }
  } catch (e) {
    alert(e);
  }
  return vResult;
}

function loadCountryToInput(paramCountry) {
  $('#input-country-code').val(paramCountry.countryCode);
  $('#input-country-name').val(paramCountry.countryName);
}

function resetCountryInput() {
  $('#input-country-code').val('');
  $('#input-country-name').val('');
}
