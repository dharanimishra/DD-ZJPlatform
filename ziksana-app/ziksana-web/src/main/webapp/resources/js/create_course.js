//Author: Arun Prasad. R
var course_tree_data = { "data" : "Untitled Course", "attr" : { "class" : "", "rel": "course", id:"c_root_node" }}; //used to persist tree data across all tabs.
var treeCount = 1; //temporary node id
var tabInfo = new Object();
tabInfo.id ="tabset-1";
var courseProgramTree = {};
var treetype_icon_url = 'images';
var _currentNode;
// Subject Areas
var arrArea = ["Computer science","information & general works","Philosophy","parapsychology and occultism & psychology","Religion","Social sciences","Language","Science","Technology","Literature","History","geography","biography"];
// Subjects
var science = ["Science","Mathematics","Astronomy & allied sciences","Physics","Chemistry & allied sciences","Earth sciences","Paleontology; Paleozoology","Life sciences","Plants","Zoological sciences/Animals"];
var technology = ["Technology(Applied sciences)","Medical sciences; Medicine","Engineering & Applied operations","Agriculture","Home economics & family living","Management & auxiliary services","Chemical engineering","Manufacturing","Manufacture for specific uses","Buildings"];
// Topics
var sci_topic = ["Natural sciences & mathematics","Philosophy & theory","Organizations & management","Education,research, related topics","Natural history","Historical,geographic,persons treatment"];
var mat_topic = ["General principles","Algebra & number theory","Arithmetic","Topology",
"Analysis","Geometry","Not assigned or no longer used","Numerical analysis","Probabilities & applied mathematics"];
var tech_topic = ["Technology","Philosophy & theory","Education, research, related topics","Invention & patents","Historical, geographic, persons treatment"];
var medicine_topic = ["Human anatomy, cytology, histology","Human physiology","Personal health & safety","Incidence & prevention of disease","Pharmacology and therapeutics","Diseases","Surgery & related medical specialties","Gynecology & other medical specialties","Experimental medicine"];

// Data flows based on Selection
var arrSubject = {"Science":science,"Technology":technology};
var arrTopic = {"Science":sci_topic,"Mathematics":mat_topic,"Technology(Applied sciences)":tech_topic,"Medical sciences; Medicine":medicine_topic};

var playbook_static_tree_data = {"data":"The Oceans","attr":{"id":"c_root_node","class":"","rel":"course"},"state":"open","metadata":{},"children":[{"data":"Course Pre-requisites, Co-requisites, and/or Other Restrictions","attr":{"id":"node_2","class":"hello","rel":"prerequisite"},"metadata":{}},{"data":"Student Learning Objectives/Outcomes","attr":{"id":"node_4","class":"hello","rel":"corequisite"},"metadata":{}},{"data":"Course Policies","attr":{"id":"node_6","class":"hello","rel":"other"},"metadata":{}},{"data":"Unit 1","attr":{"id":"node_8","class":"hello","rel":"chapter"},"metadata":{}},{"data":"Unit 2","attr":{"id":"node_10","class":"hello","rel":"chapter"},"metadata":{}},{"data":"Unit 3","attr":{"id":"node_12","class":"hello","rel":"chapter"},"metadata":{}},{"data":"Unit 4","attr":{"id":"node_14","class":"hello","rel":"chapter"},"metadata":{}},{"data":"Unit 5","attr":{"id":"node_16","class":"hello","rel":"chapter"},"metadata":{}},{"data":"Unit 6","attr":{"id":"node_18","class":"hello","rel":"chapter"},"metadata":{}},{"data":"Unit 7","attr":{"id":"node_20","class":"hello","rel":"chapter"},"metadata":{}},{"data":"Unit 8","attr":{"id":"node_22","class":"hello","rel":"chapter"},"metadata":{}},{"data":"Unit 9","attr":{"id":"node_24","class":"hello","rel":"chapter"},"metadata":{}},{"data":"Unit 10","attr":{"id":"node_26","class":"hello","rel":"chapter"},"metadata":{}}]};

var playbook_nodes = ["playbook_node1","playbook_node2","playbook_node3","playbook_node4"];
var playbook_tree_array = {"The Oceans":playbook_nodes[0],"Course Pre-requisites, Co-requisites, and/or Other Restrictions":playbook_nodes[1],"Student Learning Objectives/Outcomes":playbook_nodes[2],"Course Policies":playbook_nodes[3]};

