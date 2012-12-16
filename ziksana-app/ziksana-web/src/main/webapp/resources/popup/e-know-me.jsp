<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../images/ziksana-icon.png" rel="shortcut icon" />
<link rel="stylesheet" type="text/css" media="screen"
	href="../css/basic-styles.css" />
<link rel="stylesheet" type="text/css"
	href="../css/custom-theme/old-jquery-ui-1.8.21.custom.css">
<link rel="stylesheet" type="text/css"
	href="../css/custom-theme/jquery-ui-1.8.21.custom.css">
<link rel="stylesheet" type="text/css" media="screen"
	href="../css/type-setting.css" />

<script src="../js/jquery-1.7.2.min.js"></script>

<script src="../js/ui/jquery.ui.core.js"></script>
<script src="../js/ui/jquery.ui.widget.js"></script>
<script src="../js/ui/jquery.ui.tabs.js"></script>
<script src="../js/ui/jquery.ui.progressbar.js"></script>
<script src="../js/ui/jquery.ui.button.js"></script>
<!--topup-->

<script>
	$(function() {

		$("button").button();
		$("button, input:submit", ".action-row").button();
		$("button:first", ".course-button-bar").button({
			icons : {
				secondary : "ui-icon-pencil"
			}
		}).next().button({
			icons : {
				secondary : "ui-icon-wrench"
			}
		}).next().button({
			icons : {
				secondary : "ui-icon-signal-diag"
			}
		});
		$("#radio-1, #radio-2, #radio-3, #format").buttonset();

	});

	function nextquest1() {
		$('#quest2').show();
		$('#btnpre').show();
		$('#quest1').hide();
		$('#quest3').hide();
	}
	function nextquest2() {
		$('#btnpre').show();
		$('#quest2').hide();
		$('#btnpre').show();
		$('#quest1').hide();
		$('#quest3').show();
	}

	function prevquest1() {
		$('#btnpre').hide();
		$('#quest2').hide();
		$('#quest3').hide();
		$('#quest1').show();
	}

	function prevquest2() {
		$('#btnpre').show();
		$('#quest1').hide();
		$('#quest3').hide();
		$('#quest2').show();
		$('#btnnxt').show();
	}

	function disque2() {
		$('#td1').css("background-color", " #ffffff");
		$('#td2').css("background-color", " #DAE8F2");
		$('#td3').css("background-color", " #ffffff");

	}
	function disque3() {
		$('#td1').css("background-color", " #ffffff");
		$('#td2').css("background-color", " #ffffff");
		$('#td3').css("background-color", " #DAE8F2");

	}
	function disque1() {

		$('#td1').css("background-color", " #DAE8F2");
		$('#td2').css("background-color", " #ffffff");
		$('#td3').css("background-color", " #ffffff");

	}

	function closeit() {
		parent.jQuery.fancybox.close();

	}

	function answer() {
		var bgcol = $('#td1').css('backgroundColor');
		var bgco2 = $('#td2').css('backgroundColor');
		var bgco3 = $('#td3').css('backgroundColor');

		if ((bgcol != "rgb(218, 232, 242)") && (bgco2 != "rgb(218, 232, 242)")
				&& (bgco3 != "rgb(218, 232, 242)")) {
			alert('Please Select a Question and Click on Details');
		} else if (bgcol == "rgb(218, 232, 242)") {
			$('#disque2').hide();
			$('#disque3').hide();
			$('#disque1').show();
		} else if (bgco2 == "rgb(218, 232, 242)") {
			$('#disque1').hide();
			$('#disque3').hide();
			$('#disque2').show();
		} else if (bgco3 == "rgb(218, 232, 242)") {
			$('#disque1').hide();
			$('#disque2').hide();
			$('#disque3').show();
		}
	}

	function submit1() {
		var x1 = document.getElementById("red").checked;
		var y1 = document.getElementById("red1").checked;
		if ((y1 == true) || ((x1 == true))) {
			alert('Answer submited');
		} else {
			alert('Please select an answer and press submit button');
		}
	}

	function submit3() {
		var x = document.getElementById("blue").checked;
		var y = document.getElementById("blue1").checked

		if ((y == true) || ((x == true))) {
			alert('Answer submited');
		} else {
			alert('Please select an answer and press submit button');
		}
	}
	function submit2() {
		var z = document.getElementById("que").checked;
		var z1 = document.getElementById("que1").checked;
		var z2 = document.getElementById("que2").checked;
		var z3 = document.getElementById("que3").checked;
		var z4 = document.getElementById("que4").checked;
		var z5 = document.getElementById("que5").checked;

		if ((z == true) || (z1 == true) || (z2 == true) || (z3 == true)
				|| (z4 == true) || (z5 == true)) {
			alert('Answer submited');
		} else {
			alert('Please select an answer and press submit button');
		}

	}
