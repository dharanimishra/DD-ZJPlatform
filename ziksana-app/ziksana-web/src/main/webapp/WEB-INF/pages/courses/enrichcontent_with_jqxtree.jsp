<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>Enrich Content</title>
<!--Body Style sheet-->
<link rel="stylesheet" type="text/css" href="/ziksana-web/resources/css/dropdown.css" />
<link href="/ziksana-web/resources/css/styles.css" rel="stylesheet" type="text/css">
<link href="/ziksana-web/resources/css/type-setting.css" rel="stylesheet" type="text/css">
<link href="/ziksana-web/resources/css/effects.css" rel="stylesheet" type="text/css">
<link href="/ziksana-web/resources/css/nav.css" rel="stylesheet" type="text/css">
	<link
	href="/ziksana-web/resources/css/common/wizard/wizardstylesheet.css"
	rel="stylesheet" type="text/css">
<link href="/ziksana-web/resources/css/spinner/smartspinner.css" rel="stylesheet"
	type="text/css">
<link rel="stylesheet" href="/ziksana-web/resources/css/chosen/superbly-tagfield.css" />
<link href="/ziksana-web/resources/css/assignment.css" rel="stylesheet" type="text/css">
<link rel='stylesheet' type='text/css' href="/ziksana-web/resources/css/nav.css" />
<!--End Body Style sheet-->

<script type="text/javascript" src="/ziksana-web/resources/js/jquery-1.7.1.min.js"></script>
<script src="/ziksana-web/resources/js/custom.js" type="text/javascript"></script>
<!-- <script type="text/javascript" src="/ziksana-web/resources/js/video_player.js"></script> -->
<script type='text/javascript' src="/ziksana-web/resources/jwplayer/swfobject.js"></script>
<script type="text/javascript" src="/ziksana-web/resources/jwplayer/jwplayer.js"></script>
<!-- css for tree -->
<link rel="stylesheet" href="/ziksana-web/resources/js/tree/styles/styleTree.css"
	type="text/css" />
<!-- for the layout of the tree -->

<!-- scripts for tree -->
<script type="text/javascript" src="/ziksana-web/resources/js/tree/gettheme.js"></script>
<script type="text/javascript" src="/ziksana-web/resources/js/tree/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="/ziksana-web/resources/js/tree/core.js"></script>
<script type="text/javascript" src="/ziksana-web/resources/js/tree/buttons.js"></script>
<script type="text/javascript" src="/ziksana-web/resources/js/tree/scrollbar.js"></script>
<script type="text/javascript" src="/ziksana-web/resources/js/tree/panel.js"></script>
<script type="text/javascript" src="/ziksana-web/resources/js/tree/dragdrop.js"></script>
<script type="text/javascript" src="/ziksana-web/resources/js/tree/tree.js"></script>
<script type="text/javascript" src="/ziksana-web/resources/js/tree/menu.js"></script>
<script type="text/javascript" src="/ziksana-web/resources/js/tree/myTreeEnrich.js"></script>
<script type="text/javascript" src="/ziksana-web/resources/js/tree/splitter.js"></script>
<script type="text/javascript" src="/ziksana-web/resources/js/tree/jqxexpander.js"></script>
<script src="/ziksana-web/resources/js/custom/z_plugins.js"></script>
<script src="/ziksana-web/resources/js/custom/z_common.js"></script>


<link rel="stylesheet" href="http://www.jqwidgets.com/jquery-widgets-demo/jqwidgets/styles/jqx.base.css" type="text/css" />
<script type="text/javascript" src="http://www.jqwidgets.com/jquery-widgets-demo/scripts/gettheme.js"></script>
<!-- <script type="text/javascript" src="http://www.jqwidgets.com/jquery-widgets-demo/scripts/jquery-1.8.2.min.js"></script> -->
<script type="text/javascript" src="http://www.jqwidgets.com/jquery-widgets-demo/jqwidgets/jqxcore.js"></script>
<script type="text/javascript" src="http://www.jqwidgets.com/jquery-widgets-demo/jqwidgets/jqxdata.js"></script>
<script type="text/javascript" src="http://www.jqwidgets.com/jquery-widgets-demo/jqwidgets/jqxbuttons.js"></script>
<script type="text/javascript" src="http://www.jqwidgets.com/jquery-widgets-demo/jqwidgets/jqxscrollbar.js"></script>
<script type="text/javascript" src="http://www.jqwidgets.com/jquery-widgets-demo/jqwidgets/jqxpanel.js"></script>
<script type="text/javascript" src="http://www.jqwidgets.com/jquery-widgets-demo/jqwidgets/jqxtree.js"></script>

