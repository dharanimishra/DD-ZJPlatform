// JavaScript Document

$(document).ready(function()
{
	 var theme = getTheme();
            // for hiding th edivs on pageload
			$(".cancellinkassociatecontent").click(function(e) {
            });
			$("#splitter").jqxSplitter({ theme: theme, panels: [{ size: 280}] });
				$(window).scrollTop(0,0);
			
           
//		   jQuery("#Associatequalifier").validationEngine('attach', {
//				  onValidationComplete: function(form, status){
//					if(status == true)
//					{
//						  getassociatecontentsave();
//						  createassoc();
//						 $("#Associatequalifier").submit();
//					}
//				  }  
//				});    
	
	
    }); // end of document.ready
	
	
