<input type="hidden" value="${courseId}" id="e_course_id"/>
<input type="hidden" value="${contentId}" id="e_content_id"/>
<input type="hidden" value="${componentId}" id="e_component_id"/>


<!-- <script type="text/javascript" src="js/video_player.js"></script> -->
<script type="text/javascript" src="/ziksana-web/resources/js/jquery-1.7.2.min.js"></script>

<script type="text/javascript" src="/ziksana-web/resources/js/custom/course_enrichment.js"></script>
<script type='text/javascript' src="/ziksana-web/resources/jwplayer/swfobject.js"></script>
<script type="text/javascript" src="/ziksana-web/resources/jwplayer/jwplayer.js"></script>


	<div id="video">
		<div id="mediaplayer"></div>

		<script type="text/javascript">
		
		function secondsToHms(d) {
			d = Number(d);
			var h = Math.floor(d / 3600);
			var m = Math.floor(d % 3600 / 60);
			var s = Math.floor(d % 3600 % 60);
			return ((h > 0 ? h + ":" : "") + (m > 0 ? (h > 0 && m < 10 ? "0" : "") + m + ":" : "0:") + (s < 10 ? "0" : "") + s); 
			}
		
		var MediaServerDomainUrl = 'http://54.243.235.88';
		var MediaUploadDirectory = 'http://54.243.235.88/zikload-xml/uploads';
		
			var flashvars = {
				'file' : 'http://54.243.235.88/zikload-xml/uploads${content.contentUrl}',
				'provider' : 'http',
				'http.startparam' : 'starttime',
				'autostart':'true'
			};

			var params = {
				'allowfullscreeninteractive' : 'true',
				'allowscriptaccess' : 'always'

			};

			var attributes = {
				'id' : 'playerID',
				'name' : 'playerID'
			};

			swfobject.embedSWF('/ziksana-web/resources/jwplayer/enrich-player.swf', 'mediaplayer',
					'550', '400', '9', 'false', flashvars, params, attributes,
					flashloaded);
			var reftoplayer;
			function flashloaded(e) {
				reftoplayer = e.ref;
				
			}
			
			var add_educator_content = function(content_type, course_id, node_id, duration, title, description, coordinates, url, parentid){
				console.log('inside add educator content');
				//TO BE IMPLEMENTED.
				content_id = $('#e_content_id').val();
				component_id = $('#e_component_id').val();
				
				node_id = 'LCONTENT_1_'+component_id+'_'+content_id;
				
				$.post('/ziksana-web/secure/addEducatorNote', {'contentType':content_type, 'courseId':course_id, 'nodeId':node_id, 'duration':duration, 'title':title, 'description':description, 'coordinates':coordinates, 'url':url, 'parentId':parentid}, function(data){
					
					if(data == '1'){ //add is successful
						
						get_all_educator_content(course_id, component_id, node_id);

						jwplayer(reftoplayer).seek(duration); //resume playback from the position stopped.
						
					}
					
				});
				
			}
			
			
			var educator_toc_items_string = '';
			
			function ff_get_toc(){ 
				
				return educator_toc_items_string;
			}
			
			var get_all_educator_content = function(course_id, component_id, node_id){
				educator_toc_items_string = ''; //reset the options string
				console.log('inside get_all_educator_content');
				
				$.get('/ziksana-web/secure/getAllEducatorContent', {'courseId':course_id, 'nodeId':node_id, 'componentId':component_id}, function(data){
					
					
					data_table_tbody_html = '';
					$('select#ec_parentid').html(''); //empty the select dropdown options
					$('select#ec_parentid').append('<option value="">Select One</option>');
					
					for(i in data){
					
					
						educatorContentType = data[i].contentType;
						id = data[i].id;
						duration = data[i].duration;
						formated_duration = secondsToHms(duration);
						title = data[i].title;
						description = data[i].description;
						coordinates = data[i].coordinates;
						url = data[i].url;
						parentId = data[i].parentId;
						
						
						if(educatorContentType == 8){ //8 = Educator Note
							data_table_tbody_html += '<tr><td>Note</td><td><strong onclick="jwplayer(reftoplayer).seek('+duration+')">'+title+'</strong></td><td>'+description+'</td><td>'+formated_duration+'</td><td><img onclick="delete_educator_content($(this));" data-id="'+id+'" src="/ziksana-web/resources/images/delete.jpg"><span onclick="prepare_to_update_educator_content($(this));" data-type="note" data-id="'+id+'" data-duration="'+duration+'" data-title="'+title+'" data-description="'+description+'" data-coordinates="'+coordinates+'" data-url="'+url+'" data-parentid=""><img src="/ziksana-web/resources/images/edit.png"/></span></td></tr>';
						}
						if(educatorContentType == 1){ //1 = Educator Reference
							data_table_tbody_html += '<tr><td>Reference</td><td><strong onclick="jwplayer(reftoplayer).seek('+duration+')">'+title+'</strong></td><td>'+url+'</td><td>'+formated_duration+'</td><td><img onclick="delete_educator_content($(this));" data-id="'+id+'" src="/ziksana-web/resources/images/delete.jpg"><span onclick="prepare_to_update_educator_content($(this));" data-type="reference" data-id="'+id+'" data-duration="'+duration+'" data-title="'+title+'" data-description="'+description+'" data-coordinates="'+coordinates+'" data-url="'+url+'" data-parentid=""><img src="/ziksana-web/resources/images/edit.png"/></span></td></tr>';
						}
						if(educatorContentType == 9){ //9 = Educator HotSpot
							data_table_tbody_html += '<tr><td>Hotspot</td><td><strong onclick="jwplayer(reftoplayer).seek('+duration+')">'+title+'</strong></td><td></td><td>'+formated_duration+'</td><td><img onclick="delete_educator_content($(this));" data-id="'+id+'" src="/ziksana-web/resources/images/delete.jpg"><span onclick="prepare_to_update_educator_content($(this));" data-type="hotspot" data-id="'+id+'" data-duration="'+duration+'" data-title="'+title+'" data-description="'+description+'" data-coordinates="'+coordinates+'" data-url="'+url+'" data-parentid=""><img src="/ziksana-web/resources/images/edit.png"/></span></td></tr>';
						}
						if(educatorContentType == 7){ //7 = TOC
							option_html = '<option value="'+id+'">'+title+'</option>';
							educator_toc_items_string += id+'||'+title+'|||';
							$('select#ec_parentid').append(option_html);
							data_table_tbody_html += '<tr><td>TOC Item</td><td><strong onclick="jwplayer(reftoplayer).seek('+duration+')">'+title+'</strong></td><td>&nbsp</td><td>'+formated_duration+'</td><td><img onclick="delete_educator_content($(this));" data-id="'+id+'" src="/ziksana-web/resources/images/delete.jpg"><span onclick="prepare_to_update_educator_content($(this));" data-type="toc" data-id="'+id+'" data-duration="'+duration+'" data-title="'+title+'" data-description="'+description+'" data-coordinates="'+coordinates+'" data-url="'+url+'" data-parentid="'+parentId+'"><img src="/ziksana-web/resources/images/edit.png"/></span></td></tr>';
						}
					
					}
					
					$('#dataTable tbody').html(data_table_tbody_html);
					
					
				});
				
			}

			
			var prepare_to_update_educator_content = function(edit_icon){

				enrich_id = edit_icon.attr('data-id');
				duration = edit_icon.attr('data-duration');
				title = edit_icon.attr('data-title');
				description = edit_icon.attr('data-description');
				coordinates = edit_icon.attr('data-coordinates');
				url = edit_icon.attr('data-url');
				type = edit_icon.attr('data-type');
				parentId = edit_icon.attr('data-parentid');

				
				//reset these fields
				$('#ec_enrich_id').val('');
				$('#ec_duration').val('');
				$('#ec_title').val('');
				$('#ec_description').val('');
				$('#ec_coordinates').val('');
				$('#ec_url').val('');
				$('#ec_parentid').val('');
				
				//hide the labels
				 $('#l_ec_title, #l_ec_description, #l_ec_url, #l_ec_parentid').hide();

				//Populate the content from the variables recieved.
				$('#ec_enrich_id').val(enrich_id);
				$('#ec_duration').val(duration);
				$('#ec_title').val(title);
				$('#ec_description').val(description);
				$('#ec_coordinates').val(coordinates);
				$('#ec_url').val(url);
				$('#ec_parentid').val(parentId);

				//show the appropriate form fields based on the content type
				if(type == 'note'){ $('#l_ec_title, #l_ec_description').show(); $('.educator_content_type').html('Note');}
				if(type == 'reference'){ $('#l_ec_title, #l_ec_url').show(); $('.educator_content_type').html('Reference');}
				if(type == 'toc'){ $('#l_ec_title, #l_ec_parentid').show(); $('.educator_content_type').html('TOC Item');}
				if(type == 'hotspot'){ $('#l_ec_title').show(); $('.educator_content_type').html('Hotspot');}


				//Finally, show the form for the user to edit.
				$('#edit_educator_content').show();
				
				
			}
			
			var update_educator_content = function(){

				//get the edited variables
				id = $('#ec_enrich_id').val();
				duration = $('#ec_duration').val();
				title = $('#ec_title').val();
				description = $('#ec_description').val();
				coordinates = $('#ec_coordinates').val();
				url = $('#ec_url').val();
				parentid = $('#ec_parentid').val();

				$.post('/ziksana-web/secure/editEducatorContent', {id:id, duration:duration, title:title, description:description, coordinates:coordinates, url:url, parentId:parentid }, function(data){

					if(data == 1){ //record is successfully updated
						refresh_educator_content();
					
						$('#edit_educator_content').fadeOut();
					}

				});

			}
			
			var delete_educator_content = function(delete_icon){
				row_to_delete = delete_icon.parents('tr');
				content_id = delete_icon.attr('data-id');
				$.post('/ziksana-web/secure/deleteEducatorContent', {eduContentEnrichId: content_id}, function(data){
					if(data == 1){//row is successfully deleted
						//go ahead and remove the row.
						row_to_delete.remove();
						
					}
					
				});
				
			}
						

			

			var ff_add_note = function(note) {
				
				//console.log('inside ff_add_note s');
				var delim1 = note.indexOf("||");
				var note_title = note.substring(0, delim1);
				note = note.substring(delim1 + 2);
				var delim2 = note.indexOf("||");
				var note_desc = note.substring(0, delim2);
				note = note.substring(delim2 + 2);
				var note_time = Math.floor(note);
				console.log('note time is: '+ note_time);
				//window.alert("You have Added Note ITEM: "+note_title+ " descibed as " +  note_desc+ " at time " + note_time);
				
				


				content_type = "8"; //8 for note
				course_id = $('#e_course_id').val();
				console.log('course_id is '+course_id);
				node_id = $('#e_content_id').val();
				console.log('nodese_id is '+node_id);
				duration = Math.floor(note_time);
				
				title = note_title;
				description = note_desc;
				coordinates = 'none';
				url = 'asd';
				console.log("BFR VALL");
				display_msg(content_type, course_id, node_id, duration, title, description, coordinates, url);
				parentid = '0';
				add_educator_content(content_type, course_id, node_id, duration, title, description, coordinates, url, parentid);
				console.log("AFT CALL"); 	 
			}
			
			var display_msg = function(content_type, course_id, node_id, duration, title, description, coordinates, url){
				console.log("DISPLAYING FUNcTION");
			}

			var ff_add_reference = function(note) {
				//console.log('inside ff_add_reference');
				var delim1 = note.indexOf("||");
				var note_title = note.substring(0, delim1);
				note = note.substring(delim1 + 2);
				var delim2 = note.indexOf("||");
				var note_desc = note.substring(0, delim2);
				note = note.substring(delim2 + 2);
				var note_time = note;
				

				/*
				note_anchor_string = '<a title="'+note_desc+'" onclick="jwplayer().seek('+note_time+').play(true);" data-iconprefix="note">'+note_title+'</a>';
				$('#notes_and_bookmarks_container').append(note_anchor_string);*/
				
				content_type = 1; //1 for reference
				course_id = $('#e_course_id').val();
				node_id = $('#e_content_id').val();
				duration = Math.floor(note_time);
				title = note_title;
				description = '';
				coordinates = '';
				url = note_desc;
				parentid = '0';
				add_educator_content(content_type, course_id, node_id, duration, title, description, coordinates, url, parentid);
			
			}

			var ff_add_hs = function(note) {
				console.log('inside ff_add_hs');
				var delim1 = note.indexOf("||");
				var note_title = note.substring(0, delim1);
				note = note.substring(delim1 + 2);
				var delim2 = note.indexOf("||");
				var note_desc = note.substring(0, delim2);
				note = note.substring(delim2 + 2);
				var note_time = note;
				
				//jwplayer(reftoplayer).play();

				/*
				note_anchor_string = '<a title="'+note_desc+'" onclick="jwplayer().seek('+note_time+').play(true);" data-iconprefix="note">'+note_title+'</a>';
				$('#notes_and_bookmarks_container').append(note_anchor_string);*/

				content_type = 9; //9 for hotspot
				course_id = $('#e_course_id').val();
				node_id = $('#e_content_id').val();
				duration = Math.floor(note_time);
				title = note_title;
				coordinates = note_desc;
				description = '';
				url = '';
				parentid = '0';
				add_educator_content(content_type, course_id, node_id, duration, title, description, coordinates, url, parentid);
			
			}

			var ff_add_toc = function(note) {
				//console.log('inside ff_add_toc');
				var delim1 = note.indexOf("||");
				var note_title = note.substring(0, delim1);
				note = note.substring(delim1 + 2);
				var delim2 = note.indexOf("||");
				var note_desc = note.substring(0, delim2);
				note = note.substring(delim2 + 2);
				var note_time = note;
				//window.alert("You have Added TOC ITEM: " + note_titles	+ " under " + note_desc + " at time " + note_time);



				content_type = 7; //7 for toc
				course_id = $('#e_course_id').val();
				node_id = $('#e_content_id').val();
				duration = Math.floor(note_time);
				title = note_title;
				description = note_desc; // will carry parent node id
				coordinates = '';
				url = '';
				//parentItemString = note_desc;
				//parentid = note_desc;
				parentid = '0';
				
				add_educator_content(content_type, course_id, node_id, duration, title, description, coordinates, url, parentid);
			
			}

			var ff_pause_player = function() {
				if (jwplayer(reftoplayer).getState() == "PLAYING"){
					jwplayer(reftoplayer).pause();
				}
			}

			var ff_get_position = function() {
				var position = jwplayer(reftoplayer).getPosition();
				//console.log(position);
				return position + "";
			}





			var ff_play_position = function(e) {
				jwplayer(reftoplayer).seek(e).play(true);
			}
			
			
			
			var refresh_educator_content = function(){
			
			content_id = $('#e_content_id').val();
			component_id = $('#e_component_id').val();
			course_id = $('#e_course_id').val();
			
			node_id = 'LCONTENT_1_'+component_id+'_'+content_id;
			
			get_all_educator_content(course_id, component_id, node_id);
			}
			
			refresh_educator_content();
			
			
			
		</script>


	</div>

	<div class="tableofcontent">

		<table align="left" id="dataTable" class="table table-hover enrich_table"
			style="width: 550px;">
			<thead
				style="font-size: 8px; font-family: tahoma; font-style: normal; color: #666;">
				<tr style="background-color: #E1E8F0;">
					<th width="15%">Type</th>
					<th width="20%">Name</th>
					<th width="40%">Details</th>
					<th width="21%">Time on video</th>
					<th width="4%"></th>
				</tr>

			</thead>
			<tbody>


			</tbody>
		</table>

	</div>
	
	<div id="edit_educator_content" style="display:none;">
		<h2>Edit <span class="educator_content_type">Type</span></h2><hr/>
		<input type="hidden" id="ec_enrich_id" value=""/>
		<input type="hidden" id="ec_duration" value=""/>
		<label id="l_ec_title">Title:<br/><input type="text" id="ec_title" value=""/></label>
		<label id="l_ec_description">Description: <br/><textarea id="ec_description"></textarea></label>
		<input type="hidden" id="ec_coordinates" value=""/>
		<label id="l_ec_url">Url: <br/><input type="text" id="ec_url" value=""/></label>
		<label id="l_ec_parentid">Parent Item: <br/>
			<select id="ec_parentid"></select>
		</label>
		<hr/>
		<button onclick="update_educator_content();">Update</button>
		<button onclick="$(this).parent().hide();">Cancel</button>
	</div>
	
	<style type="text/css">
	
table.enrich_table {
  color: gray;
  font-family: tahoma;
  font-size: 8px;
  border-collapse: collapse;
  text-align: left;
}
table.enrich_table tr {border-top: 1px solid #eee;}
table.enrich_table th {
  padding: 1em;
  font-size: 11px;
  font-weight:normal;
}
table.enrich_table td {
  font-size: 11px;
  padding: 1em;
}
div.tableofcontent { width: 570px; max-height: 200px; overflow-y: auto;}
table.enrich_table td img {cursor:pointer; margin-right: .5em;}		
#edit_educator_content {
  background: #555;
  box-shadow: 0 0 12px black;
  color: white;
  display: inline-block;
  font-family: verdana;
  font-size: 12px;
  height: 201px;
  left: 83px;
  padding: 0.5em;
  position: fixed;
  top: 103px;
  width: 393px;
}
		#edit_educator_content h2 {margin: 0; font-weight: normal; font-size: 18px; color: gray;}
		#edit_educator_content label {display: block; margin-bottom: .5em;}
		#edit_educator_content input[type="text"]{width: 90%;}
	
	</style>


