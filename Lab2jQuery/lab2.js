$('document').ready(function() {
    
    var availableTags = ['Andy', 'Andrew', 'Bob', 'Bobby', 'Chuck', 'Charles', 'David']

    $('#search').autocomplete({
    	source: availableTags
    });
});