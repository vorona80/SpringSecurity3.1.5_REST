// const urlAdmin = 'http://localhost:8080/api/admin';
// // const url = 'http://localhost:8080/api/admin/new';
// // const urlRoles = '/admin/users/roles/';
// let userTable = $('#adminTable');
//
// let deleteUserModal = new bootstrap.Modal(document.getElementById('deleteUserModal'));
// let editUserModal = new bootstrap.Modal(document.getElementById('editUserModal'))
//
// let roles = ''

// adminTable();
// function adminTable() {
//      userTable.empty()
//
//     fetch(urlAdmin)
//         .then (response => response.json())
//         .then(data => {
//             data.forEach(user => {
//                 let result = `$(
//                 <tr>
//                     <td>${user.id}</td>
//                     <td>${user.username}</td>
//                     <td>${user.lastName}</td>
//                     <td>${user.age}</td>
//                     <td>${user.roles.map(role => role.role.replace('ROLE_', ''))}</td>
//
//                      <td>
//                      <button onclick="getEditModal(${user.id})" type="button" class="btnExit btn-sm btn-primary" id = "editUserBtn">
//                      Edit</button>
//                      </td>
//                      <td><button onclick="getDeleteModal(${user.id})" type="button" class="btnDelete btn-sm btn-danger" id = "deleteUserBtn">
//                      Delete</button>
//                      </td>
//                 </tr>`;
//                 userTable.append(result)
//
//                 })
// })
// }

// function getEditModal(id) {
//
//
//     fetch(urlAdmin + '/' + id)
//         .then(res => res.json())
//         .then(editUser => {
//             console.log(editUser);
//             document.getElementById('idEdit').value = editUser.id;
//             document.getElementById('usernameEdit').value = editUser.username;
//             document.getElementById('lastNameEdit').value = editUser.lastName;
//             document.getElementById('ageEdit').value = editUser.age;
//             document.getElementById('passwordEdit').value = null
//             document.getElementById('roleEdit').innerHTML = "";
//             editUser.roles.forEach(role => {
//                 const option = document.createElement('option')
//                 option.text = role.role.substring(5)
//                 document.getElementById('roleEdit').add(option)
//             })
//             editUserModal.show()
//             })
//     document.getElementById('editUser').addEventListener('submit', submitFormEditUser);
// }
// function submitFormEditUser(event) {
//     event.preventDefault()
//     let editUserForms = new Form (event.target)
//     let userEdit = {
//         id: editUserForms.get('id'),
//         username: editUserForms.get('username'),
//         lastName: editUserForms.get('lastName'),
//         age: editUserForms.get('age'),
//         password: editUserForms.get('password'),
//         roles: editUserForms("#roleEdit")
//     }
//     console.log(userEdit)
//
//     let request = new Request(urlAdmin, {
//         method: 'PUT',
//         body: JSON.stringify(userEdit),
//         // headers: {
//         //     'Content-Type': 'application/json',
//         // },
//     })
//     fetch(request).then(
//         function (response) {
//             console.log(response)
//             getUsers();
//             event.target.reset();
//             editModal.hide();
//         });
// }
// // adminTable()
//
// function getUsers() {
//     fetch(request).then(res =>
//         res.json()).then(data => {
//         let tableUsers = [];
//         if (data.length > 0) {
//             data.forEach(user => {
//                 tableUsers.push(user)
//             })
//         } else {
//             tableUsers = [];
//         }
//
//         showUsers(tableUsers);
//     })
// }
//
//
//
// function getDeleteModal(id) {
//
//     fetch(urlAdmin + '/' + id)
//         .then(res => res.json())
//         .then(deleteUser => {
//             console.log(deleteUser);
//             document.getElementById('idDelete').value = deleteUser.id;
//             document.getElementById('usernameDelete').setAttribute('value', deleteUser.username);
//             document.getElementById('lastNameDelete').setAttribute('value', deleteUser.lastName);
//             document.getElementById('ageDelete').setAttribute('value', deleteUser.age);
//             document.getElementById('roleDelete').innerHTML = ""
//             deleteUser.roles.forEach(role => {
//                 const option = document.createElement('option')
//                 option.text = role.role.substring(5)
//                 document.getElementById('roleDelete').add(option)
//                 })
//             deleteUserModal.show();
//         })
//
// }
//
// document.getElementById('deleteUserModalForm').addEventListener('submit', (event) => {
//     event.preventDefault()
//     fetch(urlAdmin + '/' + document.getElementById('idDelete').value, {
//         method: 'DELETE'
//     })
//         .then(() => {
//             $('#deleteUserCloseButton').click();
//             adminTable()
//         })
// })
//
//
//
//
//
//
//
//
//



// let formDelete = document.forms["formDelete"];
// deleteUser();
// function deleteModalUser(id) {
//         document.getElementById('closeDeleteModal').setAttribute('onclick', () => {
//             deleteModal.hide();
//         document.getElementById('formDeleteUser').reset();
//         });
//     let request = new Request(urlAdmin + "/" + id, {
//         method: 'GET',
//         headers: {
//             'Content-Type': 'application/json',
//         },
//     });
// }

//---------------- медод эмуляции по id---------------
// const on = (element, event, selector, handler) => {
// //    console.log(element)  захватывает весь элент
// //     console.log(event) передаем событие
// //     console.log(selector) /*передаем селектор точку удаления*/
// //     console.log(handler) обработчик запускаутся в случаи события
//
//     // код добавляет обработчик события для элемента. При срабатывании указанного события,
//     // вызывается функция-колбэк, которая принимает один аргумент 'e'.
//     // Цель кода - проверить, является ли элемент, на который навешивается обработчик,
//     // потомком элемента, который соответствует заданному CSS-селектору. Если да,
//     // то функция-обработчик "handler" вызывается с объектом события "e" в качестве аргумента.
//
//     element.addEventListener(event, e => {
//         if(e.target.closest(selector)) {
//             handler(e.target)
//         }
//     })
// }
//
//     let rowDelete = null
// on (document,'onclick', '.deleteUserBtn', (e) => {
//     const row = e.target.parentNode.parentNode
//     const id = row.firstElementChild.innerHTML
//     document.getElementById('idDelete').value = rowDelete.children[0].innerHTML
//     document.getElementById('usernameDelete').value = rowDelete.children[1].innerHTML
//     document.getElementById('lastNameDelete').value = rowDelete.children[2].innerHTML
//     document.getElementById('ageDelete').value = rowDelete.children[3].innerHTML
    // let option = ''

          // const  allRoles = user.roles.map(role => role.role.substring(5))
          //       .then(response => response.json)
          //       .then(roles => {
          //       roles.forEach(role => {
          //               if (rowDelete.children[5].innerHTML.includes(role.role.substring(5))) {
          //                   option += `<option value="${role.id}>${role.role.substring(5)}</option>`
          //               }
          //       })
          //       document.getElementById('roleDelete').innerHTML = option
          //   })
    // deleteUserModal.show()
    // })
    // document.getElementById('deleteUserModalForm').addEventListener('submit', (e) => {
    //     e.preventDefault()
    //     fetch(urlAdmin +  rowDelete.children[0].innerHTML, {
    //         method: 'DELETE',
    //     })
    //         .then( () => {
    //             deleteUserModal.hide()
    //             rowDelete.parentNode.removeChild(rowDelete)
    //         })
    //
    //
    // })
