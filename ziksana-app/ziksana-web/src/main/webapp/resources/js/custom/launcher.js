// JavaScript Document

$(document).ready(function(e) {
	
	
	  var hoverHTMLDemoBasic = '' + 'We welcome you to join us on our seminar on Artificial intelligence. ';
$("#demo-basic").hovercard({
        detailsHTML: hoverHTMLDemoBasic,
        width: 300,
        //cardImgSrc: 'http://1.gravatar.com/avatar/30f5be9e9d9b2d0206a08407310759be?s=90&d=http%3A%2F%2F1.gravatar.com%2Favatar%2Fad516503a11cd5ca435acc9bb6523536%3Fs%3D90&r=G'
    });
	
$("#demo-basic3").hovercard({
        detailsHTML: hoverHTMLDemoBasic,
        width: 300,
		height: 600,
        //cardImgSrc: 'http://1.gravatar.com/avatar/30f5be9e9d9b2d0206a08407310759be?s=90&d=http%3A%2F%2F1.gravatar.com%2Favatar%2Fad516503a11cd5ca435acc9bb6523536%3Fs%3D90&r=G'
    });
	
	  
$("#demo-basic2").hovercard({
        detailsHTML: hoverHTMLDemoBasic,
        width: 300,
        //cardImgSrc: 'http://1.gravatar.com/avatar/30f5be9e9d9b2d0206a08407310759be?s=90&d=http%3A%2F%2F1.gravatar.com%2Favatar%2Fad516503a11cd5ca435acc9bb6523536%3Fs%3D90&r=G'
    });
	
	
	
$("#demo-basictodo1").hovercard({
        detailsHTML: hoverHTMLDemoBasic,
        width: 300,
        //cardImgSrc: 'http://1.gravatar.com/avatar/30f5be9e9d9b2d0206a08407310759be?s=90&d=http%3A%2F%2F1.gravatar.com%2Favatar%2Fad516503a11cd5ca435acc9bb6523536%3Fs%3D90&r=G'
    });
	
	    
$("#demo-basictodo2").hovercard({
        detailsHTML: hoverHTMLDemoBasic,
        width: 300,
        //cardImgSrc: 'http://1.gravatar.com/avatar/30f5be9e9d9b2d0206a08407310759be?s=90&d=http%3A%2F%2F1.gravatar.com%2Favatar%2Fad516503a11cd5ca435acc9bb6523536%3Fs%3D90&r=G'
    });
	
$("#demo-basictodo3").hovercard({
        detailsHTML: hoverHTMLDemoBasic,
        width: 300,
        //cardImgSrc: 'http://1.gravatar.com/avatar/30f5be9e9d9b2d0206a08407310759be?s=90&d=http%3A%2F%2F1.gravatar.com%2Favatar%2Fad516503a11cd5ca435acc9bb6523536%3Fs%3D90&r=G'
    });
	
	
	
	$(".quitlink").click(function(e) {
		window.open('login.html');
		//window.location.href = "login.html";
	});
	
	
	//$(".elementlinks").empty();
		$("._cLeft").show();
		$("._cMiddle").show();
		$("._cRight").show();
		$(".todo").hide();
		$(".alert_todo").hide();
	
	$("#calendarlink").hide();
	 $('#alertlink').show();
	  $('#todolink').show();
	 
	 $("#alertlink").click(function(e) {
	 	$('#alertlink').hide();
        $("#calendarlink").show();
	  	$('#todolink').show();
		$("._cLeft").hide();
		$("._cMiddle").hide();
		$("._cRight").hide();
		$(".todo").hide();
		$(".alert_todo").show();
    });
	
	$("#todolink").click(function(e) {
	 	$('#alertlink').show();
        $("#calendarlink").show();
	  	$('#todolink').hide();
		$("._cLeft").hide();
		$("._cMiddle").hide();
		$("._cRight").hide();
		$(".alert_todo").hide();
		$(".todo").show();
    });
	
	$("#calendarlink").click(function(e) {
	 	$('#alertlink').show();
        $("#calendarlink").hide();
	  	$('#todolink').show();
		$(".todo").hide();
		$(".alert_todo").hide();
		$("._cLeft").show();
		$("._cMiddle").show();
		$("._cRight").show();
    });
	
	
	
	
	
});