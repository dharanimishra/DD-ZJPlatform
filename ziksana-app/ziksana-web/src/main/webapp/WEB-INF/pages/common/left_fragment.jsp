<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
              <div class="col-lft" >
              <div class="user-info all-box-shadow pad" >
              <div class="grey-out  f-l">
              
              <c:url var="imageUrl_profile1" value="/resources/images/user/pic-id-102.jpg" />
              
          <a href="#" rel="tipsy" title="${firstname} ${lastname}"><div class="white-in main-pic"  style="background:url(${imageUrl_profile1});" > </div></a>
          </div>
              <div class="user-dtls f-l"> 
              <span class="user-id">${firstname} ${lastname}</span>
              <a href="#" style="margin-left: 2px;" rel="tipsy" title="Profile 65% complete" class="zinfo zicons ls-no f-l" ></a>
              <span class="text-size-px10 blue text-weight-400 font-Signika b-b f-l">
              Complete your Profile </span>
           <!-- <div id="progressbar65" style="width:100px;" class="f-l"></div>
            <br/> <span class="light-blue">Profile 65% complete</span>-->
            <span class="text-size-px14 light-gray text-weight-400 font-Signika b-b">
              <br>
            ${title} </span>
          
            <p><span class="text-size-px12 light-gray font-Arial b-b">ID: ${memberId}</span></p>
              <div id="edu-star"></div>
          </div>
          <c:url var="htmlUrl_profile1" value="/resources/popup/e-status.html" />
              <div class="user-belt"><span class="blue text-size-px12 text-weight-600"><a class="lbx-70-50" href="${htmlUrl_profile1}">Guru</a></span> </div>
            </div>
             <!--test githup-->
            <!-- blogs added by sundip-->
         
      <c:url var="blogListUrl" value="/blog/list" />

			
     <script type="text/javascript">
         
            $(document).ready(function() {
            	$.ajax({
        		  	type: 'GET',
        			url: '${blogListUrl}',
        			dataType: 'html',
        			success: function(  data ) {
        				       console.log('blogList Return Value: ' + data);
                    			document.getElementById("blogList").innerHTML=$(data).html();
                    			
        			}});
            }); 
			</script> 
		 	
			
			
            
            <div id="blogList"></div> <div id="blogListError"></div>
            
           <!--    <div class="user-contacts all-box-shadow pad" >
             <span class="titles-info font-Signika text-size-px18 light-gray">Recent Blog Posts</span>
             	<div class="_blogMain">
            	<div class="_blogs">
                  <ol>
                    <li class="p-p  bckground-blue-light">
                      <p class="_postD text-size-px9">${blogPost1.get("date")}</p>
                      <b><a href="">${blogPost1.get("subject")}</a></b> <br/>
                      <p class="_postP">${blogPost1.get("detail")}</p>
                      <p class="_postT">(Tags: <a href="" class="text-size-px11">Educational Technology</a>, <a href="" class="text-size-px11">Research</a>)</p>
                    </li>
                  </ol>
                </div>
                <div class="_blogs">
                  <ol>
                    <li class="p-p bckground-blue-light">
                      <p class="_postD text-size-px9">${blogPost2.get("date")}</p>
                      <b><a href="">${blogPost2.get("subject")}</a></b> <br/>
                      <p class="_postP">${blogPost2.get("detail")}</p>
                      <p class="_postT">( Tags: <a class="text-size-px11" href="#" >Game Design</a>, <a class="text-size-px11" href="#" >Research</a> ... )</p>
                    </li>
                  </ol>
                </div>
                </div>
          <p class="txt-r" style="padding-right:10px; clear:both;">
            <a href="">More..</a>
          </p>
        </div>
        
        -->
            
          <div class="user-contacts all-box-shadow pad" >           
           <div id="tabs" class="_bgmain">
           <span class="titles-info font-Signika text-size-px18 light-gray">Contacts</span>
			
           		<a class="tab0">All</a>
				<a class="tab1">First</a>
                <a class="tab2">Second</a>
				<a class="tab3">Others</a>
				<br/><br/>
			
            <div class="tabs-0">
            
                   <ul class="contact-list" >
                    <li class="member">
                    <!--  <div class="grey-out">
                    <c:url var="imageUrl_profile2" value="/resources/images/user/2my-photor.png" />
                        <div class="white-in contact-pic" style="background:url(${imageUrl_profile2});" ><a href="#" rel="tipsy" title="Jason (Physics)"></a></div>
                      </div> -->
                      <c:url var="imageUrl_profile3" value="/resources/images/user/2my-photo.png" />
                      <div class="white-in contact-pichome" style="background:url(${imageUrl_profile3});" ><a href="#" rel="tipsy" title="Jason (Physics)"></a></div>
                    </li>
                    <li class="member _bgmain">
                      <!--<div class="grey-out _bgmain">
                      <c:url var="imageUrl_profile4" value="/resources/images/user/1my-photor.png" />
                        <div class="white-in contact-pic _bgmain" style="background:url(${imageUrl_profile4});"><a href="#" rel="tipsy" title="John (Electronics)"></a></div>
                      </div> -->
                      <c:url var="imageUrl_profile5" value="/resources/images/user/1my-photo.png" />
                       <div class="white-in contact-pichome _bgmain" style="background:url(${imageUrl_profile5});"><a href="#" rel="tipsy" title="John (Electronics)"></a></div>
                    </li>
                    <li class="member _bgmain">
                      <!--<div class="grey-out _bgmain">
                      <c:url var="imageUrl_profile6" value="/resources/images/user/3my-photo.png" />
                        <div class="white-in contact-pichome _bgmain" style="background:url(${imageUrl_profile6});"><a href="#" rel="tipsy" title="Linda (Robotics)"></a></div>
                      </div>-->
                      <c:url var="imageUrl_profile7" value="/resources/images/user/3my-photo.png" />
                      <div class="white-in contact-pichome _bgmain" style="background:url(${imageUrl_profile7});"><a href="#" rel="tipsy" title="Linda (Robotics)"></a></div>
                    </li><li class="member _bgmain">
                      <!--<div class="grey-out _bgmain">
                      <c:url var="imageUrl_profile8" value="/resources/images/user/2my-photo.png" />
                        <div class="white-in contact-pichome _bgmain" style="background:url(${imageUrl_profile8});"><a href="#" rel="tipsy" title="Jackie (Robotics)"></a></div>
                      </div>-->
                      <c:url var="imageUrl_profile9" value="/resources/images/user/2my-photo.png" />
                       <div class="white-in contact-pichome _bgmain" style="background:url(${imageUrl_profile9});"><a href="#" rel="tipsy" title="Jackie (Robotics)"></a></div>
                    </li>
                    <li class="member _bgmain">
                     <!-- <div class="grey-out _bgmain">
                     <c:url var="imageUrl_profile10" value="/resources/images/user/1my-photo.png" />
                        <div class="white-in contact-pichome _bgmain" style="background:url(${imageUrl_profile10});"><a href="#" rel="tipsy" title="Rose (Mathematics)"></a></div>
                      </div>-->
                      <c:url var="imageUrl_profile11" value="/resources/images/user/1my-photo.png" />
                      <div class="white-in contact-pichome _bgmain" style="background:url(${imageUrl_profile11});"><a href="#" rel="tipsy" title="Rose (Mathematics)"></a></div>
                    </li>
                  </ul>                  
            </div>
            <c:url var="imageUrl_profile12" value="/resources/images/background-pattern.jpg" />
            <div class="tabs-1" style="background-image:url(${imageUrl_profile12});">  
            <ul class="contact-list" >
                    <!--<li class="member">
                      <div class="grey-out">-->
                      <c:url var="imageUrl_profile13" value="/resources/images/user/2my-photo.png" />
                        <div class="white-in contact-pichome" style="background:url(${imageUrl_profile13});" ><a href="#" rel="tipsy" title="Jason (Physics)"></a></div>
                  <!--    </div>
                    </li> -->
                   </ul>
                    </div>
                    
            <c:url var="imageUrl_profile14" value="/resources/images/background-pattern.jpg" />
       
			<div class="tabs-2"  style="background-image:url(${imageUrl_profile14});"> <ul class="contact-list" >
                    <li class="member">
                     <!-- <div class="grey-out">
                     <c:url var="imageUrl_profile15" value="/resources/images/user/3my-photo.png" />
                        <div class="white-in contact-pichome" style="background:url(${imageUrl_profile15});" ><a href="#"></a></div>
                      </div>-->
                      <c:url var="imageUrl_profile16" value="/resources/images/user/3my-photo.png" />
                       <div class="white-in contact-pichome" style="background:url(${imageUrl_profile16});" ><a href="#" rel="tipsy" title="Linda (Robotics)"></a></div>
                    </li>
                   </ul>
                   </div>
			
           <div class="tabs-3">
            
                   <ul class="contact-list" >
                   
                    <li class="member _bgmain">
                     <!-- <div class="grey-out _bgmain">
                     <c:url var="imageUrl_profile17" value="/resources/images/user/1my-photo.png" />
                        <div class="white-in contact-pichome _bgmain" style="background:url(${imageUrl_profile17});"><a href="#"></a></div>
                      </div> -->
                      <c:url var="imageUrl_profile18" value="/resources/images/user/1my-photo.png" />
                      <div class="white-in contact-pichome _bgmain" style="background:url(${imageUrl_profile18});"><a href="#"  rel="tipsy" title="John (Electronics)"></a></div>
                    </li>
                    <li class="member _bgmain">
                      <!--<div class="grey-out _bgmain ">
                      <c:url var="imageUrl_profile19" value="/resources/images/user/3my-photo.png" />
                        <div class="white-in contact-pichome _bgmain" style="background:url(${imageUrl_profile19});"><a href="#"></a></div>
                      </div> -->
                      <c:url var="imageUrl_profile20" value="/resources/images/user/3my-photo.png" />
                       <div class="white-in contact-pichome _bgmain" style="background:url(${imageUrl_profile20});"><a href="#" rel="tipsy" title="Linda (Robotics)"></a></div>
                    </li>
                  </ul>                  
            </div>
      
          <p class="txt-r _bgmain" style="padding-right:10px; clear:both;">
           
           <a href="" class="Block"><span class="f-r text-pading-top">People Search</span> <strong class="in-search zicons ls f-r"></strong></a>
          </p>
        </div>
        </div>
        
  <!-- Know me Better -->
  
 
  <div  class="user-insight user-contacts all-box-shadow pad" >
  <p class="titles-info font-Signika text-size-px18 light-gray">Know me better</p>
  <ul>
    <li class="">
    <span class="p-p _blogs bckground-blue-light">You are usually the first to react to a sudden event.</span>
      <div id="radio" class="btn-set" style="margin-top:3px; margin-bottom:5px;">
         <input type="radio" id="radio1" name="radio" />
        <label for="radio1">Yes</label>
        <input type="radio" id="radio2" name="radio"  />
        <label for="radio2">Sometimes</label>
        <input type="radio" id="radio3" name="radio" />
        <label for="radio3">Never</label> 
        <br>
    </div>
    </li> 
     <!-- <li class=""><span class="p-p _blogs bckground-blue-light">You are almost never late for your appointments.</span>
      <div  class="btn-set" style="margin-top:3px; margin-bottom:5px;">
        <input type="radio" id="radio4" name="trivia" />
        <label for="radio4">Yes</label>
        <input type="radio" id="radio5" name="trivia"  />
        <label for="radio5">No</label>
        <br>
    </div>
    </li>
    <li class=""><span class="p-p _blogs bckground-blue-light">You like to be engaged in an active and fast-paced job.</span>
      <div  class="btn-set" style="margin-top:3px; margin-bottom:5px;">
        <input type="radio" id="radio7" name="gtk-1" />
        <label for="radio7">Yes</label>
        <input type="radio" id="radio8" name="gtk-1"  />
        <label for="radio8">No</label>
        <br>
    </div>
    </li>  -->
   </ul> 
   <c:url var="knowme" value="secure/getpopupwindow" />
  <div class="txt-r" ><a class="lbx-70-50 text-size-px11" href="${knowme}" class="Block"><span class="f-r text-pading-top text-pading-right"><span class="text-pading-right">Know me better</span></span> <strong class="zinfo2 zicons ls f-r"></strong></a>

  </div>
  
   
  
  
  </div> 
  
  <c:url var="showRecomendUrl" value="/secure/showrecByCateg/1" />
  <script type="text/javascript">
