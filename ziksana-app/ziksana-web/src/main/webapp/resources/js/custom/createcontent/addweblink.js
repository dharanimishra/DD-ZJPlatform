// JavaScript Document
$(document).ready(function(e) {
    var counterodd = 1;
	var countereven = 2;
	var value = 3;
	$(".adlink").click(function(e) {
		if((value%2) == 0)
		{
		$(".weblinkcontainer").append('<div class="uploadroweven"><div class="uploadphoto pull-left"><div class="fileupload fileupload-new" data-provides="fileupload">  <div class="fileupload-new thumbnail" style="width: 80px; height: 80px;"><img src="http://www.placehold.it/80x80/EFEFEF/AAAAAA" /></div>  <div class="fileupload-preview fileupload-exists thumbnail" style="width: 120px; height: 100px;"></div>  <span class="btn btn-file"><span class="fileupload-new">Upload image</span><span class="fileupload-exists">Change</span><input type="file" /></span>  <a href="#" class="btn fileupload-exists" data-dismiss="fileupload">Remove</a></div>   </div> <!--end of uploadphoto--><div class="rowfields pull-left"><ul><li><input type="text" placeholder="Enter Name" style="height:25px; margin-top:15px; width:150px;"/> </li><li><input type="text" placeholder="Htttp://" style="height:25px; margin-top:15px; width:150px;"/> </li><li><a href="#linkurl" class=editdetailsweblink'+value+'>Edit Details</a></li></ul></div> <!--end of rowfields--><div class="clearfix"></div><div class="editslidecontainer"> <div class="editslide pull-left"><textarea rows="4" cols="12" style="width:374px; margin-bottom:10px;">Details for the Web link </textarea> </div><div class="editslide pull-left" style="margin-left:5px;"><input type="text" placeholder="Specify Tags" style="height: 30px;margin-top: 7px;width: 220px;"><select><option> Specify Subject </option> </select> <br><select><option> Specify Subject </option> </select>  <select><option> Specify Subject </option> </select></div></div><div class="clearfix"></div> </div><!-- end of uploadrow-->');
		$('.editslidecontainer').hide();
			$(".editdetailsweblink"+value).click(function()
			{
				$('.uploadroweven').find('.editslidecontainer').toggle();
				//$(this).closest('.editslidecontainer').toggle();
				//var parentTag = $(this).find.closest(".editslidecontainer").toggle();
				//alert(parentTag);
				//alert(value);
			//$('.editslide').toggle();
			});
			
					value++;

		}
		
		
		else
		{
		$(".weblinkcontainer").append('<div class="uploadrowodd"><div class="uploadphoto pull-left"><div class="fileupload fileupload-new" data-provides="fileupload">  <div class="fileupload-new thumbnail" style="width: 80px; height: 80px;"><img src="http://www.placehold.it/80x80/EFEFEF/AAAAAA" /></div>  <div class="fileupload-preview fileupload-exists thumbnail" style="width: 120px; height: 100px;"></div>  <span class="btn btn-file"><span class="fileupload-new">Upload image</span><span class="fileupload-exists">Change</span><input type="file" /></span>  <a href="#" class="btn fileupload-exists" data-dismiss="fileupload">Remove</a></div>   </div> <!--end of uploadphoto--><div class="rowfields pull-left"><ul><li><input type="text" placeholder="Enter Name" style="height:25px; margin-top:15px; width:150px;"/> </li><li><input type="text" placeholder="Htttp://" style="height:25px; margin-top:15px; width:150px;"/> </li><li><a href="#linkurl" class=editdetailsweblink'+value+'>Edit Details</a></li></ul></div> <!--end of rowfields--><div class="clearfix"></div><div class="editslidecontainer"> <div class="editslide pull-left"><textarea rows="4" cols="12" style="width:374px; margin-bottom:10px;">Details for the Web link </textarea> </div><div class="editslide pull-left" style="margin-left:5px;"><input type="text" placeholder="Specify Tags" style="height: 30px;margin-top: 7px;width: 220px;"><select><option> Specify Subject </option> </select> <br><select><option> Specify Subject </option> </select>  <select><option> Specify Subject </option> </select></div></div><div class="clearfix"></div> </div><!-- end of uploadrow-->');
		$('.editslidecontainer').hide();
		
			$(".editdetailsweblink"+value).click(function()
			{
				$('.uploadrowodd').find('.editslidecontainer').toggle();
				//alert(value);
			//$('.editslide'+value).toggle();
			});

		value++;
		}
	   });
	   
	   
$(".editdetailsweblink").click(function()
			{
			$('.editslide').toggle();
			});



});