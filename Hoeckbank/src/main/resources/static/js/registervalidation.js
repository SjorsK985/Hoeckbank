//DOM elements
//generic
var email_field_reg = document.getElementById('email-field-reg');
var password_field_reg = document.getElementById("password-field-reg");
var passwordconfirm_field_reg = document.getElementById("passwordconfirm-field-reg");
var postcode_field_reg = document.getElementById("postcode-field-reg");
var housenumber_field_reg = document.getElementById("housenumber-field-reg");
var street_field_reg = document.getElementById("street-field-reg");
var city_field_reg = document.getElementById("city-field-reg");
var phone_field_reg = document.getElementById("phone-field-reg");
var agree_field_reg = document.querySelector("input[name=agree]");
var do_register_button = document.getElementById("do-register");
do_register_button.disabled=true;
document.onload = checkAllInputs();

//private
var firstname_field_reg = document.getElementById("firstname-field-reg");
var prepositions_field_reg = document.getElementById("prepositions-field-reg");
var lastname_field_reg = document.getElementById("lastname-field-reg");
var birthdate_field_reg = document.getElementById("birthdate-field-reg");
var bsn_field_reg = document.getElementById("bsn-field-reg");
//Company
var companyname_field_reg = document.getElementById("companyname-field-reg");

//Regex patterns
var emailPattern = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
var passwordPattern = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{5,20}$/;
var vast_nummer = /^(((0)[1-9]{2}[0-9][-]?[1-9][0-9]{5})|((\\+31|0|0031)[1-9][0-9][-]?[1-9][0-9]{6}))$/;
var mobiel_nummer = /^(((\\+31|0|0031)6){1}[1-9]{1}[0-9]{7})$/i;
var bsn_nummer = /^[1-9]{8,9}$/;
var onlyLetters = /^[a-zA-Z]+$/;
var onlyNumbers = /^[0-9]+$/;
var dateReg = /^(0?[1-9]|[12][0-9]|3[01])[\/\-](0?[1-9]|1[012])[\/\-]\d{4}$/;

//EventListeners general
//Event Listeners
email_field_reg.addEventListener('keyup', function () {keyUpValidation(email_field_reg, emailPattern);});
email_field_reg.addEventListener('blur', function(){blurValidation(email_field_reg, emailPattern,'dit is geen geldig emailadres');checkEmailExists();checkAllInputs();});
password_field_reg.addEventListener('keyup', function(){keyUpValidation(password_field_reg, passwordPattern);});
password_field_reg.addEventListener('blur',function() {blurValidation(password_field_reg, passwordPattern, 'het wachtwoord moet minmaal 5 karakters lang zijn en een hoofdletter, kleine letter en cijfer bevatten');checkAllInputs()});
passwordconfirm_field_reg.addEventListener('keyup', function() {keyUpEqual(passwordconfirm_field_reg, password_field_reg);});
passwordconfirm_field_reg.addEventListener('blur', function () {blurEqual(passwordconfirm_field_reg, password_field_reg, 'de wachtwoorden komen niet overeen');checkAllInputs()});
firstname_field_reg.addEventListener('keyup', function(){keyUpValidation(this, onlyLetters);});
firstname_field_reg.addEventListener('blur', function(){blurValidation(firstname_field_reg, onlyLetters, "een naam mag alleen letters bevatten");checkAllInputs()});
prepositions_field_reg.addEventListener('keyup', function () {keyUpValidation(prepositions_field_reg, onlyLettersOrNone);});
lastname_field_reg.addEventListener('keyup', function(){keyUpValidation(lastname_field_reg, onlyLetters);});
lastname_field_reg.addEventListener('blur', function () {blurValidation(lastname_field_reg, onlyLetters, "een naam mag alleen letters bevatten");checkAllInputs()});
birthdate_field_reg.addEventListener('keyup', function () {keyUpValidation(birthdate_field_reg, dateReg);});
birthdate_field_reg.addEventListener('blur', function () {blurValidation(birthdate_field_reg, dateReg, "dit is geen geldige datum");checkAllInputs()});
companyname_field_reg.addEventListener('keyup', function(){keyUpValidation(companyname_field_reg, notNoting);});
companyname_field_reg.addEventListener('blur', function () {blurValidation(companyname_field_reg, notNoting, "een bedrijfsnaam moet minstens een karakter bevatten");checkAllInputs()});
phone_field_reg.addEventListener('keyup', function () {keyUpValidation(phone_field_reg, mobiel_nummer);});
phone_field_reg.addEventListener('blur', function(){blurValidation(phone_field_reg, mobiel_nummer, "dit is geen geldig telefoonnummer");checkAllInputs()});
phone_field_reg.addEventListener('keyup', function () {keyUpValidation(phone_field_reg, vast_nummer)});
phone_field_reg.addEventListener('blur', function(){blurValidation(phone_field_reg, vast_nummer, "dit is geen geldig telefoonnummer");checkAllInputs()});
bsn_field_reg.addEventListener('blur', function(){
    blurValidation(bsn_field_reg, bsn_nummer,'dit is geen geldig bsn-nummer');
});
bsn_field_reg.addEventListener('keyup', function () {
    keyUpValidation(bsn_field_reg, bsn_nummer);
});

