( function( $ ) { /* Browse page - advanced search toggle */
    $(document).ready(function() {
    
	    $('.advanced-search .toggle').toggle( function(){
		    $('.advanced-search #form_advanced_search').slideDown();
		    $(this).addClass('rounded-no-bottom toggle-opened');
		},
		function(){
		    var target = $(this);
		    $('.advanced-search #form_advanced_search').slideUp( 500, function(){ 
			    target.removeClass('rounded-no-bottom toggle-opened');
			});
		});
     
	});
})(jQuery);
