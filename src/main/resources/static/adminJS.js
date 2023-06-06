const url = 'http://localhost:8080/api/admin';

function getAllUsers() {
    fetch(url)
        .then(res => res.json())
        .then(data => {
            loadTable(data)
        })
}
function getAdminPage() {
    fetch(url).then(response => response.json()).then(user =>
        loadTable(user))
}

function loadTable(listAllUsers) {
    let res = '';
    for (let user of listAllUsers) {
        res +=
            `<tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.lastName}</td>
                <td>${user.age}</td>
                <td id = ${'role' + user.id}>${user.roles.map(r => r.role.substring(5)).join(' ')}</td>
                <td>
                    <button class="btn btn-info" type="button"
                    data-bs-toggle="modal" data-bs-target="#editModal"
                    onclick="editModal(${user.id})">Edit</button></td>
                <td>
                    <button class="btn btn-danger" type="button"
                    data-bs-toggle="modal" data-bs-target="#deleteModal"
                    onclick="deleteModal(${user.id})">Delete</button></td>
            </tr>`
    }
    document.getElementById('adminTable').innerHTML = res;
}

getAdminPage();


// Добавление пользователя
document.getElementById('newUserForm').addEventListener('submit',(e) => {
e.preventDefault()
let  role =document.getElementById('newRoles')
    let rolesAddUser = []
    let rolesAddUserValue = ''
    for(let i = 0; i < role.options.length; i++) {
        if (role.options[i].selected) {
            rolesAddUser.push({id: role.options[i].value, role: 'ROLE_' + role.options[i].innerHTML})
            rolesAddUserValue += role.options[i].innerHTML
        }
    }
    fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            username:document.getElementById('newUsername').value,
            lastName: document.getElementById('newLastName').value,
            age: document.getElementById('newAge').value,
            password: document.getElementById('newPassword').value,
            roles: rolesAddUser
        })
    })
        .then((response) => {
if(response.ok) {
    getAllUsers()
    document.getElementById("userTableClick").click()
}
        })
})


// Закрытие модального окна
function closeModal() {
    // document.getElementById("editClose").click()
    document.querySelectorAll(".btn-close").forEach((btn) => btn.click())
}




//Редактирование пользователя
function editModal(id) {
    fetch(url + '/' + id, {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json;charset=UTF-8'
        }
    }).then(res => {
        res.json().then(u => {

            document.getElementById('editId').value = u.id;
            document.getElementById('editUsername').value = u.username;
            document.getElementById('editLastName').value = u.lastName;
            document.getElementById('editAge').value = u.age;
            document.getElementById('editPassword').value = "****";
            console.log(res)
        })
    });
}


async function editUser() {
    const form_ed = document.getElementById('modalEdit');
    let idValue = document.getElementById("editId").value;
    let usernameValue = document.getElementById("editUsername").value;
    let lastNameValue = document.getElementById("editLastName").value;
    let ageValue = document.getElementById('editAge').value;
    let passwordValue = document.getElementById("editPassword").value;
    let listOfRole = [];
    for (let i = 0; i < form_ed.roles.options.length; i++) {
        if (form_ed.roles.options[i].selected) {
            let tmp = {};
            tmp["id"] = form_ed.roles.options[i].value
            listOfRole.push(tmp);
        }
    }
    let user = {
        id: idValue,
        username: usernameValue,
        lastName: lastNameValue,
        age: ageValue,
        password: passwordValue,
        role: listOfRole
    }
    await fetch(url + '/' + user.id, {
        method: "PATCH",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json;charset=UTF-8'
        },
        body: JSON.stringify({
            id: idValue,
            username: usernameValue,
            lastName: lastNameValue,
            age: ageValue,
            password: passwordValue,
            role: listOfRole
        })

    });
    closeModal()
    getAllUsers()
}


// Удаление пользователя
function deleteModal(id) {
    fetch(url + '/' + id, {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json;charset=UTF-8'
        }
    }).then(res => {
        res.json().then(u => {
            document.getElementById('idDelete').value = u.id;
            document.getElementById('usernameDelete').value = u.username;
            document.getElementById('lastNameDelete').value = u.lastName;
            document.getElementById('ageDelete').value = u.age;
            document.getElementById('roleDelete').value = u.roles.map(r => r.role).join(", ");
        })
    });
}

async function deleteUser() {
    const id = document.getElementById("idDelete").value
    console.log(id)
    let urlDel = url + "/" + id;
    let method = {
        method: 'DELETE',
        headers: {
            "Content-Type": "application/json"
        }
    }

    fetch(urlDel, method).then(() => {
        closeModal()
        getAllUsers()
        document.getElementById("userTableClick").click()
    })
}