$(function(){

	//Initialize fancy box for 
	$("a.lbx-70-50").fancybox({
			'width'				: 700,
			'height'			: 500,
			'autoScale'			: false,
			'transitionIn'		: 'elastic',
			'transitionOut'		: 'elastic',
			'type'				: 'iframe'
	});	

	$('#treedetails_fancybox_trigger').fancybox({
			'width'				: 700,
			'height'			: 500,
			'autoScale'			: false,
			'transitionIn'		: 'elastic',
			'transitionOut'		: 'elastic',
			'type'				: 'iframe'
	});	
	

	
	// Initialize  inline edit
	$('.inline-edit').inlineEdit({hover: 'hover'});
	
	//Set up Tree for First Time	
	$("#course_name").blur( function() {	
		var title1 = $("#course_name").val(); 
		var len = (title1.length);
		if( len>25)	{
			document.getElementById("errormsg").style.display = "block";
		}else if( len<25){
				document.getElementById("errormsg").style.display = "none";
		}


		if ( $("#course_name").val()=="" ){
			document.getElementById("course_name").value = "Untitled Course";
			course_tree_data.data = "Untitled Course";
			prepareTree('tabset-1','course_tree_tabset-1'); //Prepare Course Tree for First Time or Refresh Tree Title
		}
		if ( $("#course_name").val()!="" ){
			var coursetitle = $("#course_name").val();
			course_tree_data.data =coursetitle;
			prepareTree('tabset-1','course_tree_tabset-1'); //Prepare Course Tree for First Time or Refresh Tree Title
		}	

	});	

	//when first tab nodes are clicked.###
	$('#course_tree_tabset-1 li a').live('click', function(){
		node = $(this).parent('li');
		collectTreeDetails(node);
	});
		
	//// Start Associate Block Code
	// Associate Tab Tree is clicked
	$('#course_tree_tabset-2 li a').live('click',function(){
		node = $(this).parent('li');
		//var file = node.find('a:first').text();
		//var ext = file.split(".");
		//console.log(ext[1]);
		createAssociateNodes(node);
	});
	//// End Associate Block Code
	
	// Enrich Block code
	// Enrich Tab tree is clicked
	$('#course_tree_tabset-3 li a').live('click',function(){
		node = $(this).parent('li');		
	// Start the video if the node is Flash or Video
		var file = node.find('a:first').text();
		var ext = file.split(".");
		//console.log(ext[1]);
		
		if(node.attr('rel') == 'video'){jwplayer('mediaplayer').play();}
		/*if (( ext[1] == "mp4") || ( ext[1] =="flv"))
		{
			jwplayer("mediaplayer").play();			
		}*/
	});
	// Enrich Block code Ends here
	
	
///// Start Assessment Block Code
	
	$('#course_tree_tabset-4 li a').live('click',function(){
	node = $(this).parent('li');
	//if this node is of type 'question' return false.
	if(node.attr('rel') == 'question'){
	
		question_screen_content = 'Question content here';
		
		
		screen_question = '<div class="Maindefine"><br/><br/><p style="font-size:20px;color:#0066CC;font-wight:bold;">List of Questions(Associated)</p><br/><br/><hr style="width:400px; margin-top:-5px;"><div class="submain"><div class="firstcontainer"><div id="description2" style="float:left; margin-left:20px; "><p style="font-size:16px;color:#0066CC;font-wight:bold;">Question Name</font></p><br/><p style="font-family:"Verdana"; color:#666666; font-size:12px;">Question Type. </p><br/><p style="font-family:"Verdana"; color:#666666; font-size:12px;">Description................. </p> </div><div id="txtbx" style="float:left; margin-top: 16px; padding-left: 15px;"><input type="text" placeholder="Enter marks" title="Enter marks" style=" width: 55px; font-size:9px;"/><input type="text" placeholder="Enter time" title="Enter time" style=" width: 50px; font-size:9px; "/><input type="text" placeholder="Penalty Marks" title="Penalty marks" style="width: 65px; font-size:9px;"/></div><div id="linksdefine2" style="float:right; margin-top: 5px; padding-right:5px; "><p>  <img src="images/led/page_white_edit.png" alt="Edit" title="Edit" style="cursor:pointer;"/> &nbsp;<img src="images/led/cross.png" alt="Delete" title="Delete" style="cursor:pointer;"/>  </p></div></div><div class="firstcontainer2"><div id="description2" style="float:left; margin-left:20px; "><p style="font-size:16px;color:#0066CC;font-wight:bold;">Question Name</font></p><br/><p style="font-family:"Verdana"; color:#666666; font-size:12px;">Question Type. </p><br/><p style="font-family:"Verdana"; color:#666666; font-size:12px;">Description................. </p></div><div id="txtbx" style="float:left; margin-top: 16px; padding-left: 15px;"><input type="text" placeholder="Enter marks" title="Enter marks" style=" width: 55px; font-size:9px;"/><input type="text" placeholder="Enter time" title="Enter time" style=" width: 50px; font-size:9px; "/><input type="text" placeholder="Penalty Marks" title="Penalty marks" style="width: 65px; font-size:9px;"/></div><div id="linksdefine2" style="float:right; margin-top: 5px; padding-right:5px; "><p>  <img src="images/led/page_white_edit.png" alt="Edit" title="Edit" style="cursor:pointer;"/> &nbsp;<img src="images/led/cross.png" alt="Delete" title="Delete" style="cursor:pointer;"/>  </p></div></div><div class="firstcontainer"><div id="description2" style="float:left; margin-left:20px; "><p style="font-size:16px;color:#0066CC;font-wight:bold;">Question Name</font></p><br/><p style="font-family:"Verdana"; color:#666666; font-size:12px;">Question Type. </p><br/><p style="font-family:"Verdana"; color:#666666; font-size:12px;">Description................. </p></div><div id="txtbx" style="float:left; margin-top: 16px; padding-left: 15px;"><input type="text" placeholder="Enter marks" title="Enter marks" style=" width: 55px; font-size:9px;"/><input type="text" placeholder="Enter time" title="Enter time" style=" width: 50px; font-size:9px; "/><input type="text" placeholder="Penalty Marks" title="Penalty marks" style="width: 65px; font-size:9px;"/></div><div id="linksdefine2" style="float:right; margin-top: 5px; padding-right:5px; "><p>  <img src="images/led/page_white_edit.png" alt="Edit" title="Edit" style="cursor:pointer;"/> &nbsp;<img src="images/led/cross.png" alt="Delete" title="Delete" style="cursor:pointer;"/></p></div><br /></div><div class="_btnQuestion" style="margin-top: 5px; float:right; "><p style="margin-left:100px;"><a class="lbx-70-50" style=" color:#0066CC;padding-right:10px; text-decoration:none;" href="library/search_qbank.html" > Search and Add question</a><a class="lbx-70-50 txt-size-11" style="color:#0066CC;padding-right:10px; text-decoration:none;" href="library/questionbank.html" >Create New Question</a></p></div> </div><br /> <div><input name="exit_set4" id="exit_set4"type="button" value="Exit" style="margin-left:20px;" /><input name="exit_set4" id="exit_set4"type="button" value="View Test"  /><input name="exit_set2" id="exit_set2"type="button" value="Done" /></div></div></div></div> ';
		
		$('#assignments_container').html(screen_question);
		initializeFancyBox('a.lbx-70-50');
		
/*
		var d = document.getElementById("fancybox-btn_question");				
		if(d == null){ //create a fancy box trigger. 
			var a = document.createElement("a");
			a.setAttribute("href","library/question.html");
			a.setAttribute("id","fancybox-btn_question");
			a.setAttribute("class","associate_lbx-80-50");				
			$("#tabset-2").append(a);
			$(".associate_lbx-80-50").fancybox({
				'width'				: 400,
				'height'			: 350,
				'autoScale'			: false,
				'transitionIn'		: 'elastic',
				'transitionOut'		: 'elastic',
				'type'				: 'iframe'
			});	
			a.click(function() {  $(document).ready(function(){$("a#fancybox-btn_question").fancybox();})});
		}
		$("#fancybox-btn_question").click();
		
	*/
	} else if(node.attr('rel') == 'assignment'){ //in case of an asssignment node, show the assignment content
	
		
		screen_content = '<div class="Maindefine"><br/><br/><div style=" margin-left: 23px;"><input text="text" id="assignmentname" disabled="disabled" placeholder="Ziksana" title="Ziksana"/></div><br/><br/><p style="font-size:24px;color:#0066CC;font-wight:bold;"> Associated test<br/></p><br><hr style="width:450px; margin-top:-5px;"><div class="submain"><div class="firstcontainer"><div class="defineimage2"><img src="images/badge-guru.png" width="73" height="73"/></div><div id="description2" style="float:left; margin-left:20px; "><p style="font-family:"Verdana"; color:#0066CC;">Test Name  </p><p style="font-family:"Verdana"; color:#666666;">Description...................................... </p></div><div id="linksdefine2" style="float:left; "><p> <img src="images/led/cross.png" alt="Delete" title="Delete" style="cursor:pointer;"/> &nbsp; <img src="images/led/page_white_edit.png" alt="Edit" title="Edit" style="cursor:pointer;"/> &nbsp; <img src="images/led/application_view_xp.png" alt="view" title="View" style="cursor:pointer;"/>&nbsp; </p></div></div><div class="firstcontainer2"><div class="defineimage2"><img src="images/badge-wiz.png" width="76" height="76"/></div><div id="description2"style="float:left; margin-left:20px; "><p style="font-family:"Verdana"; color:#0066CC;">Test Name  </p><p style="font-family:"Verdana"; color:#666666;">Description...................................... </p></div><div id="linksdefine2" style="float:left; "><p> <img src="images/led/cross.png" alt="Delete" title="Delete" style="cursor:pointer;"/> &nbsp; <img src="images/led/page_white_edit.png" alt="Edit" title="Edit" style="cursor:pointer;"/> &nbsp; <img src="images/led/application_view_xp.png" alt="view" title="View" style="cursor:pointer;"/>&nbsp; </p> </div> </div> <div class="firstcontainer"><div class="defineimage2"><img src="images/badge-guru.png" width="75" height="75"/></div><div id="description2" style="float:left; margin-left:20px; "><p style="font-family:"Verdana"; color:#0066CC;">Test Name  </p><p style="font-family:"Verdana"; color:#666666;">Description.................................... </p></div><div id="linksdefine2" style="float:left; "><p> <img src="images/led/cross.png" alt="Delete" title="Delete" style="cursor:pointer;"/> &nbsp; <img src="images/led/page_white_edit.png" alt="Edit" title="Edit" style="cursor:pointer;"/> &nbsp; <img src="images/led/application_view_xp.png" alt="view" title="View" style="cursor:pointer;"/>&nbsp; </p></div><br /></div><div id="definebuttons"><p style="margin-left:200px; "><a class="lbx-70-50" style="padding-right:10px;color:#0066CC;" href="library/Addtest(Define Assignment).html" > Add Test</a><a class="lbx-80-50 txt-size-11" style="padding-right:10px;color:#0066CC;" href="#" >Save and Continue</a></p></div></div></div></div></div>';

		$('#assignments_container').html(screen_content);
		initializeFancyBox('a.lbx-70-50');
		var txt1=node.attr('id');

		var txt2=($('#'+txt1).text());
		$('#assignmentname').val(txt2);
		document.getElementById('nodeHid').value=txt1;
	} else {
		$('#assignments_container').html('Click on the Assignment node to Add Assignment/Test');
	}
	
});
	
	
	///// End Assessment Block doc ready Code
	
	////Start Playbook doc ready code block
	$('#course_tree_tabset-6 li a').live('click',function(){		
		node_title = $(this).text();
		node_id = $(this).parent('li').attr('id');
		$("."+playbook_nodes[0]).hide();
		$("."+playbook_nodes[1]).hide();		
		$("."+playbook_nodes[2]).hide();
		$("."+playbook_nodes[3]).hide();				
		var div = playbook_tree_array[node_title.trim()];		
		$("."+playbook_tree_array[node_title.trim()]).show();		
	});	
	
	////End Playbook doc ready code block
	
	
	
	
	
	
	
	////////////////////////////////
	///// Enrich on doc ready block
	////////////////////////////////
//for enrich video options

	var hotspotAdvClicked = 0;
	$('.options').hide();
	$('._search').hide();
	$('._ref').hide();
	$('._advanceSearch').hide();
	$('._notes').hide();
	$('._toc').hide();
	
	$('._exit').click( function(){
		if(hotspotAdvClicked == 0)
			$('._search').hide();
		if(hotspotAdvClicked == 1)	
		{
			$("._searchNormal").show();
			hotspotAdvClicked = 0;
		}
		$('._ref').hide();
		$('._advanceSearch').hide();
		$('._notes').hide();
		$('._toc').hide();		
	});
	
	$('._showoptions').click( function(){
		$('.options').toggle('slow');
		$('._showoptions').hide();		
		});
		
		$('._hotspot').click( function(){
			$('._search').fadeIn();			
			$("._searchNormal").show();			
			$('._ref').hide();
			$('._notes').hide();
			$('._toc').hide();
		});
		
		$('._advance').click( function(){			
			$('._advanceSearch').fadeIn();
			$("._searchNormal").hide();
			$('._notes').hide();			
			$('._toc').hide();
			//$('._advance').hide();
			hotspotAdvClicked = 1;
		});
		
		$('._reference').click( function(){
			$('._ref').fadeIn();
			$('._search').hide();
			$('._notes').hide();
			$('._toc').hide();
		});
		$('.notes').click( function(){
			$('._notes').fadeIn();
			$('._search').hide();
	$('._ref').hide();
	$('._advanceSearch').hide();
	$('._toc').hide();
		});
		
		$('.toc').click( function(){
			$('._notes').hide();
			$('._search').hide();
	$('._ref').hide();
	$('._advanceSearch').hide();
		$('._toc').fadeIn();
		});
	//move the image in pixel
	var move = -15;
	
	//zoom percentage, 1.2 =120%
	var zoom = 1.2;

	//On mouse over those thumbnail
	$('.item').hover(function() {
		
		//Set the width and height according to the zoom percentage
		width = $('.folder').width() * zoom;
		height = $('.folder').height() * zoom;
		
		//Move and zoom the image
		
		
		//Display the caption
		$(this).find('div.caption').stop(false,true).fadeIn(200);
	},
	function() {
		//Reset the image
		//$(this).find('img').stop(false,true).animate({'width':$('.item').width(), 'height':$('.item').height(), 'top':'0', 'left':'0'}, {duration:100});	

		//Hide the caption
		$(this).find('div.caption').stop(false,true).fadeOut(200);
		$(this).find('div.caption')
	});

	//////////////////////////////////
	//// End of Enrich on doc ready code
	//////////////////////////////////
	
	
	
	
	//initialize social tabs
	$('#socializemaintabs').tabs();
	
	
	
	
	
	
	
}); //End of Doc Ready.




