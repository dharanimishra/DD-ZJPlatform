	<!DOCTYPE HTML>
<html lang="en">
<head>
<title>Course - Model Thinking</title>
<link rel="stylesheet" type="text/css" media="screen"
	href="../resources/content_consumption/css/basic-styles.css" />
<script type="text/javascript" src="../resources/content_consumption/js/date.js"></script>
<script type="text/javascript" src="../resources/content_consumption/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="../resources/jwplayer/swfobject.js"></script>
<!--Body Style sheet-->
<link href="../resources/content_consumption/css/styles.css" rel="stylesheet" type="text/css" />
<link href="../resources/content_consumption/css/type-setting.css" rel="stylesheet" type="text/css" />
<link href="../resources/content_consumption/css/effects.css" rel="stylesheet" type="text/css" />
<link href="../resources/content_consumption/css/nav.css" rel="stylesheet" type="text/css" />
<link type="text/css" rel="stylesheet" href="../resources/content_consumption/css/tipsy.css" />
	<link rel="stylesheet" type="text/css" href="../resources/css/jquery.fancybox.2.1.3.css"/>
	 <script src="../resources/js/jquery.fancybox.pack.2.1.3.js"></script>
<link rel="stylesheet" type="text/css"
	href="../resources/content_consumption/css/custom-theme/jquery-ui-1.8.21.custom.css">
	<link rel="stylesheet" type="text/css"
		href="../resources/content_consumption/css/custom-theme/old-jquery-ui-1.8.21.custom.css">
		<!--End Body Style sheet-->

		<script type="text/javascript" src="../resources/content_consumption/js/top_up.js"></script>


		<style type="text/css">
		
			
	a.vplayer:link { color: gray }
	a.vplayer:visited { color: white;  }
	a.vplayer:hover { color: green }
	a.vplayer { text-decoration:none }
	a.vplayer:active { color: black }
		a.note:before{content: url(icons/note_16.png); vertical-align: middle; margin-right: .25em;}
		.mainbar{
		opacity:0.8;
		position:absolute; 
		width:80px;
		height: 265px;
		left:0px; 
		top:0px; 
		z-index:990;
		background: #000;
		border-radius: 0 0px 5px 0;
		box-shadow: 0 0 8px black;
		padding: .5em;
		text-align:left;
	 }
	 
	 .sidebar{
	 	text-align:left;
		opacity:0.7;
		position:absolute; 
		width:80px;
		left:0px; 
		top:0px; 
		z-index:990;
		background: #000;
		border-radius: 0 0px 0px 5px;
		box-shadow: 0 0 8px black;
		padding: .2em;
	 }
	 
	.iconbar{
	opacity:0.9;
		position:absolute; 
		left:300px; 
		top:0px;
		height:40px;
		width: 40px
		z-index:990;
		background: #000;
		border-radius: 0px 0px 0px 0px;
		box-shadow: 0 0 4px black;
	 }

	 
	 .extensionbar{
		opacity:0.6;
		text-align:left;
		position:absolute; 
		left:91px; 
		top:2px; 
		width: 240px; 
		height: 272px;
		z-index:990;
		background: #000;
		border-radius: 0 5px 5px 0;
	 }
	.chatbox_title {
	  padding: 0.1em;
	  padding-bottom:0px;
	  padding-left:0.5em;
	  margin-left:-0.2em;
	  padding-top:0.5em;
	  width: 243px;
	  z-index: 990;
	  background: #555;
	  text-align:left;
	}
	.chatbox_options {
	  opacity: 0.5;
	  text-align:left;
	  padding: 0.1em;
	  padding-top:0.5em;
	  width: 243px;
	  z-index: 990;
	  border-bottom:1px solid gray;
	}
	
		
	.chatbox_title{ font-size: 18px; color: white; border-bottom: 4px solid silver; display: inline-block; background: silver;}
	.chatbox_user_video { color: white; padding: .25em; border-bottom: 1px solid #222; text-align:left; }
#tabs_container {
	display: table;
	font-family: verdana, arial, sans-serif;
	font-size: 12px;
}

#tabs_container ul {
	display: table-cell;
	margin: 0;
}

#tabs-titles {
	padding: 0;
}

#tabs-titles li {
	padding: .5em;
	cursor: pointer;
	background: #555;
	color: white;
	list-style: none;
}

#tabs-titles li.current {
	font-weight: bolder;
	background: #000000;
	border-radius: 3px 0 0 3px;
	color: #222;
}

#tabs-titles img {
	max-height: 50px;
}

#tabs-contents {
	background: #F2F2F2;
	padding: 0;
	vertical-align: top;
	max-width: 250px;
	border-radius: 0 3px 3px 3px;
}

#tabs-contents div.content {
	min-width: 200px;
	padding: .5em;
}

#tabs-contents div.content a {
	display: block;
	padding: .25em;
	text-decoration: none;
}


a[data-iconprefix="note"] {
    background: url("../resources/content_consumption/icons/note_16.png") no-repeat scroll left center transparent;
    padding-left: 20px !important;
    vertical-align: middle;
}
a[data-iconprefix="question"] {
    background: url("../resources/content_consumption/icons/question_16.png") no-repeat scroll left center transparent;
    padding-left: 20px !important;
    vertical-align: middle;
}

a[data-iconprefix="star"] {
    background: url("../resources/content_consumption/icons/star_16.png") no-repeat scroll left center transparent;
    padding-left: 20px !important;
    vertical-align: middle;
}


a[data-iconprefix="link"] {
    background: url("../resources/content_consumption/icons/link_16.png") no-repeat scroll left center transparent;
    padding-left: 20px !important;
    vertical-align: middle;
}


a[data-iconprefix="pdf"] {
    background: url("../resources/content_consumption/icons/pdf_16.png") no-repeat scroll left center transparent;
    padding-left: 20px !important;
    vertical-align: middle;
}


a[data-iconprefix="word"] {
    background: url("../resources/content_consumption/icons/word_16.png") no-repeat scroll left center transparent;
    padding-left: 20px !important;
    vertical-align: middle;
}

a[data-iconprefix="powerpoint"] {
    background: url("../resources/content_consumption/icons/powerpoint_16.png") no-repeat scroll left center transparent;
    padding-left: 20px !important;
    vertical-align: middle;
}

#tabs-contents li {
	display: none;
	list-style: none;
}

#tabs-contents li:first-child {
	display: block;
}



