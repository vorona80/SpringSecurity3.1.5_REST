// const userUrl = 'http://localhost:8080/api/currentUser';
//
//
// function getUserPage() {
//     fetch(userUrl).then(response => response.json()).then(user =>
//         getInformationAboutUser(user))
// }
//
// function getInformationAboutUser(user) {
//
//     let result = '';
//     result =
//         `<tr>
//      <td>${user.id}</td>
//                      <td>${user.username}</td>
//                      <td>${user.lastName}</td>
//                      <td>${user.age}</td>
//                      <td>${user.roles.map(role => role.role.substring(5))}</td>
// </tr>`
//     document.getElementById('userTableBody').innerHTML = result;
// }
//
// getUserPage();












// const urlUser = 'http://localhost:8080/api/user/current'
//
// user();
//
// function user(){
//     fetch(urlUser)
//         .then(response => response.json())
//         .then(user => {
//        // console.log('user', JSON.stringify(user))
//             $('#headerUsername').append(user.username.toUpperCase());
//             $('#headerRole').append(user.roles.map(role => role.role.substring(5) + " "));
//
//             let result = `$(
//                 <tr>
//                     <td>${user.id}</td>
//                     <td>${user.username}</td>
//                     <td>${user.lastName}</td>
//                     <td>${user.age}</td>
//                     <td>${user.roles.map(role => role.role.substring(5))}</td>
//                      </tr>)`;
//             $('#userTable').append(result);
//         })
// }











// let currentUser = "";
// fetch("http://localhost:8080/api/user/current/")
//      .then(res => res.json())
//     .then(data => {
//         currentUser = data;
//         console.log(data)
//         showOneUser(currentUser);
//     })
//
// function showOneUser(user) {
//     let temp = "";
//     temp += "<tr>"
//     temp += "<td>" + user.id + "</td>"
//     temp += "<td>" + user.username + "</td>"
//     temp += "<td>" + user.lastName + "</td>"
//     temp += "<td>" + user.age + "</td>"
//     temp += "<td>" + user.roles.map(role => role.name.substring(5)) + "</td>"
//     temp += "</tr>"
//     document.getElementById("oneUserBody").innerHTML = temp;
// }
