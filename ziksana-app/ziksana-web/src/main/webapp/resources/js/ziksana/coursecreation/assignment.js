// JavaScript Document

$(document).ready(function(e) {

	// validation for the forms
	jQuery("#DefineAssignment").validationEngine();
	jQuery("#AddTest").validationEngine();

	// for texteditor hide and show
	$('._plainText').hide();
	$('._richTextShow').hide();

	$('._richText').click(function() {
		$('._richText').hide();
		$('._plainTextShow').hide();
		$('._plainText').show();
		$('._richTextShow').show();
		CKEDITOR.replace('Assign_descrte');
		CKEDITOR.replace('Test_descrte');
	});

	$('._plainText').click(function() {
		$('._richText').show();
		$('._plainTextShow').show();
		$('._plainText').hide();
		$('._richTextShow').hide();
	});

	// cancel button hide show on define assignment

	$(".cancellinkdefineassignment").click(function(e) {
		$("#vwassignment").hide();
		$("#vwaddtest").hide();
		$("#vwassociate").hide();
		$("#vwdefine").hide();
		$("#editassignment").hide();
	});

	$("#associaterich").click(function(e) {
		CKEDITOR.replace('_associateques_assignment');
	});

	// hide show arrow for security content
	$('#showSecurity').hide();
	$('#aDown').hide();

	$('#aSide').click(function() {
		$('#showSecurity').slideDown();
		$('#aSide').hide();
		$('#aDown').show();
	});

	$('#aDown').click(function() {
		$('#showSecurity').slideUp();
		$('#aSide').show();
		$('#aDown').hide();
	});

	$('#_contentsecurity').hide();
	$('#aDowncontent').hide();

	$('#aSidecontent').click(function() {
		$('#_contentsecurity').slideDown();
		$('#aSidecontent').hide();
		$('#aDowncontent').show();
	});

	$('#aDowncontent').click(function() {
		$('#_contentsecurity').slideUp();
		$('#aSidecontent').show();
		$('#aDowncontent').hide();
	});

	// all Question stuff from Define Assignment

	$('#_QuesTrueFalse').hide();
	$('#_QuesMultiChoicesingle').hide();
	$('#_QuesMultiChoicemulti').hide();
	$('#_Quesorderingchoice').hide();
	$('#_QuesMatchfollowing').hide();
	$('#_QuesFillBlanks').hide();
	$('#_QuesJumbledques').hide();
	$('#_QuesDescriptive').hide();
	$('#_QuesMaths').hide();
	$('#_QuesFrame').hide();

	$('#_QuesSelect').change(function() {
		if ($('#_QuesSelect').val() == "True/False") {
			$('#_QuesTrueFalse').slideDown("");
			$('#_QuesMultiChoicesingle').hide();
			$('#_QuesMultiChoicemulti').hide();
			$('#_Quesorderingchoice').hide();
			$('#_QuesMatchfollowing').hide();
			$('#_QuesFillBlanks').hide();
			$('#_QuesJumbledques').hide();
			$('#_QuesDescriptive').hide();
			$('#_QuesMaths').hide();
			$('#_QuesFrame').hide();

		}

		else if ($('#_QuesSelect').val() == "MultiChoiceSingle") {

			$('#_QuesMultiChoicesingle').slideDown("");
			$('#_QuesTrueFalse').hide();
			$('#_QuesMultiChoicemulti').hide();
			$('#_Quesorderingchoice').hide();
			$('#_QuesMatchfollowing').hide();
			$('#_QuesFillBlanks').hide();
			$('#_QuesJumbledques').hide();
			$('#_QuesDescriptive').hide();
			$('#_QuesMaths').hide();
			$('#_QuesFrame').hide();

		}

		else if ($('#_QuesSelect').val() == "MultiChoiceMulti") {

			$('#_QuesMultiChoicemulti').slideDown("");
			$('#_QuesTrueFalse').hide();
			$('#_QuesMultiChoicesingle').hide();
			$('#_Quesorderingchoice').hide();
			$('#_QuesMatchfollowing').hide();
			$('#_QuesFillBlanks').hide();
			$('#_QuesJumbledques').hide();
			$('#_QuesDescriptive').hide();
			$('#_QuesMaths').hide();
			$('#_QuesFrame').hide();

		}

		else if ($('#_QuesSelect').val() == "OrderingChoices") {

			$('#_Quesorderingchoice').slideDown("");
			$('#_QuesTrueFalse').hide();
			$('#_QuesMultiChoicesingle').hide();
			$('#_QuesMultiChoicemulti').hide();
			$('#_QuesMatchfollowing').hide();
			$('#_QuesFillBlanks').hide();
			$('#_QuesJumbledques').hide();
			$('#_QuesDescriptive').hide();
			$('#_QuesMaths').hide();
			$('#_QuesFrame').hide();

		}

		else if ($('#_QuesSelect').val() == "MatchFollowing") {

			$('#_QuesMatchfollowing').slideDown("");
			$('#_QuesTrueFalse').hide();
			$('#_QuesMultiChoicesingle').hide();
			$('#_QuesMultiChoicemulti').hide();
			$('#_Quesorderingchoice').hide();
			$('#_QuesFillBlanks').hide();
			$('#_QuesJumbledques').hide();
			$('#_QuesDescriptive').hide();
			$('#_QuesMaths').hide();
			$('#_QuesFrame').hide();

		}

		else if ($('#_QuesSelect').val() == "FillBlanks") {

			$('#_QuesFillBlanks').slideDown("");
			$('#_QuesTrueFalse').hide();
			$('#_QuesMultiChoicesingle').hide();
			$('#_QuesMultiChoicemulti').hide();
			$('#_Quesorderingchoice').hide();
			$('#_QuesMatchfollowing').hide();
			$('#_QuesJumbledques').hide();
			$('#_QuesDescriptive').hide();
			$('#_QuesMaths').hide();
			$('#_QuesFrame').hide();

		}

		else if ($('#_QuesSelect').val() == "JumbledSequence") {

			$('#_QuesJumbledques').slideDown("");
			$('#_QuesTrueFalse').hide();
			$('#_QuesMultiChoicesingle').hide();
			$('#_QuesMultiChoicemulti').hide();
			$('#_Quesorderingchoice').hide();
			$('#_QuesMatchfollowing').hide();
			$('#_QuesFillBlanks').hide();
			$('#_QuesDescriptive').hide();
			$('#_QuesMaths').hide();
			$('#_QuesFrame').hide();

		}

		else if ($('#_QuesSelect').val() == "Descriptive") {

			$('#_QuesDescriptive').slideDown("");
			$('#_QuesTrueFalse').hide();
			$('#_QuesMultiChoicesingle').hide();
			$('#_QuesMultiChoicemulti').hide();
			$('#_Quesorderingchoice').hide();
			$('#_QuesMatchfollowing').hide();
			$('#_QuesFillBlanks').hide();
			$('#_QuesJumbledques').hide();
			$('#_QuesMaths').hide();
			$('#_QuesFrame').hide();

		}

		else if ($('#_QuesSelect').val() == "Mathematical") {

			$('#_QuesMaths').slideDown("");
			$('#_QuesTrueFalse').hide();
			$('#_QuesMultiChoicesingle').hide();
			$('#_QuesMultiChoicemulti').hide();
			$('#_Quesorderingchoice').hide();
			$('#_QuesMatchfollowing').hide();
			$('#_QuesFillBlanks').hide();
			$('#_QuesJumbledques').hide();
			$('#_QuesDescriptive').hide();
			$('#_QuesFrame').hide();

		}

		else if ($('#_QuesSelect').val() == "FrameQuestions") {

			$('#_QuesFrame').slideDown("");
			$('#_QuesTrueFalse').hide();
			$('#_QuesMultiChoicesingle').hide();
			$('#_QuesMultiChoicemulti').hide();
			$('#_Quesorderingchoice').hide();
			$('#_QuesMatchfollowing').hide();
			$('#_QuesFillBlanks').hide();
			$('#_QuesJumbledques').hide();
			$('#_QuesDescriptive').hide();
			$('#_QuesMaths').hide();

		}

	});

	// Assignment Options

	$('#_describeassignment').hide();
	$('#_viewassignment').hide();
	$('#_addtest').hide();
	$('._associatequestion').hide();

	$('#_nodedefineassignment').click(function() {
		$('#_viewassignment').hide();
		$('#_addtest').hide();
		$('._associatequestion').hide();
		$('#_describeassignment').slideToggle('showOrHide');
	});

	$('#_nodedefineassignment').mouseover(function() {
		$('#_viewassignment').hide();
		$('#_addtest').hide();
		$('._associatequestion').hide();
		$('#_describeassignment').slideToggle('showOrHide');

	});

	$('#_nodeviewassignment').click(function() {
		$('#_describeassignment').hide();
		$('#_addtest').hide();
		$('._associatequestion').hide();
		$('#_viewassignment').slideToggle('showOrHide');
	});

	$('#_nodeviewassignment').mouseover(function() {
		$('#_describeassignment').hide();
		$('#_addtest').hide();
		$('._associatequestion').hide();
		$('#_viewassignment').slideToggle('showOrHide');
	});

	$('#_nodeaddtest').click(function() {
		$('#_viewassignment').hide();
		$('#_describeassignment').hide();
		$('._associatequestion').hide();
		$('#_addtest').slideToggle('showOrHide');
	});

	$('#_nodeaddtest').mouseover(function() {
		$('#_viewassignment').hide();
		$('#_describeassignment').hide();
		$('._associatequestion').hide();
		$('#_addtest').slideToggle('showOrHide');

	});

	$('#_nodeassociatequestion').click(function() {
		$('#_viewassignment').hide();
		$('#_describeassignment').hide();
		$('#_addtest').hide();
		$('._associatequestion').slideToggle('showOrHide');
	});

	$('#_nodeassociatequestion').mouseover(function() {
		$('#_viewassignment').hide();
		$('#_describeassignment').hide();
		$('#_addtest').hide();
		$('._associatequestion').slideToggle('showOrHide');

	});

	$('#_exitviewassignment').click(function() {
		$('#_viewassignment').hide();

	});

	$('#_canceldescribeassignment').click(function() {
		$('#_describeassignment').hide();

	});

	$('#_btnsearchaddquestioncancel').click(function() {
		$.fancybox - close();

	});

}); // end of document.ready

