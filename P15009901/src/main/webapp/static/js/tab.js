/**
 * Created by ��Ц�� on 2015/11/13.
 */
$(function(){
    //tab������ʾ
    $("#tab-right .tab-right-div:not(:first)").hide();
    $("#tab-left ul li").click(function(){
        $(this).addClass('tab-left-hover').siblings().removeClass('tab-left-hover');
        var num = $("#tab-left ul li").index(this);
        $("#tab-right .tab-right-div").eq(num).show().siblings("#tab-right .tab-right-div").hide();
    });

//    ͷ���»��߻���,ҳ���滻
    $(".tab-right-div .tab-top .tab-top-item").click(function(){
        $(this).addClass("subline").siblings().removeClass("subline");
        var num = $(".tab-right-div .tab-top .tab-top-item").index(this);
        //$(this).parents(".tab-right-div").find(".tab-main-div").first().show().siblings().hide();
        $(".tab-right-div .tab-main .tab-main-div").eq(num).show().siblings(".tab-right-div .tab-main .tab-main-div").hide();
    });
//    �г�����
    $(".tab-main-div .tab-lab").click(function(){
       var num  = $(".tab-main-div .tab-lab").index(this);
        $(".tab-main-body .tab-body-div").eq(num).show().siblings(".tab-main-body .tab-body-div").hide();
    });
    //����
    laydate.skin('molv');
//    查询项wxy-11-25
//    	每一行的选项超过8个隐藏
	$(".smenu-right").find("span:gt(7)").hide();
//	点击更多现实已经被隐藏的选项，如果收起隐藏超过6个的选项

	$(".smenu-item-more").click(function(){
		if($(this).text()=="更多"){
			$(this).text("收起");
			$(this).prev(".smenu-right").find("span:gt(7)").show();
		}
		else{
			$(this).text("更多");
			$(this).prev(".smenu-right").find("span:gt(7)").hide();
		}
	});
	$(".no-num").click(function(){
		$(this).addClass("item-hover").next().children().removeClass("item-hover");
		$(this).addClass("item-hover").siblings().removeClass("item-hover");
	});
//	点击选项获得里面的内容
	$(".smenu-item").click(function(){
		$(this).addClass("item-hover").siblings().removeClass("item-hover");
		$(this).parent().prev().removeClass("item-hover");
	});
//	国内国际隐藏
	//$(".local-city").hide();
	$(".smenu-nation .item-area").click(function(){
		$(this).parent().prev().removeClass("item-hover");
		$(".smenu-nation span.item-hover").removeClass("item-hover");
		var len = $(".smenu-nation .item-area").index($(this));
		$(this).addClass("item-hover").siblings().removeClass("item-hover");
		$(".nations .local-city").eq(len).show().siblings(".nations .local-city").hide();
	});
	$(".nation-no").click(function(){
		$(".nations").find(".local-city").slideUp();
	});
//	导游的城市，国内全陪是出发地，国内地陪是目的地，国际领队是出发地，国际地陪是目的地
//	$(".guide-nation dl").eq(0).show().nextAll().hide();
//	$(".search-div .lab-radio").click(function(){
//		var index= $(".search-div .lab-radio").index($(this));
//		$(".guide-nation>dl").eq(index).show().siblings(".guide-nation>dl").hide();
//	});
});

