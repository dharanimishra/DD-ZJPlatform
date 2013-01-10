// JavaScript Document

function activecall()
{
	
			$('._course').slideDown('');
			$('#_isocourse').isotope({ filter: '.Active' });			
			$('#_lp').hide('');	
			$('._lo').hide('');	
			$('._lc').hide('');	
			
			$('._cklo').hide('');	
			$('._cklp').hide('');	
			$('._cklc').hide('');
			$('.arrowdown').show('');
			$('.createnew').hide();
			
			
		}


function closeactive(){

$('._cklo').show('');	
			$('._cklp').show('');	
			$('._cklc').show('');
			$('._ckcourse').show('');
			$('#course1').removeClass('marginl');	
			$('._course').hide('');	
			$('._lc').hide('');
			$('#_lp').hide('');
			$('._lo').hide('');
$('.arrowdown').hide('');
}

$(document).ready(function()
{
	
		$('#_lp').hide();
		$('._course').hide();
		$('._lo').hide();
		$('._lc').hide();
		
		$("._cklp").click( function(){
		
			$('#_lp').slideDown('');	
			$('._course').hide('');	
			$('._lo').hide('');	
			$('._lc').hide('');	
			
			$('._ckcourse').hide('');	
			$('._cklo').hide('');	
			$('._cklc').hide('');
			$('.arrowdown').show('');
			
		});
		
		$("._ckcourse").click( function(){
	$('#course1').addClass('marginl');	
			$('._course').slideDown('');
			$('#_isocourse').isotope({ filter: '.Draft' });	
			$('#draftc').addClass('hover-btn');	
			$('#draftc').removeClass('btn-info');	
			$('#_lp').hide('');	
			$('._lo').hide('');	
			$('._lc').hide('');	
			
			$('._cklo').hide('');	
			$('._cklp').hide('');	
			$('._cklc').hide('');
			$('.arrowdown').show('');
			
			
		});
		
		$("._cklo").click( function(){
			$('._lo').slideDown('');	
			$('._course').hide('');	
			$('#_lp').hide('');	
		   $('._lc').hide('');	
		   
		   $('._ckcourse').hide('');	
			$('._cklp').hide('');	
			$('._cklc').hide('');
			$('.arrowdown').show('');
		});
		
		$("._cklc").click( function(){
			$('._lc').slideDown('');	
			$('._lo').hide('');	
			$('._course').hide('');	
			$('#_lp').hide('');	
		  $('._ckcourse').hide('');	
			$('._cklp').hide('');	
			$('._cklo').hide('');
			$('.arrowdown').show('');
			
		});
		
		//top wizard active step 
	
			
        });		
		
		
	
$('#_isolp').isotope({
  // options
  itemSelector : '.item',
  layoutMode : 'fitRows'
});


$('#filters a').click(function(){
  var selector = $(this).attr('data-filter');
  $container.isotope({ filter: selector });
  return false;
});


$('#_isolp').isotope({ filter: '.my-selector' }, function( $items ) {
  var id = this.attr('id'),
      len = $items.length;
  console.log( 'Isotope has filtered for ' + len + ' items in #' + id );
});


 
function showall()
{
$('#_isolp').isotope({ filter: '.All' });
}

function showactive()
{
$('#_isolp').isotope({ filter: '.Active' });
}

function showdraft()
{
$('#_isolp').isotope({ filter: '.Draft' });
	
}

function showreview()
{
$('#_isolp').isotope({ filter: '.Review' });


}



	//end of isolp 

 $('#_isocourse').isotope({
  // options
  itemSelector : '.item',
  layoutMode : 'fitRows'
});


$('#filters a').click(function(){
  var selector = $(this).attr('data-filter');
  $container.isotope({ filter: selector });
  return false;
});


$('#_isocourse').isotope({ filter: '.my-selector' }, function( $items ) {
  var id = this.attr('id'),
      len = $items.length;
  console.log( 'Isotope has filtered for ' + len + ' items in #' + id );
});


 
function showallc()
{
$('#_isocourse').isotope({ filter: '.All' });
$('.createnew').hide();
$('#reviewc').removeClass('hover-btn');	
$('#draftc').removeClass('hover-btn');	
$('#reviewc').addClass('btn-info');	
$('#draftc').addClass('btn-info');	
$('#allc').addClass('hover-btn');
$('#allc').removeClass('btn-info');		
}

function showactivec()
{
$('#_isocourse').isotope({ filter: '.Active' });
$('.createnew').hide();
}

function showdraftc()
{
$('#_isocourse').isotope({ filter: '.Draft' });
$('.createnew').show();
$('#draftc').addClass('hover-btn');	
$('#reviewc').removeClass('hover-btn');	
			$('#draftc').removeClass('btn-info');
			$('#reviewc').addClass('btn-info');	
			$('#allc').addClass('btn-info');	
}

function showreviewc()
{
$('#_isocourse').isotope({ filter: '.Review' });
$('.createnew').hide();
$('#draftc').addClass('btn-info');
$('#reviewc').addClass('hover-btn');	
$('#reviewc').removeClass('btn-info');
$('#allc').addClass('btn-info');		
}
	//end of _isocourse	



$('#_isolo').isotope({
  // options
  itemSelector : '.item',
  layoutMode : 'fitRows'
});


$('#filters a').click(function(){
  var selector = $(this).attr('data-filter');
  $container.isotope({ filter: selector });
  return false;
});


$('#_isolo').isotope({ filter: '.my-selector' }, function( $items ) {
  var id = this.attr('id'),
      len = $items.length;
  console.log( 'Isotope has filtered for ' + len + ' items in #' + id );
});


 
function showalllo()
{
$('#_isolo').isotope({ filter: '.All' });
}

function showactivelo()
{
$('#_isolo').isotope({ filter: '.Active' });
}

function showdraftlo()
{
$('#_isolo').isotope({ filter: '.Draft' });
}

function showreviewlo()
{
$('#_isolo').isotope({ filter: '.Review' });
}
	//end of _isolo	



$('#_isolc').isotope({
  // options
  itemSelector : '.item',
  layoutMode : 'fitRows'
});


$('#filters a').click(function(){
  var selector = $(this).attr('data-filter');
  $container.isotope({ filter: selector });
  return false;
});


$('#_isolc').isotope({ filter: '.my-selector' }, function( $items ) {
  var id = this.attr('id'),
      len = $items.length;
  console.log( 'Isotope has filtered for ' + len + ' items in #' + id );
});


 
function showalllc()
{
$('#_isolc').isotope({ filter: '.All' });
}

function showactivelc()
{
$('#_isolc').isotope({ filter: '.Active' });
}

function showdraftlc()
{
$('#_isolc').isotope({ filter: '.Draft' });
}

function showreviewlc()
{
$('#_isolc').isotope({ filter: '.Review' });
}
	//end of _isolo			
		