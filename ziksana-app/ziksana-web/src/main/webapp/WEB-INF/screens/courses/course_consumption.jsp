
 
<!--Body Style sheet-->

<link href="${ms.staticResources}css/ContentConsumption.css"
	rel="stylesheet" type="text/css" />
<link href="${ms.staticResources}css/styles.css" rel="stylesheet"
	type="text/css" />
<link href="${ms.staticResources}css/type-setting.css"
	rel="stylesheet" type="text/css" />
<link href="${ms.staticResources}css/effects.css" rel="stylesheet"
	type="text/css" />
<link href="${ms.staticResources}css/nav.css" rel="stylesheet"
	type="text/css" />
<link type="text/css" rel="stylesheet" href="${ms.staticResources}css/tipsy.css" />
<link rel="stylesheet" type="text/css"
	href="${ms.staticResources}css/custom-theme/jquery-ui-1.8.21.custom.css">

<!--End Body Style sheet-->


<script type='text/javascript' src='${ms.staticResources}jwplayer/swfobject.js'></script>
<script src="${ms.staticResources}js/custom/table/js/jquery-1.8.3.min.js"></script>

<style>
 	footer{display:none}
</style>
<div id="Zikbreadcrumbback" style="margin-left: 20px;">

	<div class="Zikbreadcrumb f-l">

		<div class="fifteen columns" id="page-title">
			<a style="margin-top: -3px;" class="back"
				href="javascript:history.back()"></a>
			<p class="page-title">
				<span style="font-size: 13px; color: #6bbde8;">Home</span> < My
				Courses
			</p>

		</div>

	</div>
	<!--end of breadcrumb-->



</div>

<div class="Clearfix"></div>



