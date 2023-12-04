async function openAndFillInTheModal(form, modal, id) {
    modal.show();
    let user = await getOneUser(id);
    form.id.value = user.id;
    form.name.value = user.name;
    form.lastName.value = user.lastName;
    form.email.value = user.email;
    form.phoneNumber.value = user.phoneNumber;
    form.roles.value = user.roles;
}