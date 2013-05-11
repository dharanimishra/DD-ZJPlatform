// JavaScript Document

$(document).ready(function()
{
	
	
 });		
		
		
	
$('#_isostd').isotope({
  // options
  itemSelector : '.item',
  layoutMode : 'fitRows'
});


$('#filters a').click(function(){
  var selector = $(this).attr('data-filter');
  $container.isotope({ filter: selector });
  return false;
});


$('#_isostd').isotope({ filter: '.my-selector' }, function( $items ) {
  var id = this.attr('id'),
      len = $items.length;
  console.log( 'Isotope has filtered for ' + len + ' items in #' + id );
});


 
function showall()
{
$('#_isostd').isotope({ filter: '.All' });
}

function showtperformer()
{
$('#_isostd').isotope({ filter: '.Tperformer' });
}

function showaverage()
{
$('#_isostd').isotope({ filter: '.Average' });
}

function showbaverage()
{
$('#_isostd').isotope({ filter: '.Baverage' });
}



