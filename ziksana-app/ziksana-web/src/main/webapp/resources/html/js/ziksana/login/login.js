// JavaScript Document
function loginsec()
		 {
			var hrefval;
            var uname = null;
			var pword = null;
			var unam = null;
			uname = document.getElementById('txtusername').value;
			pword = document.getElementById('txtpassword').value;
		
			if(uname != null && pword != null)
			{
					//alert(uname +"    " +"   " +pword);
					if(uname == "Educator" && pword == "Educator123")
					{
						//window.location.href = "educatorlauncher.html";
						$.fancybox({
							'width': '56%',
							'height': '65%',
							'autoScale': true,
							'transitionIn': 'fade',
							'transitionOut': 'fade',
							'type': 'iframe',
							'href': 'launcher/educatorlauncher.html'
						});
					}
					else if(uname == "Learner" && pword == "Learner123")
					{
						//window.location.href = "learnerlauncher.html";
						$.fancybox({
							'width': '56%',
							'height': '65%',
							'autoScale': true,
							'transitionIn': 'fade',
							'transitionOut': 'fade',
							'type': 'iframe',
							'href': 'launcher/learnerlauncher.html'
						});
					}
					else if(uname == "Administrator" && pword == "Administrator123")
					{
						//window.location.href = "adminlauncher.html";
						$.fancybox({
							'width': '56%',
							'height': '65%',
							'autoScale': true,
							'transitionIn': 'fade',
							'transitionOut': 'fade',
							'type': 'iframe',
							'href': 'launcher/adminlauncher.html'
						});
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
		

	$(function() {
			
				$('#da-slider').cslider({
					autoplay	: true,
					hover : stop,
					bgincrement	: 0
				});
					
			
			});
		