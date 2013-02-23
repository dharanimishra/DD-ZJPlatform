// JavaScript Document


 $(document).ready(function(e) {
			
		 var theme = getTheme();
			$("#splitter").jqxSplitter({ theme: theme, panels: [{ size: 300}] });
				$(window).scrollTop(0,0);
					
        });  // end of document.ready
		
		