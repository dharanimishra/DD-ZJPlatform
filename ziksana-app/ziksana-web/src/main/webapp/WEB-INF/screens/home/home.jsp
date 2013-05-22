
<script src="/ziksana-web/resources/js/custom/table/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="/ziksana-web/resources/js/custom/alertstodoevents.js"></script>
<script type="text/javascript" src="/ziksana-web/resources/js/custom/jquery.hovercard.js"></script>
<div id="Zikbreadcrumbback" style="margin-left: 20px;">

	<div class="Zikbreadcrumb f-l">

		<div class="fifteen columns" id="page-title">
			<a style="margin-top: -3px;" class="back"
				href="javascript:history.back()"></a>
			<p class="page-title">
				<span style="font-size: 13px; color: #6bbde8;"><fmt:message key="home.hometext"></fmt:message></span>
				Course
			</p>

		</div>

	</div>
	<!--end of breadcrumb-->



</div>

<div class="Clearfix"></div>



<div id="contentpanel">


	<div class="tilecontainer pull-left">




		<div class="tile bg-color-blue" style="width:270px;">
			 <c:if test="${empty member.picturePath}">
			 <p><img src="<c:out value="/ziksana-web${member.picturePath}"/> " align="left" style="margin-top: 15px; margin-left: 5px; height:100px; margin-right:10px;" class="img-polaroid"/></p>
			 </c:if>
			 <c:if test="${not empty ms.url && not empty member.picturePath}">
			 <p><img src="${ms.url}<c:out value="${member.picturePath}"/>" align="left" style="margin-top: 15px; margin-left: 5px; height:100px; margin-right:10px;" class="img-polaroid"/></p>
			 </c:if>
			 <p  class="profiletilename pull-left" style="font-size: 20px; width:120px;
			margin-top: 15px;"><c:out value="${member.firstName}"/> <c:out value="${member.lastName}"/></p>
			<p> <c:out value="${member.designation}"/> </p>
			
			 
			  <img  src="/ziksana-web/resources/images/home/badge.png" width="146" style="width:148px; margin-left:-4px;"/>
 
 
  </div>

<a href="/ziksana-web/zcourse/1/createcontent">
		<div class="tile bg-color-blueDark">
			<img class="tileimg" src="/ziksana-web/resources/images/icons/createcontent.png" />
			<h3><fmt:message key="home.createcontent"></fmt:message></h3>

		</div>
		</a>
		<div class="tile">

			<img class="tileimg" src="/ziksana-web/resources/images/icons/managecourse.png" />
			<h3><fmt:message key="home.managecontent"/></h3>

		</div>


		<div class="tile bg-color-blueDark">

			<img class="tileimg" src="/ziksana-web/resources/images/icons/editcoursecontent.png" />
			<h3 style="width: 90px;"><fmt:message key="home.editcourse"/></h3>

		</div>

<a href="/ziksana-web/zcourse/createcourse">
		<div class="tile bg-color-blue">

			<img class="tileimg" src="/ziksana-web/resources/images/icons/createcourse.png" />
			<h3 style="margin-left: 10px; font-size: 20px; width: 30px;"><fmt:message key="home.createcourse"/></h3>

		</div>
