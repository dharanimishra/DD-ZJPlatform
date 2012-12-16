 $(document).ready(function(e) {
			  $("#saveassociateobject").hide();
			  $("#viewmodulesaveassociateobject").hide();
				// checkbox show hide for the homepage
				$("#security").hide();
				$("#securitytxt").hide();
				$("#chksecurity").click(function(e) {
                     if(chksecurity.checked == 1)
			   		{
				    $("#security").show();
					$("#securitytxt").show();
			   		}
					else
					{
						$("#security").hide();
						$("#securitytxt").hide();
					}
					if(chksecurity2.checked == 1)
			   		{
				    $("#security").show();
					$("#securitytxt").show();
			   		}
					
                });
				
				$("#chksecurity2").click(function(e) {
                     if(chksecurity2.checked == 1)
			   		{
				    $("#security").show();
					$("#securitytxt").show();
			   		}
					else
					{
						$("#security").hide();
						$("#securitytxt").hide();
					}
                });	


			
			//Addmodule when checkbox clicked then it shows the saveassociateobject
			$("#addmodulecheckbox").click(function(e) {
				 if(addmodulecheckbox.checked == 1)
			   		{
              		  $("#saveassociateobject").slideDown();			   
			   		}
					else
					{
              		  $("#saveassociateobject").slideUp();			   						
					}
            });
			//Viewmodule when checkbox clicked then it shows the saveassociateobject
			$("#viewmodulecheckbox").click(function(e) {
				 if(viewmodulecheckbox.checked == 1)
			   		{
              		  $("#viewmodulesaveassociateobject").slideDown();			   
			   		}
					else
					{
              		  $("#viewmodulesaveassociateobject").slideUp();			   						
					}
            });
			
			
			
			// Richtext editor of addmodule
				$("#addmodulerichedit").click(function(e) {
					  CKEDITOR.replace('editor2');
				});
			
														
				$("#Defineassignmentrichtexteditor").click(function(e) {
                    CKEDITOR.replace('_ed_assignment');
                });

				$("#addtestrichtexteditor").click(function(e) {
					CKEDITOR.replace('_ed_addtest');
				});
				
				$("#associaterich").click(function(e) {
                   CKEDITOR.replace('_associateques_assignment');
                });
				
				$("#associatecontentrichtext").click(function(e) {
                   CKEDITOR.replace('editor1');
                });
				
        });