$(document).ready(function(e) {
		var counter = 2;
		var a = 1;
	//$("#delete").hide();
	// Adds choice when clicked on the add choice button on multichoice single
    $("#addmultisingle").click(function(e) {
			
        $("#controls_QuesMultiChoicesingle").append('<tr id=multisinglerows><td><input type="text" class="defaultvalue" placeholder="Enter your Choice" style="width:400px;"/></td><td><input name="answertype" type="radio"></td><td><label class="labelclass" for="Correct Answers" >Choose the Correct Asnwer</label></td><td><a href="#linkurl" id=Delete'+counter+'><img src="../images/delete.jpg" height="12px" width="12px"/></a></td></tr>');
	
	
	$("#Delete"+counter).click(function(e) {
		
        $("#multisinglerows").remove();
    });
	counter++;
	});
	
	
	// Adds choice when clicked on the add choice button on multi choice multi
    $("#addmultimulti").click(function(e) {
        $("#controls_QuesMultiChoicemulti").append('<tr id=multirows><td><input type="text" class="defaultvalue" placeholder="Enter your Choice" style="width:400px;"/></td><td style="margin-top:-5px;"><input name="answertype" type="checkbox" value="True" checked="checked" ></td><td style="margin-top:-5px;"><label class="labelclass" for="Correct Answers" >Choose the Correct Asnwer</label></td> <td><a href="#linkurl" id=Delete'+counter+'><img src="../images/delete.jpg" height="12px" width="12px"/></a></td>    </tr> ');
    
	
	$("#Delete"+counter).click(function(e) {
        $("#multirows").remove();
    });
	counter++;
	});
	
	
	// Adds choice when clicked on the add choice button on ordering choice
    $("#Addorderingchoice").click(function(e) {
        $("#controls_Quesorderingchoice").append('<tr id=orderingchoicerows><td><input type="text" class="defaultvalue" placeholder="Enter your Choice" style="width:400px;" /></td><td style="margin-top:-5px;"><span style="margin-left:10px; margin-top:10px; color:#69F;"> Default Choice </span></td><td><a href="#linkurl" id=Delete'+counter+'><img src="../images/delete.jpg" height="12px" width="12px"/></a></td>     </tr>');
   
	$("#Delete"+counter).click(function(e) {
        $("#orderingchoicerows").remove();
    });
	counter++;
	});
	
	
	
	// Adds question when clicked on the add choice button on match the follwing
    $("#Addmatchfollowingquestion").click(function(e) {
		a++;
        $("#controls_QuesMatchfollowingfirst").append('<tr id=matchquestionrows><td><span style="margin-top:10px; color:#69F;"> Q-'+a+' </span></td><td><input type="text" class="defaultvalue" placeholder="Enter the Question" style="width:160px;"/></td><td><a href="#linkurl" id=Delete'+counter+'><img src="../images/delete.jpg" height="12px" width="12px"/></a></td></tr>');
	
	$("#Delete"+counter).click(function(e) {
        $("#matchquestionrows").remove();
    });
	counter++;
	});
	
	
	
	// Adds answer when clicked on the more answers choice button on match the follwing
    $("#Addmatchfollowinganswer").click(function(e) {
        $("#controls_QuesMatchfollowingsecond").append('<tr id=matchfollowingrows>  <td><input type="text" class="defaultvalue" placeholder="Enter the Answer" style="width:120px;" /> </td>  <td><select name="SelectArea" class="defaultvalue labelclass" style="width:190px; margin-left:5px; font-size:11px; padding:5px;"> <option>Select the Matching Question </option></select> </td> <td><a href="#linkurl" id=Delete'+counter+'><img src="../images/delete.jpg" height="12px" width="12px"/></a></td></tr>');
	
	$("#Delete"+counter).click(function(e) {
        $("#matchfollowingrows").remove();
    });
	counter++;
	});
	
	
	
	// Adds input for keyword for auto grading and adds drop down for specifying its weight
    $("#Addgradedescriptive").click(function(e) {
        $("#controls_QuesDescriptive").append('<tr id=descriptiverows> <td><input type="text" class="defaultvalue" placeholder="Enter keywords for Autograding" tabindex="" style="width:295px;" /> </td> <td><select name="SelectArea" class="defaultvalue labelclass" style="width:205px; margin-left:5px; font-size:12px; padding:5px;"> <option>Select Keyword Weight </option><option>1 </option><option>2 </option><option>3 </option><option>4 </option><option>5 </option><option>6 </option><option>7 </option>              <option>8 </option><option>9 </option><option>10</option></select> </td><td><a href="#linkurl" id=Delete'+counter+'><img src="../images/delete.jpg" height="12px" width="12px"/></a></td></tr>');

	
	$("#Delete"+counter).click(function(e) {
        $("#descriptiverows").remove();
    });
		counter++;
	});
});