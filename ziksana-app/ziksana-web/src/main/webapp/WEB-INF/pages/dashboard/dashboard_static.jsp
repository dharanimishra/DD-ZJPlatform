	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<head>
	<meta charset="utf-8">
    <!-- fix. IE 6-->
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9" >
	<!-- fix. IE 6-->
	<script>
	  document.createElement('header');
	  document.createElement('nav');
	  document.createElement('section');
	  document.createElement('article');
	  document.createElement('aside');
	  document.createElement('footer');
	</script>
	<!-- end fix. IE 6-->
	<title>Title | Welcome</title>
	<!--Body Style sheet-->
	<c:url var="cssUrl1" value="/resources/css/styles.css" />
	<c:url var="cssUrl2" value="/resources/css/type-setting.css" />
	<c:url var="cssUrl3" value="/resources/css/effects.css" />
	<c:url var="cssUrl4" value="/resources/css/nav.css" />

	<link href="${cssUrl1}" rel="stylesheet" type="text/css">
	<link href="${cssUrl2}" rel="stylesheet" type="text/css">
	<link href="${cssUrl3}" rel="stylesheet" type="text/css">
	<link href="${cssUrl4}" rel="stylesheet" type="text/css">
	<!--End Body Style sheet-->
	
    	<!--jquery UI-->
    <c:url var="cssUrl5" value="/resources/css/custom-theme/old-jquery-ui-1.8.21.custom.css" />
	<c:url var="cssUrl6" value="/resources/css/custom-theme/jquery-ui-1.8.21.custom.css" />
    	
    <link rel="stylesheet" type="text/css" href="${cssUrl5}">
    <link rel="stylesheet" type="text/css" href="${cssUrl6}">
    
    <c:url var="jsUrl1" value="/resources/js/jquery-1.7.2.min.js" />
    <c:url var="jsUrl2" value="/resources/js/ui/jquery.ui.core.js" />
    <c:url var="jsUrl3" value="/resources/js/ui/jquery.ui.widget.js" />
    <c:url var="jsUrl4" value="/resources/js/ui/jquery.ui.button.js" />
    <c:url var="jsUrl5" value="/resources/js/ui/jquery.ui.progressbar.js" />
    <c:url var="jsUrl6" value="/resources/js/ui/jquery.ui.tabs.js" />
    <c:url var="jsUrl7" value="/resources/js/ui/jquery.ui.datepicker.js" />
    <c:url var="jsUrl8" value="/resources/js/ui/jquery.ui.mouse.js" />
    <c:url var="jsUrl9" value="/resources/js/ui/jquery.ui.slider.js" />
    <c:url var="jsUrl10" value="/resources/js/tabs/jquery-ui-1.8.22.custom.min.js" />
    
	<script src="${jsUrl1}"></script>
	<script src="${jsUrl2}"></script>
	<script src="${jsUrl3}"></script>
	<script src="${jsUrl4}"></script>
	<script src="${jsUrl5}"></script>
	<script src="${jsUrl6}"></script>
	<script src="${jsUrl7}"></script>
	<script src="${jsUrl8}"></script>
	<script src="${jsUrl9}"></script>
    <script type="text/javascript" src="${jsUrl10}"></script>
   <style>
   <c:url var="imageUrl1" value="/resources/images/pbar-ani.gif" />
	.ui-progressbar .ui-progressbar-value { background-image: url(${imageUrl1}); }	
   </style>
	<script>
	$(function() {
		$( "#progressbar" ).progressbar({
			value: 65
		});
	});
	</script>
	<!--end jquery UI-->

    <!--tipsy-->
    <c:url var="jsUrl11" value="/resources/js/jquery.tipsy.js" />
    <c:url var="jsUrl12" value="/resources/js/login/jquery.tipsy.js" />
    <c:url var="jsUrl13" value="/resources/js/jquery.cookie.js" />
    <c:url var="jsUrl14" value="/resources/js/jquery.collapse.js" />
    
    <c:url var="cssUrl7" value="/resources/css/tipsy.css" />
    
    <script type='text/javascript' src='${jsUrl11}'></script>
	<link rel="stylesheet" href="${cssUrl7}" type="text/css" />
	<script src="${jsUrl12}" type="text/javascript"></script>
	<script src="${jsUrl13}"></script>
	<script src="${jsUrl14}"></script>
	<script>

	$(function() {
		$( "#tabset" ).tabs({ fx: { opacity: 'toggle' } });		
	});
	</script>
	
	<!--fancybox-->
	<c:url var="jsUrl15" value="/resources/js/jquery.fancybox-1.3.4/fancybox/jquery.mousewheel-3.0.4.pack.js" />
    <c:url var="jsUrl16" value="/resources/js/jquery.fancybox-1.3.4/fancybox/jquery.fancybox-1.3.4.pack.js" />
    
    <c:url var="cssUrl8" value="/resources/js/jquery.fancybox-1.3.4/fancybox/jquery.fancybox-1.3.4.css" />
    
	<script type="text/javascript" src="${jsUrl15}"></script>
	<script type="text/javascript" src="${jsUrl16}"></script>
	<link rel="stylesheet" type="text/css" href="${cssUrl8}" media="screen" />

	<!--fancybox end-->
    
