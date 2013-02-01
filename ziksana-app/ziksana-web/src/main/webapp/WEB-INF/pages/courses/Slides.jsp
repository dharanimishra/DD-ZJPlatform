
<%@ page language="java" contentType="text/html"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!doctype html>
    <head>
        <title>Title</title>
    
        <style type="text/css" media="screen">
.slides_container {
  height: 487px;
  margin: 0 auto;
  width: 696px;
}
            .slides_container div {
                width:696px;
                height:487px;
                display:block;
                overflow: auto;
            }
.pagination {
  margin: 0.25em 0;
  padding: 0;
  text-align: center;
}
            .pagination li {
	  list-style: none outside none;
	  margin-left: .5em;
	  display: inline-block;
	}
	.pagination li a {display:inline-block; text-align: center; width: 16px; height: 16px; border-radius: 30px; background: black; color: white; line-height: 16px; font-size: 10px; text-decoration: none; }
	.pagination li a:hover {background: silver; }
	
#slides .next, #slides .prev {
  background: none repeat scroll 0 0 black;
  border-radius: 3px;
  color: white;
  cursor: pointer;
  display: inline-block;
  font-family: arial;
  font-size: 12px;
  margin: 1em;
  padding: 0.25em 0.5em;
  position: absolute;
  text-decoration: none;
  top: 45%;
  z-index: 10;
  font-weight: bold;
}
#slides .next:hover, #slides .prev:hover {background: #222;}
#slides .next {
  right: 0px;
}
#slides .prev {
  left: 0px;
}

.pagination li.current a {
  background: none repeat scroll 0 0 orange;
}
	        </style>
    
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>
        <script src="/ziksana-web/resources/js/slides.jquery.js"></script>
    
        <script>
            $(function(){
                $("#slides").slides({generateNextPrev: true});
            });
        </script>
    </head>
    
    
    <body>
        <div id="slides">
            <div class="slides_container">	
			<c:forEach var="i" begin="0" end="${content.numberOfThumbnails-1}" step="1" varStatus ="status">
				<div>
				<image src="https://video.beta.ziksana.com/${content.thumbnailPicturePath}img<c:out value="${i}" />.jpg" />
				</div>
			</c:forEach>
          

            </div>
        </div>

    </body>