.chatbox_user {
  border-radius: 5px 5px 5px 5px;
  box-shadow: 0 0 22px black inset;
  color: white;
  margin-bottom: 0.25em;
  padding: 0.5em;
  text-align: left;
} 
.chatbox_user:hover {
  box-shadow: 0 0 22px #2277BB inset;
}
.chatbox_user img {vertical-align: middle; margin-right: .5em; border-radius: 3px; }
</style>
		<script type="text/javascript">
	    var FULSCREENMODE = false;
		var hotspotX = [];
		hotspotX[0]=150;
		hotspotX[1]=530;
		hotspotX[2]=30;

		var hotspotY=[];
		hotspotY[0]=400;
		hotspotY[1]=300;
		hotspotY[2]=480;

		var hotspotTiming=[];
		hotspotTiming[0]=50;
		hotspotTiming[1]=50;
		hotspotTiming[2]=93;

		var hotspotDuration=[];
		hotspotDuration[0]=40;
		hotspotDuration[1]=40;
		hotspotDuration[2]=40;
		var notesAndBookmarkData ='';
		var questionData = '<span style="margin-left:10px"> No Questions to be displayed </span>';
		var hotspotDone =[];
		hotspotDone[0] = false;
		hotspotDone[1] = false;
		hotspotDone[2] = false;

		hotspotDuration[4]=3;
		var hotspotText=[];
		hotspotText[0]='This is <a class="vplayer" onclick="if(isPlayerPlaying) jwplayer().pause();" style="margin-left:5px; font-size: 15px;" target="_blank" href="http://en.wikipedia.org/wiki/Banana">Banana</a>';;
		hotspotText[1]='This is <a class="vplayer" onclick="if(isPlayerPlaying) jwplayer().pause();" style="margin-left:5px; font-size: 15px;" target="_blank" href="http://en.wikipedia.org/wiki/Coconut">Coconut</a>';
		hotspotText[2]='This is <a class="vplayer" onclick="if(isPlayerPlaying) jwplayer().pause();" style="margin-left:5px; font-size: 15px;" target="_blank" href="http://en.wikipedia.org/wiki/Apple">Apple</a>';;
	
		
		var isPlayerPlaying = false;
		var hotspotImplrunning = false;
		
	
		
		var displayButtons = function() {
			 console.log("Entered display");
			  document.getElementById("bookmark_button_smallscreen").style.visibility="visible";       
		}
		
		var hideButtons = function() {
			 console.log("Entered Hide mode");
			  document.getElementById("bookmark_button_smallscreen").style.visibility="hidden";       
		}
		
		
		var showLightBox = function(arrayInput)
		{
			
		}
		var sliderOffs = [];
		var sliderOffsFull = [];
		var setBubbles = function() {
		var width = document.getElementById('videoSection_jwplayer_controlbar_timeSliderRail').offsetWidth;
		var docele = document.getElementById("videoSection_jwplayer_controlbar_timeSliderRail");
		//docele.onclick = function() { return false;};
		
		docele.innerHTML='<img id ="img1" src="../resources/content_consumption/icons/bubbuuu.png"  style=" opacity:0.8; margin-left: 20%; z-index: 999;  margin-top: 2px; width: 9px; height: 20px; "/> \
		<img src="../resources/content_consumption/icons/bubbuuu.png" id ="img2"  title="SAMPLE Aggregation Doc" style=" opacity:0.8; margin-left: 20%; z-index: 999; margin-top: 2px; width: 9px; height: 20px;"/> \
		<img src="../resources/content_consumption/icons/bubbuuu.png" id ="img3"   style=" opacity:0.8; margin-left: 40%; z-index: 999; margin-top: 2px; width: 9px; height: 20px;"/>';
		
		docele = document.getElementById("videoSection_jwplayer_controlbar_fullscreenButton");
		//docele.onclick = goFullscreen;
		docele = document.getElementById("videoSection_jwplayer_controlbar_centerGroup");
		docele.onclick = displayTopup;
		docele = document.getElementById("videoSection_jwplayer_controlbar_timeSlider");
		docele.onclick = function() {};
		docele = document.getElementById("videoSection_jwplayer_controlbar_timeSliderBuffer");
		docele.onclick = function() {};
		docele = document.getElementById("videoSection_jwplayer_controlbar_timeSliderBuffer");
		docele.onclick = function() {};
		
		docele = document.getElementById("videoSection_jwplayer_dock");
		//docele.onclick = function() { return false;};

		}
		var togglePlay = function (event, isplaying)
		{
		isPlayerPlaying= isplaying;
		if(isPlayerPlaying==true)
		{
		if(hotspotImplrunning==false) if(FULSCREENMODE) hotspotImpl(); else hotspotImplSmallScreen();
		}
			
		}
		var kickOffTimer = function(){};
		var kickTimer = function()
		{

			var elapsed = jwplayer("videoSection").getPosition();
					console.log("Kicking on Timer"+ hotspotTiming[0]);
			setTimeout(function(){showHotspot()}, hotspotTiming[0]*1000);
		}
		
		var showHotspot = function()
		{
			var elapsed = jwplayer("videoSection").getPosition();
			if(	elapsed > hotspotTiming[0]-0.5 && elapsed < hotspotTiming[0]+0.5 && isPlayerPlaying)
			{
				console.log("Triggered the Hotspot Fucntion");
				docele = document.getElementById("videoSection_jwplayer_dock");
				docele.innerHTML=docele.innerHTML+' \
				<img id ="hotspot" src="../resources/content_consumption/icons/burn-in.gif"  onmouseover=showHotspotBox() style=" opacity:0.7; position:absolute; left:'+hotspotX[0]+'px; top:'+hotspotY[0]+'px; width: 10px; height: 10px; "/>';
				setTimeout(function(){ deleteHotspots()}, hotspotDuration[0]*1000);
			}

		}
		var hotspotImpl =  function()
		{
			
			var elapsed = jwplayer("videoSection").getPosition();
			var i=0;

			for(i=0; i<hotspotTiming.length; i++)
			{
				if(!FULSCREENMODE)
				{
					for(i=0; i<hotspotTiming.length; i++)
					{
						docele = document.getElementById("hotspot"+i);
						if(docele) docele.parentNode.removeChild(docele);
						hotspotDone[i] = false;
					}
					hotspotImplSmallScreen();
					return;
				}
				if(	elapsed > hotspotTiming[i]&& elapsed < hotspotTiming[i]+hotspotDuration[i] && isPlayerPlaying && FULSCREENMODE && hotspotDone[i]==false)
				{
					console.log("Triggered the Hotspot Fucntion");
					docele = document.getElementById("videoSection_jwplayer_dock");
					docele.innerHTML=docele.innerHTML+' \
					<img id ="hotspot'+i+'" src="../resources/content_consumption/icons/burn-in.gif"  onmouseover=showHotspotBox('+i+') style=" opacity:0.5; position:absolute; left:'+hotspotX[i]+'px; top:'+hotspotY[i]+'px; width: 25px; height: 25px; "/>';
					hotspotDone[i]=true;
				}
				if(	(elapsed < hotspotTiming[i] || elapsed > hotspotTiming[i]+hotspotDuration[i]) && isPlayerPlaying  )
				{
					var id = 'hotspot'+i+'';
					element = document.getElementById(id);
					if(element ) 
					{
						console.log("Removed HOTSPOT"+i);
						element.parentNode.removeChild(element);
						setTimeout(function() {hotspotImpl()}, 1000);
						hotspotDone[i]=false;
						return;
					}
				}
			}
			setTimeout(function() {hotspotImpl()}, 1000);
		}
		
		var hotspotImplSmallScreen =  function()
		{


			var elapsed = jwplayer("videoSection").getPosition();
			var i=0;
			for(i=0; i<hotspotTiming.length; i++)
			{
				if(FULSCREENMODE)
				{
					for(i=0; i<hotspotTiming.length; i++)
					{
						docele = document.getElementById("hotspot"+i);
						if(docele) docele.parentNode.removeChild(docele);
						hotspotDone[i] = false;
					}
					hotspotImpl();
				return;
				}
				if(	elapsed > hotspotTiming[i]&& elapsed < hotspotTiming[i]+hotspotDuration[i] && isPlayerPlaying &&  hotspotDone[i]==false)
				{
					console.log("Triggered the Hotspot Fucntion");
					docele = document.getElementById("videoSection_jwplayer_dock");
					docele.innerHTML=docele.innerHTML+' \
					<img id ="hotspot'+i+'" src="../resources/content_consumption/icons/burn-in.gif"  onmouseover=showHotspotBox('+i+') style=" opacity:0.5; position:absolute; left:'+(((hotspotX[i]/screen.width)*480)+45)+'px; top:'+(((hotspotY[i]/screen.height)*270)+50)+'px; width: 15px; height: 15px; "/>';
					hotspotDone[i]=true;
				}
				if(	(elapsed < hotspotTiming[i] || elapsed > hotspotTiming[i]+hotspotDuration[i]) && isPlayerPlaying  )
				{
					var id = 'hotspot'+i+'';
					element = document.getElementById(id);
					if(element ) 
					{
						console.log("Removed HOTSPOT"+i);
						element.parentNode.removeChild(element);
						setTimeout(function() {hotspotImpl()}, 1000);
						hotspotDone[i]=false;
						return;
					}
				}
			}
			setTimeout(function() {hotspotImplSmallScreen()}, 1000);
		}

		var showHotspotBox = function(i)
		{
		//if(isPlayerPlaying) jwplayer().pause();
		docele = document.getElementById("hotspotBox");
		if(docele)docele.parentNode.removeChild(docele);
		docele = document.getElementById("imgclose");
		if(docele)docele.parentNode.removeChild(docele);
			docele = document.getElementById("videoSection_jwplayer_dock");
			//docele.onclick = function() { return false;};
			if(FULSCREENMODE)
			{
				height=hotspotY[i];
				width=hotspotX[i];
			}
			else 
			{
				height = ((hotspotY[i]/screen.height)*270);
				width =  ((hotspotX[i]/screen.width)*480);
			}
			docele.innerHTML=docele.innerHTML+' \
			<div id ="hotspotBox" style=" opacity:0.7; position:absolute;padding-top:10px; left:'+width+'px; top:'+height+'px; width: 240px; height: 30px; z-index:990; color: #fff; background:#000; border-radius: 5px 5px 5px 5px;"> \
			'+hotspotText[i]+'\
				</div> \
			<div id ="imgclose" onclick=closeBox(this) style=" opacity:0.7; position:absolute; left:'+(width+215)+'px; top:'+(height+12)+'px; width: 15px; height: 15px; z-index:999; background-repeat:no-repeat; background-size:100%; background-image: url(icons/close.png)"> \
				</div>	';
		}
		var username ="Friend";
		var startchat = function (name)
		{	
			docele = document.getElementById("ChatBox");
			docele.innerHTML=' \
			<div class="chatbox_title" ><b style="color:black; margin-left:15px; font-weight:bolder;">'+name+'<img width="20px" height="20px" src="../resources/content_consumption/icons/'+name+'.png" style="vertical-align:middle; float:left;"><img src="../resources/content_consumption/icons/close.png" onmouseover="this.src=\'icons/close_hover.png\'" onmouseout="this.src=\'icons/close.png\'" width="15px" height="15px" onclick=emptyContent("ChatBox"); style="float:right; margin-right:20px"/></b></div> \
			<div class="chatbox_options"><img src="../resources/content_consumption/icons/voicechat.png" width="15px" height="15px" title="Initiate Voice Chat" style=" margin-left:5px; padding-right:5px; border-right:1px solid gray;"/> \
			<img src="../resources/content_consumption/icons/vidoechat.png" width="15px" height="15px" title="Initiate Video Chat" style="margin-left:5px; padding-right:5px; border-right:1px solid gray;"/>\
			<img src="../resources/content_consumption/icons/addpeople.png" width="20px" height="15px" title="Add buddies to chat" style="margin-left:5px; padding-right:5px; border-right:1px solid gray;"/></div> \
			<div id="ChatHistory" style="height:75px; margin-left:10px; text-align:left; color:gray; overflow-x: hidden; overflow-y: scroll;"> </div> \
			<br style="color:gray; border-top: 1px solid silver;">\
			<input type="text" onkeydown=avoidspace("addchat",event) id="inputchat" style="width:175px; margin-bottom:10px; margin-left:10px"> <span onclick=sendchat() style="margin-right:10px; float:right;padding:5px; color:white;"><b>Send</b></span> \
			';
		}
		
		var emptyContent = function(e)
		{
			var elementToEmpty= document.getElementById(e);
			elementToEmpty.innerHTML="";
						if (e=="ChatWindow")
			{
							elementToEmpty= document.getElementById("ChatBox");
				if(elementToEmpty) elementToEmpty.innerHTML="";
			}
			if (e=="ItemDetails")
			{

				elementToEmpty= document.getElementById("send_question2");
				if(elementToEmpty) elementToEmpty.innerHTML="";
				
			}
		}
		var sendchat = function()
		{
			element = document.getElementById('ChatHistory');
			element.innerHTML=element.innerHTML+"<br>"+'<b style="font-weight:bolder;">Me: </b>'+document.getElementById('inputchat').value;
			document.getElementById('inputchat').value = "";
		}
		var displayChat = function()
		{	

				docele = document.getElementById("ChatWindow");
			docele.innerHTML=' \
			<b style="color:white;font-weight:bolder;"><center>Online Classmates<img src="../resources/content_consumption/icons/close.png" onmouseover="this.src=\'icons/close_hover.png\'" onmouseout="this.src=\'icons/close.png\'" width="15px" height="15px" onclick=emptyContent("ChatWindow"); style="float:right; margin-right:20px"/></center></b> \
			<div class="chatbox_user_video" style="margin-top:20px;"> \
			<img src="../resources/content_consumption/icons/Aaron.png" style=" vertical-align:middle;" align="middle" onclick=startchat("Aaron") width="35px" height="40px" /> \
			 Aaron \
			</div>	\
			<div class="chatbox_user_video "> \
			<img src="../resources/content_consumption/icons/Stella.png" style="vertical-align:middle;" align="middle" onclick=startchat("Stella") width="35px" height="40px" /> \
			Stella\
			</div> \
			<div class="chatbox_user_video"> \
			<img src="../resources/content_consumption/icons/Nisha.png" style="vertical-align:middle;" align="middle" onclick=startchat("Nisha") width="35px" height="40px" /> \
			Nisha\
			</div> <br><hr>';
		}
		
		var displayPlaylist = function()
		{	
			emptyContent("UserInput");
			emptyContent("ItemDetails");
			docele = document.getElementById("ItemDetails");
			docele.innerHTML=' \
			<b style="color:white; font-weight:bolder;"><center>Table of Contents<img src="../resources/content_consumption/icons/close.png" onmouseover="this.src=\'icons/close_hover.png\'" onmouseout="this.src=\'icons/close.png\'" width="15px" height="15px" onclick=emptyContent("ItemDetails"); style="float:right; margin-right:20px"/></center></b>\
			<div class="chatbox_user_video" style="margin-top:20px;"  onclick=jwplayer().seek(75).play(true);> \
			Preference Reordering \
			</div>	\
			<div class="chatbox_user_video" onclick=jwplayer().seek(248).play(true);>Transitive Preferences \
			</div> \
			<div class="chatbox_user_video" onclick=jwplayer().seek(310).play(true);>Collective Preferences \
			</div> \
			</div><br><hr>';
		}
		
			var displayBooklist = function()
		{	
				emptyContent("UserInput");
				emptyContent("ItemDetails");
			docele = document.getElementById("ItemDetails");
			docele.innerHTML=' \
			<b style="color:white;font-weight:bolder;"><center>Notes<img src="../resources/content_consumption/icons/close.png" onmouseover="this.src=\'icons/close_hover.png\'" onmouseout="this.src=\'icons/close.png\'" width="15px" height="15px" onclick=emptyContent("ItemDetails"); style="float:right; margin-right:20px"/></center></b>\
			<br>\
			<div id="note1FS" class="chatbox_user_video" style="margin-left:10px;" onclick="jwplayer().seek(75).play(true);" Title="Must read before exam - Preference Ordering" > \
			<img src="../resources/content_consumption/icons/note_16.png"  width="10px" height="10px" /> \
			Important\
			</div>\
			'+notesAndBookmarkData+' \
			<br> <hr/>';
		}
		
					var displayQlist = function()
		{	
				emptyContent("UserInput");
				emptyContent("ItemDetails");
			docele = document.getElementById("ItemDetails");
			docele.innerHTML=' \
			<b style="color:white;font-weight:bolder;"><center>Questions<img src="../resources/content_consumption/icons/close.png" onmouseover="this.src=\'icons/close_hover.png\'" onmouseout="this.src=\'icons/close.png\'" width="15px" height="15px" onclick=emptyContent("ItemDetails"); style="float:right; margin-right:20px"/></center></b>\
			<br>\
			'+questionData+' \
			<br> <hr/>';
		}
		
		var AddNote = function()
		{
			if(isPlayerPlaying) jwplayer().pause();
			docele = document.getElementById("AddNoteBox");
			if(docele) docele.parentNode.removeChild(docele);
			docele = document.getElementById("AddBookmarkBox");
			if(docele) docele.parentNode.removeChild(docele);
		//docele.onclick = function() { return false;};
		/*docele.innerHTML=' \
		<b style="color:white;font-weight:bolder;"><center>Note Details<img src="../resources/content_consumption/icons/close.png" onmouseover="this.src=\'icons/close_hover.png\'" onmouseout="this.src=\'icons/close.png\'" width="15px" height="15px" onclick=emptyContent("UserInput"); style="float:right; margin-right:20px"/></center></b> \
		<form style=" color:gray; margin-left:10px; margin-top:20px;">Title :<input id="noteTitle" type="text" onkeydown=avoidspace("addnote",event) name="firstname" style="margin-left:10px; width:155px;"><br>Desc :<textarea type="text" id="noteDesc" name="lastname" style="margin: 2px 0px 2px 5px; width: 155px; height: 30px; "></textarea> 	</form> \
			<br/><center><span id="submit2" style="color:white;  padding-top:20px; padding:0.5em; border:2px solid white " onclick="AddNoteToDataBase()"> <b>Submit</b></span></center>  <br><hr>';
			
			*/
		docele = document.getElementById("videoSection_jwplayer_dock");
			//docele.onclick = function() { return false;};
			docele.innerHTML=docele.innerHTML+' \
			<div id ="AddNoteBox" style=" opacity:0.7; text-align:left; position:absolute;padding-top:20px; padding-left:10px;  left:500px; top:300px; width: 340px; height: 150px; z-index:990; color: #fff; background:#555; border-radius: 5px 5px 5px 5px;"> \
			Title: 	<br/><input  id="noteTitle" style="margin-left:0px; width:320px;" onkeydown=avoidspace("addnote",event) name="firstname" type="text" placeholder="Note Title"/><br/><br/> \
								Description: <br/><textarea style="width:320px; margin-left:0px;" id="noteDesc" name="lastname" placeholder="Note description" value=""></textarea>	 \
								<center> <input id="submit2" type="button" style="align:center;" onclick="AddNoteToDataBase()" value="Add Note"/> </center>\
				</div> \
			<div id ="imgclose2" onclick=closeBox(this) style=" opacity:0.7; position:absolute; left:'+(500+325)+'px; top:'+(300+7)+'px; width: 15px; height: 15px; z-index:999; background-repeat:no-repeat; background-size:100%; background-image: url(icons/close.png)"> \
				</div>	';
		}
		var AddNoteToDataBase = function()
		{
			note_title = document.getElementById('noteTitle').value;
			note_description = document.getElementById('noteDesc').value;
			note_position = Math.floor(jwplayer().getPosition());
			
			note_anchor_string = '<a title="'+note_description+'" onclick="jwplayer().seek('+note_position+').play(true);" data-iconprefix="note">'+note_title+'</a>';
			note_anchor_string2='<div class="chatbox_user_video" style="margin-left:10px;" onclick="jwplayer().seek('+note_position+').play(true);" Title="'+note_description+'" > \
			<img src="../resources/content_consumption/icons/note_16.png"  width="10px" height="10px" /> \
			'+note_title+'\
			</div>';
			notesAndBookmarkData+=note_anchor_string2;
			$('#notes_and_bookmarks_container').append(note_anchor_string);
			emptyContent("UserInput");
			var elem = document.getElementById("note1FS");
			if(elem)
			{
				emptyContent("ItemDetails");
				displayBooklist();
			}
									docele = document.getElementById("AddNoteBox");
			if(docele) docele.parentNode.removeChild(docele);
			docele = document.getElementById("AddBookmarkBox");
			if(docele) docele.parentNode.removeChild(docele);
			docele = document.getElementById("imgclose2");
			if(docele) docele.parentNode.removeChild(docele);
			jwplayer().play();
			
			
		}
			var AddBookmark = function()
		{
						docele = document.getElementById("AddNoteBox");
			if(docele) docele.parentNode.removeChild(docele);
			docele = document.getElementById("AddBookmarkBox");
			if(docele) docele.parentNode.removeChild(docele);
			if(isPlayerPlaying) jwplayer().pause();
		/*	docele = document.getElementById("UserInput");
		//docele.onclick = function() { return false;};
		
		docele.innerHTML=' \
		<b style="color:white;font-weight:bolder;"><center>Bookmark Info<img src="../resources/content_consumption/icons/close.png" onmouseover="this.src=\'icons/close_hover.png\'" onmouseout="this.src=\'icons/close.png\'" width="15px" height="15px" onclick=emptyContent("UserInput"); style="float:right; margin-right:20px"/></center></b> \
		<form style=" color:#ffffff; margin-left:10px; margin-top:20px;">Title :<input id="bookmarkTitle" onkeydown=avoidspace("addbookmark",event) type="text" name="firstname" style="margin-left:10px; width:155px;"><br>	</form> \
			<br/><center><span id="submit2" onclick=AddBookmarkToDataBase() style="color:white;  padding-top:20px; padding:0.5em; border:2px solid white "> <b>Submit</b></span></center><br><hr>';
			*/
			docele = document.getElementById("videoSection_jwplayer_dock");
			//docele.onclick = function() { return false;};
			docele.innerHTML=docele.innerHTML+' \
			<div id ="AddNoteBox" style=" opacity:0.7; text-align:left; position:absolute;padding-top:20px; padding-left:10px;  left:500px; top:300px; width: 340px; height: 100px; z-index:990; color: #fff; background:#555; border-radius: 5px 5px 5px 5px;"> \
			Enter Your Question: 	<br/><input  id="bookmarkTitle" style="margin-left:0px; width:320px;" onkeydown=avoidspace("addnote",event) name="firstname" type="text" placeholder="Question?"/><br/><br/> \
								 \
								<center> <input type="button" id="submit2" onclick=AddBookmarkToDataBase() style="align:center;"  value="Add Question"/> </center>\
				</div> \
			<div id ="imgclose2" onclick=closeBox(this) style=" opacity:0.7; position:absolute; left:'+(500+325)+'px; top:'+(300+7)+'px; width: 15px; height: 15px; z-index:999; background-repeat:no-repeat; background-size:100%; background-image: url(icons/close.png)"> \
				</div>	';
		}
		
			
			var avoidspace = function(strin, e)
			{
				 if (e.keyCode == 32) { e.stopPropagation(); return '&nbsp;'; }
			        if (e.keyCode == 13) { //when enter key is clicked.
			        	if(strin=="addbookmark")
			        		{
			        		AddBookmarkToDataBase();
			        		}
			        	else if(strin=="addnote")
			        		{
			        		AddNoteToDataBase();
			        		}
			        	else if(strin=="addchat")
			        		{
			        			sendchat();
			        		}
			        }
				
			}
			
			var sendQuestionFS  = function() {
			
			
			docele = document.getElementById("UserInput");
		//docele.onclick = function() { return false;};
		
		docele.innerHTML='<div id="send_question2" >'+$('#send_question').html()+'</div>';

					}
		var AddBookmarkToDataBase= function()
		{
			/*bookmark_title =document.getElementById('bookmarkTitle').value;
			bookmark_position = Math.floor(jwplayer().getPosition());

			
			bookmark_anchor_string = '<a onclick="jwplayer().seek('+bookmark_position+').play(true);" data-iconprefix="star">'+bookmark_title+'</a>';
			bookmark_anchor_string2 = '<div class="chatbox_user_video" style="margin-left:10px;" onclick=jwplayer().seek('+bookmark_position+').play(true);> \
			<img src="../resources/content_consumption/icons/starbook.png" width="10px" height="10px" /> \
			 '+bookmark_title+'\
			</div>';
			
			$('#notes_and_bookmarks_container').append(bookmark_anchor_string);
			notesAndBookmarkData+=bookmark_anchor_string2;
			emptyContent("UserInput");
			var elem = document.getElementById("note1FS");
			if(elem)
			{
				emptyContent("ItemDetails");
				displayBooklist();
			}*/
			
					question_title = document.getElementById('bookmarkTitle').value;
		question_position =Math.floor(jwplayer().getPosition());
		//question_timestamp = Date.parse('now').toString('ddd, MMM dd, yyyy h:mm tt');
		// question_timestamp = Date.today().add(question_position).seconds().toString('mm:ss'); //get minutes from sec using datejs
		question_timestamp = (new Date).clearTime().addSeconds(question_position).toString('H:mm:ss');
		
		question_anchor_string ='<div style="width:100%;  border-bottom: 1px solid #333; padding-bottom: .25em;">'; 
		question_anchor_string += '<a onclick="jwplayer().seek('+question_position+').play(true);" style="color:white;" data-iconprefix="question">'+question_title+'</a><br/><span class="qtstamp">'+question_timestamp+'</span>';
		question_anchor_string += ' <span onclick="sendQuestionFS(); $(\'.question_to_be_sent\').html($(this).siblings(\'a\').text()+\'<hr/>\');"  style="cursor: pointer; color: #222; background: gray; border-radius: 20px; padding: 0 .5em;  margin-right:15px; " >send</span></div>';
		
		//save bookmark temporarily
		question_anchor_string2 ='<div style="width:100%;  border-bottom: 1px solid #333;">'; 
		question_anchor_string2 += '<a onclick="jwplayer().seek('+question_position+').play(true);" data-iconprefix="question">'+question_title+'</a><br/><span class="qtstamp">'+question_timestamp+'</span>';
		question_anchor_string2 += ' <span style="margin-right:15px;" class="send_question_trigger">send</span></div>';
		
		$('#questions_container').append(question_anchor_string2);
		if(questionData == '<span style="margin-left:10px"> No Questions to be displayed </span>' )
		questionData = '';
		questionData += question_anchor_string;
		
								docele = document.getElementById("AddNoteBox");
			if(docele) docele.parentNode.removeChild(docele);
			docele = document.getElementById("AddBookmarkBox");
			if(docele) docele.parentNode.removeChild(docele);
			docele = document.getElementById("imgclose2");
			if(docele) docele.parentNode.removeChild(docele);
			jwplayer().play();
			
		}
		var closeBox = function(obj)
		{
					if(!isPlayerPlaying) jwplayer().play();

							var control = document.getElementById("ThumbnailBox");
	                if(control) control.parentNode.removeChild(control);
					control = document.getElementById("hotspotBox");
	                if(control) control.parentNode.removeChild(control);
					control = document.getElementById("AddNoteBox");
	                if(control) control.parentNode.removeChild(control);
					control = document.getElementById("imgclose");
	                if(control) control.parentNode.removeChild(control);
					control = document.getElementById("imgclose2");
	               if(control) control.parentNode.removeChild(control);
		}
		var displayTopup = function(event)
		{
			var pos_x = event.offsetX?(event.offsetX):event.pageX-document.getElementById("videoSection_jwplayer_controlbar_centerGroup").offsetLeft;
			var pos_y = event.offsetY?(event.offsetY):event.pageY-document.getElementById("videoSection_jwplayer_dock").offsetTop;
			var i;
			for(i=1;i<4;i++)
			{

				var docele = document.getElementById("img"+ i);
				if(docele && event.offsetX>=docele.offsetLeft && event.offsetX<=docele.offsetLeft+9)
					{
						
						//if(isPlayerPlaying) jwplayer().pause();
						console.log("CALLED" + pos_x +"POSITION"+ pos_y+ "POSITION OF CLICK"+event.pageX);
						var element=document.getElementById("ThumbnailBox");
						if (element) element.parentNode.removeChild(element);
						element=document.getElementById("imgclose");
						if (element) element.parentNode.removeChild(element);
						element=document.getElementById("videoSection_jwplayer_dock");
						element.innerHTML=element.innerHTML+' \
						<div id ="ThumbnailBox" style=" opacity:0.7; position:absolute;padding-top:10px; left:'+(pos_x-75)+'px; top:'+(event.pageY-200-80)+'px; width: 150px; height: 30px; z-index:990; color: #fff; background:#000; border-radius: 5px 5px 5px 5px;"> \
						<b style="margin-left:20px; margin-top:10px;">Material '+i+'</b>\
							</div> \
						<div id ="imgclose" onclick=closeBox(this) style=" opacity:0.7; position:absolute; left:'+(pos_x+50)+'px; top:'+(event.pageY-200-70)+'px; width: 15px; height: 15px; z-index:999; background-repeat:no-repeat; background-size:100%; background-image: url(icons/close.png)"> \
							</div>	';
					}
				//TopUp.display ('http://google.com', {title:'google search',type:'iframe',width:800,height:400,modal:0});

			}
			//$('#img1').addClass('tu_fl');
		}
		
		var displayExtension = function(link)
		{
			$('#mainBar img.'+link).addClass('hover_state').siblings().removeClass('hover_state');

			if(link=="educator")
			{ 
				docele = document.getElementById("educatorList");
				if(docele) { 
				docele = document.getElementById("extensionBar");
				docele.parentNode.removeChild(docele);
				return;
				}
				else
				{
					element= document.getElementById("extensionBar");
					if(element) 
					{
						element.parentNode.removeChild(element);
					}
				}
				docele = document.getElementById("videoSection_jwplayer_dock");
				docele.innerHTML=docele.innerHTML+' \
				<div id ="extensionBar" class="extensionbar"> \
				<li id="educatorList"> \
						<div class="content" style="color:gray; margin-left:15px; margin-top:10px; margin-right:15px;"> \
							<b  style="color:white;"><center>Educator Suggestions</center></b> \
							<hr/> \
							<a class="vplayer" data-iconprefix="link" onclick="if(isPlayerPlaying) jwplayer().pause();" target="_blank" href="http://citeseerx.ist.psu.edu/viewdoc/summary?doi=10.1.1.151.9419">Aggregating Preferences in Multi-Issue Domains</a><br> \
							<a class="vplayer" data-iconprefix="link" onclick="if(isPlayerPlaying) jwplayer().pause();" target="_blank" href="http://faculty.arts.ubc.ca/pbartha/p321f01/p321ovh2.pdf">Preference Ordering</a> <br> \
							<a class="vplayer note" onclick="if(isPlayerPlaying) jwplayer().pause(); return false;"  href="" title="Make sure you understand this concept before proceeding. Please make use of the references provided or contact me to seek any clarifications.">Critical Concept</a>            \
						</div> \
					</li> \
					\
				</div>';
			}
			if(link=="reference")
			{ 
				docele = document.getElementById("referenceList");
				if(docele) { 
				docele = document.getElementById("extensionBar");
				docele.parentNode.removeChild(docele);
				return;
				}
				else
				{
					element= document.getElementById("extensionBar");
					if(element) 
					{
						element.parentNode.removeChild(element);
					}
				}
				docele = document.getElementById("videoSection_jwplayer_dock");
				docele.innerHTML=docele.innerHTML+' \
				<div id ="extensionBar" class="extensionbar"> \
				<li id="referenceList"> \
						<div class="content" style="color:gray; margin-left:15px; margin-top:10px; margin-right:15px;"> \
							<b style="color:white;"><center>Other References</center></b> \
							<hr/> \
							<a class="vplayer" data-iconprefix="link" onclick="if(isPlayerPlaying) jwplayer().pause();" target="_blank" href="http://en.wikipedia.org/wiki/Order_of_preference">Order of Preferences</a>\
						</div> \
					</li> \
					\
				</div>';
			}
		
			if(link=="books")
			{ 
				docele = document.getElementById("booksList");
				if(docele) { 
				docele = document.getElementById("extensionBar");
				docele.parentNode.removeChild(docele);
				return;
				}
				else
				{
					element= document.getElementById("extensionBar");
					if(element) 
					{
						element.parentNode.removeChild(element);
					}
				}
				docele = document.getElementById("videoSection_jwplayer_dock");
				docele.innerHTML=docele.innerHTML+' \
				<div id ="extensionBar" class="extensionbar"> \
				<li id="booksList"> \
						<div class="content" style="color:gray; margin-left:15px; margin-top:10px; margin-right:15px;"> \
							<b style="color:white;"><center>Books</center></b> \
							<hr/> \
							<a href="http://societysbreakthrough.com/Levels_of_Thinking_.pdf" target="_blank" data-iconprefix="pdf">Levels of Thinking</a> \
						</div> \
					</li> \
					\
				</div>';
			}
			if(link=="notes")
			{ 
				docele = document.getElementById("notesList");
				if(docele) { 
				docele = document.getElementById("extensionBar");
				docele.parentNode.removeChild(docele);
				return;
				}
				else
				{
					element= document.getElementById("extensionBar");
					if(element) 
					{
						element.parentNode.removeChild(element);
					}
				}
				docele = document.getElementById("videoSection_jwplayer_dock");
				docele.innerHTML=docele.innerHTML+' \
				<div id ="extensionBar" class="extensionbar"> \
				<li id="notesList"> \
						<div class="content" style="color:gray; margin-left:15px; margin-top:10px; margin-right:15px;"> \
							<b style="color:white;"><center>Class Notes</center></b> \
							<hr/> \
							<div style="color: white;" title="The Productive Thinking Model (sometimes known as ThinkX) was developed by Tim Hurson, a Canadian author, speaker, and creativity theorist." class="note" onclick="jwplayer().seek(75).play(true);"><img width="22px" height="22px" src="../resources/content_consumption/icons/Aron.png"> <span>Aaron</span><br> The Productive Thinking Model ...</div> \
							</li> \
					\
				</div>';
			}
		}
		
	  function ToggleFullscreen(fullscreen) {
	    var id = 'videoSection';
	    // Get the element that we want to take into fullscreen mode
	    var element = document.getElementById(id);

	  if(fullscreen==true) {
	    FULSCREENMODE = true;
	    // These function will not exist in the browsers that don't support fullscreen mode yet, 
	    // so we'll have to check to see if they're available before calling them.
	    
	    if (element.mozRequestFullScreen) {
	      // This is how to go into fullscren mode in Firefox
	      // Note the "moz" prefix, which is short for Mozilla.
	      element.mozRequestFullScreenWithKeys();
	    } else if (element.webkitRequestFullScreen) {
	      // This is how to go into fullscreen mode in Chrome and Safari
	      // Both of those browsers are based on the Webkit project, hence the same prefix.
	      element.webkitRequestFullScreen(element.ALLOW_KEYBOARD_INPUT);
		  
		  
	   }
	   var width = document.getElementById('videoSection_jwplayer_controlbar_timeSliderRail').offsetWidth;
	    sliderOffsFull[0] = width/5;
	    sliderOffs[1] = 2*(width/5)+9;
		sliderOffs[2] = 4*(width/5)+18;
		var widthspec = $(window).width();
		var heightspec = screen.height;
		/*element = document.getElementById('icon5')
				element.setAttribute("style"," opacity:0.7; position:absolute; left:"+widthspec+"px; top:10px; width: 40px; height: 40px; ");
				element = document.getElementById('icon6')
				element.setAttribute("style"," opacity:0.7; position:absolute; left:"+(widthspec+50)+"px; top:10px; width: 40px; height: 40px; ");
				element = document.getElementById('icon1')
				element.setAttribute("style"," opacity:0.7; position:absolute; left:"+(widthspec+100)+"px; top:10px; width: 40px; height: 40px; ");
				element = document.getElementById('icon3')
				element.setAttribute("style"," opacity:0.7; position:absolute; left:"+(widthspec+150)+"px; top:10px; width: 40px; height: 40px; ");
				element = document.getElementById('icon4')
				element.setAttribute("style"," opacity:0.7; position:absolute; left:"+(widthspec+200)+"px; top:10px; width: 40px; height: 40px; ");*/
				

				docele = document.getElementById("videoSection_jwplayer_dock");
		//docele.onclick = function() { return false;};

		docele.innerHTML=docele.innerHTML+' \
		<div id="sideBar" class="sidebar" style="position:absolute; left:'+(widthspec-245)+'px; width: 252px; overflow: auto;" > \
		<img id ="icon5" src="../resources/content_consumption/icons/bookmarklist.png" title="Notes" onclick=displayBooklist() style=" opacity:1;  margin-top:8px; margin-left:10px; width: 26px; height: 24px; "/> \
		<img id ="icon6" src="../resources/content_consumption/images/logos/TOC.png" title="Table of Contents"  onclick=displayPlaylist() style=" opacity:1;   margin-top:10px; margin-left:10px; width: 24px; height: 24px; "/> \
		<img id ="icon1" src="../resources/content_consumption/icons/add_question.png"  title="Add a Question" onclick=AddBookmark() style=" opacity:1;  margin-top:10px; margin-left:10px; width: 24px; height: 24px; "/> \
		<img src="../resources/content_consumption/icons/g3974.png" id ="icon3"  title="Add a Note" onclick=AddNote()  style=" opacity:1;  margin-top:10px; margin-left:8px;   width: 26px; height: 24px;"/> \
		<img src="../resources/content_consumption/icons/questions.png" id ="utdicon" title="View Questions" onclick=displayQlist() title="University of Texas" style=" opacity:1;  margin-bottom:0px; margin-left:10px;   width: 35px; height: 35px;"/> \
		<img src="../resources/content_consumption/icons/contacts.png" id ="icon4"  title="C\'mon Chat!" onclick=displayChat() style=" opacity:1;  margin-top:10px; margin-left:10px;   width: 24px; height: 24px;"/> \
		<hr style="color:gray;" />\
		<div id="ItemDetails" style="margin-top:20px; text-align:left;" > </div> \
		<div id="UserInput" style="margin-top:20px; text-align:left;" > </div> \
		<div id="ChatWindow" style="margin-top:20px; text-align:left;" > </div> \
		<div id="ChatBox" style="text-align:left;" > </div> \
		</div>';
		
		//DISPLAY MAIN BAR
		docele = document.getElementById("videoSection_jwplayer_dock");
			docele.innerHTML=docele.innerHTML+' \
		<div id ="mainBar" class="mainbar"> \
		<img class="educator" src="../resources/content_consumption/icons/Google.png" title="Educator Suggested References" onclick=displayExtension("educator") width="40px" height="40px" style="margin-left:20px; margin-top:10px"/>\
		<img class="reference" src="../resources/content_consumption/icons/Wiki-Logo.png" title="Other References" onclick=displayExtension("reference") width="40px" height="40px" style="margin-left:20px; margin-top:15px; "/> \
		<img class="books" src="../resources/content_consumption/icons/encarta.png" title="Books" onclick=displayExtension("books") width="40px" height="40px" style="margin-left:20px; margin-top:20px "/> \
		<img class="notes" src="../resources/content_consumption/icons/icc_logo.png" title="Class Notes" onclick=displayExtension("notes") width="40px" height="40px" style="margin-left:20px; margin-top:20px "/> \
		</div>';
		
			element = document.getElementById('hotspotBox')
            if(element) element.parentNode.removeChild(element);
			element = document.getElementById('imgclose')
            if(element) element.parentNode.removeChild(element);
		
		}
		else 
		{
		//TAKEAWAY SIDEBAR
		    FULSCREENMODE = false;
		var elapsed = jwplayer("videoSection").getPosition();
			console.log(elapsed);
	    // These function will not exist in the browsers that don't support fullscreen mode yet, 
	    // so we'll have to check to see if they're available before calling them.
			if (document.mozCancelFullScreen) {
			document.mozCancelFullScreen();
			}
			else if (document.webkitCancelFullScreen) {
			document.webkitCancelFullScreen();
			}

				element = document.getElementById('icon5')
				element.setAttribute("style"," opacity:0.7; position:absolute; left:160px; top:10px;  width: 30px; height: 30px; ");
				element = document.getElementById('icon6')
				element.setAttribute("style"," opacity:0.7; position:absolute; left:200px; top:10px; width: 30px; height: 30px; ");
				element = document.getElementById('icon1')
				element.setAttribute("style"," opacity:0.7; position:absolute; left:240px; top:10px; width: 30px; height: 30px; ");
				element = document.getElementById('icon3')
				element.setAttribute("style"," opacity:0.7; position:absolute; left:280px; top:10px; width: 30px; height: 30px; ");
				element = document.getElementById('icon4')
				element.setAttribute("style"," opacity:0.7; position:absolute; left:320px; top:10px; width: 30px; height: 30px; ");
				element = document.getElementById('mainBar')
	            if(element) element.parentNode.removeChild(element);
				element = document.getElementById('sideBar')
	            if(element) element.parentNode.removeChild(element);
				element = document.getElementById('chatBar')
	            if(element) element.parentNode.removeChild(element);
				element = document.getElementById('chatBarInd')
	            if(element) element.parentNode.removeChild(element);
				element = document.getElementById('extensionBar')
	            if(element) element.parentNode.removeChild(element);
				element = document.getElementById('hotspotBox')
	            if(element) element.parentNode.removeChild(element);
				element = document.getElementById('imgclose')
	            if(element) element.parentNode.removeChild(element);
				element = document.getElementById('imgclose2')
	            if(element) element.parentNode.removeChild(element);
				element = document.getElementById('AddNoteBox')
	            if(element) element.parentNode.removeChild(element);
				element = document.getElementById('AddBookmarkBox')
	            if(element) element.parentNode.removeChild(element);

		
		}
	  }

			function initiate_sidebar_tabs(){
			}
    </script>


		<script onreadystatechange="TopUp.init()" onload="TopUp.init()"
			type="text/javascript"
			src="../resources/content_consumption/js/jquery/fxc-clip.uic-resizable.js"></script>

		<script type="text/javascript">
