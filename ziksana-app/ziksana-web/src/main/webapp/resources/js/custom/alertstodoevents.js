// JavaScript Document
$(document).ready(function(e) {
$(".contentareaevent").hide();
$(".contentareaalrt").hide();
$(".contentareatodo").hide();  
//$(".todocontainer").hide();

$(".tagalert").click(function(e) {
	$(".contentareaevent").hide();
	$(".contentareatodo").hide();
    $(".contentareaalrt").slideDown(200); 
});  

$(".tagevent").click(function(e) {
	 $(".contentareaalrt").hide(); 
	 $(".contentareatodo").hide();
    $(".contentareaevent").slideDown(200); 
});

$(".tagtask").click(function(e) {
	 $(".contentareaalrt").hide(); 
    $(".contentareaevent").hide();
	$(".contentareatodo").slideDown(200);
});



	



});