<div id="contentpanel">
	<div id="content_container">
	
		<div style="background: #2b4954; width: 230px;">
			<div id="tree_container">
				<span class="column_title">Chapters</span>

				<p class="user-name-w1" style="margin-top: -15px;">1. MODEL
					THINKING</p>
				<ul id="nav" style="width: 250px;">

					<li class="user-name-w2" id="chapter">1.1 Why Model Thinking
						<ul class="user-name-w2">
							<li><a href="${ms.staticResources}images/output0.jpeg"
								data-filetype="imageset" class="tu" toptions="group= imageset-1"
								onclick="displayImageSet($(this));">1.1.1 Why Model</a> <span
								class="hidden"> <a href="${ms.staticResources}images/output1.jpeg"
									data-filetype="imageset" class="tu"
									toptions="group= imageset-1"></a> <a
									href="${ms.staticResources}images/output2.jpeg" data-filetype="imageset"
									class="tu" toptions="group= imageset-1"></a>
							</span></li>
							<li><a href="${ms.staticResources}images/output0.jpeg"
								data-filetype="imageset" class="tu" toptions="group= imageset-2"
								onclick="displayImageSet($(this));">1.1.2 Intelligent
									Citizens of the World</a> <span class="hidden"> <a
									href="${ms.staticResources}images/output1.jpeg" data-filetype="imageset"
									class="tu" toptions="group= imageset-2"></a> <a
									href="${ms.staticResources}images/output2.jpeg" data-filetype="imageset"
									class="tu" toptions="group= imageset-2"></a>
							</span></li>
						</ul>
					</li>
					<li class="user-name-w2" id="chapter">1.2 Aggregation
						<ul class="user-name-w2">
							<li><a href="${ms.staticResources}images/output0.jpeg"
								data-filetype="imageset" class="tu" toptions="group= imageset-3"
								onclick="displayImageSet($(this));">1.2.1 Aggregation</a></li>
							<span class="hidden"> <a href="${ms.staticResources}images/output1.jpeg"
								data-filetype="imageset" class="tu" toptions="group= imageset-3"></a>
								<a href="${ms.staticResources}images/output2.jpeg" data-filetype="imageset"
								class="tu" toptions="group= imageset-3"></a>
							</span>
					</li>
					<li><a href="#"
						onclick="displayVideo('sixsigma.mp4','${ms.staticResources}uploads/');">1.2.2
							Six Sigma</a></li>
					<li><a href="#"
						onclick="displayVideo('test.webm','${ms.staticResources}uploads/'); $('.preference_aggregation_temp').show();">1.2.3
							Preference Aggregation</a></li>
					<li><a href="#" onclick="displayAudio('test.mp3');">1.2.4
							Test Audio</a></li>
				</ul>
				</li>
				<li class="user-name-w2" id="chapter">1.3 Decision Models
					<ul class="user-name-w2">
						<li><a href="http://en.wikipedia.org/wiki/Decision_making"
							target="_blank">1.3.1 Introduction to Decision Making</a></li>
						<li><a href="#" data-filetype="video"
							onclick="displayVideo('BasicProbability.mp4','/Generic/uploads/');">1.3.2
								Probability: The Basics</a></li>
					</ul>
				</li>

				</ul>
			</div>
		</div>


		<!-- Start Video Container -->
		<div id="video_container" style="width: 640px; ">

			
			

			<div id="videoSection">
				<!-- START OF THE PLAYER EMBEDDING TO COPY-PASTE -->
			</div>

			
			<script type="text/javascript" src="${ms.staticResources}jwplayer/jwplayer.js"></script>
		
			
						
			<div id="video_actions" style="">
				<img data-tab="educator" src="${ms.staticResources}images/icons/proffessor.png"
					title="Educator Suggested References" onclick="showref()"> <img
					data-tab="table_of_contents" type="button"
					title="Video's Table of Contents" src="${ms.staticResources}images/icons/view_toc.png"
					onclick="showtoc()" /> <img data-tab="notes_and_bookmarks"
					type="button" title="Notes" src="${ms.staticResources}images/icons/view_notes.png"
					onclick="shownotes()" id="bookmarkicon" />
				
				<img data-tab="questions" type="button" title="Questions"
					src="${ms.staticResources}images/icons/viewquestions.png" onclick="showquestion()"
					id="questionicon" />
				<!--<img data-tab="circles" type="button" title="Online Contacts " src="${ms.staticResources}images/icons/contacts.png" onclick="" />-->
			</div>


		
			



		</div>
		<!-- End Video Container -->
		<div id="content_utilities_container" style="">

				<div id="table_of_contents_container" data-tabpane="table_of_contents1" >
						<div class="column_title"><img src="${ms.staticResources}images/icons/proffessor.png" style="margin-left:5px;"><span class="titleclass">Educator References<br/></span></div>
						<a onclick="jwplayer(player).pause(true);" href="http://citeseerx.ist.psu.edu/viewdoc/summary?doi=10.1.1.151.9419" target="_blank" data-iconprefix="link">Aggregating Preferences in Multi-Issue Domains</a>
				            <a onclick="jwplayer(player).pause(true);" href="http://faculty.arts.ubc.ca/pbartha/p321f01/p321ovh2.pdf" target="_blank" data-iconprefix="link">Preference Ordering</a>
				            <a onclick="jwplayer(player).pause(true);" title="Make sure you understand this concept before proceeding. Please make use of the references provided or contact me to seek any clarifications." href="#" data-iconprefix="note">Critical Concept</a> <!-- Temporary -->
					</div>	
			<div id="notes_and_bookmarks_container" data-tabpane="notes_and_bookmarks" style="display:none;">
						<div class="column_title"><img src="${ms.staticResources}images/icons/view_notes.png" style="margin-left:5px;"><span class="titleclass">Notes<br/></span></div>
						<span class="preference_aggregation_temp" style="display:block;"><!-- Temporary -->
						<a data-iconprefix="note" onclick="jwplayer().seek(75).play(true);" title="Must read before exam - Preference Ordering">Important</a>
						<!-- <a data-iconprefix="star" onclick="jwplayer().seek(248).play(true);">Illustration of Transitivity concept</a> -->
						</span><!-- Temporary -->
					</div>
					
				
					
					
					
					
					<div id="TOC" data-tabpane="TOC" style="display:none;">
						<div class="column_title"><img src="${ms.staticResources}images/icons/view_toc.png" style="margin-left:5px;"><span class="titleclass">Table of Contents<br/></span></div>
						
					</div>
					
					
						<!-- Questions -->
					
					<div id="questions_container" data-tabpane="questions1" style="display:none;">
					<div class="column_title"><img src="${ms.staticResources}images/icons/viewquestions.png" style="margin-left:5px;"><span class="titleclass">Questions<br/></span>
					</div>
						
					
					</div>
		</div>

	</div>

	<!--end of annprogressbar-->

	


