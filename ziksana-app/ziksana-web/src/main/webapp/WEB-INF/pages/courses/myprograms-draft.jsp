<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="${staticFileServer}resources/js/jquery.isotope.min.js"></script>
<script type='text/javascript' src="${staticFileServer}resources/js/custom/myprogram.js"></script>


<script>
    
        $(document).ready(function() {
        	
            $('.js-activated').dropdownHover();
            
            draftcall();
            $('#homepage_nav').removeClass('current');
            $('#myprograms_nav').addClass('current');
          });
  </script>



<div>

	<section>
		<div class="section">
			<!--Left column-->

			<!--End Left column-->
			<!--Center Container-->
			<div class="center for-rounded-box all-box-shadow"
				style="width: 881px; padding-left: 100px;">

				<!-- learning programs-->

				<div class="col-lft _cklp demo_message_container1"
					style="border: 1px solid #ccc;">
					<div class="demo_message1" style="font-size: 14px;">For
						Demonstration Only. Functionality to be available in subsequent
						Playpens</div>
					<div
						class="bckground-wihte for-rounded-box all-box-shadow creat-boxhover">

						<p class="titles-info1 text-size-px18 font-Signika blue uppercase">Learning
							Program</p>
						<p class="p-p create-box-width f-l"
							style="margin-bottom: 5px; margin-left: 3px; margin-top: -4px;">
							<span style="font-weight: bold;"> Learning Programs </span>
							Defines the Curriculum necessary to meet the Learning
							Objectives..
						</p>
						<span
							class="number-creat-box f-r font-Signika bold for-rounded-box"
							style="margin-top: -4px; font-size: 18px; color: #fff;">8<span
							style="font-size: 14px;"> Learning Programs</span>
						</span>

						<div class="icons-list">
							<a href="#linkurl" rel="tipsy" title="List View"
								class="Icon-listp icons-right"></a>


						</div>
					</div>
				</div>
				<!--end of learning programs -->

				<!--course-->
				<div class="col-lft _cklp" style="width: 10px;"></div>
				<div id="course1" class="col-lft _ckcourse"
					style="border: 1px solid #ccc;">

					<div
						class="bckground-wihte for-rounded-box all-box-shadow creat-boxhover">
						<p class="titles-info1 text-size-px18 font-Signika blue uppercase">Course</p>

						<p class="p-p create-box-width f-l"
							style="margin-bottom: 5px; margin-left: 3px; margin-top: -4px;">
							<span style="font-weight: bold;">Course </span> is a Learning
							Unit that Helps in Achieving the Learning Objectives of the
							Learning Program..
						</p>
						<p class="number-creat-box f-r font-Signika bold for-rounded-box"
							style="margin-top: -4px; font-size: 20px; color: #fff;">
							${courseCount} <span style="font-size: 15px;">Courses</span>
						</p>

						<div class="icons-list">
							<a href="#linkurl" rel="tipsy" title="List View"
								class="Icon-listp icons-right"></a> <img
								src="../resources/images/nav-arow.png" class="arrowdown"
								style="padding-top: 35px; padding-left: 95px; display: none;">
						</div>

					</div>

				</div>

				<!-- end of course -->

				<!--learning objects-->
				<div class="col-lft _cklp" style="width: 10px;"></div>
				<div class="col-lft _cklo demo_message_container1"
					style="border: 1px solid #ccc;">
					<div class="demo_message1" style="font-size: 14px;">For
						Demonstration Only. Functionality to be available in subsequent
						Playpens</div>
					<div
						class="bckground-wihte for-rounded-box all-box-shadow creat-boxhover">

						<p class="titles-info1 text-size-px18 font-Signika blue uppercase">Learning
							object</p>
						<p class="p-p create-box-width f-l"
							style="margin-bottom: 5px; margin-left: 3px; margin-top: -4px;">
							<span style="font-weight: bold;">Learning Object </span> is an
							Learning Unit that can be used as a building block for creating a
							course..
						</p>
						<p class="number-creat-box f-r font-Signika bold for-rounded-box"
							style="margin-top: -4px; font-size: 18px; color: #fff;">
							4<span style="font-size: 14px;"> Learning Objects</span>
						</p>

						<div class="icons-list">
							<a href="#linkurl" rel="tipsy" title="List View"
								class="Icon-listp icons-right"></a>

						</div>
					</div>
				</div>

				<!--end of learning objects-->

				<!--Courses container-->

				<div class="center for-rounded-box all-box-shadow _course"
					style="width: 973px; margin-left: -98px; border: 1px solid #a9a5a5; background: #e1e1e1;">
					<div style="margin-left: 850px; disply: table; top: -100">


						<div class="createnew" style="display: table-cell; width: 100px;">
							<a href="/ziksana-web/zcourse/createcourse"><img
								src="../resources/images/plus.png" width=12px, height=12px>&nbsp;Create
								New</a>

						</div>
						<div style="display: table-cell; padding-left: 20px;">
							<a href="#"> <img src="../resources/images/cross.png"
								onclick="closeactive()"></a>
						</div>
					</div>
					<div class="programisotope" id="mnuiso"
						style="height: 40px; margin-top: -20px; margin-right: 800px; width: 250px;">

						<li><a class="btn btn-info" href="#linkurl" id="activec"
							onClick="showactivec()" style="float: right;">Active</a></li>
						<li><a class="btn btn-info" href="#linkurl" id="reviewc"
							onClick="showreviewc()" style="float: right;">Review</a></li>
						<li><a class="btn btn-info" href="#linkurl" id="draftc"
							onclick="showdraftc()" style="float: right;">Draft</a></li>


						<li><a class="btn btn-info" href="#linkurl" id="allc"
							onclick="showallc()" style="float: right;">All</a></li>



					</div>
					<!--end of zeni isotope-->




					<div id="_isocourse" style="margin-left: 30px;">



						<!--learning objects-->
						<c:forEach var="course" items="${courses}">

							<div class="col-lft li-1 All Draft"
								id="courseModel_${course.coursesId}"
								style="border: 1px solid #ccc; width: 170px;">

								<div
									class="bckground-wihte for-rounded-box all-box-shadow creat-boxhover">

									<p style="height: 30px;"
										class="titles-info1 text-size-px14 font-Signika blue uppercase">
										<c:out value="${course.name}" />
									</p>

									<p class="p-p create-box-width f-l"
										style="margin-bottom: 5px; margin-left: 3px; margin-top: -4px;">
										<c:choose>
											<c:when test="${course.thumbnailPicturePath != ''}">
												<img
													src="<c:out value="${ms.url}"/><c:out value="${course.thumbnailPicturePath}"/>"
													width="148" height="97" />
											</c:when>
											<c:otherwise>
												<img src="/ziksana-web/resources/images/default-course.jpg"
													width="148" height="97" />
											</c:otherwise>
										</c:choose>
									</p>
									<div class="icons-list">
										<a
											href="/ziksana-web/zcourse/editcourse/COURSE_${course.coursesId}"
											rel="tipsy" title="Edit" class="Icon-edit icons-right"
											style="margin-right: -6px;"></a> <a
											onclick="delete_coursebycourseid(${course.coursesId})"
											rel="tipsy" title="Delete" class="Icon-delete icons-right"
											style="margin-right: -6px;"></a>
									</div>
								</div>
							</div>
						</c:forEach>



					</div>
					<!--end of isotope-->

				</div>
				<!--end of Course container-->

				<!--learning content-->


				<div class="col-lft _cklc demo_message_container1"
					style="border: 1px solid #ccc;">
					<div class="demo_message1" style="font-size: 14px;">For
						Demonstration Only. Functionality to be available in subsequent
						Playpens</div>
					<div
						class="bckground-wihte for-rounded-box all-box-shadow creat-boxhover">

						<p class="titles-info1 text-size-px18 font-Signika blue uppercase">Learning
							Content</p>
						<p class="p-p create-box-width f-l"
							style="margin-bottom: 5px; margin-left: 3px; margin-top: -4px;">
							<span style="font-weight: bold;">Learning Contents </span> are
							materials that can be associated to a course or a to meet the
							Objectives..
						</p>
						<p class="number-creat-box f-r font-Signika bold for-rounded-box"
							style="margin-top: -4px; font-size: 18px; color: #fff;">
							3 <span style="font-size: 14px;"> Learning Contents</span>
						</p>

						<div class="icons-list">
							<a href="#linkurl" rel="tipsy" title="List View"
								class="Icon-listp icons-right"></a>


						</div>
					</div>
				</div>

				<!--end of learning content-->









			</div>


			<!--learning programs container-->
			<div style="height: 500px;">
				<!--This div is for giving a gap between footer and content-->


				<div class="center for-rounded-box all-box-shadow" id="_lp"
					style="width: 973px; padding-left: 10px; padding-right: -10px;">
					<div class="programisotope"
						style="height: 40px; margin-right: 800px; width: 973px; float: left;">



						<li><a class="btn btn-info" href="#linkurl"
							onClick="showreview()" style="float: right;">Review</a></li>
						<li><a class="btn btn-info" href="#linkurl"
							onclick="showdraft()" style="float: right;">Draft</a></li>
						<li><a class="btn btn-info" href="#linkurl"
							onclick="showall()" style="float: right;">All</a></li>



					</div>
					<!--end of zeni isotope-->
					<a href="#"> <img src="../resources/images/cross.png"
						onclick="closeactive()" style="margin-left: 900px;"></a> <br>


					<!--end of isotope-->

				</div>
				<!--end of for learning programs container-->







			</div>
			<!--learning object container-->


		</div>
