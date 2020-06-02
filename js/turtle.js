(function iife(){
    "use strict";

    $(function() {
        $(document).scroll(turtle);
        // in case window height is initially taller than animals
        turtle();
    });

    function turtle() {
        while ($(window).scrollTop() + $(window).height() >= $(document).height())
        {
            $(document.body).append($('<div>').addClass('turtle'));
        }
    }
})();