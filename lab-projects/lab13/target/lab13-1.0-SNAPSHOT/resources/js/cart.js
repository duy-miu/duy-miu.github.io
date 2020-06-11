window.onload = function () {
    var buttons = document.getElementsByClassName("button");

    for(var i=0;i<buttons.length;i++){
        buttons[i].onclick = function () {
            var id = this.id.replace("btnAdd_","");
            var quantity = document.getElementById("quantity_"+id).value;
            if (quantity == ""){
                quantity = 1;
            }
            document.location = 'home?page=cart&id='+id+'&quantity='+quantity;
        };
    }
}