</a>



		<div class="tile bg-color-orange icon"
			style="width: 200px; height: 130px;">
			<div class="tile-content">
				<img src="/ziksana-web/resources/images/icons/courseanaltic.png" />
			</div>
			<div class="brand">
				<h3 style="margin-left: 6px; font-size: 22px; width:98%;"><fmt:message key="home.analytics"/></h3>
			</div>
		</div>



		<div class="tile bg-color-orange icon  mt-changescene"
			style="width: 200px; height: 130px;">
			<div class="tile-content">
				<img src="/ziksana-web/resources/images/icons/announcement.png" alt="mes" />
			</div>
			<div class="brand">
				<h3 style="margin-left: 10px; font-size: 22px;"><fmt:message key="home.announcement"/></h3>
			</div>
		</div>






		<div class="Clearfix"></div>


	</div>
	<!--end of tilescontainer-->



	<div class="contentarea pull-right"
		style="height: 406px; margin-top: 22px;">

		<div class="imagewrapper" style="height: 395px;">


			<!-- __________________________________ Panel head ____________________ -->


			<div class="panelhead" style="margin-top: -12px;">

				<ul>
					<li><a href="#" class="tagevent"> Events </a></li>
					<li><a href="#" class="tagtask"> To Do </a></li>


				</ul>

			</div>
			<!--end of panel head-->



			<!-- __________________________________ alert container ____________________ -->

			<div class="contentareaevent"
				style="position: absolute; width: 690px;">

				<div class="eventheader"
					style="height: 50px; background-color: rgba(50, 50, 50, 0.75); padding: 10px; border-bottom: 1px solid #ccc;">

					<p class="pull-left"
						style="color: rgb(255, 255, 255); font-size: 15px; margin-top: 5px;">
						List of Events Today</p>




				</div>
				<!--end of eventheader-->




				<div class="eventcontent"
					style="height: 280px; overflow: auto; overflow-x: hidden;">
					<table class="table table-hover table-striped">

						<tbody>
							<tr>
								<td>12:45 pm</td>
								<td>02.45 pm</td>
								<td>Meeting with Ziksana</td>

							</tr>
							<tr>
								<td>12:45 pm</td>
								<td>02.45 pm</td>
								<td>Football Match at university Ground</td>

							</tr>
							<tr>
								<td>12:45 pm</td>
								<td>02.45 pm</td>
								<td>Meeting with Professor John</td>

							</tr>

							<tr>
								<td>12:45 pm</td>
								<td>02.45 pm</td>
								<td>Meeting with Professor John</td>

							</tr>

							<tr>
								<td>12:45 pm</td>
								<td>02.45 pm</td>
								<td>Meeting with Professor John</td>

							</tr>

							<tr>
								<td>12:45 pm</td>
								<td>02.45 pm</td>
								<td>Meeting with Professor John</td>

							</tr>



						</tbody>
					</table>

				</div>
				<!--end of eventcontent-->



				<div class="eventfooter"
					style="height: 31px; background-color: rgba(50, 50, 50, 0.75); padding: 10px; border-top: 1px solid #ccc; padding: 5px; padding-left: 10px; color: #fff;">
					<p class="pull-right" style="color: #fff; font-size: 10px;">
						Manage Events <a href="#linkurl"> <img
							src="/ziksana-web/resources/images/icons/calendar.png"
							style="height: 20px; margin-left: 6px; vertical-align: middle;" />
						</a>
					</p>

				</div>
				<!--end of eventfooter-->


			</div>
			<!--end of contentareaevent-->



			<!-- __________________________________ to do container ____________________ -->


			<div class="contentareatodo" style="position: absolute; width: 690px;">

				<div class="eventheader"
					style="height: 50px; width: 690px;background-color: rgba(50, 50, 50, 0.75); padding: 10px; border-bottom: 1px solid #ccc;margin-top:-12px;">

					<p class="pull-left"
						style="color: rgb(255, 255, 255); font-size: 15px; margin-top: 5px;">
						To DO List</p>




				</div>
				<!--end of eventheader-->




				<div id="todos_placeholder" class="eventcontent"
					style="height: 270px; overflow: auto; overflow-x: hidden;">
					</div>
				<!--end of eventcontent-->



				<div class="eventfooter"
					style="height: 30px;width: 691px; background-color: rgba(50, 50, 50, 0.75); padding: 10px; border-top: 1px solid #ccc; padding: 5px; padding-left: 10px; color: #fff;">

					<p class="pull-right" style="color: #fff;">
						<a href="#linkurl" class="managetodo" coords="#fff !important;">
							<img src="/ziksana-web/resources/images/icons/settings.png" align="Manage todo"
							style="height: 20px; margin-left: 6px; vertical-align: middle;" />
						</a>
					</p>

					<div class="clearfix"></div>

				</div>
				<!--end of eventfooter-->


				

			</div>
			<!--end of contentareaevent-->



			<!-- __________________________________ to do container ____________________ -->


			<div class="contentareamanagetodo"
				style="position: absolute; width: 690px;">

				<div class="eventheader"
					style="height: 50px; background-color: rgba(50, 50, 50, 0.75); padding: 10px; border-bottom: 1px solid #ccc;margin-top: -12px;">

					<p class="pull-left"
						style="color: rgb(255, 255, 255); font-size: 15px; margin-top: 5px;">
						To DO List</p>

					<p class="pull-right" style="color: #fff;">
						<a href="#linkurl"> <img src="/ziksana-web/resources/images/content/plus.png"
							style="height: 25px; margin-top: 10px;" title="Add To DO"
							class="addtodobtn" id="sample_editable_1_new" /></a>
					</p>


				</div>
				<!--end of eventheader-->




				<div class="eventcontent" style="height: 270px; overflow: auto; overflow-x: hidden; width: 100%">


					<div class="portlet box blue">

						<div class="portlet-body">
					<div id="add_todo_fields_container" style="display:none;">
							<select id="todo_categories" style="margin-left:50px;width:150px;">
								
							</select>
							<span id="add_new_category_form" style="display:none;">
							 <input id="todo_category_name"/><!-- <button onclick="add_new_category_item();">Add</button> -->
							</span>
								<input id="todo_description" style="margin-left:50px;width:200px;height:28px;">
							<a onclick="addTodo()" style="margin-left:30px;color:white;">Save</a><a onclick="hideTodoAdd()" style="margin-left:30px;color:white;">Cancel</a>
						</div>
					<div id="todos_placeholder_more" class="eventcontent" style="height: 270px; overflow: auto; overflow-x: hidden;">
					
					</div>
							
					</div>
				</div>
					<!-- END EXAMPLE TABLE PORTLET-->

				</div>
				<!--end of eventcontent-->



				<div class="eventfooter"
					style="height: 30px; background-color: rgba(50, 50, 50, 0.75); padding: 10px; border-top: 1px solid #ccc; padding: 5px; padding-left: 10px; color: #fff;">


				</div>
				<!--end of eventfooter-->


			</div>
			<!--end of contentareaevent-->


		</div>
		<!--end of image wrapper -->

	</div>
	<!--end of contentarea-->

