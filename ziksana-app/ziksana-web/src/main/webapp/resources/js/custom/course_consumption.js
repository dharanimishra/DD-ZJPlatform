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

  });//end of doc ready
  
  
	function playVideo(path) {
		//console.log('inside play video');
		//TopUp.close();
		//$.fancybox().close();
		$('#play-vedio, #video_actions').css('visibility','visible');
		jwplayer().load(
				{
					file : path
				});
		jwplayer().play(true);
	}
	
	function playAudio(path){
		
		//TopUp.close();
		//$.fancybox().close();
		$('#video_actions').css('visibility','hidden');
		$('#play-vedio').css('visibility','visible');

		jwplayer().load(
				{
					file : path
					
					
				});
		jwplayer().play(true);
	}
	
	function displayImageSet(path){
		jwplayer().stop();
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

       
       for (i in references)
       {
           title = references[i].title;
           uri = references[i].uri;

           link = '<a data-iconprefix="link" target="_blank" href="'+uri+'" >'+title+'</a>'

           links += link;
       }

       $('[data-tabpane="educator"]').find('.educator_references').html(links);

     });


  
  }

  function get_educator_notes(node_id, parent_node_id, course_id){
	  

    $.get('/ziksana-web/secure/educatorNotes', {'nodeId':node_id, "parentNodeId":parent_node_id, "courseId":course_id}, function(data){

     

      notes = data;

      var links = '';

    for (i in notes)
    {
        title = notes[i].title;
        description = notes[i].description;
        duration = notes[i].duration;

        link = '<a data-iconprefix="note" href="#" title="'+description+'">'+title+'</a>';

        links += link;
    }


     $('[data-tabpane="educator"]').find('.educator_notes').html(links);



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
				jwplayer().play(true); //resume play
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

			for (i in notes)
			{
			    title = notes[i].noteTitle;
			    description = notes[i].noteDescription;
			    duration = notes[i].noteDuration;
			
			    link = '<a data-iconprefix="note" title="'+description+'" onclick="jwplayer().seek('+duration+').play(true);">'+title+'</a>';
			
			    links += link;
			}
			
			$('#learner_notes').html(links);
		
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
				jwplayer().play(true); //resume play
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

			for (i in questions)
			{
			    title = questions[i].noteTitle;
			    duration = questions[i].noteDuration;
			
			    link = '<a style="display:block; margin: .5em 0;" data-iconprefix="question"  onclick="jwplayer().seek('+duration+').play(true);">'+title+'</a>';
			
			    links += link;
			}
			
			$('#learner_questions').html(links);
		
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

			for (i in toc_elements)
			{
			    title = toc_elements[i].title;
			    duration = toc_elements[i].duration;
			
			    link = '<a style="display:block; margin: .5em 0;" data-iconprefix=""  onclick="jwplayer().seek('+duration+').play(true);">'+title+'</a>';
			
			    links += link;
			}
			
			$('#content_toc_container').html(links);
		
	  });
  }