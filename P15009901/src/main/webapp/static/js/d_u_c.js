$(document).ready(function(){
	/*$(".g_tab a").click(function(){
		if($(this).hasClass("on"))
		{return true;}
		else
		{	var but1=$(this).attr("class");
			var block1=".block_"+but1;
			$($(block1)).show().siblings().hide();
			$(this).addClass("on").siblings().removeClass("on");} 
	}) */
	$(".g_tab a").click(function(){
		if($(this).hasClass("on"))
		{return true;}
		else
		{	
			if($(this).hasClass("tab_00")){
				$(".block_tab_1").show().siblings().hide();
				$(this).addClass("on").siblings().removeClass("on");
			}else{
				var but1=$(this).attr("class");
				var block1=".block_"+but1;
				$($(block1)).show().siblings().hide();
				$(this).addClass("on").siblings().removeClass("on");} 
		}
	}) 
	
	$(".g_crumbs .change_a").click(function(){
		$(".area_block").show();
		$(".area_block").mouseleave(function(){
			$(".area_block").hide();
		})
	})

	
	$(".g_nav_box .nav_1 a").click(function(){
		if($(this).parent().hasClass("nav_price"))
		{
			$(".select_list .a_2").show().html($(this).text()+" x");
			//$(".select_list .span_no").remove();
		}
		if($(this).parent().hasClass("nav_way"))
		{
			//$(".select_list .span_no").remove();
			$(".select_list .a_3").show().html($(this).text()+" x");
		}
		if($(this).hasClass("on") || $(this).hasClass("nav_on"))
		{return true;}
		else if($(this).hasClass("nav_list"))
		{	
			$(this).siblings().removeClass("nav_on");
			$(this).addClass("nav_on").siblings().removeClass("on");
			var aindex=$(this).index();
			$(".nav_list_block").fadeOut(0);
			$(".nav_list_block").eq(aindex-1).animate({height: 'toggle', opacity: 'toggle'}, "slow");
		} 
		else if($(this).hasClass("first_a") == true)
		{
		
			$(this).siblings().removeClass("nav_on");
			$(this).addClass("on").siblings().removeClass("on");
			$(".nav_list_block").fadeOut(0);
		}
		else
		{
			$(this).addClass("on").siblings().removeClass("on");
		}
	}) 
	
	$(".nav_list_block a").click(function(){
		$(".nav_list_block a").removeClass("on");
		$(this).addClass("on");
		$(".select_list .a_1").show().html($(this).text()+" x");
	})
	$("#no_seed").click(function(){
		$(".nav_list_block a").removeClass("on");
		$(".select_list .a_1").html($(this).text()+" x");
		$(".select_list .a_1").hide();
	})
	$("#no_seed2").click(function(){
		$(".select_list .a_2").html($(this).text()+" x");
		$(".select_list .a_2").hide();
		$(".enter_on").addClass("on")
	})
	$("#no_seed3").click(function(){
		$(".select_list .a_3").html($(this).text()+" x");
		$(".select_list .a_3").hide();
	})
	
	$(".select_list span").click(function(){
		if($(this).attr("class") == "a_1")
		{
			$("#no_seed").addClass("on").siblings().removeClass("nav_on");
			$(".nav_list_block a").removeClass("on");
			$(".select_list .a_1").html("不限");
			
		}
		else if($(this).attr("class") == "a_2")
		{
			$("#no_seed2").addClass("on").siblings().removeClass("on");
			$(".enter_on").addClass("on")
			$(".select_list .a_2").html("不限");
			
		}
		else
		{
			$("#no_seed3").addClass("on").siblings().removeClass("on");
			$(".select_list .a_3").html("不限");
		}
		$(this).hide();
	})
	
	$("#menu_but1").hide();
	$("#menu_but3").hide();
	$("#menu_but").click(function(){
		$("#menu_box").slideUp();
		$("#menu_but1").show();
		$("#menu_but").hide();
	})
	$("#menu_but1").click(function(){
		$("#menu_box").slideDown();
		$("#menu_but").show();
		$("#menu_but1").hide();
	})
	$("#menu_but2").click(function(){
		$("#menu_box2").slideUp();
		$("#menu_but3").show();
		$("#menu_but2").hide();
	})
	$("#menu_but3").click(function(){
		$("#menu_box2").slideDown();
		$("#menu_but2").show();
		$("#menu_but3").hide();
	})


	$(".select_box").click(function(){
		$(this).children(".select_list").toggle(); 
		return false; 
	})
	$(".select_list li").click(function(){
		$(this).addClass("selected").siblings().removeClass("selected");
		$(this).parent().siblings().children(".select_txt").text($(this).text());
	})
	$(document).click (function (e)
	{
		e = e || window.event;
		if (e.target != $ ('.select_box')[0] && e.target != $ ('.select_list li')[0])
			{
				$ ('.select_list').hide ();
				//return false; 
			}
	})

	
})
	


 