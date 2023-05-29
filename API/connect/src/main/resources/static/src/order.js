let gUserId = 0;
let gOrderId = 0;
// user
$.get(`http://127.0.0.1:8080/api/users`, loadUserToSelect);
$.get(`http://127.0.0.1:8080/api/users/orders`, loadOrderToTable);
let userSelectElement = $('#select-user');
function loadUserToSelect(paramUser) {
  paramUser.forEach((user) => {
    $('<option>', {
      text: user.fullName,
      value: user.userId,
    }).appendTo(userSelectElement);
  });
}
userSelectElement.change(onGetUserChange);
function onGetUserChange(event) {
  gUserId = event.target.value;
  if (gUserId == 0) {
    $.get(`http://127.0.0.1:8080/api/users/orders`, loadOrderToTable);
  } else {
    $.get(
      `http://127.0.0.1:8080/api/users/${gUserId}/orders`,
      loadOrderToTable,
    );
  }
}

let user = {
  newUser: {
    fullName: '',
    email: '',
    phone: '',
    address: '',
  },
  onCreateNewUserClick() {
    $('#modal-create-user').modal('show');
    console.log(gUserId);
  },
  onUpdateUserClick() {
    if (gUserId != 0) {
      $('#modal-create-user').modal('show');
      $.get(`http://127.0.0.1:8080/api/users/${gUserId}`, loadUserToInput);
    } else {
      alert('Please select a user to update');
    }
  },
  onSaveUserClick() {
    this.newUser = {
      fullName: $('#input-fullname').val().trim(),
      email: $('#input-email').val().trim(),
      phone: $('#input-phone').val().trim(),
      address: $('#input-address').val().trim(),
    };
    if (gUserId == 0) {
      if (validateUser(this.newUser)) {
        $.ajax({
          url: `http://127.0.0.1:8080/api/users`,
          method: 'POST',
          contentType: 'application/json',
          data: JSON.stringify(this.newUser),
          success: () => {
            alert('successfully create new user');
            location.reload();
          },
          error: (err) => alert(err.responseText),
        });
      }
    } else {
      if (validateUser(this.newUser)) {
        $.ajax({
          url: `http://127.0.0.1:8080/api/users/${gUserId}`,
          method: 'PUT',
          contentType: 'application/json',
          data: JSON.stringify(this.newUser),
          success: () => {
            alert('successfully update user with id: ' + gUserId);
            location.reload();
          },
          error: (err) => alert(err.responseText),
        });
      }
    }
  },
  onDeleteUserClick() {
    if (gUserId != 0) {
      $('#modal-delete-user').modal('show');
    } else {
      alert('Please select a user to delete');
    }
  },
  onDeleteAllUserClick() {
    gUserId = 0;
    $('#modal-delete-user').modal('show');
  },
  onConfirmDeleteUserClick() {
    if (gUserId != 0) {
      $.ajax({
        url: `http://127.0.0.1:8080/api/users/${gUserId}`,
        method: 'delete',
        success: () => {
          alert('successfully delete user with id:' + gUserId);
          location.reload();
        },
        error: (err) => alert(err.responseText),
      });
    } else {
      $.ajax({
        url: `http://127.0.0.1:8080/api/users`,
        method: 'delete',
        success: () => {
          alert('successfully delete all users');
          location.reload();
        },
        error: (err) => alert(err.responseText),
      });
    }
  },
};

$('#btn-create-user').click(user.onCreateNewUserClick);
$('#btn-update-user').click(user.onUpdateUserClick);
$('#btn-save-user').click(user.onSaveUserClick);
$('#btn-delete-user').click(user.onDeleteUserClick);
$('#btn-delete-all-User').click(user.onDeleteAllUserClick);
$('#btn-confirm-delete-user').click(user.onConfirmDeleteUserClick);

function loadUserToInput(paramUser) {
  $('#input-fullname').val(paramUser.fullName);
  $('#input-email').val(paramUser.email);
  $('#input-phone').val(paramUser.phone);
  $('#input-address').val(paramUser.address);
}

function validateUser(paramUser) {
  let vResult = true;
  try {
    if (paramUser.fullName == '') {
      vResult = false;
      throw `full name can't be empty`;
    }

    if (paramUser.email == '') {
      vResult = false;
      throw ` email can't be empty`;
    }
    if (!validateEmail(paramUser.email)) {
      vResult = false;
      throw `must need right email`;
    }
    if (paramUser.phone == '') {
      vResult = false;
      throw `phone can't be empty`;
    }
    if (paramUser.phone.length < 10 || isNaN(paramUser.phone)) {
      vResult = false;
      throw `Cần nhập đúng kiểu số điện thoại phải không có chữ cái và đúng 10 số`;
    }
    if (paramUser.address == '') {
      vResult = false;
      throw `Address can't be empty`;
    }
  } catch (e) {
    alert(e);
  }
  return vResult;
}

function validateEmail(email) {
  const re =
    /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
  return re.test(String(email).toLowerCase());
}
// order
let orderTable = $('#order-table').DataTable({
  columns: [
    { data: 'orderCode' },
    { data: 'pizzaSize' },
    { data: 'pizzaType' },
    { data: 'voucherCode' },
    { data: 'price' },
    { data: 'paid' },
    { data: 'Action' },
  ],
  columnDefs: [
    {
      targets: -1,
      defaultContent: `<i class="fas fa-edit text-primary"></i>
      | <i class="fas fa-trash text-danger"></i>`,
    },
  ],
});

function loadOrderToTable(paramOrder) {
  orderTable.clear();
  orderTable.rows.add(paramOrder);
  orderTable.draw();
}