<!-- End tree -->
<link rel="stylesheet" type="text/css"
	href="/ziksana-web/resources/js/ui/jquery.fancybox-1.3.4.css" media="screen" />
<script type="text/javascript"
	src="/ziksana-web/resources/js/ui/jquery.mousewheel-3.0.4.pack.js"></script>
<script type="text/javascript" src="/ziksana-web/resources/js/ui/jquery.fancybox-1.3.4.pack.js"></script>
<script type='text/javascript' src="/ziksana-web/resources/js/custom/libraryfunction.js"></script>
<!-- scripts for number spinner -->
<script type="text/javascript" src="/ziksana-web/resources/js/chosen/superbly-tagfield.min.js"></script>

<!-- end for number spinner -->
<script src="/ziksana-web/resources/js/dropdown/hover-dropdown.min.js"></script>
<script src="/ziksana-web/resources/js/dropdown/tiwtter.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		
		
		 
		$(".signin1").click(function(e) {
			e.preventDefault();
			$("fieldset#signin_menu").toggle();
			$(".signin1").toggleClass("menu-open");
		});

		$("fieldset#signin_menu").mouseup(function() {
			return false
		});
		$(document).mouseup(function(e) {
			if ($(e.target).parent("a.signin").length == 0) {
				$(".signin1").removeClass("menu-open");
				$("fieldset#signin_menu").hide();
			}
		});

	});
</script>
<script>
	$(document).ready(function() {
		$('.js-activated').dropdownHover();
	});
</script>

<style>
#splitter {
	width: 975px;
	height: auto;
}

#jqxTree {
	height: auto;
	width: auto;
}

#jqxExpander {
	width: 320px;
	height: auto;
}

.breadcrumb li:nth-child(3) a {
	background: #6D9EC5;
	color: #fff;
}

.breadcrumb li:nth-child(3) a:after {
	border-left-color: #6D9EC5 !important;
}
.mnuclass {
    color: #2277BB;
    font-family: verdana;
    font-size: 12px;
    font-weight: normal;
    text-decoration: none;
}
</style>


</head>

