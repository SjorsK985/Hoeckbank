function validationError(){
    var userName = document.loginForm.gebruiker_naam.value;
    var password = document.loginForm.gebruiker_paswoord.value;

    //RK: reset error berichten voor het geval de gebruik al errors heeft
    document.getElementById("passwordError").innerHTML = "";
    document.getElementById("userNameError").innerHTML = "";

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
    return true

}
