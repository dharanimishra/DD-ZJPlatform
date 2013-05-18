// JavaScript Document
$(document).ready(function(e) {
$(".contentareaalrt").hide();
$(".contentareatodo").hide();
$(".contentareamanagetodo").hide(); 
$("#todotype").hide(); 
 $("#addtodorow").hide(); 
//$(".todocontainer").hide();




$(".addtodobtn").click(function(e) {
    $("#addtodorow").toggle(200); 
});



$(".tagevent").click(function(e) {
	 $(".contentareaalrt").slideUp(200); 
	 $(".contentareatodo").slideUp(200);
	 $(".contentareamanagetodo").slideUp(500);
    $(".contentareaevent").slideDown(500); 
});

$(".tagtask").click(function(e) {
	 $(".contentareaalrt").slideUp(200); 
    $(".contentareaevent").slideUp(200);
	$(".contentareamanagetodo").slideUp(500);
	$(".contentareatodo").slideDown(500);
	
});

  var hoverHTMLDemoBasic = '' + 'We welcome you to join us on our seminar on Artificial intelligence. ';
$("#demo-basic").hovercard({
        detailsHTML: hoverHTMLDemoBasic,
        width: 300,
        cardImgSrc: 'http://1.gravatar.com/avatar/30f5be9e9d9b2d0206a08407310759be?s=90&d=http%3A%2F%2F1.gravatar.com%2Favatar%2Fad516503a11cd5ca435acc9bb6523536%3Fs%3D90&r=G'
    });


$(".managetodo").click(function(e) {
	 $(".contentareaalrt").slideUp(200); 
    $(".contentareaevent").slideUp(200);
	$(".contentareatodo").slideUp(200);
	$(".contentareamanagetodo").slideDown(500);
	});

	
$("#todocategoryddl").change(function(e) {
    if($("#todocategoryddl").val() == "Other")
	{
		$("#todocategoryddl").hide();
		$("#todotype").show();
		
	}
	
	
	});
	
	
if($("#todocategoryddl").val() == "University")
	{
		$("#todosave").click(function(e) {
            var val1 = $("#todocategoryddl").val();
			var val2 = $("#todotype").val();
			var val3 = $("#tododescription").val();
			if(val2 == "")
			{
				$(".eventdata").prepend(' <tr> <td><input type="checkbox" id="c1" name="cc" /> <label for="c1"><span></span></label></td> <td>'+val1+'</td><td>'+val3+'</td><td></td></tr>');
			}
			else
			{
				$(".eventdata").prepend(' <tr> <td><input type="checkbox" id="c1" name="cc" /> <label for="c1"><span></span></label></td> <td>'+val2+'</td><td>'+val3+'</td><td></td></tr>');
			}
        });
	}
		
	

});