</div>
<!--end of announcement container-->




<div class="Clearfix"></div>

<script src="${ms.staticResources}js/custom/table/breakpoints/breakpoints.js"></script>
<!-- ie8 fixes -->
<!--[if lt IE 9]>
	<script src="assets/js/excanvas.js"></script>
	<script src="assets/js/respond.js"></script>
	<![endif]-->

<script src="${ms.staticResources}js/custom/bootstrap/js/bootstrap.min.js"></script>

<script type="text/javascript">
	
	var demo_data = {
			"data" : [
			          {"state":"open",
			        	  "data":{"icon":null,"attr":null,"title":"Topic1"},"children":[{"state":null,"data":{"icon":null,"attr":null,"title":"Topic2"},"children":[{"state":null,"data":{"icon":null,"attr":null,"title":"Topic4"},"children":[],"metadata":null,"attr":null,"progressiveRender":true,"correctState":true}],"metadata":null,"attr":null,"progressiveRender":true,"correctState":true},{"state":null,"data":{"icon":null,"attr":null,"title":"Topic3"},"children":[],"metadata":null,"attr":null,"progressiveRender":true,"correctState":true}],"metadata":null,"attr":null,"progressiveRender":true,"correctState":true}
			         ]};
	$("#dashboard_course_tree").jstree({
		
		
        /*"json_data" : {

            "ajax" : {

                "url" : "<c:url value="/video.htm?displayTree=ccc" />",

                "data" : function (data) {
                    
                	
                	//console.log(" callback called in jstree");
                    //console.log("data is "+data.d);
                    
                    return { id : data.attr ? data.attr("id") : 0 };

                }

            }

        },*/
        "json_data": demo_data,

        "plugins" : [ "themes", "json_data" ],
        "themes" : {
					"theme" : "default",
        			"dots" : false,
        			"icons" : true
        			}

    });

</script>

