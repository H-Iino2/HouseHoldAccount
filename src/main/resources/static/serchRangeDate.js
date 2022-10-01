get();

function get() {
  var today = new Date;
  //前月
  today.setMonth(today.getMonth()-1);
  var yyyy = today.getFullYear();
  var lastMonth = (today.getMonth()+1);
  var lastDate = new Date(yyyy,lastMonth,0);
  var mm = ("00"+lastMonth).slice(-2);
  var maxdd = lastDate.getDate();
  
  var mindd = ("00" + lastDate.getDate(lastDate.setDate(1))).slice(-2);
  
  var firstDayFormat = yyyy + '-' + mm + '-' + mindd;
  var maxDayFormat = yyyy + '-' + mm + '-' + maxdd;
  
  document.getElementById("selectFirstDate").value = firstDayFormat;
  document.getElementById("selectLastDate").value = maxDayFormat;   
}