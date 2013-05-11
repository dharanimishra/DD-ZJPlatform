$(document).ready(function(e) {
			$("#lookuplocationcontent").hide();
			var counter = 3;
    		$('#masterdataadd').click( function(e){
			counter++;
			$(".lookuplocationmenu select").append("<option id=op"+counter+">Menu Item</option>");
			
			//Edit currency
		var rowSelect = null;
		$('.lookuplocationmenu option').click( function(){
			rowSelect = $(this).attr('id');
			$("#lookuplocationcontent").show();
			$('.lookuplocationselected').empty();
			$('.lookuplocationselected').append('<input type="text" class="defaultvalue labelclass" Value="Menu item" style="width:230px;"/>');
						
		$('#emasterdata').click( function(e){
			e.preventDefault();
			if(rowSelect != null)
			{	$('#'+rowSelect).remove();
				$(".lookuplocationmenu select").append("<br/><br/><br/><br/><br/><input type='text' id='lname' placeholder='Location..' /> <a href='linkurl'>Save</a>");
				$('#lname').val($('#op1').html());
			}
			else
			{
				alert('Select a currency to edit!');				
			}
					});
					
					
			$('#dmasterdata').click( function(e){
			if(rowSelect != null)
			{
			var checkstr =  confirm('Are you sure to Delete!!');
				if(checkstr == true){
					$('#'+rowSelect).remove();
				}
			}
			else
			{
				alert('Select a currency to delete!');
			}		
			});
				});
			});
				
			
			
			//Edit currency
		var rowSelect2;
		$('.lookuplocationmenu option').click( function(){
			rowSelect2 = $(this).attr('id');
			$("#lookuplocationcontent").show();
			$('.lookuplocationselected').empty();
			$('.lookuplocationselected').append('<input type="text" class="defaultvalue labelclass" Value="Menu item" style="width:230px;"/>');
		});
		$('#emasterdata').click( function(e){
			e.preventDefault();
			if(rowSelect2 != null)
			{	$('#'+rowSelect2).remove();
				$(".lookuplocationmenu select").append("<br/><br/><br/><br/><br/><input type='text' id='lname' placeholder='Location..' /> <a href='linkurl'>Save</a>");
				$('#lname').val($('#op1').html());
			}
			else
			{
				alert('Select a currency to edit!');				
			}
			});
			
			
			//Delete currency	
		var rowSelect3 = null;
		$('.lookuplocationmenu option').click( function(){
			rowSelect3 = $(this).attr('id');
			$("#lookuplocationcontent").show();
			$('.lookuplocationselected').empty();
			$('.lookuplocationselected').append('<input type="text" class="defaultvalue labelclass" Value="Menu item" style="width:230px;"/>');
		});
			$('#dmasterdata').click( function(e){
			if(rowSelect3 != null)
			{
			var checkstr =  confirm('Are you sure to Delete!!');
					if(checkstr == true){
						$('#'+rowSelect).remove();
					}
			}
			else
			{
				alert('Select a currency to delete!');
			}		
			});
			
			
			
			
			
			//ADD, EDIT and DELETE code for Table
			
			$('#amasterrightdata').click( function(e){
					$(".lookuolocationlower").empty();
				$(".lookuolocationlower").append('<select name="Currency" class="defaultvalue labelclass" style="width:200px;"> <option> Currency </option> </select>                    <label for="Symbol" class="labelclass" style="margin-left:5px;" >Symbol</label>               <input type="text" class="defaultvalue labelclass" placeholder="$" style="width:40px;"/>                <br />           <label for="Symbol" class="labelclass" style="margin-left:5px;" >Conversion Rate</label>               <input type="text" class="defaultvalue labelclass" placeholder="Rate" style="width:40px;"/>                             <label for="Symbol" class="labelclass" style="margin-left:20px;" >Valid from</label>               <input type="text" class="defaultvalue labelclass" placeholder="28/10/2012" style="width:80px;"/>                <br />                  <label for="Symbol" class="labelclass" style="margin-left:205px;" >Valid to</label>               <input type="text" class="defaultvalue labelclass" placeholder="31/10/2012" style="width:80px;"/>');
							});			
			var rowSelecttab = null;
			$('#reviewtable tr').click( function(){
				rowSelecttab = $(this).attr('id');
	
			$('#emasterrightdata').click( function(e){
				if(rowSelecttab != null)
				{
					curr = ($('#'+rowSelecttab+' td:eq(0)').html());
					covrat = ($('#'+rowSelecttab+' td:eq(1)').html());
					valfrm = ($('#'+rowSelecttab+' td:eq(2)').html());
					valto = ($('#'+rowSelecttab+' td:eq(3)').html());
							if(curr == 'Pound')
								{
								$(".lookuolocationlower").empty();
								$(".lookuolocationlower").append('<select name="Currency" class="defaultvalue labelclass" style="width:200px;"> <option selected="selected"> Pound</option> <option> Rupee </option> <option> NZ Dollar</option></select><label for="Symbol" class="labelclass" style="margin-left:5px;" >Symbol</label><input type="text" class="defaultvalue labelclass" value="£" style="width:40px;"/><br /><label for="Symbol" class="labelclass" style="margin-left:5px;" >Conversion Rate</label><input type="text" class="defaultvalue labelclass" value='+covrat+' style="width:60px;"/><label for="Symbol" class="labelclass" style="margin-left:20px;" >Valid from</label><input type="text" class="defaultvalue labelclass" value='+valfrm+' style="width:80px;"/><br /><label for="Symbol" class="labelclass" style="margin-left:205px;" >Valid to</label><input type="text" class="defaultvalue labelclass" value='+valto+' style="width:80px;"/>');
								}
							else if(curr == 'Rupee')
								{
								$(".lookuolocationlower").empty();
								$(".lookuolocationlower").append('<select name="Currency" class="defaultvalue labelclass" style="width:200px;"> <option> Pound</option> <option selected="selected"> Rupee </option> <option> NZ Dollar</option></select><label for="Symbol" class="labelclass" style="margin-left:5px;" >Symbol</label><input type="text" class="defaultvalue labelclass" value="Rs." style="width:40px;"/><br /><label for="Symbol" class="labelclass" style="margin-left:5px;" >Conversion Rate</label><input type="text" class="defaultvalue labelclass" value='+covrat+' style="width:60px;"/><label for="Symbol" class="labelclass" style="margin-left:20px;" >Valid from</label><input type="text" class="defaultvalue labelclass" value='+valfrm+' style="width:80px;"/><br /><label for="Symbol" class="labelclass" style="margin-left:205px;" >Valid to</label><input type="text" class="defaultvalue labelclass" value='+valto+' style="width:80px;"/>');
								}
							else
							{
								$(".lookuolocationlower").empty();
								$(".lookuolocationlower").append('<select name="Currency" class="defaultvalue labelclass" style="width:200px;"> <option> Pound</option> <option> Rupee </option> <option selected="selected"> NZ Dollar</option></select><label for="Symbol" class="labelclass" style="margin-left:5px;" >Symbol</label><input type="text" class="defaultvalue labelclass" value="$NZ" style="width:40px;"/><br /><label for="Symbol" class="labelclass" style="margin-left:5px;" >Conversion Rate</label><input type="text" class="defaultvalue labelclass" value='+covrat+' style="width:60px;"/><label for="Symbol" class="labelclass" style="margin-left:20px;" >Valid from</label><input type="text" class="defaultvalue labelclass" value='+valfrm+' style="width:80px;"/><br /><label for="Symbol" class="labelclass" style="margin-left:205px;" >Valid to</label><input type="text" class="defaultvalue labelclass" value='+valto+' style="width:80px;"/>');
							}
				}
				else
				{
					alert("Select a row to Edit!");
				}
			});

						});

			// Code to Delete Rows
			var rowSelecttab3 = null;
			$('#reviewtable tr').click( function(){
				rowSelecttab3 = $(this).attr('id');
			});

			$('#dmasterrightdata').click( function(e){
						if(rowSelecttab3 != null)
						{
						var checkstr =  confirm('Are you sure to Delete!!');
							if(checkstr == true){
								$('#'+rowSelecttab3).remove();
							}
						}
						else
						{
							alert('Select a currency to delete!');
						}
						
					
						
					});
					
					
					
				//Code to Edit rows
			var rowSelecttab4 = null;
			$('#reviewtable tr').click( function(){
				rowSelecttab4 = $(this).attr('id');
			});
				
			$('#emasterrightdata').click( function(e){
				if(rowSelecttab != null)
				{
					curr = ($('#'+rowSelecttab4+' td:eq(0)').html());
					covrat = ($('#'+rowSelecttab4+' td:eq(1)').html());
					valfrm = ($('#'+rowSelecttab4+' td:eq(2)').html());
					valto = ($('#'+rowSelecttab4+' td:eq(3)').html());
							if(curr == 'Pound')
								{
								$(".lookuolocationlower").empty();
								$(".lookuolocationlower").append('<select name="Currency" class="defaultvalue labelclass" style="width:200px;"> <option selected="selected"> Pound</option> <option> Rupee </option> <option> NZ Dollar</option></select><label for="Symbol" class="labelclass" style="margin-left:5px;" >Symbol</label><input type="text" class="defaultvalue labelclass" value="£" style="width:40px;"/><br /><label for="Symbol" class="labelclass" style="margin-left:5px;" >Conversion Rate</label><input type="text" class="defaultvalue labelclass" value='+covrat+' style="width:60px;"/><label for="Symbol" class="labelclass" style="margin-left:20px;" >Valid from</label><input type="text" class="defaultvalue labelclass" value='+valfrm+' style="width:80px;"/><br /><label for="Symbol" class="labelclass" style="margin-left:205px;" >Valid to</label><input type="text" class="defaultvalue labelclass" value='+valto+' style="width:80px;"/>');
								}
							else if(curr == 'Rupee')
								{
								$(".lookuolocationlower").empty();
								$(".lookuolocationlower").append('<select name="Currency" class="defaultvalue labelclass" style="width:200px;"> <option> Pound</option> <option selected="selected"> Rupee </option> <option> NZ Dollar</option></select><label for="Symbol" class="labelclass" style="margin-left:5px;" >Symbol</label><input type="text" class="defaultvalue labelclass" value="Rs." style="width:40px;"/><br /><label for="Symbol" class="labelclass" style="margin-left:5px;" >Conversion Rate</label><input type="text" class="defaultvalue labelclass" value='+covrat+' style="width:60px;"/><label for="Symbol" class="labelclass" style="margin-left:20px;" >Valid from</label><input type="text" class="defaultvalue labelclass" value='+valfrm+' style="width:80px;"/><br /><label for="Symbol" class="labelclass" style="margin-left:205px;" >Valid to</label><input type="text" class="defaultvalue labelclass" value='+valto+' style="width:80px;"/>');
								}
							else
							{
								$(".lookuolocationlower").empty();
								$(".lookuolocationlower").append('<select name="Currency" class="defaultvalue labelclass" style="width:200px;"> <option> Pound</option> <option> Rupee </option> <option selected="selected"> NZ Dollar</option></select><label for="Symbol" class="labelclass" style="margin-left:5px;" >Symbol</label><input type="text" class="defaultvalue labelclass" value="$NZ" style="width:40px;"/><br /><label for="Symbol" class="labelclass" style="margin-left:5px;" >Conversion Rate</label><input type="text" class="defaultvalue labelclass" value='+covrat+' style="width:60px;"/><label for="Symbol" class="labelclass" style="margin-left:20px;" >Valid from</label><input type="text" class="defaultvalue labelclass" value='+valfrm+' style="width:80px;"/><br /><label for="Symbol" class="labelclass" style="margin-left:205px;" >Valid to</label><input type="text" class="defaultvalue labelclass" value='+valto+' style="width:80px;"/>');
							}
				}
				else
				{
					alert("Select a row to Edit!");
				}
		
			});
			
			
			
			
});
			