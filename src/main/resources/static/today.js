
function today() {
    var today = new Date();
    today.setDate(today.getDate());
    var yyyy = today.getFullYear();
    var mm = ("0"+(today.getMonth()+1));
    mm = mm.slice(-2);
    var dd = ("0" + today.getDate()).slice(-2);

    document.getElementById("date").value=yyyy+'-'+mm+'-'+dd;
}