TopUp.addPresets({
    'a[data-filetype="audio"]': {
      shaded: 1, effect: "fade", overlayClose: 1, width: 495, height: 285
    },
    'a[data-filetype="video"]': {
      shaded: 1, effect: "fade", overlayClose: 1, width: 485, height: 40
    },
    'a[data-filetype="image"]': {
      //title: "Thumbnails {alt} ({current} of {total})",
      //group: "doc_example",
      //readAltText: 1,
      shaded: 1,
      effect: "fade"
      //layout: "quicklook"
      // y: 100,
      // x: 400 
    },
    '[data-filetype="imageset"]': {
        title: "Thumbnails {alt} ({current} of {total})",
        //group: "doc_example",
        //readAltText: 1,
        shaded: 1,
        effect: "fade",
        layout: "quicklook"
        // y: 100,
        // x: 400 
      }


});
</script>


		<!-- fix. IE 6-->
		<script>
			document.createElement('header');
			document.createElement('nav');
			document.createElement('section');
			document.createElement('article');
			document.createElement('aside');
			document.createElement('footer');
		</script>
		<script>
			var coursevideo = true;
			var MouseOver = false;
			$(document)
					.ready(
							function() {
								$("#listen-text-bookmark").hide();
								//$("#enrich_note").hide();
								$('.tabContent').find('.tabss:eq(1)').css(
										'display', 'block');
								$('.tabsTwo a')
										.click(
												function() {
													var _loc_0 = ($(this)
															.parent().index());
													$('.tabsTwo')
															.find('a')
															.each(
																	function() {
																		$(this)
																				.parent()
																				.removeClass(
																						'selected')
																	});
													$(this).parent().addClass(
															'selected');
													$('.tabContent')
															.find('.tabss')
															.each(
																	function() {
																		$(this)
																				.css(
																						'display',
																						'none');
																	});
													$('.tabContent').find(
															'.tabss:eq('
																	+ _loc_0
																	+ ')')
															.fadeIn('fast');
												});
								$('.imgLarge').click(function() {
									$(this).parent().hide();
									$(this).parent().prev().show();
								});
								$('.imgSmall').click(function() {
									$(this).parent().hide();
									$(this).parent().next().show();
								});
								$('.videoItem')
										.click(
												function() {
													if ($(this).find(
															'div:eq(0)')
															.hasClass(
																	"selected"))
														return;
													$(this)
															.parent()
															.find('.videoItem')
															.each(
																	function() {
																		$(this)
																				.find(
																						'div:eq(0)')
																				.removeAttr(
																						"class")
																				.attr(
																						"class",
																						"videoImg normal");
																	})
													$(this)
															.find('div:eq(0)')
															.removeAttr("class")
															.attr("class",
																	"videoImg selected");
													$('#videoSection').empty();
													var _loc_0 = $(this)
															.index();
												});
								$("#listen-text").hide();
								//$("#enrich_note").hide();
							});
			$(function() {
//				getPlayList();
				$('a.link').click(function() {
					$('a.link').removeClass('active');
					$(this).addClass('active');
				});
			});

			function displayExternalVideo() {
				jwplayer("videoSection").seek('3');
				jwplayer("videoSection").pause(true);
				jwplayer("videoSection").load({
					file : 'http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4',
					image : 'thumbs/Video-1.jpg'
				});
				//jwplayer("videoSection").play();
			}
			function enableEditButton() {
				/*$("#listen").click(function() {
					jwplayer().play();
					$("#listen-text").toggle();
				});*/
			}

			function displayBookMarkSection() {
				$("#listen-text-bookmark").toggle();
				$('#bookmarklabel').val('');
				jwplayer().play();
			}
			function disableEditButton() {
				//$("#listen").click();
			}
			
			//Clean function is replaced by showVideoNoteForm();
			/*function clean() {
				$('#description').val('');
				$("input#bookmarkTitle").val('');
				$('.textArea').attr('readonly', false);
				$("input#bookmarkTitle").attr('readonly', false);
				var imageHtml = '<div class="icons"><img src="../resources/content_consumption/images/pencil.png" width="16" height="16" /></div><div class="icons"><a href="#" onclick="doAjaxPost();"><img src="../resources/content_consumption/images/disk.png" width="16" height="16" /></a></div>';
				$('.iconMain').html(imageHtml);
			}*/
			
			function showVideoNoteForm(){
				jwplayer().pause();
				$('#listen-text').fadeIn(); //show the form
				$('#listen-text').find('textarea, input[type="text"]').val('').removeAttr('readonly');
				$('#videoIdHid, #timeHid').val('');
				//collect time and video id.
				
			}

			  function showEnrichmentNoteForm(){
				 // alert("showEnrichmentNoteForm");
					jwplayer().pause();
					$('#enrich_note').fadeIn(); //show the form
					$('#enrich_note').find('input[type="text"]').val('').removeAttr('readonly');
					$('#videoIdHid, #timeHid').val('');
			  }

			  
			function onDeleteNotes(videoId,time,videoName) {
				jwplayer().pause();
				//alert("inside deleteNotesmethod");
				//alert("video length2 : " + videoId.trim().length);
				//alert( "videoId=" + videoId + " &time=" + time+" &videoName=" + videoName);
				var videoNameVal = $('#videoNameHid').val();
				//alert("videoNameVal : "+videoNameVal);
				var dataString = "";
				
				if(videoName!=null && videoName!=""){
					dataString="videoId=" + videoId + "&videoName=" + videoName + "&deleteBookmark=" + "deleteBookmark";
				}else{
					dataString="videoId=" + videoId + "&time=" + time + "&deleteNote=" + "deleteNote";
				}
				
				/*
				$.ajax({
					type : "POST",
					url : "/ContentConsumption/video.htm",
					data : dataString,
					error : function(e) {
						//alert("Error on delete Notes");
						//$('#textArea').val('');
						//$("input#bookmarkTitle").val('');
					}
				});
				*/
				jwplayer().play();
			}
			
			function onDeleteBookmark(videoId,time,videoName) {
				jwplayer().pause();
				//alert("inside onDeleteBookmark");
				//alert("video length2 : " + videoId.trim().length);
				//alert( "videoId=" + videoId + " &time=" + time+" &videoName=" + videoName);
				var videoNameVal = $('#videoNameHid').val();
				//alert("videoNameVal : "+videoNameVal);
				var dataString = "";
				/*
				$.ajax({
					type : "POST",
					url : "/ContentConsumption/video.htm",
					data : "videoId=" + videoId + "&videoName=" + videoNameVal + "&deleteBookmark=" + "deleteBookmark",
					error : function(e) {
						//alert("Error on delete Notes");
					}
				});*/
				jwplayer().play();
			}
			
			function doAjaxPost() {
				//alert("inside ajax post");
				// get the form values
				var name = (jwplayer().getPlaylistItem()["file"])
						.split("/Generic/uploads/")[1];
				var description = String($('#textArea').val());
				var videoId = String($('#videoIdHid').val());
				var time = jwplayer().getPosition();

				var bookmarkTitle = String($("input#bookmarkTitle").val());
				
				//console.log("Time: "+ time);
				//console.log("Video Length: "+ videoId.length);
				//return false;
				
				
				var dataString = "";
				if (videoId != null && videoId != "") {
					time = String($('#timeHid').val());
					
					//alert("video id not n ull111");
					//alert("video id not nulltime "+time);
					dataString = "videoId=" + videoId + "&time=" + time
							+ "&name=" + name + "&description=" + description
							+ "&bookmarkTitle=" + bookmarkTitle + "&update="
							+ "update";
				} else {
					//alert("video id  null");
					dataString = "time=" + time + "&name=" + name
							+ "&description=" + description + "&bookmarkTitle="
							+ bookmarkTitle;
				}
				//alert("dataString : "+dataString);
				/*
				$.ajax({
					type : "POST",
					url : "/ContentConsumption/video.htm",
					data : dataString,
					error : function(e) {
						$('#textArea').val('');
						$("input#bookmarkTitle").val('');
					}
				});
				*/
				$('#videoId').val('');
				document.getElementById("videoIdHid").value = "";
				jwplayer().play();
				document.getElementById("videoIdHid").value = "";

				

			}
			
			function doBookMarkPost() {
				// get the form values
				var videoName = (jwplayer().getPlaylistItem()["file"])
						.split("/Generic/uploads/")[1];
				var time = jwplayer().getPosition();
				var title = String($("input#bookmarklabel").val());
				/*
				$.ajax({
					type : "POST",
					url : "/ContentConsumption/video.htm",
					data : "time=" + time + "&title=" + title + "&videoName="
							+ videoName + "&bookmark=" + "bookmark",
					error : function(e) {
						$("input#title").val('');
					}
				});
				*/
				jwplayer().play();
			}

			function displayBookMarkNotes(time) {
				if (time != null) {
					jwplayer().seek(time);
					jwplayer().pause(true);
				}
			};

			/*
			function getBookMarkList(name) {
				$.getJSON(
								"<c:url value="/video.htm" />",
								{
									"bookamrklist" : 'bookamrklist',
									"videoName" : name
								},
								function(data) {
									var link = null;
									for ( var i = 0; i < data.length; i++) {
										var timeValue = getAssignedTime(data[i].time
												.split(":"));
										if (i == 0) {
											link = '<tr><td width="30"><img src="../resources/content_consumption/images/orgstar.gif" width="11" height="11" id="image' +i +'"/></td><td width="400"><a href="#" id='
													+ i
													+ '  onclick="displayBookMarkNotes(\''
													+ timeValue
													+ '\');" style="left: 5em;">'
													+ data[i].title
													+ '</a></td>'
													+'<td ><img type="button" src="../resources/content_consumption/images/delete.jpg" width="11" height="11" onclick="onDeleteBookmark(\''
													+ data[i].videoId
													+ '\',\''
													+ ""
													+ '\',\''
													+ data[i].videoName
													+ '\');" id="image' +i +'"/></td></tr>';
										} else {
											link = link
													+ '<tr><td width="30"><img src="../resources/content_consumption/images/orgstar.gif" width="11" height="11" id="image' +i +'"/></td><td width="400"><a href="#" id='
													+ i
													+ '  onclick="displayBookMarkNotes(\''
													+ timeValue
													+ '\');" style="left: 5em;">'
													+ data[i].title
													+ '</a></td>'
													+'<td ><img type="button" src="../resources/content_consumption/images/delete.jpg" width="11" height="11" onclick="onDeleteBookmark(\''
													+ data[i].videoId
													+ '\',\''
													+ ""
													+ '\',\''
													+ data[i].videoName
													+ '\');" id="image' +i +'"/></td></tr>';
										}
										;
									}
									;
									if (link != null) {
										$("#myBookMarkContent").html(link);
									} else {
										$("#myBookMarkContent").html(null);
									}
								});
			}
			*/
			/*
			function getPlayList() {
				//alert("init");
				$
						.getJSON(
								"<c:url value="/video.htm" />",
								{
									"displayList" : 'displayList'
								},
								function(data) {

									var playlist_items = "";
									for ( var i = 0; i < data.length; i++) {
										if (i == 0) {
											playlist_items = '<li id='+i+'><a id='
													+ i
													+ '  onclick="displayVideo(\''
													+ data[i].fileName
													+ '\',\''
													+ data[i].filePath
													+ '\');" ><div class="lar-patt"><div class="zicons l1 vedeo f-l" ><img src="/ContentConsumption/images/video_thumbnails/'+data[i].fileName+'.jpg" width="70px" height="75px"/></div><div class="p-items-for-today f-l"><strong class="light-gray text-size-px11">'
													
													+ data[i].fileName
													+ '</div></div></a></li>';
										} else {
											//console.log(data[i]);
											playlist_items = playlist_items
													+ '<li id='+i+'><a id='
													+ i
													+ ' onclick="displayVideo(\''
													+ data[i].fileName
													+ '\',\''
													+ data[i].filePath
													+ '\');" ><div class="lar-patt"><div class="zicons l1 vedeo f-l"><img src="/ContentConsumption/images/video_thumbnails/'+data[i].fileName+'.jpg" width="70px" height="75px"/></div><div class="p-items-for-today f-ls"><strong class="light-gray text-size-px11 ">'
													+ data[i].fileName
													+ '</div></div></a></li>';
										}
										
									}

									if (data.length == 0) { //there are no items in the playlist. 
										playlist_items = "<p><img src='images/icons/icon_info.png' style='vertical-align: middle;'/> There are no items in the playlist.</p>";
									}
									$("#my_playlist_items")
											.html(playlist_items);

								});
			}
			
			*/
			
			/*
			function getTreeData() {
				
				//var paramStr = 'displayTree';
				
				$("#dashboard_course_trees").jstree({
					
					
					        "json_data" : {
					
					            "ajax" : {
					
					                "url" : "<c:url value="/video.htm?displayTree=ccc" />",
					
					                "data" : function (data) {
					                    
					                	
					                	//console.log(" callback called in jstree");
					                    //console.log("data is "+data.d);
					                    
					                    return { id : data.attr ? data.attr("id") : 0 };
					
					                }
					
					            }
					
					        },
					
					        "plugins" : [ "themes", "json_data" ],
					        "themes" : {
										"theme" : "default",
					        			"dots" : false,
					        			"icons" : true
					        			}
					
					    });
					
					}
			*/
			

			function displayEnrichVideo(enrichmentid,videoid,starttime,endtime){
				//alert("inside disdf method");
			}

			/*
				function doPlayListPost() {
				// get the form values
				var name = (jwplayer().getPlaylistItem()["file"])
						.split("videos/")[1];
				var path = "videos/";
				$.ajax({
					type : "POST",
					url : "/ContentConsumption/video.htm",
					data : "fileName=" + name + "&filePath=" + path
							+ "&playlist=" + "playlist",
					error : function(e) {
					}
				});

				getPlayList();
			}

			*/
			/*
			function doUpdatePost(videoId, description, bookmarkTitle) {
				alert(":::videoId "+videoId+": description "+description+" : bookmarkTitle "+bookmarkTitle);
				var name = (jwplayer().getPlaylistItem()["file"])
						.split("videos/")[1];
				var description = String($('#textArea').val());
				var bookmarkTitle = String($("input#bookmarkTitle").val());
				//alert(":::name "+name+": description "+description+" : bookmarkTitle "+bookmarkTitle);
				$.ajax({
					type : "POST",
					url : "/ContentConsumption/video.htm",
					data : "videoId=" + videoId + "&name=" + name
							+ "&description=" + description + "&bookmarkTitle="
							+ bookmarkTitle + "&update=" + "update",
					error : function(e) {
						$('#textArea').val('');
						$("input#bookmarkTitle").val('');
					}
				});
				jwplayer().play();
			}
			*/
		</script>
		<script>
	 
	 

