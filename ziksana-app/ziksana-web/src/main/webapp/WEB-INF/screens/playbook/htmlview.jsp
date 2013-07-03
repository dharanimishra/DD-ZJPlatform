<style>

.tbboxheadfntds  {
    color: #8B8B8B;}
.tbboxheadfnt {
    color: #8B8B8B;}
.tbboxdesc p {
     color: #B1B1B1;
    font-family: 'Segoe UI Light','Open Sans',Verdana,Arial,Helvetica,sans-serif;
    font-size: 14px !important;width: 352px; 
}
.tbboxdesc {
    float: none;
    margin-top: 0;
    width: 328px;
    
}
.tbboxheadfntpublish {
    color: #4BB1CF;}
.tbboxdescds p {
    color: #B1B1B1;
    font-family: 'Segoe UI Light','Open Sans',Verdana,Arial,Helvetica,sans-serif;
    font-size: 14px!important;
}
#buildtab .badge-warning{background-color: #999999;}
#publishtab .badge1  {background-color: #F89406!important}
.tbboxdescpub p {
    color: #4BB1CF;
    font-family: 'segoe ui',sans-serif;
    font-size: 13px;
    font-weight: 100;
}
 #buildtab{width: 363px;}
 #publishtab{width:320px}

/*styles for the Playbook starts*/
.playbookconatiner{display:block;
overflow:auto;border:0px solid #000;padding:4px;
}
.pbheader{
display:block;height:149px;


}
.pheaderL{float:left;width:27%}
.phbox {
  
  float: left;
  height: 135px;
  width: 134px;
}
.phboxblue{height: 135px;
  width: 134px;
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
  border-radius: 20px 0 0 0;
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
  margin-right: 5px;
  width: 120px;
}
.userimg p{text-align:center;color:#FFFFFF;float:left;margin-top:50px}
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
.b1{padding:0px;color:#A53232; font-size:20px;width:40%;float:left; text-transform:capitalize}
.b2{padding:0px;color:#A53232;font-size:16px;float:right; text-transform:capitalize}

.coursetitle{ overflow:; hidden;width:100%;margin-bottom:30px;height: 20px;}
.coursetitle a {color:#fff;float: left;
    text-decoration: none;font-size:14px;
    width: 90%;}
 .coursetitle label{color:#fff;float:right}
 
	.pheadmiddle {
   width:60%;float: left;
  height: 146px;
}
.pheadmiddle label {
   
  color: #006666;
  font-size: 35px;
  line-height: 2;
  padding-top: 0px;
  text-align: center;
  width: 100%;
  text-transform:capitalize
  
}
.coursedescription{
display:block;margin-top:10px;padding :0px 30px;

}

.coursedescription{
display:block;margin-top:10px;page-break-after : always

}

.detailswrrapper{padding :0px 30px;clear:both;text-align:justify;font-size:16px;min-height: 200px; }

.coursedescription div.bottom{padding :0px 30px;clear:both;text-align:justify;font-size:16px;min-height: 1200px; vertical-align:top }

.coursedescription b{padding :0px 30px;clear:both;font-size:16px;font-weight:bold}
.chapeterfotter{display:block;
background-image:url(/ziksana-web/resources/images/playbook/footer.png);
background-position:10px -70px;
background-repeat:no-repeat;height:229px;

}
.pageno{border:1px solid #FF9933;
background:#FF9933;
display:block;width:50px;height:45px;float:right;color:#fff;line-height:1.8;font-size:24px;text-align:center;
position:relative;top:182px;right:45px;
}
.toplink{float:right;
font-size:16px;
margin-right: 30px;
font-weight: bold;}
/*styles for the Playbook ends*/
</style>
<div class="navheadlp">
 
 <ul>
  <a class="no_text_decoration" href="/ziksana-web/zcourse/1/planner/${course.courseId}" >
 <li style="margin-left:40px; "><span><img src="/ziksana-web/resources/images/navarrowb.png" style="margin-right:10px; height:22px;"> </span>Define Planner  </li>
 </a>

 <li style="color: #f06c0b;"> <span><img src="/ziksana-web/resources/images/navarrow.png" style="margin-right:10px; height:22px;"> </span>  Review Playbook 
 </li>
 <%-- <li>
  <a href="/ziksana-web/zplaybook/unsecure/downloadPlayBook/${course.courseId }">
 <span><img src="/ziksana-web/resources/images/navarrowb.png" style="margin-right:10px; height:22px;"> </span>  Download Playbook
 </a>
  </li> --%>
 </ul>
 
 </div> <!--end of navheadlp-->
  <div class="clearfix"></div>
  
  <div style="float:right;margin-right:20px;margin-top:10px;margin-bottom:10px"><a href="/ziksana-web/zplaybook/1/downloadPlayBook/${course.courseId }" class="btn">Download PDF</a></div>
<div class="Clearfix"> </div>
<div id="definestructureformcontainer">

<!-- ************************Course Description and Images************************* -->

<div id="course">
      <div class="pheaderL">
         <div class="phbox roundRb" style=" margin-right: 27px;background-color:#afb85b"></div>
         <div class="phbox roundLB" style="background-color:#f2db75"></div>
      </div>
       <div class="pbheader">
<div class="pheadmiddle"> <label>${course.name }</label></div>
<div class="headerright"><div class="phboxblue"></div></div>
</div>

<div class="imgcontent">
<div class="imgcontentL">
<div class="userimg">
 <div style="overflow:auto;text-align:center;width:80%;padding:6px;">
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
    <label>${member.designation } </label>
  </p></div>
</div>

<div class="coursebox" id="ctc">
<span>INSIDE THIS COURSE</span>
<div class="Clearfix"></div>
<div class="coursetitlecontent" >
<div class="coursetitle" ><a href="#cd">Course Description</a><label><a href="#cd">P1</a></label></div>
<div class="coursetitle" ><a href="#md">Module Discription with Content Listing</a><label><a href="#md" id="mdd">P${coursModuleOnPage}</a></label></div>
<div class="coursetitle" ><a href="#pd">Planner Details</a><label><a href="#pd" id="pdd">P1</a></label></div>
</div>
</div>
</div>
 <div class="imgcontentR" style="float:left;width:72%;text-align:right;margin-left:10px;">
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
${course.description}
<div class="Clearfix"> </div>
<div class="toplink"><a href="#ctc">Top</a></div>
<div class="Clearfix"> </div>
<c:if test="${coursDescriptionFooter=='YES' }">
  <div class="chapeterfotter"><label class="pageno">01</label></div>
</c:if>
</div>
   
</div>
<!-- ************** Module div ************************** -->
<div id="courseModule">
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
	  <div><label class="b1">${node.title}</label><label class="b2">${course.name}</label ></div>
	  <div style="clear:both"></div>
	  ${node.nodeDescription}
	   <br>
	   	    <!-- Module Content -->
	       <c:if test="${! empty node.contents!=null }">
	       Content Details:
	         <c:forEach var="content" items="${node.contents}">
	          <div class="detailswrrapper">
	          <div>
	          <label class="b1">
	          <img src="/ziksana-web/resources/images/preview/doc.png" width="150px" height="150px" style="padding:20px;Padding-top:0px;" align="left"-->
	          ${content.contentname}</label>
	          <label class="b2">parent: ${node.title }</label >
	          </div>
	           <div style="clear:both"></div>
	           ${content.componentDescription }
	          </div>
	         </c:forEach>
	       </c:if>

	   <!--  div style="width:60%;margin:auto;font-weight:bold">Course Name :</div -->
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
		    <b style="padding:0px">${cnode.title}</b><label style="float:right;font-weight:bold">${node.title}</label ><br/>    
		    ${cnode.nodeDescription}<br>
		   
		   	    <!-- Module Content -->
	       <c:if test="${! empty cnode.contents!=null }">
	       Content Details:
	         <c:forEach var="content" items="${cnode.contents}">
	          <div class="detailswrrapper">
	          <div>
	          <label class="b1">
	          <img src="/ziksana-web/resources/images/preview/doc.png" width="150px" height="150px" style="padding:20px;Padding-top:0px;" align="left"-->
	          ${content.contentname}</label>
	          <label class="b2">parent: ${cnode.title }</label >
	          </div>
	           <div style="clear:both"></div>
	           ${content.componentDescription }
	          </div>
	         </c:forEach>
	       </c:if>
		   
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
		    <b style="padding:0px">${cnode2.title}</b><label style="float:right;font-weight:bold">${cnode.title}</label ><br/>    
		    ${cnode2.nodeDescription}<br>
		<!-- Module Content -->
	       <c:if test="${! empty cnode2.contents!=null }">
	       Content Details:
	         <c:forEach var="content" items="${cnode3.contents}">
	          <div class="detailswrrapper">
	          <div>
	          <label class="b1">
	          <img src="/ziksana-web/resources/images/preview/doc.png" width="150px" height="150px" style="padding:20px;Padding-top:0px;" align="left"-->
	          ${content.contentname}</label>
	          <label class="b2">parent: ${cnode2.title }</label >
	          </div>
	           <div style="clear:both"></div>
	           ${content.componentDescription }
	          </div>
	         </c:forEach>
	       </c:if>	
		    
		    		  
		   </div>
		   
	         <c:if test="${! empty cnode2.children}">
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
					    <b style="padding:0px">${cnode3.title}</b><label style="float:right;font-weight:bold">${cnode2.title}</label ><br/>    
					    ${cnode3.nodeDescription}<br>
		 <!-- Module Content -->
	       <c:if test="${! empty cnode3.contents!=null }">
	       Content Details:
	         <c:forEach var="content" items="${cnode3.contents}">
	          <div class="detailswrrapper">
	          <div>
	          <label class="b1">
	          <img src="/ziksana-web/resources/images/preview/doc.png" width="150px" height="150px" style="padding:20px;Padding-top:0px;" align="left"-->
	          ${content.contentname}</label>
	          <label class="b2">parent: ${cnode3.title }</label >
	          </div>
	           <div style="clear:both"></div>
	           ${content.componentDescription }
	          </div>
	         </c:forEach>
	       </c:if>		  
					   </div>   
			      </c:forEach>  
		     </c:if>
		      
      </c:forEach>  
     </c:if>		   
		   
		      
      </c:forEach>  
     </c:if>
  
</c:forEach> 

 
 

 </div>
</div>
<!-- ***********Planner Div ************** -->
<div id="planner">
 <h2>Planner Details</h2>
<%@include file="viewPlanner.jsp"%>
<div class="Clearfix"> </div>
<div class="toplink"><a href="#ctc">Top</a></div>
<div class="Clearfix"> </div>

</div>
<div class="chapeterfotter"><label class="pageno"></label></div>
</div>
<div style="margin-top:15px" > 
    <!-- 
     <div class="playbookconatiner">


<div class="Clearfix"></div>

<div class="coursedescription" id="md">



</div>
<div class="coursedescription" id="pd">

</div>
    <div class="Clearfix"> </div>                      
                         
    <div class="Clearfix"> </div>                              
    </div> --> <!--End of contentarea -->
 
 
 <div style="float:right;margin-right:20px; margin-top:20px; margin-bottom:20px"><a href="/ziksana-web/zplaybook/1/downloadPlayBook/${course.courseId }" class="btn">Download PDF</a> 
<a href="/ziksana-web/zcourse/1/activatecourse/${courseIds}" class="btn">Complete Course</a></div> 
</div> <!--End of definestructureformcontainer -->  

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
