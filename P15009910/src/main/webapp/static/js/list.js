// JavaScript Document
$(function(){  
	$(".zh_block").on("click",".big_more_a",function(){
		if($(this).text()=="收起更多"){
			bigHeight();
			$(this).text("更多查询项");
		}else{
			$(".search_block").css({"height":"auto","overflow":"hidden"});
			$(this).text("收起更多");
		}
	})
	/*$(".zh_block").on("each",".select_block",function(){
		if($(this).height()>45){
			$(this).children(".more_a").show();
			$(this).css({"height":"40px","overflow":"hidden"});
		}
	})

	$(".zh_block").on("each",".select_block",function(){wxcalert(1);
		if($(this).height()>45){
			$(this).children(".more_a").show();
			$(this).css({"height":"40px","overflow":"hidden"});
		}
	})*/
	
	$(".zh_block").on("click",".select_block .more_a",function(){
		$(this).parent().css({"height":"auto","overflow":"hidden"});
		$(this).addClass("more_aa");
	})
	$(".zh_block").on("click",".select_block .more_aa",function(){
		$(this).parent().css({"height":"40px","overflow":"hidden"});
		$(this).removeClass("more_aa");
	})
	
	$(".zh_block").on("click",".show_block .more_cona",function(){
		$(this).parent().css({"height":"auto","overflow":"hidden"});
		$(this).addClass("more_conaa");
		if($(".big_more_a").text()=="更多查询项"){bigHeight();}
	})
	
	$(".zh_block").on("click",".show_block .more_conaa",function(){
		$(this).parent().css({"height":"35px","overflow":"hidden"});
		$(this).removeClass("more_conaa");
		if($(".big_more_a").text()=="更多查询项"){bigHeight();}
	})
	$(".zh_block").on("click",".select_cont li a",function(){
		$(this).parent().siblings().children("a").removeClass("on");
		$(this).parents(".select_block").next(".show_block").find("a").removeClass("on");
		$(this).parents(".select_block").next(".show_block").children("div").hide();
		$(this).addClass("on");
		if($(".big_more_a").text()=="更多查询项"){bigHeight();}
		if($(this).children().hasClass("icon_img")){
			var indexNu=$(this).parents("li").index();
			if(indexNu>1){
				if($(".show_block div").eq(indexNu-2).is(":visible")){
					$(".show_block div").eq(indexNu-2).hide();
				}else{
					$(".show_block div").eq(indexNu-2).show().siblings().hide();
					if($(".show_block div").eq(indexNu-2).height()>40){
						$(".show_block div").eq(indexNu-2).children(".more_cona").show();
						$(".show_block div").eq(indexNu-2).css({"height":"35px","overflow":"hidden"});
					}
					if($(".big_more_a").text()=="更多查询项"){bigHeight();}
				}
			}	
		}
	})
	
	$(".zh_block").on("mouseover",".select_cont li a",function(){
			return false;
	})
	
	$(".zh_block").on("click",".show_block a",function(){
		$(".show_block a").removeClass("on")
		$(this).addClass("on");
	})
	function bigHeight(){
		var searchH=$(".show_block").height()+199;
		$(".search_block").css({"height":searchH,"overflow":"hidden"});
	}
	
	$(".zh_block").on("click","#dq_gn",function(){
		$("#dq_gn_block").show();
		$("#dq_gj_block").hide();
		
	})
	$(".zh_block").on("click","#dq_gj",function(){
		$("#dq_gn_block").hide();
		$("#dq_gj_block").show();
	})
	$(".zh_block").on("change","#dq_gj_block input",function(){
    	if($("#gj").attr("checked")){
    		$("#gj_block").show();
    	}else{
			$("#gj_block").hide();
		}
	})
})
