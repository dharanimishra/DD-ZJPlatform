// Name        : z_ui_validation
// Function    : Un-obtrusive server side form field validation
// Author      : Arun Prasad (@arunprasadr)
// Dependencies: jquery > v.1.9
// Version     : 0.1

/* ---- SAMPLE HTML ----

	<input type="text" data-field_validation="true" data-field_validation_object="User" name="email" />
	<textarea data-field_validation="true" data-field_validation_object="User" name="addresss" />

---------------------- */

$('[data-field_validation]').on('focusout', function(){

	field_to_validate= $(this);
	object           = field_to_validate.data('field_validation_object');
	property         = field_to_validate.attr('name');
	value            = field_to_validate.val();

	$.post('/ziksana-web/validation/validateField', {'object' : object, 'property' : property, 'value': value}, function(data){
		//data will contain a boolean 'valid' and a string 'message'

		if(data.valid == 'true'){ //data is valid

			//do nothing

		} else { //data.valid == false. 

			alert(data.message); // Alert the message returned form the server to the user
			form_element = $('[name="'+name+'"]');
			form_element.val(''); // clear the value

		}

	});


});