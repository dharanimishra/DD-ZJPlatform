// JavaScript Document by Sundip editable

 $(document).ready(function () {
	 
	 		 	$("#_createnewplaybook").hide();
			    $("#editpage").hide();
			    $("#treeb").hide();
				 $("#_playbookdetail").show();
			$("#_btnnewplaybook").click(function(e) {
			   $("#treeb").hide();
			   $("#_playbookdetail").hide();
               $("#_createnewplaybook").show();
			   
			   
			
            });
			
			
			  $("#AddPlaybook").validationEngine('attach', {
				  onValidationComplete: function(form, status){
					//alert("The form status is: " +status+", it will never submit");
					if(status == true)
					{
						getplaybooksave();
						createplaybook();
						// $("#AddPlaybook").submit();
//						 $('#DegineCourse').hide();	
//						 $("#treeHideShow").show();	
//						 $(".saveTop").hide();		
//						 $("#Editcoursedtl").hide().delay(500).fadeIn();
					}
				  }  
				});    
			
			function createplaybook() {
				var playbooktitle = $("#defaultvalue").val();
				var playbookdesc = $("#Playbookdesc").val();
				
				$(".reviewtable").append('<tr><td>'+ playbooktitle +'</td><td>' +playbookdesc+ '</td><td><a class="lbx-70-50"  href="#linkurl"><img src="images/view.png" /></a></td><td><a class="lbx-70-50"  href="#linkurl">			<img src="images/edit.png" /></a></td><td></td></tr>');
                $("#_playbookdetail").hide();
                $("#_createnewplaybook").hide();
			    $("#editpage").show();
			    $("#treeb").show();
            }
			
			$("#editpage").click(function(e) {
				$("#editpage").hide();
			    $("#_playbookdetail").hide();
                $("#_createnewplaybook").show();
            });
			
			$("#Btnshowplaybook").click(function(e) {
				$("#_playbookdetail").show();
                $("#_createnewplaybook").hide();
			    $("#editpage").hide();
			    $("#treeb").hide();
            });
			
			
	
     });