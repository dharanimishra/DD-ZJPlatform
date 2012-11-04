/* Other Functions */
function grow() {
	  var textarea = document.getElementById('descrip');
	  var newHeight = textarea.scrollHeight;
	  var currentHeight = textarea.clientHeight;
	  if (newHeight > currentHeight) {
		 textarea.style.height = newHeight + 5 * TEXTAREA_LINE_HEIGHT + 'px';
	  }
	}
	function saveText(value){
		var testing=value;
		var testing1="Done";
		var testing2="Edit";
		if( testing == testing1)
		{
			$('#course_title').html($('#course_name').val());
			$('#course_descrip').html($('#descrip').val());
			$('#course_credit').html($('#course_credittxt').val());
			$('#course_extracredit').html($('#course_extracredittxt').val());
			$('#duration').html($('#durationtxt').val());
			$('#course_area').html($('#course_areaval').val());
			$('#course_topic').html($('#course_topicval').val());
			$('#course_subject').html($('#course_subjectval').val());
			$(".form").hide();
			document.getElementById("course_title").style.display = "block";
			//document.getElementById("course_name").style.display = "none";
			document.getElementById("course_descrip").style.display = "block";
			//document.getElementById("descrip").style.display = "none";
			document.getElementById("course_credit").style.display = "block";
			//document.getElementById("course_credittxt").style.display = "none";
			document.getElementById("course_extracredit").style.display = "block";
			//document.getElementById("course_extracredittxt").style.display = "none";
			document.getElementById("duration").style.display = "block";
			//document.getElementById("durationtxt").style.display = "none";
			document.getElementById("course_area").style.display = "block";
			document.getElementById("course_topic").style.display = "block";
			document.getElementById("course_subject").style.display = "block";

			document.getElementById("Enter_title").style.display = "block";
			document.getElementById("title-descrip").style.display = "block";
			document.getElementById("save_text").value = "Edit";
		}
		else if(testing == testing2)
		{
			$(".form").show();
			document.getElementById("course_title").style.display = "none";
			//document.getElementById("course_name").style.display = "none";
			document.getElementById("course_descrip").style.display = "none";
			//document.getElementById("descrip").style.display = "none";
			document.getElementById("course_credit").style.display = "none";
			//document.getElementById("course_credittxt").style.display = "none";
			document.getElementById("course_extracredit").style.display = "none";
			//document.getElementById("course_extracredittxt").style.display = "none";
			document.getElementById("duration").style.display = "none";
			//document.getElementById("durationtxt").style.display = "none";
			document.getElementById("course_area").style.display = "none";
			document.getElementById("course_topic").style.display = "none";
			document.getElementById("course_subject").style.display = "none";

			document.getElementById("save_text").value = "Done";
			document.getElementById("Enter_titleval").style.display = "none";
			document.getElementById("title-descripval").style.display = "block";
		}
	}
	$(".form").live('mousedown',function(){
		document.getElementById("save_text").value = "Done";
	});
	function savetitle(){
		$('#Enter_title').html($('#Enter_titleval').val());
		$('#title-descrip').html($('#title-descripval').val());
		$(".form").hide();
		document.getElementById("Enter_title").style.display = "block";
		document.getElementById("title-descrip").style.display = "block";
	}