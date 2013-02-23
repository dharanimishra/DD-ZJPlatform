// JavaScript Document

//code for the group performance table

	$(document).ready(function(e) {
		tablecloth();
		
		var today = new Date();
		var dd = today.getDate();
		var mm = today.getMonth(); //January is 0!
		var yyyy = today.getFullYear();
		var tarikh = dd +'/'+mm +'/'+yyyy;
		
	$(".btn").click(function(e) {
        $("#managestudent :input").removeClass('validateff');
		$("#managestudent :input").removeClass('errorform');
		
		$("#managestuinteraction :input").removeClass('validateff');
		$("#managestuinteraction :input").removeClass('errorform');
    });

	//code for the error validation
	$(".defaultvalue").focusout(function(e) {
            if($(this).val() == '')
			{
				var fieldid = $(this).attr('id');
				$(this).addClass('errorform');
				$("#error"+fieldid).empty();
				$("#error"+fieldid).append('*This field is required');
			}
			else
			{
				var fieldid = $(this).attr('id');
				$(this).removeClass('errorform');
				$(this).addClass('validateff');
				$("#error"+fieldid).empty();
			}
			
        });

	//code for the course drop down list
		
	   $('#Showme').change( function () {
        if ($('#Showme').val() == "Course"){
			$(".managestudenttable").show();
			$(".managestudentlink").show();
		}
		else
		{
			$(".managestudenttable").hide();
			$(".managestudentlink").hide();
			$(".managestudentlowercontainer").hide();
			$(".managemainbutton").hide();
			$(".courseperformancedetails").hide();
			$(".groupperformancedetails").hide();
			$(".interactiondetails").hide();
		}
			});
			
			
			var rowSelect = null;
		$('#reviewtable tr').click( function(){
			rowSelect = $(this).attr('id');
			$(".courseperformancedetails").hide();
			$(".managestudentlowercontainer").show();
			$(".managemainbutton").show();
		});
		
		


		
		//code foe the group performance
		var rowSelect2 = null;
		var addgrouprow = 9;
		 var addgrouprow = 5;
		 $(".groupperformancedetails").hide();
		 var grpperformancerow = null;

		
		
		//code for the students interaction table
		$(".managestudentlink").hide();
		$(".managestudentlowercontainer").hide();
		$(".managemainbutton").hide();
		
		//code for the course performnce table
		 $(".courseperformancedetails").hide();
		 
		//code for the interaction table
		 $(".interactiondetails").hide();
		 var interactiontabrow = null;
		 var addinteractionrow = 3


		
		
		$('#reviewtable tr').click( function(){
			rowSelect2 = $(this).attr('id');
		});
		
		
		
		//code for the group perofrmance table
		 $("#grpperformancetab tr").click(function(e) {
            $(".groupperformancedetails").show();
			grpperformancerow = $(this).attr('id');
        });
		$("#removegrp").click(function(e) {
            if(grpperformancerow != null)
			{
				var chkstr = confirm('Are you sure to remove!');
				if(chkstr == true)
				{
				$("#"+grpperformancerow).fadeOut();
				grpperformancerow = null;
				 $(".groupperformancedetails").hide();
				}
			}
			else
			{
				alert("Select a group to remove");
			}
        });
		
		$("#addstudenttogrouptabrow").click(function(e) {
			
             gpnm = $("#mngrpname").val();
			 gpstdt = $("#mngstuposition").val();
			 gpmem = $("#mngstupaticipation").val();
			 gpprg = $("#mngstugrd").val();
			 if(gpnm != '' && gpstdt != '' && gpprg != '')
			{
            $("#grpperformancetab").append('<tr id=grupdtl'+addgrouprow+'><td>'+gpnm+'</td><td>'+gpstdt+'</td><td>'+gpmem+'</td><td>'+gpprg+'%</td></tr>');
			addgrouprow++;
			tablecloth();
			document.getElementById('managestudent').reset();
			}
			else
			{
//				 $("#grpperformancetab").append('<tr id=gprperformance'+addgrouprow+'><td>Group1</td><td>Member</td><td>65%</td><td>NR</td></tr>');
//				 addgrouprow++;
//			tablecloth();

				if(gpnm == '')
			 	 {
					 $("#errormngrpname").empty();
					 $("#mngrpname").addClass('errorform');
					 $("#errormngrpname").append("*This field is required");
					
				 }
				 else
				 {
					$("#errormngrpname").removeClass('errorform');
					$("#mngrpname").addClass('validateff');
					$("#errormngrpname").empty();
				 }
				 
				 if(gpstdt == '')
			 	 {
					 $("#errormngstuposition").empty();
					 $("#mngstuposition").addClass('errorform');
					 $("#errormngstuposition").append("*This field is required");
					
				 }
				 else
				 {
					$("#errormngstuposition").removeClass('errorform');
					$("#mngstuposition").addClass('validateff');
					$("#errormngstuposition").empty();
				 }
				 
				 if(gpmem == '')
			 	 {
					 $("#errormngstupaticipation").empty();
					 $("#mngstupaticipation").addClass('errorform');
					 $("#errormngstupaticipation").append("*This field is required");
					
				 }
				 else
				 {
					$("#errormngstupaticipation").removeClass('errorform');
					$("#mngstupaticipation").addClass('validateff');
					$("#errormngstupaticipation").empty();
				 }
				 
				 if(gpprg == '')
			 	 {
					 $("#errormngstugrd").empty();
					 $("#mngstugrd").addClass('errorform');
					 $("#errormngstugrd").append("*This field is required");
					
				 }
				 else
				 {
					$("#errormngstugrd").removeClass('errorform');
					$("#mngstugrd").addClass('validateff');
					$("#errormngstugrd").empty();
				 }
				 
				 
			
			}
			$("#grpperformancetab tr").click(function(e) {
            $(".groupperformancedetails").show();
			grpperformancerow = $(this).attr('id');
        });
			
			$("#removegrp").click(function(e) {
            if(grpperformancerow != null)
			{
				var chkstr = confirm('Are you sure to remove!');
				if(chkstr == true)
				{
				$("#"+grpperformancerow).fadeOut();
				grpperformancerow = null;
				 $(".groupperformancedetails").hide();
				}
			}
        	});
        });
		

		
		
		
		
		
		
		
		//$(".managegrouptable").hide();
		//$("#grouplink").hide();
		$(".managegrouplowercontainer").hide();
		$(".managemainbutton").hide();
        	$('#Showme').change( function () {
        if ($('#Showme').val() == "Course"){
			$(".managegrouptable").show();
			$("#grouplink").show();
		}
			});
			
			
			var rowSelect = null;
		$('#reviewtable tr').click( function(){
			rowSelect = $(this).attr('id');
            if(rowSelect != null)
			{
				$(".managegrouplowercontainer").show();
				
			}
			else
			{
				alert('Select a student to Get Details!');
			}
		});
		
		
		
		//code for the course performance table
		 $("#courseperformancetab tr").click(function(e) {
            $(".courseperformancedetails").show();
        });

	
		
		//code for the interaction table
		        $("#interactiontab tr").click(function(e) {
            $(".interactiondetails").show();
			interactiontabrow = $(this).attr('id');
        });
		
		
			
		$("#addstudentinttabrow").click(function(e) {
			
             gpnm = $("#mngstuintdate").val();
			 gpstdt = $("#mngstintmode").val();
			 gpmem = $("#mngstuintstatus").val();
			 gpprg = $("#mngstuintreason").val();
			 if(gpnm != '' && gpstdt != '' && gpprg != '')
			{
            $("#interactiontab").append('<tr id=interactionrow'+addinteractionrow+'><td>'+gpnm+'</td><td>'+gpstdt+'</td><td>'+gpmem+'</td><td>'+gpprg+'</td></tr>');
			addinteractionrow++;
			tablecloth();
			document.getElementById('managestuinteraction').reset();
			}
			else
			{
//				 $("#interactiontab").append('<tr id=interactionrow'+addinteractionrow+'><td>'+tarikh+'</td><td>Video Chat</td><td>Complete</td><td>To Guide</td></tr>');
//				 addinteractionrow++;
//			tablecloth();
				
				
				 if(gpstdt == '')
			 	 {
					 $("#errormngstintmode").empty();
					 $("#mngstintmode").addClass('errorform');
					 $("#errormngstintmode").append("*This field is required");
					
				 }
				 else
				 {
					$("#errormngstintmode").removeClass('errorform');
					$("#mngstintmode").addClass('validateff');
					$("#errormngstintmode").empty();
				 }
				 
				 if(gpmem == '')
			 	 {
					 $("#errormngstuintstatus").empty();
					 $("#mngstuintstatus").addClass('errorform');
					 $("#errormngstuintstatus").append("*This field is required");
					
				 }
				 else
				 {
					$("#errormngstuintstatus").removeClass('errorform');
					$("#mngstuintstatus").addClass('validateff');
					$("#errormngstuintstatus").empty();
				 }
				 
				 if(gpprg == '')
			 	 {
					 $("#errormngstuintreason").empty();
					 $("#mngstuintreason").addClass('errorform');
					 $("#errormngstuintreason").append("*This field is required");
					
				 }
				 else
				 {
					$("#errormngstuintreason").removeClass('errorform');
					$("#mngstuintreason").addClass('validateff');
					$("#errormngstuintreason").empty();
				 }
			
			}
		
		
		$("#interactiontab tr").click(function(e) {
            $(".interactiondetails").show();
			interactiontabrow = $(this).attr('id');
        });


			$("#removeinteraction").click(function(e) {
            if(interactiontabrow != null)
			{
				var chkstr = confirm('Are you sure to remove!');
				if(chkstr == true)
				{
					$("#"+interactiontabrow).fadeOut();
					interactiontabrow = null;
					$(".interactiondetails").hide();
				}
			}
        });
        });
		
		
		
		$("#removeinteraction").click(function(e) {
            if(interactiontabrow != null)
			{
				var chkstr = confirm('Are you sure to remove!');
				if(chkstr == true)
				{
					$("#"+interactiontabrow).fadeOut();
					interactiontabrow = null;
					$(".interactiondetails").hide();
				}
			}
			else
			{
				alert("Select a interaction to remove!");
			}
        });
		


		
	});

