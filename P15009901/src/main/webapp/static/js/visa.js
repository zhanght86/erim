 $(function(){	
 $('.visa_ctertop li').click(function(){
        var liindex = $('.visa_ctertop li').index(this);
        $(this).addClass('visa_ctertoplihover').siblings().removeClass('visa_ctertoplihover');
        $('.visa_cterbig .visa_cterbox').eq(liindex).fadeIn(150).siblings('.visa_cterbig .visa_cterbox').hide();
    });
 $('.visact_bul li').click(function(){
        var liindex = $('.visact_bul li').index(this);
        $(this).addClass('visact_bullihover').siblings().removeClass('visact_bullihover');
        $('.visa_cterboxbiger .visa_cterboxbd').eq(liindex).fadeIn(150).siblings('.visa_cterboxbiger .visa_cterboxbd').hide();
        var liWidth = $('.visact_bul li').width();
		$('.visact_bul p').stop(false,true).animate({'left' : liindex * liWidth + 'px'},300);
    });
});