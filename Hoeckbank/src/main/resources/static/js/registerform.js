document.addEventListener("DOMContentLoaded", function() {
    var radios = document.getElementsByClassName("accountradio");
    for(var i = 0; i < radios.length; i++){
        radios[i].onclick = function (){
            var e = this.getAttribute("value");
            if(e === "bedrijf"){
            document.getElementById("register-welcome").innerHTML = "Geef uw bedrijfsgegevens";
            document.getElementById("company-register-fields").classList.remove('d-none');
            document.getElementById("private-register-fields").classList.add('d-none');
            document.getElementById("address-icon").classList.remove('fa-home');
            document.getElementById("address-icon").classList.add('fa-building');
            document.getElementById("register-field-city").innerHTML = "Plaats";
            } else{
                document.getElementById("register-welcome").innerHTML = "Geef uw persoonsgegevens";
                document.getElementById("company-register-fields").classList.add('d-none');
                document.getElementById("private-register-fields").classList.remove('d-none');
                document.getElementById("address-icon").classList.remove('fa-building');
                document.getElementById("address-icon").classList.add('fa-home');
                document.getElementById("register-field-city").innerHTML = "Woonplaats";
            }
        }
    }
 });