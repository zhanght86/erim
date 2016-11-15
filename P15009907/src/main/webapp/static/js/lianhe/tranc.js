
$(".nation_box").hide();
$(".inter_box").hide();
//  国内显示隐藏
$(".nation_hide").change(function() {
    $(".nation_box").toggle();
});
//  国际显示隐藏
$(".inter_hide").change(function() {
    $(".inter_box").toggle();
});
var sid = 1000;
//  添加国内城市
$(".city_bigbox .city_box .a_add").live('click', function() {
    if ($(this).text() == "+") {
    	var num = $(this).parent().parent().children().length;
    	if(num == 11) return;
        var tranchtml = $("#div_city_demo").html();
        tranchtml = tranchtml.replace('province1','province'+tranc);
    	tranchtml = tranchtml.replace('city1','city'+tranc);
    	tranchtml = tranchtml.replace('>+',' style="background:#ccc">-');
//    	 $(this).text('-').css("background", "#ccc");
    	 
    	var html = '<div class="city_box mt15">'+tranchtml+'</div>';
        $(this).parent().after(html);
        //初始化省市县
    	index.initProvinceByCity(110000,'province'+tranc,'city'+tranc);
        //$(this).parent().after('<div class="city_box mt15"><input type="text" style="width:230px;" groupId="'+groupId+'" sid="'+sid+'" value="" name="ttdEndStatcion" class="room_num validate[maxSize[200]]"><a href="javascript:void(0)" class="a_add">+</a></div>')
        //$("#coment").append('<span groupId="'+groupId+'" sid="'+sid+'" class="nation_item"></span>');
        tranc++;
    } else {
    	//var id = $(this).parent().find("input").attr("sid");
        $(this).parent().remove();
    }
});

//  添加国际国家
$(".nation_smallbox .city_box .a_add").live('click', function() {
    if ($(this).text() == "+") {
    	var num = $(this).parent().parent().children().length;
	    if(num==3) return;
    	var tranchtml = $("#div_country_demo").html();
    	tranchtml = tranchtml.replace('>+',' style="background:#ccc">-');
    	var html = '<div class="city_box mt15">'+tranchtml+'</div>';
        $(this).parent().after(html);
        //$(this).text('-').css("background", "#ccc");
        //$(this).parent().after('<div class="city_box mt15"><input type="text" style="width:230px;" groupId="'+groupId+'" sid="'+sid+'" value="" name="ttdEndStatcion" class="room_num validate[maxSize[200]]"><a href="javascript:void(0)" class="a_add">+</a></div>')
        //$("#coment").append('<span groupId="'+groupId+'" sid="'+sid+'" class="nation_item"></span>');
        //sid++;
    } else {
    	//var id = $(this).parent().find("input").attr("sid");
        //$("span[groupId="+groupId+"][sid="+id+"]").remove();
        $(this).parent().remove();
    }
});
//  常出车次
$(".wxy_train_box .wxy_train_boxl a").live('click', function() {
    if ($(this).text() == "+") {
        //提交表单
        //var url = "/transticket/num/insert";
        //var data= $(this).parents("form").serialize()+"&ttdId="+$("#id").val();
        //$.post(url,data,function(){},'json');
        //设置按钮灰显
        //$(this).text('-').css("background", "#ccc");
    	var htm = $("#wxy_train_boxl").html();
    	htm = htm.replace('>+',' style="background:#ccc">-');
    	htm = '<div class="wxy_train_boxl">'+htm+'</div>';
        $(".wxy_train_box").append(htm);
    } else {
        var id = $(this).parents(".wxy_train_boxl").find("input[name='tdlid']").val();
        if(id != undefined){
            var url = "/transticket/num/delete?id="+id;
            $.post(url,function(){},'json');
        }
        $(this).parent().remove();
    }
}); 