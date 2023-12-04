'use strict';

getCurrentUser()

function getCurrentUser() {
    fetch("userApi/auth")
        .then(res => res.json())
        .then(js => {
            $('#emailCurrentUser').append(`<span>${js.email}</span>`)
            $('#roleCurrentUser').append(`<span>${js.shortRole}</span>`)
            const user = `$(
                    <tr>
                        <td>${js.id}</td>
                        <td>${js.name}</td>
                        <td>${js.lastName}</td>
                        <td>${js.email}</td>
                        <td>${js.phoneNumber}</td>
                        <td>${js.shortRole}</td>
                    </tr>)`;
            $('#oneUser').append(user)
        })
}