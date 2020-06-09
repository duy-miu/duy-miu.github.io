window.onload = function () {
    var remember = document.getElementById("remember");
    var username = document.getElementById("username");
    var password = document.getElementById("password");
    var login = document.getElementById("login");

    //try to create a cookie
    createCookie("cs472","Test", 30);

    var cookie = document.cookie;
    console.log(cookie);

    remember.onchange = function () {
        if(this.checked){
            //fill values
            document.getElementById("username").value = readCookie("username");
            document.getElementById("password").value = readCookie("password");
        }else{
            //erase
            document.getElementById("username").value = "";
            document.getElementById("password").value = "";
        }
    }

    /*
    login.onclick = function () {
        if(remember.checked){
            createCookie("username",username.value,30);
            createCookie("password",password.value,30);
        }else{
            createCookie("username",'',1);
            createCookie("password",'',1);
        }
    };*/




    function  readCookie(name) {
        console.log("Reading cookie " +name);
        var nameSG = name + "=";
        var nuller = '';
        if (document.cookie.indexOf(nameSG) == -1)
            return nuller;

        var ca = document.cookie.split(';');
        for(var i=0; i<ca.length; i++) {
            var c = ca[i];
            while (c.charAt(0)==' ') c = c.substring(1,c.length);
            if (c.indexOf(nameSG) == 0) {
                return c.substring(nameSG.length,c.length);
            }
        }
        return null;
    }

    function createCookie(name,value,days) {
        var days = 1;
        if (days) {
            var date = new Date();
            date.setTime(date.getTime()+(days*24*60*60*1000));
            var expires = "; expires="+date.toGMTString();
        }
        else {
            var expires = "";
        }
        document.cookie = name+"="+value+expires+"; path=/";
    }
}