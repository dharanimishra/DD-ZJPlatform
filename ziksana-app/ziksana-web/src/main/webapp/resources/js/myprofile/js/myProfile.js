$(document).ready(function(e) {
        //hide show security and settings
		$('#showSet').hide();
		$('#arrowDown').css("margin-left", "106px").fadeIn();
		$('#arrowLeft').hide();
		
		//on click of security and settings
		$('#security').click( function(){
			$('#arrowDown').css("margin-left", "106px").fadeIn();
			$('#showSec').fadeIn();
			$('#showSet').hide();
			$('#sec').addClass('current');
			$('#set').removeClass('current');
		});
		$('#settings').click( function(){
			$('#arrowDown').css("margin-left", "185px").fadeIn();
			$('#showSet').fadeIn();
			$('#showSec').hide();
			$('#set').addClass('current');
			$('#sec').removeClass('current');
		});
		
		$('#security').hover( function(){
			$('#sec').css('color', '#0099FF');
		},function(){
			$('#sec').css('color', '');
		});
		
		
		$('#settings').hover( function(){
			$('#set').css('color', '#0099FF');
			},function(){
			$('#set').css('color', '');
		});
		
		//hide botom panel
		$('#showSocial').hide();
		$('#showContent').hide();
		$('#showAccount').hide();
		//onclick of the bottom panel profile
		$('#learning').click( function(){
			$('#showLearning').fadeIn();
			$('#showSocial').hide();
			$('#showContent').hide();
			$('#showAccount').hide();
			$('#learning').addClass('current');
			$('#social').removeClass('current');
			$('#content').removeClass('current');
			$('#account').removeClass('current');
		});
		
		$('#social').click( function(){
			$('#showLearning').hide();
			$('#showAccount').hide();
			$('#showContent').hide();
			$('#showSocial').fadeIn();
			$('#social').addClass('current');
			$('#learning').removeClass('current');
			$('#content').removeClass('current');
			$('#account').removeClass('current');
		});
		
		$('#content').click( function(){
			$('#showLearning').hide();
			$('#showSocial').hide();
			$('#showAccount').hide();
			$('#showContent').fadeIn();
			$('#content').addClass('current');
			$('#learning').removeClass('current');
			$('#social').removeClass('current');
			$('#account').removeClass('current');
		});
		
		$('#account').click( function(){
			$('#showLearning').hide();
			$('#showSocial').hide();
			$('#showContent').hide();
			$('#showAccount').fadeIn();
			$('#account').addClass('current');
			$('#learning').removeClass('current');
			$('#social').removeClass('current');
			$('#content').removeClass('current');
		});
    });