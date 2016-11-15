
$(".leftdiv dt").css({"background": "url('static/images/bg0.gif') repeat-x"});
$(".leftdiv>dl>div>dd>span").css({"background": "url('static/images/houtai5.png') no-repeat","background-position":"left","color":"#fff"});
$(function(){
	$(".leftdiv dd").hide();
	$(".leftdiv dt").click(function(){
		
		$(".leftdiv dt").css({"background": "url('static/images/bg0.gif') repeat-x","color":"#323232"});
		$(this).css({"background": "url('static/images/bg1.gif') repeat-x","color":"#fff"});
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
		
		
    	$(".leftdiv>dl>div>dd>span").css({"background": "url('static/images/houtai5.png') no-repeat","background-position":"left","color":"#fff"});
		$(this).css({"background": "url('static/images/houtai6.png') no-repeat","background-position":"left","color":"#ff9640"});
		
		//更改标题指向
		var html = $(this).attr("parent") + "&nbsp;>&nbsp;" + $(this).text();
		$("#titleSpan").html(html);
		
		//加载路径改变右侧状态
		var url = $(this).attr("text");
		index.load(url);
		page.url = url;
		page.backurl = url;
	});
	/*王赛行程管理添加线路2015年10月08号*/
	$(".newline_ctrlblrs a").live("click",function(){
		var xl_num=$(this).parent().parent().children().length;
		if($(this).text()=="-"){
			$(this).parent().remove();
		}
		if(xl_num>7){
			return ;
		}
		if($(this).text()=="+"){
			var htm = $(this).parents(".newline_ctrlblrs").html();
				htm = htm.replace('+','-');
				htm = '<div class="newline_ctrlblrs">'+htm+'</div>';
			$(this).parent().parent().append(htm);
		}
	});
    $(".mtabtop li").click(function(){
    	var liindex = $('.mtabtop li').index(this);
		$(this).addClass('mtabtopli').siblings().removeClass('mtabtopli');
    	  var index = $(".mtabtop li").index($(this));
        $('.mtabbiger .mtabbox').eq(index).show(0).siblings(".mtabbiger .mtabbox").hide(0);
    });

    /*国际*/
    $("#newfood_in").click(function(){
    	$(".newfood_inter").toggle();
    });
    
	/*签证弹出框*/
	$(".priceadmin").click(function(){
		$(".win_box_edit").show();
		$(".win_box_bg").show();
	});
	$(".win_box_edit .esc_a").click(function() {
		$(".win_box_edit").hide();
		$(".win_box_bg").hide();
	});
	
});
	
	/*火车票全选*/
	$("#checkAllt").click(function() {
	    $('input[name="subBoxt"]').attr("checked",this.checked); 
	});
	var $subBoxt = $("input[name='subBoxt']");
	$subBoxt.click(function(){
	    $("#checkAllt").attr("checked",$subBoxt.length == $("input[name='subBoxt']:checked").length ? true : false);
	});
	$("#checkAllt2").click(function() {
	    $('input[name="subBoxt2"]').attr("checked",this.checked); 
	});
	var $subBoxt2 = $("input[name='subBoxt2']");
	$subBoxt2.click(function(){
	    $("#checkAllt2").attr("checked",$subBoxt2.length == $("input[name='subBoxt2']:checked").length ? true : false);
	});
	$("#checkAllt3").click(function() {
	    $('input[name="subBoxt3"]').attr("checked",this.checked); 
	});
	var $subBoxt3 = $("input[name='subBoxt3']");
	$subBoxt3.click(function(){
	    $("#checkAllt3").attr("checked",$subBoxt3.length == $("input[name='subBoxt3']:checked").length ? true : false);
	});
	$(".trainl_cttop li").click(function(){
		var liindex = $('.trainl_cttop li').index(this);
		$(this).css({"background":"#d09e64"}).siblings().css({"background":"#969696"});
	    $('.trainl_biger .train_box').eq(liindex).show(0).siblings(".trainl_biger .train_box").hide(0);
	});
	
// 火车站常出车次
	$("#hc_zhandian .div_right .add_key_word").live("click",function(){
	    var objn=$("#hc_zhandian .div_right").length;
	    if($(this).text()=="-"){
	        $(this).parent().remove();
	    }
	    if (objn > 3) {
	    	return false;
	    	}
	    if($(this).text()=="+") {
	        $("<div class='div_right'><input type='text' name='ttdStartStation' class='room_num validate[required,maxSize[30]]'/><a href='javascript:void(0)' class='add_key_word'>-</a></div>").appendTo("#hc_zhandian");
	    }
	});
