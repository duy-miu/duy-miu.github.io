"use strict";

window.onload = function() {

    var text = document.getElementById("text");
    var btnStart = document.getElementById("btnStart");
    var btnStop = document.getElementById("btnStop");
    var ddlAnimation = document.getElementById("ddlAnimation");
    var ddlSize = document.getElementById("ddlSize");
    var chkTurbo = document.getElementById("chkTurbo");

    var animationArr;
    var animationStr;
    var timerArr;
    var len;
    var isStarted = false;
    var delay = 250;

    //initialize
    btnStart.disabled = false;
    btnStop.disabled = true;
    clear();


    ddlAnimation.onchange = function(){
        ddlAnimation.disabled = true;
        if(isStarted){
            btnStart.disabled = false;
        }
        btnStop.disabled = true;               
    }

    ddlSize.onchange = function(){
        ddlSize.disabled = true;
        if(isStarted){
            btnStart.disabled = false;
        }
        btnStop.disabled = true;  
    }

    chkTurbo.onchange = function(){
        
        //speed
        if(chkTurbo.checked){
            delay = 50;
        }else{
            delay = 250
        }

        //process
        if(isStarted){
            //clear previous timers
            for(let i=0; i<len;i++){ 
                clearInterval(timerArr[i]);
            }   
            //create new timers
            let i = 0;
            for(let animationItem of animationArr){ 
                timerArr[i] = setInterval(act, delay, animationItem);
                i++;
                rest();
            }
        }        
    }
    
    btnStart.onclick = function() {   
        if(ddlAnimation.value !== "Blank"){ 
            //alert("Start");    

            isStarted = true;       

            //animation
            animationStr = ANIMATIONS[""+ddlAnimation.value];
            animationArr = animationStr.split("=====\n");    
            len = animationArr.length;
            timerArr = new Array();

            ddlAnimation.disabled = true;
            btnStart.disabled = true;
            btnStop.disabled = false;
            clear();

            //size
            resize();

            

            //process
            let i = 0;
            for(let animationItem of animationArr){ 
                timerArr[i] = setInterval(act, delay, animationItem);
                i++;
                rest();
            }
        }else{
            alert("Animation is blank!")
        }
    };

    btnStop.onclick = function() {
        //alert("Stop");
        isStarted = false;

        for(let i=0; i<len;i++){ 
            clearInterval(timerArr[i]);
        }    
        timerArr = null;   
        setTimeout (act, 1000, animationStr);

        ddlAnimation.disabled = false;
        ddlSize.disabled = false;
        chkTurbo.disabled = false;
        btnStart.disabled = false;        
        btnStop.disabled = true;
    };
};

function act(val){       
    text.innerHTML = val;        
}

function rest(){    
    for(let i=0;i<100000;i++){
        clear();
    }
}

function clear(){
    text.innerHTML = ""; 
}

function resize(){
    text.style.fontSize = ddlSize.value;
}
