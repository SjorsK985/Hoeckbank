function validationError() {

    var submit = true;
    var form_tag_list = [document.transactie_form.bedrag.value, document.transactie_form.naam_ontvanger.value,
        document.transactie_form.rekeningnummer_ontvanger.value, document.transactie_form.omschrijving.value ];
    var error_elements = ["bedrag_error", "naam_ontvanger_error", "rekeningnummer_ontvanger_error", "omschrijving_error" ];
    var error_strings = ["Bedrag", "Naam ontvanger", "Rekening nummer", "Omschrijving"]

    //Haal error berichten weg voor het geval er nog errors berichten stonden
    for (let i = 0; i < error_elements.length; i++) {
        document.getElementById(error_elements[i]).innerHTML = " ";
    }
    //Geef error voor velden die leeg zijn
    for (let i = 0; i < form_tag_list.length; i++) {
        if(form_tag_list[i] === ""){
            document.getElementById(error_elements[i]).innerHTML = error_strings[i] + " mag niet leeg zijn";
            submit = false;
        }
    }
    return submit;

}