// 产品特色
$("#ldl_eature .newline_ctllr2 .zyjd_add").live("click",function(){
	var zyjd_num=$("#ldl_eature .newline_ctllr2").length;
	if($(this).text()=="-"){
		$(this).parent().remove();
	}
	if(zyjd_num>5){
	return false ;
	}
	if($(this).text()=="+"){
		$("<div class='newline_ctllr2'><input type='text'  style='margin-bottom:0;width:200px;'class='w200 lab_input validate[required,maxSize[20]]' name='ldlFeature' /><span class='mess_star_red'>*</span><a href='javascript:void(0)' class='zyjd_add'>-</a></div>").appendTo("#ldl_eature");
	}
});
/*专线*/
//主要景点增加
$("#zyjd_add .newline_ctllr2 .zyjd_add").live("click",function(){
	var zyjd_num=$("#zyjd_add .newline_ctllr2").length;
	if($(this).text()=="-"){
		$(this).parent().remove();
	}
	if(zyjd_num>21){
	return false ;
	}
	if($(this).text()=="+"){
		$('<div class="newline_ctllr2"><input type="text" name="ldlAttraction" class="validate[required,maxSize[50]]" style="width:165px;"><a href="javascript:void(0)" class="zyjd_add xl_bg_ccc">-</a></div>').appendTo("#zyjd_add");
	}
});

//学生活动增加
$("#student .newline_ctllr2 .a_button").live("click",function(){
	var stu_num = $(this).parent().parent().find(".newline_ctllr2").length;
    if($(this).text()=="-"){
        $(this).parent().remove();
    }
    if (stu_num > 1) {return;}
    if($(this).text()=="+") {
        $(this).parent().after('<div class="newline_ctllr2"  style="text-align:right;"> <input type="text" name="ldlAddgame"  class="validate[maxSize[7]]" style="width:108px;"><a href="javascript:void(0)" class="a_button xl_bg_ccc">-</a></div>');
    }
});
//产品主题增加
$("#ldlprotype .newline_ctllr2 .a_button").live("click",function(){
	  var stu_num = $(this).parent().parent().find(".newline_ctllr2").length;
    if($(this).text()=="-"){
        $(this).parent().remove();
    }
    if (stu_num > 1) {return;}
    if($(this).text()=="+") {
        $(this).parent().after('<div class="newline_ctllr2" style="text-align:right;margin-top:1px;"" ><input type="text" name="ldlProType2"  class="validate[maxSize[6]]" style="width:108px;"><a href="javascript:void(0)" class="a_button xl_bg_ccc">-</a></div>');
    }
});
//线路玩法增加
$("#xl_divadd .newline_ctllr2 .xl_add").live("click",function(){
	var xl_num=$(this).parent().parent().children().length;
	if($(this).text()=="-"){
		$(this).parent().remove();
	}
	if(xl_num>6){
	return ;
	}
	if($(this).text()=="+"){
		$(this).parent().after('<div class="newline_ctllr2"><input type="text" name="gddProductine" class="validate[required,maxSize[50]]" style="width:108px;"><a href="javascript:void(0)" class="xl_add xl_bg_ccc">-</a></div>');
	}
});


var sid = 1000;
//添加国内城市
$(".city_bigbox .city_box .a_add").live('click', function() {
var num = $(this).parent().parent().children().length;
if(num == 11) return;

if ($(this).text() == "+") {
    var tranchtml = $("#div_city_demo").html();
    tranchtml = tranchtml.replace('province1','province'+tranc);
	tranchtml = tranchtml.replace('city1','city'+tranc);
	tranchtml = tranchtml.replace('>+',' style="background:#ccc">-');
//	 $(this).text('-').css("background", "#ccc");
	 
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

//添加国际国家
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
//常出车次
$(".wxy_train_box .wxy_train_boxl a").live('click', function() {
    if ($(this).text() == "+") {
        //提交表单
        //var url = "/transticket/num/insert";
        //var data= $(this).parents("form").serialize()+"&ttdId="+$("#id").val();
        //$.post(url,data,function(){},'json');
        //设置按钮灰显
        //$(this).text('-').css("background", "#ccc");
    	var htm = $("#wxy_train_boxl").html();
    	htm = htm.replace('<a href="javascript:void(0)">+</a>','<a href="javascript:void(0)" style="background:#ccc">-</a>');
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