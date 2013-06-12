// JavaScript Document

$(document).ready(function(e) {
  //code for the upload document page 

	//$("#createcntsbt").click(function(e){
		//alert();
		  //im0 = "excel.png"; // the icon for a leaf node
		  //im1 = "excel.png"; // the icon for an expanded parent node
		  //im2 = "excel.png";
		  //var d=new Date(); tree.insertNewChild(tree.getSelectedItemId(),'excel' + d.valueOf(),'hwefg',0,im0,im1,im2,'SELECT');
		  //tree.smartRefreshItem(0);
		//alert();		
	//});
  
	$(".editable").bind("dblclick", replaceHTML);
	 
	 
	$(".btnSave").live("click", 
					function()
					{
						$(".edittxt").css('height','0');
						newText = $(this).siblings("form")
										 .children(".editBox")
										 .val().replace(/"/g, "&quot;");
										 
						$(this).parent()
							   .html(newText)
							   .removeClass("noPad")
							   .bind("dblclick", replaceHTML);
					}
					); 
	
	$(".btnDiscard").live("click", 
					function()
					{
						$(".edittxt").css('height','0');
						$(this).parent()
							   .html(oldText)
							   .removeClass("noPad")
							   .bind("dblclick", replaceHTML);
					}
					); 
	
	function replaceHTML()
					{
						oldText = $(this).html()
										 .replace(/"/g, "&quot;");
						$(this).addClass("noPad")
							   .html("")
							   .html("<div class=\"edittxt\" style=\"height:10px;\"><form style=\"margin-bottom:0;\"><input type=\"text\" class=\"editBox defaultvalue\" value=\"" + oldText + "\" /> </form><a href=\"#\" style=\"margin-left:10px; margin-top:-10px;\" class=\"btnSave\">Save</a> <a href=\"#\" style=\"margin-left:20px;\" class=\"btnDiscard\">Cancel</a></div>")
							   .unbind('dblclick', replaceHTML);
			
					}
					
					
					$("#_edit").click(function() { 
						$("#_editable").dblclick(); 
						});
						
					$("#_edit2").click(function() { 
						$("#_editable2").dblclick(); 
						});	
						
						
					$(".deleteupl").click(function() { 
						var chkstr = confirm("Are you sure you want to delete this?");
						if(chkstr == true)
						{
							//var par = $(this).parent('ul').attr('id');
							var parentTag = $(this).closest("ul").attr("id");
							$("#"+parentTag).fadeOut();
						}
					});	
					









					
					
					
//code for teh createdocument page

	$(".docdtlcontainer").hide();
		$('._plainText').hide();
		$('._richTextShow').hide();
		
		$('._richText').click( function(){
			$('._richText').hide();
			$('._plainTextShow').hide();
			$('#topicreplydesc').hide();
			$('._plainText').show();
			$('._richTextShow').show();
		});
		
		$('._plainText').click( function(){
			$('._richText').show();
			$('._plainTextShow').show();
			$('#topicreplydesc').show();
			$('._plainText').hide();
			$('._richTextShow').hide();
		});
		
		
			$("#edtdocdtllnk").click(function(e) {
                //$("#edtdocdtllnk").fadeOut();
				$(".docdtlcontainer").slideDown();

					$(".btn").click(function(e) {
                         $("#edtdocdtllnk").fadeIn();
						 $(".docdtlcontainer").slideUp();
                    });
				
            });
								
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
		




//Code for the multiple uploadcontent1

		

});
					