<!---- Search --->
 <script type="text/javascript">
            $(function() {
				/**
				* the element
				*/
				var $ui 		= $('#ui_element');
				
				/**
				* on focus and on click display the dropdown, 
				* and change the arrow image
				*/
				$ui.find('#search').bind('focus click',function(){
					$ui.find('.sb_down')
					   .addClass('sb_up')
					   .removeClass('sb_down')
					   .andSelf()
					   .find('.sb_dropdown')
					   .show();
				});
				
				/**
				* on mouse leave hide the dropdown, 
				* and change the arrow image
				*/
				$ui.bind('mouseleave',function(){
					$ui.find('.sb_up')
					   .addClass('sb_down')
					   .removeClass('sb_up')
					   .andSelf()
					   .find('.sb_dropdown')
					   .hide();
				});
				
				/**
				* selecting all checkboxes
				*/
				$ui.find('.sb_dropdown').find('label[for="all"]').prev().bind('click',function(){
					$(this).parent().siblings().find(':checkbox').attr('checked',this.checked).attr('disabled',this.checked);
				});
            });
        </script>    
<!---end of search -->
	<!--rating-->
	<c:url var="jsUrl17" value="/resources/js/jquery.raty.min.js" />
    <c:url var="jsUrl18" value="/resources/js/custom.js" />
    
	<script src="${jsUrl17}"></script>    
    <script src="${jsUrl18}" type="text/javascript"></script>
    
    <!--new calendar-->
<c:url var="cssUrl9" value="/resources/js/s-events/css/dp_calendar.css" />

<link href="${cssUrl9}" type="text/css" rel="stylesheet" />

<c:url var="jsUrl19" value="/resources/js/s-events/ui/jquery.ui.core.js" />
<c:url var="jsUrl20" value="/resources/js/s-events/ui/jquery.ui.position.js" />
<c:url var="jsUrl21" value="/resources/js/s-events/ui/jquery.ui.datepicker.js" />
<c:url var="jsUrl22" value="/resources/js/s-events/js/date.js" />
<c:url var="jsUrl23" value="/resources/js/s-events/js/jquery.dp_calendar.min.js" />

<script type="text/javascript" src="${jsUrl19}"></script> 
<script type="text/javascript" src="${jsUrl20}"></script>
<script type="text/javascript" src="${jsUrl21}"></script> 
<script type="text/javascript" src="${jsUrl22}"></script>
<script type="text/javascript" src="${jsUrl23}"></script>

<!-- todo, alert and other by Sundip Shah -->
<c:url var="jsUrl24" value="/resources/js/index/todo_alert_other.js" />

<script type="text/javascript" src="${jsUrl24}"></script> 

<c:url var="cssUrl10" value="/resources/css/tag/tagit-simple-blue.css" />  
   
<link rel="stylesheet" type="text/css" href="${cssUrl10}">
<title><tiles:getAsString name="title" /></title>
</head>