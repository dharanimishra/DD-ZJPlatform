<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<meta>
<meta http-equiv="Content-Type" content="text/html"  />
<title>Launcher</title>


<link href="resources/css/styles.css" rel="stylesheet" type="text/css">
<link href="resources/css/type-setting.css" rel="stylesheet" type="text/css">
<link href="resources/css/effects.css" rel="stylesheet" type="text/css">
<link href="resources/css/nav.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="resources/css/jquery.fancybox.2.1.3.css"/>

<link rel="stylesheet" type="text/css" href="resources/css/easyslider/style2.css" />
<link
	href='http://fonts.googleapis.com/css?family=Economica:700,400italic'
	rel='stylesheet' type='text/css'>


<script type="text/javascript" src="resources/js/jquery-1.7.2.min.js"></script>
<script src="resources/js/jquery-ui-1.8.21.custom.min.js"></script>
<script type="text/javascript" src="resources/js/custom/z_common.js"></script>


<script src="resources/js/jquery.fancybox.pack.2.1.3.js"></script>
<c:url var="imageUrl_profile1" value="../resources/images/user/pic-id-102.jpg" />
<script type="text/javascript">
	$(function() {

		
		$.fancybox({
			'width': '85%',
			'height': 550,
			'autoScale': false,
			'transitionIn': 'fade',
			'transitionOut': 'fade',
			//'autoScale': true,
			//'autoDimensions': true,
			'type': 'iframe',
			'href': '/ziksana-web/secure/launcher',
			'showCloseButton': false,
			'onComplete': setTimeout("add_ziklogo_and_close_button()", 3000),
			'onCleanup'   :   function() {
		        return window.confirm('Close?');
		    }
			
			
		});

	});
</script>
<script type="text/javascript">
function add_ziklogo_and_close_button(){

	logo_html = '<img src="/ziksana-web/resources/images/ziksana_button_logo.png" id="zik_fancy_logo"  style="cursor: pointer; left: -36px; margin: 0 auto; position: absolute; top: -36px; z-index: 10000;width:120px; height:120px;" alt="" >';
	//$(fancy_iframe).parent().find('#zik_fnacy_logo, #custom_fancybox_close').remove(); //initially remove the logo if exists.

	fancybox_wrapper = $.fancybox.wrap;
	if(fancybox_wrapper != null){
	fancybox_wrapper.prepend(logo_html);
	fancybox_wrapper.find(".fancybox-close").attr('onclick','confirmFancyboxClose(); return false;').removeAttr('href');
	

	} 
	
}


</script>

<style>
.loginwrapper {
	background-color: #FFFFFF;
}

.loginhead {
	background-color: #00BCF2;
	height: 80px;
	margin-right: auto;
	margin-left: auto;
}

.zikregister {
	float: right;
	margin-right: auto;
	margin-left: auto;
}

.loginbottom {
	background-color: #222E36;
	height: 80px;
	margin-bottom: 0;
	margin-top: 20px;
}

.loginmiddle {
	background-color: #FFF;
	margin-right: auto;
	margin-left: auto;
	width: 1010px;
	/*border:1px solid #ccc;*/
	padding: 20px;
	margin-top: 20px;
	-moz-box-shadow: 1px 2px 15px #000000;
	-webkit-box-shadow: 1px 2px 15px #000000;
	box-shadow: 1px 2px 15px #000000;
}

.slider { /*border:3px solid #ccc;*/
	width: 590px;
	/*height:600px;*/
	float: left;
	box-shadow: 1px 1px 1px 1px rgba(221, 221, 221, 1);
	-webkit-box-shadow: 1px 1px 1px 1px rgba(221, 221, 221, 1);
	-moz-box-shadow: 1px 1px 1px 1px rgba(221, 221, 221, 1);
}

.logindtls {
	width: 400px;
	float: left;
	margin-left: 5px;
	moz-box-shadow: 3px 4px 4px -3px #D9D9D9;
	-webkit-box-shadow: 3px 4px 4px -3px #D9D9D9;
	box-shadow: 3px 4px 4px -3px #D9D9D9;
	border: 3px solid rgba(185, 179, 179, 0.38);
}

.zenilogo {
	margin-left: 120px;
	margin-bottom: 20px;
}

.zenimainlogo {
	margin-left: 30px;
}

.frmloginzeni {
	height: 315px;
	margin-left: 30px;
}

.clearfix {
	float: none;
	clear: both;
}