</script>
<script type="text/javascript">
	function change(value) {
		var x = value;
		if (x == 2) {
			$('.new-que').hide();
			$('.pre-que').show();
		} else {
			$('.new-que').show();
			$('.pre-que').hide();
		}

	}
	function subans() {
		alert("Answer submitted successfully");
	}
</script>

<style>
body {
	background: #fff;
}

input,select,textarea {
	color: #555;
	font-weight: normal !important;
	padding: 3px;
	font-size: 1.2em !important;
	font-family: Arial, Helvetica, sans-serif !important;
}

.pre-que {
	width: 400px;
	display: none;
}

#tabq {
	width: 400px;
	height: 150px;
	overflow: auto;
}

.new-que {
	width: 400px;
	height: 300px;
}

.quest-table {
	border: 1px solid black;
}

.quest-table1 {
	background-color: grey;
	color: black;
	border: 1px solid black;
}

#quest2,#quest3,#disque2,#disque3,#disque1 {
	display: none;
}

#btn {
	margin: 10px;
	padding: 2px
}

#btnpre {
	margin: 10px;
	padding: 2px
}

#btnnxt {
	margin: 10px;
	padding: 2px
}

.knowmetop {
	padding: 10px;
	background-color: #DAE8F2;
}
</style>
</head>

<body>
	<p></p>
	<table style="width: 600px;">
		<tr>
			<td colspan=2><img align="left"
				style="margin-right: 10px; margin-top: 6px; margin-right: 5px; height: 20px; width: 20px; padding-left: 5px;"
				src="../images/icons/helpicon.png">
				<div class="knowmetop">You can answer a few personality
					questions to help us undersatnd you better..</div> <!--
    <img class="knowme" src="../images/icons/zicons2.png" width="1" height="1" /><h2 class="bld c369 Slogen-one" style="font-size:1em;">You can answer a few personality questions to help us undersatnd you better..</h2><br>
--></td>
		</tr>
		<tr>
			<td width="33%" style="vertical-align: top;"><p>
					<img src="../images/hero-knb.jpg" width="249" height="200"
						alt="Guru">
				</p>
				<p style="font-size: 1.8em;" class="Slogen-one">Know me better?</p>
				<p style="font-size: 1.2em">
					<br> Helps put more effective tools in your hands
				</p> <br>
				<h2 class="bld c369">&nbsp;</h2></td>
			<td width="66%" style="vertical-align: top;">

			<!-- Know me Better -->
			
 
 
  <script type="text/javascript">
  
$(document).ready(function() {
	$.ajax({
		  	type: 'GET',
			url: '/secure/getansweredquestions',
			dataType: 'xml',
			success: function( data ) {
					if (console && console.log){
								console.log( 'Questions :', data);
					}
					 var outputAnswered="";
					 var outputChoice="";
					
					
					$(data).find("answered").each(function(index){
						outputAnswered+="<form>";
						outputAnswered+="<select onchange='change(this.value)'>";
						outputAnswered+="<option >"+$(this).find("text").text()+"</option>";
													
						$(data).find("choice").each(function(index){
						
						outputChoice+="<input type='radio' id='radio1' name='radio' />";
						outputChoice+="<label for='radio1'>"+$(this).find("choicetext").text()+"</label>";
						
						
						});
						
					});

					console.log("Knowme Better: " + outputUnAnswered); 
					console.log("Knowme Better: " + outputChoice);
				
					$('#select_que').html(outputAnswered);
					
					
					
			}
	});
	
});
</script>
			<!-- End -->

				<div id="select_que">