<script type="text/javascript">
$(function(){
	
	// TABS
	$('[data-tab]').live('click',function(){
	
		tab_trigger = $(this);
		tab_trigger.addClass('hover_state').siblings('[data-tab]').removeClass('hover_state');
		tab_name = tab_trigger.attr('data-tab');
		tab_pane = $('[data-tabpane="'+tab_name+'"]');
		tab_pane.siblings('[data-tabpane]').hide();
		tab_pane.show();
		
	});
	// END TABS

	$('#content_tab_icon_container img').click(function(){

		$('#content_tab_icon_container img').not(this).removeClass('hover_state'); //remove highlight
	});
	
	/* -- DISPLAYING NOTES, BOOKMARKS & RESOURCE(Reference Materials) based on playback positions
	jwplayer().onTime(
			 function(event) {
			 video_position = Math.floor(event.position); //in sec
			 video_duration = Math.floor(event.duration); //in sec
			 //console.log('Playback Position is: '+video_position);
			 //console.log('Playback Duration is: '+video_duration);
			 }
			);

			media_notes = Object();
			media_notes['25'] = 'Sample Note ||| Sample Note Description';			
			media_bookmarks = Object();
			media_bookmarks['22'] = '';
	*/	
	
	//Temporarily show image of chat user and their name on the chatbox on click
	$('#circles_container .chatbox_user').each(function(){
		
		$(this).click(function(){
			$('.chatbox').show(); //show hidden one (temporarily)
			chatbox = $(this);
			buddyname = chatbox.find('span').text();
			buddyimage = chatbox.find('img').attr('src');
			
			$('.chat_buddy_thumbnail img').attr('src',buddyimage);
			$('.chat_buddy_name').html(buddyname);
			$('.chat_column').html(''); //empty html
		});
	});
	
	// chat
	//Workaround to prevent toggle of jwPlayer when spacebar key is pressed
	$(".chat_text").keydown(function (e) {
        if (e.keyCode == 32) { e.stopPropagation(); return '&nbsp;'; }
        if (e.keyCode == 13) { //when enter key is clicked.
        	chat_text_line = $(this).val(); 
    		$(this).parents('.chatbox').find('.chat_column').append('<span><strong>Me: </strong>'+chat_text_line+'</span>');
    		$(this).val(''); //clear chat text
        }
    });
	
	//chatbox minimize
	$('.chatbox_minimize').each(function(){
		$(this).toggle(
			function(){$(this).parent().siblings().hide();},
			function(){$(this).parent().siblings().show();}
		);
	});
	$('.chatbox_popout').each(function(){
		$(this).toggle(
			function(){$(this).parent().siblings().show();},
			function(){$(this).parent().siblings().show();}
		);
	});
	
	$('.chatbox_close').click(function(){$(this).parents('.chatbox').hide();});
	
	$('.chat_text').val(''); //clear the value (workaround for 'undefined' error)
	
	
	//New Add Bookmarks & Notes
	$('.add_bookmark_trigger').click(function(){$('#add_bookmark_container').slideDown('fast'); jwplayer().pause(true); });
	$('.add_question_trigger').click(function(){$('#add_question_container').slideDown('fast'); jwplayer().pause(true); });
	$('.add_note_trigger').click(function(){
		$('.add_note_description').val('');
		$('#add_note_container').slideDown('fast'); jwplayer().pause(true); });
	
	$('.add_bookmark_submit_button').click(function(){
		bookmark_title = $(this).parent().find('.add_bookmark_title').val();
		bookmark_position = Math.floor(jwplayer().getPosition());
		
		if(bookmark_title==''){alert('Please enter Bookmark Title!'); return false;}
		
		//save bookmark temporarily
		bookmark_anchor_string = '<a onclick="jwplayer().seek('+bookmark_position+').play(true);" data-iconprefix="star">'+bookmark_title+'</a>';
		bookmark_anchor_string2 = '<div class="chatbox_user_video" style="margin-left:10px;" onclick=jwplayer().seek('+bookmark_position+').play(true);> \
		<img src="${ms.staticResources}icons/starbook.png" width="10px" height="10px" /> \
		 '+bookmark_title+'\
		</div>';
		
		$('#notes_and_bookmarks_container').append(bookmark_anchor_string);
		notesAndBookmarkData+=bookmark_anchor_string2;

		$('#add_bookmark_container').hide(); jwplayer().play(true);
		$(this).parent().find('.add_bookmark_title').val(''); //clear the value
		
		/**/
		
		/*<div class="chatbox_user" style="margin-top:20px;" Title="Must read before exam - Preference Ordering" > \
		<img src="note_16.png"  width="10px" height="10px" /> \
		Important\
		</div>	\*/
		
		
	});
	
	$('.add_question_submit_button').click(function(){
		question_title = $(this).parent().find('.add_question_title').val();
		question_position = Math.floor(jwplayer().getPosition());
		
		if(question_title==''){alert('Please enter a Question!'); return false;}

		question_timestamp = (new Date).clearTime().addSeconds(question_position).toString('H:mm:ss');

		
		//save bookmark temporarily
		question_anchor_string ='<div  style="width:100%;">'; 
		question_anchor_string += '<a onclick="jwplayer().seek('+question_position+').play(true);" data-iconprefix="question">'+question_title+'</a><br/><span class="qtstamp">'+question_timestamp+'</span>';
		question_anchor_string += ' <span style=" margin-right:15px" class="send_question_trigger">send</span></div>';
		
		$('#questions_container').append(question_anchor_string);
		
		question_anchor_string2 ='<div style="width:100%;">'; 	
		question_anchor_string2 += '<a onclick="jwplayer().seek('+question_position+').play(true);" style="color:white;" data-iconprefix="question">'+question_title+'</a><br/><span class="qtstamp">'+question_timestamp+'</span>';
		question_anchor_string2 += ' <span onclick="sendQuestionFS(); $(\'.question_to_be_sent\').html($(this).siblings(\'a\').text()+\'<hr/>\');" style=" cursor: pointer;  color:#222; background:silver; border-radius: 15px; padding: 0 .5em; margin-right:15px;" >send</span></div>';
				if(questionData == '<span style="margin-left:10px"> No Questions to be displayed </span>' )
		questionData = '';
		questionData+=question_anchor_string2;
		$('#add_question_container').hide(); jwplayer().play(true);
		$(this).parent().find('.add_question_title').val(''); //clear the value
		
		
		
	});
	
	$('.add_note_submit_button').click(function(){
		note_title = $(this).parent().find('.add_note_title').val();
		note_description = $(this).parent().find('.add_note_description').val();
		note_position = Math.floor(jwplayer().getPosition());
		
		if(note_title==''){alert('Please enter Note Title!'); return false;}
		//save note temporarily
		note_anchor_string = '<a title="'+note_description+'" onclick="jwplayer().seek('+note_position+').play(true);" data-iconprefix="note">'+note_title+'</a>';
		note_anchor_string2='<div class="chatbox_user_video" style="margin-left:10px;" style="margin-top:20px;" onclick="jwplayer().seek('+note_position+').play(true);" Title="'+note_description+'" > \
		<img src="${ms.staticResources}icons/note_16.png"  width="10px" height="10px" /> \
		'+note_title+'\
		</div>';
		notesAndBookmarkData+=note_anchor_string2;
		$('#notes_and_bookmarks_container').append(note_anchor_string);
		
		
		$('#add_note_container').hide(); jwplayer().play(true);
		$(this).parent().find('.add_note_title, .add_note_description').val(''); //clear the value
		
		
	});	
	
	$('.send_question_trigger').live('click', function(){

		question = $(this).siblings('a').text();
		$('.question_to_be_sent').html(question +' <hr/>');
		$('#send_question').show();
		$('#send_question, #send_question2').find('input[type="checkbox"]').removeAttr('checked');
	});

	$('#video_actions img').click(function(){
		$('#video_actions img').not(this).removeClass('hover_state');
	});


	$('.select_all_mates').live('click', function(){
		if($(this).is(':checked')== true){
			console.log('hello');
			$(this).parents('div').siblings('div').find('input[type="checkbox"]').attr('checked','checked');
		} else {
			$(this).parents('div').siblings('div').find('input[type="checkbox"]').removeAttr('checked');
		}
	});

	$('.show_online_mates').live('click', function(){
		if($(this).is(':checked')== true){
			$(this).parents('div').siblings('div[data-user_online="false"]').hide();
		} else {
			$(this).parents('div').siblings('div[data-user_online="false"]').show();
		}
	});


	
});//End of Doc ready

function showref()
{

$("#table_of_contents_container").show();
$("#notes_and_bookmarks_container").hide();
$("#TOC").hide();
$("#questions_container").hide();
}
function shownotes()
{

$("#table_of_contents_container").hide();
$("#notes_and_bookmarks_container").show();
$("#TOC").hide();
$("#questions_container").hide();
}
function showtoc()
{
	
$("#TOC").show();
	$("#table_of_contents_container").hide();
	$("#notes_and_bookmarks_container").hide();
	$("#questions_container").hide();

}
function showquestion()
{
$("#table_of_contents_container").hide();
$("#notes_and_bookmarks_container").hide();
$("#questions_container").show();
$("#TOC").hide();

}
function  unhighlight_tab(tabname){
	$('[data-tab="'+tabname+'"]').removeClass('hover_state');
}

</script>



