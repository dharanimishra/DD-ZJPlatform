// JavaScript Document

  $(document).ready(function() {
        
	 $("a.lbx-launcher").fancybox({
				'width'				: 1010,
				'height'			: 520,
				'autoScale'			: false,
				'transitionIn'		: 'elastic',
				'transitionOut'		: 'elastic',
				'type'				: 'iframe'
			});			
	
	
	
	// jquery function for the error validations
	// binds fields to the validation 
	
	//jQuery("#DegineCourse").validationEngine();
	//jQuery("#DegineCourse").validationEngine();
			
    jQuery("#DegineCourse").validationEngine();    
	jQuery("#AddModule").validationEngine();
	
	
 
				// checkbox show hide for the homepage
				$("#Chksecuritywatermark").hide();
				$("#watermarktxt").hide();
				$("#Chksecuritylogo").click(function(e) {
                     if(Chksecuritylogo.checked == 1)
			   		{
				    $("#Chksecuritywatermark").show();
					$("#watermarktxt").show();
			   		}
					else
					{
						$("#Chksecuritywatermark").hide();
						$("#watermarktxt").hide();
					}
					if(Chksecuritysignature.checked == 1)
			   		{
				    $("#Chksecuritywatermark").show();
					$("#watermarktxt").show();
			   		}
					
                });
				
				$("#Chksecuritysignature").click(function(e) {
                     if(Chksecuritysignature.checked == 1)
			   		{
				    $("#Chksecuritywatermark").show();
					$("#watermarktxt").show();
			   		}
					else
					{
						$("#Chksecuritywatermark").hide();
						$("#watermarktxt").hide();
					}
                });	


			
			//Addmodule when checkbox clicked then it shows the saveassociateobject
						
			 $("#saveassociateobject").hide();
			  $("#viewmodulesaveassociateobject").hide();
			
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
					  CKEDITOR.replace('Cmoduledescrte');
				});
			
	
	
	   //search and associate modules
	
	$('#showsearchcontainer').hide();
			
				
		
		$("#Btnsrchaddmodulesbt").click(function(){			
				$("#showsearchcontainer").toggle('showOrHide');
				
				});
		
			$("#btnadvsearch").click(function(){			
				$("#showsearchcontainer").toggle('showOrHide');
				
				});
		
	
	$('#Advanceresultaddmodule').hide();
		
	$('#Btnaddmoduleadvance').click( function () {
       
		$('#Advanceresultaddmodule').toggle("");	  
		 
	});
	
	
	
		$('.Frmresultsrchmodule').hide();
			
		
		
	    $('#Btnsrchaddmodulesbt').click( function(){
			$('.Frmresultsrchmodule').toggle();
		
		});
		
		 $('#Btnsrchmoduleadvance').click( function(){
			$('.Frmresultsrchmodule').toggle();
		
		});
		
	
	// Add new info
	
	$('#infonumber').hide();
	$('#infodate').hide();
	$('._newtext').hide();
	
	$('#Caddnewinfotype').change( function () {
        if ($('#Caddnewinfotype').val() == "Text"){
            $('._newtext').slideDown("");
			$('#infonumber').hide();
			$('#infodate').hide();
		
			 
		}
		
		 else if ($('#Caddnewinfotype').val() == "Numeric"){
           $('#infonumber').slideDown("");
			$('._newtext').hide();
			$('#infodate').hide(); 	
			
			  
		 }
		 
		  else if ($('#Caddnewinfotype').val() == "Date"){
           	 $('#infodate').slideDown("");
			$('._newtext').hide();
			$('#infonumber').hide();
		
			  
		 }
		 else if ($('#Caddnewinfotype').val() == ""){
            $('._newtext').hide();
			$('#infonumber').hide();
			$('#infodate').hide();
		
			 
		}
		 
		
		});
	
	
	
		//pop-up
		$("a.lbx-addnew").fancybox({
				'width'				: 730,
				'height'			: 550,
				'autoScale'			: false,
				'transitionIn'		: 'elastic',
				'transitionOut'		: 'elastic',
				'type'				: 'iframe'
		});	
	
	
	
	// define course specify tag

   $(function() {
            var carTags = ['Science','Physics','Maths','Biology','Sports','English','Economics','Ziksana','Chevrolet'];
            $("#Ctagfield").superblyTagField({
                allowNewTags: true,
                showTagsNumber: 10,
                 title:'ggg',
                tags: carTags
            });

			        
            $('#tagDemoButton2').click(function(e){
                alert($("#Ctagfield").val());
            });
			
        });


