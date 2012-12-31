var start_position = 0;
var end_position = 0;

jwplayer("mediaplayer").setup({
			flashplayer: "jwplayer/player.swf",
			file: "jwplayer/Aggregation.mp4",
			image: "jwplayer/preview.jpg"
});
function getPos(){
	    jwplayer().pause();
		start_position = jwplayer().getPosition();
		end_position = start_position + 60;
}
function addRow(tableID) {

	var type = document.getElementById("TOC").value;
	var opt = document.getElementById("notes_toc").value;
	var dataTable = document.getElementById("dataTable").value;
    var table = document.getElementById(tableID);
    var rowCount = table.rows.length;
    var row = table.insertRow(rowCount);
    
	var cell1 = row.insertCell(0);
    cell1.innerHTML = type;
	
   var cell2 = row.insertCell(1);
    cell2.innerHTML = opt;
	 
	var cell3 = row.insertCell(2);
    cell3.innerHTML = start_position;
    var cell4 = row.insertCell(3);
    cell4.innerHTML = end_position;

	var cell5 = row.insertCell(4);
    cell5.innerHTML = "<INPUT TYPE='button' value='Delete'  onclick='del(this)'>";
    jwplayer().play();
	$('._toc').hide();
}
function addRowForNotes(tableID) {
   var type = document.getElementById("notes_type").value;
	var notesText = document.getElementById("notesText").value;
	var dataTable = document.getElementById("dataTable").value;
    var table = document.getElementById(tableID);
    var rowCount = table.rows.length;
    var row = table.insertRow(rowCount);
	var cell1 = row.insertCell(0);
    cell1.innerHTML = type;	
    var cell2 = row.insertCell(1);
    cell2.innerHTML = notesText;
	 
	var cell3 = row.insertCell(2);
    cell3.innerHTML = start_position;
    var cell4 = row.insertCell(3);
    cell4.innerHTML = end_position;
	var cell5 = row.insertCell(4);
    cell5.innerHTML = "<INPUT TYPE='button' value='Delete'  onclick='del(this)'>";
    jwplayer().play();
	$('._notes').hide();
	
}
function addRowForReference(tableID) {
   var type = document.getElementById("reference_type").value;
	var referenceText = document.getElementById("referenceText").value;
	var dataTable = document.getElementById("dataTable").value;

   var table = document.getElementById(tableID);
    var rowCount = table.rows.length;
    var row = table.insertRow(rowCount);    
	var cell1 = row.insertCell(0);
    cell1.innerHTML = type;
	
   var cell2 = row.insertCell(1);
    cell2.innerHTML = referenceText;
	 
    var cell3 = row.insertCell(2);
    cell3.innerHTML = start_position;
    var cell4 = row.insertCell(3);
    cell4.innerHTML = end_position;

	var cell5 = row.insertCell(4);
    cell5.innerHTML = "<INPUT TYPE='button' value='Delete'  onclick='del(this)'>";
    jwplayer().play();
	$('._ref').hide();
}
function setText(id, messageText) {
        document.getElementById(id).innerHTML = messageText;
}