//FUNCTIONS
function prepareTree(tab_id, course_tree_id){
		var tree_data;	
        
		
		// Yes its Exists.
		if ($('#'+tab_id).find('#'+course_tree_id).length > 0) {
			//a tree container exists			
			 
		} else {
			tree_container_html = '<div id="'+course_tree_id+'" class="tree_container"></div>';
			$('#'+tab_id).prepend(tree_container_html)
		}

		tree_container = $("#"+course_tree_id);

		tabInfo.id = tab_id;
		// Stop the Video if Playing.
		if(tab_id != "tabset-3")
		{
			jwplayer("mediaplayer").stop();			
		}	
		
		if( tab_id != "tabset-6"){
			//tree_data = eval(jQuery.jstree._reference($("#course_tree")).get_json());
			tree_data = course_tree_data;
		} else {		
			// Hide all the contents
			$("."+playbook_nodes[1]).hide();		
			$("."+playbook_nodes[2]).hide();
			$("."+playbook_nodes[3]).hide();
			// show first one by default
			$("."+playbook_nodes[0]).show();
			//use static data for playbook tab.
			tree_data = playbook_static_tree_data;		
		}		
		createProgramTreeForTabset(tree_data, tree_container);
			
	
}//preparetree


function set_course_tree_data(tree_container_id){
	//course_tree_data = jQuery.jstree._reference($('#'+tree_container_id)).get_json();
	course_tree_data = $("#"+tree_container_id).jstree("get_json", -1);
}
function get_course_tree_data(){
	return course_tree_data;
}