<!-- 
					<form>
						<select onchange="change(this.value)">
							<option value="1">Show Me - New Questions</option>
							<option value="2">Show Me – Previously Answered</option>

						</select>
					</form>
 -->				</div>










				</div> <br />
				<div class="pre-que">



					<div id="tabq">
						<table class="quest-table" border=1>
							<tr>
								<th class="quest-table1" width="200px">Question</th>
								<th class="quest-table1" width="60px">Date Answered</th>
							</tr>
							<tr>
								<td class="quest-table" id="td1"><label id="question1"
									onclick="disque1()">Question1....</input></td>

								<td class="quest-table">10/1/2012</td>
							</tr>
							<tr>
								<td class="quest-table" id="td2"><label id="question2"
									onclick="disque2()">Question2....</label></td>

								<td class="quest-table">10/12/2012</td>
							</tr>
							<tr>
								<td class="quest-table" id="td3"><label id="question3"
									onclick="disque3()">Question3.....</label></td>

								<td class="quest-table">10/18/2012</td>
							</tr>



						</table>

					</div>
					<br /> <br /> <a class="f-rt" style="color: blue;" href="#"
						onclick="answer()">Details</a> <br />



					<div id="disque1">
						<hr>
						<p>View or update the Answer:</p>
						<br /> Q: Are you the first one to make a Conversation? <br />

						<form>

							<input type="radio" name="q1" checked="checked" value="Yes">Yes<br>

							<input type="radio" name="q1" id="q1" value="No">No

						</form>

					</div>
					<div id="disque2">
						<hr>
						<p>View or update the Answer:</p>

						Q: Which is your favourite Color? <br />
						<form action="">
							<table width="180px" height="50px">
								<tr>
									<td><INPUT TYPE=CHECKBOX NAME="Black">Black<BR>
										<INPUT TYPE=CHECKBOX NAME="red"> Red<BR> <INPUT
										TYPE=CHECKBOX NAME="all">All<BR></td>


									<td><INPUT TYPE=CHECKBOX NAME="white">White<BR>
										<INPUT TYPE=CHECKBOX NAME="green">Green<BR> <INPUT
										TYPE=CHECKBOX NAME="all">None<BR></td>
								</tr>
							</table>
						</form>
					</div>
					<div id="disque3">
						<hr>
						<p>View or update the Answer:</p>
						<br /> Q: You enjoy having a wide circle of acquaintances? <br />
						<form action="">

							<input type="radio" name="q2" id="q2" value="Yes">Yes<br>

							<input type="radio" name="q2" id="q2" value="No">No

						</form>
					</div>

					<br /> <br />
					<button onclick="closeit()" class="f-rt">Return</button>
					<button onclick="subans()" class="f-rt">Submit Revisions</button>
				</div>


				<div class="new-que">
					<br />
					<div id="quest1">
						Q: Are you the first one to make a Conversation? <br />
						<br />
						<form action="">
							<table width="180px" height="30px">
								<tr>
									<td><input type="radio" name="q1" checked="checked"
										id="red" value="Yes">Yes<br></td>
								</tr>
								<tr>
									<td><input type="radio" name="q1" id="red1" value="No">No
									</td>
								</tr>
							</table>
						</form>
						<br /> <br /> <br /> <br />
						<button class="f-rt" id="btnnxt" onclick="nextquest1()">Next
							>></button>
						<button class="f-rt" id="btn" onclick="submit1()">Submit</button>



					</div>
					<div id="quest2">
						Q: Which is your favourite Color? <br />
						<br />
						<form action="">
							<table width="180px" height="50px">
								<tr>
									<td><INPUT id="que" TYPE=CHECKBOX value="1" NAME="Black">Black<BR>
										<INPUT id="que1" TYPE=CHECKBOX value="2" NAME="red">
										Red<BR> <INPUT id="que2" TYPE=CHECKBOX value="3"
										NAME="all">All<BR></td>


									<td><INPUT id="que3" TYPE=CHECKBOX value="4" NAME="white">White<BR>
										<INPUT id="que4" TYPE=CHECKBOX value="5" NAME="green">Green<BR>
										<INPUT id="que5" TYPE=CHECKBOX value="6" NAME="all">None<BR>
									</td>
								</tr>
							</table>
						</form>

						<br /> <br /> <br /> <br />
						<button class="f-rt" id="btnnxt" onclick="nextquest2()">Next
							>></button>
						<button class="f-rt" id="btn" onclick="submit2()">Submit</button>
						<button id="btnpre" onclick="prevquest1()" class="f-rt"><<
							Previous</button>

					</div>
					<div id="quest3">
						Q: You enjoy having a wide circle of acquaintances? <br />
						<br />
						<form action="">
							<table width="180px" height="30px">
								<tr>
									<td><input type="radio" name="q2" checked="checked"
										id="blue" value="Yes">Yes<br></td>
								</tr>
								<tr>
									<td><input type="radio" name="q2" id="blue1" value="No">No
									</td>
								</tr>
							</table>
						</form>
						<br /> <br />
						<hr>
						<br />
						<button class="f-rt" id="btn" onclick="submit3()">Submit</button>

						<button id="btnpre" onclick="prevquest2()" class="f-rt">
							<< Previous</button>

					</div>
					<br />
					<br />






				</div>



			</td>

		</tr>
	</table>
	<SCRIPT>
		$('input[type="text"], textarea').each(function() {

			this.value = $(this).attr('title');
			$(this).addClass('text-label');

			$(this).focus(function() {
				if (this.value == $(this).attr('title')) {
					this.value = '';
					$(this).removeClass('text-label');
				}
			});

			$(this).blur(function() {
				if (this.value == '') {
					this.value = $(this).attr('title');
					$(this).addClass('text-label');
				}
			});
		});
	</SCRIPT>
</body>
</html>
