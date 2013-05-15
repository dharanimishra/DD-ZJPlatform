
<%@ page session="true"%>
<div class="page">
<div class="nav-bar bg-color-blueDark">
    <div class="nav-bar-inner padding10">
        <span class="pull-menu"></span>

        <a href="/"><span class="element brand">
            <img style="height:100px; margin-top: -62px" src="/ziksana-web/resources/assets/images/logo_ziksana_100.png" class="place-left">
            Ziksana - Learning Naturally &trade;
        </span></a>

        <!-- <div class="divider"></div> -->
	<c:if test="${not empty member.roleType}">
        <ul class="menu">
            <li><a data-tabname="home" href="/home.php"><i class="icon-home"></i> Home1</a></li>
            <li>
                <a data-tabname="courses" href="/ziksana-web/zcourse/createcourse"><i class="icon-stats"></i> Courses</a>
            </li>
            <li><a data-tabname="students" href="/students.php"><i class="icon-user-2"></i> Students</a>
            </li>
            <li><a data-tabname="analytics" href="/analytics.php"><i class="icon-stats-up"></i> Analytics</a>
            </li>

        </ul>
    
		<div id="account">
			<img src="/ziksana-web/${member.picturePath}"> <span class="name"><c:out value="${member.firstName}"/> <c:out value="${member.lastName}"/></span> 
			<div id="account_menu">
				<a href="#"><i class="icon-cog"></i>Settings</a>
				<a href="/ziksana-web/secure/logout">Logout</a>
				
			</div>
		</div>
		 </c:if>
    </div>
</div>
</div>


<script type="text/javascript">
$(function(){
    $('a[data-tabname="home"]').addClass('active');

});//end of doc ready
</script>