<body>

	<div id="wrapper">
		<p>
			<a><img data-launcher data-launchpage="/ziksana-web/secure/launcher"
				src="/ziksana-web/resources/images/ziksana_button_logo.png"
				width=120px height=120px
				style="position: absolute; top: 3px; left: 30px; margin-left: 0px;" /></a>
		</p>
		<header class="bottom-box-shadow bckground-wihte">
			<div class="topheader">
				<!--logo container-->

				<!--end logo container-->


			</div>
			<nav>
				<div class="menu" style="margin-left: 0px;">
					<ul>
						<li><a href="/ziksana-web/secure/homepage">My Home</a>
							<div class="nav-line"></div></li>
						<li><a href="/ziksana-web/zcourse/myprograms" class="current">My
								Programs</a>
							<div class="nav-line"></div></li>
						<li><a>My Students</a>
							<div class="nav-line"></div></li>
						<li><a style="margin-left: -10px;">My Locker</a></li>
					</ul>
				</div>

				<div class="status-container">

					<div id="status-icons"
						class="bottom-box-shadow two-bottom-rounded-box ">

						<ul>
							<li><a class="email-icon" rel="tipsy"
								title="3 New Messages"><span class="wite-title">3</span></a></li>
							<li><a  class="peoples-icon orange-bc" rel="tipsy"
								title="5 Contact requests"><span class="wite-title">5</span></a></li>
							<li><a  class="alart-icon orange-bc" rel="tipsy"
								title="1 Connect Request"><span class="wite-title">1</span></a></li>
							<li><a class="announcement-icon orange-bc"
								rel="tipsy" title="3 New Announcement"><span
									class="wite-title">3</span></a></li>
							<li><a  class=" amount-icon blue-bc" rel="tipsy"
								title="Ziks available"><span class="wite-title">355500</span></a></li>

						</ul>
						<div></div>
					</div>
					<div class="account-container two-bottom-rounded-box">
						<div class="container">
							<div class="topnav">
								<a class="signin1 wite bold"><span
									class="text-size-px12 wite bold">My Account</span></a>
							</div>
							<fieldset id="signin_menu">
								<ul>
									<li><a>Preferences</a></li>
									<li><a>Privacy</a></li>
									<li><a href="/ziksana-web/secure/logout">Sign Out</a></li>
								</ul>
							</fieldset>
						</div>
					</div>
				</div>
			</nav>
		</header>
		<!--End Header Container-->
		<div class="sub-nav">
			<div class="f-l">
				<strong class="text-size-px12 font-Signika blue"><a
					href="/ziksana-web/zcourse/myprograms">My Courses </a> </strong>|&nbsp;<strong
					class="light-gray text-size-px12 font-Signika">Create New Course </strong>
			</div>
			<div class="f-r">
				<a href="#" class="mnuclass" > Manage </a> | <a class="mnuclass"  href="#"> Publish</a>
				<a class="light-blue"><img width="12" height="12" alt="add more" src="/ziksana-web/resources/images/plus.png">
				</a>
			</div>
		</div>
		<!--Main Content-->
		<section>
			<div class="section">
				<div class="col-create"
					style="width: 1000px; background-color: #FFFFFF;">
					<div class="for-rounded-box  all-box-shadow white-bg">



						<!--Wizard start-->
									<div id="page-wrap">

							<ul class="breadcrumb" style="padding: 1px;">
								<li><a href="/ziksana-web/zcourse/createcourse/${courseId}"
									style="width: 100px; text-align: center;"><span
										class="bcumb">1.</span> Define Course</a></li>
								<li><a
									href="/ziksana-web/zcourse/associatecontent/${courseId}"
									style="text-align: center;">2. Organize Content</a></li>
								<li><a href="/ziksana-web/zcourse/enrichcontent/${courseId}"
									style="width: 124px; text-align: center;">3. Enrich Content</a></li>
								<li><a  style="width: 130px; text-align: center;">4.
										Define Assignment</a></li>
								<li><a style="text-align: center;">5. Define
										Planner</a></li>
								<li><a  style="text-align: center;">6. Define
										Playbook</a></li>
								<li><a  style="width: 120px; text-align: center;">7.
										Socialize Course</a></li>
								<li></li>
								<!--<li><a href="#">Hidden</a></li>-->
							</ul>

						</div>
						<!--Wizard end  -->

					

						
						<div class="associate">
							
							<div class="definecontainer" style="float: left;">
							<br/>
								<p class="definehelp all all-box-shadow"
									style="width: 965px; padding: 5px; font-family: Helvetica; font-weight: bold; font-size: 18px; color: #125F92;">
									<img src="/ziksana-web/resources/images/icons/helpicon.png" align="left"
										style="padding-left: 5px; margin-right: 4px; line-height: 28px;" /><b>You
										can enrich your Video content by associating related
										materials/notes at different points in the video timeline. 
										Right Click over the Course Content to enrich it.
									</b>
								</p>

								<div id="splitter" style='clear: both;'>

									<div id='jqxWidget'>
										<div id='jqxExpander'>
											<div style="background-color: #FFFFFF; border: none; display: none;"></div>
										<input type="hidden" id="courseId" value="${courseid}"/>	
										
										<div id="jqx_course_tree"></div>
																			
										</div>

										<!-- <div id='rc_jqxMenu' class="jqxMenu3">
											<ul>
												<li id="videocontainer2"><img src="/ziksana-web/resources/images/view.png"
													alt="View" height="10" width="10"
													style="margin-right: 5px; margin-left: -5px;" /> Enrich
													Content</li>
											</ul>

										</div>-->
										<div id='rc_jqxMenu'>
								            <ul>
								                <li><img src="/ziksana-web/resources/images/view.png"
													alt="View" height="10" width="10"
													style="margin-right: 5px; margin-left: -5px;" />Enrich Content</li>
								            </ul>
								        </div>


									</div>

									<div id="ContentPanel"
										style="font-size: 11px; margin:1em;">
										

									<%-- <jsp:include page="enrich_player.jsp" /> --%>
									
										
										
									</div>
									<!-- End of Content Panel 

								</div>
								<!-- end tree function -->
								<br /> <br /> <a class="btn btn-info f-r"
									id="saveBottomAssociate" style="margin-right: -250px;">Save
									and Continue</a>

							</div>

						</div>

						<!----------------end of associate ------------------------->



						<!--End Center Container-->

					</div>
				</div>
			</div>
		</section>
		<!--End Main Content-->
		<!--Current Progress-->
		<div class="col border-top">
			<div class="collapse">
				<h3 class="border-left border-right border-top">Your current
					progress [ Starting ... ]</h3>
				<div>
					<p class="caption text-size-px18">Your progress this session...
					</p>
				</div>
			</div>
		</div>

		<script>
			$(".collapse").collapse({
				show : function() {
					this.animate({
						opacity : 'toggle',
						height : 'toggle'
					}, 300);
				},
				hide : function() {

					this.animate({
						opacity : 'toggle',
						height : 'toggle'
					}, 300);
				}
			});

			//rating-star	
			$('#edu-star').raty({

				click : function(score, evt) {
					$(this).fadeOut(function() {
						$(this).fadeIn();
					});
				},
				targetKeep : true,
				path : '/ziksana-web/resources/images/img/',
				score : 4,
				cancel : true
			});
		</script>


		<!--End Current Progress-->
		<!--Footer Container-->
		<footer> </footer>
		<!--End Footer Container-->
	</div>
	
