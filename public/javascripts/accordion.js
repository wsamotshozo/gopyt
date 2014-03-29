$(document).ready(function() {
	setTimeout(function() {
		$('#accordionnew > li > a.expanded + ul').slideToggle('fast');
		$('#accordionnew > li > a').click(function() {
			$('#accordionnew > li > a.expanded').not(this).toggleClass('expanded').toggleClass('').parent().find('> ul').slideToggle('fast');
			$(this).toggleClass('expanded').toggleClass('').parent().find('> ul').slideToggle('fast');
		});
	}, 250);	
	
//	$(".LeftPanelContainer").height($(".BodyAreaContainer").height() - 36);
	
});