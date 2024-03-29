
var URLPATH = '/resources/'; //Change it according to where you host the file
//var URLPATH = 'http://localhost:8080/Generic/'; //Change it according to where you host the file - Rajan Localhost Tomcat
//var URLPATH = 'http://localhost:8888/ZDemo/Generic/'; //Change it according to where you host the file - Arun Localhost Wamp
var launcher_fancybox;
$(function(){

	$('[data-launcher]').click(function(){
		launchpage = $(this).attr('data-launchpage'); //get launch page location from the cookie
		//alert(launchpage);
		
		//initiate a fancybox with the url of the launchpage.
			launcher_fancybox = $.fancybox({
			'width': '85%',
			'height': '500',
			'autoScale': true,
			'transitionIn': 'fade',
			'transitionOut': 'fade',
			'type': 'iframe',
			'href': launchpage,
			'showCloseButton': false,
			'onComplete': setInterval("add_ziklogo_and_close_button();", 2000)
			
		});
		
		return false; 
	});

//start row highlight
	$('table.row_highlight tr').on('click', function(){
		tr = $(this);
		parent_table = tr.parents('table');
		
		parent_table.find('tr').removeClass('highlighted_row');
		tr.addClass('highlighted_row');
		
		
	});

//end row highlight




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

	logo_html = '<img id="zik_fancy_logo" width="120" height="120" style="cursor: pointer; left: -36px; margin: 0 auto; position: absolute; top: -36px; z-index: 10000;" alt="" src="/ziksana-web/resources/images/ziksana_button_logo.png">';
	//$(fancy_iframe).parent().find('#zik_fnacy_logo, #custom_fancybox_close').remove(); //initially remove the logo if exists.

	fancybox_wrapper = $.fancybox.wrap;
	if(fancybox_wrapper != null){
		
		//First check if the src points to launcher modal. If not, do nothing.
		iframe_src = fancybox_wrapper.find('.fancybox-iframe').attr('src');

		if(iframe_src != '/ziksana-web/secure/launcher'){return false;}
		
		
		if(fancybox_wrapper.find('#zik_fancy_logo').length == 0){ //remove the logo if it exists.
			fancybox_wrapper.prepend(logo_html);
		}
		fancybox_wrapper.find(".fancybox-close").attr('onclick','confirmFancyboxClose(); return false;').removeAttr('href');
	

	} 
	
}


function confirmFancyboxClose(){
	//console.log('about to cloe');
	confirmation = confirm('You are about to close the Launcher! This will end your current session. Do you want to Continue?');
	if(confirmation){
		$.fancybox.close();
		window.location.href= '/ziksana-web/secure/logout';
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
//setInterval('extendSessionViaAjax();', 28*60*1000);
//
var countdown;

function startCount() {
    var count = 59;
    countdown = setInterval(function() {
    	$('p.sessionTimer').show();
        $("p.sessionTimer").html('Your session will expire in<span style="color:blue; font-weight:bold;"> '+count+'</span> &nbsp;seconds. <a onclick="extendSessionViaAjax(); return false;">Extend Session</a> before timer expires.');
        if (count == 0) {
            window.location.href = '/ziksana-web/secure/sessiontimeout';
        }
        count--;
    }, 1000);
}


function stopTimer() {
    clearInterval(countdown);
}

function extendSessionViaAjax(){
	
	$.get('/ziksana-web/secure/extendsession',{},function(data){
		if(data="success"){ //session is extended in server		
			stopTimer();
			$('p.sessionTimer').hide();
		}
	});
}
				