<script type="text/javascript">
function load_tree(){
	
	

	// prepare the data



	var source ={



		datatype : "xml",



		datafields : [



		// { name: 'CompanyName', map: 'm\\:properties>d\\:CompanyName'

		// },



		{

			name : 'id',

			map : 'id'

		},



		{

			name : 'parentId',

			map : 'parentId'

		},



		{

			name : 'title',

			map : 'title'

		},



		{

			name : 'nodeType',

			map : 'nodeType'

		},



		{

			name : 'contentId',

			map : 'contentId'

		},



		{

			name : 'contentType',

			map : 'contentType'

		},



		{

			name : 'icon',

			map : 'icon'

		},



		{

			name : 'expanded',

			map : 'expanded'

		}



		],



		root : "nodes",



		record : "node",



		id : 'id',



		url : "/ziksana-web/zcourse/getcoursetree/"

				+ $('#courseId').val(),



		async : false



	};



	// create data adapter.



	var dataAdapter = new $.jqx.dataAdapter(source);



	// perform Data Binding.



	dataAdapter.dataBind();



	// get the tree items.



	// The first parameter is the item's id. The second parameter is the

	// parent item's id. The 'items' parameter represents the sub items

	// collection name. Each jqxTree item has a 'label' property, but in

	// the xml data, we have a 'text' field. The last parameter

	// specifies the mapping between the 'text' and 'label' fields.



	var records = dataAdapter.getRecordsHierarchy('id', 'parentId',

			'items', [



			{

				name : 'title',

				map : 'label'

			},



			{

				name : 'icon',

				map : 'icon'

			},



			{

				name : 'expanded',

				map : 'expanded'

			}



			]);



	$('#jqx_course_tree').jqxTree({

		source : records,

		width : '320px',
		

	});



	// Bind Select Events



/* 	$('#jqx_course_tree').bind(

			'select',

			function(event) {



				var args = event.args;



				var item = $('#jqx_course_tree').jqxTree('getItem',

						args.element);



				var node_id = item.id;
				
				node_type = node_id.split('_')[0];
				
				if(node_type == "LCONTENT"){
					content_id = node_id.split('_')[3];
					component_id = node_id.split('_')[2];
					content_type_id = node_id.split('_')[1];
					
					if(content_type_id == 1){//video -- 1
						
						course_id = $('#courseId').val();
						$('#ContentPanel').empty();
						$('#ContentPanel').append(
							'<iframe src="/ziksana-web/subscription/enrichplayer/'
									+ course_id
									+ '/'
									+ component_id
									+ '/'
									+ content_id
									+ '" style="width:705px; height:600px;" scrolling="no"></iframe>');						

						
					} else if(content_type_id == 11){//Enhanced video -- 11
						
						course_id = $('#courseId').val();
						$('#ContentPanel').empty();
						$('#ContentPanel').append(
							'<iframe src="/ziksana-web/subscription/ev_enrichplayer/'
									+ course_id
									+ '/'
									+ component_id
									+ '/'
									+ content_id
									+ '" style="width:800px; height:700px;" scrolling="no"></iframe>');		
						
					}else {
						$('#ContentPanel').empty();
						
					}
					
					
				}

				//selected_item = $('#jqxTree').jqxTree('selectedItem');





			}); */


		//Context Menu
			var contextMenu = $("#rc_jqxMenu").jqxMenu({ width: '120px', height: '28px', autoOpenPopup: false, mode: 'popup' });
            var clickedItem = null;
            
            // open the context menu when the user presses the mouse right button.
            $("#jqx_course_tree li div.jqx-tree-item").live('mousedown', function (event) {
				console.log('mouse down triggered.');
            	var target = $(event.target).parents('li:first')[0];
                console.log($(event.target));
                console.log(target);
            
                var rightClick = isRightClick(event);
                //if (rightClick && target != null) {
                if (rightClick) {
                    $("#jqx_course_tree").jqxTree('selectItem', target);
                    var scrollTop = $(window).scrollTop();
                    var scrollLeft = $(window).scrollLeft();
                    console.log('target is');
                    
                    var content_type = $(target).attr('id').split('_')[1];
                    console.log('content type is: '+ content_type);
                    if(content_type != '1' && content_type != '11'){ return false; } 
                    contextMenu.jqxMenu('open', parseInt(event.clientX) + 5 + scrollLeft, parseInt(event.clientY) + 5 + scrollTop);
                    return false;
                }
                
                
            });
            $("#rc_jqxMenu").bind('itemclick', function (event) {
                var item = $(event.args).text();
                console.log(item);
				var args = event.args;
                switch (item) {
                    case "Enrich Content":
                        var selectedItem = $('#jqx_course_tree').jqxTree('selectedItem');
                        if (selectedItem != null) {
                            //$('#jqx_course_tree').jqxTree('addTo', { label: 'Item' }, selectedItem.element);

// begin enhance menu logic

						console.log("id is: "+selectedItem.id);
				var item = $('#jqx_course_tree').jqxTree('getItem',

						args.element);



				var node_id = selectedItem.id;
				
				node_type = node_id.split('_')[0];
				
				if(node_type == "LCONTENT"){
					content_id = node_id.split('_')[3];
					component_id = node_id.split('_')[2];
					content_type_id = node_id.split('_')[1];
					
					if(content_type_id == 1){//video -- 1
						
						course_id = $('#courseId').val();
						$('#ContentPanel').empty();
						$('#ContentPanel').append(
							'<iframe src="/ziksana-web/subscription/enrichplayer/'
									+ course_id
									+ '/'
									+ component_id
									+ '/'
									+ content_id
									+ '" style="width:705px; height:600px;" scrolling="no"></iframe>');						

						
					} else if(content_type_id == 11){//Enhanced video -- 11
						
						course_id = $('#courseId').val();
						$('#ContentPanel').empty();
						$('#ContentPanel').append(
							'<iframe src="/ziksana-web/subscription/ev_enrichplayer/'
									+ course_id
									+ '/'
									+ component_id
									+ '/'
									+ content_id
									+ '" style="width:800px; height:700px;" scrolling="no"></iframe>');		
						
					}else {
						$('#ContentPanel').empty();
						
					}

				}
// end enhance menu logic



                        }
                        break;
                    // case "Remove Item":
                    //     var selectedItem = $('#jqx_course_tree').jqxTree('selectedItem');
                    //     if (selectedItem != null) {
                    //         $('#jqx_course_tree').jqxTree('removeItem', selectedItem.element);
                    //     }
                    //     break;
                }
            });
            // disable the default browser's context menu.
            $(document).bind('contextmenu', function (e) {
                if ($(e.target).parents('.jqx-tree').length > 0) {
                    return false;
                }
                return true;
            });
            function isRightClick(event) {
                var rightclick;
                if (!event) var event = window.event;
                if (event.which) rightclick = (event.which == 3);
                else if (event.button) rightclick = (event.button == 2);
                return rightclick;
            }


}
//$(function(){
	load_tree();
	//setTimeout('load_tree();',9000);
	
	
//}); //End of doc ready
</script>

</body>
</html>
