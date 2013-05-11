<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

            
  <script>

        
//rating-star	
$('#edu-star').raty({
					
					click		: function(score, evt) {
						$(this).fadeOut(function() { $(this).fadeIn(); });
					},
					targetKeep	: true,
					path:'images/img/',
					score		: 4,
					cancel: true
				});
        </script> 

        