$(document).ready(function(){ 


 <!-- added by sundip shah --> 
 
 $("#new_comment").hide();
 $("#btn_comment").click(function() {
  $("# dash-bord-bar").append("<br/>");
  $("#new_comment").show("slow");
  $("#new_comment").val("Enter a comment");
  
 });
 
 $("#new_comment").keyup(function(event){
    if(event.keyCode == 13){
       var newcomment = $("#new_comment").val();
	  
	     $(".comments-container").append("<br/>").val();
	  $(".comments-container").append($("#new_comment").val());
	 
	   $(".comments-container").append("<br/>").val();
		
			 }
});
 <!-- upto here -->
 
		
}); 
</script>


		<link rel="stylesheet" type="text/css"
			href="../resources/content_consumption/css/custom-theme/old-jquery-ui-1.8.21.custom.css">
			<link rel="stylesheet" type="text/css"
				href="../resources/content_consumption/css/custom-theme/jquery-ui-1.8.21.custom.css">
				<script src="../resources/content_consumption/js/jquery-1.7.2.min.js"></script>
				<script src="../resources/content_consumption/js/jquery-ui-1.8.21.custom.min.js"></script>
				<!--end jquery UI-->
				
				
<link rel="stylesheet" href="http://www.jqwidgets.com/jquery-widgets-demo/jqwidgets/styles/jqx.base.css" type="text/css" />
<script type="text/javascript" src="http://www.jqwidgets.com/jquery-widgets-demo/scripts/gettheme.js"></script>
<!-- <script type="text/javascript" src="http://www.jqwidgets.com/jquery-widgets-demo/scripts/jquery-1.8.2.min.js"></script> -->
<script type="text/javascript" src="http://www.jqwidgets.com/jquery-widgets-demo/jqwidgets/jqxcore.js"></script>
<script type="text/javascript" src="http://www.jqwidgets.com/jquery-widgets-demo/jqwidgets/jqxdata.js"></script>
<script type="text/javascript" src="http://www.jqwidgets.com/jquery-widgets-demo/jqwidgets/jqxbuttons.js"></script>
<script type="text/javascript" src="http://www.jqwidgets.com/jquery-widgets-demo/jqwidgets/jqxscrollbar.js"></script>
<script type="text/javascript" src="http://www.jqwidgets.com/jquery-widgets-demo/jqwidgets/jqxpanel.js"></script>
<script type="text/javascript" src="http://www.jqwidgets.com/jquery-widgets-demo/jqwidgets/jqxtree.js"></script>
<style>
.jqx-widget-content {
  background: none repeat scroll 0 0 transparent;
  border-color: none;
  font-family: Verdana,Arial,sans-serif;
  font-size: 13px;
  font-style: normal;
}
.jqx-tree{border:0 !important;}
.jqx-item {
  background: none repeat scroll 0 0 transparent;
  border: 1px solid transparent;
  color: white;
}
.jqx-fill-state-pressed {
  background: #444;
}
</style>

				<script src="../resources/content_consumption/js/jquery.verticalscrollplus-1.0.js"></script>

				<script src="../resources/content_consumption/js/login/jquery.tipsy.js" type="text/javascript"></script>
				<script src="../resources/content_consumption/js/custom.js" type="text/javascript"></script>
				<script src="../resources/content_consumption/js/jquery.cookie.js"></script>
				<script src="../resources/content_consumption/js/jquery.collapse.js"></script>
				<script src="../resources/content_consumption/js/jstree/jquery.jstree.js"></script>
				<script src="../resources/js/custom/course_consumption.js"></script>
				<script>
					$(function() {
						//Initialize buttonset
						$("#format").buttonset();
						//Initialize progress bar
						$("#progressbar").progressbar({
							value : 37
						});
						
						//Initialize jstree for the first time on page load. Gets data via ajax
						//getTreeData();

						//Toggle Header
						$('#headerpane_toggler').toggle(
							function(){ toggle_handle = $(this); $('#headsection').slideUp(); toggle_handle.attr('src','icons/inactive-header.gif');},
							function(){ toggle_handle = $(this); $('#headsection').slideDown(); toggle_handle.attr('src','icons/active-header.gif'); }
						);						
					});
				</script>
