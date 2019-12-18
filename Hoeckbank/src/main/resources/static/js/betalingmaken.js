function validationError(){

    var bedrag = document.loginForm.bedrag.value;
    var naam_ontvanger = document.loginForm.naam_ontvanger.value;
    var rekeningnummer_ontvanger = document.loginForm.rekeningnummer_ontvanger.value;
    var omschrijving = document.loginForm.omschrijving.value;

    //RK: reset error berichten voor het geval de gebruik al errors heeft
    document.getElementById("bedrag_error").innerHTML = "";
    document.getElementById("naam_ontvanger_error").innerHTML = "";
    document.getElementById("rekeningnummer_ontvanger_error").innerHTML = "";
    document.getElementById("omschrijving_error").innerHTML = "";

    var error_list = ["Bedrag", "Naam ontvanger", "Rekeningnummmer ontvanger", "omschrijving"];

    // Todo: Maak Array van veld elementen?

    if(password === "" && userName === ""){
        document.getElementById("userNameError").innerHTML = "Gebruikersnaam mag niet leeg zijn";
        document.getElementById("passwordError").innerHTML = "Wachtwoord mag niet leeg zijn";
        return false;
    }

    if(userName === ""){
        document.getElementById("userNameError").innerHTML = "Gebruikersnaam mag niet leeg zijn";
        return false;
    }

    if(password === ""){
        document.getElementById("passwordError").innerHTML = "Wachtwoord mag niet leeg zijn";
        return false;
    }
    //return true

}
