(function iife(){     
    "use strict";  

    var ballVelocity = 0;
    $(function() {
        // start the ball in the top middle of the screen
        $("#ball").css({
            'top': '0px',
            'left': $(window).width() / 2 + 'px'
        });
        // make frame of animation
        setInterval(update, 20);
    });

    function update() {
        //apply a "gravity" to the ball and increase its downward speed by 1.
        ballVelocity += 1;

        //If the ball hits the ground, make it "bounce" up at 90% the velocity it previously had.
        if (parseInt($("#ball").css('top')) > $(window).height()) {
            ballVelocity *= -0.9;
        }
        //apply gravity and make the ball bounce when it hits the bottom of the window.
        $("#ball").css('top', function(idx, old) {
            return parseInt(old) + ballVelocity + 'px';
        });
    }
})(this);