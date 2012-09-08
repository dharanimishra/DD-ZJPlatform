// Script for the Progess Bar in Video2.Html

//highlight
  $(document).ready(function () {
            $('.highlights, textarea, select').addClass("setIdle");
            $('.highlights, textarea, select').focus(function () {
                $(this).removeClass("setIdle").addClass("setFocus");
            });

            $('.highlights, textarea, select').blur(function () {
                $(this).removeClass("setFocus").addClass("setIdle");
            });

            //Applying MSIE Check
            if ($.browser.msie) {
                $("select").bind("focusin", function () {
                    $(this).addClass("setFocus");
                });

                $("select").bind("focusout", function () {
                    $(this).removeClass("setFocus");
                });
            }

        });



//End highlight



	$(function() {
		$( "#progressbar" ).progressbar({
			value: 37
		});
	});
	
//toc syllabus
	$(function() {
		$( "#toc-list" ).dialog({
			autoOpen: false,
			show: "blind",
			hide: "fade",
		});

		$( "#toc" ).click(function() {
				$( "#toc-list" ).dialog( "open" );
			
		});
		
//		
	});






