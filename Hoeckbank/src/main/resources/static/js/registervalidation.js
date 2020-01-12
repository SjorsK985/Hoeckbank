//DOM elements
//generic
var email_field_reg = document.getElementById('email-field-reg');
var password_field_reg = document.getElementById("password-field-reg");
var passwordconfirm_field_reg = document.getElementById("passwordconfirm-field-reg");
var phone_field_reg = document.getElementById("phone-field-reg");
var agree_field_reg = document.getElementById("agree-field-reg");

//private
var firstname_field_reg = document.getElementById("firstname-field-reg");
var prepositions_field_reg = document.getElementById("prepositions-field-reg");
var lastname_field_reg = document.getElementById("lastname-field-reg");
var birthdate_field_reg = document.getElementById("birthdate-field-reg");
var bsn_field_reg = document.getElementById("bsn-field-reg");
//Company
var companyname_field_reg = document.getElementById("companyname-field-reg");

//list
var validatedItems = [];
for(var i = 0; i < 10; i++) {
    validatedItems.push(false);
}

//Regex patterns
var emailPattern = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
var passwordPattern = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{5,20}$/;
var vast_nummer = /^(((0)[1-9]{2}[0-9][-]?[1-9][0-9]{5})|((\\+31|0|0031)[1-9][0-9][-]?[1-9][0-9]{6}))$/;
var mobiel_nummer = /^(((\\+31|0|0031)6){1}[1-9]{1}[0-9]{7})$/i;
var bsn_nummer = /^[1-9]{8,9}$/;
var onlyLetters = /^[a-zA-Z]+$/;
var onlyNumbers = /^[0-9]+$/;

//EventListeners general
email_field_reg.addEventListener('keyup', function(event){
    if(emailPattern.test(email_field_reg.value)){
        showValidateIconOk(email_field_reg);
        validatedItems[0] = true;
    } else if(email_field_reg.value == ""){
        hideValidateIcon(email_field_reg);
        validatedItems[0] = false;
    } else {
        showValidateIcon(email_field_reg);
        validatedItems[0] = false;
    }
});
email_field_reg.addEventListener('blur', function(event){
    var parent = email_field_reg.parentNode;
    var node = document.createElement("p");
    node.classList.add("text-danger","mt-2");
    var instructionMail = document.createTextNode("Dit is geen geldig emailadres");
    node.appendChild(instructionMail);
    if(validatedItems[0] == false && parent.childNodes.length < 3) {
        parent.appendChild(node);
    }
});
password_field_reg.addEventListener('keyup', function(event){
    if(passwordPattern.test(password_field_reg.value)){
        showValidateIconOk(password_field_reg);
        validatedItems[1] = true;
    } else if(password_field_reg.value == ""){
        hideValidateIcon(password_field_reg);
        validatedItems[1] = false;
    } else {
        showValidateIcon(password_field_reg);
        validatedItems[1] = false;
    }
});
password_field_reg.addEventListener('blur', function(event){
    var parent = password_field_reg.parentNode;
    var node = document.createElement("p");
    node.classList.add("text-danger","mt-2");
    var instructionMail = document.createTextNode("Het wachtwoord moet een kleine letter, een hoofdletter, een cijfer en minstens 5 karakters bevatten");
    node.appendChild(instructionMail);
    if(validatedItems[1] == false && parent.childNodes.length < 3) {
        parent.appendChild(node);
    }
});
passwordconfirm_field_reg.addEventListener('keyup', function(event){
    showValidateIcon(passwordconfirm_field_reg);
   validatedItems[2] = false;
   if(passwordconfirm_field_reg.value === password_field_reg.value){
       showValidateIconOk(passwordconfirm_field_reg);
       validatedItems[2] = true;
   }
});
passwordconfirm_field_reg.addEventListener('blur', function(event){
    var parent = passwordconfirm_field_reg.parentNode;
    var node = document.createElement("p");
    node.classList.add("text-danger","mt-2");
    var instructionMail = document.createTextNode("De wachtwoorden komen niet overeen");
    node.appendChild(instructionMail);
    if(validatedItems[2] == false && parent.childNodes.length < 3) {
        parent.appendChild(node);
    }
});
phone_field_reg.addEventListener('keyup', function (event){
    if(vast_nummer.test(phone_field_reg.value) || mobiel_nummer.test(phone_field_reg.value)){
        showValidateIconOk(phone_field_reg);
        validatedItems[3] = true;
    } else if(phone_field_reg.value.length > 0){
        showValidateIcon(phone_field_reg);
        validatedItems[3] = false;
    } else{
        hideValidateIcon(phone_field_reg);
        validatedItems[3] = false;
    }
});
phone_field_reg.addEventListener('blur', function(event){
    var parent = phone_field_reg.parentNode;
    var node = document.createElement("p");
    node.classList.add("text-danger","mt-2");
    var instructionMail = document.createTextNode("Dit is geen geldig telefoonnummer");
    node.appendChild(instructionMail);
    if(validatedItems[3] == false && parent.childNodes.length < 3){
        parent.appendChild(node);
    }
});