function validChild()
{
	var items;
	items = ["default", "folder", "module", "section","assignment", "prerequisite", "corequisite", "learningobject", "chapter", "lesson", "question", "image","video","pdf","content","web","other"];
	return items;
}


function createProgramTreeForTabset(tree_json_object, tree_container){		
		tree_json_object_string = JSON.stringify(tree_json_object);			
		tree_container.jstree({
			//"json_data":tree_json_object,
			"json_data": { "data" :tree_json_object },
			"themes":{
				"theme":"default",
				"dots":true,
				"icons":true
			},
			"ui" : {
				"select_limit" : 1
			},
			"plugins" : [ "themes", "json_data", "ui", "crrm", "contextmenu", "types" ] ,
			"contextmenu" : {'items' : customMenu },

			////
			// Using types - most of the time this is an overkill
			    // read the docs carefully to decide whether you need types
			    "types" : {
			        // I set both options to -2, as I do not need depth and children count checking
			        // Those two checks may slow jstree a lot, so use only when needed
			        "max_depth" : -2,
			        "max_children" : -2,
			        // I want only `course` nodes to be root nodes
			        // This will prevent moving or creating any other type as a root node
			        "valid_children" : [ "course" ],
			        "types" : {
						"video": {
							"valid_children" : validChild,
						    "icon" : {
			                    "image" : treetype_icon_url + "/icons/video.png"
			                }						
						},
						"pdf": {
							"valid_children" : validChild,
						    "icon" : {
			                    "image" : treetype_icon_url + "/icons/pdf_icon.png"
			                }						
						},						
						"content": {
							"valid_children" : validChild,
						    "icon" : {
			                    "image" : treetype_icon_url + "/icons/word-icon.png"
			                }						
						},
						"web": {
							"valid_children" : validChild,
						    "icon" : {
			                    "image" : treetype_icon_url + "/icons/url.png"
			                }						
						},
						"image": {
							"valid_children" : validChild,
						    "icon" : {
			                    "image" : treetype_icon_url + "/file.gif"
			                }						
						},
						
			            "question" : {
			                "valid_children" : validChild,
			                "icon" : {
			                    "image" : treetype_icon_url + "/file.gif"
			                }
			            },						
						
			            // The default type, the most basic one.
			            "learningobject" : {
			                // I want this type to have only learning objects
			                
			                "valid_children" : validChild,
			                "icon" : {
			                    "image" : treetype_icon_url + "/file.gif"
			                }
			            },
			            "lesson" : {
			                "valid_children" : validChild,
			                "icon" : {
			                    "image" : treetype_icon_url + "/folder.gif"
			                }
			            },

			            "section" : {
			                "valid_children" :validChild,
			                "icon" : {
			                    "image" : treetype_icon_url + "/folder.gif"
			                }
			            },

			            "chapter" : {
			                "valid_children" : validChild,
			                "icon" : {
			                    "image" : treetype_icon_url + "/folder.gif"
			                }
			            },


			            "prerequisite" : {
			                "valid_children" : validChild,
			                "icon" : {
			                    "image" : treetype_icon_url + "/preq_creq_other.png"
			                }
			            },


			            "corequisite" : {
			                "valid_children" :validChild,
			                "icon" : {
			                    "image" : treetype_icon_url + "/preq_creq_other.png"
			                }
			            },


			            "assignment" : {
			                "valid_children" : validChild,
			                "icon" : {
			                    "image" : treetype_icon_url + "/assignment.png"
			                }
			            },

			            "module" : {
			                "valid_children" :validChild,
			                "icon" : {
			                    "image" : treetype_icon_url + "/folder.gif"
			                }
			            },
						
						"other" : {
			                "valid_children" :validChild,
			                "icon" : {
			                    "image" : treetype_icon_url + "/preq_creq_other.png"
			                }
			            },

			            // The `folder` type
			            "folder" : {
			                // can have files and other folders inside of it, but NOT `drive` nodes
			               "valid_children" :validChild,
			                "icon" : {
			                    "image" : treetype_icon_url + "/folder-closed.gif"
			                }
			            },
			            // The `course` nodes
			            "course" : {
			                // can have files and folders inside, but NOT other `course` nodes
			                "valid_children" :validChild,
			                "icon" : {
			                    "image" : treetype_icon_url + "/course.png"
			                },
			                // those prevent the functions with the same name to be used on `drive` nodes
			                // internally the `before` event is used
			                "start_drag" : false,
			                "move_node" : false,
			                "delete_node" : false,
			                "remove" : false
			            },						
			        }
			    }

			////

		
		}).bind("loaded.jstree", function (event, data) {
			//console.log("TREE LOADED");
		});
	};




