$('document').ready(function() {
    
    var availableTags = ['Andy', 'Andrew', 'Bob', 'Bobby', 'Chuck', 'Charles', 'David']

    $('div').mouseenter(function() {
        $('div').fadeTo('fast',1);
    });
    $('div').mouseleave(function() {
        $('div').fadeTo('fast',0.5);
    });

    $('#search').autocomplete({
    	source: availableTags
    });
});