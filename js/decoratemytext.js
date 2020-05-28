//alert("Hello, world!");

function decorate(){
    //alert("Hello, world!");
    var text = document.getElementById("text");   

    if(text.style.fontSize == ""){
        text.style.fontSize = "12pt";
        //text.style.fontSize = "24pt";
        //text.style.fontSize = "4em";
    }
    var fontSize = parseInt(text.style.fontSize) + 2;
    
    text.style.fontSize = fontSize+"pt";
}


function bling(){
    //var s = 5+'3'*2+"4"/2;
    var s = "6" === 6;
    alert(s);

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