postcode_field_reg.addEventListener('keyup', function(){
    if(street_field_reg.childNodes > 1){
        street_field_reg.removeChild(street_field_reg.childNodes[1]);
    }
    checkAllInputs()
});
housenumber_field_reg.addEventListener('keyup', function(){
    if(street_field_reg.childNodes > 1){
        street_field_reg.removeChild(street_field_reg.childNodes[1]);
    }
    checkAllInputs()
});
postcode_field_reg.addEventListener('blur', function () {
    if(housenumber_field_reg.value.length > 0){
        completeAddress();
    }
    checkAllInputs()
});
housenumber_field_reg.addEventListener('blur', function (){
    if(postcode_field_reg.value.length > 0){
        completeAddress();
    }
    checkAllInputs()
});
agree_field_reg.addEventListener('change', function(){
    if(this.checked) {
        agree_field_reg.classList.add('validate-ok');
    } else{
        agree_field_reg.classList.remove('validate-ok');
    }
    checkAllInputs();
});
//functions
function keyUpValidation(element, regex){
    let parent = element.parentNode;
    if(parent.childNodes.length > 1) {
        parent.removeChild(parent.childNodes[1]);
    }
    if(element.value.length > 0){
        element.classList.remove('validate-ok', 'validate-error');
        element.classList.add('validate-getinput');
    } else{
        element.classList.remove('validate-getinput', 'validate-error');
    }
    if(element.value.length > 0 && regex.test(element.value)){
        element.classList.remove('validate-getinput');
        element.classList.add('validate-ok');
    }
    console.log(element.value);
}

function blurValidation(element, regex, msg){
    if(!regex.test(element.value) && element.value.length > 0){
        element.classList.add('validate-error');
        let parent = element.parentNode;
        let node = document.createElement("p");
        node.classList.add("text-danger","mt-2");
        let warning = document.createTextNode(msg);
        node.appendChild(warning)
        if(parent.childNodes.length < 2) {
            parent.appendChild(node);
        }
    }
}

function keyUpEqual(element1, element2) {
    let parent = element1.parentNode;
    if (parent.childNodes.length > 1) {
        parent.removeChild(parent.childNodes[1]);
    }
    if (passwordconfirm_field_reg.value > 0) {
        element1.classList.remove('validate-ok', 'validate-error');
        element1.classList.add('validate-getinput');
    } else {
        element1.classList.remove('validate-getinput', 'validate-error');
    }
    if (element1.value == element2.value) {
        element1.classList.remove('validate-getinput');
        element1.classList.add('validate-ok');
    }
}

