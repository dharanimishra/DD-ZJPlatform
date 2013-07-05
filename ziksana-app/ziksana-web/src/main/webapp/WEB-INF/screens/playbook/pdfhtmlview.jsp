<!doctype html>
<html>
<head>

<style>
body{font-family:"Segoe UI";margin:0;padding:0;}
.playbookconatiner{display:block;
overflow:auto;border:1px solid #000;padding:4px;width:1055px;margin:auto;
}
.pbheader{
display:block;height:149px;


}
.pheaderL{float:left;width:28%}
.phbox {
  
  float: left;
  height: 135px;
  width: 134px;
}
.phboxblue{height: 135px;
  width: 126px;
  border-radius:16px 0px 16px 0px;
  background-color:#00c1e5}
.roundRb{border-radius:0px 16px 0px 16px}
.roundLB{border-radius:16px 0px 16px 0px}
.headerright {
    
  float: left;
  height: 146px;
  width: 12%;
}
.userimg{
width:302px;
height:160px;
border-radius: 0 10px 0px 10px;
background:#3e3f13;margin-bottom:10px
}
.imgcontentL{ 
width:305px;float:left;}
.imgcontentR > img {
  height: 459px;
  border-radius: 20px 0 0 0;width: 100%;
}
.imgcontent{
display:block;overflow:auto;
}
.borderRb {
  border: 3px solid #FFFFFF;
  border-radius: 8px 8px 8px 8px;
  display: block;
  float: left;
  height: 140px;
  margin-right: 7px;
  width: 120px;
}
.userimg p {
  
  color: #FFFFFF;
  float: left;
  margin-top: 50px;
  text-align: center;
  width: 50%;
}
.Clearfix {
	clear: both;
}
.coursebox{ 
width:100%;height:290px;overflow:auto;border-radius: 10px 0px 10px 0px;
background:#3e3f13;}
.coursebox span {
  background-color: #A53232;
  color: #FFFFFF;
  display: block;
  font-size: 18px;
  height: 65px;
  line-height: 3;
  margin: 0;
  text-align: center;
  text-shadow: 1px 2px 2px rgba(0, 0, 0, 0.8);
  width: 100%;
}
.coursetitlecontent {
 
  padding: 10px;
}

h2{font-size:25px;margin-left:20px}
.b1{padding:0px;color:#A53232; font-size:20px}
.b2{padding:0px;color:#A53232;font-size:16px;float:right}

.coursetitle{ overflow: hidden;width:100%;margin-bottom:35px;}
.coursetitle a {color:#fff;float: left;
    text-decoration: none;font-size:14px;
    width: 90%;}
 .coursetitle label{color:#fff;float:right}
 
	.pheadmiddle {
   width:60%;float: left;
  height: 146px;
}
.pheadmiddle label {
   display:block;
  color: #006666;
  font-size: 40px;
 
  padding-top: 20px;
  text-align: center;
  width: 100%;
}

.coursedescription{
 display:block;margin-top:10px;
}
.detailswrrapper{padding :0px 30px;clear:both;text-align:justify;font-size:16px;min-height: 200px; }

.coursedescription div.bottom{padding :0px 30px;clear:both;text-align:justify;font-size:16px;min-height: 1200px; vertical-align:top }

.coursedescription b{padding :0px 30px;clear:both;font-size:16px;font-weight:bold}
.chapeterfotter{display:block;
background-image:url(/ziksana-web/resources/images/playbook/footer.png);
background-position:-77px -70px;
background-repeat:no-repeat;height:229px;

}
.pageno{border:1px solid #FF9933;
background:#FF9933;
display:block;width:50px;height:45px;float:right;color:#fff;line-height:1.8;font-size:24px;text-align:center;
position:relative;top:182px;right:45px;
}
.toplink{float:right;
font-size:12px;
margin-right: 30px;
font-weight: bold;}

#contentdescription > div {
  font-size: 16px;
  padding-bottom: 6px;
}

</style>
</head>
<body>
<script type='text/javascript' src='/ziksana-web/resources/js/lib/jquery/jquery-1.9.1.min.js'></script>
<script type='text/javascript' src='/ziksana-web/resources/js/lib/jquery/jquery-ui-1.10.1.custom.min.js'></script>
<div class="playbookconatiner">
<div id="course">
<div class="pbheader"><div class="pheaderL"><div class="phbox roundRb" style=" margin-right: 25px;background-color:#afb85b"></div>
<div class="phbox roundLB" style="background-color:#f2db75"></div></div>
<div class="pheadmiddle"> <label>${course.name }</label></div>
<div class="headerright"><div class="phboxblue"></div></div></div>
<div class="Clearfix"></div>
<div class="imgcontent">
<div class="imgcontentL">
<div class="userimg">
 <div style="overflow:hidden;text-align:center;width:90%;padding:6px;">
 <c:choose>
   <c:when test="${! empty member.picturePath}">
       <img src="${mediaserver}${member.picturePath}"  class="borderRb">
   </c:when>
   <c:otherwise>
   <img src="/ziksana-web/resources/images/playbook/usericon.png"  class="borderRb">
   </c:otherwise>
  </c:choose>
  <p>
    <label>${member.firstName }&nbsp; ${member.lastName }</label>
    <label>${member.designation }</label>
  </p></div>
</div>

<div class="coursebox" id="ctc">
<span>INSIDE THIS COURSE</span>
<div class="Clearfix"></div>
<div class="coursetitlecontent" >
<div class="coursetitle" ><a href="#cd">Course Description</a><label><a href="#cd">P1</a></label></div>
<div class="coursetitle" ><a href="#md">Module Discription with Content Listing</a><label><a href="#md" id="mdd">P1</a></label></div>
<div class="coursetitle" ><a href="#pd">Planner Details</a><label><a href="#pd" id="pdd">P1</a></label></div>
</div>
</div>
</div>
 <div class="imgcontentR" style="float:left;width:70%;text-align:right;margin-left:10px;">
  <c:choose>
   <c:when test="${! empty course.thumbnailPicturePath}">
       <img src="${mediaserver}${course.thumbnailPicturePath}" width="826px" height="459px"/>       
   </c:when>
   <c:otherwise>
   <img src="/ziksana-web/resources/images/playbook/defaultcourse.jpg">
   </c:otherwise>
  </c:choose>
 </div>
</div>


<div class="coursedescription" id="cd">
  <!-- b>Course Description</b -->
   <p class="top"> ${course.description}</p>
   <div class="Clearfix"> </div>
</div>
</div>
<div id="courseModule">

<div class="coursedescription" id="md" style="min-height:500px">
<h2>Module Discription with Content Listing</h2>
 <div class="contentdetails">
 <c:forEach var="node" items="${treeNodeList}">
	 <div class="detailswrrapper">
         <c:choose>
      <c:when test="${! empty node.thumbnailPicturePath}">
         <img src="${mediaserver}${node.thumbnailPicturePath}" width="150px" height="150px" style="padding:20px;Padding-top:0px;" align="left"/>       
      </c:when>
      <c:otherwise>
      <img src="/ziksana-web/resources/images/playbook/defaultmodule.png" width="150px" height="150px" style="padding:20px;Padding-top:0px;" align="left">
   </c:otherwise>
  </c:choose>
	  <div><label class="b1">${node.title}</label><label  class="b2">${course.name}</label ></div>   
	  ${node.nodeDescription}
	   <br>
	  	   	    <!-- Module Content -->
	       <c:if test="${! empty node.contents!=null }">
	       <div class="Clearfix"> </div>
	       <div id="contentdescription" style="padding:20px;text-align:justify">
	          <h4> Content Details  </h4><div class="Clearfix"> </div>
	           <c:forEach var="content" items="${node.contents}">         
	            <div>	            
	             <img src="/ziksana-web/${imagePathMap[content.contentType]}" width="150px" height="150px" style="float:left;padding-right:6px;"/>
	              <span style="width:40%;float:left;font-weight:bold;color:navy"> ${content.contentname}</span>
	              <span style="width:45%;float:left;text-align:right;margin-right:6px;"><b>Parent:${node.title }</b> </span>
	             ${content.componentDescription }
	          </div>
	          <div class="Clearfix"> </div>	           
	         </c:forEach>
	         	         
	         </div>
	       </c:if> 
	   <!--  div style="width:60%;margin:auto;font-weight:bold">Course Name :</div-->
	  </div>
   <c:if test="${! empty node.children}">
     <c:forEach var="cnode" items="${node.children}">    
        <div class="detailswrrapper">   
		     <c:choose>
		      <c:when test="${! empty cnode.thumbnailPicturePath}">
		         <img src="${mediaserver}${cnode.thumbnailPicturePath}" width="150px" height="150px" style="padding:20px;Padding-top:0px;" align="left"/>       
		      </c:when>
		      <c:otherwise>
		   <img src="/ziksana-web/resources/images/playbook/defaultmodule.png" width="150px" height="150px" style="padding:20px;Padding-top:0px;" align="left">
		   </c:otherwise>
		  </c:choose>
		    <div><label class="b1">${cnode.title}</label><label  class="b2">${node.title}</label ></div>   
		    ${cnode.nodeDescription}<br>
		   
		   <!-- Module Content -->
	       <c:if test="${! empty cnode.contents!=null }">
	       <div class="Clearfix"> </div>
	       <div id="contentdescription" style="padding:20px;text-align:justify">
	          <h4> Content Details  </h4><div class="Clearfix"> </div>
	           <c:forEach var="content" items="${cnode.contents}">         
	            <div>	            
	             <img src="/ziksana-web/${imagePathMap[content.contentType]}" width="150px" height="150px" style="float:left;padding-right:6px;"/>
	              <span style="width:40%;float:left;font-weight:bold;color:navy"> ${content.contentname}</span>
	              <span style="width:45%;float:left;text-align:right;margin-right:6px;"><b>Parent:${cnode.title }</b> </span>
	             ${content.componentDescription }
	          </div>
	          <div class="Clearfix"> </div>	           
	         </c:forEach>
	         	         
	         </div>
	       </c:if> 
		    <!--  div style="width:60%;margin:auto;font-weight:bold">Course Name :</div-->
		   </div>
		   <c:if test="${! empty cnode.children}">
		     <c:forEach var="cnode2" items="${cnode.children}">    
		        <div class="detailswrrapper">   
				     <c:choose>
				      <c:when test="${! empty cnode.thumbnailPicturePath}">
				         <img src="${mediaserver}${cnode.thumbnailPicturePath}" width="150px" height="150px" style="padding:20px;Padding-top:0px;" align="left"/>       
				      </c:when>
				      <c:otherwise>
				   <img src="/ziksana-web/resources/images/playbook/defaultmodule.png" width="150px" height="150px" style="padding:20px;Padding-top:0px;" align="left">
				   </c:otherwise>
				  </c:choose>
				    <div><label class="b1">${cnode2.title}</label><label  class="b2">${cnode.title}</label ></div>   
				    ${cnode2.nodeDescription}<br>
				  
				  		   <!-- Module Content -->
	       <c:if test="${! empty cnode2.contents!=null }">
	       <div class="Clearfix"> </div>
	       <div id="contentdescription" style="padding:20px;text-align:justify">
	          <h4> Content Details  </h4><div class="Clearfix"> </div>
	           <c:forEach var="content" items="${cnode2.contents}">         
	            <div>	            
	             <img src="/ziksana-web/${imagePathMap[content.contentType]}" width="150px" height="150px" style="float:left;padding-right:6px;"/>
	              <span style="width:40%;float:left;font-weight:bold;color:navy"> ${content.contentname}</span>
	              <span style="width:45%;float:left;text-align:right;margin-right:6px;"><b>Parent:${cnode2.title }</b> </span>
	             ${content.componentDescription }
	          </div>
	          <div class="Clearfix"> </div>	           
	         </c:forEach>
	         	         
	         </div>
	       </c:if>  
				    
				    <!--  div style="width:60%;margin:auto;font-weight:bold">Course Name :</div-->
				   </div>
				   
				   		   <c:if test="${! empty cnode.children}">
		     <c:forEach var="cnode3" items="${cnode2.children}">    
		        <div class="detailswrrapper">   
				     <c:choose>
				      <c:when test="${! empty cnode.thumbnailPicturePath}">
				         <img src="${mediaserver}${cnode.thumbnailPicturePath}" width="150px" height="150px" style="padding:20px;Padding-top:0px;" align="left"/>       
				      </c:when>
				      <c:otherwise>
				   <img src="/ziksana-web/resources/images/playbook/defaultmodule.png" width="150px" height="150px" style="padding:20px;Padding-top:0px;" align="left">
				   </c:otherwise>
				  </c:choose>
				    <div><label class="b1">${cnode3.title}</label><label  class="b2">${cnode2.title}</label ></div>   
				    ${cnode3.nodeDescription}<br>
				  		   <!-- Module Content -->
	       <c:if test="${! empty cnode3.contents!=null }">
	       <div class="Clearfix"> </div>
	       <div id="contentdescription" style="padding:20px;text-align:justify">
	          <h4> Content Details  </h4><div class="Clearfix"> </div>
	           <c:forEach var="content" items="${cnode3.contents}">         
	            <div>	            
	             <img src="/ziksana-web/${imagePathMap[content.contentType]}" width="150px" height="150px" style="float:left;padding-right:6px;"/>
	              <span style="width:40%;float:left;font-weight:bold;color:navy"> ${content.contentname}</span>
	              <span style="width:45%;float:left;text-align:right;margin-right:6px;"><b>Parent:${cnode3.title }</b> </span>
	             ${content.componentDescription }
	          </div>
	          <div class="Clearfix"> </div>	           
	         </c:forEach>
	         	         
	         </div>
	       </c:if> 
				    
				    <!--  div style="width:60%;margin:auto;font-weight:bold">Course Name :</div-->
				   </div>   
		      </c:forEach>  
           </c:if>
				   
				      
		      </c:forEach>  
           </c:if>  
		       
      </c:forEach>  
     </c:if>	  
</c:forEach> 

 
 

 </div>
<div class="Clearfix"> </div>
</div>
</div>
	<div id="planner">
		<div class="coursedescription">
			<h2>Planner Details</h2>
			<%@include file="viewPlanner.jsp"%>
		</div>
	</div>

</div>
<script>
$(document).ready(function(){
	//var totalHieght = $("#definestructureformcontainer").height()/1100;
	var courseHieght = $("#course").height();
	var moduleHieght = $("#courseModule").height();	
	var coursemoduleOnPg=Math.ceil((courseHieght)/1100);;	 
	var plannerOnPg = Math.ceil((courseHieght+moduleHieght)/1100);
	 //alert(" " +coursemoduleOnPg +" "+ plannerOnPg);
	$("#mdd").text("P"+coursemoduleOnPg);
	$("#pdd").text("P"+plannerOnPg);
	//alert("hi" +);	
});
</script>
</body>
</html>