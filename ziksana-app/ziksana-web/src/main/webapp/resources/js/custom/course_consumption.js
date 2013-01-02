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
	                var node_id = item.id;
	                var parent_node_id = item.parentId;
	                var course_id = $('#courseId').val();
	                display_content(node_id, parent_node_id, course_id);

                  //Get Educator Notes
                  get_educator_notes(node_id, parent_node_id, course_id);
                  //Get Educator Suggested References
                  get_educator_suggested_references(node_id, parent_node_id, course_id);

           		});

           		function display_content(node_id, parent_node_id, course_id){
           			//this function makes a request to the server, fetches the content and displays it. The server is expected to return two parameters, 1.contentType and 2. contentUrl. 
           			// 'contentType' will be either 'video', 'audio' or 'image' or 'imageset'
           			// 'contentUrl' will be the url for the 'video' or 'audio' or 'image slideshow url'

           			//Step 1. Make a request to the server to fetch the content
           			$.get('/ziksana-web/secure/content/getContent', {'contentId':node_id, 'parentNodeId':parent_node_id, 'courseId':course_id}, function(data){
           				console.log(data);

           				
           				content_type = (data.contentTypeString).toUpperCase();
           				console.log(content_type);
           				content_path = data.contentUrl;

           				if(content_type == 'VIDEO'){ playVideo(content_path); }
           				if(content_type == 'AUDIO'){ playAudio(content_path); }
           				if(content_type == 'IMAGE'){ displayImageSet(path); }
           				if(content_type == 'IMAGESET'){ displayImageSet(path); }



           			});
	                console.log(node_id);
           		}

  });//end of doc ready
  
  
	function playVideo(path) {
		console.log('inside play video');
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
					file : filepath
					
					
				});
		jwplayer().play(true);
	}
	
	function displayImageSet(path){
		jwplayer().stop();
		$('#video_actions').css('visibility','hidden');
		$('#play-vedio').css('visibility','hidden');
		filepath = anchor.attr('data-filepath');
		$.fancybox({
			'width': '85%',
			'height': '85%',
			'autoScale': true,
			'transitionIn': 'fade',
			'transitionOut': 'fade',
			'type': 'iframe',
			'href': path,
			'showCloseButton': false,
			'onComplete': add_ziklogo_and_close_button()
	
		});
		
	}

  function get_educator_suggested_references(node_id, parent_node_id, course_id){


    // $.get('/ziksana-web/secure/educatorNotes', {'nodeId':node_id, "parentNodeId":parent_node_id, "courseId":course_id}, function(data){

    //   console.log(data);

    //   references = data;

    //   links = '';

    //   for(var i=0; i<=references.length; i++){
    //     title = references[i].title;
    //     uri = references[i].uri;

    //     link = '<a data-iconprefix="link" href="'+uri+'" >'+title+'</a>'

    //     links += link;

    //   }

    //   $('[data-tabpane="educator"]').find('.educator_references').html(links);

    // });


  
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

        link = '<a data-iconprefix="note" href="#" title="'+description+'">'+title+'</a>'

        links += link;
    }

      // for(var i=0; i<=notes.length; i++){
      //   title = notes[i].title;
      //   description = notes[i].description;
      //   duration = notes[i].duration;

      //   link = '<a data-iconprefix="note" href="#" title="'+description+'">'+title+'</a>'

      //   links += link;

      // }

     $('[data-tabpane="educator"]').find('.educator_notes').html(links);



    });

  }