$(document).ready(function() {
	$.ajax({
		  	type: 'GET',
			url: '${showRecomendUrl}',
			dataType: 'xml',
			success: function( data ) {
					if (console && console.log){
								console.log( 'Recommend of data:', data);
					}
					var output="";
					
					
					$(data).find("recommenditem").each(function(index){
						
						output+="<ol>";
	                    output+="<li class='p-p _blogs bckground-blue-light'>";
	                    output+="<b >"+ $(this).find("title").text()+"</b>";
	                    output+="<br/>";
	                    output+="<p  style='padding-left: 10px;'>"+ $(this).find("description").text()+"</p>";
	                    output+="</li></ol><br/>";
												
					});

					console.log("Recommendations: " + output);
				
					
					$('#recomend').html(output);
					
			}
	});
	
});
</script>
 
<div class="user-contacts all-box-shadow pad" >
           
           <div id="tabsbottom" style="background-color:#FFF; margin-bottom:15px;">
           <span class="titles-info font-Signika text-size-px18 light-gray">Zeni Recommendations</span>
			           
            	<a class="rec0">All</a>
				<a class="rec1">Course</a>
                <a class="rec2">Grades</a>
				<br/><br/>
                            
            <div id= "recomend" class="rec-0 ">
              
            </div>
            
          			          
      
          <p class="txt-r _bgmain" style="padding-right:10px; clear:both;">
          <c:url var="htmlUrl_profile2" value="/resources/popup/z-zini.html" />
            <span><a href="${htmlUrl_profile2}" class="" style="color: #27b;">More..</a></span>
          </p>
        </div>
        </div>
                </div> 