function initializeFancyBox(selector){
	$(selector).fancybox({
		'width'				: 700,
		'height'			: 500,
		'autoScale'			: false,
		'transitionIn'		: 'elastic',
		'transitionOut'		: 'elastic',
		'type'				: 'iframe'
	});	
}








	function createAssociateNodes(node) {

		currentNode = node;
		var d = document.getElementById("fancybox-btn");				
		if(d == null){ //create a fancy box trigger. 
			var a = document.createElement("a");
			a.setAttribute("href","create_adddescribe.html");
			a.setAttribute("id","fancybox-btn");
			a.setAttribute("class","associate_lbx-80-50");				
			$("#tabset-2").append(a);
			$(".associate_lbx-80-50").fancybox({
				'width'				: 700,
				'height'			: 500,
				'autoScale'			: false,
				'transitionIn'		: 'elastic',
				'transitionOut'		: 'elastic',
				'type'				: 'iframe'
			});	
			a.click(function() {  $(document).ready(function(){$("a#fancybox-btn").fancybox();})});
		}
		$("#fancybox-btn").click();
		console.log($(".associate_lbx-80-50"));
	}


//custom Context Menu
function customMenu(node) {
    	
	var items;
	currentNode = node;
	tab_id = node.parents('div').attr('id');
	//if(tabInfo.id == "tabset-2"){
	if(tab_id == "tabset-2"){
	items = {
    	create: {
    		label: "Create",
			//action: associate_fancybox(node)
    		action: function(obj) {
				var d = document.getElementById("fancybox-btn");				
				if(d == null)
				{
				var a = document.createElement("a");
				a.setAttribute("href","create_adddescribe.html");
				a.setAttribute("id","fancybox-btn");
				a.setAttribute("class","associate_lbx-80-50");				
				$("#tabset-2").append(a);
				$(".associate_lbx-80-50").fancybox({
					'width'				: 700,
					'height'			: 500,
					'autoScale'			: false,
					'transitionIn'		: 'elastic',
					'transitionOut'		: 'elastic',
					'type'				: 'iframe'
				});	
				a.click(function() {  $(document).ready(function(){$("a#fancybox-btn").fancybox();})});
				}
				$("#fancybox-btn").click();
				//console.log($(".associate_lbx-80-50"));
			}
		},	
		renameItem: { // The "rename" menu item
            label: "Rename",
            action: function (obj) { this.rename(obj); }
        },
        deleteItem: { // The "delete" menu item
            label: "Delete",
            action: function (obj) { if(this.is_selected(obj)) { this.remove(); } else { this.remove(obj); } }
        }
	}
	 return items;
	}
	// Continues if Not Tab-2
	// The default set of all items
	
    var items = {
        createItem: { // The "rename" menu item
            label: "Create Component",
            action: function (obj) { collectTreeDetails(obj); /*this function uses the parent obj and a fancy box form to create new node*/ }
        },
        renameItem: { // The "rename" menu item
            label: "Rename",
            action: function (obj) { this.rename(obj); }
        },
        deleteItem: { // The "delete" menu item
            label: "Delete",
            action: function (obj) { if(this.is_selected(obj)) { this.remove(); } else { this.remove(obj); } }
        }
    };

    if ($(node).hasClass("folder")) {
        // Delete the "delete" menu item
        delete items.deleteItem;
    }

    return items;
}




