  $(document).ready(function(e) {
	 	 $(".selsubject").hide();
		 $(".seltopic").hide();
            var cate=3;
			$('#amastercatdata').click( function(e){
				cate++;		
				
			$("#descarea").empty();		
			$("#descarea").append('<div id="lookupmenudescription" class="lookupleft" style="width:210px;"><label for="value" class="labelclass lookupleft" style="margin-top:7px; margin-right:5px;"> Value </label><input type="text" class="defaultvalue labelclass lookupright"  value="Menu item" style="width:150px;" />                    <br />                    <br />                    <br />                    <input type="checkbox" class="defaultvalue labelclass" style="margin-left:120px;" checked="checked"/>  <span class="labelclass"> Active </span>                    </div>');
			
			
			//code to delete added category
			var catSelect = null;
		$('.selcategory option').click( function(){
			catSelect = $(this).attr('id');
		
		
		$('#dmastercatdata').click( function(e){
			if(catSelect != null)
			{
				$('#'+catSelect).remove();
			}
			});
		
		
			//Edit Category
			//Edit category
		$('#emastercatdata').click( function(e){
			e.preventDefault();
			if(catSelect !=  null)
			
			{	
			$('#'+catSelect).remove();
			$("#descarea").empty();		
			$("#descarea").append('<div id="lookupmenudescription" class="lookupleft" style="width:210px;"><label for="value" class="labelclass lookupleft" style="margin-top:7px; margin-right:5px;"> Value </label><input type="text" class="defaultvalue labelclass lookupright"  value="Menu item" style="width:150px;" />                    <br />                    <br />                    <br />                    <input type="checkbox" class="defaultvalue labelclass" style="margin-left:120px;" checked="checked"/>  <span class="labelclass"> Active </span>                    </div>');

				$('#lname').val($('#cat1').html());
				
			}
			else
			{
				alert("Select a value before editing!");
			}
			});
		});
	});
			
			
//delete category
		var catSelect2 = null;
		$('.selcategory option').click( function(){
			catSelect2 = $(this).attr('id');
		});
		
		$('#dmastercatdata').click( function(e){
			if(catSelect2 != null)
			{
				$('#'+catSelect2).remove();
			}						
			else
			{alert("Select value before Delete!");}
			
		});
		
		
		//Edit category
		var catSelect3;
		$('.selcategory option').click( function(){
			catSelect3 = $(this).attr('id');
		});
		$('#emastercatdata').click( function(e){
			e.preventDefault();
			if(catSelect3)
			
			{	
			$('#'+catSelect3).remove();
						$("#descarea").empty();		
			$("#descarea").append('<div id="lookupmenudescription" class="lookupleft" style="width:210px;"><label for="value" class="labelclass lookupleft" style="margin-top:7px; margin-right:5px;"> Value </label><input type="text" class="defaultvalue labelclass lookupright"  value="Menu item" style="width:150px;" />                    <br />                    <br />                    <br />                    <input type="checkbox" class="defaultvalue labelclass" style="margin-left:120px;" checked="checked"/>  <span class="labelclass"> Active </span>                    </div>');
	
			}
			else
			{alert("Select value before edit!");}
		});
		
		
		
		
		
		$('#lookupmenucategory').change( function () {
			 if ($('#lookupmenucategory').val() == "Menu item"){
				 $(".selsubject").show();
			 }
		});
		
		$('#lookupmenusubject').change( function () {
			 if ($('#lookupmenusubject').val() == "Menu item"){
				 $(".seltopic").show();
			 }
		});
		
		
		
		//Code for subject
		
		
		 var cate=3;
			$('#amastersubdata').click( function(e){
				cate++;				
			$("#descsub").empty();
			$("#descsub").append('<div id="lookupmenudescription" class="lookupleft" style="width:210px;"><label for="value" class="labelclass lookupleft" style="margin-top:7px; margin-right:5px;"> Value </label> <input type="text" class="defaultvalue labelclass" value="Menu item" style="width:150px;" />                    <br />                    <br />                    <input type="checkbox" class="defaultvalue labelclass" style="margin-left:120px;" checked="checked"/>  <span class="labelclass"> Active </span>                    </div>');
			
			
			//code to delete added category
			var catSelect = null;
		$('.selsubject option').click( function(){
			catSelect = $(this).attr('id');
		
		
		$('#dmastersubdata').click( function(e){
			if(catSelect != null)
			{
				$('#'+catSelect).remove();
			}
									else
			{alert("Select value before Delete!");}
			});
		
		
			//Edit Category
			//Edit category
		$('#emastersubdata').click( function(e){
			e.preventDefault();
			if(catSelect !=  null)
			
			{	$('#'+catSelect).remove();
			$("#descsub").empty();
			$("#descsub").append('<div id="lookupmenudescription" class="lookupleft" style="width:210px;"><label for="value" class="labelclass lookupleft" style="margin-top:7px; margin-right:5px;"> Value </label> <input type="text" class="defaultvalue labelclass" value="Menu item" style="width:150px;" />                    <br />                    <br />                    <input type="checkbox" class="defaultvalue labelclass" style="margin-left:120px;" checked="checked"/>  <span class="labelclass"> Active </span>                    </div>');
			}
			else
			{alert("Select value before edit!");}

			});
		});
	});
			
			
//delete category
		var catSelect6 = null;
		$('.selsubject option').click( function(){
			catSelect6 = $(this).attr('id');
		});
		
		$('#dmastersubdata').click( function(e){
			if(catSelect6 != null)
			{
				$('#'+catSelect6).remove();
			}
									else
			{alert("Select value before Delete!");}
			
		});
		
		
		//Edit category
		var arSelect3;
		$('.selsubject option').click( function(){
			arSelect3 = $(this).attr('id');
		});
		$('#emastersubdata').click( function(e){
			e.preventDefault();
			if(arSelect3)
			
			{	$('#'+arSelect3).remove();
			$("#descsub").empty();
			$("#descsub").append('<div id="lookupmenudescription" class="lookupleft" style="width:210px;"><label for="value" class="labelclass lookupleft" style="margin-top:7px; margin-right:5px;"> Value </label> <input type="text" class="defaultvalue labelclass" value="Menu item" style="width:150px;" />                    <br />                    <br />                    <input type="checkbox" class="defaultvalue labelclass" style="margin-left:120px;" checked="checked"/>  <span class="labelclass"> Active </span>                    </div>');
			}
			else
			{alert("Select value before edit!");}
		});
		
			
			
			
			
			
		//code for Topic
		
		
		 var cate=3;
			$('#amastertopdata').click( function(e){
				cate++;				
			$("#desctopic").empty();
			$("#desctopic").append('<div id="lookupmenudescription" class="lookupleft" style="width:210px;"><label for="value" class="labelclass lookupleft" style="margin-top:7px; margin-right:5px;"> Value </label><input type="text" class="defaultvalue labelclass" value="Menu item" style="width:150px;" />                <br />                <br />                <input type="checkbox" class="defaultvalue labelclass" style="margin-left:120px;" checked="checked"/>  <span class="labelclass"> Active </span>                </div>');				 
			
			
			//code to delete added category
			var catSelect = null;
		$('.seltopic option').click( function(){
			catSelect = $(this).attr('id');
		
		
		$('#dmastertopdata').click( function(e){
			if(catSelect != null)
			{
				$('#'+catSelect).remove();
			}
			else
			{alert("Select value before Delete!");}
			});
		
		
			//Edit Category
			//Edit category
		$('#emastertopdata').click( function(e){
			e.preventDefault();
			if(catSelect !=  null)
			
			{	$('#'+catSelect).remove();
			$("#desctopic").empty();
			$("#desctopic").append('<div id="lookupmenudescription" class="lookupleft" style="width:210px;"><label for="value" class="labelclass lookupleft" style="margin-top:7px; margin-right:5px;"> Value </label><input type="text" class="defaultvalue labelclass" value="Menu item" style="width:150px;" />                <br />                <br />                <input type="checkbox" class="defaultvalue labelclass" style="margin-left:120px;" checked="checked"/>  <span class="labelclass"> Active </span>                </div>');				 
			}
			else
			{alert("Select value before edit!");}
			});
		});
	});
			
			
//delete category
		var catSelect8 = null;
		$('.seltopic option').click( function(){
			catSelect8 = $(this).attr('id');
		});
		
		$('#dmastertopdata').click( function(e){
			if(catSelect8 != null)
			{
				$('#'+catSelect8).remove();
			}
			else
			{alert("Select value before Delete!");}

			
		});
		
		
		//Edit category
		var topSelect3;
		$('.seltopic option').click( function(){
			topSelect3 = $(this).attr('id');
		});
		$('#emastertopdata').click( function(e){
			e.preventDefault();
			if(topSelect3 != null)
			{	
			$('#'+topSelect3).remove();
			$("#desctopic").empty();
			$("#desctopic").append('<div id="lookupmenudescription" class="lookupleft" style="width:210px;"><label for="value" class="labelclass lookupleft" style="margin-top:7px; margin-right:5px;"> Value </label><input type="text" class="defaultvalue labelclass" value="Menu item" style="width:150px;" />                <br />                <br />                <input type="checkbox" class="defaultvalue labelclass" style="margin-left:120px;" checked="checked"/>  <span class="labelclass"> Active </span>                </div>');				 
			}
			else
			{alert("Select value before edit!");}
		});
			
			
});