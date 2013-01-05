<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script type="text/javascript" src="../resources/js/tree/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="../resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="../resources/js/jquery-ui-1.8.21.custom.min.js">

</script>


<html>
<head>

<title>Zrecommend</title>
<link rel="stylesheet" href="../resources/css/zeni/zeni2.css" />
<link rel="stylesheet" href="../resources/css/bootstrap.css" />
 <link href="../resources/css/jquery.mCustomScrollbar.css" rel="stylesheet" type="text/css" /> 

<!--[if gte IE 9]>
  <style type="text/css">
    .gradient {
       filter: none;
    }
  </style>
<![endif]-->


<script src="../resources/js/isotope/jquery-1.7.2.min.js"></script>
<script src="../resources/js/isotope/jquery.isotope.min.js"></script>
<!----- included for tooltip ---->
   <script src="../resources/js/bootstrap.min.js"></script>
   <script src="../resources/js/bootstrap.js"></script>
<!----- end for tooltip script ----> 
<script src="../resources/js/zRecommend.js"></script>

 <c:url var="showRecomendByCateg" value="/secure/showrecByCateg/" />
 <c:url var="getAllRecommendations" value="/secure/getallrecomendations" />
  <script type="text/javascript">
  function closeIt(){
	 
		  parent.jQuery.fancybox.close();

		  
  }
$(document).ready(function() {
	
	populate_new_recommendations();
	
});
	
	function populate_new_recommendations(){
	$.ajax({
		  	type: 'GET',
			url: '${getAllRecommendations}',
			dataType: 'xml',
			success: function( data ) {
					if (console && console.log){
								console.log( 'Recommend of data:', data);
					}
					var output="";
					
					
					$(data).find("recommenditem").each(function(index){
						
						extra_class = '';
						if($(this).find("category").text() == '1000'){//New
							extra_class = 'new';
							
						}
						if($(this).find("category").text() == '1001'){//Actioned
							extra_class = 'actioned';
						}
						if($(this).find("category").text() == '1002'){//Ignored
							extra_class = 'ignored';
						
						}
						 if($(this).find("category").text() == '1000' && '1001' && '1002'){//All
							extra_class = 'all';
							
						}  
						
						output+="<div class='zeniboxrewards "+extra_class+"' id='rec1'>";
						output+="<div  class='zenititle'><label id='recomendId"+index+"'> "+ $(this).find("recommendationId").text()+"</label></div>";  
						output+="<div  class='zenititle'><label id='categoryId"+index+"'> "+ $(this).find("category").text()+"</label></div>";
						output+="<div  class='zenititle'><label id='recomendTitle"+index+"'> "+ $(this).find("title").text()+"</label></div>";
						output+="<div class='zenisubtitle'>";
						output+="<div class='zsublink1 zenileft'>Created by : <span class='zlinktext'>Ziksana </span></div>";
						output+="<div class='zsublink2 zenileft'>Valid upto : <span class='zlinktext2'> 31/09/2012  </span></div><br/><br/></div>";
						output+="<div class='zenirecommendcenter'>";
						output+="<div class='zenirecommendborder zenileft'></div>";
						output+="<div class='zenircommendcenterlink zenileft'>";
						
						output+="<a class='myButtonLink' id='options' rel='tooltip' data-placement='bottom' href='#'   title='Add to Calendar'></a>";
						output+="<a class='myButtonLink2 add_to_todo' id='options' rel='tooltip' data-placement='bottom' href='' onclick='createNewTodo("+index+")' title='Add To Do'></a>";  																																								
						output+="<a class='myButtonLink3 ignore_hide'  rel='tooltip' data-placement='bottom' href='' onclick='moveIgnored("+index+")' title='Ignore' id='_ignore4'></a></div><br /></div>";
						
						output+="<div class='zenilower'>   ";
						output+="<div class='zeniiconimage zenileft'><img src='../resources/images/noimage.png' width='70' height='70'/></div>";
						output+="<div class='zenicontent'><label id='recomendDescription"+index+"'>"+ $(this).find("description").text()+"</label></div><br /></div></div>";
					
						output+="</div>";
												
					});
					
				
					$('#recommendations_container').html(output);
					show_only_new(); //show only new recommendations
					
					
					
			}
	});
	}
	

	
</script>


<script>
 
    $('#container4').isotope({
  // options
  itemSelector : '.item',
  layoutMode : 'fitRows'
});


$('#filters a').click(function(){
  var selector = $(this).attr('data-filter');
  $container.isotope({ filter: selector });
  return false;
});


$('#container4').isotope({ filter: '.my-selector' }, function( $items ) {
  var id = this.attr('id'),
      len = $items.length;
  console.log( 'Isotope has filtered for ' + len + ' items in #' + id );
});


 
function showall()
{
$('#container4').isotope({ filter: '.All'});
}

function showactive()
{
$('#container4').isotope({ filter: '.All' });
}

function showreview()
{
$('#container4').isotope({ filter: '.All' });
}

