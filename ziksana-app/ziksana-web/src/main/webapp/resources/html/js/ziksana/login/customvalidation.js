// JavaScript Document


// validation of form
$(document).ready(function(e) {
	
	$(function() {
$('.password').pstrength();
});

jQuery("#registerfrm").validationEngine({'custom_error_messages' : {
	
	'#txtuserid' : {
        'required': {
            'message': "* Please enter Unique UserID "
        }
	},
	
	'#password' : {
        'required': {
            'message': "* Please enter Password "
        }
	},
	
	'#passwordcng' : {
        'required': {
            'message': "* Please Re-enter Password "
        }
	},
	
	
	'#txtfname' : {
        'required': {
            'message': "* Please enter your First Name "
        }
	},
	
	'#txtlname' : {
        'required': {
            'message': "* Please enter your Last Name "
        }
	},
	
		'#txtpriemail' : {
        'required': {
            'message': "* Please Enter correct Primary Email address, we will email you password to this email incase you forget it"
        }
	},
	
	'#txtsecemail' : {
        'required': {
            'message': "* Please Enter you Alternate Email address"
        }
	},
	
	'#txtsecans1' : {
        'required': {
            'message': "* Please Enter your Security Answer"
        }
	},
	
	'#txtsecans2' : {
        'required': {
            'message': "* Please Enter your Security Answer"
        }
	},
	
	'#sques1' : {
        'required': {
            'message': "* Please Select Security Question"
        }
	},
	
	'#sques2' : {
        'required': {
            'message': "* Please Select Security Question"
        }
	},
	
	'#agree' : {
        'required': {
            'message': "* Please Check, if you agree with the Terms and Services of Ziksana"
        }
	},
	
	
	
	
}
});

});
