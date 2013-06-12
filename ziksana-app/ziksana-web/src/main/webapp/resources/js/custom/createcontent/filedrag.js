/*
filedrag.js - HTML5 File Drag & Drop demonstration
Featured on SitePoint.com
Developed by Craig Buckler (@craigbuckler) of OptimalWorks.net
*/

//$(document).ready(function(e) {
//    var counter = 1;
//});

var filenm = null;

(function() {

	// getElementById
	function $id(id) {
		return document.getElementById(id);
	}


	// output information
	function Output(msg) {
		var m = $id("messages");
		m.innerHTML = msg + m.innerHTML;
		
		//$(".uplcontainer").show();
	}


	// file drag hover
	function FileDragHover(e) {
		e.stopPropagation();
		e.preventDefault();
		e.target.className = (e.type == "dragover" ? "hover" : "");
		
	}


	// file selection
	function FileSelectHandler(e) {

		// cancel event and hover styling
		FileDragHover(e);

		// fetch FileList object
		var files = e.target.files || e.dataTransfer.files;

		// process all File objects
		for (var i = 0, f; f = files[i]; i++) {
			ParseFile(f);
			UploadFile(f);
		}

	}


	// output file information
	function ParseFile(file) {
		
			
		// display an image
		if (file.type.indexOf("image") == 0) {
			var reader = new FileReader();
			reader.onload = function(e) {
				Output(
			'<div class="previewdata"><img src="' + e.target.result + '" height="' + 50 + '" width="' + 50 + '" class="previewfile" />'+
			"<div class='fileslist'><strong>" + file.name + ":</strong></div><br />" +
			'<div id="uploadclass"> <div  class="uploaddatacontainer" > <div class="progress-bar blue stripes"><span style="width: 40%"></span></div></div>             				             <div class="uplbtn" style="float:right; margin-top:-85px; height:40px; width:40px;"><a href="#linkurl"><img src="../images/content/delete.png" title="remove"/></a>	            </div><div class="ClearFix"></div></div><div class="separater"></div>'
				
				);
				
				filenm = file.name;
				fileext = "img";
				$(".uploadheads").hide();
		//alert(filenm);
				
			}
			reader.readAsDataURL(file);
		}

		// display pdf
		if (file.type.indexOf("application/pdf") == 0 ) {
			var reader = new FileReader();
			reader.onload = function(e) {
				Output(
					'<div class="previewdata"><img src="../images/pdffile.jpg" height="' + 50 + '" width="' + 50 + '" class="previewfile" />'+
					"<div class='fileslist'><strong>" + file.name + ":</strong></div><br />" +
			'<div id="uploadclass">  <div  class="uploaddatacontainer" > <div class="progress-bar blue stripes"><span style="width: 40%"></span></div></div>             				             <div class="uplbtn" style="float:right; margin-top:-85px; height:40px; width:40px;"><a href="#linkurl"><img src="../images/content/delete.png" title="remove"/></a>	            </div><div class="ClearFix"></div></div><div class="separater"></div>'
				
				);
				filenm = file.name
				fileext = "pdf";
				$(".uploadheads").hide();
			}
			reader.readAsDataURL(file);
		}
		
		
		// display word
		if (file.type.indexOf("application/vnd") == 0 ) {
			var reader = new FileReader();
			reader.onload = function(e) {
				Output(
					'<div class="previewdata"><img src="../images/wordfile.jpg" height="' + 50 + '" width="' + 50 + '" class="previewfile" />'+
					"<div class='fileslist'><strong>" + file.name + ":</strong></div><br />" +
			'<div id="uploadclass">  <div  class="uploaddatacontainer" > <div class="progress-bar blue stripes"><span style="width: 40%"></span></div></div>             				             <div class="uplbtn" style="float:right; margin-top:-85px; height:40px; width:40px;"><a href="#linkurl"><img src="../images/content/delete.png" title="remove"/></a>	            </div><div class="ClearFix"></div></div><div class="separater"></div>'
					
				);
				filenm = file.name;
				fileext = "word";
				$(".uploadheads").hide();
			}
			reader.readAsDataURL(file);
		}
		
		// display word
		if (file.type.indexOf("spreadsheetml.sheet") >= 0 ) {
			var reader = new FileReader();
			reader.onload = function(e) {
				Output(
					'<div class="previewdata"><img src="../images/excelfile.jpg" height="' + 50 + '" width="' + 50 + '" class="previewfile" />'+
					"<div class='fileslist'><strong>" + file.name + ":</strong></div><br />" +
			'<div id="uploadclass">  <div  class="uploaddatacontainer" > <div class="progress-bar blue stripes"><span style="width: 40%"></span></div></div>             				             <div class="uplbtn" style="float:right; margin-top:-85px; height:40px; width:40px;"><a href="#linkurl"><img src="../images/content/delete.png" title="remove"/></a>	            </div><div class="ClearFix"></div></div><div class="separater"></div>'
					
				);
				filenm = file.name;
				fileext = "excel";
				$(".uploadheads").hide();
			}
			reader.readAsDataURL(file);
		}
		
		
		// display Zipfile
		if (file.type == "") {
			var reader = new FileReader();
			reader.onload = function(e) {
				Output(
					'<div class="previewdata"><img src="../images/zipfile.jpg" height="' + 50 + '" width="' + 50 + '" class="previewfile" />'+
					"<div class='fileslist'><strong>" + file.name + ":</strong></div><br />" +
			'<div id="uploadclass">  <div  class="uploaddatacontainer" > <div class="progress-bar blue stripes"><span style="width: 40%"></span></div></div>             				             <div class="uplbtn" style="float:right; margin-top:-85px; height:40px; width:40px;"><a href="#linkurl"><img src="../images/content/delete.png" title="remove"/></a>	            </div><div class="ClearFix"></div></div><div class="separater"></div>'
					
				);
				filenm = file.name;
				fileext = "zip";
				$(".uploadheads").hide();
			}
			reader.readAsDataURL(file);
		}
		
		
		// display text
		if (file.type.indexOf("text") == 0) {
			var reader = new FileReader();
			reader.onload = function(e) {
				Output(
				'<div class="previewdata"><img src="../images/txtfile.jpg" height="' + 50 + '" width="' + 50 + '" class="previewfile" />'+
					"<div class='fileslist'><strong>" + file.name + ":</strong></div><br />" +
			'<div id="uploadclass">  <div  class="uploaddatacontainer" > <div class="progress-bar blue stripes"><span style="width: 40%"></span></div></div>             				             <div class="uplbtn" style="float:right; margin-top:-85px; height:40px; width:40px;"><a href="#linkurl"><img src="../images/content/delete.png" title="remove"/></a>	            </div><div class="ClearFix"></div></div><div class="separater"></div>'
					
				);
				filenm = file.name;
				fileext = "txt";
				$(".uploadheads").hide();
			}
			reader.readAsDataURL(file);
		}
		
		
	}
	
		


	// upload JPEG files
	function UploadFile(file) {

		// following line is not necessary: prevents running on SitePoint servers
		if (location.host.indexOf("sitepointstatic") >= 0) return

		var xhr = new XMLHttpRequest();
		if (xhr.upload && file.type == "image/jpeg" && file.size <= $id("MAX_FILE_SIZE").value) {

			// create progress bar
			var o = $id("progress");
			var progress = o.appendChild(document.createElement("p"));
			progress.appendChild(document.createTextNode("upload " + file.name));


			// progress bar
			xhr.upload.addEventListener("progress", function(e) {
				var pc = parseInt(100 - (e.loaded / e.total * 100));
				progress.style.backgroundPosition = pc + "% 0";
			}, false);

			// file received/failed
			xhr.onreadystatechange = function(e) {
				if (xhr.readyState == 4) {
					progress.className = (xhr.status == 200 ? "success" : "failure");
				}
			};

			// start upload
			xhr.open("POST", $id("upload").action, true);
			xhr.setRequestHeader("X_FILENAME", file.name);
			xhr.send(file);

		}

	}


	// initialize
	function Init() {

		var fileselect = $id("fileselect"),
			filedrag = $id("filedrag"),
			submitbutton = $id("submitbutton");

		// file select
		fileselect.addEventListener("change", FileSelectHandler, false);

		// is XHR2 available?
		var xhr = new XMLHttpRequest();
		if (xhr.upload) {

			// file drop
			filedrag.addEventListener("dragover", FileDragHover, false);
			filedrag.addEventListener("dragleave", FileDragHover, false);
			filedrag.addEventListener("drop", FileSelectHandler, false);
			filedrag.style.display = "block";

			// remove submit button
			submitbutton.style.display = "none";
		}

	}

	// call initialization file
	if (window.File && window.FileList && window.FileReader) {
		Init();
	}

})();

	$("#fileupl").click(function(e) {
		//alert();
		$(".prg").each(function(index, element) {
           // alert(index);
			//alert(element);
			$(this).animate({width: '402px'},1500);
			//$(this).css('border-radius','10px');
        });
			
			
    });
	
	$("#uploadcontent2sbt").click(function(e){
		
			//alert(filenm);
			//alert(fileext);
			
					 var im0 = fileext+".png"; // the icon for a leaf node
					 var im1 = fileext+".png"; // the icon for an expanded parent node
					 var im2 = fileext+".png"; 
					 //alert(im0);
					 
					//  var im3 = "img.png"; // the icon for a leaf node
					// var im4 = "img.png"; // the icon for an expanded parent node
					// var im5 = "img.png"; 
					 
					 // var im6 = "pdf.png"; // the icon for a leaf node
					 //var im7 = "pdf.png"; // the icon for an expanded parent node
					 //var im8 = "pdf.png"; 
					 
					 var d=new Date(); tree.insertNewChild(tree.getSelectedItemId(),'Content' + d.valueOf(),filenm,0,im0,im1,im2);
					  //var d=new Date(); tree.insertNewChild(tree.getSelectedItemId(),'Child' + d.valueOf(),'Image2',0,im3,im4,im5);
					   //var d=new Date(); tree.insertNewChild(tree.getSelectedItemId(),'Child' + d.valueOf(),'PDF',0,im6,im7,im8);
					   
					    document.getElementById("upload").reset();
						 $("#messages").empty();
					    $("#uploadcontentwrapper").hide();
					  $("#createcontentwrapper").show();
							  tree.smartRefreshItem(0);
	});
	
	

