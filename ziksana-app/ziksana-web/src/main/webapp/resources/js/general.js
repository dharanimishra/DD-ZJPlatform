var labid="";
function getValues(){
		document.getElementById('draggable').innerHTML = document.getElementById("Enter_titleval").value;		
}

function strStartsWith(str, prefix) {
	return str.indexOf(prefix) === 0;
}

$(function() {
		$( "ul.droptrue" ).sortable({
			connectWith: "ul"
		});

		$( "ul.dropfalse" ).sortable({
			connectWith: "ul",
			dropOnEmpty: false
		});

		$( "#sortable0, #sortable1" ).disableSelection();
});

$('#addnewinfo span').live('mouseover', function(e) {
		labid = $(this).attr("id"); 
		$("#del1").css('left', e.pageX-435);
		$("#del1").css('top', e.pageY-225);
		$("#del1").css('display','block');					
	});
	
function dellabel(){
	$("#"+labid).remove();
	$('#addnewinfo').load();
	$("#del1").hide();
}

$(document).ready(function(){
$(".collapse").collapse({
	show: function(){
		this.animate({
		opacity: 'toggle', 
		height: 'toggle'
		}, 300);
    },
    hide : function() {
		this.animate({
		opacity: 'toggle', 
		height: 'toggle'
		}, 300);
    }
});
       
//rating-star	
$('#edu-star').raty({
	click: function(score, evt) {
		$(this).fadeOut(function() { $(this).fadeIn(); });
	},
	targetKeep	: true,
	path:'images/img/',
	score: 4,
	cancel: true
});
});