// add module specify tag

   $(function() {
            var carTags = ['Science','Physics','Maths','Biology','Sports','English','Economics','Ziksana','Chevrolet'];
            $("#Addmoduletag").superblyTagField({
                allowNewTags: true,
                showTagsNumber: 10,
                 title:'ggg',
                tags: carTags
            });

			        
            $('#tagDemoButton2').click(function(e){
                alert($("#Addmoduletag").val());
            });
			
        });
		
		
		
   
// Search and add module search and specify tag
$(function() {
            var carTags = ['Science','Physics','Maths','Biology','Sports','English','Economics','Ziksana','Chevrolet'];
            $("#Srchddmoduletags").superblyTagField({
                allowNewTags: true,
                showTagsNumber: 10,
                 title:'ggg',
                tags: carTags
            });

			        
            $('#tagDemoButton3').click(function(e){
                alert($("#Srchddmoduletags").val());
            });
		
			
        });		
	
$('#_advanced').hide();
		
	$('#_btnadvanced').click( function () {
       
		$('#_advanced').toggle("");	  
		 
   }); 
   

		/* function for splitter on define step profile */
		$('#_hide').hide();
		$('#Editcoursedtl').hide();
		$('#_split').hover( function(){
			$('#_hide').show(400);
		
		});
		
		
	
     	//define step save buttons event
		$("#treeHideShow").hide();
		
		
		$("#saveBottom").click( function(){
			alert("This will save the current state define course..");
			$("#_define").css("color", "#393");
			$("#saveBottom").attr("href", "#page-wrap");
			});
		
		$("#topSave").click( function(){
			alert("This will save the current state of define course..");
			$("#_define").css("color", "#393");
			$('#definetab').hide();
			$("#_associate").css("color","rgb(232,111,30)");
			$('#associatetab').show();
			});
				
		$("#Editcoursedtl").click( function(){
			$('#DegineCourse').fadeIn('slow');
			$('#treeHideShow').hide();
			$('#Sbtcoursedtl').show();
			$("#Editcoursedtl").hide();
			$(".saveTop").show();
			});
			
		$('#_hide').mouseleave( function(){
			$('#_hide').hide(800);
		});
		
		//for texteditor hide and show
		$('._plainText').hide();
		$('._richTextShow').hide();
		
		$('._richText').click( function(){
			$('._richText').hide();
			$('._plainTextShow').hide();
			$('._plainText').show();
			$('._richTextShow').show();
		});
		
		$('._plainText').click( function(){
			$('._richText').show();
			$('._plainTextShow').show();
			$('._plainText').hide();
			$('._richTextShow').hide();
		});
		
			//hide show arrow for security content
						$('#showSecurity').hide();						
						$('#aDown').hide();
						
						$('#aSide').click(function(){
							$('#showSecurity').slideDown();						
							$('#aSide').hide();
							$('#aDown').show();
						});
    
						$('#aDown').click(function(){
							$('#showSecurity').slideUp();						
							$('#aSide').show();
							$('#aDown').hide();
						});
     	
		
		
		$('#_contentsecurity').hide();						
						$('#aDowncontent').hide();
						
						$('#aSidecontent').click(function(){
							$('#_contentsecurity').slideDown();						
							$('#aSidecontent').hide();
							$('#aDowncontent').show();
						});
    
						$('#aDowncontent').click(function(){
							$('#_contentsecurity').slideUp();						
							$('#aSidecontent').show();
							$('#aDowncontent').hide();
						});
     		
	
	});  // end of document.ready