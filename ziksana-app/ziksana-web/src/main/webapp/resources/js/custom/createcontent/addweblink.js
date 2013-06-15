// JavaScript Document
$(document).ready(function(e) {

	weblink_row_count = 1;

	$(".adlink").click(function(e) {
		
		weblink_container = $('#web_link_container');
		weblink_div = '<div class="weblink_row">';
		weblink_div += weblink_container.find('div.weblink_row').first().html();
		weblink_div += '</div>';
				
		weblink_container.append(weblink_div);
		added_weblink_div = weblink_container.find('div.weblink_row').last();
		

		/*$(".weblinkcontainer").append('<div class="uploadroweven" style="padding: 10px;"><div class="uploadphoto pull-left" style="width: 350px"><div class="fileupload fileupload-new" data-provides="fileupload"> <img src="../../resources/images/preview/link.png" style="width: 100px; margin-bottom: 5px;" align="left"/> <div class="fileupload-preview fileupload-exists thumbnail" style="width: 120px; height: 100px;"></div>  <span class="btn btn-file"><span class="fileupload-new">Upload image</span><span class="fileupload-exists">Change</span><input type="file" /></span>  <a href="#" class="btn fileupload-exists" data-dismiss="fileupload">Remove</a></div>   </div> <!--end of uploadphoto--><div class="rowfields pull-left"><ul><li><input type="text" placeholder="Enter Name" style="height:25px; margin-top:15px; width:150px;"/> </li><li><input type="text" placeholder="htttp://" style="height:25px; margin-top:15px; width:150px;"/> </li><li><a href="#linkurl" class=editdetailsweblink'+value+'>Edit Details</a></li></ul></div> <!--end of rowfields--><div class="clearfix"></div><div class="editslidecontainer"> <div class="editslide pull-left"><textarea rows="4" cols="12" style="width:374px; margin-bottom:10px;">Details for the Web link </textarea> </div><div class="editslide pull-left" style="margin-left:5px;"><input type="text" placeholder="Specify Tags" style="height: 30px;margin-top: 7px;width: 220px;"><select><option> Specify Subject </option> </select> <br><select><option> Specify Subject </option> </select>  <select><option> Specify Subject </option> </select></div></div><div class="clearfix"></div> </div><!-- end of uploadrow-->');
		$('.editslidecontainer').hide();
			$(".editdetailsweblink"+value).click(function() 
			{
				$('.uploadroweven').find('.editslidecontainer').toggle();

			});
			
			weblink_row_count++;
*/

		
		
		
	   });
	   
	   
$(".editdetailsweblink").click(function(){
			$('.editslide').toggle();
});



});