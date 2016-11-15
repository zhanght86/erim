$(".leftdiv dt").css({"background": "url('"+ _staticRoot +"/images/bg0.gif') repeat-x"});
$(".leftdiv>dl>div>dd>span").css({"background": "url('"+ _staticRoot +"/images/houtai5.png') no-repeat","background-position":"left","color":"#fff"});
$(function(){
	$(".leftdiv dd").hide();
	$(".leftdiv dt").click(function(){
		$(".leftdiv dt").css({"background": "url('"+ _staticRoot +"/images/bg0.gif') repeat-x","color":"#000"});
		$(this).css({"background": "url('"+ _staticRoot +"/images/bg1.gif') repeat-x","color":"#fff"});
		$(this).parent().find('dd').removeClass("menu_chioce");
		$(".menu_chioce").slideUp(); 
		$(this).parent().find('div').removeClass("menu_chioe");
		$(".menu_chioe").slideUp(); 
		$(this).parent().find('dd').slideToggle(0);
		$(this).parent().find('div').slideToggle(0);
		$(this).parent().find('dd').addClass("menu_chioce");
		$(this).parent().find('div').addClass("menu_chioe");
		var liHeight = $('.leftdiv dt').height();
		var liindex = $('.leftdiv dt').index(this);
		$('.leftdivp img').stop(false,true).animate({'top' : liindex * liHeight + 'px'},300);
	});
	$('.leftdiv>dl>div>dd>span').click(function() {
    	$(".leftdiv>dl>div>dd>span").css({"background": "url('"+ _staticRoot +"/images/houtai5.png') no-repeat","background-position":"left","color":"#fff"});
		$(this).css({"background": "url('"+ _staticRoot +"/images/houtai6.png') no-repeat","background-position":"left","color":"#ff9640"});
		
		//更改标题指向
		var html = $(this).attr("parent") + "&nbsp;>&nbsp;" + $(this).text();
		$("#titleSpan").html(html);
		
		//加载路径改变右侧状态
		var url = $(this).attr("text");
		index.load(url);
	});
   
    $(".mtabtop li").click(function(){
    	var liindex = $('.mtabtop li').index(this);
		$(this).addClass('mtabtopli').siblings().removeClass('mtabtopli');
    	  var index = $(".mtabtop li").index($(this));
        $('.mtabbiger .mtabbox').eq(index).show(0).siblings(".mtabbiger .mtabbox").hide(0);
    });
});