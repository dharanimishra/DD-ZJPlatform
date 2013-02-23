// JavaScript Document

$(document).ready(function()
{
	

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
     	
		
		//pop-up
		$("a.lbx-70-50").fancybox({
				'width'				: 780,
				'height'			: 650,
				'autoScale'			: false,
				'transitionIn'		: 'elastic',
				'transitionOut'		: 'elastic',
				'type'				: 'iframe'
		});	
		
		
	$("a.lbx-video").fancybox({
				'width'				: 500,
				'height'			: 500,
				'autoScale'			: true,
				'transitionIn'		: 'elastic',
				'transitionOut'		: 'elastic',
				'type'				: 'iframe'
			});		
			
			
	$("a.lbx-asso").fancybox({
				'width'				: 1150,
				'height'			: 700,
				'autoScale'			: true,
				'transitionIn'		: 'elastic',
				'transitionOut'		: 'elastic',
				'type'				: 'iframe'
			});		
	$("a.lbx-50-50").fancybox({
				'width'				: 400,
				'height'			: 400,
				'autoScale'			: true,
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
		
		
	
					
						
	//temporary static data code
		
	$('#showsearchcontainer').hide();
			
				
		
		$("#btnsearch").click(function(){			
				$("#showsearchcontainer").toggle('showOrHide');
				
				});
		
			$("#btnadvsearch").click(function(){			
				$("#showsearchcontainer").toggle('showOrHide');
				
				});
		
						
						
			//all Question stuff from Define Assignment		
						
    $('#_QuesTrueFalse').hide();
	$('#_QuesMultiChoicesingle').hide();
	$('#_QuesMultiChoicemulti').hide();
	$('#_Quesorderingchoice').hide();
	$('#_QuesMatchfollowing').hide();
	$('#_QuesFillBlanks').hide();
	$('#_QuesJumbledques').hide();
	$('#_QuesDescriptive').hide();
	$('#_QuesMaths').hide();
	$('#_QuesFrame').hide();
	
	
	$('#_QuesSelect').change( function () {
        if ($('#_QuesSelect').val() == "True/False"){
            $('#_QuesTrueFalse').slideDown("");
			$('#_QuesMultiChoicesingle').hide();
			$('#_QuesMultiChoicemulti').hide();
			$('#_Quesorderingchoice').hide();
			$('#_QuesMatchfollowing').hide();
			$('#_QuesFillBlanks').hide();
			$('#_QuesJumbledques').hide();
			$('#_QuesDescriptive').hide();
			$('#_QuesMaths').hide();
				$('#_QuesFrame').hide();
			//$('#_QuesMultiChoicesingle').hide();
			//$('#_QuesMultiChoicesingle').hide();
			//$('#_QuesMultiChoicesingle').hide();
			//$('#_QuesMultiChoicesingle').hide();
			 
		}
		
		 else if ($('#_QuesSelect').val() == "MultiChoiceSingle"){
           	
			$('#_QuesMultiChoicesingle').slideDown("");
			 $('#_QuesTrueFalse').hide();
			 $('#_QuesMultiChoicemulti').hide();
			 $('#_Quesorderingchoice').hide();
			 $('#_QuesMatchfollowing').hide();
			 $('#_QuesFillBlanks').hide();
			 $('#_QuesJumbledques').hide();
			 $('#_QuesDescriptive').hide();
			 $('#_QuesMaths').hide();
			 	$('#_QuesFrame').hide();
			//$('#_QuesMultiChoicesingle').hide();
			//$('#_QuesMultiChoicesingle').hide();
			//$('#_QuesMultiChoicesingle').hide();
			  
		 }
		 
		  else if ($('#_QuesSelect').val() == "MultiChoiceMulti"){
           	
			$('#_QuesMultiChoicemulti').slideDown("");
			 $('#_QuesTrueFalse').hide();
			 $('#_QuesMultiChoicesingle').hide();
			 $('#_Quesorderingchoice').hide();
			$('#_QuesMatchfollowing').hide();
			$('#_QuesFillBlanks').hide();
			$('#_QuesJumbledques').hide();
			$('#_QuesDescriptive').hide();
			$('#_QuesMaths').hide();
				$('#_QuesFrame').hide();
			//$('#_QuesMultiChoicesingle').hide();
			  
		 }
		 
		 
		   else if ($('#_QuesSelect').val() == "OrderingChoices"){
           	
			$('#_Quesorderingchoice').slideDown("");
			 $('#_QuesTrueFalse').hide();
			 $('#_QuesMultiChoicesingle').hide();
			 $('#_QuesMultiChoicemulti').hide();
			 $('#_QuesMatchfollowing').hide();
			 $('#_QuesFillBlanks').hide();
			 $('#_QuesJumbledques').hide();
			 $('#_QuesDescriptive').hide();
			 $('#_QuesMaths').hide();
			 	$('#_QuesFrame').hide();
			//$('#_QuesMultiChoicesingle').hide();
			//$('#_QuesMultiChoicesingle').hide();
					  
		 }
		 
		 
		    else if ($('#_QuesSelect').val() == "MatchFollowing"){
           	
			$('#_QuesMatchfollowing').slideDown("");
			 $('#_QuesTrueFalse').hide();
			 $('#_QuesMultiChoicesingle').hide();
			 $('#_QuesMultiChoicemulti').hide();
			 $('#_Quesorderingchoice').hide();
			 $('#_QuesFillBlanks').hide();
			 $('#_QuesJumbledques').hide();
			 $('#_QuesDescriptive').hide();
			 $('#_QuesMaths').hide();
			 	$('#_QuesFrame').hide();
			//$('#_QuesMultiChoicesingle').hide();
			//$('#_QuesMultiChoicesingle').hide();
					  
		 }
		 
		 
		  else if ($('#_QuesSelect').val() == "FillBlanks"){
           	
			$('#_QuesFillBlanks').slideDown("");
			 $('#_QuesTrueFalse').hide();
			 $('#_QuesMultiChoicesingle').hide();
			 $('#_QuesMultiChoicemulti').hide();
			 $('#_Quesorderingchoice').hide();
			 $('#_QuesMatchfollowing').hide();
			 $('#_QuesJumbledques').hide();
			 $('#_QuesDescriptive').hide();
			 $('#_QuesMaths').hide();
			 	$('#_QuesFrame').hide();
			//$('#_QuesMultiChoicesingle').hide();
			//$('#_QuesMultiChoicesingle').hide();
					  
		 }
		 
		 else if ($('#_QuesSelect').val() == "JumbledSequence"){
           	
			$('#_QuesJumbledques').slideDown("");
			 $('#_QuesTrueFalse').hide();
			 $('#_QuesMultiChoicesingle').hide();
			 $('#_QuesMultiChoicemulti').hide();
			 $('#_Quesorderingchoice').hide();
			 $('#_QuesMatchfollowing').hide();
			 $('#_QuesFillBlanks').hide();
			 $('#_QuesDescriptive').hide();
			 $('#_QuesMaths').hide();
			 	$('#_QuesFrame').hide();
			//$('#_QuesMultiChoicesingle').hide();
			//$('#_QuesMultiChoicesingle').hide();
					  
		 }
		 
		 
		  else if ($('#_QuesSelect').val() == "Descriptive"){
           	
			$('#_QuesDescriptive').slideDown("");
			 $('#_QuesTrueFalse').hide();
			 $('#_QuesMultiChoicesingle').hide();
			 $('#_QuesMultiChoicemulti').hide();
			 $('#_Quesorderingchoice').hide();
			 $('#_QuesMatchfollowing').hide();
			 $('#_QuesFillBlanks').hide();
			 $('#_QuesJumbledques').hide();
			 $('#_QuesMaths').hide();
			 	$('#_QuesFrame').hide();
			//$('#_QuesMultiChoicesingle').hide();
			//$('#_QuesMultiChoicesingle').hide();
					  
		 }
		 
		   else if ($('#_QuesSelect').val() == "Mathematical"){
           	
			$('#_QuesMaths').slideDown("");
			 $('#_QuesTrueFalse').hide();
			 $('#_QuesMultiChoicesingle').hide();
			 $('#_QuesMultiChoicemulti').hide();
			 $('#_Quesorderingchoice').hide();
			 $('#_QuesMatchfollowing').hide();
			 $('#_QuesFillBlanks').hide();
			 $('#_QuesJumbledques').hide();
			$('#_QuesDescriptive').hide();
				$('#_QuesFrame').hide();
			//$('#_QuesMultiChoicesingle').hide();
					  
		 }
		 
		    else if ($('#_QuesSelect').val() == "FrameQuestions"){
           	
			$('#_QuesFrame').slideDown("");
			 $('#_QuesTrueFalse').hide();
			 $('#_QuesMultiChoicesingle').hide();
			 $('#_QuesMultiChoicemulti').hide();
			 $('#_Quesorderingchoice').hide();
			 $('#_QuesMatchfollowing').hide();
			 $('#_QuesFillBlanks').hide();
			 $('#_QuesJumbledques').hide();
			$('#_QuesDescriptive').hide();
				$('#_QuesMaths').hide();
			//$('#_QuesMultiChoicesingle').hide();
					  
		 }
   

   }); 
	
	  
	
	
		
		
	// Enrichment Options	
		
		$('#_Referencematerial').hide();
	$('#_Addnote').hide();
	$('#_Toccontent').hide();
	$('#_Associatereference').hide();
	$('#_Searchreference').hide();
	//$('#_Hotspot').hide();
	
	
	
	$('#_btnaddnote').click( function(){
		jwplayer().play();
		//$('#_Hotspot').hide();
		$('#_Referencematerial').hide();
		$('#_Toccontent').hide();
		$('#_Associatereference').hide();
			$('#_Searchreference').hide();
	$('#_Addnote').slideToggle('showORHide');
		});	
		
		$('#_btnaddreference').click( function(){
			jwplayer().play();
			$('#_Addnote').hide();
			$('#_Toccontent').hide();
			$('#_Associatereference').hide();
			$('#_Searchreference').hide();
	$('#_Referencematerial').slideToggle('showORHide');
		});	
		
		
		$('#_btnSearchrefrence').click( function(){
			jwplayer().play();
			
			$('#_Searchreference').show();
			$('#_Toccontent').hide();
			$('#_Associatereference').hide();
			$('#_searchresults').hide();
				
	       
		});	
		
			$('#_btnSearchresults').click( function(){
			
			$('#_Searchreference').show();
			$('#_searchresults').show();
			$('#_Toccontent').hide();
			$('#_Associatereference').hide();
		
				
	       
		});
		
		$('#_btnAssociatexternal').click( function(){
			$('#_Addnote').hide();
			$('#_Toccontent').hide();
		//$('#_Referencematerial').hide();
				$('#_Searchreference').hide();
	$('#_Associatereference').slideToggle('showORHide');
		});	
		
		
		$('#_btncreatetoc').click( function(){
			jwplayer().play();
			$('#_Addnote').hide();
			$('#_Referencematerial').hide();
			$('#_Associatereference').hide();
	$('#_Toccontent').slideToggle('showORHide');
		});	
			
			
		$('#_closeAddnote').click( function(){
		$('#_Addnote').hide();
	
		});		
					
		$('#_closeReferencematerial').click( function(){
		$('#_Referencematerial').hide();
		$('#_Searchreference').hide();
		$('#_Associatereference').hide();
	
		});		
			
		$('#_closeAssociatereference').click( function(){
		$('#_Associatereference').hide();
		});					
	
	    $('#_closeToccontent').click( function(){
		$('#_Toccontent').hide();
		});		
		
		
		// Assignment Options	
		
		$('#_describeassignment').hide();
		$('#_viewassignment').hide();
		$('#_addtest').hide();
		 $('._associatequestion').hide();
		
		
		
	    $('#_nodedefineassignment').click( function(){
			$('#_viewassignment').hide();
			$('#_addtest').hide();
			 $('._associatequestion').hide();
		$('#_describeassignment').slideToggle('showOrHide');
		});
		
		 $('#_nodedefineassignment').mouseover( function(){
		$('#_viewassignment').hide();
		$('#_addtest').hide();
		 $('._associatequestion').hide();
		$('#_describeassignment').slideToggle('showOrHide');
		
		});
		
		  $('#_nodeviewassignment').click( function(){
		$('#_describeassignment').hide();
		$('#_addtest').hide();	
		 $('._associatequestion').hide();  
		$('#_viewassignment').slideToggle('showOrHide');
		});
		
		 $('#_nodeviewassignment').mouseover( function(){
			 $('#_describeassignment').hide();
			 $('#_addtest').hide();
			  $('._associatequestion').hide();
		$('#_viewassignment').slideToggle('showOrHide');
		});
		
		  $('#_nodeaddtest').click( function(){
			$('#_viewassignment').hide();
			 $('#_describeassignment').hide();
			  $('._associatequestion').hide();
		$('#_addtest').slideToggle('showOrHide');
		});
		
		 $('#_nodeaddtest').mouseover( function(){
		$('#_viewassignment').hide();
		 $('#_describeassignment').hide();
		 $('._associatequestion').hide();
		$('#_addtest').slideToggle('showOrHide');
		
		});
		
		
		 $('#_nodeassociatequestion').click( function(){
			$('#_viewassignment').hide();
			 $('#_describeassignment').hide();
			  $('#_addtest').hide();
		$('._associatequestion').slideToggle('showOrHide');
		});
		
		 $('#_nodeassociatequestion').mouseover( function(){
		$('#_viewassignment').hide();
		 $('#_describeassignment').hide();
		 $('#_addtest').hide();
		$('._associatequestion').slideToggle('showOrHide');
		
		});
		
		
		 $('#_exitviewassignment').click( function(){
		$('#_viewassignment').hide();	  
		
		});	
		
		 $('#_canceldescribeassignment').click( function(){
		 $('#_describeassignment').hide();  
		
		});	
		
		 $('#_btnsearchaddquestioncancel').click( function(){
		$.fancybox-close();
		
		});		
    

});

	
 $(function() {
            var carTags = ['Science','Physics','Maths','Biology','Sports','English','Economics','Ziksana','Chevrolet'];
            $("#tagfield3").superblyTagField({
                allowNewTags: true,
                showTagsNumber: 10,
                 title:'ggg',
                tags: carTags
            });

			        
            $('#tagDemoButton3').click(function(e){
                alert($("#tagfield3").val());
            });
			
        });		
		
	