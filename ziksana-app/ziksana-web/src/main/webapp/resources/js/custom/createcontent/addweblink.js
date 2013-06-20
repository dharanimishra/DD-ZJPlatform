// JavaScript Document
$(document).ready(function(e) {

	weblink_row_count = 1;

	$(".adlink").click(function(e) {
		
		weblink_container = $('#web_link_container');
		weblink_div = '<div class="weblink_row">';
		weblink_div += weblink_container.find('div.weblink_row').first().html();
		weblink_div += '</div>';
				
		weblink_container.append(weblink_div);
		added_weblink_div = weblink_container.find('div.weblink_row').last();
		

		added_weblink_div.find('.editdetailsweblink').click(function(){
			$(this).parents('div.weblink_row').find('.editslide').toggle();
			return false;
		});
		
		
		
	   });
	   
	   
$(".editdetailsweblink").click(function(){
	$(this).parents('div.weblink_row').find('.editslide').toggle();
});



}); // end of doc ready