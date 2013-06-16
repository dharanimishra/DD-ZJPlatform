<style>

.tbboxheadfnt {
    color: #8B8B8B;}
.tbboxdesc p {
    color: #B1B1B1;
    font-family: 'segoe ui',sans-serif;
    font-size: 14px!important;
    font-weight: 100;
}
.tbboxdesc {
    float: none;
    margin-top: 0;
    width: 328px;
}
.tbboxheadfntds {
    color: #4BB1CF;}
.tbboxdescds p {
    color: #4BB1CF;
    font-family: 'Segoe UI Light','Open Sans',Verdana,Arial,Helvetica,sans-serif;
    font-size: 13px!important;
}
.badge-warning{background-color: #999999;}
#publishtab .badge1{background-color: #F89406}

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
   
  color: #006666;
  font-size: 40px;
  line-height: 2;
  padding-top: 20px;
  text-align: center;
  width: 100%;
}
.coursedescription{
display:block;margin-top:10px

}

.coursedescription{
display:block;margin-top:10px;page-break-after : always

}
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
 <li style="margin-left:40px; color: #f06c0b;"><span><img src="/ziksana-web/resources/images/navarrow.png" style="margin-right:10px; height:22px;"> </span>Define Planner  </li>
 </a>

 <li> <span><img src="/ziksana-web/resources/images/navarrowb.png" style="margin-right:10px; height:22px;"> </span>  Review Playbook 
 </li>
 <li>
  <a href="/ziksana-web/zplaybook/unsecure/downloadPlayBook/${course.courseId }">
 <span><img src="/ziksana-web/resources/images/navarrowb.png" style="margin-right:10px; height:22px;"> </span>  Download Playbook
 </a>
  </li>
 </ul>
 
 </div> <!--end of navheadlp-->
  <div class="clearfix"></div>
<div id="definestructureformcontainer">

          <!--  <div class="page-header" style="padding-left:0px !important; margin-bottom:0px !important;">
                <div class="icon">
                    <img src="../images/icons/information_icon.png" style="height:25px;"/>
                </div>
                 <h1>Organize your course into course modules/chapters</h1>
            </div>End of page-header -->
                

  <div class="clearfix"></div>

<div style="margin-top:15px" > 
     <div class="playbookconatiner">
<div class="pbheader"><div class="pheaderL"><div class="phbox roundRb" style=" margin-right: 27px;background-color:#afb85b"></div>
<div class="phbox roundLB" style="background-color:#f2db75"></div></div>
<div class="pheadmiddle"> <label>${course.name }</label></div>
<div class="headerright"><div class="phboxblue"></div></div></div>
<div class="imgcontent">
<div class="imgcontentL">
<div class="userimg">
 <div style="overflow:auto;text-align:center;width:80%;padding:6px;">
 
  <img src="/ziksana-web/resources/images/playbook/usericon.png"  class="borderRb">
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
<div class="coursetitle" ><a href="#md">Module Discription with Content Listing</a><label><a href="#md">P2</a></label></div>
<div class="coursetitle" ><a href="#pd">Planner Details</a><label><a href="#pd">P3</a></label></div>
</div>
</div>
</div>
 <div class="imgcontentR" style="float:left;width:72%;text-align:right;margin-left:10px;"><img src="/ziksana-web/resources/images/playbook/medicalproffesional.png"></div>
</div>
<div class="Clearfix"></div>
<div class="coursedescription" id="cd">
<b>Course Description</b>
<p>Over the course of human history, people have developed many interconnected and validated ideas about the physical, biological, psychological, and social worlds. Those ideas have enabled successive generations to achieve an increasingly comprehensive and reliable understanding of the human species and its environment. The means used to develop these ideas are particular ways of observing, thinking, experimenting, and validating. These ways represent a fundamental aspect of the nature of science and reflect how science tends to differ from other modes of knowing.</p><p>

It is the union of science, mathematics, and technology that forms the scientific endeavor and that makes it so successful. Although each of these human enterprises has a character and history of its own, each is dependent on and reinforces the others. Accordingly, the first three chapters of recommendations draw portraits of science, mathematics, and technology that emphasize their roles in the scientific endeavor and reveal some of the similarities and connections among them.</p><p>

This chapter lays out recommendations for what knowledge of the way science works is requisite for scientific literacy. The chapter focuses on three principal subjects: the scientific world view, scientific methods of inquiry, and the nature of the scientific enterprise. Chapters 2 and 3 consider ways in which mathematics and technology differ from science in general. Chapters 4 through 9 present views of the world as depicted by current science; Chapter 10, Historical Perspectives, covers key episodes in the development of science; and Chapter 11, </p>
<p>Over the course of human history, people have developed many interconnected and validated ideas about the physical, biological, psychological, and social worlds. Those ideas have enabled successive generations to achieve an increasingly comprehensive and reliable understanding of the human species and its environment. The means used to develop these ideas are particular ways of observing, thinking, experimenting, and validating. These ways represent a fundamental aspect of the nature of science and reflect how science tends to differ from other modes of knowing.</p><p>

It is the union of science, mathematics, and technology that forms the scientific endeavor and that makes it so successful. Although each of these human enterprises has a character and history of its own, each is dependent on and reinforces the others. Accordingly, the first three chapters of recommendations draw portraits of science, mathematics, and technology that emphasize their roles in the scientific endeavor and reveal some of the similarities and connections among them.</p><p>

This chapter lays out recommendations for what knowledge of the way science works is requisite for scientific literacy. The chapter focuses on three principal subjects: the scientific world view, scientific methods of inquiry, and the nature of the scientific enterprise. Chapters 2 and 3 consider ways in which mathematics and technology differ from science in general. Chapters 4 through 9 present views of the world as depicted by current science; Chapter 10, Historical Perspectives, covers key episodes in the development of science; and Chapter 11, </p>
<div class="Clearfix"> </div>
<div class="toplink"><a href="#ctc">Top</a></div>
<div class="Clearfix"> </div>
<div class="chapeterfotter"><label class="pageno">01</label></div>
</div>
<div class="coursedescription" id="md"><b>Module Discription with Content Listing</b>
<p>Over the course of human history, people have developed many interconnected and validated ideas about the physical, biological, psychological, and social worlds. Those ideas have enabled successive generations to achieve an increasingly comprehensive and reliable understanding of the human species and its environment. The means used to develop these ideas are particular ways of observing, thinking, experimenting, and validating. These ways represent a fundamental aspect of the nature of science and reflect how science tends to differ from other modes of knowing.</p><p>

It is the union of science, mathematics, and technology that forms the scientific endeavor and that makes it so successful. Although each of these human enterprises has a character and history of its own, each is dependent on and reinforces the others. Accordingly, the first three chapters of recommendations draw portraits of science, mathematics, and technology that emphasize their roles in the scientific endeavor and reveal some of the similarities and connections among them.</p><p>

This chapter lays out recommendations for what knowledge of the way science works is requisite for scientific literacy. The chapter focuses on three principal subjects: the scientific world view, scientific methods of inquiry, and the nature of the scientific enterprise. Chapters 2 and 3 consider ways in which mathematics and technology differ from science in general. Chapters 4 through 9 present views of the world as depicted by current science; Chapter 10, Historical Perspectives, covers key episodes in the development of science; and Chapter 11, </p>
<p>Over the course of human history, people have developed many interconnected and validated ideas about the physical, biological, psychological, and social worlds. Those ideas have enabled successive generations to achieve an increasingly comprehensive and reliable understanding of the human species and its environment. The means used to develop these ideas are particular ways of observing, thinking, experimenting, and validating. These ways represent a fundamental aspect of the nature of science and reflect how science tends to differ from other modes of knowing.</p><p>

It is the union of science, mathematics, and technology that forms the scientific endeavor and that makes it so successful. Although each of these human enterprises has a character and history of its own, each is dependent on and reinforces the others. Accordingly, the first three chapters of recommendations draw portraits of science, mathematics, and technology that emphasize their roles in the scientific endeavor and reveal some of the similarities and connections among them.</p><p>

This chapter lays out recommendations for what knowledge of the way science works is requisite for scientific literacy. The chapter focuses on three principal subjects: the scientific world view, scientific methods of inquiry, and the nature of the scientific enterprise. Chapters 2 and 3 consider ways in which mathematics and technology differ from science in general. Chapters 4 through 9 present views of the world as depicted by current science; Chapter 10, Historical Perspectives, covers key episodes in the development of science; and Chapter 11, </p>
<div class="Clearfix"> </div>
<div class="toplink"><a href="#ctc">Top</a></div>
<div class="Clearfix"> </div>
<div class="chapeterfotter"><label class="pageno">02</label></div>
</div>
<div class="coursedescription" id="pd"><b>Planner Details</b>
<p>Over the course of human history, people have developed many interconnected and validated ideas about the physical, biological, psychological, and social worlds. Those ideas have enabled successive generations to achieve an increasingly comprehensive and reliable understanding of the human species and its environment. The means used to develop these ideas are particular ways of observing, thinking, experimenting, and validating. These ways represent a fundamental aspect of the nature of science and reflect how science tends to differ from other modes of knowing.</p><p>

It is the union of science, mathematics, and technology that forms the scientific endeavor and that makes it so successful. Although each of these human enterprises has a character and history of its own, each is dependent on and reinforces the others. Accordingly, the first three chapters of recommendations draw portraits of science, mathematics, and technology that emphasize their roles in the scientific endeavor and reveal some of the similarities and connections among them.</p><p>

This chapter lays out recommendations for what knowledge of the way science works is requisite for scientific literacy. The chapter focuses on three principal subjects: the scientific world view, scientific methods of inquiry, and the nature of the scientific enterprise. Chapters 2 and 3 consider ways in which mathematics and technology differ from science in general. Chapters 4 through 9 present views of the world as depicted by current science; Chapter 10, Historical Perspectives, covers key episodes in the development of science; and Chapter 11, </p>
<p>Over the course of human history, people have developed many interconnected and validated ideas about the physical, biological, psychological, and social worlds. Those ideas have enabled successive generations to achieve an increasingly comprehensive and reliable understanding of the human species and its environment. The means used to develop these ideas are particular ways of observing, thinking, experimenting, and validating. These ways represent a fundamental aspect of the nature of science and reflect how science tends to differ from other modes of knowing.</p><p>

It is the union of science, mathematics, and technology that forms the scientific endeavor and that makes it so successful. Although each of these human enterprises has a character and history of its own, each is dependent on and reinforces the others. Accordingly, the first three chapters of recommendations draw portraits of science, mathematics, and technology that emphasize their roles in the scientific endeavor and reveal some of the similarities and connections among them.</p><p>

This chapter lays out recommendations for what knowledge of the way science works is requisite for scientific literacy. The chapter focuses on three principal subjects: the scientific world view, scientific methods of inquiry, and the nature of the scientific enterprise. Chapters 2 and 3 consider ways in which mathematics and technology differ from science in general. Chapters 4 through 9 present views of the world as depicted by current science; Chapter 10, Historical Perspectives, covers key episodes in the development of science; and Chapter 11, </p>
<div class="Clearfix"> </div>
<div class="toplink"><a href="#ctc">Top</a></div>
<div class="Clearfix"> </div>
<div class="chapeterfotter"><label class="pageno">03</label></div>
</div>
</div>
                          
                             
    </div> <!--End of contentarea -->
  
</div> <!--End of definestructureformcontainer -->      