</head>
<body>

	<div id="wrapper">
		<img id="headerpane_toggler" style="position: absolute; top: 2em; left:110em; cursor:pointer;" src="../resources/content_consumption/icons/active-header.gif" title="Toggle Header Pane">
		<!--Header Container-->
	<div id="headsection">
		<header class="bottom-box-shadow bckground-wihte">
		<div class="topheader">

			<!--logo container-->

			<div class="logo">
				<a href="/Generic/"><img src="../resources/content_consumption/images/logo.jpg" width="189" height="73"></a>
			</div>

			<!--end logo container-->

			<div class="status-container">
				<div id="status-icons"
					class="bottom-box-shadow two-bottom-rounded-box">
					<ul>
						<li><a href="#" class="email-icon" rel="tipsy"
							title="3 New emails"><span class="wite-title">3</span></a></li>
						<li><a href="#" class="alart-icon orange-bc" rel="tipsy"
							title="1 Circle Invite"><span class="wite-title">1</span></a></li>
						<li><a href="#" class=" amount-icon blue-bc" rel="tipsy"
							title="Ziks available"><span class="wite-title">355500</span></a></li>
						<li><a href="#" class="peoples-icon orange-bc" rel="tipsy"
							title="5 Contact requests"><span class="wite-title">5</span></a></li>
					</ul>
					<div></div>
				</div>
				<div class="account-container two-bottom-rounded-box">
					<div class="container">
						<div class="topnav">
							<a href="#" class="signin wite bold"><span
								class="text-size-px12 wite bold">My Account</span></a>
						</div>
						<fieldset id="signin_menu">
							<ul>
								<li><a href="#">Preferences</a></li>
								<li><a href="#">Privacy</a></li>
								<li><a href="#">Sign Out</a></li>
							</ul>
						</fieldset>
					</div>
				</div>
			</div>
		</div>
		<nav> <!--menu-->
		<!--
		<div class="menu">
			<ul>
				<li><a href="learnerhomepage.html" class="current">My Home</a>
				<div class="nav-line"></div></li>
				<li><a href="#">My Programs</a>
				<div class="nav-line"></div></li>
				<li><a href="#">My Performance</a>
				<div class="nav-line"></div></li>
				<li><a href="#">My Locker</a></li>
			</ul>
		</div>
		-->
		<div class="menu">
		  <ul>
			<li><a href="/Generic/learnerhomepage.html" class="current">My Home</a><div class="nav-line"></div></li>
			<li><a href="#">My Programs</a><div class="nav-line"></div></li>
			<li><a href="#" style="margin-left:10px; margin-right:10px;">My Performance</a><div class="nav-line"></div></li>
			<li><a href="#" style="margin-left:-10px;">My Locker</a></li>
		  </ul>
		</div>




		<!--End menu-->
		<div class="searchpanel">
			<div>
				<form id="ui_element" class="sb_wrapper">
					<input type="text" name="search" id="search"
						placeholder="Search..." title="Search..." autosave="unique"
						class="two-left-rounded-box two-right-rounded-box"> <input
						id="submit" type="submit" value="Submit">

							<ul class="sb_dropdown" style="display: none;">
								<li class="sb_filter">Filter your search</li>
								<li><input type="checkbox" /><label for="all"><strong>All
											Categories</strong></label></li>
								<li><input type="checkbox" /><label for="Automotive">Filter
										by Area</label></li>
								<li><input type="checkbox" /><label for="Baby">Filter
										by Subject</label></li>
								<li><input type="checkbox" /><label for="Beauty">Filter
										by Topic</label></li>
								<p></p>
								<p>
									<li><input type="checkbox" /><label for="all"><strong>All
												Categories</strong></label></li>
									<li><input type="checkbox" /><label for="Automotive">Filter
											by Area</label></li>
									<li><input type="checkbox" /><label for="Baby">Filter
											by Subject</label></li>
									<li><input type="checkbox" /><label for="Beauty">Filter
											by Topic</label></li>
								</p>

							</ul>
				</form>

			</div>
		</div>
		<div class="searchoptions">
			<ul>
				<li class="srch-op-a"><a href="#"></a></li>
				<li class="srch-op-b"><a href="#"></a></li>
				<li class="srch-op-c"><a href="#"></a></li>
			</ul>
		</div>
		</nav> </header>
	</div> <!--to be included	-->		
		<!--End Header Container-->
		<!--slogen-->
