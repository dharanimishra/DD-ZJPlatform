// JavaScript Document

function quitsection()
	{
	var answer = confirm("Do you want to log off?");
	if (answer){
		
		parent.window.location.href = "login.html";
	}
	}
function loginsec()
		 {
			var hrefval;
            var uname = null;
			var pword = null;
			var unam = null;
			uname = document.getElementById('txtusername').value;
			pword = document.getElementById('txtpassword').value;
			//unam = uname.substring(0,4);
			//unam = uname.length;
			//unam = uname.charAt(3)
			//unam = uname.indexOf();
			//unam = uname.replace('a','A', 3)
			//unam = uname.search('a')
			//alert(unam);
			if(uname != null && pword != null)
			{
					//alert(uname +"    " +"   " +pword);
					if(uname == "Educator" && pword == "Educator123")
					{
						//window.location.href = "educatorlauncher.html";
						$.fancybox({
							'width': '85%',
							'height': '85%',
							'autoScale': true,
							'transitionIn': 'fade',
							'transitionOut': 'fade',
							'type': 'iframe',
							'href': 'educatorlauncher.html',
							'showCloseButton': false,
							'onComplete': add_ziklogo_and_close_button()
							
							
						});
						$.cookie("launchpage","educatorlauncher.html");
					}
					else if(uname == "Learner" && pword == "Learner123")
					{
						//window.location.href = "learnerlauncher.html";
						$.fancybox({
							'width': '85%',
							'height': '85%',
							'autoScale': true,
							'transitionIn': 'fade',
							'transitionOut': 'fade',
							'type': 'iframe',
							'href': 'learnerlauncher.html',
							'showCloseButton': false,
							'onComplete': add_ziklogo_and_close_button()
						});
						$.cookie("launchpage","learnerlauncher.html");
					}
					else if(uname == "Administrator" && pword == "Administrator123")
					{
						//window.location.href = "adminlauncher.html";
						$.fancybox({
							'width': '85%',
							'height': '85%',
							'autoScale': true,
							'transitionIn': 'fade',
							'transitionOut': 'fade',
							'type': 'iframe',
							'href': 'adminlauncher.html',
							'showCloseButton': false,
							'onComplete': add_ziklogo_and_close_button()
					
						});
						$.cookie("launchpage","adminlauncher.html");
					}
					else if(uname >= "A" && uname <= "Z" || uname >= "a" && uname <= "z" || uname >= "0" && uname <= "9" || pword >= "A" && pword <= "Z" || pword >="a" && pword <= "z" || pword >="0" && pword <= "9")
					{
						$("#uerror").empty();
						$("#perror").empty();
						$("#uerror").append('<font color="red">Username is Wrong!</font>');
						$("#perror").append('<font color="red">Password is Wrong!</font>');
					}
					else
					{
						$("#uerror").empty();
						$("#perror").empty();
						$("#uerror").append('<font color="red">Enter Username!</font>');
						$("#perror").append('<font color="red">Enter Password!</font>');	
					}
			}
        }
		
		











		
		