.box {
	background: #fefefe;
	border: 1px solid #C3D4DB;
	border-top: 1px;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
	-moz-box-shadow: rgba(0, 0, 0, 0.15) 0 0 1px;
	-webkit-box-shadow: rgba(0, 0, 0, 0.15) 0 0 1px;
	box-shadow: rgba(0, 0, 0, 0.15) 0 0 1px;
	color: #444;
	font: normal 12px/14px Arial, Helvetica, Sans-serif;
	/* margin:0 auto 30px;*/
	overflow: hidden;
}

.box.login { /*height:290px;*/
	width: 332px;
	position: absolute;
	padding: 10PX;
	border: 1px solid #999;
	/*left:50%;
	top:50%;
	margin:-130px 0 0 -166px;*/
}

.boxBody {
	background: #fefefe;
	/*border-top:1px solid #dde0e8;*/
	border:0;
	padding: 10px 20px;
}

.box footer {
	background: #eff4f6;
	border-top: 1px solid #fff;
	padding: 12px 16px;
	overflow: hidden;
	/*height:32px;*/
}

.box label {
	display: block;
	font: 14px/22px Arial, Helvetica, Sans-serif;
	margin: 10px 0 0 6px;
}

.box footer label {
	float: left;
	margin: 4px 0 0;
}

.box footer input[type=checkbox] {
	vertical-align: sub;
	*vertical-align: middle;
	margin-right: 10px;
}

.box input[type=text],.box input[type=password],.txtField,.cjComboBox {
	border: 6px solid #F7F9FA;
	-webkit-border-radius: 3px;
	-moz-border-radius: 3px;
	border-radius: 3px;
	-moz-box-shadow: 2px 3px 3px rgba(0, 0, 0, 0.06) inset, 0 0 1px #95a2a7
		inset;
	-webkit-box-shadow: 2px 3px 3px rgba(0, 0, 0, 0.06) inset, 0 0 1px
		#95a2a7 inset;
	box-shadow: 2px 3px 3px rgba(0, 0, 0, 0.06) inset, 0 0 1px #95a2a7 inset;
	margin: 3px 0 4px;
	padding: 8px 6px;
	width: 270px;
	display: block;
}

.box input[type=text]:focus,.box input[type=password]:focus,.txtField:focus,.cjComboBox:focus
	{
	border: 6px solid #f0f7fc;
	-moz-box-shadow: 2px 3px 3px rgba(0, 0, 0, 0.04) inset, 0 0 1px #0d6db6
		inset;
	-webkit-box-shadow: 2px 3px 3px rgba(0, 0, 0, 0.04) inset, 0 0 1px
		#0d6db6 inset;
	box-shadow: 2px 3px 3px rgba(0, 0, 0, 0.04) inset, 0 0 1px #0d6db6 inset;
	color: #333;
}

.cjComboBox {
	width: 294px;
}

.cjComboBox.small {
	padding: 3px 2px 3px 6px;
	width: 100px;
	border-width: 3px !important;
}

.txtField.small {
	padding: 3px 6px;
	width: 200px;
	border-width: 3px !important;
}

.rLink {
	padding: 0 6px 0 0;
	font-size: 11px;
	float: right;
}

.box a { /*color:#999;*/
	
}

.box a:hover,.box a:focus {
	text-decoration: underline;
}

.box a:active {
	color: #f84747;
}

.btnLogin {
	background: #00BCF2;
	border: 2px solid #ffffff !important;
	cursor: pointer;
	padding: 11px 16px;
	font: bold 11px/14px Verdana, Tahomma, Geneva;
	text-shadow: rgba(0, 0, 0, 0.2) 0 1px 0px;
	color: #fff;
	-moz-box-shadow: inset rgba(255, 255, 255, 0.6) 0 1px 1px,
		rgba(0, 0, 0, 0.1) 0 1px 1px;
	-webkit-box-shadow: inset rgba(255, 255, 255, 0.6) 0 1px 1px,
		rgba(0, 0, 0, 0.1) 0 1px 1px;
	box-shadow: inset rgba(255, 255, 255, 0.6) 0 1px 1px, rgba(0, 0, 0, 0.1)
		0 1px 1px;
	margin-left: 12px;
	float: right;
	padding: 7px 21px;
}

.btnLogin:hover,.btnLogin:focus,.btnLogin:active {
	background: #f28920;
}

.btnLogin:active {
	text-shadow: rgba(0, 0, 0, 0.3) 0 -1px 0px;
}
</style>

</head>

<body style="background-image: none;">



</body>
</html>