//---- Private -----//
firstname_field_reg.addEventListener('keyup', function(event){
    if(firstname_field_reg.value.length > 0 && onlyLetters.test(firstname_field_reg.value)){
        showValidateIcon(firstname_field_reg);
        showValidateIconOk(firstname_field_reg);
        validatedItems[4] = true;
    }else{
        hideValidateIcon(firstname_field_reg);
        validatedItems[4] = false;
    }
});
firstname_field_reg.addEventListener('blur', function(event){
    if(validatedItems[4] == false) {
        var parent = firstname_field_reg.parentNode;
        var node = document.createElement("p");
        node.classList.add("text-danger", "mt-2");
        var instructionMail = document.createTextNode("Een voornaam moet minstens 1 karakter en mag geen cijfers bevatten");
        node.appendChild(instructionMail);
        if (validatedItems[4] == false && parent.childNodes.length < 3) {
            parent.appendChild(node);
        }
    }
});
prepositions_field_reg.addEventListener('keyup', function(event){
        var parent = prepositions_field_reg.parentNode;
        if(parent.childNodes.length > 2) {
        parent.removeChild(parent.childNodes[2]);
    }
});
prepositions_field_reg.addEventListener('blur', function(event){
    if(onlyNumbers.test(prepositions_field_reg.value)){
        var parent = prepositions_field_reg.parentNode;
        var node = document.createElement("p");
        node.classList.add("text-danger", "mt-2");
        var instructionMail = document.createTextNode("Tussenvoegsels mogen geen cijfers bevatten");
        node.appendChild(instructionMail);
        if (validatedItems[5] == false && parent.childNodes.length < 3) {
            parent.appendChild(node);
        }
    }
});
lastname_field_reg.addEventListener('keyup', function(event){
    if(lastname_field_reg.value.length > 0 && onlyLetters.test(lastname_field_reg.value)){
        showValidateIcon(lastname_field_reg);
        showValidateIconOk(lastname_field_reg);
        validatedItems[6] = true;
    }else{
        hideValidateIcon(lastname_field_reg);
        validatedItems[6] = false;
    }
});
lastname_field_reg.addEventListener('blur', function(event){
    if(validatedItems[6] == false) {
        var parent = lastname_field_reg.parentNode;
        var node = document.createElement("p");
        node.classList.add("text-danger", "mt-2");
        var instructionMail = document.createTextNode("Een achternaam moet minstens 1 karakter en mag geen cijfers bevatten");
        node.appendChild(instructionMail);
        if (validatedItems[6] == false && parent.childNodes.length < 3) {
            parent.appendChild(node);
        }
    }
});
bsn_field_reg.addEventListener('keyup', function(event){
    console.log('ik word getarged keyup');
    if(bsn_nummer.test(bsn_field_reg.value)){
        showValidateIconOk(bsn_field_reg);
        validatedItems[7] = true;
    } else if(bsn_field_reg.value.length > 0){
        showValidateIcon(bsn_field_reg);
        validatedItems[7] = false;
    } else{
        hideValidateIcon(bsn_field_reg);
        validatedItems[7] = false;
    }
});
bsn_field_reg.addEventListener('blur', function(event){
    console.log('ik word getarged blur');
    if(validatedItems[7] == false) {
        var parent = bsn_field_reg.parentNode;
        var node = document.createElement("p");
        node.classList.add("text-danger", "mt-2");
        var instructionMail = document.createTextNode("Een geldig BSN nummer bestaat uit 8 of 9 cijfers");
        node.appendChild(instructionMail);
        if (validatedItems[7] == false && parent.childNodes.length < 3) {
            parent.appendChild(node);
        }
    }
});
//Business
companyname_field_reg.addEventListener('keyup', function(event){
    if(companyname_field_reg.value.length > 0){
        showValidateIcon(companyname_field_reg);
        showValidateIconOk(companyname_field_reg);
        validatedItems[8] = true;
    }else{
        hideValidateIcon(companyname_field_reg);
        validatedItems[8] = false;
    }
});
companyname_field_reg.addEventListener('blur', function(event){
    if(validatedItems[8] == false) {
        var parent = companyname_field_reg.parentNode;
        var node = document.createElement("p");
        node.classList.add("text-danger", "mt-2");
        var instructionMail = document.createTextNode("Een bedrijfsnaam moet minstens 1 karakter bevatten");
        node.appendChild(instructionMail);
        if (validatedItems[8] == false && parent.childNodes.length < 3) {
            parent.appendChild(node);
        }
    }
});
agree_field_reg.addEventListener('change', function(event){
    if(this.checked){
        validatedItems[9] = true;
    } else{
        validatedItems[9] = false;
    }
});

//Functions
function showValidateIcon(element){
    var idstring = String(element.id);
    var selectorString = "#" + idstring + " + i";
    document.querySelector(selectorString).classList.remove('hidden','text-success','fa-check');
    document.querySelector(selectorString).classList.add('fa-pencil-alt','text-muted');

}

function hideValidateIcon(element){
    var idstring = String(element.id);
    var selectorString = "#" + idstring + " + i";
    document.querySelector(selectorString).classList.add('hidden');
}

function showValidateIconOk(element){
    var parent = element.parentNode;
    var idstring = String(element.id);
    var selectorString = "#" + idstring + " + i";
    document.querySelector(selectorString).classList.remove('fa-pencil-alt','text-muted');
    document.querySelector(selectorString).classList.add('text-success','fa-check');
    if(parent.childNodes.length > 2) {
        parent.removeChild(parent.childNodes[2]);
    }
}