<!-- 		<div class="sub-nav">
			<div class="f-l">
				<strong class="text-size-px16 font-Signika blue"><a
					href="#" style="text-decoration: none;">Course Name </a>> </strong><strong
					class="light-gray text-size-px16">3. Survey</strong>
			</div>
			<div class="f-r">
				<strong class="text-size-px14 light-gray">|<a href="#">
						Course Blog</a> | <a href="#">Tasks & assignments</a> | <a href="#">Grades</a>
					| <a href="#">Calendar</a> | <a href="#">Playbook</a></strong>
			</div>
		</div> -->
		<!--End slogen-->
		<!--Main Content-->
		<section style="position: relative;">

			<div id="content_container">
				<div id="content_tab_pane_container">
				
				        <div data-tabpane="educator" style="display:none;">
				        	<img onclick="$(this).parent().fadeOut('fast'); unhighlight_tab('educator');" src="../resources/content_consumption/icons/cross.png" class="hide_parent">
				        	<span class="column_title">Educator</span>
				        	<div class="educator_notes"></div>
				        	<div class="educator_references"></div>
				            <!-- <a href="http://citeseerx.ist.psu.edu/viewdoc/summary?doi=10.1.1.151.9419" target="_blank" data-iconprefix="link">Aggregating Preferences in Multi-Issue Domains</a>
				            <a href="http://faculty.arts.ubc.ca/pbartha/p321f01/p321ovh2.pdf" target="_blank" data-iconprefix="link">Preference Ordering</a>
				            <a title="Make sure you understand this concept before proceeding. Please make use of the references provided or contact me to seek any clarifications." href="#" data-iconprefix="note">Critical Concept</a>  -->          
				        </div>
	
				        <div data-tabpane="reference_materials" style="display:none;">
				        	<img onclick="$(this).parent().fadeOut('fast'); unhighlight_tab('reference_materials');" src="../resources/content_consumption/icons/cross.png" class="hide_parent">
				        	<span class="column_title">Reference Materials</span>
				            <a href="http://en.wikipedia.org/wiki/Order_of_preference" target="_blank" data-iconprefix="link">Order of Preferences</a>                
				        </div>
	
				        <div data-tabpane="books" style="display:none;">
				        	<img onclick="$(this).parent().fadeOut('fast'); unhighlight_tab('books');" src="../resources/content_consumption/icons/cross.png" class="hide_parent">
				        	<span class="column_title">Books</span>
				        	<a data-iconprefix="pdf" target="_blank" href="http://societysbreakthrough.com/Levels_of_Thinking_.pdf">Levels of Thinking</a>
				        </div>
	
				        <div data-tabpane="class" style="display:none;">
				        	<img onclick="$(this).parent().hide(); unhighlight_tab('class');" src="../resources/content_consumption/icons/cross.png" class="hide_parent">
				        	<span class="column_title">Class Notes</span>
								<div class="note" title="The Productive Thinking Model (sometimes known as ThinkX) was developed by Tim Hurson, a Canadian author, speaker, and creativity theorist." onclick="jwplayer().seek(25).play(true);">
									<img width="40px" height="40px" src="../resources/content_consumption/icons/Aron.png"> <span>Aaron</span><br/> The Productive Thinking Model ...

								</div>
								<div class="note" title="Look at Wikipedia article on Model Thinking" onclick="jwplayer().seek(75).play(true);" >
									<img width="40px" height="40px" src="../resources/content_consumption/icons/Stella.png"> <span>Stella</span><br/>
									Wikipedia article on Model Thinking.
								</div>
				        </div>

					
				</div>
				<div id="tree_container">
					<span class="column_title">Chapters</span>
					
					<p class="user-name-w1">1. MODEL THINKING</p>

					<div id="jqx_tree_container">
        <script type="text/javascript">
          
        </script>
        <div id='jqx_course_tree'>
        </div>
					
					</div>
				<input type="hidden" value="100" id="courseId"/>

					<ul id="nav">

						<li class="user-name-w2" id="chapter">1.1 Why Model Thinking
							<ul class="user-name-w2">
								<li><a href="/ContentConsumption/images/output0.jpeg"
									data-filetype="imageset" class="tu"
									toptions="group= imageset-1"
									onclick="displayImageSet($(this));">1.1.1 Why Model</a> <span
									class="hidden"> <a
										href="/ContentConsumption/images/output1.jpeg"
										data-filetype="imageset" class="tu"
										toptions="group= imageset-1"></a> <a
										href="/ContentConsumption/images/output2.jpeg"
										data-filetype="imageset" class="tu"
										toptions="group= imageset-1"></a>
								</span></li>
								<li><a href="/ContentConsumption/images/output0.jpeg"
									data-filetype="imageset" class="tu"
									toptions="group= imageset-2"
									onclick="displayImageSet($(this));">1.1.2 Intelligent
										Citizens of the World</a> <span class="hidden"> <a
										href="/ContentConsumption/images/output1.jpeg"
										data-filetype="imageset" class="tu"
										toptions="group= imageset-2"></a> <a
										href="/ContentConsumption/images/output2.jpeg"
										data-filetype="imageset" class="tu"
										toptions="group= imageset-2"></a>
								</span></li>
							</ul>
						</li>
						<li class="user-name-w2" id="chapter">1.2 Aggregation
							<ul class="user-name-w2">
								<li><a href="/ContentConsumption/images/output0.jpeg"
									data-filetype="imageset" class="tu"
									toptions="group= imageset-3"
									onclick="displayImageSet($(this));">1.2.1 Aggregation</a></li>
								<span class="hidden"> <a
									href="/ContentConsumption/images/output1.jpeg"
									data-filetype="imageset" class="tu"
									toptions="group= imageset-3"></a> <a
									href="/ContentConsumption/images/output2.jpeg"
									data-filetype="imageset" class="tu"
									toptions="group= imageset-3"></a>
								</span>
						</li>
						<li><a href="#"
							onclick="displayVideo('sixsigma.mp4','/Generic/uploads/');">1.2.2 Six
								Sigma</a></li>
						<li><a href="#"
							onclick="displayVideo('test.webm','/Generic/uploads/'); $('.preference_aggregation_temp').show();">1.2.3
								Preference Aggregation</a></li>
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

				<div id="content_tab_icon_container">
					<span class="column_title">References</span>
					<img data-tab="educator" src="../resources/content_consumption/icons/Google.png" title="Educator Suggested References"><br/><br/><br/>
					<img data-tab="reference_materials" src="../resources/content_consumption/images/logos/_reference_material.png" title="Reference Materials"><br /><br/><br/>
					<img data-tab="class" src="../resources/content_consumption/images/logos/_class.png" title="Class Notes"><br /><br/><br/>
					<img data-tab="books" src="../resources/content_consumption/images/logos/_books.png" title="Books"><br/><br/><br/>
				</div>

				<!-- Start Video Container -->
				<div id="video_container">

						<div style="position: absolute; z-index: 2; text-align: left; background: #444; width: 640px; ">
							<div id="add_bookmark_container" style="display:none;">
								<img class="hide_parent" src="../resources/content_consumption/icons/cross.png" onclick="$(this).parent().fadeOut('fast'); jwplayer().play(true);">
								<span class="column_title">Add a Bookmark</span>
								Title: <input class="add_bookmark_title" type="text" placeholder="Bookmark Title"/>
								<input class="add_bookmark_submit_button" type="button" value="Add Bookmark"/>
							</div>
							<div id="add_question_container" style="display:none;">
								<img class="hide_parent" src="../resources/content_consumption/icons/cross.png" onclick="$(this).parent().fadeOut('fast'); jwplayer().play(true);">
								<span class="column_title">Add a Question</span>
								Question: <input class="add_question_title" type="text" placeholder="Type your Question"/>
								<input class="add_question_submit_button" type="button" value="Add Question"/>
							</div>
							<div id="add_note_container" style="display:none;">
								<img class="hide_parent" src="../resources/content_consumption/icons/cross.png" onclick="$(this).parent().fadeOut('fast'); jwplayer().play(true);">
								<span class="column_title">Add a Note</span>
								Title: <br/><input class="add_note_title" type="text" placeholder="Note Title"/><br/><br/>
								Description: <br/><textarea class="add_note_description" placeholder="Note description" value="">
								</textarea>
								<input class="add_note_submit_button" type="button" value="Add Note"/>
							</div>
						</div>
						<div style="width: 630px; text-align: right; z-index: 1; position: absolute; margin-top: 10px; margin-bottom: -42px;">
							<img id="bookmark_button_smallscreen" class="add_bookmark_trigger" width="32px" src="../resources/content_consumption/icons/add_bookmark.png" style="display:none; visibility:visible; margin-right: 2em;"title="Add Bookmark">
							<img id="question_button_smallscreen" class="add_question_trigger" width="32px" src="../resources/content_consumption/icons/add_question.png" style=" visibility:visible; margin-right: 2em;"title="Add Question">
							<img id="note_button_smallscreen"  class="add_note_trigger" width="32px" src="../resources/content_consumption/icons/add_note.png" style="visibility:visible;" title="Add Note">
						</div>
						
						<div id="videoSection"  >
							<!-- START OF THE PLAYER EMBEDDING TO COPY-PASTE -->
						</div>

						<script type="text/javascript">
							var player = null;
							function playerReady(obj) {
								var link = '<img src="../resources/content_consumption/images/disk.png" width="16" height="16"/>';
								player = document.getElementById(obj['id']);
								player.setOverlay('overlay1', link, 'l,t');
								player.sendEvent('REDRAW');
							};

							function editBookMark(videoId, description,
									bookmarkTitle) {
								//alert("inside editbookmark method ");
								$('.textArea').attr('readonly', false);
								$("input#bookmarkTitle")
										.attr('readonly', false);
								//alert("videoId "+videoId+": description "+description+" : bookmarkTitle "+bookmarkTitle);
								var imageHtml = '<div class="icons"><img src="../resources/content_consumption/images/pencil.png" width="16" height="16" /></div><div class="icons"><a href="#" onclick="doUpdatePost(\''
										+ videoId
										+ '\',\''
										+ description
										+ '\', \''
										+ bookmarkTitle
										+ '\');"><img src="../resources/content_consumption/images/disk.png" width="16" height="16" /></a></div>';
								$('.iconMain').html(imageHtml);
							};
							

							function displayBookMark(videoId, description,
									time, bookmarkTitle) {
								//alert("inside method ");
								//alert("time :"+time+" :: videoId : "+videoId+" :: description : "+description+" :: bookmarkTitle : "+bookmarkTitle);
								if (videoId != null) {
									document.getElementById("videoIdHid").value = videoId;
									document.getElementById("timeHid").value = time;
									//alert("inside not null");
									$("#listen-text").show();
									$('.textArea').val(description);
									$('#bookmarkTitle').val(bookmarkTitle);
									$('.textArea').attr('readonly', true);
									$("input#bookmarkTitle").attr('readonly',true);
									var imageHtml = '<div class="icons"><a href="#" onclick="editBookMark(\''
											+ videoId
											+ '\',\''
											+ description
											+ '\', \''
											+ bookmarkTitle
											+ '\');"><img src="../resources/content_consumption/images/pencil.png" width="16" height="16"/></a></div><div class="icons"><img src="../resources/content_consumption/images/disk.png" width="16" height="16"/></div>';
											
									$('.iconMain').html(imageHtml);
									
									jwplayer().seek(time);
									jwplayer().pause(true);
								}
							};
						</script>
						<script type="text/javascript" src="../resources/jwplayer/jwplayer.js"></script>
						<script type="text/javascript">
							var description;
							var time;
							var name;
							var bookmarkTitle;
							var videoID;
							var counter = 0;
							var oldTime = 0;
							var playListItemCounter = 0;
							jwplayer("videoSection").setup({
								flashplayer : "../resources/jwplayer/player.swf",
								playlist : [ {
									"file" : '../resources/jwplayer/video.mp4',
									"provider" : "http"
								} ],
								// Nov 7
								modes: [ { type: "html5" }, {type: 'flash', src: '../resources/jwplayer/player.swf'}, { type: "download" } ] , 
								 events: {
									 //onPlay: function(event) { togglePlay(event, true)	 },
									 onPause: function(event) { togglePlay(event, false) },
									 onFullscreen: function(event) {
									 ToggleFullscreen(event.fullscreen);
									 }
									},
									
								// Nov 7									
								image : 'thumbs/Video-1.jpg',
								repeat : "list",
								'stretching' : 'fill',
								'controlbar' : 'bottom',
								'width' : '640',//'550',
								'height' : '385',//'335',
/* 								'plugins' : {
									"captions-2" : {
										file : "videos/captions.srt",
										back : true
									}
								}, */ //Nov 7
								'provider' : 'http',
								'http.startparam' : 'starttime'
							});
							var checkStatus = "true";
							var refStatus  = "yes";
							
							function displayAudio(anchor){
								TopUp.close();
								$('#video_actions').css('visibility','hidden');
								$('#play-vedio').css('visibility','visible');
								filepath = anchor.attr('data-filepath');
								filepath = 'ContentConsumption/audio/'+ filepath;
								jwplayer().load(
										{
											file : filepath
											
											
										});
								jwplayer().play(true);
								
							}
							
							function displayImage(anchor){
								jwplayer().stop();
								$('#video_actions').css('visibility','hidden');
								$('#play-vedio').css('visibility','hidden');
								filepath = anchor.attr('data-filepath');
								//filepath = '/ContentConsumption/'+filepath;
								//anchor.click(); // workaround to trigger topup
								
							}
							
							
							function displayVideo(videoName, videoPath) {
								TopUp.close();
								$('#play-vedio, #video_actions').css('visibility','visible');
								checkStatus = "true";
								document.getElementById("videoNameHid").value=videoName;				
								jwplayer().load(
										{
											file : "" + videoPath
													+ videoName,
											image : 'thumbs/Video-1.jpg'
										});
								jwplayer().play(true);
							}

							/*
							function displayEnrichmentNote(videoId,time){
								
								//alert("inside method : "+videoId);
								$("#enrichment_list").html('');

								//alert("inside method :time "+time);
								$('input[name="enrich-set"][value="all"]').attr('checked',false);
								
								if (videoId != null) {
									document.getElementById("videoIdHid").value = videoId;
									document.getElementById("timeHid").value = time;
									//alert("time is : "+time);
									$("#enrichment_list").html(''); //empties table#enrichment_list
									$.getJSON(
											"<c:url value="/video.htm" />",
											{
												"enrichItem" : 'enrichItem',
												"videoid" : videoId,
												"starttime" : time
											},
											function(data) {
												var enrichment_list_items = null;
												//alert("data length : "+data.length); 
												//data.each(function(){console.log($(this).enrichmentid)});
												enrichment_list_items = '<tr class="'+data[0].componentType+' '+data[0].enrichmentid+'"><td width="150"><a href="#" id='
															+ '  onclick="displayEnrichVideo(\''
															+ data[0].enrichmentid
															+ '\',\''
															+ data[0].videoid
															+ '\',\''
															+ data[0].starttime
															+ '\', \''
															+ data[0].endtime
															+ '\');" style="left: 5em;">'
															+ data[0].title
															+ '</a></td>'
															//+ '<td width="100">'+data[0].title+'</td>'
															+'<td width="40">'+data[0].starttime+'</td>'
															//+'<td width="40">'+data[0].endtime+'</td>'
															+'</tr>';
												$("#enrichment_list").html(enrichment_list_items);
												
												if(data[0].componetType=="Notes"){
													refStatus = false;
													$('input[name="enrich-set"][value="notes"]').attr('checked',true);
													$('#enrich-filter').buttonset({option:1});
												}if(data[0].componetType=="Reference Material"){
													$('input[name="enrich-set"][value="refmaterial"]').attr('checked',true);
													$('#enrich-filter').buttonset({option:0});
												}
												document.getElementById("checkAllStatus").value = "false";
												checkStatus = "false";
										}
									);
									jwplayer().seek(time);
									jwplayer().pause(true);
								}
							} */
							
							function pausejwplayer(){jwplayer().pause();}
							function resumejwplayer(){jwplayer().play();}
							
							/*function displayEnrichAll(){
								$('input[name="enrich-set"][value="refmaterial"]').attr('checked',true);
								$('#enrich-filter').buttonset({option:0});

								
								$('input[name="enrich-set"][value="notes"]').attr('checked',true);
								$('#enrich-filter').buttonset({option:1});

								checkStatus = "true";
								getEnrichmentList(name);
								
							}*/
												
							
							var sizeOfRec = 0;
							var noteArray = new Array();
							var enrichArray=new Array();
							var noteTime=0;
							var enrichTime=0;

							jwplayer("videoSection")
									.onPlay(
											
											function(event) {
								
												//setTimeout(setBubbles, 500);
												element = document.getElementById('img1')
												if (element) {}
												else 
												{
													setTimeout(setBubbles, 500);
											
												}
												togglePlay(event, true);
												$("#listen-text-bookmark").hide();
												//getPlayList();
												enableEditButton();
												
												name = (jwplayer()
														.getPlaylistItem()["file"])
														.split("/Generic/uploads/")[1];

												//getNoteList(name);
												
												//getEnrichmentList(name);

												//alert("outside loop time : "+time);
												//getBookMarkList(name);		
												//alert("before call");
												$('input[name="enrich-set"][value="all"]').attr('checked',true);
/* 												alert("hid status :  "+document.getElementById("checkAllStatus").value);
 */												
												$('#enrich-filter').buttonset({option:2});
												//getEnrichmentList(name);
												document.getElementById("vidNameHid").value = name;
											});
							/*
							jwplayer("videoSection")
									.onReady(
											function() {
												name = (jwplayer()
														.getPlaylistItem()["file"]).split("videos/")[1];
												addVideo();
										
												$("#listen-text-bookmark").hide();
												//$("#enrichment_list").hide();
												
											});
							jwplayer("videoSection").onComplete(function() {
								oldTime = 0;
							});
							*/
							function getAssignedTime(timesplit) {
								var timeValue;
								if (timesplit[0] != "00") {
									timeValue = timesplit[0] + ".";
								}
								if (timesplit[1] != "00") {
									timeValue = timesplit[1] + ".";
								}
								if (timesplit[2] != "00") {
									timeValue = timesplit[2];
								}
								if (timesplit[2] == "00") {
									timeValue = "0.50";
								}
								return timeValue;
							}

							  function showEnrichmentTopicForm(){
								 // alert("showEnrichmentTopicForm");
							  }
							  function showEnrichRefMaterialForm(){
								  //alert("showEnrichRefMaterialForm");
							  }

    						  function doEnrichPost(){
								// get the form values
								var videoName = $("#vidNameHid").val();
								
								var starttime = jwplayer().getPosition();
								//alert("starttime : "+starttime);
								var endtime  =  jwplayer().getPosition()+30;
								//alert("end time : "+endtime);
								var title = String($("input#title").val());
								var componetType = String($("input#componetType").val());				
																
								//alert("videoName=" + videoName + "&title=" + title + "&componetType="+ componetType);
							/*
								$.ajax({
									type : "POST",
									url : "/ContentConsumption/video.htm",
									data : "videoName=" + videoName + "&starttime="+starttime+"&endtime="+endtime+"&title=" + title + "&componetType="
											+ componetType + "&postEnrich=" + "postEnrich",
									error : function(e) {
										$("input#title").val('');
										$("input#componetType").val('');
									}
								});
								jwplayer().play();

							  
							*/
    						  }
						</script>



						<div id="tempdata_sidebar" style="display: none;">
							<div id="sideBar" class="sidebar">
								<div id="tabs_container">
									<ul id="tabs-titles">
										<li data-tabpane="educator" title="Educator"><img
											src="../resources/content_consumption/icons/Google.png" /></li>
										<li data-tabpane="reference_materials"
											title="Reference Materials"><img
											src="../resources/content_consumption/icons/Wiki-Logo.png"></li>
										<li data-tabpane="books" title="Books"><img
											src="../resources/content_consumption/icons/encarta.png"></li>
										<li data-tabpane="class" title="Class"><img
											src="../resources/content_consumption/icons/icc_logo.png"></li>
									</ul>
									<ul id="tabs-contents">
										<li class="educator" style="display: none;">
											<div class="content">
												<a data-iconprefix="link" onclick="jwplayer().pause();"
													target="_blank"
													href="http://citeseerx.ist.psu.edu/viewdoc/summary?doi=10.1.1.151.9419">Aggregating
													Preferences in Multi-Issue Domains</a> <a
													data-iconprefix="link" onclick="jwplayer().pause();"
													target="_blank"
													href="http://faculty.arts.ubc.ca/pbartha/p321f01/p321ovh2.pdf">Preference
													Ordering</a> <a data-iconprefix="note"
													onclick="jwplayer().pause();" href="#"
													title="Make sure you understand this concept before proceeding. Please make use of the references provided or contact me to seek any clarifications.">Critical
													Concept</a>
											</div>
										</li>
										<li class="reference_materials">
											<div class="content">
												<a data-iconprefix="link" onclick="jwplayer().pause();"
													target="_blank"
													href="http://en.wikipedia.org/wiki/Order_of_preference">Order
													of Preferences</a>
											</div>
										</li>
										<li class="books">
											<div class="content">
												<a data-iconprefix="pdf" target="_blank" href="http://societysbreakthrough.com/Levels_of_Thinking_.pdf">Levels of Thinking</a>
 
											</div>
										</li>
										<li class="class">
											<div class="content">
												<div class="note">
													<img width="40px" height="40px" src="../resources/content_consumption/icons/Aron.png"> <span>Aaron</span>
													The Productive Thinking Model (sometimes known as "ThinkX") was developed by Tim Hurson, a Canadian author, speaker, and creativity theorist.
												</div>
												<div class="note">
													<img width="40px" height="40px" src="../resources/content_consumption/icons/Aron.png"> <span>Aaron</span>
													The Productive Thinking Model (sometimes known as "ThinkX") was developed by Tim Hurson, a Canadian author, speaker, and creativity theorist.
												</div>
											</div>
										</li>
									</ul>
								</div>
							</div>
						</div>
						<div id="video_actions">

							<img data-tab="table_of_contents" type="button" title="Video's Table of Contents" src="../resources/content_consumption/images/logos/TOC.png" onclick="" />
							<img data-tab="notes_and_bookmarks" type="button" title="Notes" src="../resources/content_consumption/images/logos/bookmarklist.png" onclick="" id="bookmarkicon" />
							<img data-tab="questions" type="button" title="Questions" src="../resources/content_consumption/icons/questions.png" onclick="" id="questionicon" />
							<img data-tab="circles" type="button" title="Online Contacts " src="../resources/content_consumption/icons/contacts.png" onclick="" />
						</div>


						<form:form commandName="file"
							action="/ContentConsumption/video.htm" id="fileForm">
							<!-- <input type="hidden" id="videoId"/> -->
							<div id="listen-text">
								<div id="editbox">
									<b>Note Title:</b>
									<form:input path="bookmarkTitle"
										class="password-strength-title" />
									<br /> <br /> <b>Note Description:</b>
									<div class="textArea">
										<form:textarea path="description" id="textArea" cols="70"
											class="textArea note_description" />
									</div>

								</div>

								<div id="video_note_actions">
									<img src="../resources/content_consumption/images/pencil.png" width="16" height="16"
										onclick="$('#bookmarkTitle, .note_description').removeAttr('readonly');" />
									<img type="button" src="../resources/content_consumption/images/disk.png" width="16" height="16"
										onclick="doAjaxPost();" /> <img src="../resources/content_consumption/images/cross.png"
										onclick="$('#listen-text').fadeOut(); $('#').show();$('#enrich_note').fadeOut();" />
								</div>
								<div id="dtext">
									<div class="textArea" id="savetext"></div>
								</div>
							</div>

							<input type="hidden" id="videoIdHid" />
							<input type="hidden" id="timeHid" />
							<input type="hidden" id="videoNameHid" />
						</form:form>
						<form name="bookamrk" method="post"
							action="/ContentConsumption/video.htm">
							<div id="listen-text-bookmark">
								<div id="editbox">
									<b>Bookmark Title:</b> <input type="text" name="bookmarklabel"
										id="bookmarklabel" class="password-strength-title" /> <a
										href="#" onclick="doBookMarkPost();"><img
										style="padding: .25em; background: white; vertical-align: middle; border-radius: 3px;"
										type="button" src="../resources/content_consumption/images/disk.png" width="16" height="16" /></a>
								</div>

								<div id="dtext">
									<div class="textArea" id="savetext"></div>
								</div>
							</div>
						</form>




				</div>
				<!-- End Video Container -->
				<div id="content_utilities_container">
					<!-- Table of Contents -->
					<div id="table_of_contents_container" data-tabpane="table_of_contents" style="display:none;">
						<span class="column_title">Table of Contents</span>
						<span class="preference_aggregation_temp" style="display:none;"><!-- Temporary -->
						<span id="current_media_title">Preference Aggregation</span>
						<a onclick="jwplayer().seek(75).play(true);">Preference Ordering</a>
						<a onclick="jwplayer().seek(248).play(true);">Transitive Preferences</a>
						<a onclick="jwplayer().seek(310).play(true);">Collective Preferences</a>
						</span><!-- Temporary -->
					</div>
					<!-- Notes & Bookmarks -->
					<div id="notes_and_bookmarks_container" data-tabpane="notes_and_bookmarks" style="display:none;">
						<span class="column_title">Notes</span>
						<span class="preference_aggregation_temp" style="display:none;"><!-- Temporary -->
						<a data-iconprefix="note" onclick="jwplayer().seek(75).play(true);" title="Must read before exam - Preference Ordering">Important</a>
						<!-- <a data-iconprefix="star" onclick="jwplayer().seek(248).play(true);">Illustration of Transitivity concept</a> -->
						</span><!-- Temporary -->
					</div>
					<!-- Questions -->
					<div id="questions_container" data-tabpane="questions" style="display:none;">
						<span class="column_title">Questions</span>
						
					</div>
					<!-- Send Question -->
					<div id="send_question" style="display:none;">
						<span class="column_title">Send Question</span>
						<input type="hidden" id="selected_question_id" value=""/>
						<div class="question_to_be_sent"></div>
						<div style="color: silver;">
							<span data-tab="q_educator" class="hover_state">EDUCATOR</span>
							<span data-tab="q_classmates">CLASSMATES</span>
						</div>
						<hr/>
						<div data-tabpane="q_educator"> 
							<img width="40px" height="40px" src="../resources/content_consumption/images/educator.png">
						</div>
						<div data-tabpane="q_classmates" style="display:none;">
							<div class="align_left">
								<label><input class="select_all_mates" type="checkbox"/>Select All</label> | <label><input class="show_online_mates" type="checkbox"/>Only Online</label>
							</div>
							<div data-user_online="true">
							<input type="checkbox" id=""/>
							<img src="../resources/content_consumption/icons/Aron.png" height="40px" width="40px"> <span>Aron</span>
							</div>
							<div data-user_online="false">
							<input type="checkbox" id=""/>
							<img src="../resources/content_consumption/icons/Stella.png" height="40px" width="40px"> <span>Stella</span>
							</div>
							<div data-user_online="false">
							<input type="checkbox" id=""/>
							<img src="../resources/content_consumption/icons/Nisha.png" height="40px" width="40px"> <span>Nisha</span>
							</div>
						</div>
						<hr/>
						<button onclick="$(this).parent().hide(); alert('Question sent to the selected recipients.')">Send</button><button onclick="$(this).parent().hide();">Cancel</button>
						
					</div>
					<!-- Circles -->
					<div id="circles_container" data-tabpane="circles">
						<span class="column_title">Online Classmates</span>
						<div class="chatbox_user">
							<img src="../resources/content_consumption/icons/Aron.png" height="40px" width="40px"> <span>Aaron</span>
						</div>
						<div class="chatbox_user online">
							<img src="../resources/content_consumption/icons/Stella.png" height="40px" width="40px"> <span>Stella</span> 
						</div>
						<div class="chatbox_user">
							<img src="../resources/content_consumption/icons/Nisha.png" height="40px" width="40px"> <span>Nisha</span>
						</div>
						
						
						<div id="chatboxes_container">
							<div class="chatbox">
								<div class="chat_header">
									<div class="chat_buddy_thumbnail"><img src="../resources/content_consumption/icons/Aron.png"></div>
									<div class="chat_buddy_name">Aron</div>
									<div class="chatbox_minimize" title="Minimize"></div>
									<div class="chatbox_popout" title="Popout"></div>
									<div class="chatbox_close" title="Close"></div>
								</div>
								<div class="chat_options">
									<div class="video_chat"></div>
									<div class="voice_chat"></div>
									<div class="add_buddies"></div>
									<div style="width: 160px;"></div>

								</div>
								<div class="chat_column"></div>
								<div class="chat_bar">
									<input type="text" class="chat_text" value="">
								</div>
							</div>
						</div>
						
					</div>

				</div>
			</div>
		</section>

		<!--End Main Content-->


		<footer> </footer>

	</div>

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
		<img src="../resources/content_consumption/icons/starbook.png" width="10px" height="10px" /> \
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
		<img src="../resources/content_consumption/icons/note_16.png"  width="10px" height="10px" /> \
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

function  unhighlight_tab(tabname){
	$('[data-tab="'+tabname+'"]').removeClass('hover_state');
}

</script>
</body>
</html>
