var newUserId;
var addUrl = "app/registration/add";
var deleteUrl = "app/registration/delete";
var updateUrl = "app/registration/update";

function setUpdateForm(element){
	trElement = document.getElementById(element);
	document.userForm.standard.value = trElement.children[1].innerHTML;
	document.userForm.age.value = trElement.children[2].innerHTML;
	document.userForm.action = projectUrl + updateUrl;
}

function setAddForm(){
	document.userForm.id.value = newUserId;
	document.userForm.name.value = "";
	document.userForm.standard.value = "";
	document.userForm.action = projectUrl + addUrl;
}

function setDeleteForm() {
	document.userForm.action = projectUrl + deleteUrl;
	return true;
}

