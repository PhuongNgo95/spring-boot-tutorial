function setCustomers(){
    $('#createNewMessage').hide();
    clearAddingUser();
}

function clearAddingUser(){
    $('#CustomerAdd').trigger("reset");
}