$(".uploadcontent2").hide();
$(".addweblink").hide();
$(".editslide").hide();

	$('.saveup1').click( function(){
			$('.uploadcontent1').hide();
			$('.uploadcontent2').slideDown(200);
			$('#topicreplydesc').hide();
			$('._plainText').show();
			$('._richTextShow').show();
		});
$("#uploadbtn").click(function()
{

$('.uploadcontent1').fadeIn(200);
$(".uploadcontent2").hide();
$(".addweblink").hide();	
});


$("#addweblinkbtn").click(function()
{

$('.addweblink').fadeIn(200);
$(".uploadcontent1").hide();
$(".uploadcontent2").hide();	
});


$('.editslideup1').hide();
			$(".editdetailsweblink").click(function()
			{
				$('.editslideup1').toggle();
				
			});


$('#editslideup2').hide();
			$(".editdetailsweblink2").click(function()
			{
				$('#editslideup2').toggle();
				
			});			
			
			
	





	
	
	$("#addweblnksbt").click(function(e){
				var val = null;
				val = $("#addweblnktxtnm").val();
				var val2 = null;
				if(val != null && val != "" )
				{
					alert('Upload Link Information Saved.');
					 var im0 = "link.png"; // the icon for a leaf node
					 var im1 = "link.png"; // the icon for an expanded parent node
					 var im2 = "link.png"; 
					 
					 var d=new Date(); tree.insertNewChild(tree.getSelectedItemId(),'Content' + d.valueOf(),document.getElementById('addweblnktxtnm').value,0,im0,im1,im2,'SELECT');
					 $("addweblnktxtnm").val(val2);
					 $("addweblnkurl").val(val2);
					 
					  $("#addweblink").hide();
					  $("#createcontentwrapper").show();
					 
							  tree.smartRefreshItem(0);
				}
   });
   
   
   $("#addtopicforum").click(function(e){
				var val = null;
				val = $("#prg_name").val();
				
				
				if(val != null && val != "" )
				{
					alert('Upload Link Information Saved.');
					 var im0 = "notesIcon.png"; // the icon for a leaf node
					 var im1 = "notesIcon.png"; // the icon for an expanded parent node
					 var im2 = "notesIcon.png"; 
					 
					 var d=new Date(); tree.insertNewChild(tree.getSelectedItemId(),'Content' + d.valueOf(),document.getElementById('prg_name').value,0,im0,im1,im2,'SELECT');
					  document.getElementById("frmcreatedocument").reset();
					  $("#uploadwrapper").hide();
					  $("#createcontentwrapper").show();
							  tree.smartRefreshItem(0);
				}
   });
		


		