//collect node details in fancybox
function collectTreeDetails(obj){

	parent_node_id = $(obj).attr('id');

	anchor = $('#treedetails_fancybox_trigger');
	anchor_href='create_addtree.html?parent_node_id='+parent_node_id;
	anchor.attr('href', anchor_href);
	$('a#treedetails_fancybox_trigger').click();
}

//open treedetails in fancybox
function openNodeDetails(node){
	//console.log('about to open node details')
	node_id = node.attr('id');
	node_name = node.children("a").text() ;
	node_type = node.attr('rel');
	anchor = $('#treedetails_fancybox_trigger');
	//anchor_href='create_addtree.html?node_id='+new_node_id+'&node_type='+new_node_type;
	anchor_href='tree_node_details.html?node_id='+node_id+'&node_type='+node_type;
	anchor.attr('href', anchor_href);
	$('a#treedetails_fancybox_trigger').click();
}


//create nodes
function createNode(parent_node_id, text, node_type){

	//console.log(parent_node_id +'--'+text+'---'+node_type);
	node = $('#'+parent_node_id);
	node_id = "node_"+treeCount++;
	new_node_obj = { 
						"data" : text, 
						"attr" : { "class" : "hello", "rel": node_type, "id": node_id }
					}
	$("#course_tree_tabset-1").jstree("create",'#'+parent_node_id,'last',new_node_obj,false,true);

	set_course_tree_data('course_tree_tabset-1'); //update global tree data
}

