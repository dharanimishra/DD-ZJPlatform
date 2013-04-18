
<div class="page" id="page-index">
    <div class="page-header">
        <div class="page-header-content">
            <h1>Home</h1>        
        </div>
    </div>
    <div class="page-region">
        <div class="page-region-content">
            <div class="grid">
                <div class="row">
                    <div class="span7">
                        <div class="tile double bg-color-blueDark">
                            <div class="tile-content">
                                <img src="/ziksana-web/${member.picturePath}" class="place-right">
                                <h2>${member.firstName} ${member.lastName}</h2>
                                <h5>${member.designation}</h5>
                                <div class="static-rating small">
                                    <div style="width: 100%" class="rating-value"></div>
                                </div>
                            </div>
                            <div class="brand">
                                <span class="name">Profile</span>
                            </div>
                        </div>

                        <div class="tile bg-color-orangeDark icon">
                            <b class="check"></b>
                            <div class="tile-content">
                                <img src="" alt="">
                            </div>
                            <div class="brand">
                                <div class="badge">4</div>
                                <span class="name">Courses</span>
                            </div>
                        </div>
                        
                        <div class="tile icon bg-color-green">
                            <div class="tile-content">
                                <i class="icon-book" style="font-size: 62px;"></i>
                            </div>
                            <div class="brand">
                                <span class="name">Create Course</span>
                            </div>
                        </div>
                        <div class="tile icon bg-color-yellow    ">
                            <div class="tile-content">
                                <i class="icon-book" style="font-size: 62px;"></i>
                            </div>
                            <div class="brand">
                                <span class="name">Edit Course</span>
                            </div>
                        </div>
                        <div class="tile icon ">
                            <div class="tile-content">
                                <i class="icon-clock" style="font-size: 62px;"></i>
                            </div>
                            <div class="brand">
                                <span class="name">Create Course Term</span>
                            </div>
                        </div>
                        <div class="tile bg-color-green icon">
                            <div class="tile-content">
                                <i class="icon-file" style="font-size: 62px;"></i>
                            </div>
                            <div class="brand">
                                <span class="name">Create Content</span>
                            </div>
                        </div>
                        <div class="tile icon">
                            <div class="tile-content">
                                <i class="icon-file" style="font-size: 62px;"></i>
                            </div>
                            <div class="brand">
                                <span class="name">Manage Content</span>
                            </div>
                        </div>                        
                        
                        <div class="tile double bg-color-green">
                            <div class="tile-content">
                                <h2>Announcement</h2>
                                <h5>New Privacy Policy</h5>
                                <p>
                                    We would like to inform you that the privacy policy document has been updated and you are requested to ...
                                </p>
                            </div>
                            <div class="brand">
                                <div class="badge">12</div>
                                <span class="name"><i class="icon-mail"></i></span>
                            </div>
                        </div>                        
                        <div class="tile bg-color-orange icon">
                            <div class="tile-content">
                                <i class="icon-stats-up" style="font-size: 62px;"></i>
                            </div>
                            <div class="brand">
                                <span class="name">Analytics</span>
                            </div>
                        </div>
                    </div>
                    <div class="span5">
                        <div class="page-control" data-role="page-control">
                            <!-- Responsive controls -->
                            <span class="menu-pull"></span> 
                            <div class="menu-pull-bar"></div>
                            <!-- Tabs -->
                            <ul>
                                <li class="active"><a href="#frame_alerts"><i class="icon-bell"></i> Alerts</a></li>
                                <li><a href="#frame_todos"><i class="icon-checkbox"></i> To Do</a></li>
                                <li><a href="#frame_events"><i class="icon-calendar"></i> Events</a></li>
                            </ul>
                            <!-- Tabs content -->
                            <div class="frames">
                                <div class="frame active" id="frame_alerts">  </div>
                                <div class="frame" id="frame_todos">  <? include("frame_todos.php")?> </div>
                                <div class="frame" id="frame_events">
                                    <div class="calnedar" data-role="calendar"></div>
                                </div>
                            </div>
                        </div>                    
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
$(function(){
	$.ajax({
		  	type: 'GET',
			url: '/ziksana-web/zalert/getalerts',
			dataType: 'xml',
		success: function( data ) {
			var output="";
			$(data).find("alertitem").each(function(index){
				
				output+="<div class='alertclass'><div><img title='' src='/ziksana-web/resources/images/icons/urgent.png'  alt='INFO' /><div class='alertinfo-category' >"+$(this).find("category").text()+"</div><div class='alertinfo-description' >"+$(this).find("description").text()+"</div></div></div>";
				
			});
			$('#frame_alerts').html( output);
		}
	
	});
});
// Todo JQuery Ajax call
$(function(){
	$.ajax({
		  	type: 'GET',
			url: '/ziksana-web/ztodo/showalltodo',
			dataType: 'xml',
		success: function( data ) {
			var output="";
			$(data).find("alertitem").each(function(index){
				
				//output+="<div class='alertclass'><div><img title='' src='/ziksana-web/resources/images/icons/urgent.png'  alt='INFO' /><div class='alertinfo-category' >"+$(this).find("category").text()+"</div><div class='alertinfo-description' >"+$(this).find("description").text()+"</div></div></div>";
				
			});
			$('#frame_alerts').html( output);
		}
	
	});
});

</script>

<style>

</style>
