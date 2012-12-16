$(document).ready(function () {
            var theme = getTheme();
            // Create jqxTree with drag n drop
           	$('#jqxTree').jqxTree({ allowDrag: true, allowDrop: true, width: '240px', theme: theme });
			
				// $('#jqxTree').jqxTree({ theme: theme });
/*			$('#jqxExpander').jqxExpander({ showArrow: false, toggleMode: 'none', width: '240px', theme: theme });
*/			//spliiter
//			$("#splitter").jqxSplitter({ theme: theme, panels: [{ size: 180}] });

			 $(document).bind('contextmenu', function (e) {
                if ($(e.target).parents('.jqx-tree').length > 0) {
                    return false;
                }
                return true;
            });
	});