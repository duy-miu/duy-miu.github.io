(function iife(){     
    "use strict";  

    function decorate(){
        //alert("Hello, world!");
        var text = document.getElementById("text");   

        if(text.style.fontSize == ""){
            text.style.fontSize = "12pt";
        }
        var fontSize = parseInt(text.style.fontSize) + 2;
        
        text.style.fontSize = fontSize+"pt";
    }

    function decorateText(){
        setInterval(decorate, 500);
    }


    function bling(){
        //alert("Bling");
        var checkbox = document.getElementById("checkbox");
        var text = document.getElementById("text");
        if(checkbox.checked){
            text.style.fontWeight="bold";
            text.style.textDecoration = "underline";
            text.style.color="green";

        }else{
            text.style.fontWeight="normal";
            text.style.textDecoration = "none";
            text.style.color="black";
        }
    }

    var button = document.getElementById("button");
    button.addEventListener("click", decorateText);

    var checkbox = document.getElementById("checkbox");
    checkbox.addEventListener("click", bling);

})(this);