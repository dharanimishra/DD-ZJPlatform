// JavaScript Document
$(document).ready(function(e) {
    				 // code to add new data
			$("#lookuplocationcontent").hide();
				 var counter=3;
			$('#masterdataadd').click( function(e){
			counter++;
			$(".lookuplocationmenu select").append("<option id=op"+counter+">Menu item</option>");
		
		
		//Start of edit code
			var rowSelect4 = null;
		$('.lookuplocationmenu option').click( function(){
			rowSelect4 = $(this).attr('id');
		
		$('#emasterdata').click( function(e){
			if(rowSelect4 != null)
			{
				$('#'+rowSelect4).remove();
				$(".lookuplocationmenu select").append("<br/><br/><br/><br/><br/><input type='text' id='lname'/> <a href='#linkurl' id='addedvalue' >Save</a>");
				$('#lname').val($('#op1').html());
			}
			else
			{
				alert("Please Select a row to Edit.");
			}
				});
		});
		
			
			//code to delete
		var rowSelect3;
		$('.lookuplocationmenu option').click( function(){
			rowSelect3 = $(this).attr('id');
		
		
		$('#dmasterdata').click( function(e){
			var checkstr = true
			if(rowSelect2 != null){
					if(checkstr == true){$('#'+rowSelect2).remove();}
			}
			else
			{alert("select a record to delete!");}
		});
			});
				});
				
				
				
		var rowSelect2 = null;
		$('.lookuplocationmenu option').click( function(){
			rowSelect2 = $(this).attr('id');
		
		
		$('#dmasterdata').click( function(e){
			var checkstr = true
			if(rowSelect2 != null){
					if(checkstr == true){$('#'+rowSelect2).remove();}
			}
			else
			{alert("select a record to delete!");}
		});
		});
		// End of Deletion code
		
		
		
		//Start of edit code
			var rowSelect5 = null;
		$('.lookuplocationmenu option').click( function(){
			rowSelect5 = $(this).attr('id');
		
		$('#emasterdata').click( function(e){
			if(rowSelect5 != null)
			{
				$('#'+rowSelect5).remove();
				$(".lookuplocationmenu select").append("<br/><br/><br/><br/><br/><input type='text' id='lname'/> <a href='#linkurl' id='addedvalue' >Save</a>");
				$('#lname').val($('#op1').html());	
			}
			else
			{
				alert('Select a record to edit!');
			}
			
				});
		});
		//End of edit code	
		
		
		
		
		
		//start of display code for lookuplocationsubmenu
		$('#Locationtype').change( function () {
			$(".lookuplocationselected").empty();
        if ($('#Locationtype').val() == "loctype1"){
			$("#locationleftsubmenu").empty();
			$("#locationleftsubmenu").append('<label for="Locationname" class="labelclass" style="margin-left:5px;"> Location</label><br /><input type="text" class="defaultvalue labelclass" placeholder="Dupage" style="width:230px;"/><br /><br /><select name="Type" class="defaultvalue labelclass lookupmargin"> <option> Type </option> </select><input type="checkbox" class="defaultvalue labelclass"/> <span class="labelclass"> Active </span><br /><br /><label for="Locationmap" class="labelclass" style="margin-left:5px;" >Map</label><br /><input type="text" class="defaultvalue labelclass" placeholder="Location Map" style="width:230px;"/><br /><br /><label for="Currency" class="labelclass" style="margin-left:5px;">Zip</label><br /><input type="text" class="defaultvalue labelclass " placeholder="M1J3C9" style="width:140px;"/><br /><br /><select name="currency" class="defaultvalue labelclass">Currency  <option> CAD$</option><option> US$</option></select>');
			$("#lookuplocationcontent").show();
			$(".lookuplocationselected").append('<input type="text" class="defaultvalue labelclass" Value="Dupage" style="width:230px;"/>');
			}
		if ($('#Locationtype').val() == "loctype2"){
			$("#locationleftsubmenu").empty();
			$("#locationleftsubmenu").append('<label for="Locationname" class="labelclass" style="margin-left:5px;"> Location</label><br /><input type="text" class="defaultvalue labelclass" placeholder="United States" style="width:230px;"/><br /><br /><select name="Type" class="defaultvalue labelclass lookupmargin"> <option> Type </option> </select><input type="checkbox" class="defaultvalue labelclass"/> <span class="labelclass"> Active </span><br /><br /><label for="Locationmap" class="labelclass" style="margin-left:5px;" >Map</label><br /><input type="text" class="defaultvalue labelclass" placeholder="Location Map" style="width:230px;"/><br /><br /><label for="Currency" class="labelclass" style="margin-left:5px;">Zip</label><br /><input type="text" class="defaultvalue labelclass " placeholder="M9V2B2" style="width:140px;"/><br /><br /><select name="currency" class="defaultvalue labelclass">Currency  <option> US$</option><option> CAD$</option></select>');
			$("#lookuplocationcontent").show();
			$(".lookuplocationselected").append('<input type="text" class="defaultvalue labelclass" Value="United States" style="width:230px;"/>');
			}
		if ($('#Locationtype').val() == "loctype3"){
			$("#locationleftsubmenu").empty();
			$("#locationleftsubmenu").append('<label for="Locationname" class="labelclass" style="margin-left:5px;"> Location</label><br /><input type="text" class="defaultvalue labelclass" placeholder="Illinois" style="width:230px;"/><br /><br /><select name="Type" class="defaultvalue labelclass lookupmargin"> <option> Type </option> </select><input type="checkbox" class="defaultvalue labelclass"/> <span class="labelclass"> Active </span><br /><br /><label for="Locationmap" class="labelclass" style="margin-left:5px;" >Map</label><br /><input type="text" class="defaultvalue labelclass" placeholder="Location Map" style="width:230px;"/><br /><br /><label for="Currency" class="labelclass" style="margin-left:5px;">Zip</label><br /><input type="text" class="defaultvalue labelclass " placeholder="M9W3H3" style="width:140px;"/><br /><br /><select name="currency" class="defaultvalue labelclass">Currency <option> US$</option><option> CAD$</option></select>');
			$("#lookuplocationcontent").show();
			$(".lookuplocationselected").append('<input type="text" class="defaultvalue labelclass" Value="Illinois" style="width:230px;"/>');
			}	
		});
		
		
		
		//code to add edit delete location and relationship table
		 counter2= 12;
			$('#amasterrightdata').click( function(e){
			counter2++;
			$(".table.reviewtable tbody").append("<tr id=locrel"+counter2+"><td><input type='text' class='tablebox' placeholder='Location..' /></td><td><input type='text' class='tablebox' placeholder='Relationship..' /><a href=#linkurl>Add</a></td></tr>");
			
			});
		
		//delete location and relationship
		var rowSelect6 = null;;
		$('#reviewtable tr').click( function(){
			rowSelect6 = $(this).attr('id');
		});
		$('#dmasterrightdata').click( function(e){
			if(rowSelect6 != null)
			{				
				$('#'+rowSelect6).remove();
			}
			else
			{
				alert('Select a comment to delete!');
			}
			
			
		});
		
		
		
		//Edit location and relationship
		a=0;
		var val;
		var rel;
		var rowSelect = null;
		$('#reviewtable tr').click( function(){
			rowSelect = $(this).attr('id');
		val = ($('#'+rowSelect+' td:eq(0)').html());
		rel = ($('#'+rowSelect+' td:eq(1)').html());
			});
		$('#emasterrightdata').click( function(e){
			if(rowSelect != null)
			{	$('#'+rowSelect).remove();
				a++;
				$(".table.reviewtable tbody").append("<tr><td><input type='text' id=lname"+a+" value="+val+" /></td><td><input type='text' id=rname"+a+" value="+rel+" /><a href='linkurl'>Save</a></td></tr>");
			}
			else
			{
				alert('select a row to Edit!');
			}
		});
		
		//$('#emasterrightdata').click( function(e){
//			if(rowSelect == "locrel2")
//			{	$('#'+rowSelect).fadeOut();
//				$(".table.reviewtable tbody").append("<tr><td><input type='text' id='lname2' placeholder='Location..' /></td><td><input type='text' id='rname2' placeholder='Relationship..' /><a href='linkurl'>Save</a></td></tr>");
//
//				$('#lname2').val($('#locrel2 td:first').html());
//				$('#rname2').val($('#locrel2 td:last').html());
//			}
//		});
//		
//		$('#emasterrightdata').click( function(e){
//			if(rowSelect == "locrel3")
//			{	$('#'+rowSelect).fadeOut();
//				$(".table.reviewtable tbody").append("<tr><td><input type='text' id='lname3' placeholder='Location..' /></td><td><input type='text' id='rname3' placeholder='Relationship..' /><a href='linkurl'>Save</a></td></tr>");
//
//				$('#lname3').val($('#locrel3 td:first').html());
//				$('#rname3').val($('#locrel3 td:last').html());
//			}
//		});
//		
//		$('#emasterrightdata').click( function(e){
//			if(rowSelect == "locrel4")
//			{	$('#'+rowSelect).fadeOut();
//				$(".table.reviewtable tbody").append("<tr><td><input type='text' id='lname4' placeholder='Location..' /></td><td><input type='text' id='rname4' placeholder='Relationship..' /><a href='linkurl'>Save</a></td></tr>");
//
//				$('#lname4').val($('#locrel4 td:first').html());
//				$('#rname4').val($('#locrel4 td:last').html());
//			}
//		});
//		
//		$('#emasterrightdata').click( function(e){
//			if(rowSelect == "locrel5")
//			{	$('#'+rowSelect).fadeOut();
//				$(".table.reviewtable tbody").append("<tr><td><input type='text' id='lname5' placeholder='Location..' /></td><td><input type='text' id='rname5' placeholder='Relationship..' /><a href='linkurl'>Save</a></td></tr>");
//
//				$('#lname5').val($('#locrel5 td:first').html());
//				$('#rname5').val($('#locrel5 td:last').html());
//			}
//		});
//		
//		$('#emasterrightdata').click( function(e){
//			if(rowSelect == "locrel6")
//			{	$('#'+rowSelect).fadeOut();
//				$(".table.reviewtable tbody").append("<tr><td><input type='text' id='lname6' placeholder='Location..' /></td><td><input type='text' id='rname6' placeholder='Relationship..' /><a href='linkurl'>Save</a></td></tr>");
//
//				$('#lname6').val($('#locrel6 td:first').html());
//				$('#rname6').val($('#locrel6 td:last').html());
//			}
//		});
//		
//		$('#emasterrightdata').click( function(e){
//			if(rowSelect == "locrel7")
//			{	$('#'+rowSelect).fadeOut();
//				$(".table.reviewtable tbody").append("<tr><td><input type='text' id='lname7' placeholder='Location..' /></td><td><input type='text' id='rname7' placeholder='Relationship..' /><a href='linkurl'>Save</a></td></tr>");
//
//				$('#lname7').val($('#locrel7 td:first').html());
//				$('#rname7').val($('#locrel7 td:last').html());
//			}
//		});
//		
//		$('#emasterrightdata').click( function(e){
//			if(rowSelect == "locrel8")
//			{	$('#'+rowSelect).fadeOut();
//				$(".table.reviewtable tbody").append("<tr><td><input type='text' id='lname8' placeholder='Location..' /></td><td><input type='text' id='rname8' placeholder='Relationship..' /><a href='linkurl'>Save</a></td></tr>");
//
//				$('#lname8').val($('#locrel8 td:first').html());
//				$('#rname8').val($('#locrel8 td:last').html());
//			}
//		});
//		
//		$('#emasterrightdata').click( function(e){
//			if(rowSelect == "locrel9")
//			{	$('#'+rowSelect).fadeOut();
//				$(".table.reviewtable tbody").append("<tr><td><input type='text' id='lname9' placeholder='Location..' /></td><td><input type='text' id='rname9' placeholder='Relationship..' /><a href='linkurl'>Save</a></td></tr>");
//
//				$('#lname9').val($('#locrel9 td:first').html());
//				$('#rname9').val($('#locrel9 td:last').html());
//			}
//		});
//		
//		$('#emasterrightdata').click( function(e){
//			if(rowSelect == "locrel10")
//			{	$('#'+rowSelect).fadeOut();
//				$(".table.reviewtable tbody").append("<tr><td><input type='text' id='lname10' placeholder='Location..' /></td><td><input type='text' id='rname10' placeholder='Relationship..' /><a href='linkurl'>Save</a></td></tr>");
//
//				$('#lname10').val($('#locrel10 td:first').html());
//				$('#rname10').val($('#locrel10 td:last').html());
//			}
//		});
//		
//		$('#emasterrightdata').click( function(e){
//			if(rowSelect == "locrel11")
//			{	$('#'+rowSelect).fadeOut();
//				$(".table.reviewtable tbody").append("<tr><td><input type='text' id='lname11' placeholder='Location..' /></td><td><input type='text' id='rname11' placeholder='Relationship..' /><a href='linkurl'>Save</a></td></tr>");
//
//				$('#lname11').val($('#locrel11 td:first').html());
//				$('#rname11').val($('#locrel11 td:last').html());
//			}
//		});
//		
//		$('#emasterrightdata').click( function(e){
//			if(rowSelect == "locrel12")
//			{	$('#'+rowSelect).fadeOut();
//				$(".table.reviewtable tbody").append("<tr><td><input type='text' id='lname12' placeholder='Location..' /></td><td><input type='text' id='rname12' placeholder='Relationship..' /><a href='linkurl'>Save</a></td></tr>");
//
//				$('#lname12').val($('#locrel12 td:first').html());
//				$('#rname12').val($('#locrel12 td:last').html());
//			}
//		});
		
		
		//Description of the selected row
		var row;
		$('#reviewtable tr').dblclick( function(){
			$(".lookuolocationlower").empty();
			row = $(this).attr('id');
				val = ($('#'+row+' td:eq(0)').html());
				rel = ($('#'+row+' td:eq(1)').html());
				if(rel == 'State')
			{$(".lookuolocationlower").append('<input type="text" readonly class="defaultvalue labelclass" value='+val+' style="width:230px;"/> <span> <a href="#linkurl"> Lookup </a></span><br /> <br /> <select disabled name="Relationship" class="defaultvalue labelclass" style="width:200px;"> <option> Country </option>  <option selected="selected"> State </option> </select>');}
				else
			{$(".lookuolocationlower").append('<input type="text" readonly class="defaultvalue labelclass" value='+val+' style="width:230px;"/> <span> <a href="#linkurl"> Lookup </a></span><br /> <br /> <select disabled name="Relationship" class="defaultvalue labelclass" style="width:200px;"> <option selected="selected"> Country </option>  <option> State </option> </select>');}
		});
});