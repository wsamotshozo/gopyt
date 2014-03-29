$(document).ready(function() {
	setTimeout(function() {
		$('#accordionnewpage > li > a.expanded + ul').slideToggle('fast');
		$('#accordionnewpage > li > a').click(function() {
			$('#accordionnewpage > li > a.expanded').not(this).toggleClass('expanded').toggleClass('').parent().find('> ul').slideToggle('fast');
			$(this).toggleClass('expanded').toggleClass('').parent().find('> ul').slideToggle('fast');
		});
	}, 250);	
	
//	$(".LeftPanelContainer").height($(".BodyAreaContainer").height() - 36);
	
});