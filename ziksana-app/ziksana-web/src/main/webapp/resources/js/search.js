             $(function() {
				/**
				* the element
				*/
				var $ui 		= $('#ui_search');
				
				/**
				* on focus and on click display the dropdown, 
				* and change the arrow image
				*/
				$ui.find('.sb_inputq').bind('focus click',function(){
					$ui.find('.sb_downq')
					   .addClass('sb_up')
					   .removeClass('sb_downq')
					   .andSelf()
					   .find('.sb_dropdownq')
					   .show();
				});
				
				/**
				* on mouse leave hide the dropdown, 
				* and change the arrow image
				*/
				$ui.bind('mouseleave',function(){
					$ui.find('.sb_up')
					   .addClass('sb_downq')
					   .removeClass('sb_up')
					   .andSelf()
					   .find('.sb_dropdownq')
					   .hide();
				});
				
				/**
				* selecting all checkboxes
				*/
				$ui.find('.sb_dropdownq').find('label[for="all"]').prev().bind('click',function(){
					$(this).parent().siblings().find(':checkbox').attr('checked',this.checked).attr('disabled',this.checked);
				});
            });
       