function createNewTodo(index){
	//alert(index);
	recommend_id = $('#recomendId'+index+'').html(); 
	categoryId= $('#categoryId'+index+'').html();
	
	 recommend_title = $('#recomendTitle'+index+'').html();
	 recommend_description = $('#recomendDescription'+index+'').html();
	
	 
	    $.post( '<c:url value='/secure/createtodo'/>'
 		 , {'category':recommend_title,'notificationContent':recommend_description}
 		 , function( data )
  			{
  
				

 	 		});  
	    
	   
	    
	    $.post( '<c:url value='/secure/updaterecommendation'/>'
	    		 , {'recommendationId':recommend_id,'category':1001}
	    		 , function( data )
	     			{
	     
	    			 populate_new_recommendations();

	    			 });   
	    
	   
	
}
function moveIgnored(index){
	//alert(index);
	recommend_id = $('#recomendId'+index+'').html(); 
	categoryId= $('#categoryId'+index+'').html();
	
	 $.post( '<c:url value='/secure/updaterecommendation'/>'
    		 , {'recommendationId':recommend_id,'category':1002}
    		 , function( data )
     			{
     
    			 populate_new_recommendations();

    			 });  
}

</script>
 
 <!-- for edit -->
<script type="text/javascript" src="../resources/js/mojo.js"></script>
<script type="text/javascript" src="../resources/js/mojo.js"></script>

 

</head>

<body bgcolor="#EAEAEA">
	
    <div class="zeniwrapper">
   
	<div class="helptext">
    Recommendations Page
    </div> <!-- end of help text -->

   
    <div class="zeniisotope">
                    
                    <li><a  id="all_recommend" class="btn btn-info" onclick="show_all();">All</a> </li>
                    <li><a  id="shownew_recommend" class="btn btn-info" onclick="show_only_new();">New</a></li>
                    <li> <a id="Actioned_recommend" class="btn btn-info" onclick="show_only_actioned();">Actioned</a></li>
                    <li> <a  id="Ignored_recommend" class="btn btn-info ign" onclick="show_only_ignored();">Ignored</a></li>
                                      
                    
          </div> <!--end of zeni isotope--> 
  <div id="wrap" style="height:500px; overflow:auto;">
    <div id="recommendations_container" >
   
  
   
  
   </div> 
  
   </div> <!--------------end of container-4 --->
  
  <div class="zenibuttons" style="height:50px;">
              <a class="btn btn-info" onclick="closeIt()" style="float:right;">Return</a>
                 </div> <!--end of zenibuttons -->  
  
  
  
   <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>
	<script>!window.jQuery.ui && document.write(unescape('%3Cscript src="jquery/jquery-ui-1.8.21.custom.min.js"%3E%3C/script%3E'))</script>
	<!-- mousewheel plugin -->
	<script src="../resources/js/scrollbar/jquery.mousewheel.min.js"></script>
	<!-- custom scrollbars plugin -->
	<!--  
	<script src="../resources/js/scrollbar/jquery.mCustomScrollbar.js"></script>-->
	<script>
	
		
		
		
		function show_only_new(){
			  $('#shownew_recommend').addClass('btn-info-hover');
			  $('#all_recommend').removeClass('btn-info-hover');
			  $('#Actioned_recommend').removeClass('btn-info-hover');
			  $('#Ignored_recommend').removeClass('btn-info-hover');
			//hides all actioned and ignored recommendations.
			$('#recommendations_container > div').show();
			jQuery('#recommendations_container').find('div.actioned, div.ignored').hide();
		}
		
		function show_only_actioned(){
			  $('#shownew_recommend').removeClass('btn-info-hover');
			  $('#all_recommend').removeClass('btn-info-hover');
			  $('#Actioned_recommend').addClass('btn-info-hover');
			  $('#Ignored_recommend').removeClass('btn-info-hover');
			
			$('#recommendations_container > div').hide();
			jQuery('#recommendations_container').find('div.actioned').show();
		}
		
		function show_only_ignored(){
			  $('#shownew_recommend').removeClass('btn-info-hover');
			  $('#all_recommend').removeClass('btn-info-hover');
			  $('#Actioned_recommend').removeClass('btn-info-hover');
			  $('#Ignored_recommend').addClass('btn-info-hover');
			
			$('#recommendations_container > div').hide();
			jQuery('#recommendations_container').find('div.ignored').show();
		}
		
		function show_all(){
			   $('#shownew_recommend').removeClass('btn-info-hover');
			   $('#all_recommend').addClass('btn-info-hover');
			   $('#Actioned_recommend').removeClass('btn-info-hover');
			   $('#Ignored_recommend').removeClass('btn-info-hover');
			//shows all recommendations.
			jQuery('#recommendations_container > div').show();
		}
	</script> 
    
  
 
   
</div><!-----------end of zeniwrapper ---->
<style>
.actioned .add_to_todo {
  display: none;
}
.ignored .ignore_hide{
  display:none;
}

.btn-info-hover {
    background-color: #B80000;
    background-image: linear-gradient(to bottom, #D80000, #FF0000);
    background-repeat: repeat-x;
    border-color: rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.25);
    color: #FFFFFF;
    text-shadow: 0 -1px 0 rgba(0, 0, 0, 0.25);
}

</style>
</body>
</html>


