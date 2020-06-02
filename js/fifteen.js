(function iife(){
    "use strict";

    $(function() {
        init();
        $("#shufflebutton").click(shuffle);
    });

    function init() {
        $('#puzzlearea').children('div').each(function(i,cell){

            // calculate x and y for this piece
            var x = ((i % 4) * 100) ;
            var y = (Math.floor(i / 4) * 100) ;

            // set basic style and background            
            $(cell).addClass('puzzlepiece');
            $(cell).css({
                'left': x + 'px',
                'top': y + 'px',
                'backgroundImage': 'url("../img/puzzle/background.jpg")',
                'backgroundPosition': -x + 'px ' + (-y) + 'px'
            });
            
            // store x and y for later
            $(cell).x = x;
            $(cell).y = y; 
        });        
    }

    function shuffle() {
        var divs = $('#puzzlearea').children('div');
        
        // initialize each piece
        var array = randomArrayShuffle();
        for (var i=0; i< array.length; i++) {
            var cell = divs[array[i]];
            
            // calculate x and y for this piece
            var x = ((i % 4) * 100) ;
            var y = (Math.floor(i / 4) * 100) ;

            // set basic style and background
            $(cell).addClass('puzzlepiece');
            $(cell).css({
                'left': x + 'px',
                'top': y + 'px',
                'backgroundImage': 'url("../img/puzzle/background.jpg")',
                'backgroundPosition': -x + 'px ' + (-y) + 'px'
            });
            
            // store x and y for later
            $(cell).x = x;
            $(cell).y = y; 
        }        
    }

    function randomArrayShuffle() {
        var array=[0,1,2,3,4,5,6,7,8,9,10,11,12,13,14];
        array.sort(() => Math.random() - 0.5);
        return array;
    }

})();