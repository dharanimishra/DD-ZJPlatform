  $(document).ready(function () {
                // var theme = getTheme();
                // prepare the data
                var source =
                {
                    datatype: "xml",
                    datafields: [
                        //{ name: 'CompanyName', map: 'm\\:properties>d\\:CompanyName' },
                        { name: 'id', map: 'id' },
                        { name: 'parentId', map: 'parentId' },
                        { name: 'title', map: 'title' },
                        { name: 'nodeType', map: 'nodeType' },
                        { name: 'contentId', map: 'contentId' },
                        { name: 'contentType', map: 'contentType' },
                        { name: 'icon', map: 'icon' },
                        { name: 'expanded', map: 'expanded' }
                    ],
                    root: "nodes",
                    record: "node",
                    id: 'id',
                    url: "/ziksana-web/secure/getcoursetree/"+$('#courseId').val(),
                    async: false
                };


			// create data adapter.
                var dataAdapter = new $.jqx.dataAdapter(source);
                // perform Data Binding.
                dataAdapter.dataBind();
                // get the tree items. 
                // The first parameter is the item's id. The second parameter is the parent item's id. The 'items' parameter represents the sub items collection name. Each jqxTree item has a 'label' property, but in the xml data, we have a 'text' field. The last parameter specifies the mapping between the 'text' and 'label' fields.  
                var records = dataAdapter.getRecordsHierarchy('id', 'parentId', 'items', [
                	{ name: 'title', map: 'label'},
                	{ name: 'icon', map: 'icon'},
                	{ name: 'expanded', map: 'expanded'}
     


                	]);
                $('#jqx_course_tree').jqxTree({ source: records, width: '300px'});

                //Bind Select Events
                $('#jqx_course_tree').bind('select', function (event) {
	                var args = event.args;
	                var item = $('#jqx_course_tree').jqxTree('getItem', args.element);
	                var node_id = item.id; $('#selected_node_id').val(node_id);
	                var parent_node_id = item.parentId;
	                var course_id = $('#courseId').val();
	                display_content(node_id, parent_node_id, course_id);

                  //Get Educator Notes
                  get_educator_notes(node_id, parent_node_id, course_id);
                  //Get Educator Suggested References
                  get_educator_suggested_references(node_id, parent_node_id, course_id);
                  //Get Learner Notes
                  get_learner_content_notes(node_id, course_id );
                  //Get Learner Questions
                  get_learner_questions(node_id, course_id );
                  //Get Content's TOC\
                  get_content_toc(node_id, course_id);


           		});

           		function display_content(node_id, parent_node_id, course_id){
           			//this function makes a request to the server, fetches the content and displays it. The server is expected to return two parameters, 1.contentType and 2. contentUrl. 
           			// 'contentType' will be either 'video', 'audio' or 'image' or 'imageset'
           			// 'contentUrl' will be the url for the 'video' or 'audio' or 'image slideshow url'

           			//Step 1. Make a request to the server to fetch the content
           			$.get('/ziksana-web/secure/content/getContent', {'contentId':node_id, 'parentNodeId':parent_node_id, 'courseId':course_id}, function(data){
           		

           				
           				content_type = (data.contentTypeString).toUpperCase();
           				content_path = data.contentUrl;

           				if(content_type == 'VIDEO'){ playVideo(content_path); }
           				if(content_type == 'AUDIO'){ playAudio(content_path); }
           				if(content_type == 'PDF' || content_type == 'WORD' || content_type == 'POWERPOINT' || content_type == 'IMAGE' || content_type == 'TEXTUAL'){ displayImageSet(content_path); }
           			



           			});
	          
           		}
           		
           		//initiate jwplayer ontime
           		jwplayer('player').onTime(function(player_event){
           			position = Math.floor(player_event.position);
           			//if(position%5==0){
	           			show_by_position(position);
           			//}
           		});
           		
           		jwplayer('player').onSeek(function(player_event){
           			position = Math.floor(player_event.offset);
           			console.log(position);
           			looped_show_by_position(position);
           		});
  
  });//end of doc ready
  
  
	function playVideo(path) {
		//console.log('inside play video');
		//TopUp.close();
		//$.fancybox().close();
		$('#notes_and_bookmarks_container, #table_of_contents_container, #questions_container').css('visibility','visible');
		$('#videoSection').css('visibility','visible');
		$('.add_note_trigger, .add_question_trigger').css('visibility','visible');
		$('#play-vedio, #video_actions').css('visibility','visible');
		jwplayer('player').load(
				{
					file : path
				});
		jwplayer('player').play(true);
	}
	
	function playAudio(path){
		$('#notes_and_bookmarks_container, #table_of_contents_container, #questions_container').css('visibility','hidden');
		$('#videoSection').css('visibility','visible');
		$('.add_note_trigger, .add_question_trigger').css('visibility','hidden');

		//TopUp.close();
		//$.fancybox().close();
		$('#video_actions').css('visibility','hidden');
		$('#play-vedio').css('visibility','visible');

		jwplayer('player').load(
				{
					file : path
					
					
				});
		jwplayer('player').play(true);
	}
	
	function displayImageSet(path){
		$('#notes_and_bookmarks_container, #table_of_contents_container, #questions_container').css('visibility','hidden');
		$('#videoSection').css('visibility','hidden');
		$('.add_note_trigger, .add_question_trigger').css('visibility','hidden');

		jwplayer('player').stop();
		$('#video_actions').css('visibility','hidden');
		$('#play-vedio').css('visibility','hidden');
		
		$.fancybox({
			'width': 700, 
            'height': 800, 
            'autoDimensions' : true, 
			'transitionIn': 'fade',
			'transitionOut': 'fade',
			'type': 'iframe',
			'href': path
	
		});
		
	}

  function get_educator_suggested_references(node_id, parent_node_id, course_id){


     $.get('/ziksana-web/secure/educatorReferences', {'nodeId':node_id, "parentNodeId":parent_node_id, "courseId":course_id}, function(data){


       references = data;

       links = '';

       ff_edu_references="";
       for (i in references)
       {
           title = references[i].title;
           uri = references[i].uri;
           duration = references[i].duration;

           link = '<a style="display:none;" data-iconprefix="link" class="position" data-position="'+duration+'" target="_blank" href="'+uri+'" >'+title+'</a>'
           ff_edu_references= ff_edu_references+title+"||"+uri+"|||";
           links += link;
       }

       $('[data-tabpane="educator"]').find('.educator_references').html(links);
       sort_by_position('descending'); //sorts by descending order

     });


  
  }

  function get_educator_notes(node_id, parent_node_id, course_id){
	  

    $.get('/ziksana-web/secure/educatorNotes', {'nodeId':node_id, "parentNodeId":parent_node_id, "courseId":course_id}, function(data){

     

      notes = data;

      var links = '';
      ff_edu_notes ="";
    for (i in notes)
    {
        title = notes[i].title;
        description = notes[i].description;
        duration = notes[i].duration;

        link = '<a style="display:none;" class="position" data-position="'+duration+'" data-iconprefix="note" href="#" title="'+description+'">'+title+'</a>';
        ff_edu_notes=ff_edu_notes+title+"||note:"+duration+":"+description+"|||";
        links += link;
    }


     $('[data-tabpane="educator"]').find('.educator_notes').html(links);
     sort_by_position('descending'); //sorts by descending order



    });

  }
  
  
  //add learner note
  function add_learner_content_note(note_title, note_description, note_duration){
	  
	  node_id = $('#selected_node_id').val();
	  course_id = $('#courseId').val();
	  
	  $.post('/ziksana-web/secure/addLearnerNote', {"courseId":course_id, 'nodeId':node_id, "noteTitle":note_title, "noteDescription":note_description, "noteDuration":note_duration}, function(data){

		  if(data == '1'){
			  
			  	get_learner_content_notes(node_id, course_id); //refresh learner notes
			  	$('[data-tab="notes_and_bookmarks"]').click(); //show the learner notes pane
			  	
				//if the note is successfully added
				$('#add_note_container').hide(); 
				jwplayer('player').play(true); //resume play
				$('.add_note_title, .add_note_description').val(''); //clear the value
		  }
		  
	  });
	  
	  
  }
  
  //get learner content note
  function get_learner_content_notes(node_id, course_id ){
	  
	  //clear alerdy existing notes of previous node
	  $('#learner_notes').html('');
	  
	  $.get('/ziksana-web/secure/getLearnerNotes', {"courseId":course_id, "nodeId":node_id}, function(data){
		  
  
	  
		  notes = data;

		  var links = '';
		  ff_note_data ="";
			for (i in notes)
			{
			    title = notes[i].noteTitle;
			    description = notes[i].noteDescription;
			    duration = notes[i].noteDuration;
			
			    link = '<a style="display:none;" data-iconprefix="note" class="position" data-position="'+duration+'" title="'+description+'" onclick="jwplayer(\'player\').seek('+duration+').play(true);">'+title+'</a>';
			
			    links += link;
			    if(description=="") ff_note_data=ff_note_data+title+"||"+".."+"||"+duration+"|||";
			    else
			    ff_note_data=ff_note_data+title+"||"+description+"||"+duration+"|||";
			    //console.log("ff_note_data:"+ff_note_data);
			}
			
			$('#learner_notes').html(links);
			sort_by_position('descending'); //sorts by descending order
		
	  });
  }
  
  
  //add learner note
  function add_learner_question(question_title, question_duration){
	  
	  node_id = $('#selected_node_id').val();
	  course_id = $('#courseId').val();
	  
	  $.post('/ziksana-web/secure/addLearnerQuestion', {"courseId":course_id, 'nodeId':node_id, "questionTitle":question_title,  "questionDuration":question_duration}, function(data){

		  if(data == '1'){
			  
			  	get_learner_questions(node_id, course_id); //refresh learner notes
			  	$('[data-tab="questions"]').click(); //show the learner notes pane
			  	
				//if the question is successfully added
				$('#add_question_container').hide(); 
				jwplayer('player').play(true); //resume play
				$('.add_question_title').val(''); //clear the value
		  }
		  
	  });
	  
	  
  }
  
  //get learner questions
  function get_learner_questions(node_id, course_id ){
	  //return true;
	  //clear already existing notes of previous node
	  $('#learner_questions').html('');
	  
	  $.get('/ziksana-web/secure/getLearnerQuestions', {"courseId":course_id, "nodeId":node_id}, function(data){
		  
  
	  
		  questions = data;

		  var links = '';
		  ff_question_data ="";
			for (i in questions)
			{
			    title = questions[i].noteTitle;
			    duration = questions[i].noteDuration;
			
			    link = '<a style="display:none; margin: .5em 0;" data-iconprefix="question" class="position" data-position="'+duration+'" onclick="jwplayer(\'player\').seek('+duration+').play(true);">'+title+'</a>';
			
			    links += link;
			    ff_question_data=ff_question_data+title+"||"+duration+"|||";
			}
			
			$('#learner_questions').html(links);
			sort_by_position('descending'); //sorts by descending order
		
	  });
  }
  
