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
//var register_button = document.getElementById('do-register');
// register_button.disabled = true;

//private
var firstname_field_reg = document.getElementById("firstname-field-reg");
var prepositions_field_reg = document.getElementById("prepositions-field-reg");
var lastname_field_reg = document.getElementById("lastname-field-reg");
var birthdate_field_reg = document.getElementById("birthdate-field-reg");
var bsn_field_reg = document.getElementById("bsn-field-reg");
//Company
var companyname_field_reg = document.getElementById("companyname-field-reg");

//Helper vars
var validatedItems = [12];
var emailexists = false;

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
email_field_reg.addEventListener('keyup', function(event){
    emailexists = true;
    if(emailPattern.test(email_field_reg.value)){
        validatedItems[0] = true;
    } else if(email_field_reg.value == ""){
        hideValidateIcon(email_field_reg);
        validatedItems[0] = false;
    } else {
        showValidateIcon(email_field_reg);
        validatedItems[0] = false;
    }
});
email_field_reg.addEventListener('blur', function(){
    var parent = email_field_reg.parentNode;
    var node = document.createElement("p");
    node.classList.add("text-danger","mt-2");
    var instructionMail = document.createTextNode("Dit is geen geldig emailadres of het veld is leeg");
    node.appendChild(instructionMail);
    if(validatedItems[0] == false && parent.childNodes.length < 3) {
        parent.appendChild(node);
    }
    if(validatedItems[0] == true) {
        checkAddressExists();
        showValidateIconOk(email_field_reg);
    }
    checkAllInputs();
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
    checkAllInputs();
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
    checkAllInputs();
});
/*postcode_field_reg.addEventListener('keyup', function(event){
    postcode_field_reg.classList.remove('validate-field-error','validate-field-ok');
    housenumber_field_reg.classList.remove('validate-field-error','validate-field-ok');
    if(postcode_field_reg.value > 0){
        showValidateIcon(postcode_field_reg);
    }
});
housenumber_field_reg.addEventListener('keyup', function(event){
    postcode_field_reg.classList.remove('validate-field-error','validate-field-ok');
    housenumber_field_reg.classList.remove('validate-field-error','validate-field-ok');
    if(housenumber_field_reg.value > 0){
        showValidateIcon(housenumber_field_reg);
    }
});*/
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
    checkAllInputs();
});
agree_field_reg.addEventListener('change', function(){
    if(this.checked) {
        showValidateIcon(agree_field_reg);
        showValidateIconOk(agree_field_reg);
    } else{
        hideValidateIcon(agree_field_reg);
    }
    checkAllInputs();
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
    checkAllInputs();
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
    checkAllInputs();
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
    checkAllInputs();
});
birthdate_field_reg.addEventListener('keyup', function(){
    birthdate_String = birthdate_field_reg.value;
    birthdate_String = birthdate_String.replace("/","-");
    birthdate_String = birthdate_String.replace("/","-");
    console.log(birthdate_String);
    birthdate_Components = birthdate_String.split("-");
    var days = parseInt(birthdate_Components[0]);
    var months = parseInt(birthdate_Components[1]);
    var years = parseInt(birthdate_Components[2]);
    var date = new Date();
    var daysOk = days > 0 && days <32;
    console.log(daysOk);
    var monthsOk = months > 0 && months <13;
    console.log(monthsOk);
    var yearsOk = years > 1900 && years <= date.getFullYear() - 18;
    console.log(monthsOk);
    if(dateReg.test(birthdate_String) && daysOk && monthsOk && yearsOk){
        showValidateIconOk(birthdate_field_reg);
        validatedItems[7] = true;
    } else if(birthdate_field_reg.value.length > 0) {
        showValidateIcon(birthdate_field_reg);
        validatedItems[7] = false;
    } else{
       hideValidateIcon(birthdate_field_reg);
       validatedItems[7] = false;
   }
});
birthdate_field_reg.addEventListener('blur', function(){
    if(validatedItems[7] == false) {
        var parent = birthdate_field_reg.parentNode;
        var node = document.createElement("p");
        node.classList.add("text-danger", "mt-2");
        var instructionMail = document.createTextNode("Dit is geen geldige geboortedatum (dd/mm/yyyy) of de datum is niet ingevuld. Ook moet je minimaal 18 zijn.");
        node.appendChild(instructionMail);
        if (validatedItems[7] == false && parent.childNodes.length < 3) {
            parent.appendChild(node);
        }
    }
    checkAllInputs();
});
bsn_field_reg.addEventListener('keyup', function(event){
    console.log('ik word getarged keyup');
    if(bsn_nummer.test(bsn_field_reg.value)){
        showValidateIconOk(bsn_field_reg);
        validatedItems[8] = true;
    } else if(bsn_field_reg.value.length > 0){
        showValidateIcon(bsn_field_reg);
        validatedItems[8] = false;
    } else{
        hideValidateIcon(bsn_field_reg);
        validatedItems[8] = false;
    }
});
bsn_field_reg.addEventListener('blur', function(event){
    console.log('ik word getarged blur');
    if(validatedItems[8] == false) {
        var parent = bsn_field_reg.parentNode;
        var node = document.createElement("p");
        node.classList.add("text-danger", "mt-2");
        var instructionMail = document.createTextNode("Een geldig BSN nummer bestaat uit 8 of 9 cijfers");
        node.appendChild(instructionMail);
        if (validatedItems[8] == false && parent.childNodes.length < 3) {
            parent.appendChild(node);
        }
    }
    checkAllInputs();
});
//Business
companyname_field_reg.addEventListener('keyup', function(event){
    if(companyname_field_reg.value.length > 0){
        showValidateIcon(companyname_field_reg);
        showValidateIconOk(companyname_field_reg);
        validatedItems[9] = true;
    }else{
        hideValidateIcon(companyname_field_reg);
        validatedItems[9] = false;
    }
});
companyname_field_reg.addEventListener('blur', function(event){
    if(validatedItems[9] == false) {
        var parent = companyname_field_reg.parentNode;
        var node = document.createElement("p");
        node.classList.add("text-danger", "mt-2");
        var instructionMail = document.createTextNode("Een bedrijfsnaam moet minstens 1 karakter bevatten");
        node.appendChild(instructionMail);
        if (validatedItems[9] == false && parent.childNodes.length < 3) {
            parent.appendChild(node);
        }
    }
    checkAllInputs();
});
agree_field_reg.addEventListener('change', function(event){
    if(this.checked){
        validatedItems[10] = true;
    } else{
        validatedItems[10] = false;
    }
    checkAllInputs();
    console.log(validatedItems);
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

function checkAllInputs(){
    var aantalGoed = 0;
    for(i=0; i < validatedItems.length; i++){
        if(validatedItems[i] == true){
            aantalGoed++;
        }
    }
    if(firstname_field_reg.value!="" && aantalGoed == 10){
        register_button.disabled = false;
    } else if(companyname_field_reg.value!="" && aantalGoed == 7){
        register_button.disabled = false;
    }
    else{
        register_button.disabled = true;
    }
}

//Postcodeautocomplete
/*
postcode_field_reg.addEventListener('focusout', completeAddress);
housenumber_field_reg.addEventListener('focusout', completeAddress);
*/


function checkAddressExists(){
    let exists = "eerste waarde";
    let email = document.getElementById('email-field-reg').value;
    let formData = `email=${email}`;
    var request = new XMLHttpRequest();
    request.open('POST','http://localhost:8080/emailcheck', true);
    request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    request.setRequestHeader('Accept', 'application/json');
    request.send(formData); // zet om naar json als String
    request.onload = function() {
        let exists = request.responseText;
        console.log(exists);
        let mail = document.getElementById('email-field-reg');
        var parent = mail.parentNode;
        var node = document.createElement("p");
        node.classList.add("text-danger", "mt-2");
        instructionMail = document.createTextNode("Dit emailadres is al in gebruik")
        node.appendChild(instructionMail);
        if (request.responseText == "true" && parent.childNodes.length < 3){
            hideValidateIcon(document.getElementById('email-field-reg'));
            parent.appendChild(node);
        } else{
            if(parent.childNodes.length > 2) {
                parent.removeChild(parent.childNodes[2]);
            }
        }
    }
}

function completeAddress(){
    let regex = new RegExp(/^[1-9][0-9]{3}[\s]?[A-Za-z]{2}$/i);

    let postcode = postcode_field_reg.value;
    let housenumber = housenumber_field_reg.value;

    // als postcode een valide postcode is nummer niet leeg, dan

    if(regex.test(postcode) && housenumber){
        let parent = city_field_reg.parentNode;

        //Omzetten JSON naar String, moet backtick zijn
        let formData = `postcode=${postcode}&nr=${housenumber}`;

        //FF loggen dat input valide is

        //Start AJAX request
        var request = new XMLHttpRequest();
        request.open('POST','http://localhost:8080/postcode', true);
        // om de server te laten weten wat de vorm is: form data in dit geval
        request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        // de vorm waarin we data terug willen hebben
        request.setRequestHeader('Accept', 'application/json');
        request.send(formData); // zet om naar json als String

        request.onload = function() {
            if (request.status != 200) { // analyze HTTP status of the response
                validatedItems[11] = false;
                postcode_field_reg.classList.add('validate-field-error');
                housenumber_field_reg.classList.add('validate-field-error');

//                        alert(`Error ${request.status}: ${request.statusText}`);
                // velden legen
                document.getElementById('city-field-reg').value = ''; // zonder validatie
                document.getElementById('street-field-reg').value = ''; // zonder validatie

                // error style geven
                var node = document.createElement("p");
                node.classList.add("text-danger", "mt-2");
                var instructionMail = document.createTextNode("Onbekende combinatie postcode/huisnummer");
                node.appendChild(instructionMail);
                if (parent.childNodes.length < 3) {
                    parent.appendChild(node);
                }


            } else { // show the result
                showValidateIconOk(postcode_field_reg);
                showValidateIconOk(housenumber_field_reg);
                validatedItems[11] = true;
                console.log(`Done, got ${request.response.length} bytes`);
                // haal de data uit de request
                let addressPart = JSON.parse(request.response); // de data is in ASCII format, nu nog naar object omzetten
                // velden vullen
                document.getElementById('city-field-reg').value = addressPart.city; // zonder validatie
                document.getElementById('street-field-reg').value = addressPart.street; // zonder validatie

                // error style weghalen
                city_field_reg.classList.add('validate-field-ok');
                street_field_reg.classList.add('validate-field-ok');

                if(parent.childNodes.length > 2) {
                    parent.removeChild(parent.childNodes[2]);
                }
            }
        };
    }
    checkAllInputs();
}