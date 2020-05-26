function calcTip(){
    try{
        var subtotal = eval(document.getElementById("subtotal").value);
        var tip = eval(document.getElementById("tip").value);
        if(subtotal > 0 || tip > 0 ){
            var total = subtotal+subtotal*tip/100;
            //console.log("subtotal= " + subtotal);
            //console.log("tip= " + tip);
            var result = document.getElementById("total");
            //console.log("result= " + total);
            result.innerHTML=total.toFixed(2);
        }else{
            alert("Wrong input");
        }
    }catch{
        alert("Wrong input");
    }
}