//create test type nodes
function createTestNode(parent_node_id, text, node_type){
	treeCount = parent.treeCount;
	node = $('#'+parent_node_id);
	node_id = "node_"+treeCount++;
	new_node_obj = { 
						"data" : text, 
						"attr" : { "class" : "hello", "rel": node_type, "id": node_id }
					}
	$("#course_tree_tabset-4").jstree("create",'#'+parent_node_id,'last',new_node_obj,false,true);
	set_course_tree_data('course_tree_tabset-4'); //updates global tree data
}


function fillSubject() {
		var course_areaval = document.getElementById("course_areaval");
		var indexArea = course_areaval.selectedIndex
		var course_subjectval = document.getElementById("course_subjectval");
		var indexSubject = course_subjectval.selectedIndex
		if (indexArea == 1) {
			var course_subjectval = document.getElementById("course_subjectval");
			var subject0 = new Option('-Select Subject1-', 'Select Subject1');
			var subject1 = new Option('Subject 11', 'Subject 11');
			var subject2 = new Option('Subject 12', 'Subject 12');
			var subject3 = new Option('Subject 13', 'Subject 13');
			
			course_subjectval.options[0] = subject0;
			course_subjectval.options[1] = subject1;
			course_subjectval.options[2] = subject2;
			course_subjectval.options[3] = subject3;
		}else if (indexArea == 2) {

			var course_subjectval = document.getElementById("course_subjectval");
			var subject0 = new Option('-Select Subject2-', 'Select Subject2');
			var subject1 = new Option('Subject 21', 'Subject 21');
			var subject2 = new Option('Subject 22', 'Subject 22');
			var subject3 = new Option('Subject 23', 'Subject 23');
			
			course_subjectval.options[0] = subject0;
			course_subjectval.options[1] = subject1;
			course_subjectval.options[2] = subject2;
			course_subjectval.options[3] = subject3;
		}else if (indexArea == 3) {

			var course_subjectval = document.getElementById("course_subjectval");
			var subject0 = new Option('-Select Subject3-', 'Select Subject3');
			var subject1 = new Option('Subject 31', 'Subject 31');
			var subject2 = new Option('Subject 32', 'Subject 32');
			var subject3 = new Option('Subject 33', 'Subject 33');
			
			course_subjectval.options[0] = subject0;
			course_subjectval.options[1] = subject1;
			course_subjectval.options[2] = subject2;
			course_subjectval.options[3] = subject3;
		} else if (indexSubject== 1) {
			var course_topicval = document.getElementById("course_topicval");
			var topic0 = new Option('-Select Topic1-', '0');
			var topic1 = new Option('Topic 11', 'Topic 11');
			var topic2 = new Option('Topic 12', 'Topic 12');

			course_topicval.options[0] = topic0;
			course_topicval.options[1] = topic1;
			course_topicval.options[2] = topic2;
		}
		else if (indexSubject== 2) {
			var course_topicval = document.getElementById("course_topicval");
			var topic0 = new Option('-Select Topic1-', '0');
			var topic1 = new Option('Topic 21', 'Topic 21');
			var topic2 = new Option('Topic 22', 'Topic 22');

			course_topicval.options[0] = topic0;
			course_topicval.options[1] = topic1;
			course_topicval.options[2] = topic2;
		}
	}

