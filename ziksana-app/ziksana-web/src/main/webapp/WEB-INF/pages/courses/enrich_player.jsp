
<!-- <script type="text/javascript" src="js/video_player.js"></script> -->
<script type="text/javascript" src="/ziksana-web/resources/js/custom/course_enrichment.js"></script>
<script type='text/javascript' src="/ziksana-web/resources/jwplayer/swfobject.js"></script>
<script type="text/javascript" src="/ziksana-web/resources/jwplayer/jwplayer.js"></script>


	<div id="video">
		<div id="mediaplayer"></div>

		<script type="text/javascript">
			var flashvars = {
				'file' : '/ziksana-web/resources/videos/preference_aggregation.mp4',
				'provider' : 'http',
				'http.startparam' : 'starttime'
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

			var ff_add_note = function(note) {
				
				console.log('inside ff_add_note');
				var delim1 = note.indexOf("||");
				var note_title = note.substring(0, delim1);
				note = note.substring(delim1 + 2);
				var delim2 = note.indexOf("||");
				var note_desc = note.substring(0, delim2);
				note = note.substring(delim2 + 2);
				var note_time = Math.floor(note);
				//window.alert("You have Added Note ITEM: "+note_title+ " descibed as " +  note_desc+ " at time " + note_time);
				
				var table = document.getElementById("dataTable");
				var rowCount = table.rows.length;
				var row = table.insertRow(rowCount);
				var cell1 = row.insertCell(0);
				cell1.innerHTML = "Notes";
				var cell2 = row.insertCell(1);
				cell2.innerHTML = "<b onclick='jwplayer(reftoplayer).seek("
						+ note_time + ")'>" + note_title + "</b>";

				var cell3 = row.insertCell(2);
				cell3.innerHTML = note_desc;
				var cell4 = row.insertCell(3);
				cell4.innerHTML = note_time;
				var cell5 = row.insertCell(4);
				cell5.innerHTML = "<img src='/ziksana-web/resources/images/delete.jpg'   onclick='del(this)'>";
				jwplayer(reftoplayer).play();

				/*
				note_anchor_string = '<a title="'+note_desc+'" onclick="jwplayer().seek('+note_time+').play(true);" data-iconprefix="note">'+note_title+'</a>';
				$('#notes_and_bookmarks_container').append(note_anchor_string);*/
				
				content_type = 8; //8 for note
				course_id = $('#courseid').val();
				node_id = $('#selected_node_id').val();
				duration = Math.floor(note_time);
				title = note_title;
				description = note_desc;
				coordiantes = '';
				url = '';
				add_educator_content(content_type, course_id, node_id, duration, title, description, coordinates, url);
			}

			var ff_add_reference = function(note) {
				console.log('inside ff_add_reference');
				var delim1 = note.indexOf("||");
				var note_title = note.substring(0, delim1);
				note = note.substring(delim1 + 2);
				var delim2 = note.indexOf("||");
				var note_desc = note.substring(0, delim2);
				note = note.substring(delim2 + 2);
				var note_time = note;
				//window.alert("You have Added Reference ITEM: "+note_title+ " linking " +  note_desc+ " at time " + note_time);
				var table = document.getElementById("dataTable");
				var rowCount = table.rows.length;
				var row = table.insertRow(rowCount);
				var cell1 = row.insertCell(0);
				cell1.innerHTML = "Reference";
				var cell2 = row.insertCell(1);
				cell2.innerHTML = "<b onclick='jwplayer(reftoplayer).seek("
						+ note_time + ")'>" + note_title + "</b>";

				var cell3 = row.insertCell(2);
				cell3.innerHTML = note_desc;
				var cell4 = row.insertCell(3);
				cell4.innerHTML = note_time;
				var cell5 = row.insertCell(4);
				cell5.innerHTML = "<img src='/ziksana-web/resources/images/delete.jpg'   onclick='del(this)'>";
				jwplayer(reftoplayer).play();

				/*
				note_anchor_string = '<a title="'+note_desc+'" onclick="jwplayer().seek('+note_time+').play(true);" data-iconprefix="note">'+note_title+'</a>';
				$('#notes_and_bookmarks_container').append(note_anchor_string);*/
				
				content_type = 1; //1 for reference
				course_id = $('#courseid').val();
				node_id = $('#selected_node_id').val();
				duration = Math.floor(note_time);
				title = note_title;
				description = '';
				coordinates = '';
				url = note_desc;
				add_educator_content(content_type, course_id, node_id, duration, title, description, coordinates, url);
			
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
				//window.alert("You have Added Reference ITEM: "+note_title+ " linking " +  note_desc+ " at time " + note_time);
				var table = document.getElementById("dataTable");
				var rowCount = table.rows.length;
				var row = table.insertRow(rowCount);
				var cell1 = row.insertCell(0);
				cell1.innerHTML = "Hotspot";
				var cell2 = row.insertCell(1);
				cell2.innerHTML = "<b onclick='jwplayer(reftoplayer).seek("
						+ note_time + ")'>" + note_title + "</b>";

				var cell3 = row.insertCell(2);
				cell3.innerHTML = note_desc;
				var cell4 = row.insertCell(3);
				cell4.innerHTML = note_time;
				var cell5 = row.insertCell(4);
				cell5.innerHTML = "<img src='/ziksana-web/resources/images/delete.jpg'   onclick='del(this)'>";
				jwplayer(reftoplayer).play();

				/*
				note_anchor_string = '<a title="'+note_desc+'" onclick="jwplayer().seek('+note_time+').play(true);" data-iconprefix="note">'+note_title+'</a>';
				$('#notes_and_bookmarks_container').append(note_anchor_string);*/

				content_type = 9; //9 for hotspot
				course_id = $('#courseid').val();
				node_id = $('#selected_node_id').val();
				duration = Math.floor(note_time);
				title = note_title;
				coordinates = note_desc;
				description = '';
				url = '';
				add_educator_content(content_type, course_id, node_id, duration, title, description, coordinates, url);
			
			}

			var ff_add_toc = function(note) {
				console.log('inside ff_add_toc');
				var delim1 = note.indexOf("||");
				var note_title = note.substring(0, delim1);
				note = note.substring(delim1 + 2);
				var delim2 = note.indexOf("||");
				var note_desc = note.substring(0, delim2);
				note = note.substring(delim2 + 2);
				var note_time = note;
				window.alert("You have Added TOC ITEM: " + note_title
						+ " under " + note_desc + " at time " + note_time);

				/*
				note_anchor_string = '<a title="'+note_desc+'" onclick="jwplayer().seek('+note_time+').play(true);" data-iconprefix="note">'+note_title+'</a>';
				$('#notes_and_bookmarks_container').append(note_anchor_string);*/
			

				content_type = 7; //7 for toc
				course_id = $('#courseid').val();
				node_id = $('#selected_node_id').val();
				duration = Math.floor(note_time);
				title = note_title;
				description = note_desc; // will carry parent node id
				coordinates = '';
				url = '';
				add_educator_content(content_type, course_id, node_id, duration, title, description, coordinates, url);
			
			}

			var ff_pause_player = function() {
				if (jwplayer(reftoplayer).getState() == "PLAYING")
					jwplayer(reftoplayer).pause();
			}

			var ff_get_position = function() {
				var position = jwplayer(reftoplayer).getPosition();
				console.log(position);
				return position + "";
			}

			var ff_add_note2 = function(note) {

				var delim1 = note.indexOf("||");
				var note_title = note.substring(0, delim1);
				note = note.substring(delim1 + 2);
				var delim2 = note.indexOf("||");
				var note_desc = note.substring(0, delim2);
				note = note.substring(delim2 + 2);
				var note_time = note;
				console.log("note_title " + note_title + "note_desc "
						+ note_desc + "note_time " + note_time);
				add_learner_content_note(note_title, note_desc, note_time);
			}

			var ff_add_question = function(question) {

				var delim1 = question.indexOf("||");
				var question_title = question.substring(0, delim1);
				question = question.substring(delim1 + 2);
				var question_position = question;
				add_learner_question(question_title, question_position)
			}

			var ff_play_position = function(e) {
				jwplayer(reftoplayer).seek(e).play(true)
			}
			
			function add_educator_content(content_type, course_id, node_id, duration, title, description, coordinates, url){
				
				//TO BE IMPLEMENTED.
				
				//$.post('/ziksana-web/secure/');
				
			}

			
			
			
			
			
		</script>


	</div>

	<div class="tableofcontent">

		<table align="center" id="dataTable" class="table table-hover"
			style="width: 550px;">
			<thead
				style="font-size: 8px; font-family: tahoma; font-style: normal; color: #666;">
				<tr style="background-color: #E1E8F0;">
					<th width="15%">Type</th>
					<th width="20%">Name</th>
					<th width="30%">Details</th>
					<th width="21%">Time on video</th>
					<th width="4%"></th>
					<th width="5%"></th>
					<th width="5%"></th>
				</tr>
			</thead>
			<tbody>


			</tbody>
		</table>

	</div>


