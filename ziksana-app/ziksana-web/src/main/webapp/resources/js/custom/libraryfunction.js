// JavaScript Document

$(document).ready(function()
{
	
	$('#type-1').hide();
	$('#type-2').hide();
	$('#type-3').hide();
	$('#treeDiv').hide();
	
	$('#q_type').change( function () {
        if ($('#q_type').val() == "Upload Content"){
            $('#type-1').fadeIn("slow");
			 $('#type-2').hide();
			  $('#type-3').hide();
		}
		 else if ($('#q_type').val() == "External WebPage"){
           	
			$('#type-2').fadeIn("slow");
			 $('#type-1').hide();
			  $('#type-3').hide();
			  
		 }
		 
		  else if ($('#q_type').val() == "Create Content"){
           $('#type-3').fadeIn("slow");
		   $('#type-1').hide();
			 $('#type-2').hide();
			  
		 }
		 
		  else if ($('#q_type').val() == "Selected"){
          $('#type-1').hide();
	$('#type-2').hide();
	$('#type-3').hide();
			  
		 }
   }); 
   
   
	$('#_advanced').hide();
		
	$('#_btnadvanced').click( function () {
       
		$('#_advanced').toggle("");	  
		 
   }); 
   

		/* function for splitter on define step profile */
		$('#_hide').hide();
		$('#show1').hide();
		$('#_split').hover( function(){
			$('#_hide').show(400);		
		});
		
		$("#done1").click( function(){
			$('#DegineCourse').submit();
			$('#DegineCourse').fadeOut('slow');	
			$(".saveTop").hide();		
			$("#show1").hide().delay(500).fadeIn();
			$('#treeDiv').fadeIn('slow');
			$("#saveBottom").show();
		});
		
		//top wizard active step 
		//define
		$("#_define").css("color","rgb(232,111,30)");		
		
		
		$("#_define").click(function(){			
				$("#_define").css("color","rgb(232,111,30)");
				$("#_associate").css("color","#369");
				$("#_enrich").css("color","#369");
				$("#_assignment").css("color","#369");
				$("#_planner").css("color","#369");	
				$("#_playbook").css("color","#369");
				$("#_socialize").css("color","#369");
				});
		
		//associate				
		$("#_associate").click(function(){			
				$("#_associate").css("color","rgb(232,111,30)");
				$("#_define").css("color","#369");	
				$("#_enrich").css("color","#369");
				$("#_assignment").css("color","#369");
				$("#_planner").css("color","#369");	
				$("#_playbook").css("color","#369");
				$("#_socialize").css("color","#369");
				
		});
		//Enrich
		$("#_enrich").click(function(){			
				$("#_enrich").css("color","rgb(232,111,30)");
				$("#_define").css("color","#369");	
				$("#_associate").css("color","#369");
				$("#_assignment").css("color","#369");
				$("#_planner").css("color","#369");	
				$("#_playbook").css("color","#369");
				$("#_socialize").css("color","#369");
		});
		//assignment
		$("#_assignment").click(function(){			
				$("#_assignment").css("color","rgb(232,111,30)");
				$("#_define").css("color","#369");	
				$("#_associate").css("color","#369");
				$("#_enrich").css("color","#369");
				$("#_planner").css("color","#369");	
				$("#_playbook").css("color","#369");
				$("#_socialize").css("color","#369");
		});
		//planner
		$("#_planner").click(function(){			
				$("#_planner").css("color","rgb(232,111,30)");
				$("#_define").css("color","#369");	
				$("#_associate").css("color","#369");
				$("#_enrich").css("color","#369");
				$("#_assignment").css("color","#369");
				$("#_playbook").css("color","#369");
				$("#_socialize").css("color","#369");
		});
		//playbook
		$("#_playbook").click(function(){			
				$("#_playbook").css("color","rgb(232,111,30)");
				$("#_define").css("color","#369");	
				$("#_associate").css("color","#369");
				$("#_enrich").css("color","#369");
				$("#_assignment").css("color","#369");
				$("#_planner").css("color","#369");
				$("#_socialize").css("color","#369");
		});
		//socialize
		$("#_socialize").click(function(){			
				$("#_socialize").css("color","rgb(232,111,30)");
				$("#_define").css("color","#369");	
				$("#_associate").css("color","#369");
				$("#_enrich").css("color","#369");
				$("#_assignment").css("color","#369");
				$("#_planner").css("color","#369");
				$("#_playbook").css("color","#369");
		});
     	//define step save buttons event
		$("#saveBottom").click( function(){
			alert("This will save the current state define course..");
			$("#_define").css("color", "#393");
			$('#definetab').hide();
			$("#_associate").css("color","rgb(232,111,30)");
			$('#associatetab').show();
			});
		
		$("#topSave").click( function(){
			alert("This will save the current state of define course..");
			$("#_define").css("color", "#393");
			$('#definetab').hide();
			$("#_associate").css("color","rgb(232,111,30)");
			$('#associatetab').show();
			$('#_define').bind('click', function() {
  			alert('Data saved..');
			$("#_define").css("color", "#393");
			});

			});
				
		$("#show1").click( function(){
			$('#DegineCourse').fadeIn('slow');
			$('#done1').show();
			$("#show1").hide();
			$(".saveTop").show();
			$('#treeDiv').hide();
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
     	
		//pop-up
		$("a.lbx-70-50").fancybox({
				'width'				: 780,
				'height'			: 650,
				'autoScale'			: false,
				'transitionIn'		: 'elastic',
				'transitionOut'		: 'elastic',
				'type'				: 'iframe'
		});	
		
		
		//for enrich tab
		//for enrich video options
	$('.options').hide();
	$('._search').hide();
	$('._ref').hide();
	$('._advanceSearch').hide();
	$('._notes').hide();
	$('._toc').hide();
	
	$('._exit').click( function(){
		$('._search').hide();
		$('._ref').hide();
		$('._notes').hide();
		$('._toc').hide();
	});
	
	$('._exitBottom').click( function(){
		$('._advanceSearch').hide();
		$('._advance').show();
		$('.img_search').show();
	});
	
		
		$('._hotspot').click( function(){
			$('._search').fadeIn();
			$('._ref').hide();
			$('._notes').hide();
			$('._toc').hide();
			$('._advance').show();
		$('.img_search').show();
		});
		
	
		$('._advance').click( function(){
			$('._advanceSearch').show();
			$('._notes').hide();
			$('._toc').hide();
			$('._advance').hide();
			$('.img_search').hide();
			$('._exitBottom').show();
			
		});
		
		$('._reference').click( function(){
			$('._ref').fadeIn();
			$('._search').hide();
			$('._notes').hide();
			$('._toc').hide();
			$('._advanceSearch').hide();
		});
		$('.notes').click( function(){
			$('._notes').fadeIn();
			$('._search').hide();
			$('._ref').hide();
			$('._toc').hide();
			$('._advanceSearch').hide();
		});
		
		$('.toc').click( function(){
			$('._notes').hide();
			$('._search').hide();
			$('._ref').hide();
			$('._toc').fadeIn();
			$('._advanceSearch').hide();
		});
		
		  $('._inv').click( function(){
			$('#ed3').fadeOut();
			$('._inv').fadeOut();
			$('._txt2').val("Child name");
			$('._txt3').val("Sibling name");
			
		}); 
		
		
		//all steps show and hide
			
			$('#associatetab').hide();
			$('#enrichtab').hide();
			$('#assignmenttab').hide();
			$('#plannertab').hide();
			$('#playbooktab').hide();
			$('#solializetab').hide();
			
		
		$('#_define').click( function(){
			$('#definetab').show();
			$('#associatetab').hide();
			$('#enrichtab').hide();
			$('#assignmenttab').hide();
			$('#plannertab').hide();
			$('#playbooktab').hide();
			$('#solializetab').hide();
			});
		
		
		$('#_associate').click( function(){
			$('#associatetab').show();
			$('#definetab').hide();
			$('#enrichtab').hide();
			$('#assignmenttab').hide();
			$('#plannertab').hide();
			$('#playbooktab').hide();
			$('#solializetab').hide();
			});
			
			$('#_enrich').click( function(){
			$('#enrichtab').show();
		    $('#definetab').hide();
			$('#associatetab').hide();
			$('#assignmenttab').hide();
			$('#plannertab').hide();
			$('#playbooktab').hide();
			$('#solializetab').hide();
			});	


			$('#_assignment').click( function(){
						$('#assignmenttab').show();
						$('#definetab').hide();
						$('#associatetab').hide();
						$('#enrichtab').hide();
						$('#plannertab').hide();
						$('#playbooktab').hide();
						$('#solializetab').hide();
						});	
						
						$('#_planner').click( function(){
						$('#plannertab').show();
						$('#definetab').hide();
						$('#associatetab').hide();
						$('#enrichtab').hide();
						$('#assignmenttab').hide();
						$('#playbooktab').hide();
						$('#solializetab').hide();
						});	
						
						
						$('#_playbook').click( function(){
						$('#playbooktab').show();
						$('#definetab').hide();
						$('#associatetab').hide();
						$('#enrichtab').hide();
						$('#assignmenttab').hide();
						$('#plannertab').hide();
						$('#solializetab').hide();
						});	
						
						$('#_socialize').click( function(){
						$('#solializetab').show();
						$('#definetab').hide();
						$('#associatetab').hide();
						$('#enrichtab').hide();
						$('#assignmenttab').hide();
						$('#plannertab').hide();
						$('#playbooktab').hide();
						});	
						
		
				//spinner
				$('#Duration').spinit(); 
				$('#Credits').spinit();  
				$('#ExtraCredits').spinit();      
    
	
	
});

   $(function() {
            var courseTags = ['Science','Physics','Maths','Biology','Sports','English','Economics','Ziksana','Chevrolet'];
            $("#tagfield2").superblyTagField({
                allowNewTags: true,
                showTagsNumber: 10,
                 title:'ggg',
                tags: courseTags
            });

			        
            $('#tagDemoButton2').click(function(e){
                alert($("#tagfield2").val());
            });
			
        });
		
		
		