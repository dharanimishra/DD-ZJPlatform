\<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script type="text/javascript" src="../resources/js/tree/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="../resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="../resources/js/jquery-ui-1.8.21.custom.min.js">

</script>


<html>
<head>

<title>ZRecommendations</title>
<link rel="stylesheet" href="../resources/css/zeni/zeni2.css" />
<style type="text/css">
.recommendation-info-category
{
	background-color: #F7F7F7;
  border: 1px solid rgba(0, 68, 119, 0.28);
  border-radius: 3px 3px 3px 3px;
  color: rgba(27, 110, 172, 0.94);
  cursor: pointer;
  float: left;
  font-family: arial;
  font-size: 10px;
  font-weight: bold;
  height: 14px;
  
  
  text-align: center;
 
  width: 65px;
   
}
</style>
<link rel="stylesheet" href="../resources/css/bootstrap.css" />
 <link href="../resources/css/jquery.mCustomScrollbar.css" rel="stylesheet" type="text/css" /> 

<!--[if gte IE 9]>
  <style type="text/css">
    .gradient {
       filter: none;
    }
  </style>
<![endif]-->
<style type="text/css">
	.hideTodo .add_to_todo {display:none; visibility:hidden;}
	.hide_ignore_hide .ignore_hide {display:none; visibility:hidden;}
	.zeniwrapper{margin:0 auto;}
</style>

<script src="../resources/js/isotope/jquery-1.7.2.min.js"></script>
<script src="../resources/js/isotope/jquery.isotope.min.js"></script>
<!----- included for tooltip ---->
   <script src="../resources/js/bootstrap.min.js"></script>
   <script src="../resources/js/bootstrap.js"></script>
<!----- end for tooltip script ----> 
<script src="../resources/js/zRecommend.js"></script>

 <c:url var="showRecomendByCateg" value="/zrecommendations/getrecommendationbycategory/" />
 <c:url var="getAllRecommendations" value="/zrecommendations/getallrecomendations" />
  <script type="text/javascript">
  function closeIt(){
	 
		  parent.jQuery.fancybox.close();

		  
  }
$(document).ready(function() {
	
	populate_new_recommendations();
	
	
	
	
});

function show_recommendation_tab(tab){
	
	if(tab == 'all'){ $('#all_recommend').click();  }
	if(tab == 'new'){ $('#shownew_recommend').click();  }
	if(tab == 'actioned'){ $('#Actioned_recommend').click();  }
	if(tab == 'ignored'){ $('#Ignored_recommend').click();  }
	
}

	
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
						if($(this).find("category").text() == '944'){//New
							extra_class = 'new';
							
						}
						if($(this).find("category").text() == '942'){//Actioned
							extra_class = 'actioned';
							if($(this).find("ignorecount").text() >= 1){
								 extra_class +=' ';
								extra_class += 'hide_ignore_hide';
							}
							
						}
						if($(this).find("category").text() == '943'){//Ignored
							extra_class = 'ignored';
							 if($(this).find("ignorecount").text() > 1){
								 extra_class +=' ';
								extra_class += 'hideTodo';
							} 
						
						}
						 /* if($(this).find("category").text() == '1000' && '1001' && '1002'){//All
							extra_class = 'all';
							
						}  */  
						
						output+="<div class='zeniboxrewards "+extra_class+"' id='rec1'>";
						output+="<div  class='zenititle'><label style='display:none;' id='recomendId"+index+"'> "+ $(this).find("recommendationId").text()+"</label></div>";  
						output+="<div  class='zenititle'><label style='display:none;' id='categoryId"+index+"'> "+ $(this).find("category").text()+"</label></div>";
						output+="<div  class='zenititle'><label style='display:none;' id='recomendTitle"+index+"'> "+ $(this).find("title").text()+"</label><label style='display:none;'> "+ $(this).find("ignorecount").text()+"</label></div>";
						output+="<div class='zenisubtitle'>";
						output+="<div class='zsublink1 zenileft'>Created by : <span class='zlinktext'>Ziksana </span></div>";
						output+="<div class='zsublink2 zenileft'>Valid upto : <span class='zlinktext2'> 18/02/2013  </span></div><br/><br/></div>";
						output+="<div class='zenirecommendcenter'>";
						output+="<div class='zenirecommendborder zenileft'></div>";
						output+="<div class='zenircommendcenterlink zenileft'>";
						
						output+="<a class='myButtonLink' id='options' rel='tooltip' data-placement='bottom'   title='Add to Calendar'></a>";
						output+="<a class='myButtonLink2 add_to_todo' id='options' rel='tooltip' data-placement='bottom' href='#' onclick='createNewTodo("+index+")' title='Add To Do'></a>";  																																								
						output+="<a class='myButtonLink3 ignore_hide'  rel='tooltip' data-placement='bottom' href='#' onclick='moveIgnored("+index+")' title='Ignore' id='_ignore4'></a></div><br /></div>";
						
						output+="<div class='zenilower'>   ";
						output+="<div class='zeniiconimage zenileft'><div class='recommendation-info-category' style='padding-bottom:5px;display:inline;'><strong> "+ $(this).find("title").text()+"</strong></div></div>";
						output+="<div class='zenicontent'><label id='recomendDescription"+index+"'>"+ $(this).find("description").text()+"</label></div><br /></div></div>";
					
						output+="</div>";
												
					});
					
				
					$('#recommendations_container').html(output);
					//show_recommendation_tab($('#show_tab').val());
					$('.zeniisotope a.btn-info-hover').click();
					
					
					
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
	
	
	addTodo_and_update_recommendation(index);
	 

}

//update and addtodo operation
function addTodo_and_update_recommendation(index){
	recommend_title = $('#recomendTitle'+index+'').html();
	recommend_description = $('#recomendDescription'+index+'').html();
	
	recommend_id = $('#recomendId'+index+'').html(); 
	categoryId= $('#categoryId'+index+'').html();
	
	$.post( '<c:url value='/zrecommendations/createtodoandrecomendationupdation'/>'
	 		 , {'categoryName':recommend_title,'notificationContent':recommend_description,'recommendationId':recommend_id,'category':942}
	 		 , function( data )
	  			{
	  				if(data=='1'){
	  					console.log('Updated Successfully');
						populate_new_recommendations();
	  					
	  				}
					

	 	 		});  
	
}


function moveIgnored(index){
	
	recommend_id = $('#recomendId'+index+'').html(); 
	categoryId= $('#categoryId'+index+'').html();
	
	 $.post( '<c:url value='/zrecommendations/updaterecommendation'/>'
    		 , {'recommendationId':recommend_id,'category':943}
    		 , function( data )
     			{

    			 console.log(data);
					if(data == 1){
						populate_new_recommendations();
						console.log('recommendation move to Ignored updated suucessfully');
						
					}

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
    Recommendations to improve your experience on the platform.
    </div> 

   <input id='show_tab' type="hidden" value="new">
   
    <div class="zeniisotope">
                    
                    <li><a  id="all_recommend" class="btn btn-info" onclick="show_all();">All</a> </li>
                    <li><a  id="shownew_recommend" class="btn btn-info btn-info-hover" onclick="show_only_new();">New</a></li>
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
	
	<script type="text/javascript">
	
		
		
		
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
 background:#edeaea;
    background-color: #edeaea;
    background-image: linear-gradient(to top, #edeaea, #edeaea,#edeaea);
    background-repeat: repeat-x;
    border-color: rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.25);
    color: #000000;
    
}
.btn-info-hover:hover
{
background:#edeaea;
color: #000000;
}

</style>
</body>
</html>


