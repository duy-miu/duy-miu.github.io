(function iife(){
    "use strict";

    $(function() {
        $(document).keypress(cheer);
    });
    
    function cheer(e) {

        //convert character should be in upper case, followed by an exclamation point
        $("<li>").text(String.fromCharCode(e.which).toUpperCase() + "!").appendTo($("#cheers"));

        // remove itself from the page after two seconds (i.e., 2000 milliseconds).
        setTimeout(removeCheer, 2000);
    }
    
    function removeCheer() {
        $("#cheers li").first().remove();
    }
})();