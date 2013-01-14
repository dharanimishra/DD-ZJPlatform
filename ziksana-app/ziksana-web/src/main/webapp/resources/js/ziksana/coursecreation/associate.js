// JavaScript Document

$(document).ready(
		function() {
			var theme = getTheme();
			// for hiding th edivs on pageload
			$("#associatedefinecontainer").hide();
			$("#Associatecontentsearch").hide();

			$(".cancellinkassociatecontent").click(function(e) {
				$("#associatedefinecontainer").hide();
				$("#Associatecontentsearch").hide();
				$("#instruction").show();
			});
			$("#splitter").jqxSplitter({
				theme : theme,
				panels : [ {
					size : 180
				} ]
			});
			$(window).scrollTop(0, 0);
			// To be used in future
			// label:"Model Thinking", id:"rootLi", parentId:0,
			// parentElement:null, parentItem:null, disabled:false,
			// selected:false, locked:false, checked:false, level:0,
			// isExpanded:true, hasItems:true, element:({}),
			// subtreeElement:({}), checkBoxElement:null, titleElement:{0:({}),
			// length:1}, arrow:({}),

			$(function() { // this will run when the document.ready event fires
				$("#instruction").show();
				// To be used in future
				/* alert(item2.label); */
			});
			// /

			// associate form validations

			// Associate content Rich text editor

			// for texteditor hide and show
			$('._plainText').hide();
			$('._richTextShow').hide();

			$('._richText').click(function() {
				$('._richText').hide();
				$('._plainTextShow').hide();
				$('._plainText').show();
				$('._richTextShow').show();
				CKEDITOR.replace('Associatecdescrte');
			});

			$('._plainText').click(function() {
				$('._richText').show();
				$('._plainTextShow').show();
				$('._plainText').hide();
				$('._richTextShow').hide();
			});

			// Associate content specify tag function

			$(function() {
				var carTags = [ 'Science', 'Physics', 'Maths', 'Biology',
						'Sports', 'English', 'Economics', 'Ziksana',
						'Chevrolet' ];
				$("#Associatetag").superblyTagField({
					allowNewTags : true,
					showTagsNumber : 10,
					title : 'ggg',
					tags : carTags
				});

				$('#tagDemoButton2').click(function(e) {
					alert($("#Associatetag").val());
				});

			});

			// Associate Content form

			$('#type-1').hide();
			$('#type-2').hide();
			$('#type-3').hide();

			$('#q_type').change(function() {
				if ($('#q_type').val() == "UploadContent") {
					$('#type-1').fadeIn("slow");
					$('#type-2').hide();
					$('#type-3').hide();
				} else if ($('#q_type').val() == "ExternalWebPage") {

					$('#type-2').fadeIn("slow");
					$('#type-1').hide();
					$('#type-3').hide();

				}

				else if ($('#q_type').val() == "CreateContent") {
					$('#type-3').fadeIn("slow");
					$('#type-1').hide();
					$('#type-2').hide();
					CKEDITOR.replace('q_typecdesdcrte');

				}

				else if ($('#q_type').val() == "") {
					$('#type-1').hide();
					$('#type-2').hide();
					$('#type-3').hide();

				}
			});

			// Search and Associate content specify tag function

			$(function() {
				var carTags = [ 'Science', 'Physics', 'Maths', 'Biology',
						'Sports', 'English', 'Economics', 'Ziksana',
						'Chevrolet' ];
				$("#SearchAssociatetag").superblyTagField({
					allowNewTags : true,
					showTagsNumber : 10,
					title : 'ggg',
					tags : carTags
				});

				$('#tagDemoButton2').click(function(e) {
					alert($("#SearchAssociatetag").val());
				});

			});

			// search an associate form search hide and show on advance click or
			// search button

			$('#frmadvsearchassoc').hide();
			$("#srchresultsearchassoc").hide();

			$("#Btnsearchassocadv").click(function() {
				$("#frmadvsearchassoc").toggle('showOrHide');

			});

			$("#Btnsrchsearchassoc").click(function() {
				$("#srchresultsearchassoc").toggle('showOrHide');

			});

			$("#Btnsbtsearchassoc").click(function() {
				$("#srchresultsearchassoc").toggle('showOrHide');

			});

		}); // end of document.ready

