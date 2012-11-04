function addCombo() {
	var textb = document.getElementById("notes_toc");
	var combo = document.getElementById("select");
	
	var option = document.createElement("option");
	option.text = textb.value;
	option.value = textb.value;
	try {
		combo.add(option, null); //Standard 
	}catch(error) {
		combo.add(option); // IE only
	}
	
}


function showVideoNoteForm(){
				jwplayer().pause();
				$('#listen-text').fadeIn(); //show the form
				$('#listen-text').find('textarea, input[type="text"]').val('').removeAttr('readonly');
				$('#videoIdHid, #timeHid').val('');
				//collect time and video id.
				
			}
function del(node) {
    try {
        r = node.parentNode.parentNode;
        r.parentNode.removeChild(r);
        var table = document.getElementById(rowCount);
        var rowCount = table;
        var rowCount = table.rows.length;
        for (var i = 0; i < rowCount; i++) {
            var row = table.rows[i];
            var chkbox = row.cells[0].childNodes[0];
            if (chk != null && chk.checked == true) {
                table.deleteRow(i);
                rowCount--;
                i--;
            }
        }
    } catch(e) {
    }
} 