</div>
<!--end of contentpanel-->


</div>
<!--end of leftpanel-->

</section>
<!--end of section leftpanel-->


<div class="Clearfix"></div>


</div>
<!--end of body wrapper-->
<style>
.table-striped tbody tr:nth-child(odd) td, .table-striped tbody tr:nth-child(odd) th {
background-color: rgb(18, 122, 163);
}

*input [type="text"]
{
background-color:rgb(180, 200, 213);	
}

#sample_editable_1_info
{
font-size:13px;
color:#fff;	
}

/* .metrouicss a
{
color:#fff;	
}

.metrouicss a:hover
{
color:#333;	
} */

.tileheadaa
{
margin-left:20px;
font-size: 20px;
font-size:30px;	
}

table tr th
{
color:#fff;
font-size:18px;	
border:none !important;
}

table tr td
{
color:#fff;
font-size:14px;	
border:none !important;
}
.hc-details
{
width: 300px;
background-color: rgb(56, 111, 143) !important;
margin-top:10px; !important;
display: none;	
}

.table-hover tbody tr:hover td, .table-hover tbody tr:hover th {
background-color: rgba(206, 204, 204, 0.27);
}
#sample_editable_1_length
{
display:none;
}

#sample_editable_1_filter
{
display:none;	
}
</style>
 <script src="/ziksana-web/resources/js/custom/table/breakpoints/breakpoints.js"></script>	
	<!-- ie8 fixes -->
	<!--[if lt IE 9]>
	<script src="assets/js/excanvas.js"></script>
	<script src="assets/js/respond.js"></script>
	<![endif]-->	
	
	<script type="text/javascript" src="/ziksana-web/resources/js/custom/table/data-tables/jquery.dataTables.js"></script>
	<script type="text/javascript" src="/ziksana-web/resources/js/custom/table/data-tables/DT_bootstrap.js"></script>
	<script src="/ziksana-web/resources/js/custom/table/js/app.js"></script>		
	<script>
		jQuery(document).ready(function() {			
			// initiate layout and plugins
			App.setPage("table_editable");
			App.init();		
			$('table').dataTable({"bFilter": false,"bInfo": false});
			
		});
		
	</script>