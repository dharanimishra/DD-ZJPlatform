
var URLPATH = 'http://localhost:8080/Generic_9dec/'; //Change it according to where you host the file
$(function(){

	$('[data-launcher]').click(function(){
		launchpage = getCookie("launchpage"); //get launch page location from the cookie
		//alert(launchpage);
		
		//initiate a fancybox with the url of the launchpage.
		$.fancybox({
			'width': '85%',
			'height': '450',
			'autoScale': true,
			'transitionIn': 'fade',
			'transitionOut': 'fade',
			'type': 'iframe',
			'href': URLPATH + launchpage,
			'showCloseButton': false,
			'onComplete': add_ziklogo_and_close_button()
			
		});
		
		return false; 
	});

}); //End of document ready


//Common Application Functions:

function getCookie(c_name)
{
var i,x,y,ARRcookies=document.cookie.split(";");
for (i=0;i<ARRcookies.length;i++)
  {
  x=ARRcookies[i].substr(0,ARRcookies[i].indexOf("="));
  y=ARRcookies[i].substr(ARRcookies[i].indexOf("=")+1);
  x=x.replace(/^\s+|\s+$/g,"");
  if (x==c_name)
    {
    return unescape(y);
    }
  }
}

function add_ziklogo_and_close_button(){
	logo_html = '<img id="zik_fnacy_logo" width="120" height="120" style="background: none repeat scroll 0 0 white; border-radius: 49px 5px 49px 0; box-shadow: 0 0 10px #000000; cursor: pointer; left: -60px; top: -25px; margin-bottom: -95px; padding: 5px 35px 15px 15px; position: absolute; z-index: 10000;" alt="" src="'+URLPATH+'images/logo-trans.gif">';
	$('#zik_fnacy_logo, #custom_fancybox_close').remove(); //initially remove the logo if exists.
	$('#fancybox-wrap').prepend(logo_html);
	
	//also add custom fancybox close button
	fancybox_close_btn_html = '<a onclick="confirmFancyboxClose();" id="custom_fancybox_close" style="display: inline;"></a>';
	$('#fancybox-outer').append(fancybox_close_btn_html);
}


function confirmFancyboxClose(){
	//console.log('about to cloe');
	confirmation = confirm('You are about to close the Launcher! This will end your current session. Do you want to Continue?');
	if(confirmation){
		$.fancybox.close();
		window.location.href= URLPATH + 'login.html';
	}
	
	return false; 
	//below code will be enabled once the conflict issues between pages/plugins are resolved.
	$.confirm({
		'title'		: 'End Current Session?',
		'message'	: 'You are about to close the Launcher! This will end your current session. Do you want to Continue?',
		'buttons'	: {
			'Yes'	: {
				'class'	: 'blue',
				'action': function(){
					$.fancybox.close();
				}
			},
			'No'	: {
				'class'	: 'gray',
				'action': function(){}	// Nothing to do in this case. You can as well omit the action property.
			}
		}
	});	
	
}