</div>
<!--End Center Container-->
</div>
<!--End Right column-->
</section>
<!--End Main Content-->
<!--Current Progress-->
<div class="col border-top">
	<div class="collapse">
		<h3 class="border-left border-right border-top">Your current
			progress [ Starting ... ]</h3>
		<div>
			<p class="caption text-size-px18">Your progress this session...</p>
		</div>
	</div>
</div>

<style type="text/css">
.ui-progressbar .ui-progressbar-value {
	background-image: url(images/pbar-ani.gif);
}


body {
	background: #F9F9F9 url("../resources/images/grain-light.png");
}

#jDash {
	min-height: 500px;
	/* [disabled]background: white; */
}

.demo1 {
	border: 1px solid #ccc;
	margin-top: 10px;
	font-size: 12px;
}

.demo1 div div {
	padding: 10px;
	border-bottom: 1px solid #ccc;
}

.demo_message_container1 {
	position: relative;
}

.demo_message_container1:hover .demo_message1 {
	display: block !important;
	padding-top: 22% !important;
}

.demo_message1 {
	background: none repeat scroll 0 0 rgba(0, 0, 0, 0.8);
	bottom: 0;
	color: white;
	display: none;
	font-size: 10px;
	left: 0;
	padding: 1em;
	position: absolute;
	right: 0;
	top: 0;
	text-align: center;
	vertical-align: middle;
	z-index: 99;
}

.hover-btn {
	color: #000000;
	text-shadow: 0 -1px 0 rgba(0, 0, 0, 0.25);
}

.marginl {
	margin-left: -80px;
}

.titles-info1 {
	background-color: rgba(218, 216, 216, 0.17);
	border-bottom: 1px solid #CCCCCC;
	border-radius: 3px 3px 0 0;
	display: block;
	margin: 0 0 10px;
	padding: 7.5px 13px;
	position: relative;
}
</style>





