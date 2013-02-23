// JavaScript Document

	$(document).ready(function(e) {
		
		tablecloth();
		
		var today = new Date();
		var dd = today.getDate();
		var mm = today.getMonth(); //January is 0!
		var yyyy = today.getFullYear();
		var tarikh = dd +'/'+mm +'/'+yyyy;
		var rowSelect2 = null;
		var addgrouprow = 9;
		
		$(".btn").click(function(e) {
        $("#managegroup :input").removeClass('validateff');
		$("#managegroup :input").removeClass('errorform');
		$(".erroediv").empty();
		
		$("#managegroupmember :input").removeClass('validateff');
		$("#managegroupmember :input").removeClass('errorform');
		
		$("#frmmngmembermessage :input").removeClass('validateff');
		$("#frmmngmembermessage :input").removeClass('errorform');
		
		$("#frmmngmemberinteraction :input").removeClass('validateff');
		$("#frmmngmemberinteraction :input").removeClass('errorform');
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
	
	//students table 	
	$(".Membergroupdetails").hide();
		var rowSelectstuint = null;
		var addgrouprowstutable = 5
		
	//activity table		
    $(".Membergroupactvitiesdetails").hide();
		
	//interactio  table	
	$(".Membergroupinteractiondetails").hide();
		var delinttabrow = null;
		var addstuintrowtable = 3;


		
		
			$('#reviewtable tr').click( function(){
			rowSelect2 = $(this).attr('id');
		});
		
		
		$('#delgroup').click(function(e) {
			if(rowSelect2 != null)
			{
				var chkstr = confirm ("Are you sure to Delete!");
			
				if(chkstr == true)
				{
				$('#'+rowSelect2).fadeOut();
				rowSelect2 = null;
				}
			}
			else
			{
				alert('Select a group to remove!');
			}
        });
		
		
	
	
		$("#addgrouptabrow").click(function(e) {
			 gpnm = $("#mngrpname").val();
			 gpstdt = $("#memdate").val();
			 gpmem = $("#mngmembers").val();
			 gpprg = $("#mngprogress").val();
			if(gpnm != '' && gpstdt != '' && gpprg != '')
			{
            $("#reviewtable").append('<tr id=grupdtl'+addgrouprow+'><td>'+gpnm+'</td><td>'+gpstdt+'</td><td>'+gpmem+'</td><td>'+gpprg+'%</td></tr>');
			addgrouprow++;
			tablecloth();
			document.getElementById('managegroup').reset();
			}
			else
			{
			 //$("#reviewtable").append('<tr id=grupdtl'+addgrouprow+'><td>Group'+addgrouprow+'</td><td>'+tarikh+'</td><td>0</td><td>0%</td></tr>');
			 //addgrouprow++;
			 //tablecloth();
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
					 $("#errormemdate").empty();
					 $("#memdate").addClass('errorform');
					 $("#errormemdate").append("*This field is required");
					
				 }
				 else
				 {
					$("#errormemdate").removeClass('errorform');
					$("#memdate").addClass('validateff');
					$("#errormemdate").empty();
				 }
				 
				 if(gpmem == '')
			 	 {
					 $("#errormngmembers").empty();
					 $("#mngmembers").addClass('errorform');
					 $("#errormngmembers").append("*This field is required");
					
				 }
				 else
				 {
					$("#errormngmembers").removeClass('errorform');
					$("#mngmembers").addClass('validateff');
					$("#errormngmembers").empty();
				 }
			 	if(gpprg == '')
			 	{
					$("#errormngprogress").empty();
					 $("#mngprogress").addClass('errorform');
					 $("#errormngprogress").append("*This field is required");
				}
				else
				{
					$("#errormngprogress").removeClass('errorform');
					$("#mngprogress").addClass('validateff');
					$("#errormngprogress").empty();
				}
				 
			}
			$('#reviewtable tr').click( function(){
			rowSelect2 = $(this).attr('id');
		});
		
		
		$('#delgroup').click(function(e) {
			if(rowSelect2 != null)
			{
				var chkstr = confirm ("Are you sure to Delete!");
			
				if(chkstr == true)
				{
				$('#'+rowSelect2).fadeOut();
				rowSelect2 = null;
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
				$(".managemainbutton").show();
			}
			else
			{
				alert('Select a student to Get Details!');
			}
		});
		
		
		
		
		
		
		
		
		
		
		//code to add rows into the students table
		
		
		
			$("#addstutogrouptabrow").click(function(e) {
             gpnm = $("#mngmemberstdname").val();
			 gpstdt = $("#mngmemberdate").val();
			 gpmem = $("#mngmemberposition").val();
			 gpprg = $("#mngmembergrade").val();
			 if(gpnm != '' && gpstdt != '' && gpprg != '')
			{
            $("#studenttable").append('<tr id=grupdtl'+addgrouprowstutable+'><td>'+gpnm+'</td><td>'+gpstdt+'</td><td>'+gpmem+'</td><td>'+gpprg+'%</td></tr>');
			addgrouprowstutable++;
			tablecloth();
			document.getElementById('managegroupmember').reset();
			}
			else
			{
//				 $("#studenttable").append('<tr id=gprperformance'+addgrouprowstutable+'><td>Student 1</td><td>'+tarikh+'</td><td>Member</td><td>NR</td></tr>');
//				 addgrouprowstutable++;
//			tablecloth();

				 if(gpnm == '')
			 	 {
					 $("#errormngmemberstdname").empty();
					 $("#mngmemberstdname").addClass('errorform');
					 $("#errormngmemberstdname").append("*This field is required");
					
				 }
				 else
				 {
					$("#errormngmemberstdname").removeClass('errorform');
					$("#mngmemberdate").addClass('validateff');
					$("#errormngmemberstdname").empty();
				 }
				 
				 if(gpstdt == '')
			 	 {
					 $("#errormngmemberdate").empty();
					 $("#mngmemberstdname").addClass('errorform');
					 $("#errormngmemberdate").append("*This field is required");
					
				 }
				 else
				 {
					$("#errormngmemberdate").removeClass('errorform');
					$("#mngmemberdate").addClass('validateff');
					$("#errormngmemberdate").empty();
				 }
				 
				  if(gpmem == '')
			 	 {
					 $("#errormngmemberposition").empty();
					 $("#mngmemberposition").addClass('errorform');
					 $("#errormngmemberposition").append("*This field is required");
					
				 }
				 else
				 {
					$("#errormngmemberposition").removeClass('errorform');
					$("#mngmemberposition").addClass('validateff');
					$("#errormngmemberposition").empty();
				 }
				 
				  if(gpprg == '')
			 	 {
					 $("#errormngmembergrade").empty();
					 $("#mngmembergrade").addClass('errorform');
					 $("#errormngmembergrade").append("*This field is required");
					
				 }
				 else
				 {
					$("#errormngmembergrade").removeClass('errorform');
					$("#mngmembergrade").addClass('validateff');
					$("#errormngmembergrade").empty();
				 }
			}
			
			
		$('#studenttable tr').click( function(){
			rowSelectstuint = $(this).attr('id');
			$(".Membergroupdetails").show();
		});
		
		$("#delstudent").click(function(e) {
			if(rowSelectstuint != null)
			{
				var chkstr = confirm('Are you Sure to Remove');
				if(chkstr == true)
				{
            		$("#"+rowSelectstuint).fadeOut();
					rowSelectstuint = null;
					$(".Membergroupdetails").hide();
				}
			}
        });
			
			
        });

		
		
		
        $('#studenttable tr').click( function(){
			rowSelectstuint = $(this).attr('id');
			$(".Membergroupdetails").show();
		});
		
		$("#delstudent").click(function(e) {
			if(rowSelectstuint != null)
			{
				var chkstr = confirm('Are you Sure to Remove');
				if(chkstr == true)
				{
            		$("#"+rowSelectstuint).fadeOut();
					rowSelectstuint = null;
					$(".Membergroupdetails").hide();
				}
			}
			else
			{
				alert("Select a student to remove from group.");
			}
        });

		
		
		
		
		//Code for the Activity table in manage group
				$("#activitytab tr").click(function(e) {
             $(".Membergroupactvitiesdetails").show();
        });

		
		
		//cpde to add message to the table
		$("#addgroupactivitytabrow").click(function(e) {
            gpnm = $("#mngmembermsgtitle").val();
			 gpstdt = $("#mngmembermsgdesc").val();
			 if(gpnm != '' && gpstdt != '')
			 {
				 document.getElementById('frmmngmembermessage').reset();
			 }
			 else
			 {
				 if(gpnm == '')
			 	 {
					 $("#errormngmembermsgtitle").empty();
					 $("#mngmembermsgtitle").addClass('errorform');
					 $("#errormngmembermsgtitle").append("*This field is required");
					
				 }
				 else
				 {
					$("#errormngmembermsgtitle").removeClass('errorform');
					$("#mngmembermsgtitle").addClass('validateff');
					$("#errormngmembermsgtitle").empty();
				 }
				 
				  if(gpstdt == '')
			 	 {
					 $("#errormngmembermsgdesc").empty();
					 $("#mngmembermsgdesc").addClass('errorform');
					 $("#errormngmembermsgdesc").append("*This field is required");
					
				 }
				 else
				 {
					$("#errormngmembermsgdesc").removeClass('errorform');
					$("#mngmembermsgdesc").addClass('validateff');
					$("#errormngmembermsgdesc").empty();
				 }
				 
			 }
        });
		
		
		
		//code for the interaction table
		
				$("#addstuintinmangrp").click(function(e) {
             gpnm = $("#mnginteractiondate").val();
			 gpstdt = $("#mnginteractionstatus").val();
			 gpmem = $("#mnginteractionposition").val();
			 gpprg = $("#mnginteractiondesc").val();
			 
			 if(gpnm != '' && gpstdt != '' && gpprg != '' && gpmem != '')
			{
            $("#interactiontab").append('<tr id=grpinteraction'+addstuintrowtable+'><td>'+gpnm+'</td><td>'+gpstdt+'</td><td>'+gpmem+'</td><td>'+gpprg+'</td></tr>');
			addstuintrowtable++;
			tablecloth();
			document.getElementById('frmmngmemberinteraction').reset();
			}
			else
			{
//			$("#interactiontab").append('<tr id=grpinteraction'+addstuintrowtable+'><td>'+tarikh+'</td><td>Face Meeting</td><td>Complete</td><td>To Guide</td></tr>');
//				 addstuintrowtable++;
//			tablecloth();
					 if(gpnm == '')
			 	 {
					 $("#errormnginteractiondate").empty();
					 $("#mnginteractiondate").addClass('errorform');
					 $("#errormnginteractiondate").append("*This field is required");
					
				 }
				 else
				 {
					$("#errormnginteractiondate").removeClass('errorform');
					$("#mnginteractiondate").addClass('validateff');
					$("#errormnginteractiondate").empty();
				 }

				  if(gpstdt == '')
			 	 {
					 $("#errormnginteractionstatus").empty();
					 $("#mnginteractionstatus").addClass('errorform');
					 $("#errormnginteractionstatus").append("*This field is required");
					
				 }
				 else
				 {
					$("#errormnginteractionstatus").removeClass('errorform');
					$("#mnginteractionstatus").addClass('validateff');
					$("#errormnginteractionstatus").empty();
				 }
				 
				  if(gpmem == '')
			 	 {
					 $("#errormnginteractionposition").empty();
					 $("#mnginteractionposition").addClass('errorform');
					 $("#errormnginteractionposition").append("*This field is required");
					
				 }
				 else
				 {
					$("#errormnginteractionposition").removeClass('errorform');
					$("#mnginteractionposition").addClass('validateff');
					$("#errormnginteractionposition").empty();
				 }
				 
				  if(gpprg == '')
			 	 {
					 $("#errormnginteractiondesc").empty();
					 $("#mnginteractiondesc").addClass('errorform');
					 $("#errormnginteractiondesc").append("*This field is required");
					
				 }
				 else
				 {
					$("#errormnginteractiondesc").removeClass('errorform');
					$("#mnginteractiondesc").addClass('validateff');
					$("#errormnginteractiondesc").empty();
				 }
			
			}
			
		$("#interactiontab tr").click(function(e) {
            $(".Membergroupinteractiondetails").show();
			delinttabrow = $(this).attr('id');
        });
		
		$("#delint").click(function(e) {

			if(delinttabrow != null)
			{
				var chkstr = confirm('Are you sure to remove!');
				if(chkstr == true)
				{
					$("#"+delinttabrow).fadeOut();
					delinttabrow = null;
					$(".Membergroupinteractiondetails").hide();
				}
			}
       });
    });
		
		$("#interactiontab tr").click(function(e) {
            $(".Membergroupinteractiondetails").show();
			delinttabrow = $(this).attr('id');
        });
		
		$("#delint").click(function(e) {

			if(delinttabrow != null)
			{
				var chkstr = confirm('Are you sure to remove!');
				if(chkstr == true)
				{
					$("#"+delinttabrow).fadeOut();
					delinttabrow = null;
					$(".Membergroupinteractiondetails").hide();
				}
			}
			else
			{
				alert("Select an interaction to remove.");
			}
       });

		
		
		
		
		
	});