function fillTopic() {
		var course_areaval = document.getElementById("course_areaval");
		var indexArea = course_areaval.selectedIndex

		var course_subjectval = document.getElementById("course_subjectval");
		var indexSubject = course_subjectval.selectedIndex
		if (indexSubject== 1) {
			var course_topicval = document.getElementById("course_topicval");
			var topic0 = new Option('-Select Topic1-', '0');
			var topic1 = new Option('Topic 11', 'Topic 11');
			var topic2 = new Option('Topic 12', 'Topic 12');

			course_topicval.options[0] = topic0;
			course_topicval.options[1] = topic1;
			course_topicval.options[2] = topic2;
		}
		else if (indexSubject== 2) {
			var course_topicval = document.getElementById("course_topicval");
			var topic0 = new Option('-Select Topic1-', '0');
			var topic1 = new Option('Topic 21', 'Topic 21');
			var topic2 = new Option('Topic 22', 'Topic 22');

			course_topicval.options[0] = topic0;
			course_topicval.options[1] = topic1;
			course_topicval.options[2] = topic2;
		}

	}
	

	function validCourseChild()
	{
		var items = [ "default", "folder", "module", "section", "assignment", "prerequisite", "corequisite", "learningobject", "chapter", "lesson", "question", "other"];
		return items;
	}
	
	function createProgramTree(tree_json_object){
		$("#course_tree").jstree({
			"json_data":tree_json_object,
			"themes":{
				"theme":"default",
				"dots":true,
				"icons":true
			},
			"ui" : {
				"select_limit" : 1
			},
			"plugins" : [ "themes", "json_data", "ui", "crrm", "contextmenu", "types" ] ,
			"contextmenu" : {'items' : customMenu },

			////
			// Using types - most of the time this is an overkill
			    // read the docs carefully to decide whether you need types
			    "types" : {
			        // I set both options to -2, as I do not need depth and children count checking
			        // Those two checks may slow jstree a lot, so use only when needed
			        "max_depth" : -2,
			        "max_children" : -2,
			        // I want only `course` nodes to be root nodes
			        // This will prevent moving or creating any other type as a root node
			        "valid_children" : [ "course" ],
			        "types" : {
						
						"question" : {
			                "valid_children" : validCourseChild,
			                "icon" : {
			                    "image" : treetype_icon_url + "/file.gif"
			                }
			            },
			            "learningobject" : {
			                // I want this type to have only learning objects
			                "valid_children": validCourseChild,
			                "icon" : {
			                    "image" : treetype_icon_url + "/file.gif"
			                }
			            },
			            "lesson" : {
							"valid_children": validCourseChild,
			                "icon" : {
			                    "image" : treetype_icon_url + "/folder.gif"
			                }
			            },

			            "section" : {
							"valid_children": validCourseChild,
			                "icon" : {
			                    "image" : treetype_icon_url + "/folder.gif"
			                }
			            },

			            "chapter" : {
							"valid_children": validCourseChild,
			                "icon" : {
			                    "image" : treetype_icon_url + "/folder.gif"
			                }
			            },


			            "prerequisite" : {
							"valid_children": validCourseChild,
			                "icon" : {
			                    "image" : treetype_icon_url + "/preq_creq_other.png"
			                }
			            },


			            "corequisite" : {
							"valid_children": validCourseChild,
			                "icon" : {
			                    "image" : treetype_icon_url + "/preq_creq_other.png"
			                }
			            },


			            "assignment" : {
							"valid_children": validCourseChild,
			                "icon" : {
			                    "image" : treetype_icon_url + "/assignment.png"
			                }
			            },

			            "module" : {
							"valid_children": validCourseChild,
			                "icon" : {
			                    "image" : treetype_icon_url + "/folder.gif"
			                }
			            },
						
						"other" : {
			                "valid_children" :validCourseChild,
			                "icon" : {
			                    "image" : treetype_icon_url + "/preq_creq_other.png"
			                }
			            },

			            // The `folder` type
			            "folder" : {
							// can have files and other folders inside of it, but NOT `drive` nodes
							"valid_children": validCourseChild,
			                "icon" : {
			                    "image" : treetype_icon_url + "/folder-closed.gif"
			                }
			            },
			            // The `course` nodes
			            "course" : {
			                // can have files and folders inside, but NOT other `course` nodes
							"valid_children": validCourseChild,
			                "icon" : {
			                    "image" : treetype_icon_url + "/course.png"
			                },
			                // those prevent the functions with the same name to be used on `drive` nodes
			                // internally the `before` event is used
			                "start_drag" : false,
			                "move_node" : false,
			                "delete_node" : false,
			                "remove" : false
			            }
			        }
			    }

			////

		
		}).bind("loaded.jstree", function (event, data) {
			//console.log("TREE LOADED");
		});
	};
	
	

function loadArea()
{
	var obj = document.getElementById("course_areaval");	
    for(var i=1;i<=arrArea.length;i++){
	  //alert(area[i-1]);
	  obj.options[i] = new Option(arrArea[i-1]);
	}
}
function areaSelected(val)
{
  var arr = arrSubject[val];
  var obj = document.getElementById("course_subjectval");
  obj.innerHTML='<option value="">Select Subject</option>'; 
  var obj1 = document.getElementById("course_topicval");
  obj1.innerHTML='<option value="">Select Topic</option>';      
  if(arr != undefined){
	for(var i=1;i<=arr.length;i++){
	obj.options[i] = new Option(arr[i-1]);
	}
  }  
}

function subjectSelected(val)
{
  var arr = arrTopic[val];  
  var obj = document.getElementById("course_topicval");
  obj.innerHTML='<option value="">Select Topic</option>';    
  if(arr != undefined){
	for(var i=1;i<=arr.length;i++){
	obj.options[i] = new Option(arr[i-1]);
	}
  }  
}

$(document).ready(function(){
	loadArea();
});

	