let order = {
  newOrder: {
    orderCode: '',
    pizzaSize: '',
    pizzaType: '',
    voucherCode: '',
    price: '',
    paid: '',
  },
  onNewOrderClick() {
    gOrderId = 0;
    this.newOrder = {
      orderCode: $('#input-order-Code').val().trim(),
      pizzaSize: $('#input-pizza-size').val().trim(),
      pizzaType: $('#input-pizza-type').val().trim(),
      voucherCode: $('#input-voucher').val().trim(),
      price: $('#input-Price').val().trim(),
      paid: $('#input-Paid').val().trim(),
    };
    if (validateOrder(this.newOrder)) {
      if (gUserId == 0) {
        alert(`Please select customer to create a new order`);
      } else {
        $.ajax({
          url: `http://127.0.0.1:8080/api/users/${gUserId}/orders`,
          method: 'POST',
          data: JSON.stringify(this.newOrder),
          contentType: 'application/json',
          success: () => {
            alert(`Order created successfully`);
            $.get(
              `http://127.0.0.1:8080/api/users/${gUserId}/orders`,
              loadOrderToTable,
            );
            resetOrderInput();
          },
        });
      }
    }
  },
  onEditOrderClick() {
    vSelectedRow = $(this).parents('tr');
    vSelectedData = orderTable.row(vSelectedRow).data();
    gOrderId = vSelectedData.orderId;
    $.get(
      `http://127.0.0.1:8080/api/users/orders/${gOrderId}`,
      loadOrderToInput,
    );
  },
  onUpdateOrderClick() {
    this.newOrder = {
      orderCode: $('#input-order-Code').val().trim(),
      pizzaSize: $('#input-pizza-size').val().trim(),
      pizzaType: $('#input-pizza-type').val().trim(),
      voucherCode: $('#input-voucher').val().trim(),
      price: $('#input-Price').val().trim(),
      paid: $('#input-Paid').val().trim(),
    };
    if (validateOrder(this.newOrder)) {
      if (gUserId == 0) {
        alert(`Please select customer to update a new order`);
      } else {
        $.ajax({
          url: `http://127.0.0.1:8080/api/users/orders/${gOrderId}`,
          method: 'PUT',
          data: JSON.stringify(this.newOrder),
          contentType: 'application/json',
          success: () => {
            alert(`Order updated successfully`);
            $.get(
              `http://127.0.0.1:8080/api/users/${gUserId}/orders`,
              loadOrderToTable,
            );
            resetOrderInput();
          },
        });
      }
    }
  },
  onDeleteUserByIdClick() {
    $('#modal-delete-order').modal('show');
    vSelectedRow = $(this).parents('tr');
    vSelectedData = orderTable.row(vSelectedRow).data();
    gOrderId = vSelectedData.orderId;
  },
  onDeleteAllOrderClick() {
    $('#modal-delete-order').modal('show');
    gOrderId = 0;
  },
  onOrderConfirmDeleteClick() {
    if (gOrderId == 0) {
      $.ajax({
        url: `http://127.0.0.1:8080/api/users/orders`,
        method: 'delete',
        success: () => {
          alert('All Order was successfully deleted');
          $.get(`http://127.0.0.1:8080/api/users/orders`, loadOrderToTable);
          $('#modal-delete-order').modal('hide');
        },
        error: (err) => alert(err.responseText),
      });
    } else {
      $.ajax({
        url: `http://127.0.0.1:8080/api/users/orders/${gOrderId}`,
        method: 'delete',
        success: () => {
          alert(`Order with id ${gOrderId} was successfully deleted`);
          $.get(`http://127.0.0.1:8080/api/users/orders`, loadOrderToTable);
          $('#modal-delete-order').modal('hide');
        },
        error: (err) => alert(err.responseText),
      });
    }
  },
};

$('#create-order').click(order.onNewOrderClick);
$('#update-order').click(order.onUpdateOrderClick);
$('#delete-all-order').click(order.onDeleteAllOrderClick);
$('#btn-confirm-delete-order').click(order.onOrderConfirmDeleteClick);
$('#order-table').on('click', '.fa-edit', order.onEditOrderClick);
$('#order-table').on('click', '.fa-trash', order.onDeleteUserByIdClick);

function validateOrder(paramOrder) {
  let vResult = true;
  try {
    if (paramOrder.orderCode == '') {
      vResult = false;
      throw `Order code can't empty`;
    }
    if (paramOrder.pizzaSize == '') {
      vResult = false;
      throw `Pizza Size can't empty`;
    }
    if (paramOrder.pizzaType == '') {
      vResult = false;
      throw `Pizza Type can't empty`;
    }
    if (paramOrder.price == '' || isNaN(paramOrder.price)) {
      vResult = false;
      throw `Price cant' be empty or must is number`;
    }
    if (paramOrder.paid == '' || isNaN(paramOrder.paid)) {
      vResult = false;
      throw `Paid cant' be empty or must is number`;
    }
  } catch (e) {
    alert(e);
  }
  return vResult;
}

function loadOrderToInput(paramOrder) {
  $('#input-order-Code').val(paramOrder.orderCode);
  $('#input-pizza-size').val(paramOrder.pizzaSize);
  $('#input-pizza-type').val(paramOrder.pizzaType);
  $('#input-voucher').val(paramOrder.voucherCode);
  $('#input-Price').val(paramOrder.price);
  $('#input-Paid').val(paramOrder.paid);
}

function resetOrderInput() {
  $('#input-order-Code').val('');
  $('#input-pizza-size').val('');
  $('#input-pizza-type').val('');
  $('#input-voucher').val('');
  $('#input-Price').val('');
  $('#input-Paid').val('');
}
