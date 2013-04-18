$(function(){
	
	var account_menu_active = false;
	$('#account').click(function(){
		
		if(account_menu_active == false){
			$('#account_menu').addClass('active');
			account_menu_active = true; 
		}else {
			$('#account_menu').removeClass('active');
			account_menu_active = false;
		}
		
	});
	
});//end of doc ready