function blurEqual(element1, element2, msg){
    if(element1.value != element2.value && element1.value.length > 0 && element2.value.length > 0){
        element1.classList.add('validate-error');
        let parent = element1.parentNode;
        let node = document.createElement("p");
        node.classList.add("text-danger","mt-2");
        let warning = document.createTextNode(msg);
        node.appendChild(warning)
        if(parent.childNodes.length < 2) {
            parent.appendChild(node);
        }
    }
}

function checkAllInputs(){
    let validatedItems = document.getElementsByClassName("validate-ok");
    console.log(validatedItems);
    console.log(validatedItems.length);
    if(validatedItems.length  >= 10){
        do_register_button.disabled = false;
    } else{
        do_register_button.disabled = true;
    }
}

//AJAX functions
function checkEmailExists(){
    let exists = false;
    let email = document.getElementById('email-field-reg').value;
    let formData = `email=${email}`;
    var request = new XMLHttpRequest();
    request.open('POST','http://localhost:8080/emailcheck', true);
    request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    request.setRequestHeader('Accept', 'application/json');
    request.send(formData); // zet om naar json als String
    request.onload = function() {
        let exists = request.responseText;
        console.log("exist is "+  exists);
        if(exists == "true"){
            console.log("email exists");
            email_field_reg.classList.remove('validate-ok','validate-getinput');
            email_field_reg.classList.add('validate-error');
            let msg = "dit e-mailadres is al in gebruik";
            let parent = email_field_reg.parentNode;
            let node = document.createElement("p");
            node.classList.add("text-danger","mt-2");
            let warning = document.createTextNode(msg);
            node.appendChild(warning)
            if(parent.childNodes.length < 2) {
                parent.appendChild(node);
            }
        }
    }
}

function completeAddress() {
    let regex = new RegExp(/^[1-9][0-9]{3}[\s]?[A-Za-z]{2}$/i);

    let postcode = postcode_field_reg.value;
    let housenumber = housenumber_field_reg.value;

    // als postcode een valide postcode is nummer niet leeg, dan

    if (regex.test(postcode) && housenumber) {
        let parent = city_field_reg.parentNode;
        let formData = `postcode=${postcode}&housenumber=${housenumber}`;
        var request = new XMLHttpRequest();
        request.open('POST', 'http://localhost:8080/postcodecheck', true);
        request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        request.setRequestHeader('Accept', 'application/json');
        request.send(formData); // zet om naar json als String
        request.onload = function () {
            if (request.status != 200) {
                postcode_field_reg.classList.add('validate-error');
                housenumber_field_reg.classList.add('validate-error');
                city_field_reg.value = ''; // zonder validatie
                street_field_reg.value = ''; // zonder validatie
                city_field_reg.classList.remove('validate-field-ok');
                city_field_reg.classList.add('validate-field-error');
                street_field_reg.classList.remove('validate-field-ok');
                street_field_reg.classList.add('validate-field-error');
                // error style geven
                var node = document.createElement("p");
                node.classList.add("text-danger", "mt-2");
                var instructionMail = document.createTextNode("Onbekende combinatie postcode/huisnummer");
                node.appendChild(instructionMail);
                if (parent.childNodes.length < 3) {
                    parent.appendChild(node);
                }
            } else {
                postcode_field_reg.classList.remove('validate-error');
                housenumber_field_reg.classList.remove('validate-error');
                postcode_field_reg.classList.add('validate-ok');
                housenumber_field_reg.classList.add('validate-ok');
                console.log(`Done, got ${request.response.length} bytes`);
                // haal de data uit de request
                let postcode = JSON.parse(request.response); // de data is in ASCII format, nu nog naar object omzetten
                console.log(request.responseText);
                // velden vullen
                city_field_reg.value = postcode.stad; // zonder validatie
                city_field_reg.classList.add('validate-field-ok');
                street_field_reg.value = postcode.straat; // zonder validatie
                street_field_reg.classList.add('validate-field-ok');
                if (parent.childNodes.length > 2) {
                    parent.removeChild(parent.childNodes[2]);
                }
            }
        }
    }
}