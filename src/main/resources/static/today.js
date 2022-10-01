
function today() {
    var today = new Date();
    today.setDate(today.getDate());
    var yyyy = today.getFullYear();
    var mm = ("0"+(today.getMonth()+1));
    mm.slice(-2);
    var dd = (today.getDate());
    console.log(mm);
    console.log(dd);
    document.getElementById("date").value=yyyy+'-'+mm+'-'+dd;
}
//前月の月初と月末を初期値にいれる



