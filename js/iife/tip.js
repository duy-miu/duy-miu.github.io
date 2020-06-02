

(function iife(){     
    "use strict";  

    function calCalc(){     
        
        var subtotal = parseFloat(document.getElementById("subtotal").value);
        var tip = parseFloat(document.getElementById("tip").value);
        if(subtotal > 0 || tip > 0 ){
            var total = subtotal+subtotal*tip/100;
            var result = document.getElementById("total");
            result.innerHTML=total.toFixed(2);
        }else{
            alert("Wrong input");
        }
       
    }

    var btn = document.getElementById("btn");
    btn.addEventListener("click", calCalc);
})(this);