//get content toc
  function get_content_toc(node_id, course_id){
	  //return true;
	  //clear already existing TOC of previous node
	  $('#content_toc_container').html('');
	  
	  $.get('/ziksana-web/secure/getContentTOC', {"courseId":course_id, "nodeId":node_id}, function(data){
		  
  
	  
		  toc_elements = data;

		  var links = '';
		  ff_toc_data ="";
			for (i in toc_elements)
			{
			    title = toc_elements[i].title;
			    duration = toc_elements[i].duration;
			
			    link = '<a style="display:block; margin: .5em 0;" data-iconprefix="" class="" data-position="'+duration+'" onclick="jwplayer(\'player\').seek('+duration+').play(true);">'+title+'</a>';
			    ff_toc_data= ff_toc_data+title+"||"+duration+"|||";
			    links += link;
			}
			
			$('#content_toc_container').html(links);
		
	  });
  }
  
  
  
  ////Reorder/Sort Functions
  function reorder_by_position(position){

		$('.position_sortable').each(function(){
		    var $this = $(this);
		    
		   current_position_element = $this.find('[data-position="'+position+'"]');
		   last_element_in_collection = current_position_element.siblings(":last");


			if(current_position_element.nextAll().length >= 1){
		   		current_position_element.prevAll().slideUp().insertAfter(last_element_in_collection).slideDown();  
			} else {
		   		current_position_element.prevAll().slideUp().insertAfter(current_position_element).slideDown();  
			}
		                                        
		});
	}
  
  function show_by_position(position){

		$('.position_sortable').each(function(){
		    var $this = $(this);
		   
		    
		   current_position_element = $this.find('[data-position="'+position+'"]');
		   
		   current_position_element.fadeIn();
		   current_position_element.nextAll().show();
		   
		   		                                        
		});
	}

  function sort_by_position(order){
	  	//order = 'descending';
		$('.position_sortable').each(function(){
		    var $this = $(this);
		    $this.append($this.find('.position').get().sort(function(a, b) {
		    	if(order == 'ascending'){
		    		return $(a).data('position') - $(b).data('position'); //ascending order
		    	} else {
		    		 return $(b).data('position') - $(a).data('position'); //descending order
		    	}
		    	
		    }));
		});
	}
  
  //looped show by position (process intensive)
  function looped_show_by_position(order){
	  	//order = 'descending';
	  
	  duration = Math.floor(jwplayer('player').getDuration());
	  for(var i=duration; i>=0; i--){
		  show_by_position(i);
		  
	  }

	}	