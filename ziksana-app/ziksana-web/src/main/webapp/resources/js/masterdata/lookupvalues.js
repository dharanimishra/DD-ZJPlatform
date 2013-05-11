$(document).ready(function(e) {
	
	
	
    $('#amasterrightdata').click( function(e){
			e.preventDefault();
			$(".table.reviewtable tbody").append("<tr><td><input type='text' style='width:130px;' class='tablebox' placeholder='Value..' /></td><td><input type='text' style='width:130px;' class='tablebox' placeholder='Description..' /></td><td><input type='text' style='width:130px;' class='tablebox' placeholder='Status..' /></td><td><input type='text' style='width:130px;' class='tablebox' placeholder='Date..' />&nbsp;&nbsp; <a href='#linkurl'>Save</a></td></tr>");
			

		});
		
		//delete location and relationship
		var rowSelect;
		$('#reviewtable tr').click( function(){
			rowSelect = $(this).attr('id');
		});
		
		$('#dmasterrightdata').click( function(e){
			e.preventDefault();
			if(rowSelect)
			{
			var checkstr =  confirm('Are you sure to Delete!!');
							if(checkstr == true){
								$('#'+rowSelect).fadeOut();
							}else{
							return false;
							}
			}
			else
			{
				alert('Select a comment to delete!');
			}
			
		
			
		});
		
		
		
		
		
		//Description of location and relationship
		var rowSelect = null;
		$('#reviewtable tr').click( function(){
			rowSelect = $(this).attr('id');
		});
		var val;
		var dat;
		var desc;
		var chk;
		var ckbox = false;
		
		$('#emasterrightdata').click(function (e){
			if(rowSelect != null)
		{
			$("#lookupdescriptionupper").empty();
			$("#lookupdescriptiolower").empty();
			if(rowSelect == "locrel1")
			{	
				val = ($('#locrel1 td:eq(0)').html());
				desc = ($('#locrel1 td:eq(1)').html());
				chk = ($('#locrel1 td:eq(2)').html());
				dat = ($('#locrel1 td:eq(3)').html());
				$("#lookupdescriptionupper").append(' <div class="lookupleft"><label for="value" class="labelclass"> Value </label><input type="text" class="defaultvalue labelclass" Value='+val+' style="margin-left:38px;" /> </div><div class="lookupright"><label for="Date" class="labelclass"> Date</label><input id="datepicker-example1" type="text" Value='+dat+' class="defaultvalue"><input type="checkbox" checked="checked" class="defaultvalue labelclass"/> <span class="labelclass"> Active </span></div> ');
				$("#lookupdescriptiolower").append('<label for="Description" class="labelclass"> Description</label><textarea name="catdescription" cols="85" rows="5" class="defaultvalue labelclass">'+desc+'</textarea>');
			}
			if(rowSelect == "locrel2")
			{	
				val = ($('#locrel2 td:eq(0)').html());
				desc = ($('#locrel2 td:eq(1)').html());
				chk = ($('#locrel2 td:eq(2)').html());
				dat = ($('#locrel2 td:eq(3)').html());
				$("#lookupdescriptionupper").append(' <div class="lookupleft"><label for="value" class="labelclass"> Value </label><input type="text" class="defaultvalue labelclass" Value='+val+' style="margin-left:38px;" /> </div><div class="lookupright"><label for="Date" class="labelclass"> Date</label><input id="datepicker-example1" type="text" Value='+dat+' class="defaultvalue"><input type="checkbox" checked="checked" class="defaultvalue labelclass"/> <span class="labelclass"> Active </span></div> ');
				$("#lookupdescriptiolower").append('<label for="Description" class="labelclass"> Description</label><textarea name="catdescription" cols="85" rows="5" class="defaultvalue labelclass">'+desc+'</textarea>');				
			}
			if(rowSelect == "locrel3")
			{	
				val = ($('#locrel3 td:eq(0)').html());
				desc = ($('#locrel3 td:eq(1)').html());
				chk = ($('#locrel3 td:eq(2)').html());
				dat = ($('#locrel3 td:eq(3)').html());
				$("#lookupdescriptionupper").append(' <div class="lookupleft"><label for="value" class="labelclass"> Value </label><input type="text" class="defaultvalue labelclass" Value='+val+' style="margin-left:38px;" /> </div><div class="lookupright"><label for="Date" class="labelclass"> Date</label><input id="datepicker-example1" type="text" Value='+dat+' class="defaultvalue"><input type="checkbox" class="defaultvalue labelclass"/> <span class="labelclass"> Active </span></div> ');
				$("#lookupdescriptiolower").append('<label for="Description" class="labelclass"> Description</label><textarea name="catdescription" cols="85" rows="5" class="defaultvalue labelclass">'+desc+'</textarea>');
			}
		}
		else
		{
			alert("select a row to edit!");
		}
				});

});